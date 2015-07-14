package com.pb.sawdust.tensor.factory;

import com.pb.sawdust.tensor.Tensor;
import com.pb.sawdust.tensor.alias.matrix.Matrix;
import com.pb.sawdust.tensor.alias.matrix.id.*;
import com.pb.sawdust.tensor.alias.matrix.primitive.*;
import com.pb.sawdust.tensor.alias.scalar.Scalar;
import com.pb.sawdust.tensor.alias.scalar.id.*;
import com.pb.sawdust.tensor.alias.scalar.primitive.*;
import com.pb.sawdust.tensor.alias.vector.Vector;
import com.pb.sawdust.tensor.alias.vector.id.*;
import com.pb.sawdust.tensor.alias.vector.primitive.*;
import com.pb.sawdust.tensor.decorators.id.IdTensor;
import com.pb.sawdust.tensor.decorators.id.primitive.*;
import com.pb.sawdust.tensor.decorators.primitive.*;
import com.pb.sawdust.tensor.read.TensorReader;

import java.util.List;

/**
 * The {@code WrappedTensorFactory} wraps a {@code TensorFactory} and delegates all method calls to it. This class is
 * useful for developing tensor factories which need to override a small subset of the factory functionality/contract.
 *
 * @author crf
 *         Started 10/18/11 10:29 AM
 */
public class WrappedTensorFactory implements TensorFactory {
    private final TensorFactory factory;

    /**
     * Constructor specifying the factory to wrap.
     *
     * @param factory
     *        The wrapped factory.
     */
    public WrappedTensorFactory(TensorFactory factory) {
        this.factory = factory;
    }

    @Override
    public ByteTensor byteTensor(int... dimensions) {
        return factory.byteTensor(dimensions);
    }

    @Override
    public ByteTensor initializedByteTensor(byte defaultValue, int... dimensions) {
        return factory.initializedByteTensor(defaultValue,dimensions);
    }

    @Override
    public <I> IdByteTensor<I> byteTensor(List<List<I>> ids, int... dimensions) {
        return factory.byteTensor(ids,dimensions);
    }

    @Override
    public <I> IdByteTensor<I> initializedByteTensor(byte defaultValue, List<List<I>> ids, int... dimensions) {
        return factory.initializedByteTensor(defaultValue,ids,dimensions);
    }

    @Override
    public <I> IdByteTensor<I> byteTensor(I[][] ids, int... dimensions) {
        return factory.byteTensor(ids,dimensions);
    }

    @Override
    public <I> IdByteTensor<I> initializedByteTensor(byte defaultValue, I[][] ids, int... dimensions) {
        return factory.initializedByteTensor(defaultValue,ids,dimensions);
    }

    @Override
    public ShortTensor shortTensor(int... dimensions) {
        return factory.shortTensor(dimensions);
    }

    @Override
    public ShortTensor initializedShortTensor(short defaultValue, int... dimensions) {
        return factory.initializedShortTensor(defaultValue,dimensions);
    }

    @Override
    public <I> IdShortTensor<I> shortTensor(List<List<I>> ids, int... dimensions) {
        return factory.shortTensor(ids,dimensions);
    }

    @Override
    public <I> IdShortTensor<I> initializedShortTensor(short defaultValue, List<List<I>> ids, int... dimensions) {
        return factory.initializedShortTensor(defaultValue,ids,dimensions);
    }

    @Override
    public <I> IdShortTensor<I> shortTensor(I[][] ids, int... dimensions) {
        return factory.shortTensor(ids,dimensions);
    }

    @Override
    public <I> IdShortTensor<I> initializedShortTensor(short defaultValue, I[][] ids, int... dimensions) {
        return factory.initializedShortTensor(defaultValue,ids,dimensions);
    }

    @Override
    public IntTensor intTensor(int... dimensions) {
        return factory.intTensor(dimensions);
    }

    @Override
    public IntTensor initializedIntTensor(int defaultValue, int... dimensions) {
        return factory.initializedIntTensor(defaultValue,dimensions);
    }

    @Override
    public <I> IdIntTensor<I> intTensor(List<List<I>> ids, int... dimensions) {
        return factory.intTensor(ids,dimensions);
    }

    @Override
    public <I> IdIntTensor<I> initializedIntTensor(int defaultValue, List<List<I>> ids, int... dimensions) {
        return factory.initializedIntTensor(defaultValue,ids,dimensions);
    }

