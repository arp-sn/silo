package com.pb.sawdust.tensor;

import com.pb.sawdust.tensor.alias.matrix.Matrix;
import com.pb.sawdust.tensor.alias.matrix.primitive.*;
import com.pb.sawdust.tensor.alias.vector.primitive.*;
import com.pb.sawdust.tensor.decorators.id.IdTensor;
import com.pb.sawdust.tensor.decorators.primitive.*;
import com.pb.sawdust.tensor.decorators.id.primitive.*;
import com.pb.sawdust.tensor.factory.TensorFactory;
import com.pb.sawdust.tensor.index.*;
import com.pb.sawdust.util.JavaType;
import com.pb.sawdust.util.MathUtil;
import com.pb.sawdust.util.array.*;
import com.pb.sawdust.util.format.TextFormat;
import com.pb.sawdust.util.abacus.IterableAbacus;
import com.pb.sawdust.util.abacus.Abacus;
import static com.pb.sawdust.util.Range.*;
import com.pb.sawdust.util.concurrent.DnCRecursiveAction;
import com.pb.sawdust.util.concurrent.ForkJoinPoolFactory;

import java.util.*;

/**
 * The {@code TensorUtil} class provides a variety of convenience and utility methods for working with tensors.
 * 
 * @author crf <br/>
 *         Started: Jan 21, 2009 8:05:46 PM
 */
public class TensorUtil {

    private TensorUtil(){}
    
    //////////////////////unmodifiable tensor///////////////////////////////

    /**
     * Get an unmodifiable reference to a tensor. Though the returned tensor cannot be modified (mutating methods will
     * throw exceptions), the source tensor may be modifiable, and any changes to it will be reflected in the tensor
     * returned by this method.
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @param <T>
     *        The type held by the tensors.
     *        
     * @return an unmodifiable reference to {@code tensor}.
     */
    public static <T> Tensor<T> unmodifiableTensor(Tensor<T> tensor) {
        return UnmodifiableTensor.unmodifiableTensor(tensor);
    }

    /**
     * Get an unmodifiable reference to a tensor holding {@code byte}s. Though the returned tensor cannot be modified (mutating 
     * methods will throw exceptions), the source tensor may be modifiable, and any changes to it will be reflected in the 
     * tensor returned by this method.
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @return an unmodifiable reference to {@code tensor}.
     */
    public static ByteTensor unmodifiableTensor(ByteTensor tensor) {
        return UnmodifiableTensor.unmodifiableTensor(tensor);
    }

    /**
     * Get an unmodifiable reference to a tensor holding {@code short}s. Though the returned tensor cannot be modified (mutating 
     * methods will throw exceptions), the source tensor may be modifiable, and any changes to it will be reflected in the 
     * tensor returned by this method.
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @return an unmodifiable reference to {@code tensor}.
     */
    public static ShortTensor unmodifiableTensor(ShortTensor tensor) {
        return UnmodifiableTensor.unmodifiableTensor(tensor);
    }

    /**
     * Get an unmodifiable reference to a tensor holding {@code int}s. Though the returned tensor cannot be modified (mutating 
     * methods will throw exceptions), the source tensor may be modifiable, and any changes to it will be reflected in the 
     * tensor returned by this method.
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @return an unmodifiable reference to {@code tensor}.
     */
    public static IntTensor unmodifiableTensor(IntTensor tensor) {
        return UnmodifiableTensor.unmodifiableTensor(tensor);
    }

    /**
     * Get an unmodifiable reference to a tensor holding {@code long}s. Though the returned tensor cannot be modified (mutating 
     * methods will throw exceptions), the source tensor may be modifiable, and any changes to it will be reflected in the 
     * tensor returned by this method.
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @return an unmodifiable reference to {@code tensor}.
     */
    public static LongTensor unmodifiableTensor(LongTensor tensor) {
        return UnmodifiableTensor.unmodifiableTensor(tensor);
    }

    /**
     * Get an unmodifiable reference to a tensor holding {@code float}s. Though the returned tensor cannot be modified (mutating 
     * methods will throw exceptions), the source tensor may be modifiable, and any changes to it will be reflected in the 
     * tensor returned by this method.
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @return an unmodifiable reference to {@code tensor}.
     */
    public static FloatTensor unmodifiableTensor(FloatTensor tensor) {
        return UnmodifiableTensor.unmodifiableTensor(tensor);
    }

    /**
     * Get an unmodifiable reference to a tensor holding {@code double}s. Though the returned tensor cannot be modified (mutating 
     * methods will throw exceptions), the source tensor may be modifiable, and any changes to it will be reflected in the 
     * tensor returned by this method.
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @return an unmodifiable reference to {@code tensor}.
     */
    public static DoubleTensor unmodifiableTensor(DoubleTensor tensor) {
        return UnmodifiableTensor.unmodifiableTensor(tensor);
    }

    /**
     * Get an unmodifiable reference to a tensor holding {@code boolean}s. Though the returned tensor cannot be modified (mutating 
     * methods will throw exceptions), the source tensor may be modifiable, and any changes to it will be reflected in the 
     * tensor returned by this method.
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @return an unmodifiable reference to {@code tensor}.
     */
    public static BooleanTensor unmodifiableTensor(BooleanTensor tensor) {
        return UnmodifiableTensor.unmodifiableTensor(tensor);
    }

    /**
     * Get an unmodifiable reference to a tensor holding {@code char}s. Though the returned tensor cannot be modified (mutating 
     * methods will throw exceptions), the source tensor may be modifiable, and any changes to it will be reflected in the 
     * tensor returned by this method.
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @return an unmodifiable reference to {@code tensor}.
     */
    public static CharTensor unmodifiableTensor(CharTensor tensor) {
        return UnmodifiableTensor.unmodifiableTensor(tensor);
    }
    /**
     * Get an unmodifiable reference to an id tensor. Though the returned tensor cannot be modified (mutating methods will
     * throw exceptions), the source tensor may be modifiable, and any changes to it will be reflected in the tensor
     * returned by this method.
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @param <T>
     *        The type held by the tensors.
     *        
     * @param <I>
     *        The type of the tensors's ids.
     *        
     * @return an unmodifiable reference to {@code tensor}.
     */
    public static <T,I> IdTensor<T,I> unmodifiableTensor(IdTensor<T,I> tensor) {
        return UnmodifiableTensor.unmodifiableTensor(tensor);
    }                                                                                                                       

    /**
     * Get an unmodifiable reference to an id tensor holding {@code byte}s. Though the returned tensor cannot be modified (mutating 
     * methods will throw exceptions), the source tensor may be modifiable, and any changes to it will be reflected in the 
     * tensor returned by this method.
     * 
     * @param tensor
     *        The source tensor.            
     *        
     * @param <I>
     *        The type of the tensors's ids.
     *        
     * @return an unmodifiable reference to {@code tensor}.
     */
    public static <I> IdByteTensor<I> unmodifiableTensor(IdByteTensor<I> tensor) {
        return UnmodifiableTensor.unmodifiableByteTensor(tensor);
    }

    /**
     * Get an unmodifiable reference to an id tensor holding {@code short}s. Though the returned tensor cannot be modified (mutating 
     * methods will throw exceptions), the source tensor may be modifiable, and any changes to it will be reflected in the 
     * tensor returned by this method.
     * 
     * @param tensor
     *        The source tensor.            
     *        
     * @param <I>
     *        The type of the tensors's ids.
     *        
     * @return an unmodifiable reference to {@code tensor}.
     */
    public static <I> IdShortTensor<I> unmodifiableTensor(IdShortTensor<I> tensor) {
        return UnmodifiableTensor.unmodifiableShortTensor(tensor);
    }

    /**
     * Get an unmodifiable reference to an id tensor holding {@code int}s. Though the returned tensor cannot be modified (mutating 
     * methods will throw exceptions), the source tensor may be modifiable, and any changes to it will be reflected in the 
     * tensor returned by this method.
     * 
     * @param tensor
     *        The source tensor.            
     *        
     * @param <I>
     *        The type of the tensors's ids.
     *        
     * @return an unmodifiable reference to {@code tensor}.
     */
    public static <I> IdIntTensor<I> unmodifiableTensor(IdIntTensor<I> tensor) {
        return UnmodifiableTensor.unmodifiableIntTensor(tensor);
    }

    /**
     * Get an unmodifiable reference to an id tensor holding {@code long}s. Though the returned tensor cannot be modified (mutating 
     * methods will throw exceptions), the source tensor may be modifiable, and any changes to it will be reflected in the 
     * tensor returned by this method.
     * 
     * @param tensor
     *        The source tensor.            
     *        
     * @param <I>
     *        The type of the tensors's ids.
     *        
     * @return an unmodifiable reference to {@code tensor}.
     */
    public static <I> IdLongTensor<I> unmodifiableTensor(IdLongTensor<I> tensor) {
        return UnmodifiableTensor.unmodifiableLongTensor(tensor);
    }

    /**
     * Get an unmodifiable reference to an id tensor holding {@code float}s. Though the returned tensor cannot be modified (mutating 
     * methods will throw exceptions), the source tensor may be modifiable, and any changes to it will be reflected in the 
     * tensor returned by this method.
     * 
     * @param tensor
     *        The source tensor.            
     *        
     * @param <I>
     *        The type of the tensors's ids.
     *        
     * @return an unmodifiable reference to {@code tensor}.
     */
    public static <I> IdFloatTensor<I> unmodifiableTensor(IdFloatTensor<I> tensor) {
        return UnmodifiableTensor.unmodifiableFloatTensor(tensor);
    }

    /**
     * Get an unmodifiable reference to an id tensor holding {@code double}s. Though the returned tensor cannot be modified (mutating 
     * methods will throw exceptions), the source tensor may be modifiable, and any changes to it will be reflected in the 
     * tensor returned by this method.
     * 
     * @param tensor
     *        The source tensor.            
     *        
     * @param <I>
     *        The type of the tensors's ids.
     *        
     * @return an unmodifiable reference to {@code tensor}.
     */
    public static <I> IdDoubleTensor<I> unmodifiableTensor(IdDoubleTensor<I> tensor) {
        return UnmodifiableTensor.unmodifiableDoubleTensor(tensor);
    }

    /**
     * Get an unmodifiable reference to an id tensor holding {@code boolean}s. Though the returned tensor cannot be modified (mutating 
     * methods will throw exceptions), the source tensor may be modifiable, and any changes to it will be reflected in the 
     * tensor returned by this method.
     * 
     * @param tensor
     *        The source tensor.            
     *        
     * @param <I>
     *        The type of the tensors's ids.
     *        
     * @return an unmodifiable reference to {@code tensor}.
     */
    public static <I> IdBooleanTensor<I> unmodifiableTensor(IdBooleanTensor<I> tensor) {
        return UnmodifiableTensor.unmodifiableBooleanTensor(tensor);
    }

    /**
     * Get an unmodifiable reference to an id tensor holding {@code char}s. Though the returned tensor cannot be modified (mutating 
     * methods will throw exceptions), the source tensor may be modifiable, and any changes to it will be reflected in the 
     * tensor returned by this method.
     * 
     * @param tensor
     *        The source tensor.            
     *        
     * @param <I>
     *        The type of the tensors's ids.
     *        
     * @return an unmodifiable reference to {@code tensor}.
     */
    public static <I> IdCharTensor<I> unmodifiableTensor(IdCharTensor<I> tensor) {
        return UnmodifiableTensor.unmodifiableCharTensor(tensor);
    }

    /////////////////////fill functions///////////////////////////////////////
    private static final long FILL_ACTION_PARALLEL_SIZE_LIMIT = 5000L;
    private static final int FILL_ACTION_PARALLELISM = Runtime.getRuntime().availableProcessors();

    /**
     * The {@code TensorValueFunction} interface provides a structure for specifying the value of a tensor at a given
     * index. It is intended to be used for tensor filling operations.
     * 
     * @param <T>
     *        The type the value function returns.
     */
    public static interface TensorValueFunction<T> {
        /**
         * Get the value at the specified index location. This method will often be called in a concurrent (multi-threaded)
         * environment, so each call to this method should be independent of any others.
         * 
         * @param indices
         *        The index location.
         * 
         * @return the value at {@code indices}.
         */
        T getValue(int ... indices);
    }

    /**
     * Fill a tensor.
     * 
     * @param tensor
     *        The tensor to fill.
     *        
     * @param function
     *        The function specifying the values the tensor will be filled with.
     *        
     * @param <T>
     *        The type held by the tensor.
     */
    public static <T> void fill(Tensor<T> tensor, TensorValueFunction<T> function) {
        long size = getElementCount(tensor);
        if (size == 1 && tensor.size() == 0)
            tensor.setValue(function.getValue(new int[0]));
        else if (size > FILL_ACTION_PARALLEL_SIZE_LIMIT)
            ForkJoinPoolFactory.getForkJoinPool(FILL_ACTION_PARALLELISM).invoke(new ObjectTensorFillAction<T>(tensor,function,size));
        else
            for (int[] indices : IterableAbacus.getIterableAbacus(tensor.getDimensions()))
                tensor.setValue(function.getValue(indices),indices);
    }

    /**
     * Fill a tensor with a single value.
     * 
     * @param tensor
     *        The tensor to fill.
     *        
     * @param value
     *        The value to fill the tensor with.                                
     *        
     * @param <T>
     *        The type held by the tensor.
     */
    public static <T> void fill(Tensor<T> tensor, final T value) {
        fill(tensor,new TensorValueFunction<T>() {
                public T getValue(int ... indices) {
                    return value;
                }
            });
    }

    /**
     * The {@code ByteTensorValueFunction} interface provides a structure for specifying the value of a tensor holding
     * {@code byte}s at a given index. It is intended to be used for tensor filling operations.
     */
    public static interface ByteTensorValueFunction {
        /**
         * Get the value at the specified index location. This method will often be called in a concurrent (multi-threaded)
         * environment, so each call to this method should be independent of any others.
         * 
         * @param indices
         *        The index location.
         * 
         * @return the value at {@code indices}.
         */
        byte getValue(int ... indices);
    }

    /**
     * Fill a tensor holding {@code byte}s.
     * 
     * @param tensor
     *        The tensor to fill.
     *        
     * @param function
     *        The function specifying the values the tensor will be filled with.
     */
    public static void fill(ByteTensor tensor, ByteTensorValueFunction function) {
        long size = getElementCount(tensor);
        if (size == 1 && tensor.size() == 0)
            tensor.setCell(function.getValue(new int[0]));
        else if (size > FILL_ACTION_PARALLEL_SIZE_LIMIT)
            ForkJoinPoolFactory.getForkJoinPool(FILL_ACTION_PARALLELISM).invoke(new ByteTensorFillAction(tensor,function,size));
        else
            for (int[] indices : IterableAbacus.getIterableAbacus(tensor.getDimensions()))
                tensor.setCell(function.getValue(indices),indices);
    }

    /**
     * Fill a tensor holding {@code byte}s with a single value.
     * 
     * @param tensor
     *        The tensor to fill.
     *        
     * @param value
     *        The value to fill the tensor with.
     */
    public static void fill(ByteTensor tensor, final byte value) {
        fill(tensor,new ByteTensorValueFunction() {
                public byte getValue(int ... indices) {
                    return value;
                }
            });
    }

    /**
     * The {@code ShortTensorValueFunction} interface provides a structure for specifying the value of a tensor holding
     * {@code short}s at a given index. It is intended to be used for tensor filling operations.
     */
    public static interface ShortTensorValueFunction {
        /**
         * Get the value at the specified index location. This method will often be called in a concurrent (multi-threaded)
         * environment, so each call to this method should be independent of any others.
         * 
         * @param indices
         *        The index location.
         * 
         * @return the value at {@code indices}.
         */
        short getValue(int ... indices);
    }

    /**
     * Fill a tensor holding {@code short}s.
     * 
     * @param tensor
     *        The tensor to fill.
     *        
     * @param function
     *        The function specifying the values the tensor will be filled with.
     */
    public static void fill(ShortTensor tensor, ShortTensorValueFunction function) {
        long size = getElementCount(tensor);
        if (size == 1 && tensor.size() == 0)
            tensor.setCell(function.getValue(new int[0]));
        else if (size > FILL_ACTION_PARALLEL_SIZE_LIMIT)
            ForkJoinPoolFactory.getForkJoinPool(FILL_ACTION_PARALLELISM).invoke(new ShortTensorFillAction(tensor,function,size));
        else
            for (int[] indices : IterableAbacus.getIterableAbacus(tensor.getDimensions()))
                tensor.setCell(function.getValue(indices),indices);
    }

    /**
     * Fill a tensor holding {@code short}s with a single value.
     * 
     * @param tensor
     *        The tensor to fill.
     *        
     * @param value
     *        The value to fill the tensor with.
     */
    public static void fill(ShortTensor tensor, final short value) {
        fill(tensor,new ShortTensorValueFunction() {
                public short getValue(int ... indices) {
                    return value;
                }
            });
    }
       
    /**
     * The {@code IntTensorValueFunction} interface provides a structure for specifying the value of a tensor holding
     * {@code int}s at a given index. It is intended to be used for tensor filling operations.
     */
    public static interface IntTensorValueFunction {
        /**
         * Get the value at the specified index location. This method will often be called in a concurrent (multi-threaded)
         * environment, so each call to this method should be independent of any others.
         * 
         * @param indices
         *        The index location.
         * 
         * @return the value at {@code indices}.
         */
        int getValue(int ... indices);
    }

    /**
     * Fill a tensor holding {@code int}s.
     * 
     * @param tensor
     *        The tensor to fill.
     *        
     * @param function
     *        The function specifying the values the tensor will be filled with.
     */
    public static void fill(IntTensor tensor, IntTensorValueFunction function) {
        long size = getElementCount(tensor);
        if (size == 1 && tensor.size() == 0)
            tensor.setCell(function.getValue(new int[0]));
        else if (size > FILL_ACTION_PARALLEL_SIZE_LIMIT)
            ForkJoinPoolFactory.getForkJoinPool(FILL_ACTION_PARALLELISM).invoke(new IntTensorFillAction(tensor,function,size));
        else
            for (int[] indices : IterableAbacus.getIterableAbacus(tensor.getDimensions()))
                tensor.setCell(function.getValue(indices),indices);
    }

    /**
     * Fill a tensor holding {@code int}s with a single value.
     * 
     * @param tensor
     *        The tensor to fill.
     *        
     * @param value
     *        The value to fill the tensor with.
     */
    public static void fill(IntTensor tensor, final int value) {
        fill(tensor,new IntTensorValueFunction() {
                public int getValue(int ... indices) {
                    return value;
                }
            });
    }

