package com.pb.sawdust.tensor.decorators.primitive;

import com.pb.sawdust.tensor.TensorTest;
import com.pb.sawdust.tensor.Tensor;
import com.pb.sawdust.util.JavaType;
import com.pb.sawdust.util.array.TypeSafeArrayFactory;
import com.pb.sawdust.util.array.ByteTypeSafeArray;
import com.pb.sawdust.util.array.TypeSafeArray;
import static com.pb.sawdust.util.Range.range;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author crf <br/>
 *         Started: Jan 26, 2009 12:11:35 PM
 */
public abstract class ByteTensorTest extends TensorTest<Byte> {
    protected ByteTensor pTensor;
    protected ByteTypeSafeArray pData;

    protected JavaType getJavaType() {
        return JavaType.BYTE;
    }

    abstract protected ByteTypeSafeArray getData();
    abstract protected ByteTensor getTensor(TypeSafeArray<Byte> data);

    @Before
    public void beforeTest() {
        super.beforeTest();
        pTensor = (ByteTensor) tensor;
        pData = (ByteTypeSafeArray) data;
    }
    
    @Test
    public void testGetCell() {
        int[] index = new int[dimensions.length];
        for (int i : range(index.length))
            index[i] = random.nextInt(dimensions[i]);
        assertEquals(pData.get(index),pTensor.getCell(index));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testGetCellInvalidDimensionsTooBig() {
        int[] index = new int[dimensions.length+1];
        pTensor.getCell(index);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testGetCellInvalidDimensionsTooSmall() {
        int[] index = new int[dimensions.length-1];
        pTensor.getCell(index);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetCellInvalidIndexTooBig() {
        int[] index = new int[dimensions.length];
        int randomIndex = random.nextInt(dimensions.length);
        index[randomIndex] = dimensions[randomIndex];
        pTensor.getCell(index);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetCellInvalidIndexTooSmall() {
        int[] index = new int[dimensions.length];
        index[random.nextInt(dimensions.length)] = -1;
        pTensor.getCell(index);
    }

    @Test
    public void testSetCell() {
        int[] index = new int[dimensions.length];
        for (int i : range(index.length))
            index[i] = random.nextInt(dimensions[i]);
        byte value = getRandomElement();
        pTensor.setCell(value,index);
        assertEquals(value,pTensor.getCell(index));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSetCellInvalidDimensionsTooBig() {
        int[] index = new int[dimensions.length+1];
        pTensor.setCell(getRandomElement(),index);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSetCellInvalidDimensionsTooSmall() {
        int[] index = new int[dimensions.length-1];
        pTensor.setCell(getRandomElement(),index);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testSetCellInvalidIndexTooBig() {
        int[] index = new int[dimensions.length];
        int randomIndex = random.nextInt(dimensions.length);
        index[randomIndex] = dimensions[randomIndex];
        pTensor.setCell(getRandomElement(),index);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testSetCellInvalidIndexTooSmall() {
        int[] index = new int[dimensions.length];
        index[random.nextInt(dimensions.length)] = -1;
        pTensor.setCell(getRandomElement(),index);
    }

    @Test
    public void testSetTensorValuesPrimitiveArray() {
        ByteTypeSafeArray newValues = TypeSafeArrayFactory.byteTypeSafeArray(dimensions);
        int[] index = new int[dimensions.length];
        for (int i : range(index.length))
            index[i] = random.nextInt(dimensions[i]);
        byte value = getRandomElement();
        newValues.set(value,index);
        pTensor.setTensorValues(newValues);
        assertEquals(value,pTensor.getCell(index));
    }

    @Test
    public void testIteratorType() {
        for (Tensor<Byte> t : tensor)
            assertTrue(t instanceof ByteTensor);
    }
}