    @Override
    public <I> IdIntTensor<I> intTensor(I[][] ids, int... dimensions) {
        return factory.intTensor(ids,dimensions);
    }

    @Override
    public <I> IdIntTensor<I> initializedIntTensor(int defaultValue, I[][] ids, int... dimensions) {
        return factory.initializedIntTensor(defaultValue,ids,dimensions);
    }

    @Override
    public LongTensor longTensor(int... dimensions) {
        return factory.longTensor(dimensions);
    }

    @Override
    public LongTensor initializedLongTensor(long defaultValue, int... dimensions) {
        return factory.initializedLongTensor(defaultValue,dimensions);
    }

    @Override
    public <I> IdLongTensor<I> longTensor(List<List<I>> ids, int... dimensions) {
        return factory.longTensor(ids,dimensions);
    }

    @Override
    public <I> IdLongTensor<I> initializedLongTensor(long defaultValue, List<List<I>> ids, int... dimensions) {
        return factory.initializedLongTensor(defaultValue,ids,dimensions);
    }

    @Override
    public <I> IdLongTensor<I> longTensor(I[][] ids, int... dimensions) {
        return factory.longTensor(ids,dimensions);
    }

    @Override
    public <I> IdLongTensor<I> initializedLongTensor(long defaultValue, I[][] ids, int... dimensions) {
        return factory.initializedLongTensor(defaultValue,ids,dimensions);
    }

    @Override
    public FloatTensor floatTensor(int... dimensions) {
        return factory.floatTensor(dimensions);
    }

    @Override
    public FloatTensor initializedFloatTensor(float defaultValue, int... dimensions) {
        return factory.initializedFloatTensor(defaultValue,dimensions);
    }

    @Override
    public <I> IdFloatTensor<I> floatTensor(List<List<I>> ids, int... dimensions) {
        return factory.floatTensor(ids,dimensions);
    }

    @Override
    public <I> IdFloatTensor<I> initializedFloatTensor(float defaultValue, List<List<I>> ids, int... dimensions) {
        return factory.initializedFloatTensor(defaultValue,ids,dimensions);
    }

    @Override
    public <I> IdFloatTensor<I> floatTensor(I[][] ids, int... dimensions) {
        return factory.floatTensor(ids,dimensions);
    }

    @Override
    public <I> IdFloatTensor<I> initializedFloatTensor(float defaultValue, I[][] ids, int... dimensions) {
        return factory.initializedFloatTensor(defaultValue,ids,dimensions);
    }

    @Override
    public DoubleTensor doubleTensor(int... dimensions) {
        return factory.doubleTensor(dimensions);
    }

    @Override
    public DoubleTensor initializedDoubleTensor(double defaultValue, int... dimensions) {
        return factory.initializedDoubleTensor(defaultValue,dimensions);
    }

    @Override
    public <I> IdDoubleTensor<I> doubleTensor(List<List<I>> ids, int... dimensions) {
        return factory.doubleTensor(ids,dimensions);
    }

    @Override
    public <I> IdDoubleTensor<I> initializedDoubleTensor(double defaultValue, List<List<I>> ids, int... dimensions) {
        return factory.initializedDoubleTensor(defaultValue,ids,dimensions);
    }

    @Override
    public <I> IdDoubleTensor<I> doubleTensor(I[][] ids, int... dimensions) {
        return factory.doubleTensor(ids,dimensions);
    }

    @Override
    public <I> IdDoubleTensor<I> initializedDoubleTensor(double defaultValue, I[][] ids, int... dimensions) {
        return factory.initializedDoubleTensor(defaultValue,ids,dimensions);
    }

    @Override
    public CharTensor charTensor(int... dimensions) {
        return factory.charTensor(dimensions);
    }

    @Override
    public CharTensor initializedCharTensor(char defaultValue, int... dimensions) {
        return factory.initializedCharTensor(defaultValue,dimensions);
    }

    @Override
    public <I> IdCharTensor<I> charTensor(List<List<I>> ids, int... dimensions) {
        return factory.charTensor(ids,dimensions);
    }

    @Override
    public <I> IdCharTensor<I> initializedCharTensor(char defaultValue, List<List<I>> ids, int... dimensions) {
        return factory.initializedCharTensor(defaultValue,ids,dimensions);
    }