    /**
     * The {@code LongTensorValueFunction} interface provides a structure for specifying the value of a tensor holding
     * {@code long}s at a given index. It is intended to be used for tensor filling operations.
     */
    public static interface LongTensorValueFunction {
        /**
         * Get the value at the specified index location. This method will often be called in a concurrent (multi-threaded)
         * environment, so each call to this method should be independent of any others.
         * 
         * @param indices
         *        The index location.
         * 
         * @return the value at {@code indices}.
         */
        long getValue(int ... indices);
    }

    /**
     * Fill a tensor holding {@code long}s.
     * 
     * @param tensor
     *        The tensor to fill.
     *        
     * @param function
     *        The function specifying the values the tensor will be filled with.
     */
    public static void fill(LongTensor tensor, LongTensorValueFunction function) {
        long size = getElementCount(tensor);
        if (size == 1 && tensor.size() == 0)
            tensor.setCell(function.getValue(new int[0]));
        else if (size > FILL_ACTION_PARALLEL_SIZE_LIMIT)
            ForkJoinPoolFactory.getForkJoinPool(FILL_ACTION_PARALLELISM).invoke(new LongTensorFillAction(tensor,function,size));
        else
            for (int[] indices : IterableAbacus.getIterableAbacus(tensor.getDimensions()))
                tensor.setCell(function.getValue(indices),indices);
    }

    /**
     * Fill a tensor holding {@code long}s with a single value.
     * 
     * @param tensor
     *        The tensor to fill.
     *        
     * @param value
     *        The value to fill the tensor with.
     */
    public static void fill(LongTensor tensor, final long value) {
        fill(tensor,new LongTensorValueFunction() {
                public long getValue(int ... indices) {
                    return value;
                }
            });
    }

    /**
     * The {@code FloatTensorValueFunction} interface provides a structure for specifying the value of a tensor holding
     * {@code float}s at a given index. It is intended to be used for tensor filling operations.
     */
    public static interface FloatTensorValueFunction {
        /**
         * Get the value at the specified index location. This method will often be called in a concurrent (multi-threaded)
         * environment, so each call to this method should be independent of any others.
         * 
         * @param indices
         *        The index location.
         * 
         * @return the value at {@code indices}.
         */
        float getValue(int ... indices);
    }

    /**
     * Fill a tensor holding {@code float}s.
     * 
     * @param tensor
     *        The tensor to fill.
     *        
     * @param function
     *        The function specifying the values the tensor will be filled with.
     */
    public static void fill(FloatTensor tensor, FloatTensorValueFunction function) {
        long size = getElementCount(tensor);
        if (size == 1 && tensor.size() == 0)
            tensor.setCell(function.getValue(new int[0]));
        else if (size > FILL_ACTION_PARALLEL_SIZE_LIMIT)
            ForkJoinPoolFactory.getForkJoinPool(FILL_ACTION_PARALLELISM).invoke(new FloatTensorFillAction(tensor,function,size));
        else
            for (int[] indices : IterableAbacus.getIterableAbacus(tensor.getDimensions()))
                tensor.setCell(function.getValue(indices),indices);
    }

    /**
     * Fill a tensor holding {@code float}s with a single value.
     * 
     * @param tensor
     *        The tensor to fill.
     *        
     * @param value
     *        The value to fill the tensor with.
     */
    public static void fill(FloatTensor tensor, final float value) {
        fill(tensor,new FloatTensorValueFunction() {
                public float getValue(int ... indices) {
                    return value;
                }
            });
    }

    /**
     * The {@code DoubleTensorValueFunction} interface provides a structure for specifying the value of a tensor holding
     * {@code double}s at a given index. It is intended to be used for tensor filling operations.
     */
    public static interface DoubleTensorValueFunction {
        /**
         * Get the value at the specified index location. This method will often be called in a concurrent (multi-threaded)
         * environment, so each call to this method should be independent of any others.
         * 
         * @param indices
         *        The index location.
         * 
         * @return the value at {@code indices}.
         */
        double getValue(int ... indices);
    }

    /**
     * Fill a tensor holding {@code double}s.
     * 
     * @param tensor
     *        The tensor to fill.
     *        
     * @param function
     *        The function specifying the values the tensor will be filled with.
     */
    public static void fill(DoubleTensor tensor, DoubleTensorValueFunction function) {
        long size = getElementCount(tensor);
        if (size == 1 && tensor.size() == 0)
            tensor.setCell(function.getValue(new int[0]));
        else if (size > FILL_ACTION_PARALLEL_SIZE_LIMIT)
            ForkJoinPoolFactory.getForkJoinPool(FILL_ACTION_PARALLELISM).invoke(new DoubleTensorFillAction(tensor,function,size));
        else
            for (int[] indices : IterableAbacus.getIterableAbacus(tensor.getDimensions()))
                tensor.setCell(function.getValue(indices),indices);
    }

    /**
     * Fill a tensor holding {@code double}s with a single value.
     * 
     * @param tensor
     *        The tensor to fill.
     *        
     * @param value
     *        The value to fill the tensor with.
     */
    public static void fill(DoubleTensor tensor, final double value) {
        fill(tensor,new DoubleTensorValueFunction() {
                public double getValue(int ... indices) {
                    return value;
                }
            });
    }

    /**
     * The {@code BooleanTensorValueFunction} interface provides a structure for specifying the value of a tensor holding
     * {@code boolean}s at a given index. It is intended to be used for tensor filling operations.
     */
    public static interface BooleanTensorValueFunction {
        /**
         * Get the value at the specified index location. This method will often be called in a concurrent (multi-threaded)
         * environment, so each call to this method should be independent of any others.
         * 
         * @param indices
         *        The index location.
         * 
         * @return the value at {@code indices}.
         */
        boolean getValue(int ... indices);
    }

    /**
     * Fill a tensor holding {@code boolean}s.
     * 
     * @param tensor
     *        The tensor to fill.
     *        
     * @param function
     *        The function specifying the values the tensor will be filled with.
     */
    public static void fill(BooleanTensor tensor, BooleanTensorValueFunction function) {
        long size = getElementCount(tensor);
        if (size == 1 && tensor.size() == 0)
            tensor.setCell(function.getValue(new int[0]));
        else if (size > FILL_ACTION_PARALLEL_SIZE_LIMIT)
            ForkJoinPoolFactory.getForkJoinPool(FILL_ACTION_PARALLELISM).invoke(new BooleanTensorFillAction(tensor,function,size));
        else
            for (int[] indices : IterableAbacus.getIterableAbacus(tensor.getDimensions()))
                tensor.setCell(function.getValue(indices),indices);
    }

    /**
     * Fill a tensor holding {@code boolean}s with a single value.
     * 
     * @param tensor
     *        The tensor to fill.
     *        
     * @param value
     *        The value to fill the tensor with.
     */
    public static void fill(BooleanTensor tensor, final boolean value) {
        fill(tensor,new BooleanTensorValueFunction() {
                public boolean getValue(int ... indices) {
                    return value;
                }
            });
    }

    /**
     * The {@code CharTensorValueFunction} interface provides a structure for specifying the value of a tensor holding
     * {@code char}s at a given index. It is intended to be used for tensor filling operations.
     */
    public static interface CharTensorValueFunction {
        /**
         * Get the value at the specified index location. This method will often be called in a concurrent (multi-threaded)
         * environment, so each call to this method should be independent of any others.
         * 
         * @param indices
         *        The index location.
         * 
         * @return the value at {@code indices}.
         */
        char getValue(int ... indices);
    }

    /**
     * Fill a tensor holding {@code char}s.
     * 
     * @param tensor
     *        The tensor to fill.
     *        
     * @param function
     *        The function specifying the values the tensor will be filled with.
     */
    public static void fill(CharTensor tensor, CharTensorValueFunction function) {
        long size = getElementCount(tensor);
        if (size == 1 && tensor.size() == 0)
            tensor.setCell(function.getValue(new int[0]));
        else if (size > FILL_ACTION_PARALLEL_SIZE_LIMIT)
            ForkJoinPoolFactory.getForkJoinPool(FILL_ACTION_PARALLELISM).invoke(new CharTensorFillAction(tensor,function,size));
        else
            for (int[] indices : IterableAbacus.getIterableAbacus(tensor.getDimensions()))
                tensor.setCell(function.getValue(indices),indices);
    }

    /**
     * Fill a tensor holding {@code char}s with a single value.
     * 
     * @param tensor
     *        The tensor to fill.
     *        
     * @param value
     *        The value to fill the tensor with.
     */
    public static void fill(CharTensor tensor, final char value) {
        fill(tensor,new CharTensorValueFunction() {
                public char getValue(int ... indices) {
                    return value;
                }
            });
    }

    private abstract static class TensorFillAction extends DnCRecursiveAction {
        final Abacus abacus;

        private TensorFillAction(Abacus abacus, long start, long length, DnCRecursiveAction next) {
            super(start,length,next);
            this.abacus = abacus.freshClone();
        }

        private TensorFillAction(Tensor tensor, long size) {
            super(0,size);
            abacus = new Abacus(tensor.getDimensions());
        }

        abstract protected void setValueAction(int[] indices);

        @Override
        protected void computeAction(long position, long length) {
            abacus.setAbacusAtPosition(position);
            while (length > 0) {
                setValueAction(abacus.next());
                length--;
            }
        }

        @Override
        protected boolean continueDividing(long newLength) {
            return newLength > FILL_ACTION_PARALLEL_SIZE_LIMIT && getSurplusQueuedTaskCount() <= 3;
        }
    }

    private static class ObjectTensorFillAction<T> extends TensorFillAction {
        private static final long serialVersionUID = 6627878158679982653L;

        private final Tensor<T> tensor;
        private final TensorValueFunction<T> function;

        private ObjectTensorFillAction(Abacus abacus, Tensor<T> tensor, TensorValueFunction<T> function, long start, long length, DnCRecursiveAction next) {
            super(abacus,start,length,next);
            this.tensor = tensor;
            this.function = function;
        }

        private ObjectTensorFillAction(Tensor<T> tensor, TensorValueFunction<T> function, long size) {
            super(tensor,size);
            this.tensor = tensor;
            this.function = function;
        }

        protected void setValueAction(int[] indices) {
            tensor.setValue(function.getValue(indices),indices);
        }

        @Override
        protected DnCRecursiveAction getNextAction(long start, long length, DnCRecursiveAction next) {
            return new ObjectTensorFillAction<T>(abacus,tensor,function,start,length,next);
        }
    }

    private static class ByteTensorFillAction extends TensorFillAction {
        private static final long serialVersionUID = 2457306928977492650L;

        private final ByteTensor tensor;
        private final ByteTensorValueFunction function;

        private ByteTensorFillAction(Abacus abacus, ByteTensor tensor, ByteTensorValueFunction function, long start, long length, DnCRecursiveAction next) {
            super(abacus,start,length,next);
            this.tensor = tensor;
            this.function = function;
        }

        private ByteTensorFillAction(ByteTensor tensor, ByteTensorValueFunction function, long size) {
            super(tensor,size);
            this.tensor = tensor;
            this.function = function;
        }

        protected void setValueAction(int[] indices) {
            tensor.setCell(function.getValue(indices),indices);
        }

        @Override
        protected DnCRecursiveAction getNextAction(long start, long length, DnCRecursiveAction next) {
            return new ByteTensorFillAction(abacus,tensor,function,start,length,next);
        }
    }

    private static class ShortTensorFillAction extends TensorFillAction {
        private static final long serialVersionUID = 6058721042652787889L;

        private final ShortTensor tensor;
        private final ShortTensorValueFunction function;

        private ShortTensorFillAction(Abacus abacus, ShortTensor tensor, ShortTensorValueFunction function, long start, long length, DnCRecursiveAction next) {
            super(abacus,start,length,next);
            this.tensor = tensor;
            this.function = function;
        }

        private ShortTensorFillAction(ShortTensor tensor, ShortTensorValueFunction function, long size) {
            super(tensor,size);
            this.tensor = tensor;
            this.function = function;
        }

        protected void setValueAction(int[] indices) {
            tensor.setCell(function.getValue(indices),indices);
        }

        @Override
        protected DnCRecursiveAction getNextAction(long start, long length, DnCRecursiveAction next) {
            return new ShortTensorFillAction(abacus,tensor,function,start,length,next);
        }
    }

    private static class IntTensorFillAction extends TensorFillAction {
        private static final long serialVersionUID = 1453051510210020851L;

        private final IntTensor tensor;
        private final IntTensorValueFunction function;

        private IntTensorFillAction(Abacus abacus, IntTensor tensor, IntTensorValueFunction function, long start, long length, DnCRecursiveAction next) {
            super(abacus,start,length,next);
            this.tensor = tensor;
            this.function = function;
        }

        private IntTensorFillAction(IntTensor tensor, IntTensorValueFunction function, long size) {
            super(tensor,size);
            this.tensor = tensor;
            this.function = function;
        }

        protected void setValueAction(int[] indices) {
            tensor.setCell(function.getValue(indices),indices);
        }

        @Override
        protected DnCRecursiveAction getNextAction(long start, long length, DnCRecursiveAction next) {
            return new IntTensorFillAction(abacus,tensor,function,start,length,next);
        }
    }

    private static class LongTensorFillAction extends TensorFillAction {
        private static final long serialVersionUID = -643717778291276016L;

        private final LongTensor tensor;
        private final LongTensorValueFunction function;

        private LongTensorFillAction(Abacus abacus, LongTensor tensor, LongTensorValueFunction function, long start, long length, DnCRecursiveAction next) {
            super(abacus,start,length,next);
            this.tensor = tensor;
            this.function = function;
        }

        private LongTensorFillAction(LongTensor tensor, LongTensorValueFunction function, long size) {
            super(tensor,size);
            this.tensor = tensor;
            this.function = function;
        }

        protected void setValueAction(int[] indices) {
            tensor.setCell(function.getValue(indices),indices);
        }

        @Override
        protected DnCRecursiveAction getNextAction(long start, long length, DnCRecursiveAction next) {
            return new LongTensorFillAction(abacus,tensor,function,start,length,next);
        }
    }

    private static class FloatTensorFillAction extends TensorFillAction {
        private static final long serialVersionUID = 32921758348329456L;

        private final FloatTensor tensor;
        private final FloatTensorValueFunction function;

        private FloatTensorFillAction(Abacus abacus, FloatTensor tensor, FloatTensorValueFunction function, long start, long length, DnCRecursiveAction next) {
            super(abacus,start,length,next);
            this.tensor = tensor;
            this.function = function;
        }

        private FloatTensorFillAction(FloatTensor tensor, FloatTensorValueFunction function, long size) {
            super(tensor,size);
            this.tensor = tensor;
            this.function = function;
        }

        protected void setValueAction(int[] indices) {
            tensor.setCell(function.getValue(indices),indices);
        }

        @Override
        protected DnCRecursiveAction getNextAction(long start, long length, DnCRecursiveAction next) {
            return new FloatTensorFillAction(abacus,tensor,function,start,length,next);
        }
    }

    private static class DoubleTensorFillAction extends TensorFillAction {
        private static final long serialVersionUID = -1484741639211516341L;

        private final DoubleTensor tensor;
        private final DoubleTensorValueFunction function;

        private DoubleTensorFillAction(Abacus abacus, DoubleTensor tensor, DoubleTensorValueFunction function, long start, long length, DnCRecursiveAction next) {
            super(abacus,start,length,next);
            this.tensor = tensor;
            this.function = function;
        }

        private DoubleTensorFillAction(DoubleTensor tensor, DoubleTensorValueFunction function, long size) {
            super(tensor,size);
            this.tensor = tensor;
            this.function = function;
        }

        protected void setValueAction(int[] indices) {
            tensor.setCell(function.getValue(indices),indices);
        }

        @Override
        protected DnCRecursiveAction getNextAction(long start, long length, DnCRecursiveAction next) {
            return new DoubleTensorFillAction(abacus,tensor,function,start,length,next);
        }
    }

    private static class CharTensorFillAction extends TensorFillAction {
        private static final long serialVersionUID = 2987434933552494786L;

        private final CharTensor tensor;
        private final CharTensorValueFunction function;

        private CharTensorFillAction(Abacus abacus, CharTensor tensor, CharTensorValueFunction function, long start, long length, DnCRecursiveAction next) {
            super(abacus,start,length,next);
            this.tensor = tensor;
            this.function = function;
        }

        private CharTensorFillAction(CharTensor tensor, CharTensorValueFunction function, long size) {
            super(tensor,size);
            this.tensor = tensor;
            this.function = function;
        }

        protected void setValueAction(int[] indices) {
            tensor.setCell(function.getValue(indices),indices);
        }

        @Override
        protected DnCRecursiveAction getNextAction(long start, long length, DnCRecursiveAction next) {
            return new CharTensorFillAction(abacus,tensor,function,start,length,next);
        }
    }

    private static class BooleanTensorFillAction extends TensorFillAction {
        private static final long serialVersionUID = 8330680547764824899L;

        private final BooleanTensor tensor;
        private final BooleanTensorValueFunction function;

        private BooleanTensorFillAction(Abacus abacus, BooleanTensor tensor, BooleanTensorValueFunction function, long start, long length, DnCRecursiveAction next) {
            super(abacus,start,length,next);
            this.tensor = tensor;
            this.function = function;
        }

        private BooleanTensorFillAction(BooleanTensor tensor, BooleanTensorValueFunction function, long size) {
            super(tensor,size);
            this.tensor = tensor;
            this.function = function;
        }

        protected void setValueAction(int[] indices) {
            tensor.setCell(function.getValue(indices),indices);
        }

        @Override
        protected DnCRecursiveAction getNextAction(long start, long length, DnCRecursiveAction next) {
            return new BooleanTensorFillAction(abacus,tensor,function,start,length,next);
        }
    }

    ////////////////////////////non-numeric copyto functions//////////////////////

    /**
     * Copy the values from one tensor holding {@code boolean}s to another.
     * 
     * @param sourceTensor
     *        The source tensor.
     *        
     * @param sinkTensor
     *        The destination tensor.
     *        
     * @throws IllegalArgumentException if the size/dimensionality of the two tensors are not equal.
     */
    public static void copyTo(final BooleanTensor sourceTensor, BooleanTensor sinkTensor) {
        TensorImplUtil.checkSetTensorParameters(sourceTensor,sinkTensor);
        TensorUtil.fill(sinkTensor, new TensorUtil.BooleanTensorValueFunction() {
            public boolean getValue(int ... indices) {
                return sourceTensor.getCell(indices);
            }
        });
    }

