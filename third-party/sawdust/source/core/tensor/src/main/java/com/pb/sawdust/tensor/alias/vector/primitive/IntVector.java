package com.pb.sawdust.tensor.alias.vector.primitive;

import com.pb.sawdust.tensor.decorators.primitive.size.IntD1Tensor;
import com.pb.sawdust.tensor.Tensor;

import java.util.Iterator;

/**
 * The {@code IdIntVector} interface provides an alternate name for 1-dimensional tensors holding {@code int}s.
 *
 * @author crf <br/>
 *         Started: Jun 16, 2009 9:22:03 AM
 */
public interface IntVector extends IntD1Tensor {

    /**
     * {@inheritDoc}
     *
     * The tensors this iterator loops over are guaranteed to be {@code IntScalar}s.
     *
     */
    Iterator<Tensor<Integer>> iterator();
}