    @Override
    public <I> IdCharTensor<I> charTensor(I[][] ids, int... dimensions) {
        return factory.charTensor(ids,dimensions);
    }

    @Override
    public <I> IdCharTensor<I> initializedCharTensor(char defaultValue, I[][] ids, int... dimensions) {
        return factory.initializedCharTensor(defaultValue,ids,dimensions);
    }

    @Override
    public BooleanTensor booleanTensor(int... dimensions) {
        return factory.booleanTensor(dimensions);
    }

    @Override
    public BooleanTensor initializedBooleanTensor(boolean defaultValue, int... dimensions) {
        return factory.initializedBooleanTensor(defaultValue,dimensions);
    }

    @Override
    public <I> IdBooleanTensor<I> booleanTensor(List<List<I>> ids, int... dimensions) {
        return factory.booleanTensor(ids,dimensions);
    }

    @Override
    public <I> IdBooleanTensor<I> initializedBooleanTensor(boolean defaultValue, List<List<I>> ids, int... dimensions) {
        return factory.initializedBooleanTensor(defaultValue,ids,dimensions);
    }

    @Override
    public <I> IdBooleanTensor<I> booleanTensor(I[][] ids, int... dimensions) {
        return factory.booleanTensor(ids,dimensions);
    }

    @Override
    public <I> IdBooleanTensor<I> initializedBooleanTensor(boolean defaultValue, I[][] ids, int... dimensions) {
        return factory.initializedBooleanTensor(defaultValue,ids,dimensions);
    }

    @Override
    public <T> Tensor<T> copyTensor(Tensor<T> tensor) {
        return factory.copyTensor(tensor);
    }

    @Override
    public <T,I> IdTensor<T,I> copyTensor(IdTensor<T,I> tensor) {
        return factory.copyTensor(tensor);
    }

    @Override
    public <T> Tensor<T> tensor(int... dimensions) {
        return factory.tensor(dimensions);
    }

    @Override
    public <T> Tensor<T> initializedTensor(T defaultValue, int... dimensions) {
        return factory.initializedTensor(defaultValue,dimensions);
    }

    @Override
    public <T,I> IdTensor<T,I> tensor(List<List<I>> ids, int... dimensions) {
        return factory.tensor(ids,dimensions);
    }

    @Override
    public <T,I> IdTensor<T,I> initializedTensor(T defaultValue, List<List<I>> ids, int... dimensions) {
        return factory.initializedTensor(defaultValue,ids,dimensions);
    }

    @Override
    public <T,I> IdTensor<T,I> tensor(I[][] ids, int... dimensions) {
        return factory.tensor(ids,dimensions);
    }

    @Override
    public <T,I> IdTensor<T,I> initializedTensor(T defaultValue, I[][] ids, int... dimensions) {
        return factory.initializedTensor(defaultValue,ids,dimensions);
    }

    @Override
    public <T,I> Tensor<T> tensor(TensorReader<T,I> reader) {
        return factory.tensor(reader);
    }

    @Override
    public ByteScalar byteScalar() {
        return factory.byteScalar();
    }

    @Override
    public ByteScalar initializedByteScalar(byte value) {
        return factory.initializedByteScalar(value);
    }

    @Override
    public <I> IdByteScalar<I> initializedByteScalar(byte value, I[] ids, int d0) {
        return factory.initializedByteScalar(value,ids,d0);
    }

    @Override
    public ByteVector byteVector(int d0) {
        return factory.byteVector(d0);
    }

    @Override
    public <I> IdByteVector<I> byteVector(List<I> ids, int d0) {
        return factory.byteVector(ids,d0);
    }

    @Override
    public <I> IdByteVector<I> byteVector(I[] ids, int d0) {
        return factory.byteVector(ids,d0);
    }

    @Override
    public ByteVector initializedByteVector(byte value, int d0) {
        return factory.initializedByteVector(value,d0);
    }

    @Override
    public <I> IdByteVector<I> initializedByteVector(byte value, List<I> ids, int d0) {
        return factory.initializedByteVector(value,ids,d0);
    }

    @Override
    public <I> IdByteVector<I> initializedByteVector(byte value, I[] ids, int d0) {
        return factory.initializedByteVector(value,ids,d0);
    }