    /**
     * Copy the values from one tensor holding {@code char}s to another.
     * 
     * @param sourceTensor
     *        The source tensor.
     *        
     * @param sinkTensor
     *        The destination tensor.
     *        
     * @throws IllegalArgumentException if the size/dimensionality of the two tensors are not equal.
     */
    public static void copyTo(final CharTensor sourceTensor, CharTensor sinkTensor) {      
        TensorImplUtil.checkSetTensorParameters(sourceTensor,sinkTensor);
        TensorUtil.fill(sinkTensor, new TensorUtil.CharTensorValueFunction() {
            public char getValue(int ... indices) {
                return sourceTensor.getCell(indices);
            }
        });
    }

    /**
     * Copy the values from one tensor to another.
     * 
     * @param sourceTensor
     *        The source tensor.
     *        
     * @param sinkTensor
     *        The destination tensor.
     *        
     * @param <T>
     *        The type held by the tensors.
     *        
     * @throws IllegalArgumentException if the size/dimensionality of the two tensors are not equal.
     */
    public static <T> void copyTo(final Tensor<T> sourceTensor, Tensor<T> sinkTensor) {
        TensorImplUtil.checkSetTensorParameters(sourceTensor,sinkTensor);
        TensorUtil.fill(sinkTensor, new TensorUtil.TensorValueFunction<T>() {
            public T getValue(int ... indices) {
                return sourceTensor.getValue(indices);
            }
        });
    }

    ////////////////////////////copyof functions//////////////////////        
    @SuppressWarnings("unchecked") //id list is ok here, everything is done under the covers
    private static <T> Tensor<T> shellCopyOf(Tensor<T> tensor, TensorFactory factory) {
        Index<?> index = tensor.getIndex();
        return index instanceof IdlessIndex ? factory.<T>tensor(tensor.getDimensions()) : 
                                              factory.<T,Object>tensor((List<List<Object>>) (List<?>) index.getIndexIds(),tensor.getDimensions());
    }
    
    @SuppressWarnings("unchecked") //id list is ok here, everything is done under the covers
    private static BooleanTensor booleanShellCopyOf(Tensor<?> tensor, TensorFactory factory) {
        Index<?> index = tensor.getIndex();
        return index instanceof IdlessIndex ? factory.booleanTensor(tensor.getDimensions()) : 
                                              factory.booleanTensor((List<List<Object>>) (List<?>) index.getIndexIds(),tensor.getDimensions());
    }
    
    @SuppressWarnings("unchecked") //id list is ok here, everything is done under the covers
    private static CharTensor charShellCopyOf(Tensor<?> tensor, TensorFactory factory) {
        Index<?> index = tensor.getIndex();
        return index instanceof IdlessIndex ? factory.charTensor(tensor.getDimensions()) : 
                                              factory.charTensor((List<List<Object>>) (List<?>) index.getIndexIds(),tensor.getDimensions());
    }   
    
    @SuppressWarnings("unchecked") //id list is ok here, everything is done under the covers
    private static ByteTensor byteShellCopyOf(Tensor<?> tensor, TensorFactory factory) {
        Index<?> index = tensor.getIndex();
        return index instanceof IdlessIndex ? factory.byteTensor(tensor.getDimensions()) : 
                                              factory.byteTensor((List<List<Object>>) (List<?>) index.getIndexIds(),tensor.getDimensions());
    }
    
    @SuppressWarnings("unchecked") //id list is ok here, everything is done under the covers
    private static ShortTensor shortShellCopyOf(Tensor<?> tensor, TensorFactory factory) {
        Index<?> index = tensor.getIndex();
        return index instanceof IdlessIndex ? factory.shortTensor(tensor.getDimensions()) : 
                                              factory.shortTensor((List<List<Object>>) (List<?>) index.getIndexIds(),tensor.getDimensions());
    }
    
    @SuppressWarnings("unchecked") //id list is ok here, everything is done under the covers
    private static IntTensor intShellCopyOf(Tensor<?> tensor, TensorFactory factory) {
        Index<?> index = tensor.getIndex();
        return index instanceof IdlessIndex ? factory.intTensor(tensor.getDimensions()) : 
                                              factory.intTensor((List<List<Object>>) (List<?>) index.getIndexIds(),tensor.getDimensions());
    }
    
    @SuppressWarnings("unchecked") //id list is ok here, everything is done under the covers
    private static LongTensor longShellCopyOf(Tensor<?> tensor, TensorFactory factory) {
        Index<?> index = tensor.getIndex();
        return index instanceof IdlessIndex ? factory.longTensor(tensor.getDimensions()) : 
                                              factory.longTensor((List<List<Object>>) (List<?>) index.getIndexIds(),tensor.getDimensions());
    }
    
    @SuppressWarnings("unchecked") //id list is ok here, everything is done under the covers
    private static FloatTensor floatShellCopyOf(Tensor<?> tensor, TensorFactory factory) {
        Index<?> index = tensor.getIndex();
        return index instanceof IdlessIndex ? factory.floatTensor(tensor.getDimensions()) : 
                                              factory.floatTensor((List<List<Object>>) (List<?>) index.getIndexIds(),tensor.getDimensions());
    }
    
    @SuppressWarnings("unchecked") //id list is ok here, everything is done under the covers
    private static DoubleTensor doubleShellCopyOf(Tensor<?> tensor, TensorFactory factory) {
        Index<?> index = tensor.getIndex();
        return index instanceof IdlessIndex ? factory.doubleTensor(tensor.getDimensions()) : 
                                              factory.doubleTensor((List<List<Object>>) (List<?>) index.getIndexIds(),tensor.getDimensions());
    }

    /**
     * Get a copy of a tensor. The returned tensor will not be a reference to the source tensor, but rather an independent
     * copy. The appropriate size and type interfaces from {@code com.pb.sawdust.decorators} will be implemented by 
     * the returned tensor.
     * 
     * @param tensor
     *        The tensor to copy.
     *        
     * @param factory
     *        The tensor factory used to build the returned tensor.
     *        
     * @param <T>
     *        The type held by the tensors.
     *        
     * @return a copy of {@code tensor}.
     */
    @SuppressWarnings("unchecked") //casts from [primitive]Tensor to Tensor<T> will be verified by inputs combined with java type
    public static <T> Tensor<T> copyOf(Tensor<T> tensor, TensorFactory factory) {
        int[] dim = tensor.getDimensions();
        switch (tensor.getType()) {
            case BOOLEAN : {
                BooleanTensor t = booleanShellCopyOf(tensor,factory);
                try {
                    copyTo((BooleanTensor) tensor,t);
                } catch (ClassCastException e) {
                    copyTo((BooleanTensor) TensorImplUtil.tensorCaster(tensor),t);
                }
                return (Tensor<T>) t;
            }
            case BYTE : {
                ByteTensor t = byteShellCopyOf(tensor,factory);
                try {
                    copyTo((ByteTensor) tensor,t);
                } catch (ClassCastException e) {
                    copyTo((ByteTensor) TensorImplUtil.tensorCaster(tensor),t);
                }
                return (Tensor<T>) t;
            }
            case CHAR :{
                CharTensor t = charShellCopyOf(tensor,factory);
                try {
                    copyTo((CharTensor) tensor,t);
                } catch (ClassCastException e) {
                    copyTo((CharTensor) TensorImplUtil.tensorCaster(tensor),t);
                }
                return (Tensor<T>) t;
            }
            case DOUBLE : {
                DoubleTensor t = doubleShellCopyOf(tensor,factory);
                try {
                    copyTo((DoubleTensor) tensor,t);
                } catch (ClassCastException e) {
                    copyTo((DoubleTensor) TensorImplUtil.tensorCaster(tensor),t);
                }
                return (Tensor<T>) t;
            }
            case FLOAT : {
                FloatTensor t = floatShellCopyOf(tensor,factory);
                try {
                    copyTo((FloatTensor) tensor,t);
                } catch (ClassCastException e) {
                    copyTo((FloatTensor) TensorImplUtil.tensorCaster(tensor),t);
                }
                return (Tensor<T>) t;
            }
            case INT : {
                IntTensor t = intShellCopyOf(tensor,factory);
                try {
                    copyTo((IntTensor) tensor,t);
                } catch (ClassCastException e) {
                    copyTo((IntTensor) TensorImplUtil.tensorCaster(tensor),t);
                }
                return (Tensor<T>) t;
            }
            case LONG : {
                LongTensor t = longShellCopyOf(tensor,factory);
                try {
                    copyTo((LongTensor) tensor,t);
                } catch (ClassCastException e) {
                    copyTo((LongTensor) TensorImplUtil.tensorCaster(tensor),t);
                }
                return (Tensor<T>) t;
            }
            case SHORT : {
                ShortTensor t = shortShellCopyOf(tensor,factory);
                try {
                    copyTo((ShortTensor) tensor,t);
                } catch (ClassCastException e) {
                    copyTo((ShortTensor) TensorImplUtil.tensorCaster(tensor),t);
                }
                return (Tensor<T>) t;
            }
            case OBJECT :{
                Tensor<T> t = shellCopyOf(tensor,factory);
                copyTo(tensor,t);
                return t;
            }
        }
        throw new IllegalStateException("shouldn't be here");
    }


    ////////////////////////////get element///////////////////////////

    /**
     * Get the first element in a tensor.
     * 
     * @param tensor
     *        The tensor.
     *        
     * @return The first element in {@code tensor}.
     */
    public static Object getFirstElement(Tensor<?> tensor) {
        return tensor.getValue(new Abacus(tensor.getDimensions()).getAbacusPoint(0));
    }

    /**
     * Get an iterator over the elements in a tensor holding {@code boolean}s. The iterator will cycle over the elements
     * in the same order as specified by an {@link Abacus} built from the tensor's size.
     * 
     * @param t
     *        The tensor.
     *        
     * @return an iterator which will cycle over the elements of {@code t}.
     */
    public static Iterator<Boolean> getElementIterator(final BooleanTensor t) {
        final Abacus ab = new Abacus(t.getDimensions());
        return new Iterator<Boolean>() {

            @Override
            public boolean hasNext() {
                return ab.hasNext();
            }

            @Override
            public Boolean next() {
                if (hasNext())
                    return t.getValue(ab.next());
                throw new NoSuchElementException();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("remove method not supported");
            }
        };
    }                                              

    /**
     * Get an iterator over the elements in a tensor holding {@code char}s. The iterator will cycle over the elements
     * in the same order as specified by an {@link Abacus} built from the tensor's size.
     * 
     * @param t
     *        The tensor.
     *        
     * @return an iterator which will cycle over the elements of {@code t}.
     */
    public static Iterator<Character> getElementIterator(final CharTensor t) {
        final Abacus ab = new Abacus(t.getDimensions());
        return new Iterator<Character>() {

            @Override
            public boolean hasNext() {
                return ab.hasNext();
            }

            @Override
            public Character next() {
                if (hasNext())
                    return t.getValue(ab.next());
                throw new NoSuchElementException();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("remove method not supported");
            }
        };
    }

    /**
     * Get an iterator over the elements in a tensor holding {@code byte}s. The iterator will cycle over the elements
     * in the same order as specified by an {@link Abacus} built from the tensor's size.
     * 
     * @param t
     *        The tensor.
     *        
     * @return an iterator which will cycle over the elements of {@code t}.
     */
    public static Iterator<Byte> getElementIterator(final ByteTensor t) {
        final Abacus ab = new Abacus(t.getDimensions());
        return new Iterator<Byte>() {

            @Override
            public boolean hasNext() {
                return ab.hasNext();
            }

            @Override
            public Byte next() {
                if (hasNext())
                    return t.getValue(ab.next());
                throw new NoSuchElementException();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("remove method not supported");
            }
        };
    }                  

    /**
     * Get an iterator over the elements in a tensor holding {@code short}s. The iterator will cycle over the elements
     * in the same order as specified by an {@link Abacus} built from the tensor's size.
     * 
     * @param t
     *        The tensor.
     *        
     * @return an iterator which will cycle over the elements of {@code t}.
     */
    public static Iterator<Short> getElementIterator(final ShortTensor t) {
        final Abacus ab = new Abacus(t.getDimensions());
        return new Iterator<Short>() {

            @Override
            public boolean hasNext() {
                return ab.hasNext();
            }

            @Override
            public Short next() {
                if (hasNext())
                    return t.getValue(ab.next());
                throw new NoSuchElementException();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("remove method not supported");
            }
        };
    }

    /**
     * Get an iterator over the elements in a tensor holding {@code int}s. The iterator will cycle over the elements
     * in the same order as specified by an {@link Abacus} built from the tensor's size.
     * 
     * @param t
     *        The tensor.
     *        
     * @return an iterator which will cycle over the elements of {@code t}.
     */
    public static Iterator<Integer> getElementIterator(final IntTensor t) {
        final Abacus ab = new Abacus(t.getDimensions());
        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                return ab.hasNext();
            }

