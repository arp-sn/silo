package com.pb.sawdust.tensor.decorators.primitive.size;

import com.pb.sawdust.tensor.decorators.primitive.CharTensor;
import com.pb.sawdust.tensor.decorators.size.D0Tensor;
import com.pb.sawdust.tensor.Tensor;

import java.util.Iterator;

/**
 * The {@code CharD0Tensor} interface combines the {@code CharTensor} and {@code D0Tensor} interfaces. The notes and caveats
 * specified in those interfaces apply here as well.
 *
 * @see com.pb.sawdust.tensor.alias.scalar.primitive.CharScalar
 *
 * @author crf <br/>
 *         Started: Sat Oct 25 21:35:12 2008
 *         Revised: Jun 16, 2009 3:17:18 PM
 */
public interface CharD0Tensor extends CharTensor, D0Tensor<Character> {
    /**
     * Get the value of this tensor.
     *
     * @return the tensor value at the specified location.
     */
    char getCell();
    
    /**
     * Set the value of this tensor.
     *
     * @param value
     *        The value to set the tensor to.
     */
    void setCell(char value);
    
    /**
     * {@inheritDoc}
     * 
     * The returned iterator will iterate exactly once, returning this tensor.
     * 
     */
    Iterator<Tensor<Character>> iterator();
}