    @Override
    public ByteMatrix byteMatrix(int d0, int d1) {
        return factory.byteMatrix(d0,d1);
    }

    @Override
    public <I> IdByteMatrix<I> byteMatrix(List<I> d0Ids, List<I> d1Ids, int d0, int d1) {
        return factory.byteMatrix(d0Ids,d1Ids,d0,d1);
    }

    @Override
    public <I> IdByteMatrix<I> byteMatrix(I[] d0Ids, I[] d1Ids, int d0, int d1) {
        return factory.byteMatrix(d0Ids,d1Ids,d0,d1);
    }

    @Override
    public ByteMatrix initializedByteMatrix(byte value, int d0, int d1) {
        return factory.initializedByteMatrix(value,d0,d1);
    }

    @Override
    public <I> IdByteMatrix<I> initializedByteMatrix(byte value, List<I> d0Ids, List<I> d1Ids, int d0, int d1) {
        return factory.initializedByteMatrix(value,d0Ids,d1Ids,d0,d1);
    }

    @Override
    public <I> IdByteMatrix<I> initializedByteMatrix(byte value, I[] d0Ids, I[] d1Ids, int d0, int d1) {
        return factory.initializedByteMatrix(value,d0Ids,d1Ids,d0,d1);
    }

    @Override
    public ShortScalar shortScalar() {
        return factory.shortScalar();
    }

    @Override
    public ShortScalar initializedShortScalar(short value) {
        return factory.initializedShortScalar(value);
    }

    @Override
    public <I> IdShortScalar<I> initializedShortScalar(short value, I[] ids, int d0) {
        return factory.initializedShortScalar(value,ids,d0);
    }

    @Override
    public ShortVector shortVector(int d0) {
        return factory.shortVector(d0);
    }

    @Override
    public <I> IdShortVector<I> shortVector(List<I> ids, int d0) {
        return factory.shortVector(ids,d0);
    }

    @Override
    public <I> IdShortVector<I> shortVector(I[] ids, int d0) {
        return factory.shortVector(ids,d0);
    }

    @Override
    public ShortVector initializedShortVector(short value, int d0) {
        return factory.initializedShortVector(value,d0);
    }

    @Override
    public <I> IdShortVector<I> initializedShortVector(short value, List<I> ids, int d0) {
        return factory.initializedShortVector(value,ids,d0);
    }

    @Override
    public <I> IdShortVector<I> initializedShortVector(short value, I[] ids, int d0) {
        return factory.initializedShortVector(value,ids,d0);
    }

    @Override
    public ShortMatrix shortMatrix(int d0, int d1) {
        return factory.shortMatrix(d0,d1);
    }

    @Override
    public <I> IdShortMatrix<I> shortMatrix(List<I> d0Ids, List<I> d1Ids, int d0, int d1) {
        return factory.shortMatrix(d0Ids,d1Ids,d0,d1);
    }

    @Override
    public <I> IdShortMatrix<I> shortMatrix(I[] d0Ids, I[] d1Ids, int d0, int d1) {
        return factory.shortMatrix(d0Ids,d1Ids,d0,d1);
    }

    @Override
    public ShortMatrix initializedShortMatrix(short value, int d0, int d1) {
        return factory.initializedShortMatrix(value,d0,d1);
    }

    @Override
    public <I> IdShortMatrix<I> initializedShortMatrix(short value, List<I> d0Ids, List<I> d1Ids, int d0, int d1) {
        return factory.initializedShortMatrix(value,d0Ids,d1Ids,d0,d1);
    }

    @Override
    public <I> IdShortMatrix<I> initializedShortMatrix(short value, I[] d0Ids, I[] d1Ids, int d0, int d1) {
        return factory.initializedShortMatrix(value,d0Ids,d1Ids,d0,d1);
    }

    @Override
    public IntScalar intScalar() {
        return factory.intScalar();
    }

    @Override
    public IntScalar initializedIntScalar(int value) {
        return factory.initializedIntScalar(value);
    }

    @Override
    public <I> IdIntScalar<I> initializedIntScalar(int value, I[] ids, int d0) {
        return factory.initializedIntScalar(value,ids,d0);
    }

    @Override
    public IntVector intVector(int d0) {
        return factory.intVector(d0);
    }

    @Override
    public <I> IdIntVector<I> intVector(List<I> ids, int d0) {
        return factory.intVector(ids,d0);
    }

