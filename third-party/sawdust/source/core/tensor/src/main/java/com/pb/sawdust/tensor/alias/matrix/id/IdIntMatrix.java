package com.pb.sawdust.tensor.alias.matrix.id;

import com.pb.sawdust.tensor.alias.matrix.primitive.IntMatrix;
import com.pb.sawdust.tensor.decorators.id.primitive.size.IdIntD2Tensor;
import com.pb.sawdust.tensor.Tensor;

import java.util.Iterator;

/**
 * The {@code IdIntMatrix} interface provides an alternate name for 2-dimensional id tensors holding {@code int}s.
 *
 * @author crf <br/>
 *         Started: Jun 16, 2009 9:22:03 AM
 */
public interface IdIntMatrix<I> extends IdIntD2Tensor<I>,IntMatrix {

    /**
     * {@inheritDoc}
     *
     * The tensors this iterator loops over are guaranteed to be {@code IdIntVector}s.
     *
     */
    Iterator<Tensor<Integer>> iterator();
}