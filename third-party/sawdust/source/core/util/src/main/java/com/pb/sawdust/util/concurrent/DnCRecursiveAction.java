package com.pb.sawdust.util.concurrent;

import com.pb.sawdust.util.exceptions.RuntimeInterruptedException;
import com.pb.sawdust.util.exceptions.RuntimeWrappingException;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * The {@code DnCRecursiveAction} provides a framework for "divide-and-conquer" {@code RecursiveAction}s. A divide-and-conquer
 * action is recursively split in half as seperate actions (within a {@code ForkJoinPool}) until some criterion is
 * reached, at which point the sub-actions are executed. The criterion should generally use the static
 * {@code getSurplusQueuedTaskCount()} method inherited from the {@code RecursiveTask} class.
 * <p>
 * In order to work correctly, the two constructors in this class must be used in a specific manner.  The constructor
 * taking two {@code long} arguments is intended for use as the (super) constructor of the instance passed to the
 * {@code ForkJoinPool}. The other constructor should be invoked (through super calls) in the implementation of the
 * {@link #getNextAction(long, long, DnCRecursiveAction)} method.
 * <p>
 * To make this more concrete, the following presents an example implementation for an action which takes an array
 * of doubles and replaces it with the squares of the array values.
 *
 * <pre><code>
 *     public class ArraySquarer extends DnCRecursiveAction {
 *         private final double[] array;
 *
 *         public ArraySquarer(double[] array) {
 *             super(0,array.length);
 *             this.array = array;
 *         }
 *
 *         private ArraySquarer(double[] array, long start, long length, DnCRecursiveAction next) {
 *             super(start,length,next);
 *             this.array = array;
 *         }
 *
 *         protected void computeAction(long start, long length) {
 *             long end = start + length;
 *             for (long i = start; i < end; i++)
 *                 array[i] = array[i]*array[i];
 *         }
 *
 *         protected DnCRecursiveAction getNextAction(long start, long length, DnCRecursiveAction next) {
 *             return new ArraySquarer(array,start,length,next);
 *         }
 *
 *         protected boolean continueDividing(long newLength) {
 *             return getSurplusQueuedTaskCount() < 3;
 *         }
 *     }
 * </code></pre>
 *
 * @author crf <br/>
 *         Started: Aug 11, 2009 8:41:10 AM
 */
public abstract class DnCRecursiveAction extends RecursiveAction {
    private final long start;
    private long length;
    private final DnCRecursiveAction next;

    /**
     * Conatructor for sub-actions. This should be called for constructing the object returned by
     * {@link #getNextAction(long, long, DnCRecursiveAction)}.
     *
     * @param start
     *        The starting point of the action.
     *
     * @param length
     *        The length of the action.
     *
     * @param next
     *        The next action.
     */
    protected DnCRecursiveAction(long start, long length, DnCRecursiveAction next) {
        this.start = start;
        this.length = length;
        this.next = next;
    }

    /**
     * Constructor for the main action passed to the {@code ForkJoinPool}.
     *
     * @param start
     *        The starting point of the action.
     *
     * @param length
     *        The length of the action.
     */
    protected DnCRecursiveAction(long start, long length) {
        this(start,length,null);
    }

    /**
     * Compute the action. This method should perform whatever tasks are needed for the points on <code>[start,start+length)</code>.
     *
     * @param start
     *        The starting point of the action.
     *
     * @param length
     *        The length of the action.
     */
    abstract protected void computeAction(long start, long length);

    /**
     * Get the next (sub-)action resulting from a division. This method should return an instance of the subclass which
     * uses the {@link #DnCRecursiveAction(long, long, DnCRecursiveAction)} constructor as its {@code super}.
     *
     * @param start
     *        The starting point of the action.
     *
     * @param length
     *        The length of the action.
     *
     * @param next
     *        The next action.
     *
     * @return the next sub-action.
     */
    abstract protected DnCRecursiveAction getNextAction(long start, long length, DnCRecursiveAction next);

    /**
     * Determine whether the action should continue to divide or, instead, perform its computations. This method should,
     * at least, make use of the static {@code getSurplusQueuedTaskCount()} method inherited from the {@code RecursiveTask} class,
     * the result of which should generally be kept above 3 to maintain high concurrency.
     *
     * @param length
     *        The length of the action.
     *
     * @return {@code true} if it should continue dividing, {@code false} if it should perform its computations.
     */
    abstract protected boolean continueDividing(long length);

    protected void compute() {
        long newLength = length;
        DnCRecursiveAction b = null;
        while (continueDividing(newLength)) {
            newLength = newLength >>> 1; //divide by dos
            if (newLength == length) //newLength < 2
                break;
            b = getNextAction(start+newLength,length-newLength,b);
            b.fork();
            length = newLength;
        }
        try {
            computeAction(start,length);
        } catch (RuntimeException | Error e) {
            completeExceptionally(e);
        }
        while (b != null) {
            if (b.tryUnfork())
                b.compute();
            else
                b.join();
            b = b.next;
        }
    }

    /**
     * This method is the same as {@code get()}, except it wraps the declared exceptions in runtime exceptions.
     *
     * @return the result of {@code get()}.
     *
     * @throws RuntimeInterruptedException in place of {@code InterruptedException}.
     * @throws RuntimeWrappingException wrapping a thrown {@code ExecutionException}.
     */
    public Void getResult() {
        try {
            return get();
        } catch (InterruptedException e) {
            throw new RuntimeInterruptedException(e);
        } catch (ExecutionException e) {
            throw new RuntimeWrappingException(e);
        }
    }

    /**
     * This method is the same as {@code get(long,TimeUnit)}, except it wraps the declared exceptions in runtime exceptions.
     *
     * @param timeout
     *        The length of time to wait for the method to return.
     *
     * @param timeUnit
     *        The units for {@code timeout}.
     *
     * @return the result of {@code get(timeout,timeUnit)}.
     *
     * @throws com.pb.sawdust.util.exceptions.RuntimeInterruptedException in place of {@code InterruptedException}.
     * @throws RuntimeWrappingException wrapping a thrown {@code ExecutionException} or {@code TimeoutException}}.
     */
    public Void getResult(long timeout, TimeUnit timeUnit) {
        try {
            return get(timeout,timeUnit);
        } catch (InterruptedException e) {
            throw new RuntimeInterruptedException(e);
        } catch (ExecutionException | TimeoutException e) {
            throw new RuntimeWrappingException(e);
        }
    }
}