    @Override
    public <I> IdIntVector<I> intVector(I[] ids, int d0) {
        return factory.intVector(ids,d0);
    }

    @Override
    public IntVector initializedIntVector(int value, int d0) {
        return factory.initializedIntVector(value,d0);
    }

    @Override
    public <I> IdIntVector<I> initializedIntVector(int value, List<I> ids, int d0) {
        return factory.initializedIntVector(value,ids,d0);
    }

    @Override
    public <I> IdIntVector<I> initializedIntVector(int value, I[] ids, int d0) {
        return factory.initializedIntVector(value,ids,d0);
    }

    @Override
    public IntMatrix intMatrix(int d0, int d1) {
        return factory.intMatrix(d0,d1);
    }

    @Override
    public <I> IdIntMatrix<I> intMatrix(List<I> d0Ids, List<I> d1Ids, int d0, int d1) {
        return factory.intMatrix(d0Ids,d1Ids,d0,d1);
    }

    @Override
    public <I> IdIntMatrix<I> intMatrix(I[] d0Ids, I[] d1Ids, int d0, int d1) {
        return factory.intMatrix(d0Ids,d1Ids,d0,d1);
    }

    @Override
    public IntMatrix initializedIntMatrix(int value, int d0, int d1) {
        return factory.initializedIntMatrix(value,d0,d1);
    }

    @Override
    public <I> IdIntMatrix<I> initializedIntMatrix(int value, List<I> d0Ids, List<I> d1Ids, int d0, int d1) {
        return factory.initializedIntMatrix(value,d0Ids,d1Ids,d0,d1);
    }

    @Override
    public <I> IdIntMatrix<I> initializedIntMatrix(int value, I[] d0Ids, I[] d1Ids, int d0, int d1) {
        return factory.initializedIntMatrix(value,d0Ids,d1Ids,d0,d1);
    }

    @Override
    public LongScalar longScalar() {
        return factory.longScalar();
    }

    @Override
    public LongScalar initializedLongScalar(long value) {
        return factory.initializedLongScalar(value);
    }

    @Override
    public <I> IdLongScalar<I> initializedLongScalar(long value, I[] ids, int d0) {
        return factory.initializedLongScalar(value,ids,d0);
    }

    @Override
    public LongVector longVector(int d0) {
        return factory.longVector(d0);
    }

    @Override
    public <I> IdLongVector<I> longVector(List<I> ids, int d0) {
        return factory.longVector(ids,d0);
    }

    @Override
    public <I> IdLongVector<I> longVector(I[] ids, int d0) {
        return factory.longVector(ids,d0);
    }

    @Override
    public LongVector initializedLongVector(long value, int d0) {
        return factory.initializedLongVector(value,d0);
    }

    @Override
    public <I> IdLongVector<I> initializedLongVector(long value, List<I> ids, int d0) {
        return factory.initializedLongVector(value,ids,d0);
    }

    @Override
    public <I> IdLongVector<I> initializedLongVector(long value, I[] ids, int d0) {
        return factory.initializedLongVector(value,ids,d0);
    }

    @Override
    public LongMatrix longMatrix(int d0, int d1) {
        return factory.longMatrix(d0,d1);
    }

    @Override
    public <I> IdLongMatrix<I> longMatrix(List<I> d0Ids, List<I> d1Ids, int d0, int d1) {
        return factory.longMatrix(d0Ids,d1Ids,d0,d1);
    }

    @Override
    public <I> IdLongMatrix<I> longMatrix(I[] d0Ids, I[] d1Ids, int d0, int d1) {
        return factory.longMatrix(d0Ids,d1Ids,d0,d1);
    }

    @Override
    public LongMatrix initializedLongMatrix(long value, int d0, int d1) {
        return factory.initializedLongMatrix(value,d0,d1);
    }

    @Override
    public <I> IdLongMatrix<I> initializedLongMatrix(long value, List<I> d0Ids, List<I> d1Ids, int d0, int d1) {
        return factory.initializedLongMatrix(value,d0Ids,d1Ids,d0,d1);
    }

    @Override
    public <I> IdLongMatrix<I> initializedLongMatrix(long value, I[] d0Ids, I[] d1Ids, int d0, int d1) {
        return factory.initializedLongMatrix(value,d0Ids,d1Ids,d0,d1);
    }

