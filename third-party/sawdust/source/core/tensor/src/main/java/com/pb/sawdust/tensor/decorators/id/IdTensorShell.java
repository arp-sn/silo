package com.pb.sawdust.tensor.decorators.id;

import com.pb.sawdust.tensor.Tensor;
import com.pb.sawdust.tensor.ComposableTensor;
import com.pb.sawdust.tensor.index.Index;
import com.pb.sawdust.tensor.index.BaseIndex;
import com.pb.sawdust.util.JavaType;
import com.pb.sawdust.util.array.TypeSafeArray;

import java.util.List;
import java.util.Iterator;

/**
 * The {@code IdTensorShell} class is used wrap index referencing ids on already created matrices. The ids' dimensionality
 * match the dimensional shape of the source indes; that is, this class will not reshape the referenced tensor.
 *
 * @param <T>
 *        The type held by the tensor.
 *
 * @param <I>
 *        The type of id used to reference dimensional indices.
 *
 * @author crf <br/>
 *         Started: Jan 18, 2009 1:21:39 PM
 */
public class IdTensorShell<T,I> extends ComposableTensor<T> implements IdTensor<T,I> {
    private final Tensor<T> tensor;
    private final Index<I> index;

    private static void checkIdsSize(int tensorSize, int idsSize) {
        if (tensorSize != idsSize)
            throw new IllegalArgumentException("Tensor dimension (" + tensorSize + ") and id (" + idsSize + ") counts must be equal.");
    }

    private static void checkIdSize(int dimension, int dimSize, int idSize) {
        if (dimSize != idSize)
            throw new IllegalArgumentException("Tensor dimension (" + dimSize + ") and id (" + idSize + ") lengths must be equal for dimension" + dimension + ".");
    }

    private static <I> List<List<I>> checkIdsSize(Tensor<?> tensor, List<List<I>> ids) {
        checkIdsSize(tensor.size(),ids.size());
        int counter = 0;
        for (List<I> id : ids) {
            checkIdSize(counter,tensor.size(counter),id.size());
            counter++;
        }
        return ids;
    }

    private static <I> I[][] checkIdsSize(Tensor<?> tensor, I[][] ids) {
        checkIdsSize(tensor.size(),ids.length);
        int counter = 0;
        for (I[] id : ids) {
            checkIdSize(counter,tensor.size(counter),id.length);
            counter++;
        }
        return ids;
    }

    private IdTensorShell(Tensor<T> tensor, Index<I> index) {
        this.tensor = tensor;
        this.index = index;
    }

    /**
     * Constructor specifying the tensor to reference and the ids to be used in the new tensor.
     *
     * @param tensor
     *        The tensor to reference.
     *
     * @param ids
     *        The ids to be used in the new tensor.
     *
     * @throws IllegalArgumentException if {@code ids.size() != tensor.size()}, or if the size of each dimension's id list
     *                                  is not equal to the size of the source tensor (<i>i.e.</i> {@code ids.get(i).size() != tensor.size(i)}
     *                                  for all {@code i} on <code>[0,tensor.size())</code>).
     */
    public IdTensorShell(Tensor<T> tensor, List<List<I>> ids) {
        this(tensor,new BaseIndex<I>(checkIdsSize(tensor,ids)));
    }

    /**
     * Constructor specifying the tensor to reference and the ids to be used in the new tensor.
     *
     * @param tensor
     *        The tensor to reference.
     *
     * @param ids
     *        The ids to be used in the new tensor.
     *
     * @throws IllegalArgumentException if {@code ids.length != tensor.size()}, or if the size of each dimension's id list
     *                                  is not equal to the size of the source tensor (<i>i.e.</i> {@code ids[i].length != tensor.size(i)}
     *                                  for all {@code i} on <code>[0,tensor.size())</code>).
     */
    @SafeVarargs
    @SuppressWarnings({"unchecked","varargs"})
    public IdTensorShell(Tensor<T> tensor, I[] ... ids) {
        this(tensor,new BaseIndex<I>(checkIdsSize(tensor,ids)));
    }

    /**
     * Constructor which will wrap a tensor, using its current index for the ids. Note that this constructor is
     * inherently unsafe, as there is no way to check that the type of the tensor's index matches the type declared
     * when this constructor is called. Therefore, it should be used with care or in situations where the index type
     * can be verified.
     *
     * @param tensor
     *        The tensor to wrap.
     */
    @SuppressWarnings("unchecked") //warning is duly noted and clearly stated in the documentation
    public IdTensorShell(Tensor<T> tensor) {
        this(tensor,(Index<I>) tensor.getIndex());
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
        return tensor.getValue(indices);
    }

    public void setValue(T value, int ... indices) {
        tensor.setValue(value,indices);
    }

    public void setTensorValues(TypeSafeArray<? extends T> typeSafeArray) {
        tensor.setTensorValues(typeSafeArray);
    }

    public TypeSafeArray<T> getTensorValues(Class<T> type) {
        return tensor.getTensorValues(type);
    }

    public void setTensorValues(Tensor<? extends T> tensor) {
        this.tensor.setTensorValues(tensor);
    }

    public Index<I> getIndex() {
        return index;
    }

    @SuppressWarnings({"unchecked", "varargs"})
    public T getValueById(I ... ids) {
        return tensor.getValue(index.getIndices(ids));
    }

    @SuppressWarnings({"unchecked", "varargs"})
    public void setValueById(T value, I ... ids) {
        tensor.setValue(value,index.getIndices(ids));
    }

    public Iterator<Tensor<T>> iterator() {
        return new Iterator<Tensor<T>>() {
            Iterator<Tensor<T>> it = IdTensorShell.super.iterator();

            public boolean hasNext() {
                return it.hasNext();
            }

            public Tensor<T> next() {
                return new IdTensorShell<T,I>(it.next());
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}