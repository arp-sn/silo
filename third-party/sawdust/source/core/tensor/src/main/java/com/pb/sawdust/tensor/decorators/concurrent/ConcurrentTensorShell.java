package com.pb.sawdust.tensor.decorators.concurrent;

import com.pb.sawdust.tensor.Tensor;
import com.pb.sawdust.tensor.ComposableTensor;
import com.pb.sawdust.tensor.index.Index;
import com.pb.sawdust.util.JavaType;
import com.pb.sawdust.util.array.TypeSafeArray;

import java.util.concurrent.locks.Lock;

/**
 * The {@code ConcurrentTensorShell} class provides a wrapper for creating concurrent (thread-safe) tensors. It requires
 * the specification of a tensor to wrap and a {@code ConcurrentTensorLocks} implementation which specifies the concurrency
 * policies used for locking.
 
 * @author crf <br/>
 *         Started: Jan 31, 2009 8:14:16 PM
 *         Revised: Dec 14, 2009 12:35:34 PM
 */
public class ConcurrentTensorShell<T> extends ComposableTensor<T> {
    private final Tensor<T> tensor;
    
    /**
     * The {@code ConcurrentTensorLocks} instance holding the concurrency policy used for locking the wrapped tensor.
     */
    protected final ConcurrentTensorLocks locks;

    /**
     * Constructor specifying the tensor to wrap and the concurrency policy.
     * 
     * @param tensor
     *        The tensor to wrap.
     *
     * @param locks
     *        The object holding the concurrency policy which will be used when locking the wrapped tensor.
     */
    public ConcurrentTensorShell(Tensor<T> tensor, ConcurrentTensorLocks locks) {
        this.tensor = tensor;
        this.locks = locks;
    }

    public int[] getDimensions() {
        return tensor.getDimensions();
    }

    public int size(int dimension) {
        return tensor.size(dimension);
    }

    public int size() {
        return tensor.size();
    }

    public JavaType getType() {
        return tensor.getType();
    }

    public T getValue(int ... indices) {
        Lock lock = locks.getReadLock(indices);
        lock.lock();
        try {
            return tensor.getValue(indices);
        } finally {
            lock.unlock();
        }
    }

    public void setValue(T value, int ... indices) {
        Lock lock = locks.getWriteLock(indices);
        lock.lock();
        try {
            tensor.setValue(value,indices);
        } finally {
            lock.unlock();
        }
    }

    public TypeSafeArray<T> getTensorValues(Class<T> type) {
        Lock lock = locks.getTensorReadLock();
        lock.lock();
        try {
            return tensor.getTensorValues(type);
        } finally {
            lock.unlock();
        }
    }

    public void setTensorValues(TypeSafeArray<? extends T> typeSafeArray) {
        Lock lock = locks.getTensorWriteLock();
        lock.lock();
        try {
            tensor.setTensorValues(typeSafeArray);
        } finally {
            lock.unlock();
        }
    }

    public void setTensorValues(Tensor<? extends T> tensor) {
        Lock lock = locks.getTensorWriteLock();
        lock.lock();
        try {
            this.tensor.setTensorValues(tensor);
        } finally {
            lock.unlock();
        }
    }

    public Index<?> getIndex() {
        return tensor.getIndex();
    }
}