    @Override
    public FloatScalar floatScalar() {
        return factory.floatScalar();
    }

    @Override
    public FloatScalar initializedFloatScalar(float value) {
        return factory.initializedFloatScalar(value);
    }

    @Override
    public <I> IdFloatScalar<I> initializedFloatScalar(float value, I[] ids, int d0) {
        return factory.initializedFloatScalar(value,ids,d0);
    }

    @Override
    public FloatVector floatVector(int d0) {
        return factory.floatVector(d0);
    }

    @Override
    public <I> IdFloatVector<I> floatVector(List<I> ids, int d0) {
        return factory.floatVector(ids,d0);
    }

    @Override
    public <I> IdFloatVector<I> floatVector(I[] ids, int d0) {
        return factory.floatVector(ids,d0);
    }

    @Override
    public FloatVector initializedFloatVector(float value, int d0) {
        return factory.initializedFloatVector(value,d0);
    }

    @Override
    public <I> IdFloatVector<I> initializedFloatVector(float value, List<I> ids, int d0) {
        return factory.initializedFloatVector(value,ids,d0);
    }

    @Override
    public <I> IdFloatVector<I> initializedFloatVector(float value, I[] ids, int d0) {
        return factory.initializedFloatVector(value,ids,d0);
    }

    @Override
    public FloatMatrix floatMatrix(int d0, int d1) {
        return factory.floatMatrix(d0,d1);
    }

    @Override
    public <I> IdFloatMatrix<I> floatMatrix(List<I> d0Ids, List<I> d1Ids, int d0, int d1) {
        return factory.floatMatrix(d0Ids,d1Ids,d0,d1);
    }

    @Override
    public <I> IdFloatMatrix<I> floatMatrix(I[] d0Ids, I[] d1Ids, int d0, int d1) {
        return factory.floatMatrix(d0Ids,d1Ids,d0,d1);
    }

    @Override
    public FloatMatrix initializedFloatMatrix(float value, int d0, int d1) {
        return factory.initializedFloatMatrix(value,d0,d1);
    }

    @Override
    public <I> IdFloatMatrix<I> initializedFloatMatrix(float value, List<I> d0Ids, List<I> d1Ids, int d0, int d1) {
        return factory.initializedFloatMatrix(value,d0Ids,d1Ids,d0,d1);
    }

    @Override
    public <I> IdFloatMatrix<I> initializedFloatMatrix(float value, I[] d0Ids, I[] d1Ids, int d0, int d1) {
        return factory.initializedFloatMatrix(value,d0Ids,d1Ids,d0,d1);
    }

    @Override
    public DoubleScalar doubleScalar() {
        return factory.doubleScalar();
    }

    @Override
    public DoubleScalar initializedDoubleScalar(double value) {
        return factory.initializedDoubleScalar(value);
    }

    @Override
    public <I> IdDoubleScalar<I> initializedDoubleScalar(double value, I[] ids, int d0) {
        return factory.initializedDoubleScalar(value,ids,d0);
    }

    @Override
    public DoubleVector doubleVector(int d0) {
        return factory.doubleVector(d0);
    }

    @Override
    public <I> IdDoubleVector<I> doubleVector(List<I> ids, int d0) {
        return factory.doubleVector(ids,d0);
    }

    @Override
    public <I> IdDoubleVector<I> doubleVector(I[] ids, int d0) {
        return factory.doubleVector(ids,d0);
    }

    @Override
    public DoubleVector initializedDoubleVector(double value, int d0) {
        return factory.initializedDoubleVector(value,d0);
    }

    @Override
    public <I> IdDoubleVector<I> initializedDoubleVector(double value, List<I> ids, int d0) {
        return factory.initializedDoubleVector(value,ids,d0);
    }

    @Override
    public <I> IdDoubleVector<I> initializedDoubleVector(double value, I[] ids, int d0) {
        return factory.initializedDoubleVector(value,ids,d0);
    }

    @Override
    public DoubleMatrix doubleMatrix(int d0, int d1) {
        return factory.doubleMatrix(d0,d1);
    }

    @Override
    public <I> IdDoubleMatrix<I> doubleMatrix(List<I> d0Ids, List<I> d1Ids, int d0, int d1) {
        return factory.doubleMatrix(d0Ids,d1Ids,d0,d1);
    }

