package com.pb.sawdust.tensor.decorators.size;

import com.pb.sawdust.tensor.Tensor;
import java.util.Iterator;

/**
 * The {@code D0Tensor} interface specifies a tensor with {@code 0} dimensions; that is, a scalar/point.
 *
 * @param <T>
 *        The type this tensor holds.
 *
 * @see com.pb.sawdust.tensor.alias.scalar.impl.ScalarImpl
 *
 * @author crf <br/>
 *         Started: Oct 20, 2008 6:55:24 PM
 *         Revised: Jun 16, 2009 3:17:18 PM
 */
public interface D0Tensor<T> extends Tensor<T> {

    /**
     * Gets the number of dimensions in this tensor.
     *
     * @return {@code 0}, the number of dimensions in this tensor.
     */
    int size();
    
    /**
     * Get the value of this tensor.
     *
     * @return the tensor value.
     */
    T getValue();
    
    /**
     * Set this tensor value.
     *
     * @param value
     *        The value to set the tensor to.
     */
    void setValue(T value);
    
    /**
     * {@inheritDoc}
     *
     * The returned iterator will iterate exactly once, returning this tensor.
     * 
     */
    Iterator<Tensor<T>> iterator();
}