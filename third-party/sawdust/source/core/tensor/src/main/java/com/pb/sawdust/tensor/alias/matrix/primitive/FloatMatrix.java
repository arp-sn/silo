package com.pb.sawdust.tensor.alias.matrix.primitive;

import com.pb.sawdust.tensor.decorators.primitive.size.FloatD2Tensor;
import com.pb.sawdust.tensor.Tensor;

import java.util.Iterator;

/**
 * The {@code FloatMatrix} interface provides an alternate name for 2-dimensional tensors holding {@code float}s.
 *
 * @author crf <br/>
 *         Started: Jun 16, 2009 9:22:03 AM
 */
public interface FloatMatrix extends FloatD2Tensor {   
    
    /**
     * {@inheritDoc}
     * 
     * The tensors this iterator loops over are guaranteed to be {@code FloatVector}s.
     * 
     */
    Iterator<Tensor<Float>> iterator();
}