package com.pb.sawdust.tensor.index;

import com.pb.sawdust.util.array.ArrayUtil;
import com.pb.sawdust.util.Range;

import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

/**
 * The {@code StandardIndex} class is used as a base index for matrices. it is intended to be as simple an index as
 * possible: it does not transfer its indices to a reference index (it just passes them through) and its ids are just
 * the object ({@code Integer}) equivalents of the index indices.
 *
 * @author crf <br/>
 *         Started: Jan 10, 2009 9:06:36 PM
 */
public class StandardIndex extends AbstractIndex<Integer> implements IdlessIndex {

    /**
     * Constructor specifying the dimensions of this index.
     *
     * @param dimensions
     *        The dimensions of this index.
     *
     * @throws IllegalArgumentException if any of the elements in {@code dimensions} is less than one.
     */
    public StandardIndex(int ... dimensions) {
        super(dimensions);
    }

    public List<List<Integer>> getIndexIds() {
        List<List<Integer>> ids = new LinkedList<List<Integer>>();
        for (int dimension : dimensions)
            ids.add(Arrays.asList(ArrayUtil.toIntegerArray(new Range(dimension).getRangeArray())));
        return ids;
    }

    public int getIndex(int dimension, Integer id) {
        try {
            return getIndex(dimension,(int) id);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Index id not found " + id);
        }
    }

    public int[] getIndices(Integer ... ids) {
        try {
            return getIndices(ArrayUtil.toPrimitive(ids));
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Integer getIndexId(int dimension, int indexId) {
        return getIndex(dimension,indexId);
    }

    public List<Integer> getIndexIds(int ... indices) {
        return Arrays.asList(ArrayUtil.toIntegerArray(getIndices(indices)));
    }
}