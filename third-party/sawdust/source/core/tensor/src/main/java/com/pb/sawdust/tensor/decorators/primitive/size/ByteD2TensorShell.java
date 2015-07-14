package com.pb.sawdust.tensor.decorators.primitive.size;

import com.pb.sawdust.tensor.decorators.size.D2TensorShell;
import com.pb.sawdust.tensor.decorators.primitive.ByteTensor;
import com.pb.sawdust.tensor.index.Index;
import com.pb.sawdust.tensor.TensorImplUtil;
import com.pb.sawdust.tensor.decorators.id.primitive.IdByteTensor;
import com.pb.sawdust.util.abacus.IterableAbacus;
import com.pb.sawdust.util.array.ByteTypeSafeArray;
import com.pb.sawdust.util.array.TypeSafeArrayFactory;
import com.pb.sawdust.tensor.alias.matrix.primitive.ByteMatrix;

/**
 * The {@code ByteD2TensorShell} class is a wrapper which sets a 2-dimensional {@code ByteTensor} as a {@code Matrix} (or,
 * more specifically, a {@code ByteMatrix}).
 *
 * @author crf <br/>
 *         Started: Sat Oct 25 21:35:12 2008
 *         Revised: Dec 14, 2009 12:35:24 PM
 */
public class ByteD2TensorShell extends D2TensorShell<Byte> implements ByteMatrix {
    private final ByteTensor tensor;

    /**
     * Constructor specifying tensor to wrap. The tensor must be 2-dimensional or an exception will be thrown.
     *
     * @param tensor
     *        The tensor to wrap.
     *
     * @throws IllegalArgumentException if {@code tensor} is not 2 dimension in size.
     */
    public ByteD2TensorShell(ByteTensor tensor) {
        super(tensor);
        this.tensor = tensor;
    }

    /**
     * {@inheritDoc}
     *
     * This method just calls {@code ByteTensor.getCell(d0index,d1index)}, 
     * and should be overridden if any efficiencies over that method can be made.
     */
    public byte getCell(int d0index, int d1index) {
        return tensor.getCell(d0index,d1index);
    }

    public byte getCell(int ... indices) {
        if (indices.length != 2)
            throw new IllegalArgumentException("ByteD2Tensor is 2 dimension in size, getValue passed with " + indices.length + " indices.");
        return getCell(indices[0],indices[1]);
    }

    public Byte getValue(int ... indices) {
        return getCell(indices);
    }

    public Byte getValue(int d0index, int d1index) {
        return getCell(d0index,d1index);
    }

    /**
     * {@inheritDoc}
     *
     * This method just calls {@code ByteTensor.setCell(byte,d0index,d1index)}, 
     * and should be overridden if any efficiencies over that method can be made.
     */
    public void setCell(byte value, int d0index, int d1index) {
        tensor.setCell(value,d0index,d1index);
    }

    public void setCell(byte value, int ... indices) {
        if (indices.length != 2)
            throw new IllegalArgumentException("ByteD2Tensor is 2 dimension in size, getValue passed with " + indices.length + " indices.");
        setCell(value,indices[0],indices[1]);
    }

    public void setValue(Byte value, int ... indices) {
        setCell(value,indices);
    }

    public void setValue(Byte value, int d0index, int d1index) {
        setCell(value,d0index,d1index);
    }
    
    public ByteTypeSafeArray getTensorValues(Class<Byte> type) {
        return getTensorValues();
    }

    public ByteTypeSafeArray getTensorValues() {
       @SuppressWarnings("unchecked") //getType requirements in tensor make this ok
        ByteTypeSafeArray array = TypeSafeArrayFactory.byteTypeSafeArray(getDimensions());
        for (int[] index : IterableAbacus.getIterableAbacus(getDimensions()))
            array.set(getCell(index),index);
        return array;
    }

    public void setTensorValues(ByteTypeSafeArray valuesArray) {
        TensorImplUtil.setTensorValues(this,valuesArray);
    }

    public <I> IdByteTensor<I> getReferenceTensor(Index<I> index) {
        return (IdByteTensor<I>) super.getReferenceTensor(index);
    }

    protected ByteTensor getComposedTensor(Index<?> index) {
        return TensorImplUtil.getComposedTensor(this,index); 
    }
}