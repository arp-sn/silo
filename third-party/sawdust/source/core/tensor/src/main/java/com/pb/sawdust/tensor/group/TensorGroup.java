package com.pb.sawdust.tensor.group;

import com.pb.sawdust.tensor.Tensor;
import com.pb.sawdust.tensor.index.Index;
import com.pb.sawdust.util.ContainsMetadata;

import java.util.Iterator;
import java.util.Set;

/**
 * The {@code TensorGroup} ...
 *
 * @author crf <br/>
 *         Started Mar 3, 2010 12:10:22 PM
 */
public interface TensorGroup<T,I> extends ContainsMetadata<String> {
    int[] getDimensions();
    void addTensor(String tensorKey, Tensor<T> tensor);
    void addIndex(String indexKey, Index<I> index);
    Tensor<T> getTensor(String tensorKey);
    Index<I> getIndex(String indexKey);
    Set<String> tensorKeySet();
    Set<String> indexKeySet();
    Iterator<Tensor<T>> tensorIterator();
    Iterator<Index<I>> indexIterator();
}