    @Override
    public <I> IdDoubleMatrix<I> doubleMatrix(I[] d0Ids, I[] d1Ids, int d0, int d1) {
        return factory.doubleMatrix(d0Ids,d1Ids,d0,d1);
    }

    @Override
    public DoubleMatrix initializedDoubleMatrix(double value, int d0, int d1) {
        return factory.initializedDoubleMatrix(value,d0,d1);
    }

    @Override
    public <I> IdDoubleMatrix<I> initializedDoubleMatrix(double value, List<I> d0Ids, List<I> d1Ids, int d0, int d1) {
        return factory.initializedDoubleMatrix(value,d0Ids,d1Ids,d0,d1);
    }

    @Override
    public <I> IdDoubleMatrix<I> initializedDoubleMatrix(double value, I[] d0Ids, I[] d1Ids, int d0, int d1) {
        return factory.initializedDoubleMatrix(value,d0Ids,d1Ids,d0,d1);
    }

    @Override
    public CharScalar charScalar() {
        return factory.charScalar();
    }

    @Override
    public CharScalar initializedCharScalar(char value) {
        return factory.initializedCharScalar(value);
    }

    @Override
    public <I> IdCharScalar<I> initializedCharScalar(char value, I[] ids, int d0) {
        return factory.initializedCharScalar(value,ids,d0);
    }

    @Override
    public CharVector charVector(int d0) {
        return factory.charVector(d0);
    }

    @Override
    public <I> IdCharVector<I> charVector(List<I> ids, int d0) {
        return factory.charVector(ids,d0);
    }

    @Override
    public <I> IdCharVector<I> charVector(I[] ids, int d0) {
        return factory.charVector(ids,d0);
    }

    @Override
    public CharVector initializedCharVector(char value, int d0) {
        return factory.initializedCharVector(value,d0);
    }

    @Override
    public <I> IdCharVector<I> initializedCharVector(char value, List<I> ids, int d0) {
        return factory.initializedCharVector(value,ids,d0);
    }

    @Override
    public <I> IdCharVector<I> initializedCharVector(char value, I[] ids, int d0) {
        return factory.initializedCharVector(value,ids,d0);
    }

    @Override
    public CharMatrix charMatrix(int d0, int d1) {
        return factory.charMatrix(d0,d1);
    }

    @Override
    public <I> IdCharMatrix<I> charMatrix(List<I> d0Ids, List<I> d1Ids, int d0, int d1) {
        return factory.charMatrix(d0Ids,d1Ids,d0,d1);
    }

    @Override
    public <I> IdCharMatrix<I> charMatrix(I[] d0Ids, I[] d1Ids, int d0, int d1) {
        return factory.charMatrix(d0Ids,d1Ids,d0,d1);
    }

    @Override
    public CharMatrix initializedCharMatrix(char value, int d0, int d1) {
        return factory.initializedCharMatrix(value,d0,d1);
    }

    @Override
    public <I> IdCharMatrix<I> initializedCharMatrix(char value, List<I> d0Ids, List<I> d1Ids, int d0, int d1) {
        return factory.initializedCharMatrix(value,d0Ids,d1Ids,d0,d1);
    }

    @Override
    public <I> IdCharMatrix<I> initializedCharMatrix(char value, I[] d0Ids, I[] d1Ids, int d0, int d1) {
        return factory.initializedCharMatrix(value,d0Ids,d1Ids,d0,d1);
    }

    @Override
    public BooleanScalar booleanScalar() {
        return factory.booleanScalar();
    }

    @Override
    public BooleanScalar initializedBooleanScalar(boolean value) {
        return factory.initializedBooleanScalar(value);
    }

    @Override
    public <I> IdBooleanScalar<I> initializedBooleanScalar(boolean value, I[] ids, int d0) {
        return factory.initializedBooleanScalar(value,ids,d0);
    }

    @Override
    public BooleanVector booleanVector(int d0) {
        return factory.booleanVector(d0);
    }

    @Override
    public <I> IdBooleanVector<I> booleanVector(List<I> ids, int d0) {
        return factory.booleanVector(ids,d0);
    }

    @Override
    public <I> IdBooleanVector<I> booleanVector(I[] ids, int d0) {
        return factory.booleanVector(ids,d0);
    }