            @Override
            public Integer next() {
                if (hasNext())
                    return t.getValue(ab.next());
                throw new NoSuchElementException();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("remove method not supported");
            }
        };
    }

    /**
     * Get an iterator over the elements in a tensor holding {@code long}s. The iterator will cycle over the elements
     * in the same order as specified by an {@link Abacus} built from the tensor's size.
     * 
     * @param t
     *        The tensor.
     *        
     * @return an iterator which will cycle over the elements of {@code t}.
     */
    public static Iterator<Long> getElementIterator(final LongTensor t) {
        final Abacus ab = new Abacus(t.getDimensions());
        return new Iterator<Long>() {

            @Override
            public boolean hasNext() {
                return ab.hasNext();
            }

            @Override
            public Long next() {
                if (hasNext())
                    return t.getValue(ab.next());
                throw new NoSuchElementException();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("remove method not supported");
            }
        };
    }

    /**
     * Get an iterator over the elements in a tensor holding {@code float}s. The iterator will cycle over the elements
     * in the same order as specified by an {@link Abacus} built from the tensor's size.
     * 
     * @param t
     *        The tensor.
     *        
     * @return an iterator which will cycle over the elements of {@code t}.
     */
    public static Iterator<Float> getElementIterator(final FloatTensor t) {
        final Abacus ab = new Abacus(t.getDimensions());
        return new Iterator<Float>() {

            @Override
            public boolean hasNext() {
                return ab.hasNext();
            }

            @Override
            public Float next() {
                if (hasNext())
                    return t.getValue(ab.next());
                throw new NoSuchElementException();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("remove method not supported");
            }
        };
    }

    /**
     * Get an iterator over the elements in a tensor holding {@code double}s. The iterator will cycle over the elements
     * in the same order as specified by an {@link Abacus} built from the tensor's size.
     * 
     * @param t
     *        The tensor.
     *        
     * @return an iterator which will cycle over the elements of {@code t}.
     */
    public static Iterator<Double> getElementIterator(final DoubleTensor t) {
        final Abacus ab = new Abacus(t.getDimensions());
        return new Iterator<Double>() {

            @Override
            public boolean hasNext() {
                return ab.hasNext();
            }

            @Override
            public Double next() {
                if (hasNext())
                    return t.getValue(ab.next());
                throw new NoSuchElementException();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("remove method not supported");
            }
        };
    }

    /**
     * Get an iterator over the elements in a tensor . The iterator will cycle over the elements
     * in the same order as specified by an {@link Abacus} built from the tensor's size.
     * 
     * @param t
     *        The tensor.
     *        
     * @param <T>
     *        The type held by the tensor.
     *        
     * @return an iterator which will cycle over the elements of {@code t}.
     */
    public static <T> Iterator<T> getElementIterator(final Tensor<T> t) {
        final Abacus ab = new Abacus(t.getDimensions());
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                return ab.hasNext();
            }

            @Override
            public T next() {
                if (hasNext())
                    return t.getValue(ab.next());
                throw new NoSuchElementException();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("remove method not supported");
            }
        };
    }

    ////////////////////////////size functions////////////////////////

    /**
     * Get the number of elements in a tensor.
     * 
     * @param tensor
     *        The tensor.
     *        
     * @return the number of elements in {@code tensor}.
     */
    public static long getElementCount(Tensor tensor) {
        return getElementCount(tensor.getDimensions());
    }
                                                    
    /**
     * Get the number of elements in a tensor with the specified shape.
     * 
     * @param tensorDimensions
     *        The tensor dimensionality/shape.
     *        
     * @return the number of elements in a tensor of shape {@code tensorDimensions}.
     */
    public static long getElementCount(int[] tensorDimensions) {
        long count = 1L;
        for (int i : tensorDimensions)
            count *= i;
        return count;

    }

    //////////////////////////numeric casts//////////////////////////

    /**
     * Get a tensor holding {@code double}s which refers to a tensor holding numbers. This method is useful for transferring
     * between numeric types without having to copy the source tensor.
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @return a reference to {@code tensor} which holds {@code double}s.
     */
    public static DoubleTensor asDoubleTensor(Tensor<? extends Number> tensor) {
        return NumericTensor.asDoubleTensor(tensor);
    }

    /**
     * Get a tensor holding {@code float}s which refers to a tensor holding numbers. This method is useful for transferring
     * between numeric types without having to copy the source tensor.
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @return a reference to {@code tensor} which holds {@code float}s.
     */
    public static FloatTensor asFloatTensor(Tensor<? extends Number> tensor) {
        return NumericTensor.asFloatTensor(tensor);
    }
    
    /**
     * Get a tensor holding {@code long}s which refers to a tensor holding numbers. This method is useful for transferring
     * between numeric types without having to copy the source tensor.
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @return a reference to {@code tensor} which holds {@code long}s.
     */
    public static LongTensor asLongTensor(Tensor<? extends Number> tensor) {
        return NumericTensor.asLongTensor(tensor);
    }
    
    /**
     * Get a tensor holding {@code int}s which refers to a tensor holding numbers. This method is useful for transferring
     * between numeric types without having to copy the source tensor.
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @return a reference to {@code tensor} which holds {@code int}s.
     */
    public static IntTensor asIntTensor(Tensor<? extends Number> tensor) {
        return NumericTensor.asIntTensor(tensor);
    }
    
    /**
     * Get a tensor holding {@code short}s which refers to a tensor holding numbers. This method is useful for transferring
     * between numeric types without having to copy the source tensor.
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @return a reference to {@code tensor} which holds {@code short}s.
     */
    public static ShortTensor asShortTensor(Tensor<? extends Number> tensor) {
        return NumericTensor.asShortTensor(tensor);
    }
    
    /**
     * Get a tensor holding {@code byte}s which refers to a tensor holding numbers. This method is useful for transferring
     * between numeric types without having to copy the source tensor.
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @return a reference to {@code tensor} which holds {@code byte}s.
     */
    public static ByteTensor asByteTensor(Tensor<? extends Number> tensor) {
        return NumericTensor.asByteTensor(tensor);
    }

    /**
     * Copy the values from one numeric tensor to another.
     * 
     * @param sourceTensor
     *        The source tensor.
     *        
     * @param sinkTensor
     *        The tensor to copy the values to.
     *        
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo(ByteTensor sourceTensor, DoubleTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code double}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @param factory
     *        The tensor factory to use to construct the copy.
     *        
     * @return a tensor with the values in {@code tensor} as {@code double}s.
     */
    public static DoubleTensor copyOfAsDouble(ByteTensor tensor, TensorFactory factory) {
        DoubleTensor t = doubleShellCopyOf(tensor,factory);
        copyTo(tensor,t);
        return t;
    }

    /**
     * Copy the values from one numeric tensor to another.
     * 
     * @param sourceTensor
     *        The source tensor.
     *        
     * @param sinkTensor
     *        The tensor to copy the values to.
     *        
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo(ShortTensor sourceTensor, DoubleTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code double}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @param factory
     *        The tensor factory to use to construct the copy.
     *        
     * @return a tensor with the values in {@code tensor} as {@code double}s.
     */
    public static DoubleTensor copyOfAsDouble(ShortTensor tensor, TensorFactory factory) {
        DoubleTensor t = doubleShellCopyOf(tensor,factory);
        copyTo(tensor,t);
        return t;
    }

    /**
     * Copy the values from one numeric tensor to another.
     * 
     * @param sourceTensor
     *        The source tensor.
     *        
     * @param sinkTensor
     *        The tensor to copy the values to.
     *        
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo(IntTensor sourceTensor, DoubleTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code double}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @param factory
     *        The tensor factory to use to construct the copy.
     *        
     * @return a tensor with the values in {@code tensor} as {@code double}s.
     */
    public static DoubleTensor copyOfAsDouble(IntTensor tensor, TensorFactory factory) {
        DoubleTensor t = doubleShellCopyOf(tensor,factory);
        copyTo(tensor,t);
        return t;
    }

    /**
     * Copy the values from one numeric tensor to another.
     * 
     * @param sourceTensor
     *        The source tensor.
     *        
     * @param sinkTensor
     *        The tensor to copy the values to.
     *        
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo(LongTensor sourceTensor, DoubleTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code double}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @param factory
     *        The tensor factory to use to construct the copy.
     *        
     * @return a tensor with the values in {@code tensor} as {@code double}s.
     */
    public static DoubleTensor copyOfAsDouble(LongTensor tensor, TensorFactory factory) {
        DoubleTensor t = doubleShellCopyOf(tensor,factory);
        copyTo(tensor,t);
        return t;
    }

    /**
     * Copy the values from one numeric tensor to another.
     * 
     * @param sourceTensor
     *        The source tensor.
     *        
     * @param sinkTensor
     *        The tensor to copy the values to.
     *        
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo(FloatTensor sourceTensor, DoubleTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code double}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @param factory
     *        The tensor factory to use to construct the copy.
     *        
     * @return a tensor with the values in {@code tensor} as {@code double}s.
     */
    public static DoubleTensor copyOfAsDouble(FloatTensor tensor, TensorFactory factory) {
        DoubleTensor t = doubleShellCopyOf(tensor,factory);
        copyTo(tensor,t);
        return t;
    }

    /**
     * Copy the values from one numeric tensor to another.
     * 
     * @param sourceTensor
     *        The source tensor.
     *        
     * @param sinkTensor
     *        The tensor to copy the values to.
     *        
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo(DoubleTensor sourceTensor, DoubleTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }    

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code double}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @param factory
     *        The tensor factory to use to construct the copy.
     *        
     * @return a tensor with the values in {@code tensor} as {@code double}s.
     */
    public static DoubleTensor copyOfAsDouble(DoubleTensor tensor, TensorFactory factory) {
        return (DoubleTensor) copyOf(tensor,factory);
    }

    /**
     * Copy the values from one numeric tensor to another.
     * 
     * @param sourceTensor
     *        The source tensor.
     *        
     * @param sinkTensor
     *        The tensor to copy the values to.
     *        
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo(ByteTensor sourceTensor, FloatTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code float}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @param factory
     *        The tensor factory to use to construct the copy.
     *        
     * @return a tensor with the values in {@code tensor} as {@code float}s.
     */
    public static FloatTensor copyOfAsFloat(ByteTensor tensor, TensorFactory factory) {
        FloatTensor t = floatShellCopyOf(tensor,factory);
        copyTo(tensor,t);
        return t;
    }

    /**
     * Copy the values from one numeric tensor to another.
     * 
     * @param sourceTensor
     *        The source tensor.
     *        
     * @param sinkTensor
     *        The tensor to copy the values to.
     *        
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo(ShortTensor sourceTensor, FloatTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code float}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @param factory
     *        The tensor factory to use to construct the copy.
     *        
     * @return a tensor with the values in {@code tensor} as {@code float}s.
     */
    public static FloatTensor copyOfAsFloat(ShortTensor tensor, TensorFactory factory) {
        FloatTensor t = floatShellCopyOf(tensor,factory);
        copyTo(tensor,t);
        return t;
    }

    /**
     * Copy the values from one numeric tensor to another.
     * 
     * @param sourceTensor
     *        The source tensor.
     *        
     * @param sinkTensor
     *        The tensor to copy the values to.
     *        
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo(IntTensor sourceTensor, FloatTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code float}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @param factory
     *        The tensor factory to use to construct the copy.
     *        
     * @return a tensor with the values in {@code tensor} as {@code float}s.
     */
    public static FloatTensor copyOfAsFloat(IntTensor tensor, TensorFactory factory) {
        FloatTensor t = floatShellCopyOf(tensor,factory);
        copyTo(tensor,t);
        return t;
    }

    /**
     * Copy the values from one numeric tensor to another.
     * 
     * @param sourceTensor
     *        The source tensor.
     *        
     * @param sinkTensor
     *        The tensor to copy the values to.
     *        
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo(LongTensor sourceTensor, FloatTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code float}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @param factory
     *        The tensor factory to use to construct the copy.
     *        
     * @return a tensor with the values in {@code tensor} as {@code float}s.
     */
    public static FloatTensor copyOfAsFloat(LongTensor tensor, TensorFactory factory) {
        FloatTensor t = floatShellCopyOf(tensor,factory);
        copyTo(tensor,t);
        return t;
    }

    /**
     * Copy the values from one numeric tensor to another.
     * 
     * @param sourceTensor
     *        The source tensor.
     *        
     * @param sinkTensor
     *        The tensor to copy the values to.
     *        
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo(DoubleTensor sourceTensor, FloatTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }     

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code float}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @param factory
     *        The tensor factory to use to construct the copy.
     *        
     * @return a tensor with the values in {@code tensor} as {@code float}s.
     */
    public static FloatTensor copyOfAsFloat(FloatTensor tensor, TensorFactory factory) {
        return (FloatTensor) copyOf(tensor,factory);
    }

    /**
     * Copy the values from one numeric tensor to another.
     * 
     * @param sourceTensor
     *        The source tensor.
     *        
     * @param sinkTensor
     *        The tensor to copy the values to.
     *        
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo(FloatTensor sourceTensor, FloatTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code float}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @param factory
     *        The tensor factory to use to construct the copy.
     *        
     * @return a tensor with the values in {@code tensor} as {@code float}s.
     */
    public static FloatTensor copyOfAsFloat(DoubleTensor tensor, TensorFactory factory) {
        FloatTensor t = floatShellCopyOf(tensor,factory);
        copyTo(tensor,t);
        return t;
    }

    /**
     * Copy the values from one numeric tensor to another.
     * 
     * @param sourceTensor
     *        The source tensor.
     *        
     * @param sinkTensor
     *        The tensor to copy the values to.
     *        
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo(ByteTensor sourceTensor, LongTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code long}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @param factory
     *        The tensor factory to use to construct the copy.
     *        
     * @return a tensor with the values in {@code tensor} as {@code long}s.
     */
    public static LongTensor copyOfAsLong(ByteTensor tensor, TensorFactory factory) {
        LongTensor t = longShellCopyOf(tensor,factory);
        copyTo(tensor,t);
        return t;
    }

    /**
     * Copy the values from one numeric tensor to another.
     * 
     * @param sourceTensor
     *        The source tensor.
     *        
     * @param sinkTensor
     *        The tensor to copy the values to.
     *        
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo(ShortTensor sourceTensor, LongTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code long}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @param factory
     *        The tensor factory to use to construct the copy.
     *        
     * @return a tensor with the values in {@code tensor} as {@code long}s.
     */
    public static LongTensor copyOfAsLong(ShortTensor tensor, TensorFactory factory) {
        LongTensor t = longShellCopyOf(tensor,factory);
        copyTo(tensor,t);
        return t;
    }

    /**
     * Copy the values from one numeric tensor to another.
     * 
     * @param sourceTensor
     *        The source tensor.
     *        
     * @param sinkTensor
     *        The tensor to copy the values to.
     *        
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo(IntTensor sourceTensor, LongTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code long}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @param factory
     *        The tensor factory to use to construct the copy.
     *        
     * @return a tensor with the values in {@code tensor} as {@code long}s.
     */
    public static LongTensor copyOfAsLong(IntTensor tensor, TensorFactory factory) {
        LongTensor t = longShellCopyOf(tensor,factory);
        copyTo(tensor,t);
        return t;
    }

    /**
     * Copy the values from one numeric tensor to another.
     * 
     * @param sourceTensor
     *        The source tensor.
     *        
     * @param sinkTensor
     *        The tensor to copy the values to.
     *        
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo(FloatTensor sourceTensor, LongTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code long}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @param factory
     *        The tensor factory to use to construct the copy.
     *        
     * @return a tensor with the values in {@code tensor} as {@code long}s.
     */
    public static LongTensor copyOfAsLong(FloatTensor tensor, TensorFactory factory) {
        LongTensor t = longShellCopyOf(tensor,factory);
        copyTo(tensor,t);
        return t;
    }

    /**
     * Copy the values from one numeric tensor to another.
     * 
     * @param sourceTensor
     *        The source tensor.
     *        
     * @param sinkTensor
     *        The tensor to copy the values to.
     *        
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo(DoubleTensor sourceTensor, LongTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code long}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @param factory
     *        The tensor factory to use to construct the copy.
     *        
     * @return a tensor with the values in {@code tensor} as {@code long}s.
     */
    public static LongTensor copyOfAsLong(DoubleTensor tensor, TensorFactory factory) {
        LongTensor t = longShellCopyOf(tensor,factory);
        copyTo(tensor,t);
        return t;
    }

    /**
     * Copy the values from one numeric tensor to another.
     * 
     * @param sourceTensor
     *        The source tensor.
     *        
     * @param sinkTensor
     *        The tensor to copy the values to.
     *        
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo(LongTensor sourceTensor, LongTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }                       

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code long}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @param factory
     *        The tensor factory to use to construct the copy.
     *        
     * @return a tensor with the values in {@code tensor} as {@code long}s.
     */
    public static LongTensor copyOfAsLong(LongTensor tensor, TensorFactory factory) {
        return (LongTensor) copyOf(tensor,factory);
    }

    /**
     * Copy the values from one numeric tensor to another.
     * 
     * @param sourceTensor
     *        The source tensor.
     *        
     * @param sinkTensor
     *        The tensor to copy the values to.
     *        
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo(ByteTensor sourceTensor, IntTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }         

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code int}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @param factory
     *        The tensor factory to use to construct the copy.
     *        
     * @return a tensor with the values in {@code tensor} as {@code int}s.
     */
    public static IntTensor copyOfAsInt(ByteTensor tensor, TensorFactory factory) {
        IntTensor t = intShellCopyOf(tensor,factory);
        copyTo(tensor,t);
        return t;
    }

    /**
     * Copy the values from one numeric tensor to another.
     * 
     * @param sourceTensor
     *        The source tensor.
     *        
     * @param sinkTensor
     *        The tensor to copy the values to.
     *        
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo(ShortTensor sourceTensor, IntTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }        

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code int}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @param factory
     *        The tensor factory to use to construct the copy.
     *        
     * @return a tensor with the values in {@code tensor} as {@code int}s.
     */
    public static IntTensor copyOfAsInt(ShortTensor tensor, TensorFactory factory) {
        IntTensor t = intShellCopyOf(tensor,factory);
        copyTo(tensor,t);
        return t;
    }

    /**
     * Copy the values from one numeric tensor to another.
     * 
     * @param sourceTensor
     *        The source tensor.
     *        
     * @param sinkTensor
     *        The tensor to copy the values to.
     *        
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo(LongTensor sourceTensor, IntTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }        

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code int}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @param factory
     *        The tensor factory to use to construct the copy.
     *        
     * @return a tensor with the values in {@code tensor} as {@code int}s.
     */
    public static IntTensor copyOfAsInt(LongTensor tensor, TensorFactory factory) {
        IntTensor t = intShellCopyOf(tensor,factory);
        copyTo(tensor,t);
        return t;
    }

    /**
     * Copy the values from one numeric tensor to another.
     * 
     * @param sourceTensor
     *        The source tensor.
     *        
     * @param sinkTensor
     *        The tensor to copy the values to.
     *        
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo(FloatTensor sourceTensor, IntTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code int}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     *
     * @param tensor
     *        The source tensor.
     *
     * @param factory
     *        The tensor factory to use to construct the copy.
     *
     * @return a tensor with the values in {@code tensor} as {@code int}s.
     */
    public static IntTensor copyOfAsInt(FloatTensor tensor, TensorFactory factory) {
        IntTensor t = intShellCopyOf(tensor,factory);
        copyTo(tensor,t);
        return t;
    }

    /**
     * Copy the values from one numeric tensor to another.
     * 
     * @param sourceTensor
     *        The source tensor.
     *        
     * @param sinkTensor
     *        The tensor to copy the values to.
     *        
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo(DoubleTensor sourceTensor, IntTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }        

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code int}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @param factory
     *        The tensor factory to use to construct the copy.
     *        
     * @return a tensor with the values in {@code tensor} as {@code int}s.
     */
    public static IntTensor copyOfAsInt(DoubleTensor tensor, TensorFactory factory) {
        IntTensor t = intShellCopyOf(tensor,factory);
        copyTo(tensor,t);
        return t;
    }

    /**
     * Copy the values from one numeric tensor to another.
     * 
     * @param sourceTensor
     *        The source tensor.
     *        
     * @param sinkTensor
     *        The tensor to copy the values to.
     *        
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo(IntTensor sourceTensor, IntTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }               

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code int}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @param factory
     *        The tensor factory to use to construct the copy.
     *        
     * @return a tensor with the values in {@code tensor} as {@code int}s.
     */
    public static IntTensor copyOfAsInt(IntTensor tensor, TensorFactory factory) {
        return (IntTensor) copyOf(tensor,factory);
    }

    /**
     * Copy the values from one numeric tensor to another.
     * 
     * @param sourceTensor
     *        The source tensor.
     *        
     * @param sinkTensor
     *        The tensor to copy the values to.
     *        
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo(ByteTensor sourceTensor, ShortTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }        

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code short}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     * 
     * @param tensor
     *        The source tensor.
     *        
     * @param factory
     *        The tensor factory to use to construct the copy.
     *        
     * @return a tensor with the values in {@code tensor} as {@code short}s.
     */
    public static ShortTensor copyOfAsShort(ByteTensor tensor, TensorFactory factory) {
        ShortTensor t = shortShellCopyOf(tensor,factory);
        copyTo(tensor,t);
        return t;
    }

    /**
     * Copy the values from one numeric tensor to another.
     *
     * @param sourceTensor
     *        The source tensor.
     *
     * @param sinkTensor
     *        The tensor to copy the values to.
     *
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo(IntTensor sourceTensor, ShortTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code short}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     *
     * @param tensor
     *        The source tensor.
     *
     * @param factory
     *        The tensor factory to use to construct the copy.
     *
     * @return a tensor with the values in {@code tensor} as {@code short}s.
     */
    public static ShortTensor copyOfAsShort(IntTensor tensor, TensorFactory factory) {
        ShortTensor t = shortShellCopyOf(tensor,factory);
        copyTo(tensor,t);
        return t;
    }

    /**
     * Copy the values from one numeric tensor to another.
     *
     * @param sourceTensor
     *        The source tensor.
     *
     * @param sinkTensor
     *        The tensor to copy the values to.
     *
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo(LongTensor sourceTensor, ShortTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code short}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     *
     * @param tensor
     *        The source tensor.
     *
     * @param factory
     *        The tensor factory to use to construct the copy.
     *
     * @return a tensor with the values in {@code tensor} as {@code short}s.
     */
    public static ShortTensor copyOfAsShort(LongTensor tensor, TensorFactory factory) {
        ShortTensor t = shortShellCopyOf(tensor,factory);
        copyTo(tensor,t);
        return t;
    }

    /**
     * Copy the values from one numeric tensor to another.
     *
     * @param sourceTensor
     *        The source tensor.
     *
     * @param sinkTensor
     *        The tensor to copy the values to.
     *
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo(FloatTensor sourceTensor, ShortTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code short}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     *
     * @param tensor
     *        The source tensor.
     *
     * @param factory
     *        The tensor factory to use to construct the copy.
     *
     * @return a tensor with the values in {@code tensor} as {@code short}s.
     */
    public static ShortTensor copyOfAsShort(FloatTensor tensor, TensorFactory factory) {
        ShortTensor t = shortShellCopyOf(tensor,factory);
        copyTo(tensor,t);
        return t;
    }

    /**
     * Copy the values from one numeric tensor to another.
     *
     * @param sourceTensor
     *        The source tensor.
     *
     * @param sinkTensor
     *        The tensor to copy the values to.
     *
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo(DoubleTensor sourceTensor, ShortTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code short}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     *
     * @param tensor
     *        The source tensor.
     *
     * @param factory
     *        The tensor factory to use to construct the copy.
     *
     * @return a tensor with the values in {@code tensor} as {@code short}s.
     */
    public static ShortTensor copyOfAsShort(DoubleTensor tensor, TensorFactory factory) {
        ShortTensor t = shortShellCopyOf(tensor,factory);
        copyTo(tensor,t);
        return t;
    }

    /**
     * Copy the values from one numeric tensor to another.
     * 
     * @param sourceTensor
     *        The source tensor.
     *        
     * @param sinkTensor
     *        The tensor to copy the values to.
     *        
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo( ShortTensor sourceTensor, ShortTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code short}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     *
     * @param tensor
     *        The source tensor.
     *
     * @param factory
     *        The tensor factory to use to construct the copy.
     *
     * @return a tensor with the values in {@code tensor} as {@code short}s.
     */
    public static ShortTensor copyOfAsShort(ShortTensor tensor, TensorFactory factory) {
        return (ShortTensor) copyOf(tensor,factory);
    }

    /**
     * Copy the values from one numeric tensor to another.
     *
     * @param sourceTensor
     *        The source tensor.
     *
     * @param sinkTensor
     *        The tensor to copy the values to.
     *
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo( ShortTensor sourceTensor, ByteTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code byte}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     *
     * @param tensor
     *        The source tensor.
     *
     * @param factory
     *        The tensor factory to use to construct the copy.
     *
     * @return a tensor with the values in {@code tensor} as {@code byte}s.
     */
    public static ByteTensor copyOfAsByte(ShortTensor tensor, TensorFactory factory) {
        ByteTensor t = byteShellCopyOf(tensor,factory);
        copyTo(tensor,t);
        return t;
    }

    /**
     * Copy the values from one numeric tensor to another.
     *
     * @param sourceTensor
     *        The source tensor.
     *
     * @param sinkTensor
     *        The tensor to copy the values to.
     *
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo( IntTensor sourceTensor, ByteTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code byte}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     *
     * @param tensor
     *        The source tensor.
     *
     * @param factory
     *        The tensor factory to use to construct the copy.
     *
     * @return a tensor with the values in {@code tensor} as {@code byte}s.
     */
    public static ByteTensor copyOfAsByte(IntTensor tensor, TensorFactory factory) {
        ByteTensor t = byteShellCopyOf(tensor,factory);
        copyTo(tensor,t);
        return t;
    }

    /**
     * Copy the values from one numeric tensor to another.
     *
     * @param sourceTensor
     *        The source tensor.
     *
     * @param sinkTensor
     *        The tensor to copy the values to.
     *
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo(LongTensor sourceTensor, ByteTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code byte}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     *
     * @param tensor
     *        The source tensor.
     *
     * @param factory
     *        The tensor factory to use to construct the copy.
     *
     * @return a tensor with the values in {@code tensor} as {@code byte}s.
     */
    public static ByteTensor copyOfAsByte(LongTensor tensor, TensorFactory factory) {
        ByteTensor t = byteShellCopyOf(tensor,factory);
        copyTo(tensor,t);
        return t;
    }

    /**
     * Copy the values from one numeric tensor to another.
     *
     * @param sourceTensor
     *        The source tensor.
     *
     * @param sinkTensor
     *        The tensor to copy the values to.
     *
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo(FloatTensor sourceTensor, ByteTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code byte}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     *
     * @param tensor
     *        The source tensor.
     *
     * @param factory
     *        The tensor factory to use to construct the copy.
     *
     * @return a tensor with the values in {@code tensor} as {@code byte}s.
     */
    public static ByteTensor copyOfAsByte(FloatTensor tensor, TensorFactory factory) {
        ByteTensor t = byteShellCopyOf(tensor,factory);
        copyTo(tensor,t);
        return t;
    }

    /**
     * Copy the values from one numeric tensor to another.
     *
     * @param sourceTensor
     *        The source tensor.
     *
     * @param sinkTensor
     *        The tensor to copy the values to.
     *
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo( DoubleTensor sourceTensor, ByteTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code byte}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     *
     * @param tensor
     *        The source tensor.
     *
     * @param factory
     *        The tensor factory to use to construct the copy.
     *
     * @return a tensor with the values in {@code tensor} as {@code byte}s.
     */
    public static ByteTensor copyOfAsByte(DoubleTensor tensor, TensorFactory factory) {
        ByteTensor t = byteShellCopyOf(tensor,factory);
        copyTo(tensor,t);
        return t;
    }

    /**
     * Copy the values from one numeric tensor to another.
     * 
     * @param sourceTensor
     *        The source tensor.
     *        
     * @param sinkTensor
     *        The tensor to copy the values to.
     *        
     * @throws IllegalArgumentException if {@code sourceTensor} and {@code sinkTensor} are not the same shape.
     */
    public static void copyTo(ByteTensor sourceTensor, ByteTensor sinkTensor) {
        NumericTensor.copyTo(sourceTensor,sinkTensor);
    }

    /**
     * Get a copy of a numeric tensor as a tensor holding {@code byte}s. The returned tensor will be independant of the
     * source tensor (that is, it will not be a reference tensor).
     *
     * @param tensor
     *        The source tensor.
     *
     * @param factory
     *        The tensor factory to use to construct the copy.
     *
     * @return a tensor with the values in {@code tensor} as {@code byte}s.
     */
    public static ByteTensor copyOfAsByte(ByteTensor tensor, TensorFactory factory) {
        return (ByteTensor) copyOf(tensor,factory);
    }

    //////////////////////////expand/collapse/////////////////////

    /**
     * Get a reference to a tensor with additional dimensions. That is, the returned tensor will refer to the source tensor
     * for its contents, but it will have extra dimensions (each of size one) added to its end. For example, adding two
     * dimensions to a scalar will yield a on-element matrix.
     *
     * @param source
     *        The source tensor.
     *
     * @param additionalDimensions
     *        The number of dimensions to add.
     *
     * @return a reference to {@code source} with {@code additionalDimensions} extra dimensions.
     */
    public static BooleanTensor expand(BooleanTensor source, int additionalDimensions) {
        return source.getReferenceTensor(ExpandingIndex.getStandardExpandingIndex(source.getIndex(),additionalDimensions));
    }

    /**
     *  Get a reference to a tensor with some of its dimensions collapsed. A dimension may be collapsed if it is of size
     *  one. Collapsing a tensor reduces its dimensionality without affecting the contents it holds.
     *
     * @param source
     *        The source tensor.
     *
     * @param dimensionsToCollapse
     *        The dimensions to collapse.
     *
     * @return a reference to {@code source} with dimensions {@code dimensionsToCollapse} collapsed.
     *
     * @throws IllegalArgumentException if any of {@code dimensionsToCollapse} are less than one or greater than the size
     *                                  of {@code source}, or if any of the dimensions in {@code dimensionsToCollapse}
     *                                  have a size greater than one.
     */
    @SuppressWarnings("unchecked") //don't care about index id type explicitly
    public static BooleanTensor collapse(BooleanTensor source, int ... dimensionsToCollapse) {
        return source.getReferenceTensor(new CollapsingIndex(source.getIndex(),true,dimensionsToCollapse));
    }      

    /**
     *  Get a reference to a tensor with all of its collapsible dimensions collapsed. A dimension may be collapsed if it
     *  is of size one. Collapsing a tensor reduces its dimensionality without affecting the contents it holds.
     *
     * @param source
     *        The source tensor.
     *
     * @return a reference to {@code source} with all of its size-one dimensions collapsed.
     */
    @SuppressWarnings("unchecked") //don't care about index id type explicitly
    public static BooleanTensor collapse(BooleanTensor source) {
        return source.getReferenceTensor(new CollapsingIndex(source.getIndex()));
    }

    /**
     * Get a reference to a tensor with additional dimensions. That is, the returned tensor will refer to the source tensor
     * for its contents, but it will have extra dimensions (each of size one) added to its end. For example, adding two
     * dimensions to a scalar will yield a on-element matrix.
     *
     * @param source
     *        The source tensor.
     *
     * @param additionalDimensions
     *        The number of dimensions to add.
     *
     * @return a reference to {@code source} with {@code additionalDimensions} extra dimensions.
     */
    public static CharTensor expand(CharTensor source, int additionalDimensions) {
        return source.getReferenceTensor(ExpandingIndex.getStandardExpandingIndex(source.getIndex(),additionalDimensions));
    }

    /**
     *  Get a reference to a tensor with some of its dimensions collapsed. A dimension may be collapsed if it is of size
     *  one. Collapsing a tensor reduces its dimensionality without affecting the contents it holds.
     *
     * @param source
     *        The source tensor.
     *
     * @param dimensionsToCollapse
     *        The dimensions to collapse.
     *
     * @return a reference to {@code source} with dimensions {@code dimensionsToCollapse} collapsed.
     *
     * @throws IllegalArgumentException if any of {@code dimensionsToCollapse} are less than one or greater than the size
     *                                  of {@code source}, or if any of the dimensions in {@code dimensionsToCollapse}
     *                                  have a size greater than one.
     */
    @SuppressWarnings("unchecked") //don't care about index id type explicitly
    public static CharTensor collapse(CharTensor source, int ... dimensionsToCollapse) {
        return source.getReferenceTensor(new CollapsingIndex(source.getIndex(),true,dimensionsToCollapse));
    }      

    /**
     *  Get a reference to a tensor with all of its collapsible dimensions collapsed. A dimension may be collapsed if it
     *  is of size one. Collapsing a tensor reduces its dimensionality without affecting the contents it holds.
     *
     * @param source
     *        The source tensor.
     *
     * @return a reference to {@code source} with all of its size-one dimensions collapsed.
     */
    @SuppressWarnings("unchecked") //don't care about index id type explicitly
    public static CharTensor collapse(CharTensor source) {
        return source.getReferenceTensor(new CollapsingIndex(source.getIndex()));
    }

    /**
     * Get a reference to a tensor with additional dimensions. That is, the returned tensor will refer to the source tensor
     * for its contents, but it will have extra dimensions (each of size one) added to its end. For example, adding two
     * dimensions to a scalar will yield a on-element matrix.
     *
     * @param source
     *        The source tensor.
     *
     * @param additionalDimensions
     *        The number of dimensions to add.
     *
     * @return a reference to {@code source} with {@code additionalDimensions} extra dimensions.
     */
    public static ByteTensor expand(ByteTensor source, int additionalDimensions) {
        return source.getReferenceTensor(ExpandingIndex.getStandardExpandingIndex(source.getIndex(),additionalDimensions));
    }

    /**
     *  Get a reference to a tensor with some of its dimensions collapsed. A dimension may be collapsed if it is of size
     *  one. Collapsing a tensor reduces its dimensionality without affecting the contents it holds.
     *
     * @param source
     *        The source tensor.
     *
     * @param dimensionsToCollapse
     *        The dimensions to collapse.
     *
     * @return a reference to {@code source} with dimensions {@code dimensionsToCollapse} collapsed.
     *
     * @throws IllegalArgumentException if any of {@code dimensionsToCollapse} are less than one or greater than the size
     *                                  of {@code source}, or if any of the dimensions in {@code dimensionsToCollapse}
     *                                  have a size greater than one.
     */
    @SuppressWarnings("unchecked") //don't care about index id type explicitly
    public static ByteTensor collapse(ByteTensor source, int ... dimensionsToCollapse) {
        return source.getReferenceTensor(new CollapsingIndex(source.getIndex(),true,dimensionsToCollapse));
    }

    /**
     *  Get a reference to a tensor with all of its collapsible dimensions collapsed. A dimension may be collapsed if it
     *  is of size one. Collapsing a tensor reduces its dimensionality without affecting the contents it holds.
     *
     * @param source
     *        The source tensor.
     *
     * @return a reference to {@code source} with all of its size-one dimensions collapsed.
     */
    @SuppressWarnings("unchecked") //don't care about index id type explicitly
    public static ByteTensor collapse(ByteTensor source) {
        return source.getReferenceTensor(new CollapsingIndex(source.getIndex()));
    }

    /**
     * Get a reference to a tensor with additional dimensions. That is, the returned tensor will refer to the source tensor
     * for its contents, but it will have extra dimensions (each of size one) added to its end. For example, adding two
     * dimensions to a scalar will yield a on-element matrix.
     *
     * @param source
     *        The source tensor.
     *
     * @param additionalDimensions
     *        The number of dimensions to add.
     *
     * @return a reference to {@code source} with {@code additionalDimensions} extra dimensions.
     */
    public static ShortTensor expand(ShortTensor source, int additionalDimensions) {
        return source.getReferenceTensor(ExpandingIndex.getStandardExpandingIndex(source.getIndex(),additionalDimensions));
    }

    /**
     *  Get a reference to a tensor with some of its dimensions collapsed. A dimension may be collapsed if it is of size
     *  one. Collapsing a tensor reduces its dimensionality without affecting the contents it holds.
     *
     * @param source
     *        The source tensor.
     *
     * @param dimensionsToCollapse
     *        The dimensions to collapse.
     *
     * @return a reference to {@code source} with dimensions {@code dimensionsToCollapse} collapsed.
     *
     * @throws IllegalArgumentException if any of {@code dimensionsToCollapse} are less than one or greater than the size
     *                                  of {@code source}, or if any of the dimensions in {@code dimensionsToCollapse}
     *                                  have a size greater than one.
     */
    @SuppressWarnings("unchecked") //don't care about index id type explicitly
    public static ShortTensor collapse(ShortTensor source, int ... dimensionsToCollapse) {
        return source.getReferenceTensor(new CollapsingIndex(source.getIndex(),true,dimensionsToCollapse));
    }

    /**
     *  Get a reference to a tensor with all of its collapsible dimensions collapsed. A dimension may be collapsed if it
     *  is of size one. Collapsing a tensor reduces its dimensionality without affecting the contents it holds.
     *
     * @param source
     *        The source tensor.
     *
     * @return a reference to {@code source} with all of its size-one dimensions collapsed.
     */
    @SuppressWarnings("unchecked") //don't care about index id type explicitly
    public static ShortTensor collapse(ShortTensor source) {
        return source.getReferenceTensor(new CollapsingIndex(source.getIndex()));
    }

    /**
     * Get a reference to a tensor with additional dimensions. That is, the returned tensor will refer to the source tensor
     * for its contents, but it will have extra dimensions (each of size one) added to its end. For example, adding two
     * dimensions to a scalar will yield a on-element matrix.
     *
     * @param source
     *        The source tensor.
     *
     * @param additionalDimensions
     *        The number of dimensions to add.
     *
     * @return a reference to {@code source} with {@code additionalDimensions} extra dimensions.
     */
    public static IntTensor expand(IntTensor source, int additionalDimensions) {
        return source.getReferenceTensor(ExpandingIndex.getStandardExpandingIndex(source.getIndex(),additionalDimensions));
    }

    /**
     *  Get a reference to a tensor with some of its dimensions collapsed. A dimension may be collapsed if it is of size
     *  one. Collapsing a tensor reduces its dimensionality without affecting the contents it holds.
     *
     * @param source
     *        The source tensor.
     *
     * @param dimensionsToCollapse
     *        The dimensions to collapse.
     *
     * @return a reference to {@code source} with dimensions {@code dimensionsToCollapse} collapsed.
     *
     * @throws IllegalArgumentException if any of {@code dimensionsToCollapse} are less than one or greater than the size
     *                                  of {@code source}, or if any of the dimensions in {@code dimensionsToCollapse}
     *                                  have a size greater than one.
     */
    @SuppressWarnings("unchecked") //don't care about index id type explicitly
    public static IntTensor collapse(IntTensor source, int ... dimensionsToCollapse) {
        return source.getReferenceTensor(new CollapsingIndex(source.getIndex(),true,dimensionsToCollapse));
    }

    /**
     *  Get a reference to a tensor with all of its collapsible dimensions collapsed. A dimension may be collapsed if it
     *  is of size one. Collapsing a tensor reduces its dimensionality without affecting the contents it holds.
     *
     * @param source
     *        The source tensor.
     *
     * @return a reference to {@code source} with all of its size-one dimensions collapsed.
     */
    @SuppressWarnings("unchecked") //don't care about index id type explicitly
    public static IntTensor collapse(IntTensor source) {
        return source.getReferenceTensor(new CollapsingIndex(source.getIndex()));
    }

    /**
     * Get a reference to a tensor with additional dimensions. That is, the returned tensor will refer to the source tensor
     * for its contents, but it will have extra dimensions (each of size one) added to its end. For example, adding two
     * dimensions to a scalar will yield a on-element matrix.
     *
     * @param source
     *        The source tensor.
     *
     * @param additionalDimensions
     *        The number of dimensions to add.
     *
     * @return a reference to {@code source} with {@code additionalDimensions} extra dimensions.
     */
    public static LongTensor expand(LongTensor source, int additionalDimensions) {
        return source.getReferenceTensor(ExpandingIndex.getStandardExpandingIndex(source.getIndex(),additionalDimensions));
    }

    /**
     *  Get a reference to a tensor with some of its dimensions collapsed. A dimension may be collapsed if it is of size
     *  one. Collapsing a tensor reduces its dimensionality without affecting the contents it holds.
     *
     * @param source
     *        The source tensor.
     *
     * @param dimensionsToCollapse
     *        The dimensions to collapse.
     *
     * @return a reference to {@code source} with dimensions {@code dimensionsToCollapse} collapsed.
     *
     * @throws IllegalArgumentException if any of {@code dimensionsToCollapse} are less than one or greater than the size
     *                                  of {@code source}, or if any of the dimensions in {@code dimensionsToCollapse}
     *                                  have a size greater than one.
     */
    @SuppressWarnings("unchecked") //don't care about index id type explicitly
    public static LongTensor collapse(LongTensor source, int ... dimensionsToCollapse) {
        return source.getReferenceTensor(new CollapsingIndex(source.getIndex(),true,dimensionsToCollapse));
    } 

    /**
     *  Get a reference to a tensor with all of its collapsible dimensions collapsed. A dimension may be collapsed if it
     *  is of size one. Collapsing a tensor reduces its dimensionality without affecting the contents it holds.
     *
     * @param source
     *        The source tensor.
     *
     * @return a reference to {@code source} with all of its size-one dimensions collapsed.
     */
    @SuppressWarnings("unchecked") //don't care about index id type explicitly
    public static LongTensor collapse(LongTensor source) {
        return source.getReferenceTensor(new CollapsingIndex(source.getIndex()));
    }

    /**
     * Get a reference to a tensor with additional dimensions. That is, the returned tensor will refer to the source tensor
     * for its contents, but it will have extra dimensions (each of size one) added to its end. For example, adding two
     * dimensions to a scalar will yield a on-element matrix.
     *
     * @param source
     *        The source tensor.
     *
     * @param additionalDimensions
     *        The number of dimensions to add.
     *
     * @return a reference to {@code source} with {@code additionalDimensions} extra dimensions.
     */
    public static FloatTensor expand(FloatTensor source, int additionalDimensions) {
        return source.getReferenceTensor(ExpandingIndex.getStandardExpandingIndex(source.getIndex(),additionalDimensions));
    }

    /**
     *  Get a reference to a tensor with some of its dimensions collapsed. A dimension may be collapsed if it is of size
     *  one. Collapsing a tensor reduces its dimensionality without affecting the contents it holds.
     *
     * @param source
     *        The source tensor.
     *
     * @param dimensionsToCollapse
     *        The dimensions to collapse.
     *
     * @return a reference to {@code source} with dimensions {@code dimensionsToCollapse} collapsed.
     *
     * @throws IllegalArgumentException if any of {@code dimensionsToCollapse} are less than one or greater than the size
     *                                  of {@code source}, or if any of the dimensions in {@code dimensionsToCollapse}
     *                                  have a size greater than one.
     */
    @SuppressWarnings("unchecked") //don't care about index id type explicitly
    public static FloatTensor collapse(FloatTensor source, int ... dimensionsToCollapse) {
        return source.getReferenceTensor(new CollapsingIndex(source.getIndex(),true,dimensionsToCollapse));
    }

    /**
     *  Get a reference to a tensor with all of its collapsible dimensions collapsed. A dimension may be collapsed if it
     *  is of size one. Collapsing a tensor reduces its dimensionality without affecting the contents it holds.
     *
     * @param source
     *        The source tensor.
     *
     * @return a reference to {@code source} with all of its size-one dimensions collapsed.
     */
    @SuppressWarnings("unchecked") //don't care about index id type explicitly
    public static FloatTensor collapse(FloatTensor source) {
        return source.getReferenceTensor(new CollapsingIndex(source.getIndex()));
    }

    /**
     * Get a reference to a tensor with additional dimensions. That is, the returned tensor will refer to the source tensor
     * for its contents, but it will have extra dimensions (each of size one) added to its end. For example, adding two
     * dimensions to a scalar will yield a on-element matrix.
     *
     * @param source
     *        The source tensor.
     *
     * @param additionalDimensions
     *        The number of dimensions to add.
     *
     * @return a reference to {@code source} with {@code additionalDimensions} extra dimensions.
     */
    public static DoubleTensor expand(DoubleTensor source, int additionalDimensions) {
        return source.getReferenceTensor(ExpandingIndex.getStandardExpandingIndex(source.getIndex(),additionalDimensions));
    }

    /**
     *  Get a reference to a tensor with some of its dimensions collapsed. A dimension may be collapsed if it is of size
     *  one. Collapsing a tensor reduces its dimensionality without affecting the contents it holds.
     *
     * @param source
     *        The source tensor.
     *
     * @param dimensionsToCollapse
     *        The dimensions to collapse.
     *
     * @return a reference to {@code source} with dimensions {@code dimensionsToCollapse} collapsed.
     *
     * @throws IllegalArgumentException if any of {@code dimensionsToCollapse} are less than one or greater than the size
     *                                  of {@code source}, or if any of the dimensions in {@code dimensionsToCollapse}
     *                                  have a size greater than one.
     */
    @SuppressWarnings("unchecked") //don't care about index id type explicitly
    public static DoubleTensor collapse(DoubleTensor source, int ... dimensionsToCollapse) {
        return source.getReferenceTensor(new CollapsingIndex(source.getIndex(),true,dimensionsToCollapse));
    }

    /**
     *  Get a reference to a tensor with all of its collapsible dimensions collapsed. A dimension may be collapsed if it
     *  is of size one. Collapsing a tensor reduces its dimensionality without affecting the contents it holds.
     *
     * @param source
     *        The source tensor.
     *
     * @return a reference to {@code source} with all of its size-one dimensions collapsed.
     */
    @SuppressWarnings("unchecked") //don't care about index id type explicitly
    public static DoubleTensor collapse(DoubleTensor source) {
        return source.getReferenceTensor(new CollapsingIndex(source.getIndex()));
    }

    /**
     * Get a reference to a tensor with additional dimensions. That is, the returned tensor will refer to the source tensor
     * for its contents, but it will have extra dimensions (each of size one) added to its end. For example, adding two
     * dimensions to a scalar will yield a on-element matrix.
     *
     * @param source
     *        The source tensor.
     *
     * @param additionalDimensions
     *        The number of dimensions to add.
     *
     * @param <T>
     *        The type held by the tensors.
     *
     * @return a reference to {@code source} with {@code additionalDimensions} extra dimensions.
     */
    public static <T> Tensor<T> expand(Tensor<T> source, int additionalDimensions) {
        return source.getReferenceTensor(ExpandingIndex.getStandardExpandingIndex(source.getIndex(),additionalDimensions));
    }

    /**
     *  Get a reference to a tensor with some of its dimensions collapsed. A dimension may be collapsed if it is of size
     *  one. Collapsing a tensor reduces its dimensionality without affecting the contents it holds.
     *
     * @param source
     *        The source tensor.
     *
     * @param dimensionsToCollapse
     *        The dimensions to collapse.
     *
     * @param <T>
     *        The type held by the tensors.
     *
     * @return a reference to {@code source} with dimensions {@code dimensionsToCollapse} collapsed.
     *
     * @throws IllegalArgumentException if any of {@code dimensionsToCollapse} are less than one or greater than the size
     *                                  of {@code source}, or if any of the dimensions in {@code dimensionsToCollapse}
     *                                  have a size greater than one.
     */
    @SuppressWarnings("unchecked") //don't care about index id type explicitly
    public static <T> Tensor<T> collapse(Tensor<T> source, int ... dimensionsToCollapse) {
        return source.getReferenceTensor(new CollapsingIndex(source.getIndex(),true,dimensionsToCollapse));
    }  

    /**
     *  Get a reference to a tensor with all of its collapsible dimensions collapsed. A dimension may be collapsed if it
     *  is of size one. Collapsing a tensor reduces its dimensionality without affecting the contents it holds.
     *
     * @param source
     *        The source tensor.
     *
     * @param <T>
     *        The type held by the tensors.
     *
     * @return a reference to {@code source} with all of its size-one dimensions collapsed.
     */
    @SuppressWarnings("unchecked") //don't care about index id type explicitly
    public static <T> Tensor<T> collapse(Tensor<T> source) {
        return source.getReferenceTensor(new CollapsingIndex(source.getIndex()));
    }

    //////////////////////////special/////////////////////////////

    /**
     * Get an identity tensor of the specified dimensionality.
     *
     * @param dimensions
     *        The number of dimensions in the identity tensor.
     *
     * @param size
     *        The length of each dimension in the identity tensor.
     *
     * @return an identity tensor with {@code dimensions} dimensions of size {@code size}.
     */
    public static IntTensor identityTensor(int dimensions, int size) {
        return NumericTensor.identityTensor(dimensions,size);
    }
    
    /////////////////////////simple array to tensor transformations//////////////////////

    /**
     * Get a matrix version of a {@code byte} array. The matrix will hold copies of the values in the array, and will
     * not maintain a reference to it once constructed.
     *
     * @param factory
     *        The tensor factory used to build the matrix.
     *
     * @param values
     *        The values for the matrix. It is assumed that this will be a rectangular array, and this assumption is not
     *        verified/checked by this method.
     *
     * @return a matrix version of {@code values}.
     */
    public static ByteMatrix arrayToMatrix(TensorFactory factory, byte[][] values) {
        ByteMatrix m = factory.byteMatrix(values.length, values[0].length);
        m.setTensorValues(new ByteTypeSafeArray(values));
        return m;
    }

    /**
     * Get a vector version of a {@code byte} array. The vector will hold copies of the values in the array, and will
     * not maintain a reference to it once constructed.
     *
     * @param factory
     *        The tensor factory used to build the vector.
     *
     * @param values
     *        The values for the vector.
     *
     * @return a vector version of {@code values}.
     */
    public static ByteVector arrayToVector(TensorFactory factory, byte[] values) {
        ByteVector v = factory.byteVector(values.length);
        v.setTensorValues(new ByteTypeSafeArray(values));
        return v;
    }

    /**
     * Get a tensor version of a {@code byte} array. The tensor will hold copies of the values in the array, and will
     * not maintain a reference to it once constructed.
     *
     * @param factory
     *        The tensor factory used to build the tensor.
     *
     * @param values
     *        The values for the tensor. It is assumed that this will be a rectangular array, and this assumption is not
     *        verified/checked by this method.
     *
     * @return a tensor version of {@code values}.
     *
     * @throws IllegalArgumentException if {@code values} is not an array, or its base component type is not {@code byte};
     */
    public static ByteTensor byteArrayToTensor(TensorFactory factory, Object values) {
        if (ArrayUtil.getBaseComponentType(values) != byte.class)
            throw new IllegalArgumentException("Values is not a byte array, but a " + ArrayUtil.getBaseComponentType(values) + " array.");
        ByteTensor t = factory.byteTensor(ArrayUtil.getDimensions(values));
        t.setTensorValues(new ByteTypeSafeArray(values));
        return t;
    }

    /**
     * Get a matrix version of a {@code short} array. The matrix will hold copies of the values in the array, and will
     * not maintain a reference to it once constructed.
     *
     * @param factory
     *        The tensor factory used to build the matrix.
     *
     * @param values
     *        The values for the matrix. It is assumed that this will be a rectangular array, and this assumption is not
     *        verified/checked by this method.
     *
     * @return a matrix version of {@code values}.
     */
    public static ShortMatrix arrayToMatrix(TensorFactory factory, short[][] values) {
        ShortMatrix m = factory.shortMatrix(values.length, values[0].length);
        m.setTensorValues(new ShortTypeSafeArray(values));
        return m;
    }

    /**
     * Get a vector version of a {@code short} array. The vector will hold copies of the values in the array, and will
     * not maintain a reference to it once constructed.
     *
     * @param factory
     *        The tensor factory used to build the vector.
     *
     * @param values
     *        The values for the vector.
     *
     * @return a vector version of {@code values}.
     */
    public static ShortVector arrayToVector(TensorFactory factory, short[] values) {
        ShortVector v = factory.shortVector(values.length);
        v.setTensorValues(new ShortTypeSafeArray(values));
        return v;
    }

    /**
     * Get a tensor version of a {@code short} array. The tensor will hold copies of the values in the array, and will
     * not maintain a reference to it once constructed.
     *
     * @param factory
     *        The tensor factory used to build the tensor.
     *
     * @param values
     *        The values for the tensor. It is assumed that this will be a rectangular array, and this assumption is not
     *        verified/checked by this method.
     *
     * @return a tensor version of {@code values}.
     *
     * @throws IllegalArgumentException if {@code values} is not an array, or its base component type is not {@code short};
     */
    public static ShortTensor shortArrayToTensor(TensorFactory factory, Object values) {
        if (ArrayUtil.getBaseComponentType(values) != short.class)
            throw new IllegalArgumentException("Values is not a short array, but a " + ArrayUtil.getBaseComponentType(values) + " array.");
        ShortTensor t = factory.shortTensor(ArrayUtil.getDimensions(values));
        t.setTensorValues(new ShortTypeSafeArray(values));
        return t;
    }

    /**
     * Get a matrix version of an {@code int} array. The matrix will hold copies of the values in the array, and will
     * not maintain a reference to it once constructed.
     *
     * @param factory
     *        The tensor factory used to build the matrix.
     *
     * @param values
     *        The values for the matrix. It is assumed that this will be a rectangular array, and this assumption is not
     *        verified/checked by this method.
     *
     * @return a matrix version of {@code values}.
     */
    public static IntMatrix arrayToMatrix(TensorFactory factory, int[][] values) {
        IntMatrix m = factory.intMatrix(values.length, values[0].length);
        m.setTensorValues(new IntTypeSafeArray(values));
        return m;
    }

    /**
     * Get a vector version of an {@code int} array. The vector will hold copies of the values in the array, and will
     * not maintain a reference to it once constructed.
     *
     * @param factory
     *        The tensor factory used to build the vector.
     *
     * @param values
     *        The values for the vector.
     *
     * @return a vector version of {@code values}.
     */
    public static IntVector arrayToVector(TensorFactory factory, int[] values) {
        IntVector v = factory.intVector(values.length);
        v.setTensorValues(new IntTypeSafeArray(values));
        return v;
    }

    /**
     * Get a tensor version of an {@code int} array. The tensor will hold copies of the values in the array, and will
     * not maintain a reference to it once constructed.
     *
     * @param factory
     *        The tensor factory used to build the tensor.
     *
     * @param values
     *        The values for the tensor. It is assumed that this will be a rectangular array, and this assumption is not
     *        verified/checked by this method.
     *
     * @return a tensor version of {@code values}.
     *
     * @throws IllegalArgumentException if {@code values} is not an array, or its base component type is not {@code int};
     */
    public static IntTensor intArrayToTensor(TensorFactory factory, Object values) {
        if (ArrayUtil.getBaseComponentType(values) != int.class)
            throw new IllegalArgumentException("Values is not an int array, but a " + ArrayUtil.getBaseComponentType(values) + " array.");
        IntTensor t = factory.intTensor(ArrayUtil.getDimensions(values));
        t.setTensorValues(new IntTypeSafeArray(values));
        return t;
    }

    /**
     * Get a matrix version of a {@code long} array. The matrix will hold copies of the values in the array, and will
     * not maintain a reference to it once constructed.
     *
     * @param factory
     *        The tensor factory used to build the matrix.
     *
     * @param values
     *        The values for the matrix. It is assumed that this will be a rectangular array, and this assumption is not
     *        verified/checked by this method.
     *
     * @return a matrix version of {@code values}.
     */
    public static LongMatrix arrayToMatrix(TensorFactory factory, long[][] values) {
        LongMatrix m = factory.longMatrix(values.length, values[0].length);
        m.setTensorValues(new LongTypeSafeArray(values));
        return m;
    }

    /**
     * Get a vector version of a {@code long} array. The vector will hold copies of the values in the array, and will
     * not maintain a reference to it once constructed.
     *
     * @param factory
     *        The tensor factory used to build the vector.
     *
     * @param values
     *        The values for the vector.
     *
     * @return a vector version of {@code values}.
     */
    public static LongVector arrayToVector(TensorFactory factory, long[] values) {
        LongVector v = factory.longVector(values.length);
        v.setTensorValues(new LongTypeSafeArray(values));
        return v;
    }

    /**
     * Get a tensor version of a {@code long} array. The tensor will hold copies of the values in the array, and will
     * not maintain a reference to it once constructed.
     *
     * @param factory
     *        The tensor factory used to build the tensor.
     *
     * @param values
     *        The values for the tensor. It is assumed that this will be a rectangular array, and this assumption is not
     *        verified/checked by this method.
     *
     * @return a tensor version of {@code values}.
     *
     * @throws IllegalArgumentException if {@code values} is not an array, or its base component type is not {@code long};
     */
    public static LongTensor longArrayToTensor(TensorFactory factory, Object values) {
        if (ArrayUtil.getBaseComponentType(values) != long.class)
            throw new IllegalArgumentException("Values is not a long array, but a " + ArrayUtil.getBaseComponentType(values) + " array.");
        LongTensor t = factory.longTensor(ArrayUtil.getDimensions(values));
        t.setTensorValues(new LongTypeSafeArray(values));
        return t;
    }

    /**
     * Get a matrix version of a {@code float} array. The matrix will hold copies of the values in the array, and will
     * not maintain a reference to it once constructed.
     *
     * @param factory
     *        The tensor factory used to build the matrix.
     *
     * @param values
     *        The values for the matrix. It is assumed that this will be a rectangular array, and this assumption is not
     *        verified/checked by this method.
     *
     * @return a matrix version of {@code values}.
     */
    public static FloatMatrix arrayToMatrix(TensorFactory factory, float[][] values) {
        FloatMatrix m = factory.floatMatrix(values.length, values[0].length);
        m.setTensorValues(new FloatTypeSafeArray(values));
        return m;
    }

    /**
     * Get a vector version of a {@code float} array. The vector will hold copies of the values in the array, and will
     * not maintain a reference to it once constructed.
     *
     * @param factory
     *        The tensor factory used to build the vector.
     *
     * @param values
     *        The values for the vector.
     *
     * @return a vector version of {@code values}.
     */
    public static FloatVector arrayToVector(TensorFactory factory, float[] values) {
        FloatVector v = factory.floatVector(values.length);
        v.setTensorValues(new FloatTypeSafeArray(values));
        return v;
    }

    /**
     * Get a tensor version of a {@code float} array. The tensor will hold copies of the values in the array, and will
     * not maintain a reference to it once constructed.
     *
     * @param factory
     *        The tensor factory used to build the tensor.
     *
     * @param values
     *        The values for the tensor. It is assumed that this will be a rectangular array, and this assumption is not
     *        verified/checked by this method.
     *
     * @return a tensor version of {@code values}.
     *
     * @throws IllegalArgumentException if {@code values} is not an array, or its base component type is not {@code float};
     */
    public static FloatTensor floatArrayToTensor(TensorFactory factory, Object values) {
        if (ArrayUtil.getBaseComponentType(values) != float.class)
            throw new IllegalArgumentException("Values is not a float array, but a " + ArrayUtil.getBaseComponentType(values) + " array.");
        FloatTensor t = factory.floatTensor(ArrayUtil.getDimensions(values));
        t.setTensorValues(new FloatTypeSafeArray(values));
        return t;
    }

    /**
     * Get a matrix version of a {@code double} array. The matrix will hold copies of the values in the array, and will
     * not maintain a reference to it once constructed.
     *
     * @param factory
     *        The tensor factory used to build the matrix.
     *
     * @param values
     *        The values for the matrix. It is assumed that this will be a rectangular array, and this assumption is not
     *        verified/checked by this method.
     *
     * @return a matrix version of {@code values}.
     */
    public static DoubleMatrix arrayToMatrix(TensorFactory factory, double[][] values) {
        DoubleMatrix m = factory.doubleMatrix(values.length, values[0].length);
        m.setTensorValues(new DoubleTypeSafeArray(values));
        return m;
    }

    /**
     * Get a vector version of a {@code double} array. The vector will hold copies of the values in the array, and will
     * not maintain a reference to it once constructed.
     *
     * @param factory
     *        The tensor factory used to build the vector.
     *
     * @param values
     *        The values for the vector.
     *
     * @return a vector version of {@code values}.
     */
    public static DoubleVector arrayToVector(TensorFactory factory, double[] values) {
        DoubleVector v = factory.doubleVector(values.length);
        v.setTensorValues(new DoubleTypeSafeArray(values));
        return v;
    }

    /**
     * Get a tensor version of a {@code double} array. The tensor will hold copies of the values in the array, and will
     * not maintain a reference to it once constructed.
     *
     * @param factory
     *        The tensor factory used to build the tensor.
     *
     * @param values
     *        The values for the tensor. It is assumed that this will be a rectangular array, and this assumption is not
     *        verified/checked by this method.
     *
     * @return a tensor version of {@code values}.
     *
     * @throws IllegalArgumentException if {@code values} is not an array, or its base component type is not {@code double};
     */
    public static DoubleTensor doubleArrayToTensor(TensorFactory factory, Object values) {
        if (ArrayUtil.getBaseComponentType(values) != double.class)
            throw new IllegalArgumentException("Values is not a double array, but a " + ArrayUtil.getBaseComponentType(values) + " array.");
        DoubleTensor t = factory.doubleTensor(ArrayUtil.getDimensions(values));
        t.setTensorValues(new DoubleTypeSafeArray(values));
        return t;
    }

    /**
     * Get a matrix version of a {@code char} array. The matrix will hold copies of the values in the array, and will
     * not maintain a reference to it once constructed.
     *
     * @param factory
     *        The tensor factory used to build the matrix.
     *
     * @param values
     *        The values for the matrix. It is assumed that this will be a rectangular array, and this assumption is not
     *        verified/checked by this method.
     *
     * @return a matrix version of {@code values}.
     */
    public static CharMatrix arrayToMatrix(TensorFactory factory, char[][] values) {
        CharMatrix m = factory.charMatrix(values.length, values[0].length);
        m.setTensorValues(new CharTypeSafeArray(values));
        return m;
    }

    /**
     * Get a vector version of a {@code char} array. The vector will hold copies of the values in the array, and will
     * not maintain a reference to it once constructed.
     *
     * @param factory
     *        The tensor factory used to build the vector.
     *
     * @param values
     *        The values for the vector.
     *
     * @return a vector version of {@code values}.
     */
    public static CharVector arrayToVector(TensorFactory factory, char[] values) {
        CharVector v = factory.charVector(values.length);
        v.setTensorValues(new CharTypeSafeArray(values));
        return v;
    }

    /**
     * Get a tensor version of a {@code char} array. The tensor will hold copies of the values in the array, and will
     * not maintain a reference to it once constructed.
     *
     * @param factory
     *        The tensor factory used to build the tensor.
     *
     * @param values
     *        The values for the tensor. It is assumed that this will be a rectangular array, and this assumption is not
     *        verified/checked by this method.
     *
     * @return a tensor version of {@code values}.
     *
     * @throws IllegalArgumentException if {@code values} is not an array, or its base component type is not {@code char}.
     */
    public static CharTensor charArrayToTensor(TensorFactory factory, Object values) {
        if (ArrayUtil.getBaseComponentType(values) != char.class)
            throw new IllegalArgumentException("Values is not a char array, but a " + ArrayUtil.getBaseComponentType(values) + " array.");
        CharTensor t = factory.charTensor(ArrayUtil.getDimensions(values));
        t.setTensorValues(new CharTypeSafeArray(values));
        return t;
    }

    /**
     * Get a matrix version of a {@code boolean} array. The matrix will hold copies of the values in the array, and will
     * not maintain a reference to it once constructed.
     *
     * @param factory
     *        The tensor factory used to build the matrix.
     *
     * @param values
     *        The values for the matrix. It is assumed that this will be a rectangular array, and this assumption is not
     *        verified/checked by this method.
     *
     * @return a matrix version of {@code values}.
     */
    public static BooleanMatrix arrayToMatrix(TensorFactory factory, boolean[][] values) {
        BooleanMatrix m = factory.booleanMatrix(values.length, values[0].length);
        m.setTensorValues(new BooleanTypeSafeArray(values));
        return m;
    }

    /**
     * Get a vector version of a {@code boolean} array. The vector will hold copies of the values in the array, and will
     * not maintain a reference to it once constructed.
     *
     * @param factory
     *        The tensor factory used to build the vector.
     *
     * @param values
     *        The values for the vector.
     *
     * @return a vector version of {@code values}.
     */
    public static BooleanVector arrayToVector(TensorFactory factory, boolean[] values) {
        BooleanVector v = factory.booleanVector(values.length);
        v.setTensorValues(new BooleanTypeSafeArray(values));
        return v;
    }

    /**
     * Get a tensor version of a {@code boolean} array. The tensor will hold copies of the values in the array, and will
     * not maintain a reference to it once constructed.
     *
     * @param factory
     *        The tensor factory used to build the tensor.
     *
     * @param values
     *        The values for the tensor. It is assumed that this will be a rectangular array, and this assumption is not
     *        verified/checked by this method.
     *
     * @return a tensor version of {@code values}.
     *
     * @throws IllegalArgumentException if {@code values} is not an array, or its base component type is not {@code boolean}.
     */
    public static BooleanTensor booleanArrayToTensor(TensorFactory factory, Object values) {
        if (ArrayUtil.getBaseComponentType(values) != boolean.class)
            throw new IllegalArgumentException("Values is not a boolean array, but a " + ArrayUtil.getBaseComponentType(values) + " array.");
        BooleanTensor t = factory.booleanTensor(ArrayUtil.getDimensions(values));
        t.setTensorValues(new BooleanTypeSafeArray(values));
        return t;
    }

    /**
     * Get a matrix version of an array. The matrix will hold copies of the values in the array, and will
     * not maintain a reference to it (the array) once constructed.
     *
     * @param factory
     *        The tensor factory used to build the matrix.
     *
     * @param values
     *        The values for the matrix. It is assumed that this will be a rectangular array, and this assumption is not
     *        verified/checked by this method.
     *
     * @param <T>
     *        The type held by the array and matrix.
     *
     * @return a matrix version of {@code values}.
     */
    @SuppressWarnings("unchecked") //should be ok here, we are introspecting into array, but typing should be ok as it is applied
    public static <T> Matrix<T> arrayToMatrix(TensorFactory factory, T[][] values) {
        Matrix<T> m = factory.matrix(values.length, values[0].length);
        m.setTensorValues(new ObjectTypeSafeArray<T>(values,(Class<T>) values.getClass().getComponentType().getComponentType()));
        return m;
    }

    /**
     * Get a vector version of an array. The vector will hold copies of the values in the array, and will
     * not maintain a reference to it once constructed.
     *
     * @param factory
     *        The tensor factory used to build the vector.
     *
     * @param values
     *        The values for the vector.
     *
     * @param <T>
     *        The type held by the array and vector.
     *
     * @return a vector version of {@code values}.
     */
    @SuppressWarnings("unchecked") //should be ok here, we are introspecting into array, but typing should be ok as it is applied
    public static <T> com.pb.sawdust.tensor.alias.vector.Vector<T> arrayToVector(TensorFactory factory, T[] values) {
        com.pb.sawdust.tensor.alias.vector.Vector<T> v = factory.vector(values.length);
        v.setTensorValues(new ObjectTypeSafeArray<T>(values,(Class<T>) values.getClass().getComponentType()));
        return v;
    }

    /**
     * Get a tensor version of an array. The tensor will hold copies of the values in the array, and will
     * not maintain a reference to it once constructed.
     *
     * @param factory
     *        The tensor factory used to build the tensor.
     *
     * @param values
     *        The values for the tensor. It is assumed that this will be a rectangular array, and this assumption is not
     *        verified/checked by this method.
     *
     * @param <T>
     *        The type held by the array and vector.
     *
     * @return a tensor version of {@code values}.
     *
     * @throws IllegalArgumentException if {@code values} is not an array.
     */
    @SuppressWarnings("unchecked") //should be ok here, we are introspecting into array, but typing should be ok as it is applied
    public static <T> Tensor<T> arrayToTensor(TensorFactory factory, Object values) {
        Tensor<T> t = factory.tensor(ArrayUtil.getDimensions(values));
        t.setTensorValues(new ObjectTypeSafeArray<T>(values,(Class<T>) values.getClass().getComponentType()));
        return t;
    }

    ///////////////////////////to string methods////////////////////////

    private static String scalarToString(Tensor<?> tensor, TextFormat format) {
        return "<" + format.format(tensor.getValue()).trim() + ">";
    }

    private static String vectorToString(Tensor<?> tensor, TextFormat format, int maxEntries) {
        StringBuilder st = new StringBuilder("[");
        int size = tensor.size(0);
        if (size > maxEntries) {
            int halfEntries = (maxEntries >>> 1) - 1;
            for (int i : range(halfEntries)) {
                if (i > 0)
                    st.append(",");
                st.append(format.format(tensor.getValue(i)));
            }
            st.append("   ...   ");
            int endStart = size - halfEntries;
            for (int i : range(endStart,size)) {
                if (i > endStart)
                    st.append(",");
                st.append(format.format(tensor.getValue(i)));
            }
        } else {
            for (int i : range(size)) {
                if (i > 0)
                    st.append(",");
                st.append(format.format(tensor.getValue(i)));
            }
        }
        return st.append("]").toString();
    }

    @SuppressWarnings("unchecked") //index/Tensor<?> call is ok, because we don't care about types here
    private static String matrixToString(Tensor<?> tensor, TextFormat format, int offset, int maxEntries) {
        StringBuilder st = new StringBuilder("[");
        int counter = 0;
        boolean tooBig = maxEntries < tensor.size(0);
        int halfEntries = (maxEntries >>> 1) - 1;
        Iterator it = TensorImplUtil.getIndexIterator(tensor.getIndex(),0);
        while (it.hasNext()) {
            if (tooBig && counter >= halfEntries) {
                if (counter == halfEntries+1) {
                    st.append("\n ");
                    for (int i : range(offset))
                        st.append(" ");
                    st.append("  ...  ");
                }
                it.next();
                if (counter++ == tensor.size(0)-halfEntries-1) {
                    counter = 0;
                    st.append("\n ");
                    for (int i : range(offset))
                        st.append(" ");
                }
                continue;
            }
            Tensor<?> t = tensor.getReferenceTensor((Index) it.next());
            if (counter++ > 0) {
                st.append("\n ");
                for (int i : range(offset))
                    st.append(" ");
            }
            st.append(vectorToString(t,format,maxEntries));
        }
        return st.append("]").toString();
    }

    private static String tensorToString(Tensor<?> tensor, TextFormat format, int maxEntries) {
        return tensorToString(tensor,format,1,maxEntries);
    }

    private static String tensorToString(Tensor<?> tensor, TextFormat format, int offset, int maxEntries) {
        int size = tensor.size();
        switch (size) {
            case 0 : return scalarToString(tensor,format);
            case 1 : return vectorToString(tensor,format,maxEntries);
            case 2 : return matrixToString(tensor,format,0,maxEntries);
            default : {
                boolean tooBig = maxEntries < tensor.size(0);
                int halfEntries = (maxEntries >>> 1) - 1;
                StringBuilder st = new StringBuilder("[");
                int counter = 0;
                for (Tensor<?> t : tensor) {
                    if (tooBig && counter >= halfEntries) {
                        if (counter == halfEntries+1) {
                            st.append("\n ");
                            for (int i : range(offset))
                                st.append(" ");
                            st.append("  ...  ");
                        }
                        if (counter++ == tensor.size(0)-halfEntries-1) {
                            counter = 0;
                            st.append("\n ");
                            for (int i : range(offset-1))
                                st.append(" ");
                        }
                        continue;
                    }
                    if (counter++ > 0) {
                        st.append("\n");
                        for (int i : range(offset))
                            st.append(" ");
                    }
                    if (size == 3)
                        st.append(matrixToString(t,format,offset,maxEntries));
                    else
                        st.append(tensorToString(t,format,offset+1,maxEntries));
                }
                return st.append("]").toString();
            }
        }
    }

    private static final int DEFAULT_MAX_TO_STRING_ENTRIES = 10;

    /**
     * Get a simple, formatted string version of a tensor.
     *
     * @param tensor
     *        The tensor.
     *
     * @param format
     *        The format to use for the entries.
     *
     * @param maxEntries
     *        The maximum number of entries to display for each dimension.
     *
     * @return a formatted string representation of {@code tensor}.
     */
    public static String toString(Tensor<?> tensor, TextFormat format, int maxEntries) {
        return tensorToString(tensor,format,maxEntries);
    }

    /**
     * Get a simple, formatted string version of a tensor, displaying a default maximum number of entries for each dimension.
     *
     * @param tensor
     *        The tensor.
     *
     * @param format
     *        The format to use for the entries.
     *
     * @return a formatted string representation of {@code tensor}.
     */
    public static String toString(Tensor<?> tensor, TextFormat format) {
        return toString(tensor,format,DEFAULT_MAX_TO_STRING_ENTRIES);
    }

    /**
     * Get a simple string version of a tensor using a default text format for the entries.
     *
     * @param tensor
     *        The tensor.
     *
     * @param maxEntries
     *        The maximum number of entries to display for each dimension.
     *
     * @return a formatted string representation of {@code tensor}.
     */
    @SuppressWarnings("unchecked") //Tensor<Number> casts are actually incorrect, but are ok here and in the spirit of what we want
    public static String toString(Tensor<?> tensor, int maxEntries) {
        switch (tensor.getType()) {
            case BYTE :
            case SHORT :
            case INT :
            case LONG : return toStringIntegral((Tensor<Number>) tensor,maxEntries);
            case FLOAT :
            case DOUBLE: return toStringDecimal((Tensor<Number>) tensor,maxEntries);
            default : return toString(tensor,new TextFormat(TextFormat.Conversion.STRING),maxEntries);
        }
    }

    /**
     * Get a simple string version of a tensor, displaying a default maximum number of entries for each dimension and
     * using a default text format for the entries.
     *
     * @param tensor
     *        The tensor.
     *
     * @return a formatted string representation of {@code tensor}.
     */
    public static String toString(Tensor<?> tensor) {
        return toString(tensor,DEFAULT_MAX_TO_STRING_ENTRIES);
    }

    private static String toStringDecimal(Tensor<? extends Number> tensor, int maxEntries) {
        //return toString(tensor,new TextFormat(TextFormat.Conversion.FLOATING_POINT_OR_SCIENTIFIC,8,3));
        return toString(tensor,new TextFormat(TextFormat.Conversion.FLOATING_POINT_OR_SCIENTIFIC,11,5),maxEntries);
    }

    private static String toStringIntegral(Tensor<? extends Number> tensor, int maxEntries) {
        return toString(tensor,new TextFormat(TextFormat.Conversion.INTEGER,5),maxEntries);
    }

    ///////////////////test id to string
    private static String vectorToStringWithIds(Tensor<?> tensor, TextFormat format, int maxEntries) {
        StringBuilder st = new StringBuilder("[");
        int size = tensor.size(0);
        if (size > maxEntries) {
            int halfEntries = (maxEntries >>> 1) - 1;
            for (int i : range(halfEntries)) {
                if (i > 0)
                    st.append(",");
                st.append(format.format(tensor.getValue(i)));
            }
            st.append("   ...   ");
            int endStart = size - halfEntries;
            for (int i : range(endStart,size)) {
                if (i > endStart)
                    st.append(",");
                st.append(format.format(tensor.getValue(i)));
            }
        } else {
            for (int i : range(size)) {
                if (i > 0)
                    st.append(",");
                st.append(format.format(tensor.getValue(i)));
            }
        }
        return st.append("]").toString();
    }

    private static String vectorIdsToString(List<?> ids, int maxEntries, int offset, TextFormat idFormat) {
        StringBuilder st = new StringBuilder("");
        for (int i : range(offset))
            st.append(" ");
        int size = ids.size();
        if (size > maxEntries) {
            int halfEntries = (maxEntries >>> 1) - 1;
            for (int i : range(halfEntries)) {
//                if (i > 0)
//                    st.append(" ");
                st.append("(").append(exactSize(ids.get(i),idFormat)).append(")");
            }
            st.append("  ...   ");
            int endStart = size - halfEntries;
            for (int i : range(endStart,size)) {
//                if (i > endStart)
//                    st.append(" ");
                st.append("(").append(exactSize(ids.get(i),idFormat)).append(")");
            }
        } else {
            for (int i : range(size)) {
//                if (i > 0)
//                    st.append(" ");
                st.append("(").append(exactSize(ids.get(i),idFormat)).append(")");
            }
        }
        return st.toString();
    }

    private static String matrixToStringWithIds(Tensor<?> tensor, TextFormat format, int offset, int maxEntries) {
        return matrixToStringWithIds(tensor,format,offset,maxEntries,false);
    }

    @SuppressWarnings("unchecked") //index/Tensor<?> call is ok, because we don't care about types here
    private static String matrixToStringWithIds(Tensor<?> tensor, TextFormat format, int offset, int maxEntries, boolean headIds) {
        List<? extends List<?>> ids = tensor.getIndex().getIndexIds();
        int counter = 0;
        boolean tooBig = maxEntries < tensor.size(0);
        int halfEntries = (maxEntries >>> 1) - 1;
        Iterator it = TensorImplUtil.getIndexIterator(tensor.getIndex(),0);
        Iterator idIt = ids.get(0).iterator();
        TextFormat idFormat = new TextFormat(TextFormat.Conversion.STRING,format.getMinimumWidth()-1);
        StringBuilder st = new StringBuilder(headIds ? vectorIdsToString(ids.get(1),maxEntries,offset+3+format.getMinimumWidth(),idFormat) + "\n" : "");
        for (int i : range(offset))
            st.append(" ");
        st.append("[");
        while (it.hasNext()) {
            Object id = idIt.next();
            if (tooBig && counter >= halfEntries) {
                if (counter == halfEntries+1) {
                    st.append("\n ");
                    for (int i : range(offset))
                        st.append(" ");
                    st.append("  ...  ");
                }
                it.next();
                if (counter++ == tensor.size(0)-halfEntries-1) {
                    counter = 0;
                    st.append("\n ");
                    for (int i : range(offset))
                        st.append(" ");
                }
                continue;
            }
            Tensor<?> t = tensor.getReferenceTensor((Index) it.next());
            if (counter++ > 0) {
                st.append("\n ");
                for (int i : range(offset))
                    st.append(" ");
            }
            st.append("(").append(exactSize(id,idFormat)).append(") ").append(vectorToString(t, format, maxEntries));
        }
        return st.append("]").toString();
    }

    private static String exactSize(Object input, TextFormat format) {
        String out = format.format(input);
        if (out.length() > format.getMinimumWidth())
            out = out.substring(0,format.getMinimumWidth()-3) + "...";
        return out;
    }

    private static String tensorToStringWithIds(Tensor<?> tensor, TextFormat format, int maxEntries, boolean headIds) {
        return tensorToStringWithIds(tensor, format, 1, maxEntries,headIds);
    }

    private static String tensorToStringWithIds(Tensor<?> tensor, TextFormat format, int offset, int maxEntries) {
        return tensorToStringWithIds(tensor,format,offset,maxEntries,false);
    }

    private static String tensorToStringWithIds(Tensor<?> tensor, TextFormat format, int offset, int maxEntries, boolean headIds) {
        return tensorToStringWithIds(tensor,format,offset,maxEntries,headIds,null);
    }

    private static String tensorToStringWithIds(Tensor<?> tensor, TextFormat format, int offset, int maxEntries, boolean headIds, Object id) {
        int size = tensor.size();
        switch (size) {
            case 0 : return scalarToString(tensor,format);
            case 1 : return vectorToStringWithIds(tensor,format,maxEntries);
            case 2 : return matrixToStringWithIds(tensor,format,0,maxEntries,headIds);
            default : {
                boolean tooBig = maxEntries < tensor.size(0);
                int halfEntries = (maxEntries >>> 1) - 1;
                //StringBuilder st = new StringBuilder("[");
                StringBuilder st = new StringBuilder(headIds ? vectorIdsToString(tensor.getIndex().getIndexIds().get(1),maxEntries,offset+4+format.getMinimumWidth(),new TextFormat(TextFormat.Conversion.STRING,format.getMinimumWidth()-1)) + "\n" : "").append("[");
                //StringBuilder st = new StringBuilder("[");
                int counter = 0;
                List<?> ids = tensor.getIndex().getIndexIds().get(tensor.size()-1);
                for (Tensor<?> t : tensor) {
                    if (tooBig && counter >= halfEntries) {
                        if (counter == halfEntries+1) {
                            st.append("\n ");
                            for (int i : range(offset))
                                st.append(" ");
                            st.append("  ...  ");
                        }
                        if (counter++ == tensor.size(0)-halfEntries-1) {
                            counter = 0;
                            st.append("\n ");
                            for (int i : range(offset-1))
                                st.append(" ");
                        }
                        continue;
                    }
                    if (id != null) {
                        st.append("(").append(exactSize(id,new TextFormat(TextFormat.Conversion.STRING,format.getMinimumWidth()-1))).append(")");
                        if (counter == 0)
                            offset += format.getMinimumWidth();
                    } else if (size == 3) {
                        //special for 3d initial?
                        st.append("(").append(exactSize(ids.get((counter)),new TextFormat(TextFormat.Conversion.STRING,format.getMinimumWidth()-1))).append(")");
                        if (counter == 0)
                            offset += format.getMinimumWidth();
                    }
                    if (counter++ > 0) {
                        st.append("\n");
                        for (int i : range(offset))
                            st.append(" ");
                    } else {
                        if (id == null && size == 3)
                            id = ids.get((counter-1));
                        if (id != null)
                            st.append("(").append(exactSize(id,new TextFormat(TextFormat.Conversion.STRING,format.getMinimumWidth()-1))).append(")");
                    }
//                    if (id != null) {
//                        st.append("(").append(exactSize(id,new TextFormat(TextFormat.Conversion.STRING,format.getMinimumWidth()-1))).append(")");
//                        if (counter == 1)
//                            offset += format.getMinimumWidth();
//                    } else if (size == 3) {
//                        //special for 3d initial?
//                        st.append("(").append(exactSize(ids.get((counter-1)),new TextFormat(TextFormat.Conversion.STRING,format.getMinimumWidth()-1))).append(")");
//                        if (counter == 1)
//                            offset += format.getMinimumWidth();
//                    }
                    if (size == 3)
                        st.append(matrixToStringWithIds(t, format, offset, maxEntries,counter > 1).substring(1));
                    else
                        st.append(tensorToStringWithIds(t,format,offset,maxEntries,false,ids.get((counter-1))));
                }
                return st.append("]").toString();
            }
        }
    }

    public static String toStringWithIds(Tensor<?> tensor, TextFormat format, int maxEntries) {
        return tensorToStringWithIds(tensor, format, maxEntries,true);
    }

    public static String toStringWithIds(Tensor<?> tensor, TextFormat format) {
        return toStringWithIds(tensor, format, DEFAULT_MAX_TO_STRING_ENTRIES);
    }

    @SuppressWarnings("unchecked") //Tensor<Number> casts are actually incorrect, but are ok here and in the spirit of what we want
    public static String toStringWithIds(Tensor<?> tensor, int maxEntries) {
        switch (tensor.getType()) {
            case BYTE :
            case SHORT :
            case INT :
            case LONG : return toStringIntegralWithIds((Tensor<Number>) tensor, maxEntries);
            case FLOAT :
            case DOUBLE: return toStringDecimalWithIds((Tensor<Number>) tensor, maxEntries);
            default : return toStringWithIds(tensor, new TextFormat(TextFormat.Conversion.STRING), maxEntries);
        }
    }

    public static String toStringWithIds(Tensor<?> tensor) {
        return toStringWithIds(tensor, DEFAULT_MAX_TO_STRING_ENTRIES);
    }

    private static String toStringDecimalWithIds(Tensor<? extends Number> tensor, int maxEntries) {
        //return toString(tensor,new TextFormat(TextFormat.Conversion.FLOATING_POINT_OR_SCIENTIFIC,8,3));
        return toStringWithIds(tensor, new TextFormat(TextFormat.Conversion.FLOATING_POINT_OR_SCIENTIFIC, 11, 5), maxEntries);
    }

    private static String toStringIntegralWithIds(Tensor<? extends Number> tensor, int maxEntries) {
        return toStringWithIds(tensor, new TextFormat(TextFormat.Conversion.INTEGER, 5), maxEntries);
    }

    
    /***********************equals***********************/

    /**
     * Determine if two tensors are equal, value-wise. Specifically, two tensors are equal value-wise if they have the same
     * shape (dimensionality), the same type, and every value in the two tensors at the same index are equal (either
     * they are both {@code null} or are equal via their {@code equals} method).
     *  
     * @param t1
     *        The first tensor.
     * 
     * @param t2
     *        The second tensor.
     * 
     * @return {@code true} it {@code t1} and {@code t2} are equal value-wise.
     */
    public static boolean equals(Tensor<?> t1, Tensor<?> t2) {
        JavaType t1Type = t1.getType();
        if (t1.getType() != t2.getType())
            return false;
        switch (t1Type) {
            case BYTE : return equals((ByteTensor) t1,(ByteTensor) t2);
            case SHORT : return equals((ShortTensor) t1,(ShortTensor) t2);
            case INT : return equals((IntTensor) t1,(IntTensor) t2);
            case LONG : return equals((LongTensor) t1,(LongTensor) t2);
            case FLOAT : return equals((FloatTensor) t1,(FloatTensor) t2);
            case DOUBLE : return equals((DoubleTensor) t1,(DoubleTensor) t2);
            case CHAR : return equals((CharTensor) t1,(CharTensor) t2);
            case BOOLEAN : return equals((BooleanTensor) t1,(BooleanTensor) t2);
        }
        if (!Arrays.equals(t1.getDimensions(),t2.getDimensions()))
            return false;
        if (t1.size() == 0) //special for scalar
            return t1.getValue().equals(t2.getValue());
        for (int[] index : IterableAbacus.getIterableAbacus(t1.getDimensions())) {
            Object v1 = t1.getValue(index);
            Object v2 = t2.getValue(index);
            if (v1 == null) {
                if (v2 != null)
                    return false;
            } else if (!v1.equals(v2)) {
                return false;
            }
        }
        return true;
    }              

    /**
     * Determine if two char tensors are equal, value-wise. Specifically, two tensors are equal value-wise if they have the same
     * shape (dimensionality), and every value in the two tensors at the same index are equal.
     *  
     * @param t1
     *        The first tensor.
     * 
     * @param t2
     *        The second tensor.
     * 
     * @return {@code true} it {@code t1} and {@code t2} are equal value-wise.
     */
    public static boolean equals(CharTensor t1, CharTensor t2) {
        if (!Arrays.equals(t1.getDimensions(),t2.getDimensions()))
            return false;
        if (t1.size() == 0) //special for scalar
            return t1.getCell() == t2.getCell();
        for (int[] index : IterableAbacus.getIterableAbacus(t1.getDimensions())) 
            if (t1.getCell(index) != t2.getCell(index))
                return false;
        return true;
    }

    /**
     * Determine if two boolean tensors are equal, value-wise. Specifically, two tensors are equal value-wise if they have the same
     * shape (dimensionality), and every value in the two tensors at the same index are equal.
     *  
     * @param t1
     *        The first tensor.
     * 
     * @param t2
     *        The second tensor.
     * 
     * @return {@code true} it {@code t1} and {@code t2} are equal value-wise.
     */
    public static boolean equals(BooleanTensor t1, BooleanTensor t2) {
        if (!Arrays.equals(t1.getDimensions(),t2.getDimensions()))
            return false;
        if (t1.size() == 0) //special for scalar
            return t1.getCell() == t2.getCell();
        for (int[] index : IterableAbacus.getIterableAbacus(t1.getDimensions())) 
            if (t1.getCell(index) != t2.getCell(index))
                return false;
        return true;
    }

    /**
     * Determine if two byte tensors are equal, value-wise. Specifically, two tensors are equal value-wise if they have the same
     * shape (dimensionality), and every value in the two tensors at the same index are equal.
     *  
     * @param t1
     *        The first tensor.
     * 
     * @param t2
     *        The second tensor.
     * 
     * @return {@code true} it {@code t1} and {@code t2} are equal value-wise.
     */
    public static boolean equals(ByteTensor t1, ByteTensor t2) {
        if (!Arrays.equals(t1.getDimensions(),t2.getDimensions()))
            return false;
        if (t1.size() == 0) //special for scalar
            return t1.getCell() == t2.getCell();
        for (int[] index : IterableAbacus.getIterableAbacus(t1.getDimensions())) 
            if (t1.getCell(index) != t2.getCell(index))
                return false;
        return true;
    }

    /**
     * Determine if two short tensors are equal, value-wise. Specifically, two tensors are equal value-wise if they have the same
     * shape (dimensionality), and every value in the two tensors at the same index are equal.
     *  
     * @param t1
     *        The first tensor.
     * 
     * @param t2
     *        The second tensor.
     * 
     * @return {@code true} it {@code t1} and {@code t2} are equal value-wise.
     */
    public static boolean equals(ShortTensor t1, ShortTensor t2) {
        if (!Arrays.equals(t1.getDimensions(),t2.getDimensions()))
            return false;
        if (t1.size() == 0) //special for scalar
            return t1.getCell() == t2.getCell();
        for (int[] index : IterableAbacus.getIterableAbacus(t1.getDimensions())) 
            if (t1.getCell(index) != t2.getCell(index))
                return false;
        return true;
    }

    /**
     * Determine if two int tensors are equal, value-wise. Specifically, two tensors are equal value-wise if they have the same
     * shape (dimensionality), and every value in the two tensors at the same index are equal.
     *  
     * @param t1
     *        The first tensor.
     * 
     * @param t2
     *        The second tensor.
     * 
     * @return {@code true} it {@code t1} and {@code t2} are equal value-wise.
     */
    public static boolean equals(IntTensor t1, IntTensor t2) {
        if (!Arrays.equals(t1.getDimensions(),t2.getDimensions()))
            return false;
        if (t1.size() == 0) //special for scalar
            return t1.getCell() == t2.getCell();
        for (int[] index : IterableAbacus.getIterableAbacus(t1.getDimensions())) 
            if (t1.getCell(index) != t2.getCell(index))
                return false;
        return true;
    }

    /**
     * Determine if two long tensors are equal, value-wise. Specifically, two tensors are equal value-wise if they have the same
     * shape (dimensionality), and every value in the two tensors at the same index are equal.
     *  
     * @param t1
     *        The first tensor.
     * 
     * @param t2
     *        The second tensor.
     * 
     * @return {@code true} it {@code t1} and {@code t2} are equal value-wise.
     */
    public static boolean equals(LongTensor t1, LongTensor t2) {
        if (!Arrays.equals(t1.getDimensions(),t2.getDimensions()))
            return false;
        if (t1.size() == 0) //special for scalar
            return t1.getCell() == t2.getCell();
        for (int[] index : IterableAbacus.getIterableAbacus(t1.getDimensions())) 
            if (t1.getCell(index) != t2.getCell(index))
                return false;
        return true;
    }

    /**
     * Determine if two float tensors are equal, value-wise. Specifically, two tensors are equal value-wise if they have the same
     * shape (dimensionality), and every value in the two tensors at the same index are equal.
     *  
     * @param t1
     *        The first tensor.
     * 
     * @param t2
     *        The second tensor.
     * 
     * @return {@code true} it {@code t1} and {@code t2} are equal value-wise.
     */
    public static boolean equals(FloatTensor t1, FloatTensor t2) {
        if (!Arrays.equals(t1.getDimensions(),t2.getDimensions()))
            return false;
        if (t1.size() == 0) //special for scalar
            return t1.getCell() == t2.getCell();
        for (int[] index : IterableAbacus.getIterableAbacus(t1.getDimensions())) 
            if (t1.getCell(index) != t2.getCell(index))
                return false;
        return true;
    }

    /**
     * Determine if two double tensors are equal, value-wise. Specifically, two tensors are equal value-wise if they have the same
     * shape (dimensionality), and every value in the two tensors at the same index are equal.
     *  
     * @param t1
     *        The first tensor.
     * 
     * @param t2
     *        The second tensor.
     * 
     * @return {@code true} it {@code t1} and {@code t2} are equal value-wise.
     */
    public static boolean equals(DoubleTensor t1, DoubleTensor t2) {
        if (!Arrays.equals(t1.getDimensions(),t2.getDimensions()))
            return false;
        if (t1.size() == 0) //special for scalar
            return t1.getCell() == t2.getCell();
        for (int[] index : IterableAbacus.getIterableAbacus(t1.getDimensions())) 
            if (t1.getCell(index) != t2.getCell(index))
                return false;
        return true;
    }

    /**
     * Determine if two float tensors are almost equal, value-wise. Specifically, two tensors are almost equal value-wise
     * if they have the same shape (dimensionality), and every value in the two tensors at the same index are almost equal
     * (as defined by {@link MathUtil#almostEquals(float,float)}).
     *
     * @param t1
     *        The first tensor.
     *
     * @param t2
     *        The second tensor.
     *
     * @return {@code true} it {@code t1} and {@code t2} are equal value-wise.
     */
    public static boolean almostEquals(FloatTensor t1, FloatTensor t2) {
        if (!Arrays.equals(t1.getDimensions(),t2.getDimensions()))
            return false;
        if (t1.size() == 0) //special for scalar
            return MathUtil.almostEquals(t1.getCell(),t2.getCell());
        for (int[] index : IterableAbacus.getIterableAbacus(t1.getDimensions()))
            if (!MathUtil.almostEquals(t1.getCell(index),t2.getCell(index)))
                return false;
        return true;
    }

    /**
     * Determine if two double tensors are almost equal, value-wise. Specifically, two tensors are almost equal value-wise
     * if they have the same shape (dimensionality), and every value in the two tensors at the same index are almost equal
     * (as defined by {@link MathUtil#almostEquals(double,double)}).
     *
     * @param t1
     *        The first tensor.
     *
     * @param t2
     *        The second tensor.
     *
     * @return {@code true} it {@code t1} and {@code t2} are equal value-wise.
     */
    public static boolean almostEquals(DoubleTensor t1, DoubleTensor t2) {
        if (!Arrays.equals(t1.getDimensions(),t2.getDimensions()))
            return false; 
        if (t1.size() == 0) //special for scalar
            return MathUtil.almostEquals(t1.getCell(),t2.getCell());
        for (int[] index : IterableAbacus.getIterableAbacus(t1.getDimensions()))
            if (!MathUtil.almostEquals(t1.getCell(index),t2.getCell(index)))
                return false;
        return true;
    }

    /**
     * Determine if two float tensors are almost equal, value-wise. Specifically, two tensors are almost equal value-wise
     * if they have the same shape (dimensionality), and every value in the two tensors at the same index are almost equal
     * (as defined by {@link MathUtil#almostEquals(float,float,float,float)}).
     *
     * @param t1
     *        The first tensor.
     *
     * @param t2
     *        The second tensor.
     *
     * @param delta
     *        The delta to use in the almost equals calculation.
     *
     * @param epsilon
     *        The epsilon to use in the almost equal calculation.
     *
     * @return {@code true} it {@code t1} and {@code t2} are equal value-wise.
     */
    public static boolean almostEquals(FloatTensor t1, FloatTensor t2, float delta, float epsilon) {
        if (!Arrays.equals(t1.getDimensions(),t2.getDimensions()))
            return false;                       
        if (t1.size() == 0) //special for scalar
            return MathUtil.almostEquals(t1.getCell(),t2.getCell(),delta,epsilon);
        for (int[] index : IterableAbacus.getIterableAbacus(t1.getDimensions()))
            if (!MathUtil.almostEquals(t1.getCell(index),t2.getCell(index),delta,epsilon))
                return false;
        return true;
    }

    /**
     * Determine if two double tensors are almost equal, value-wise. Specifically, two tensors are almost equal value-wise
     * if they have the same shape (dimensionality), and every value in the two tensors at the same index are almost equal
     * (as defined by {@link MathUtil#almostEquals(double,double,double,double)}).
     *
     * @param t1
     *        The first tensor.
     *
     * @param t2
     *        The second tensor.
     *
     * @param delta
     *        The delta to use in the almost equals calculation.
     *
     * @param epsilon
     *        The epsilon to use in the almost equal calculation.
     *
     * @return {@code true} it {@code t1} and {@code t2} are equal value-wise.
     */
    public static boolean almostEquals(DoubleTensor t1, DoubleTensor t2, double delta, double epsilon) {
        if (!Arrays.equals(t1.getDimensions(),t2.getDimensions()))
            return false;                             
        if (t1.size() == 0) //special for scalar
            return MathUtil.almostEquals(t1.getCell(),t2.getCell(),delta,epsilon);
        for (int[] index : IterableAbacus.getIterableAbacus(t1.getDimensions()))
            if (!MathUtil.almostEquals(t1.getCell(index),t2.getCell(index),delta,epsilon))
                return false;
        return true;
    }

}