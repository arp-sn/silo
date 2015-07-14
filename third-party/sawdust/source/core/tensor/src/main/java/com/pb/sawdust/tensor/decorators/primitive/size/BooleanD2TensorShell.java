package com.pb.sawdust.tensor.decorators.primitive.size;

import com.pb.sawdust.tensor.decorators.size.D2TensorShell;
import com.pb.sawdust.tensor.decorators.primitive.BooleanTensor;
import com.pb.sawdust.tensor.index.Index;
import com.pb.sawdust.tensor.TensorImplUtil;
import com.pb.sawdust.tensor.decorators.id.primitive.IdBooleanTensor;
import com.pb.sawdust.util.abacus.IterableAbacus;
import com.pb.sawdust.util.array.BooleanTypeSafeArray;
import com.pb.sawdust.util.array.TypeSafeArrayFactory;
import com.pb.sawdust.tensor.alias.matrix.primitive.BooleanMatrix;

/**
 * The {@code BooleanD2TensorShell} class is a wrapper which sets a 2-dimensional {@code BooleanTensor} as a {@code Matrix} (or,
 * more specifically, a {@code BooleanMatrix}).
 *
 * @author crf <br/>
 *         Started: Sat Oct 25 21:35:12 2008
 *         Revised: Dec 14, 2009 12:35:25 PM
 */
public class BooleanD2TensorShell extends D2TensorShell<Boolean> implements BooleanMatrix {
    private final BooleanTensor tensor;

    /**
     * Constructor specifying tensor to wrap. The tensor must be 2-dimensional or an exception will be thrown.
     *
     * @param tensor
     *        The tensor to wrap.
     *
     * @throws IllegalArgumentException if {@code tensor} is not 2 dimension in size.
     */
    public BooleanD2TensorShell(BooleanTensor tensor) {
        super(tensor);
        this.tensor = tensor;
    }

    /**
     * {@inheritDoc}
     *
     * This method just calls {@code BooleanTensor.getCell(d0index,d1index)}, 
     * and should be overridden if any efficiencies over that method can be made.
     */
    public boolean getCell(int d0index, int d1index) {
        return tensor.getCell(d0index,d1index);
    }

    public boolean getCell(int ... indices) {
        if (indices.length != 2)
            throw new IllegalArgumentException("BooleanD2Tensor is 2 dimension in size, getValue passed with " + indices.length + " indices.");
        return getCell(indices[0],indices[1]);
    }

    public Boolean getValue(int ... indices) {
        return getCell(indices);
    }

    public Boolean getValue(int d0index, int d1index) {
        return getCell(d0index,d1index);
    }

    /**
     * {@inheritDoc}
     *
     * This method just calls {@code BooleanTensor.setCell(boolean,d0index,d1index)}, 
     * and should be overridden if any efficiencies over that method can be made.
     */
    public void setCell(boolean value, int d0index, int d1index) {
        tensor.setCell(value,d0index,d1index);
    }

    public void setCell(boolean value, int ... indices) {
        if (indices.length != 2)
            throw new IllegalArgumentException("BooleanD2Tensor is 2 dimension in size, getValue passed with " + indices.length + " indices.");
        setCell(value,indices[0],indices[1]);
    }

    public void setValue(Boolean value, int ... indices) {
        setCell(value,indices);
    }

    public void setValue(Boolean value, int d0index, int d1index) {
        setCell(value,d0index,d1index);
    }
    
    public BooleanTypeSafeArray getTensorValues(Class<Boolean> type) {
        return getTensorValues();
    }

    public BooleanTypeSafeArray getTensorValues() {
       @SuppressWarnings("unchecked") //getType requirements in tensor make this ok
        BooleanTypeSafeArray array = TypeSafeArrayFactory.booleanTypeSafeArray(getDimensions());
        for (int[] index : IterableAbacus.getIterableAbacus(getDimensions()))
            array.set(getCell(index),index);
        return array;
    }

    public void setTensorValues(BooleanTypeSafeArray valuesArray) {
        TensorImplUtil.setTensorValues(this,valuesArray);
    }

    public <I> IdBooleanTensor<I> getReferenceTensor(Index<I> index) {
        return (IdBooleanTensor<I>) super.getReferenceTensor(index);
    }

    protected BooleanTensor getComposedTensor(Index<?> index) {
        return TensorImplUtil.getComposedTensor(this,index); 
    }
}