    @Override
    public BooleanVector initializedBooleanVector(boolean value, int d0) {
        return factory.initializedBooleanVector(value,d0);
    }

    @Override
    public <I> IdBooleanVector<I> initializedBooleanVector(boolean value, List<I> ids, int d0) {
        return factory.initializedBooleanVector(value,ids,d0);
    }

    @Override
    public <I> IdBooleanVector<I> initializedBooleanVector(boolean value, I[] ids, int d0) {
        return factory.initializedBooleanVector(value,ids,d0);
    }

    @Override
    public BooleanMatrix booleanMatrix(int d0, int d1) {
        return factory.booleanMatrix(d0,d1);
    }

    @Override
    public <I> IdBooleanMatrix<I> booleanMatrix(List<I> d0Ids, List<I> d1Ids, int d0, int d1) {
        return factory.booleanMatrix(d0Ids,d1Ids,d0,d1);
    }

    @Override
    public <I> IdBooleanMatrix<I> booleanMatrix(I[] d0Ids, I[] d1Ids, int d0, int d1) {
        return factory.booleanMatrix(d0Ids,d1Ids,d0,d1);
    }

    @Override
    public BooleanMatrix initializedBooleanMatrix(boolean value, int d0, int d1) {
        return factory.initializedBooleanMatrix(value,d0,d1);
    }

    @Override
    public <I> IdBooleanMatrix<I> initializedBooleanMatrix(boolean value, List<I> d0Ids, List<I> d1Ids, int d0, int d1) {
        return factory.initializedBooleanMatrix(value,d0Ids,d1Ids,d0,d1);
    }

    @Override
    public <I> IdBooleanMatrix<I> initializedBooleanMatrix(boolean value, I[] d0Ids, I[] d1Ids, int d0, int d1) {
        return factory.initializedBooleanMatrix(value,d0Ids,d1Ids,d0,d1);
    }

    @Override
    public <T> Scalar<T> scalar() {
        return factory.scalar();
    }

    @Override
    public <T> Scalar<T> initializedScalar(T value) {
        return factory.initializedScalar(value);
    }

    @Override
    public <T,I> IdScalar<T,I> initializedScalar(T value, I[] ids, int d0) {
        return factory.initializedScalar(value,ids,d0);
    }

    @Override
    public <T> Vector<T> vector(int d0) {
        return factory.vector(d0);
    }

    @Override
    public <T,I> IdVector<T,I> vector(List<I> ids, int d0) {
        return factory.vector(ids,d0);
    }

    @Override
    public <T,I> IdVector<T,I> vector(I[] ids, int d0) {
        return factory.vector(ids,d0);
    }

    @Override
    public <T> Vector<T> initializedVector(T value, int d0) {
        return factory.initializedVector(value,d0);
    }

    @Override
    public <T,I> IdVector<T,I> initializedVector(T value, List<I> ids, int d0) {
        return factory.initializedVector(value,ids,d0);
    }

    @Override
    public <T,I> IdVector<T,I> initializedVector(T value, I[] ids, int d0) {
        return factory.initializedVector(value,ids,d0);
    }

    @Override
    public <T> Matrix<T> matrix(int d0, int d1) {
        return factory.matrix(d0,d1);
    }

    @Override
    public <T,I> IdMatrix<T,I> matrix(List<I> d0Ids, List<I> d1Ids, int d0, int d1) {
        return factory.matrix(d0Ids,d1Ids,d0,d1);
    }

    @Override
    public <T,I> IdMatrix<T,I> matrix(I[] d0Ids, I[] d1Ids, int d0, int d1) {
        return factory.matrix(d0Ids,d1Ids,d0,d1);
    }

    @Override
    public <T> Matrix<T> initializedMatrix(T value, int d0, int d1) {
        return factory.initializedMatrix(value,d0,d1);
    }

    @Override
    public <T,I> IdMatrix<T,I> initializedMatrix(T value, List<I> d0Ids, List<I> d1Ids, int d0, int d1) {
        return factory.initializedMatrix(value,d0Ids,d1Ids,d0,d1);
    }

    @Override
    public <T,I> IdMatrix<T,I> initializedMatrix(T value, I[] d0Ids, I[] d1Ids, int d0, int d1) {
        return factory.initializedMatrix(value,d0Ids,d1Ids,d0,d1);
    }
}