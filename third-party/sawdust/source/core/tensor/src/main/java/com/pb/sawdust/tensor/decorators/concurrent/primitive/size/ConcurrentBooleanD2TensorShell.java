package com.pb.sawdust.tensor.decorators.concurrent.primitive.size;

import com.pb.sawdust.tensor.TensorImplUtil;
import com.pb.sawdust.tensor.index.Index;
import com.pb.sawdust.tensor.decorators.concurrent.size.ConcurrentD2TensorShell;
import com.pb.sawdust.tensor.decorators.primitive.BooleanTensor;
import com.pb.sawdust.tensor.decorators.id.primitive.IdBooleanTensor;
import com.pb.sawdust.tensor.alias.matrix.primitive.BooleanMatrix;
import com.pb.sawdust.tensor.decorators.primitive.size.BooleanD2Tensor;
import com.pb.sawdust.util.array.BooleanTypeSafeArray;

import java.util.concurrent.locks.Lock;

/**
 * The {@code ConcurrentBooleanD2TensorShell} class provides a wrapper for implementations of the {@code BooleanMatrix} interface
 * with support for concurrent access. The locking policy is set by the {@code D2ConcurrentTensorLocks} implementation used
 * in the class.
 *
 * @author crf <br/>
 *         Started: January 30, 2009 10:47:31 PM
 *         Revised: Dec 14, 2009 12:35:25 PM
 */
public class ConcurrentBooleanD2TensorShell extends ConcurrentD2TensorShell<Boolean> implements BooleanMatrix {
    private final BooleanD2Tensor tensor;

    /**
     * Constructor specifying the tensor to wrap and the concurrency policy used for locking the tensor.
     *
     * @param tensor
     *        The tensor to wrap.
     *
     * @param locks
     *        The {@code ConcurrentD2TensorLocks} instance holding the concurrency policy used when locking the tensor.
     */
    public ConcurrentBooleanD2TensorShell(BooleanD2Tensor tensor, ConcurrentD2TensorLocks locks) {
        super(tensor,locks);
        this.tensor = tensor;
    }
    
    public boolean getCell(int d0index, int d1index) {
        Lock lock = locks.getReadLock(d0index,d1index);
        lock.lock();
        try {
            return tensor.getCell(d0index,d1index);
        } finally {
            lock.unlock();
        }
    }

    public void setCell(boolean value, int d0index, int d1index) {
        Lock lock = locks.getWriteLock(d0index,d1index);
        lock.lock();
        try {
            tensor.setCell(value,d0index,d1index);
        } finally {
            lock.unlock();
        }
    }

    public boolean getCell(int ... indices) {
        TensorImplUtil.checkIndicesLength(this,indices);
        Lock lock = locks.getReadLock(indices[0],indices[1]);
        lock.lock();
        try {
            return tensor.getCell(indices[0],indices[1]);
        } finally {
            lock.unlock();
        }
    }

    public void setCell(boolean value, int ... indices) {
        TensorImplUtil.checkIndicesLength(this,indices);
        Lock lock = locks.getWriteLock(indices[0],indices[1]);
        lock.lock();
        try {
            tensor.setCell(value,indices[0],indices[1]);
        } finally {
            lock.unlock();
        }
    }

    public void setTensorValues(BooleanTypeSafeArray valuesArray) {
        Lock lock = locks.getTensorWriteLock();
        lock.lock();
        try {
            tensor.setTensorValues(valuesArray);
        } finally {
            lock.unlock();
        }
    }

    public BooleanTypeSafeArray getTensorValues() {
        Lock lock = locks.getTensorReadLock();
        lock.lock();
        try {
            return tensor.getTensorValues();
        } finally {
            lock.unlock();
        }
    }               

    public BooleanTypeSafeArray getTensorValues(Class<Boolean> type) {
        Lock lock = locks.getTensorReadLock();
        lock.lock();
        try {
            return tensor.getTensorValues(type);
        } finally {
            lock.unlock();
        }
    }

    protected BooleanTensor getComposedTensor(Index<?> index) {
        return TensorImplUtil.getComposedTensor(this,index); 
    }

    public <I> IdBooleanTensor<I> getReferenceTensor(Index<I> index) {
        return (IdBooleanTensor<I>) super.getReferenceTensor(index);
    }
}