package com.pb.sawdust.tensor;

import static com.pb.sawdust.util.Range.*;

import com.pb.sawdust.tensor.factory.LiterateTensorFactory;
import com.pb.sawdust.util.JavaType;
import com.pb.sawdust.util.array.ArrayUtil;
import com.pb.sawdust.tensor.decorators.primitive.*;
import com.pb.sawdust.tensor.decorators.primitive.size.*;
import com.pb.sawdust.tensor.decorators.size.*;
import com.pb.sawdust.tensor.alias.scalar.impl.*;

import java.lang.reflect.Array;

/**
 * The {@code LinearTensor} class offers access to "linear" tensor implementations. A linear tensor is one whose values are internally held as a 
 * sequential list (array) of values. A linear tensor's memory footprint will be somewhat lower than an equivalent {@code ArrayTensor}, though its
 * access times will be slightly slower.
 * <p>
 * The maximum number of tensor elements allowed in a {@code LinearTensor} is 4,611,686,014,132,420,609 ({@code Integer.MAX_VALUE*Integer.MAX_VALUE}).
 *
 * @author crf <br/>
 *         Started: Oct 20, 2008 9:55:32 AM
 *         Revised: Dec 14, 2009 12:35:34 PM
 */
public final class LinearTensor extends LiterateTensorFactory {
    private LinearTensor() {}
    
    private static final LinearTensor factory = new LinearTensor();
    
    /**
     Method to get a linear tensor factory.
     
     @return a {@code LinearTensor} instance.
     */
    public static LinearTensor getFactory() {
        return factory;
    }
    

    public ByteTensor byteTensor(int ... dimensions) {
        switch (dimensions.length) {
            case 0 : return new ByteScalarImpl();
            case 1 : return new ByteD1LinearTensor(new ByteLinearTensor(dimensions));
            case 2 : return new ByteD2LinearTensor(new ByteLinearTensor(dimensions));
            case 3 : return new ByteD3LinearTensor(new ByteLinearTensor(dimensions));
            case 4 : return new ByteD4LinearTensor(new ByteLinearTensor(dimensions));
            case 5 : return new ByteD5LinearTensor(new ByteLinearTensor(dimensions));
            case 6 : return new ByteD6LinearTensor(new ByteLinearTensor(dimensions));
            case 7 : return new ByteD7LinearTensor(new ByteLinearTensor(dimensions));
            case 8 : return new ByteD8LinearTensor(new ByteLinearTensor(dimensions));
            case 9 : return new ByteD9LinearTensor(new ByteLinearTensor(dimensions));
            default : return new ByteLinearTensor(dimensions);
        }
    }
    public ByteTensor initializedByteTensor(byte defaultValue, int ... dimensions) {
        switch (dimensions.length) {
            case 0 : return new ByteScalarImpl(defaultValue);
            case 1 : return new ByteD1LinearTensor(new ByteLinearTensor(true,defaultValue,dimensions));
            case 2 : return new ByteD2LinearTensor(new ByteLinearTensor(true,defaultValue,dimensions));
            case 3 : return new ByteD3LinearTensor(new ByteLinearTensor(true,defaultValue,dimensions));
            case 4 : return new ByteD4LinearTensor(new ByteLinearTensor(true,defaultValue,dimensions));
            case 5 : return new ByteD5LinearTensor(new ByteLinearTensor(true,defaultValue,dimensions));
            case 6 : return new ByteD6LinearTensor(new ByteLinearTensor(true,defaultValue,dimensions));
            case 7 : return new ByteD7LinearTensor(new ByteLinearTensor(true,defaultValue,dimensions));
            case 8 : return new ByteD8LinearTensor(new ByteLinearTensor(true,defaultValue,dimensions));
            case 9 : return new ByteD9LinearTensor(new ByteLinearTensor(true,defaultValue,dimensions));
            default : return new ByteLinearTensor(true,defaultValue,dimensions);
        }
    }

    public ShortTensor shortTensor(int ... dimensions) {
        switch (dimensions.length) {
            case 0 : return new ShortScalarImpl();
            case 1 : return new ShortD1LinearTensor(new ShortLinearTensor(dimensions));
            case 2 : return new ShortD2LinearTensor(new ShortLinearTensor(dimensions));
            case 3 : return new ShortD3LinearTensor(new ShortLinearTensor(dimensions));
            case 4 : return new ShortD4LinearTensor(new ShortLinearTensor(dimensions));
            case 5 : return new ShortD5LinearTensor(new ShortLinearTensor(dimensions));
            case 6 : return new ShortD6LinearTensor(new ShortLinearTensor(dimensions));
            case 7 : return new ShortD7LinearTensor(new ShortLinearTensor(dimensions));
            case 8 : return new ShortD8LinearTensor(new ShortLinearTensor(dimensions));
            case 9 : return new ShortD9LinearTensor(new ShortLinearTensor(dimensions));
            default : return new ShortLinearTensor(dimensions);
        }
    }
    public ShortTensor initializedShortTensor(short defaultValue, int ... dimensions) {
        switch (dimensions.length) {
            case 0 : return new ShortScalarImpl(defaultValue);
            case 1 : return new ShortD1LinearTensor(new ShortLinearTensor(true,defaultValue,dimensions));
            case 2 : return new ShortD2LinearTensor(new ShortLinearTensor(true,defaultValue,dimensions));
            case 3 : return new ShortD3LinearTensor(new ShortLinearTensor(true,defaultValue,dimensions));
            case 4 : return new ShortD4LinearTensor(new ShortLinearTensor(true,defaultValue,dimensions));
            case 5 : return new ShortD5LinearTensor(new ShortLinearTensor(true,defaultValue,dimensions));
            case 6 : return new ShortD6LinearTensor(new ShortLinearTensor(true,defaultValue,dimensions));
            case 7 : return new ShortD7LinearTensor(new ShortLinearTensor(true,defaultValue,dimensions));
            case 8 : return new ShortD8LinearTensor(new ShortLinearTensor(true,defaultValue,dimensions));
            case 9 : return new ShortD9LinearTensor(new ShortLinearTensor(true,defaultValue,dimensions));
            default : return new ShortLinearTensor(true,defaultValue,dimensions);
        }
    }

    public IntTensor intTensor(int ... dimensions) {
        switch (dimensions.length) {
            case 0 : return new IntScalarImpl();
            case 1 : return new IntD1LinearTensor(new IntLinearTensor(dimensions));
            case 2 : return new IntD2LinearTensor(new IntLinearTensor(dimensions));
            case 3 : return new IntD3LinearTensor(new IntLinearTensor(dimensions));
            case 4 : return new IntD4LinearTensor(new IntLinearTensor(dimensions));
            case 5 : return new IntD5LinearTensor(new IntLinearTensor(dimensions));
            case 6 : return new IntD6LinearTensor(new IntLinearTensor(dimensions));
            case 7 : return new IntD7LinearTensor(new IntLinearTensor(dimensions));
            case 8 : return new IntD8LinearTensor(new IntLinearTensor(dimensions));
            case 9 : return new IntD9LinearTensor(new IntLinearTensor(dimensions));
            default : return new IntLinearTensor(dimensions);
        }
    }
    public IntTensor initializedIntTensor(int defaultValue, int ... dimensions) {
        switch (dimensions.length) {
            case 0 : return new IntScalarImpl(defaultValue);
            case 1 : return new IntD1LinearTensor(new IntLinearTensor(true,defaultValue,dimensions));
            case 2 : return new IntD2LinearTensor(new IntLinearTensor(true,defaultValue,dimensions));
            case 3 : return new IntD3LinearTensor(new IntLinearTensor(true,defaultValue,dimensions));
            case 4 : return new IntD4LinearTensor(new IntLinearTensor(true,defaultValue,dimensions));
            case 5 : return new IntD5LinearTensor(new IntLinearTensor(true,defaultValue,dimensions));
            case 6 : return new IntD6LinearTensor(new IntLinearTensor(true,defaultValue,dimensions));
            case 7 : return new IntD7LinearTensor(new IntLinearTensor(true,defaultValue,dimensions));
            case 8 : return new IntD8LinearTensor(new IntLinearTensor(true,defaultValue,dimensions));
            case 9 : return new IntD9LinearTensor(new IntLinearTensor(true,defaultValue,dimensions));
            default : return new IntLinearTensor(true,defaultValue,dimensions);
        }
    }

    public LongTensor longTensor(int ... dimensions) {
        switch (dimensions.length) {
            case 0 : return new LongScalarImpl();
            case 1 : return new LongD1LinearTensor(new LongLinearTensor(dimensions));
            case 2 : return new LongD2LinearTensor(new LongLinearTensor(dimensions));
            case 3 : return new LongD3LinearTensor(new LongLinearTensor(dimensions));
            case 4 : return new LongD4LinearTensor(new LongLinearTensor(dimensions));
            case 5 : return new LongD5LinearTensor(new LongLinearTensor(dimensions));
            case 6 : return new LongD6LinearTensor(new LongLinearTensor(dimensions));
            case 7 : return new LongD7LinearTensor(new LongLinearTensor(dimensions));
            case 8 : return new LongD8LinearTensor(new LongLinearTensor(dimensions));
            case 9 : return new LongD9LinearTensor(new LongLinearTensor(dimensions));
            default : return new LongLinearTensor(dimensions);
        }
    }
    public LongTensor initializedLongTensor(long defaultValue, int ... dimensions) {
        switch (dimensions.length) {
            case 0 : return new LongScalarImpl(defaultValue);
            case 1 : return new LongD1LinearTensor(new LongLinearTensor(true,defaultValue,dimensions));
            case 2 : return new LongD2LinearTensor(new LongLinearTensor(true,defaultValue,dimensions));
            case 3 : return new LongD3LinearTensor(new LongLinearTensor(true,defaultValue,dimensions));
            case 4 : return new LongD4LinearTensor(new LongLinearTensor(true,defaultValue,dimensions));
            case 5 : return new LongD5LinearTensor(new LongLinearTensor(true,defaultValue,dimensions));
            case 6 : return new LongD6LinearTensor(new LongLinearTensor(true,defaultValue,dimensions));
            case 7 : return new LongD7LinearTensor(new LongLinearTensor(true,defaultValue,dimensions));
            case 8 : return new LongD8LinearTensor(new LongLinearTensor(true,defaultValue,dimensions));
            case 9 : return new LongD9LinearTensor(new LongLinearTensor(true,defaultValue,dimensions));
            default : return new LongLinearTensor(true,defaultValue,dimensions);
        }
    }

    public FloatTensor floatTensor(int ... dimensions) {
        switch (dimensions.length) {
            case 0 : return new FloatScalarImpl();
            case 1 : return new FloatD1LinearTensor(new FloatLinearTensor(dimensions));
            case 2 : return new FloatD2LinearTensor(new FloatLinearTensor(dimensions));
            case 3 : return new FloatD3LinearTensor(new FloatLinearTensor(dimensions));
            case 4 : return new FloatD4LinearTensor(new FloatLinearTensor(dimensions));
            case 5 : return new FloatD5LinearTensor(new FloatLinearTensor(dimensions));
            case 6 : return new FloatD6LinearTensor(new FloatLinearTensor(dimensions));
            case 7 : return new FloatD7LinearTensor(new FloatLinearTensor(dimensions));
            case 8 : return new FloatD8LinearTensor(new FloatLinearTensor(dimensions));
            case 9 : return new FloatD9LinearTensor(new FloatLinearTensor(dimensions));
            default : return new FloatLinearTensor(dimensions);
        }
    }
    public FloatTensor initializedFloatTensor(float defaultValue, int ... dimensions) {
        switch (dimensions.length) {
            case 0 : return new FloatScalarImpl(defaultValue);
            case 1 : return new FloatD1LinearTensor(new FloatLinearTensor(true,defaultValue,dimensions));
            case 2 : return new FloatD2LinearTensor(new FloatLinearTensor(true,defaultValue,dimensions));
            case 3 : return new FloatD3LinearTensor(new FloatLinearTensor(true,defaultValue,dimensions));
            case 4 : return new FloatD4LinearTensor(new FloatLinearTensor(true,defaultValue,dimensions));
            case 5 : return new FloatD5LinearTensor(new FloatLinearTensor(true,defaultValue,dimensions));
            case 6 : return new FloatD6LinearTensor(new FloatLinearTensor(true,defaultValue,dimensions));
            case 7 : return new FloatD7LinearTensor(new FloatLinearTensor(true,defaultValue,dimensions));
            case 8 : return new FloatD8LinearTensor(new FloatLinearTensor(true,defaultValue,dimensions));
            case 9 : return new FloatD9LinearTensor(new FloatLinearTensor(true,defaultValue,dimensions));
            default : return new FloatLinearTensor(true,defaultValue,dimensions);
        }
    }

    public DoubleTensor doubleTensor(int ... dimensions) {
        switch (dimensions.length) {
            case 0 : return new DoubleScalarImpl();
            case 1 : return new DoubleD1LinearTensor(new DoubleLinearTensor(dimensions));
            case 2 : return new DoubleD2LinearTensor(new DoubleLinearTensor(dimensions));
            case 3 : return new DoubleD3LinearTensor(new DoubleLinearTensor(dimensions));
            case 4 : return new DoubleD4LinearTensor(new DoubleLinearTensor(dimensions));
            case 5 : return new DoubleD5LinearTensor(new DoubleLinearTensor(dimensions));
            case 6 : return new DoubleD6LinearTensor(new DoubleLinearTensor(dimensions));
            case 7 : return new DoubleD7LinearTensor(new DoubleLinearTensor(dimensions));
            case 8 : return new DoubleD8LinearTensor(new DoubleLinearTensor(dimensions));
            case 9 : return new DoubleD9LinearTensor(new DoubleLinearTensor(dimensions));
            default : return new DoubleLinearTensor(dimensions);
        }
    }
    public DoubleTensor initializedDoubleTensor(double defaultValue, int ... dimensions) {
        switch (dimensions.length) {
            case 0 : return new DoubleScalarImpl(defaultValue);
            case 1 : return new DoubleD1LinearTensor(new DoubleLinearTensor(true,defaultValue,dimensions));
            case 2 : return new DoubleD2LinearTensor(new DoubleLinearTensor(true,defaultValue,dimensions));
            case 3 : return new DoubleD3LinearTensor(new DoubleLinearTensor(true,defaultValue,dimensions));
            case 4 : return new DoubleD4LinearTensor(new DoubleLinearTensor(true,defaultValue,dimensions));
            case 5 : return new DoubleD5LinearTensor(new DoubleLinearTensor(true,defaultValue,dimensions));
            case 6 : return new DoubleD6LinearTensor(new DoubleLinearTensor(true,defaultValue,dimensions));
            case 7 : return new DoubleD7LinearTensor(new DoubleLinearTensor(true,defaultValue,dimensions));
            case 8 : return new DoubleD8LinearTensor(new DoubleLinearTensor(true,defaultValue,dimensions));
            case 9 : return new DoubleD9LinearTensor(new DoubleLinearTensor(true,defaultValue,dimensions));
            default : return new DoubleLinearTensor(true,defaultValue,dimensions);
        }
    }

    public CharTensor charTensor(int ... dimensions) {
        switch (dimensions.length) {
            case 0 : return new CharScalarImpl();
            case 1 : return new CharD1LinearTensor(new CharLinearTensor(dimensions));
            case 2 : return new CharD2LinearTensor(new CharLinearTensor(dimensions));
            case 3 : return new CharD3LinearTensor(new CharLinearTensor(dimensions));
            case 4 : return new CharD4LinearTensor(new CharLinearTensor(dimensions));
            case 5 : return new CharD5LinearTensor(new CharLinearTensor(dimensions));
            case 6 : return new CharD6LinearTensor(new CharLinearTensor(dimensions));
            case 7 : return new CharD7LinearTensor(new CharLinearTensor(dimensions));
            case 8 : return new CharD8LinearTensor(new CharLinearTensor(dimensions));
            case 9 : return new CharD9LinearTensor(new CharLinearTensor(dimensions));
            default : return new CharLinearTensor(dimensions);
        }
    }
    public CharTensor initializedCharTensor(char defaultValue, int ... dimensions) {
        switch (dimensions.length) {
            case 0 : return new CharScalarImpl(defaultValue);
            case 1 : return new CharD1LinearTensor(new CharLinearTensor(true,defaultValue,dimensions));
            case 2 : return new CharD2LinearTensor(new CharLinearTensor(true,defaultValue,dimensions));
            case 3 : return new CharD3LinearTensor(new CharLinearTensor(true,defaultValue,dimensions));
            case 4 : return new CharD4LinearTensor(new CharLinearTensor(true,defaultValue,dimensions));
            case 5 : return new CharD5LinearTensor(new CharLinearTensor(true,defaultValue,dimensions));
            case 6 : return new CharD6LinearTensor(new CharLinearTensor(true,defaultValue,dimensions));
            case 7 : return new CharD7LinearTensor(new CharLinearTensor(true,defaultValue,dimensions));
            case 8 : return new CharD8LinearTensor(new CharLinearTensor(true,defaultValue,dimensions));
            case 9 : return new CharD9LinearTensor(new CharLinearTensor(true,defaultValue,dimensions));
            default : return new CharLinearTensor(true,defaultValue,dimensions);
        }
    }

    public BooleanTensor booleanTensor(int ... dimensions) {
        switch (dimensions.length) {
            case 0 : return new BooleanScalarImpl();
            case 1 : return new BooleanD1LinearTensor(new BooleanLinearTensor(dimensions));
            case 2 : return new BooleanD2LinearTensor(new BooleanLinearTensor(dimensions));
            case 3 : return new BooleanD3LinearTensor(new BooleanLinearTensor(dimensions));
            case 4 : return new BooleanD4LinearTensor(new BooleanLinearTensor(dimensions));
            case 5 : return new BooleanD5LinearTensor(new BooleanLinearTensor(dimensions));
            case 6 : return new BooleanD6LinearTensor(new BooleanLinearTensor(dimensions));
            case 7 : return new BooleanD7LinearTensor(new BooleanLinearTensor(dimensions));
            case 8 : return new BooleanD8LinearTensor(new BooleanLinearTensor(dimensions));
            case 9 : return new BooleanD9LinearTensor(new BooleanLinearTensor(dimensions));
            default : return new BooleanLinearTensor(dimensions);
        }
    }
    public BooleanTensor initializedBooleanTensor(boolean defaultValue, int ... dimensions) {
        switch (dimensions.length) {
            case 0 : return new BooleanScalarImpl(defaultValue);
            case 1 : return new BooleanD1LinearTensor(new BooleanLinearTensor(true,defaultValue,dimensions));
            case 2 : return new BooleanD2LinearTensor(new BooleanLinearTensor(true,defaultValue,dimensions));
            case 3 : return new BooleanD3LinearTensor(new BooleanLinearTensor(true,defaultValue,dimensions));
            case 4 : return new BooleanD4LinearTensor(new BooleanLinearTensor(true,defaultValue,dimensions));
            case 5 : return new BooleanD5LinearTensor(new BooleanLinearTensor(true,defaultValue,dimensions));
            case 6 : return new BooleanD6LinearTensor(new BooleanLinearTensor(true,defaultValue,dimensions));
            case 7 : return new BooleanD7LinearTensor(new BooleanLinearTensor(true,defaultValue,dimensions));
            case 8 : return new BooleanD8LinearTensor(new BooleanLinearTensor(true,defaultValue,dimensions));
            case 9 : return new BooleanD9LinearTensor(new BooleanLinearTensor(true,defaultValue,dimensions));
            default : return new BooleanLinearTensor(true,defaultValue,dimensions);
        }
    }

    public <T> Tensor<T> tensor(int ... dimensions) {
        switch (dimensions.length) {
            case 0 : return new ScalarImpl<T>();
            case 1 : return new ObjectD1LinearTensor<T>(new ObjectLinearTensor<T>(dimensions));
            case 2 : return new ObjectD2LinearTensor<T>(new ObjectLinearTensor<T>(dimensions));
            case 3 : return new ObjectD3LinearTensor<T>(new ObjectLinearTensor<T>(dimensions));
            case 4 : return new ObjectD4LinearTensor<T>(new ObjectLinearTensor<T>(dimensions));
            case 5 : return new ObjectD5LinearTensor<T>(new ObjectLinearTensor<T>(dimensions));
            case 6 : return new ObjectD6LinearTensor<T>(new ObjectLinearTensor<T>(dimensions));
            case 7 : return new ObjectD7LinearTensor<T>(new ObjectLinearTensor<T>(dimensions));
            case 8 : return new ObjectD8LinearTensor<T>(new ObjectLinearTensor<T>(dimensions));
            case 9 : return new ObjectD9LinearTensor<T>(new ObjectLinearTensor<T>(dimensions));
            default : return new ObjectLinearTensor<T>(dimensions);
        }
    }
    
    public <T> Tensor<T> initializedTensor(T defaultValue, int ... dimensions) {
        switch (dimensions.length) {
            case 0 : return new ScalarImpl<T>(defaultValue);
            case 1 : return new ObjectD1LinearTensor<T>(new ObjectLinearTensor<T>(true,defaultValue,dimensions));
            case 2 : return new ObjectD2LinearTensor<T>(new ObjectLinearTensor<T>(true,defaultValue,dimensions));
            case 3 : return new ObjectD3LinearTensor<T>(new ObjectLinearTensor<T>(true,defaultValue,dimensions));
            case 4 : return new ObjectD4LinearTensor<T>(new ObjectLinearTensor<T>(true,defaultValue,dimensions));
            case 5 : return new ObjectD5LinearTensor<T>(new ObjectLinearTensor<T>(true,defaultValue,dimensions));
            case 6 : return new ObjectD6LinearTensor<T>(new ObjectLinearTensor<T>(true,defaultValue,dimensions));
            case 7 : return new ObjectD7LinearTensor<T>(new ObjectLinearTensor<T>(true,defaultValue,dimensions));
            case 8 : return new ObjectD8LinearTensor<T>(new ObjectLinearTensor<T>(true,defaultValue,dimensions));
            case 9 : return new ObjectD9LinearTensor<T>(new ObjectLinearTensor<T>(true,defaultValue,dimensions));
            default : return new ObjectLinearTensor<T>(true,defaultValue,dimensions);
        }
    }

    private static class LinearIndex {
        private static final double maxElementCount = ((double) Integer.MAX_VALUE)*((double) Integer.MAX_VALUE);
        
        private final boolean rollover;
        private final long[] offsets;
        private final long size;
        private final int[] dimensions;

        private LinearIndex(int ... dimensions) {
            long size = 1l;
            double testSize = 1d;
            for (int d : dimensions) {
                size *= d;
                testSize *= (double) d;
            }
            if (testSize > maxElementCount)
                throw new IllegalStateException("Total number of possible tensor elements cannot exceed " + maxElementCount + ", found " + testSize);
            offsets = new long[dimensions.length];
            offsets[dimensions.length-1] = 1l;
            for (int i : range(dimensions.length-1,0,-1))
                offsets[i-1] = offsets[i]*((long) dimensions[i]);
            rollover = size > Integer.MAX_VALUE;
            this.size = size;
            this.dimensions = dimensions;
        }


        public boolean rollsOver() {
            return rollover;
        }

        public int getRollOverCount() {
            return (int) (size / Integer.MAX_VALUE);
        }

        public int getFinalLinearIndex() {
            return (int) (size % Integer.MAX_VALUE);
        }

        public int[] getPoint(int ... indices) {
            TensorImplUtil.checkIndexLengths(dimensions,indices);
            long point = 0;
            int position = 0;
            for (int index : indices)
                point += index*offsets[position++];
            if (rollover)
                return new int[] {(int) (point / Integer.MAX_VALUE),(int) (point % Integer.MAX_VALUE)};
            else
                return new int[] {0,(int) point};
        }     

        public int[] getPoint(int d0Index) {
            long point = offsets[0]*d0Index;
            if (rollover)
                return new int[] {(int) (point / Integer.MAX_VALUE),(int) (point % Integer.MAX_VALUE)};
            else
                return new int[] {0,(int) point};
        }

        public int[] getPoint(int d0Index, int d1Index) {
            long point = offsets[0]*d0Index + offsets[1]*d1Index;
            if (rollover)
                return new int[] {(int) (point / Integer.MAX_VALUE),(int) (point % Integer.MAX_VALUE)};
            else
                return new int[] {0,(int) point};
        }                                                         

        public int[] getPoint(int d0Index, int d1Index, int d2Index) {
            long point = offsets[0]*d0Index + offsets[1]*d1Index + offsets[2]*d2Index;
            if (rollover)
                return new int[] {(int) (point / Integer.MAX_VALUE),(int) (point % Integer.MAX_VALUE)};
            else
                return new int[] {0,(int) point};
        }

        public int[] getPoint(int d0Index, int d1Index, int d2Index, int d3Index) {
            long point = offsets[0]*d0Index + offsets[1]*d1Index + offsets[2]*d2Index + offsets[3]*d3Index;
            if (rollover)
                return new int[] {(int) (point / Integer.MAX_VALUE),(int) (point % Integer.MAX_VALUE)};
            else
                return new int[] {0,(int) point};
        }

        public int[] getPoint(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index) {
            long point = offsets[0]*d0Index + offsets[1]*d1Index + offsets[2]*d2Index + offsets[3]*d3Index + offsets[4]*d4Index;
            if (rollover)
                return new int[] {(int) (point / Integer.MAX_VALUE),(int) (point % Integer.MAX_VALUE)};
            else
                return new int[] {0,(int) point};
        }

        public int[] getPoint(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index) {
            long point = offsets[0]*d0Index + offsets[1]*d1Index + offsets[2]*d2Index + offsets[3]*d3Index + offsets[4]*d4Index + offsets[5]*d5Index;
            if (rollover)
                return new int[] {(int) (point / Integer.MAX_VALUE),(int) (point % Integer.MAX_VALUE)};
            else
                return new int[] {0,(int) point};
        }

        public int[] getPoint(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index) {
            long point = offsets[0]*d0Index + offsets[1]*d1Index + offsets[2]*d2Index + offsets[3]*d3Index + offsets[4]*d4Index + offsets[5]*d5Index + offsets[6]*d6Index;
            if (rollover)
                return new int[] {(int) (point / Integer.MAX_VALUE),(int) (point % Integer.MAX_VALUE)};
            else
                return new int[] {0,(int) point};
        }

        public int[] getPoint(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index) {
            long point = offsets[0]*d0Index + offsets[1]*d1Index + offsets[2]*d2Index + offsets[3]*d3Index + offsets[4]*d4Index + offsets[5]*d5Index + offsets[6]*d6Index + offsets[7]*d7Index;
            if (rollover)
                return new int[] {(int) (point / Integer.MAX_VALUE),(int) (point % Integer.MAX_VALUE)};
            else
                return new int[] {0,(int) point};
        }

        public int[] getPoint(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index, int d8Index) {
            long point = offsets[0]*d0Index + offsets[1]*d1Index + offsets[2]*d2Index + offsets[3]*d3Index + offsets[4]*d4Index + offsets[5]*d5Index + offsets[6]*d6Index + offsets[7]*d7Index + offsets[8]*d8Index;
            if (rollover)
                return new int[] {(int) (point / Integer.MAX_VALUE),(int) (point % Integer.MAX_VALUE)};
            else
                return new int[] {0,(int) point};
        }
    }

    private static class ByteLinearTensor extends AbstractByteTensor {
        private final LinearIndex index;
        private final byte[][] tensor;

        private ByteLinearTensor(int ... dimensions) {
            super(dimensions);
            index = new LinearIndex(getDimensions());
            tensor = new byte[index.getRollOverCount()+1][];
            for (int i : range(index.getRollOverCount()))
                tensor[i] = new byte[Integer.MAX_VALUE];
            tensor[tensor.length-1] = new byte[index.getFinalLinearIndex()];
        }
        
        private ByteLinearTensor(boolean defaultIndicator, byte defaultValue, int ... dimensions) {
            this(dimensions);
            ArrayUtil.deepPrimitiveFill(tensor,defaultValue);
        }
        
        public byte getCell(int ... indices) {
            TensorImplUtil.checkIndices(this,indices);
            return getCellUnchecked(indices);
        }
        
        public void setCell(byte value, int ... indices) {
            TensorImplUtil.checkIndices(this,indices);
            setCellUnchecked(value,indices);
        }
        
        private byte getCellUnchecked(int ... indices) {
            int[] ind = index.getPoint(indices);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(byte value, int ... indices) {
            int[] ind = index.getPoint(indices);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private byte getCellUnchecked(int d0Index) {
            int[] ind = index.getPoint(d0Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(byte value, int d0Index) {
            int[] ind = index.getPoint(d0Index);
            tensor[ind[0]][ind[1]] = value;
        }   
        
        private byte getCellUnchecked(int d0Index, int d1Index) {
            int[] ind = index.getPoint(d0Index,d1Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(byte value, int d0Index, int d1Index) {
            int[] ind = index.getPoint(d0Index,d1Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private byte getCellUnchecked(int d0Index, int d1Index, int d2Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(byte value, int d0Index, int d1Index, int d2Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private byte getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(byte value, int d0Index, int d1Index, int d2Index, int d3Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private byte getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(byte value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private byte getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(byte value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private byte getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(byte value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private byte getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(byte value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private byte getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index, int d8Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index,d8Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(byte value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index, int d8Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index,d8Index);
            tensor[ind[0]][ind[1]] = value;
        }
    }

    private static class ShortLinearTensor extends AbstractShortTensor {
        private final LinearIndex index;
        private final short[][] tensor;

        private ShortLinearTensor(int ... dimensions) {
            super(dimensions);
            index = new LinearIndex(getDimensions());
            tensor = new short[index.getRollOverCount()+1][];
            for (int i : range(index.getRollOverCount()))
                tensor[i] = new short[Integer.MAX_VALUE];
            tensor[tensor.length-1] = new short[index.getFinalLinearIndex()];
        }
        
        private ShortLinearTensor(boolean defaultIndicator, short defaultValue, int ... dimensions) {
            this(dimensions);
            ArrayUtil.deepPrimitiveFill(tensor,defaultValue);
        }
        
        public short getCell(int ... indices) {
            TensorImplUtil.checkIndices(this,indices);
            return getCellUnchecked(indices);
        }
        
        public void setCell(short value, int ... indices) {
            TensorImplUtil.checkIndices(this,indices);
            setCellUnchecked(value,indices);
        }
        
        private short getCellUnchecked(int ... indices) {
            int[] ind = index.getPoint(indices);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(short value, int ... indices) {
            int[] ind = index.getPoint(indices);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private short getCellUnchecked(int d0Index) {
            int[] ind = index.getPoint(d0Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(short value, int d0Index) {
            int[] ind = index.getPoint(d0Index);
            tensor[ind[0]][ind[1]] = value;
        }   
        
        private short getCellUnchecked(int d0Index, int d1Index) {
            int[] ind = index.getPoint(d0Index,d1Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(short value, int d0Index, int d1Index) {
            int[] ind = index.getPoint(d0Index,d1Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private short getCellUnchecked(int d0Index, int d1Index, int d2Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(short value, int d0Index, int d1Index, int d2Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private short getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(short value, int d0Index, int d1Index, int d2Index, int d3Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private short getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(short value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private short getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(short value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private short getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(short value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private short getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(short value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private short getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index, int d8Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index,d8Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(short value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index, int d8Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index,d8Index);
            tensor[ind[0]][ind[1]] = value;
        }
    }

    private static class IntLinearTensor extends AbstractIntTensor {
        private final LinearIndex index;
        private final int[][] tensor;

        private IntLinearTensor(int ... dimensions) {
            super(dimensions);
            index = new LinearIndex(getDimensions());
            tensor = new int[index.getRollOverCount()+1][];
            for (int i : range(index.getRollOverCount()))
                tensor[i] = new int[Integer.MAX_VALUE];
            tensor[tensor.length-1] = new int[index.getFinalLinearIndex()];
        }
        
        private IntLinearTensor(boolean defaultIndicator, int defaultValue, int ... dimensions) {
            this(dimensions);
            ArrayUtil.deepPrimitiveFill(tensor,defaultValue);
        }
        
        public int getCell(int ... indices) {
            TensorImplUtil.checkIndices(this,indices);
            return getCellUnchecked(indices);
        }
        
        public void setCell(int value, int ... indices) {
            TensorImplUtil.checkIndices(this,indices);
            setCellUnchecked(value,indices);
        }
        
        private int getCellUnchecked(int ... indices) {
            int[] ind = index.getPoint(indices);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(int value, int ... indices) {
            int[] ind = index.getPoint(indices);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private int getCellUnchecked(int d0Index) {
            int[] ind = index.getPoint(d0Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(int value, int d0Index) {
            int[] ind = index.getPoint(d0Index);
            tensor[ind[0]][ind[1]] = value;
        }   
        
        private int getCellUnchecked(int d0Index, int d1Index) {
            int[] ind = index.getPoint(d0Index,d1Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(int value, int d0Index, int d1Index) {
            int[] ind = index.getPoint(d0Index,d1Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private int getCellUnchecked(int d0Index, int d1Index, int d2Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(int value, int d0Index, int d1Index, int d2Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private int getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(int value, int d0Index, int d1Index, int d2Index, int d3Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private int getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(int value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private int getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(int value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private int getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(int value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private int getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(int value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private int getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index, int d8Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index,d8Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(int value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index, int d8Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index,d8Index);
            tensor[ind[0]][ind[1]] = value;
        }
    }

    private static class LongLinearTensor extends AbstractLongTensor {
        private final LinearIndex index;
        private final long[][] tensor;

        private LongLinearTensor(int ... dimensions) {
            super(dimensions);
            index = new LinearIndex(getDimensions());
            tensor = new long[index.getRollOverCount()+1][];
            for (int i : range(index.getRollOverCount()))
                tensor[i] = new long[Integer.MAX_VALUE];
            tensor[tensor.length-1] = new long[index.getFinalLinearIndex()];
        }
        
        private LongLinearTensor(boolean defaultIndicator, long defaultValue, int ... dimensions) {
            this(dimensions);
            ArrayUtil.deepPrimitiveFill(tensor,defaultValue);
        }
        
        public long getCell(int ... indices) {
            TensorImplUtil.checkIndices(this,indices);
            return getCellUnchecked(indices);
        }
        
        public void setCell(long value, int ... indices) {
            TensorImplUtil.checkIndices(this,indices);
            setCellUnchecked(value,indices);
        }
        
        private long getCellUnchecked(int ... indices) {
            int[] ind = index.getPoint(indices);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(long value, int ... indices) {
            int[] ind = index.getPoint(indices);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private long getCellUnchecked(int d0Index) {
            int[] ind = index.getPoint(d0Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(long value, int d0Index) {
            int[] ind = index.getPoint(d0Index);
            tensor[ind[0]][ind[1]] = value;
        }   
        
        private long getCellUnchecked(int d0Index, int d1Index) {
            int[] ind = index.getPoint(d0Index,d1Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(long value, int d0Index, int d1Index) {
            int[] ind = index.getPoint(d0Index,d1Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private long getCellUnchecked(int d0Index, int d1Index, int d2Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(long value, int d0Index, int d1Index, int d2Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private long getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(long value, int d0Index, int d1Index, int d2Index, int d3Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private long getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(long value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private long getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(long value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private long getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(long value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private long getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(long value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private long getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index, int d8Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index,d8Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(long value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index, int d8Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index,d8Index);
            tensor[ind[0]][ind[1]] = value;
        }
    }

    private static class FloatLinearTensor extends AbstractFloatTensor {
        private final LinearIndex index;
        private final float[][] tensor;

        private FloatLinearTensor(int ... dimensions) {
            super(dimensions);
            index = new LinearIndex(getDimensions());
            tensor = new float[index.getRollOverCount()+1][];
            for (int i : range(index.getRollOverCount()))
                tensor[i] = new float[Integer.MAX_VALUE];
            tensor[tensor.length-1] = new float[index.getFinalLinearIndex()];
        }
        
        private FloatLinearTensor(boolean defaultIndicator, float defaultValue, int ... dimensions) {
            this(dimensions);
            ArrayUtil.deepPrimitiveFill(tensor,defaultValue);
        }
        
        public float getCell(int ... indices) {
            TensorImplUtil.checkIndices(this,indices);
            return getCellUnchecked(indices);
        }
        
        public void setCell(float value, int ... indices) {
            TensorImplUtil.checkIndices(this,indices);
            setCellUnchecked(value,indices);
        }
        
        private float getCellUnchecked(int ... indices) {
            int[] ind = index.getPoint(indices);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(float value, int ... indices) {
            int[] ind = index.getPoint(indices);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private float getCellUnchecked(int d0Index) {
            int[] ind = index.getPoint(d0Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(float value, int d0Index) {
            int[] ind = index.getPoint(d0Index);
            tensor[ind[0]][ind[1]] = value;
        }   
        
        private float getCellUnchecked(int d0Index, int d1Index) {
            int[] ind = index.getPoint(d0Index,d1Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(float value, int d0Index, int d1Index) {
            int[] ind = index.getPoint(d0Index,d1Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private float getCellUnchecked(int d0Index, int d1Index, int d2Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(float value, int d0Index, int d1Index, int d2Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private float getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(float value, int d0Index, int d1Index, int d2Index, int d3Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private float getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(float value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private float getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(float value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private float getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(float value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private float getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(float value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private float getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index, int d8Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index,d8Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(float value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index, int d8Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index,d8Index);
            tensor[ind[0]][ind[1]] = value;
        }
    }

    private static class DoubleLinearTensor extends AbstractDoubleTensor {
        private final LinearIndex index;
        private final double[][] tensor;

        private DoubleLinearTensor(int ... dimensions) {
            super(dimensions);
            index = new LinearIndex(getDimensions());
            tensor = new double[index.getRollOverCount()+1][];
            for (int i : range(index.getRollOverCount()))
                tensor[i] = new double[Integer.MAX_VALUE];
            tensor[tensor.length-1] = new double[index.getFinalLinearIndex()];
        }
        
        private DoubleLinearTensor(boolean defaultIndicator, double defaultValue, int ... dimensions) {
            this(dimensions);
            ArrayUtil.deepPrimitiveFill(tensor,defaultValue);
        }
        
        public double getCell(int ... indices) {
            TensorImplUtil.checkIndices(this,indices);
            return getCellUnchecked(indices);
        }
        
        public void setCell(double value, int ... indices) {
            TensorImplUtil.checkIndices(this,indices);
            setCellUnchecked(value,indices);
        }
        
        private double getCellUnchecked(int ... indices) {
            int[] ind = index.getPoint(indices);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(double value, int ... indices) {
            int[] ind = index.getPoint(indices);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private double getCellUnchecked(int d0Index) {
            int[] ind = index.getPoint(d0Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(double value, int d0Index) {
            int[] ind = index.getPoint(d0Index);
            tensor[ind[0]][ind[1]] = value;
        }   
        
        private double getCellUnchecked(int d0Index, int d1Index) {
            int[] ind = index.getPoint(d0Index,d1Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(double value, int d0Index, int d1Index) {
            int[] ind = index.getPoint(d0Index,d1Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private double getCellUnchecked(int d0Index, int d1Index, int d2Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(double value, int d0Index, int d1Index, int d2Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private double getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(double value, int d0Index, int d1Index, int d2Index, int d3Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private double getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(double value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private double getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(double value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private double getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(double value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private double getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(double value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private double getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index, int d8Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index,d8Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(double value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index, int d8Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index,d8Index);
            tensor[ind[0]][ind[1]] = value;
        }
    }

    private static class CharLinearTensor extends AbstractCharTensor {
        private final LinearIndex index;
        private final char[][] tensor;

        private CharLinearTensor(int ... dimensions) {
            super(dimensions);
            index = new LinearIndex(getDimensions());
            tensor = new char[index.getRollOverCount()+1][];
            for (int i : range(index.getRollOverCount()))
                tensor[i] = new char[Integer.MAX_VALUE];
            tensor[tensor.length-1] = new char[index.getFinalLinearIndex()];
        }
        
        private CharLinearTensor(boolean defaultIndicator, char defaultValue, int ... dimensions) {
            this(dimensions);
            ArrayUtil.deepPrimitiveFill(tensor,defaultValue);
        }
        
        public char getCell(int ... indices) {
            TensorImplUtil.checkIndices(this,indices);
            return getCellUnchecked(indices);
        }
        
        public void setCell(char value, int ... indices) {
            TensorImplUtil.checkIndices(this,indices);
            setCellUnchecked(value,indices);
        }
        
        private char getCellUnchecked(int ... indices) {
            int[] ind = index.getPoint(indices);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(char value, int ... indices) {
            int[] ind = index.getPoint(indices);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private char getCellUnchecked(int d0Index) {
            int[] ind = index.getPoint(d0Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(char value, int d0Index) {
            int[] ind = index.getPoint(d0Index);
            tensor[ind[0]][ind[1]] = value;
        }   
        
        private char getCellUnchecked(int d0Index, int d1Index) {
            int[] ind = index.getPoint(d0Index,d1Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(char value, int d0Index, int d1Index) {
            int[] ind = index.getPoint(d0Index,d1Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private char getCellUnchecked(int d0Index, int d1Index, int d2Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(char value, int d0Index, int d1Index, int d2Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private char getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(char value, int d0Index, int d1Index, int d2Index, int d3Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private char getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(char value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private char getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(char value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private char getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(char value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private char getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(char value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private char getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index, int d8Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index,d8Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(char value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index, int d8Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index,d8Index);
            tensor[ind[0]][ind[1]] = value;
        }
    }

    private static class BooleanLinearTensor extends AbstractBooleanTensor {
        private final LinearIndex index;
        private final boolean[][] tensor;

        private BooleanLinearTensor(int ... dimensions) {
            super(dimensions);
            index = new LinearIndex(getDimensions());
            tensor = new boolean[index.getRollOverCount()+1][];
            for (int i : range(index.getRollOverCount()))
                tensor[i] = new boolean[Integer.MAX_VALUE];
            tensor[tensor.length-1] = new boolean[index.getFinalLinearIndex()];
        }
        
        private BooleanLinearTensor(boolean defaultIndicator, boolean defaultValue, int ... dimensions) {
            this(dimensions);
            ArrayUtil.deepPrimitiveFill(tensor,defaultValue);
        }
        
        public boolean getCell(int ... indices) {
            TensorImplUtil.checkIndices(this,indices);
            return getCellUnchecked(indices);
        }
        
        public void setCell(boolean value, int ... indices) {
            TensorImplUtil.checkIndices(this,indices);
            setCellUnchecked(value,indices);
        }
        
        private boolean getCellUnchecked(int ... indices) {
            int[] ind = index.getPoint(indices);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(boolean value, int ... indices) {
            int[] ind = index.getPoint(indices);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private boolean getCellUnchecked(int d0Index) {
            int[] ind = index.getPoint(d0Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(boolean value, int d0Index) {
            int[] ind = index.getPoint(d0Index);
            tensor[ind[0]][ind[1]] = value;
        }   
        
        private boolean getCellUnchecked(int d0Index, int d1Index) {
            int[] ind = index.getPoint(d0Index,d1Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(boolean value, int d0Index, int d1Index) {
            int[] ind = index.getPoint(d0Index,d1Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private boolean getCellUnchecked(int d0Index, int d1Index, int d2Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(boolean value, int d0Index, int d1Index, int d2Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private boolean getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(boolean value, int d0Index, int d1Index, int d2Index, int d3Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private boolean getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(boolean value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private boolean getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(boolean value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private boolean getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(boolean value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private boolean getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(boolean value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private boolean getCellUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index, int d8Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index,d8Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setCellUnchecked(boolean value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index, int d8Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index,d8Index);
            tensor[ind[0]][ind[1]] = value;
        }
    }

    private static class ObjectLinearTensor<T> extends AbstractTensor<T> {
        private final LinearIndex index;
        private final T[][] tensor;

        private ObjectLinearTensor(int ... dimensions) {
            super(dimensions);
            index = new LinearIndex(getDimensions());
            tensor = get2DTypeArray(index.getRollOverCount()+1);
            for (int i : range(index.getRollOverCount()))
                tensor[i] = getTypeArray(Integer.MAX_VALUE);
            tensor[tensor.length-1] = getTypeArray(index.getFinalLinearIndex());
        }
        
        private ObjectLinearTensor(boolean defaultIndicator, T defaultValue, int ... dimensions) {
            this(dimensions);
            ArrayUtil.deepFill(tensor,defaultValue);
        }

       @SuppressWarnings("unchecked") //used only internally - this is equivalent because of erasure
        private T[][] get2DTypeArray(int size) {
            return (T[][]) Array.newInstance((new Object[0]).getClass(),size);
        }

       @SuppressWarnings("unchecked") //used only internally - this is equivalent because of erasure
        private T[] getTypeArray(int size) {
            return (T[]) Array.newInstance(Object.class,size);
        }

        public JavaType getType() {
            return JavaType.OBJECT;
        }

        public T getValue(int ... indices) {
            TensorImplUtil.checkIndices(this,indices);
            return getValueUnchecked(indices);
        }

        public void setValue(T value, int ... indices) {
            TensorImplUtil.checkIndices(this,indices);
            setValueUnchecked(value,indices);
        }

        private T getValueUnchecked(int ... indices) {
            int[] ind = index.getPoint(indices);
            return tensor[ind[0]][ind[1]];
        }

        private void setValueUnchecked(T value, int ... indices) {
            int[] ind = index.getPoint(indices);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private T getValueUnchecked(int d0Index) {
            int[] ind = index.getPoint(d0Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setValueUnchecked(T value, int d0Index) {
            int[] ind = index.getPoint(d0Index);
            tensor[ind[0]][ind[1]] = value;
        }   
        
        private T getValueUnchecked(int d0Index, int d1Index) {
            int[] ind = index.getPoint(d0Index,d1Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setValueUnchecked(T value, int d0Index, int d1Index) {
            int[] ind = index.getPoint(d0Index,d1Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private T getValueUnchecked(int d0Index, int d1Index, int d2Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setValueUnchecked(T value, int d0Index, int d1Index, int d2Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private T getValueUnchecked(int d0Index, int d1Index, int d2Index, int d3Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setValueUnchecked(T value, int d0Index, int d1Index, int d2Index, int d3Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private T getValueUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setValueUnchecked(T value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private T getValueUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setValueUnchecked(T value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private T getValueUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setValueUnchecked(T value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private T getValueUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setValueUnchecked(T value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index);
            tensor[ind[0]][ind[1]] = value;
        }
        
        private T getValueUnchecked(int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index, int d8Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index,d8Index);
            return tensor[ind[0]][ind[1]];
        }
        
        private void setValueUnchecked(T value, int d0Index, int d1Index, int d2Index, int d3Index, int d4Index, int d5Index, int d6Index, int d7Index, int d8Index) {
            int[] ind = index.getPoint(d0Index,d1Index,d2Index,d3Index,d4Index,d5Index,d6Index,d7Index,d8Index);
            tensor[ind[0]][ind[1]] = value;
        }
    }
 
    private static class ByteD1LinearTensor extends ByteD1TensorShell {
        private final ByteLinearTensor tensor;
        
        private ByteD1LinearTensor(ByteLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public byte getCell(int index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),index);
            return tensor.getCellUnchecked(index);
        }
        
        public void setCell(byte value,int index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),index);
            tensor.setCellUnchecked(value,index);
        }
    }
 
    private static class ShortD1LinearTensor extends ShortD1TensorShell {
        private final ShortLinearTensor tensor;
        
        private ShortD1LinearTensor(ShortLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public short getCell(int index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),index);
            return tensor.getCellUnchecked(index);
        }
        
        public void setCell(short value,int index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),index);
            tensor.setCellUnchecked(value,index);
        }
    }
 
    private static class IntD1LinearTensor extends IntD1TensorShell {
        private final IntLinearTensor tensor;
        
        private IntD1LinearTensor(IntLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public int getCell(int index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),index);
            return tensor.getCellUnchecked(index);
        }
        
        public void setCell(int value,int index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),index);
            tensor.setCellUnchecked(value,index);
        }
    }
 
    private static class LongD1LinearTensor extends LongD1TensorShell {
        private final LongLinearTensor tensor;
        
        private LongD1LinearTensor(LongLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public long getCell(int index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),index);
            return tensor.getCellUnchecked(index);
        }
        
        public void setCell(long value,int index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),index);
            tensor.setCellUnchecked(value,index);
        }
    }
 
    private static class FloatD1LinearTensor extends FloatD1TensorShell {
        private final FloatLinearTensor tensor;
        
        private FloatD1LinearTensor(FloatLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public float getCell(int index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),index);
            return tensor.getCellUnchecked(index);
        }
        
        public void setCell(float value,int index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),index);
            tensor.setCellUnchecked(value,index);
        }
    }
 
    private static class DoubleD1LinearTensor extends DoubleD1TensorShell {
        private final DoubleLinearTensor tensor;
        
        private DoubleD1LinearTensor(DoubleLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public double getCell(int index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),index);
            return tensor.getCellUnchecked(index);
        }
        
        public void setCell(double value,int index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),index);
            tensor.setCellUnchecked(value,index);
        }
    }
 
    private static class CharD1LinearTensor extends CharD1TensorShell {
        private final CharLinearTensor tensor;
        
        private CharD1LinearTensor(CharLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public char getCell(int index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),index);
            return tensor.getCellUnchecked(index);
        }
        
        public void setCell(char value,int index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),index);
            tensor.setCellUnchecked(value,index);
        }
    }
 
    private static class BooleanD1LinearTensor extends BooleanD1TensorShell {
        private final BooleanLinearTensor tensor;
        
        private BooleanD1LinearTensor(BooleanLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public boolean getCell(int index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),index);
            return tensor.getCellUnchecked(index);
        }
        
        public void setCell(boolean value,int index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),index);
            tensor.setCellUnchecked(value,index);
        }
    }
 
    private static class ByteD2LinearTensor extends ByteD2TensorShell {
        private final ByteLinearTensor tensor;
        
        private ByteD2LinearTensor(ByteLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public byte getCell(int d0index, int d1index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index);
            return tensor.getCellUnchecked(d0index,d1index);
        }
        
        public void setCell(byte value,int d0index, int d1index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index);
            tensor.setCellUnchecked(value,d0index,d1index);
        }
    }
 
    private static class ShortD2LinearTensor extends ShortD2TensorShell {
        private final ShortLinearTensor tensor;
        
        private ShortD2LinearTensor(ShortLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public short getCell(int d0index, int d1index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index);
            return tensor.getCellUnchecked(d0index,d1index);
        }
        
        public void setCell(short value,int d0index, int d1index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index);
            tensor.setCellUnchecked(value,d0index,d1index);
        }
    }
 
    private static class IntD2LinearTensor extends IntD2TensorShell {
        private final IntLinearTensor tensor;
        
        private IntD2LinearTensor(IntLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public int getCell(int d0index, int d1index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index);
            return tensor.getCellUnchecked(d0index,d1index);
        }
        
        public void setCell(int value,int d0index, int d1index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index);
            tensor.setCellUnchecked(value,d0index,d1index);
        }
    }
 
    private static class LongD2LinearTensor extends LongD2TensorShell {
        private final LongLinearTensor tensor;
        
        private LongD2LinearTensor(LongLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public long getCell(int d0index, int d1index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index);
            return tensor.getCellUnchecked(d0index,d1index);
        }
        
        public void setCell(long value,int d0index, int d1index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index);
            tensor.setCellUnchecked(value,d0index,d1index);
        }
    }
 
    private static class FloatD2LinearTensor extends FloatD2TensorShell {
        private final FloatLinearTensor tensor;
        
        private FloatD2LinearTensor(FloatLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public float getCell(int d0index, int d1index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index);
            return tensor.getCellUnchecked(d0index,d1index);
        }
        
        public void setCell(float value,int d0index, int d1index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index);
            tensor.setCellUnchecked(value,d0index,d1index);
        }
    }
 
    private static class DoubleD2LinearTensor extends DoubleD2TensorShell {
        private final DoubleLinearTensor tensor;
        
        private DoubleD2LinearTensor(DoubleLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public double getCell(int d0index, int d1index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index);
            return tensor.getCellUnchecked(d0index,d1index);
        }
        
        public void setCell(double value,int d0index, int d1index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index);
            tensor.setCellUnchecked(value,d0index,d1index);
        }
    }
 
    private static class CharD2LinearTensor extends CharD2TensorShell {
        private final CharLinearTensor tensor;
        
        private CharD2LinearTensor(CharLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public char getCell(int d0index, int d1index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index);
            return tensor.getCellUnchecked(d0index,d1index);
        }
        
        public void setCell(char value,int d0index, int d1index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index);
            tensor.setCellUnchecked(value,d0index,d1index);
        }
    }
 
    private static class BooleanD2LinearTensor extends BooleanD2TensorShell {
        private final BooleanLinearTensor tensor;
        
        private BooleanD2LinearTensor(BooleanLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public boolean getCell(int d0index, int d1index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index);
            return tensor.getCellUnchecked(d0index,d1index);
        }
        
        public void setCell(boolean value,int d0index, int d1index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index);
            tensor.setCellUnchecked(value,d0index,d1index);
        }
    }
 
    private static class ByteD3LinearTensor extends ByteD3TensorShell {
        private final ByteLinearTensor tensor;
        
        private ByteD3LinearTensor(ByteLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public byte getCell(int d0index, int d1index, int d2index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index);
            return tensor.getCellUnchecked(d0index,d1index,d2index);
        }
        
        public void setCell(byte value,int d0index, int d1index, int d2index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index);
        }
    }
 
    private static class ShortD3LinearTensor extends ShortD3TensorShell {
        private final ShortLinearTensor tensor;
        
        private ShortD3LinearTensor(ShortLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public short getCell(int d0index, int d1index, int d2index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index);
            return tensor.getCellUnchecked(d0index,d1index,d2index);
        }
        
        public void setCell(short value,int d0index, int d1index, int d2index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index);
        }
    }
 
    private static class IntD3LinearTensor extends IntD3TensorShell {
        private final IntLinearTensor tensor;
        
        private IntD3LinearTensor(IntLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public int getCell(int d0index, int d1index, int d2index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index);
            return tensor.getCellUnchecked(d0index,d1index,d2index);
        }
        
        public void setCell(int value,int d0index, int d1index, int d2index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index);
        }
    }
 
    private static class LongD3LinearTensor extends LongD3TensorShell {
        private final LongLinearTensor tensor;
        
        private LongD3LinearTensor(LongLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public long getCell(int d0index, int d1index, int d2index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index);
            return tensor.getCellUnchecked(d0index,d1index,d2index);
        }
        
        public void setCell(long value,int d0index, int d1index, int d2index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index);
        }
    }
 
    private static class FloatD3LinearTensor extends FloatD3TensorShell {
        private final FloatLinearTensor tensor;
        
        private FloatD3LinearTensor(FloatLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public float getCell(int d0index, int d1index, int d2index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index);
            return tensor.getCellUnchecked(d0index,d1index,d2index);
        }
        
        public void setCell(float value,int d0index, int d1index, int d2index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index);
        }
    }
 
    private static class DoubleD3LinearTensor extends DoubleD3TensorShell {
        private final DoubleLinearTensor tensor;
        
        private DoubleD3LinearTensor(DoubleLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public double getCell(int d0index, int d1index, int d2index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index);
            return tensor.getCellUnchecked(d0index,d1index,d2index);
        }
        
        public void setCell(double value,int d0index, int d1index, int d2index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index);
        }
    }
 
    private static class CharD3LinearTensor extends CharD3TensorShell {
        private final CharLinearTensor tensor;
        
        private CharD3LinearTensor(CharLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public char getCell(int d0index, int d1index, int d2index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index);
            return tensor.getCellUnchecked(d0index,d1index,d2index);
        }
        
        public void setCell(char value,int d0index, int d1index, int d2index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index);
        }
    }
 
    private static class BooleanD3LinearTensor extends BooleanD3TensorShell {
        private final BooleanLinearTensor tensor;
        
        private BooleanD3LinearTensor(BooleanLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public boolean getCell(int d0index, int d1index, int d2index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index);
            return tensor.getCellUnchecked(d0index,d1index,d2index);
        }
        
        public void setCell(boolean value,int d0index, int d1index, int d2index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index);
        }
    }
 
    private static class ByteD4LinearTensor extends ByteD4TensorShell {
        private final ByteLinearTensor tensor;
        
        private ByteD4LinearTensor(ByteLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public byte getCell(int d0index, int d1index, int d2index, int d3index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index);
        }
        
        public void setCell(byte value,int d0index, int d1index, int d2index, int d3index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index);
        }
    }
 
    private static class ShortD4LinearTensor extends ShortD4TensorShell {
        private final ShortLinearTensor tensor;
        
        private ShortD4LinearTensor(ShortLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public short getCell(int d0index, int d1index, int d2index, int d3index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index);
        }
        
        public void setCell(short value,int d0index, int d1index, int d2index, int d3index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index);
        }
    }
 
    private static class IntD4LinearTensor extends IntD4TensorShell {
        private final IntLinearTensor tensor;
        
        private IntD4LinearTensor(IntLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public int getCell(int d0index, int d1index, int d2index, int d3index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index);
        }
        
        public void setCell(int value,int d0index, int d1index, int d2index, int d3index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index);
        }
    }
 
    private static class LongD4LinearTensor extends LongD4TensorShell {
        private final LongLinearTensor tensor;
        
        private LongD4LinearTensor(LongLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public long getCell(int d0index, int d1index, int d2index, int d3index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index);
        }
        
        public void setCell(long value,int d0index, int d1index, int d2index, int d3index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index);
        }
    }
 
    private static class FloatD4LinearTensor extends FloatD4TensorShell {
        private final FloatLinearTensor tensor;
        
        private FloatD4LinearTensor(FloatLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public float getCell(int d0index, int d1index, int d2index, int d3index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index);
        }
        
        public void setCell(float value,int d0index, int d1index, int d2index, int d3index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index);
        }
    }
 
    private static class DoubleD4LinearTensor extends DoubleD4TensorShell {
        private final DoubleLinearTensor tensor;
        
        private DoubleD4LinearTensor(DoubleLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public double getCell(int d0index, int d1index, int d2index, int d3index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index);
        }
        
        public void setCell(double value,int d0index, int d1index, int d2index, int d3index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index);
        }
    }
 
    private static class CharD4LinearTensor extends CharD4TensorShell {
        private final CharLinearTensor tensor;
        
        private CharD4LinearTensor(CharLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public char getCell(int d0index, int d1index, int d2index, int d3index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index);
        }
        
        public void setCell(char value,int d0index, int d1index, int d2index, int d3index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index);
        }
    }
 
    private static class BooleanD4LinearTensor extends BooleanD4TensorShell {
        private final BooleanLinearTensor tensor;
        
        private BooleanD4LinearTensor(BooleanLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public boolean getCell(int d0index, int d1index, int d2index, int d3index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index);
        }
        
        public void setCell(boolean value,int d0index, int d1index, int d2index, int d3index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index);
        }
    }
 
    private static class ByteD5LinearTensor extends ByteD5TensorShell {
        private final ByteLinearTensor tensor;
        
        private ByteD5LinearTensor(ByteLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public byte getCell(int d0index, int d1index, int d2index, int d3index, int d4index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index);
        }
        
        public void setCell(byte value,int d0index, int d1index, int d2index, int d3index, int d4index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index);
        }
    }
 
    private static class ShortD5LinearTensor extends ShortD5TensorShell {
        private final ShortLinearTensor tensor;
        
        private ShortD5LinearTensor(ShortLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public short getCell(int d0index, int d1index, int d2index, int d3index, int d4index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index);
        }
        
        public void setCell(short value,int d0index, int d1index, int d2index, int d3index, int d4index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index);
        }
    }
 
    private static class IntD5LinearTensor extends IntD5TensorShell {
        private final IntLinearTensor tensor;
        
        private IntD5LinearTensor(IntLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public int getCell(int d0index, int d1index, int d2index, int d3index, int d4index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index);
        }
        
        public void setCell(int value,int d0index, int d1index, int d2index, int d3index, int d4index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index);
        }
    }
 
    private static class LongD5LinearTensor extends LongD5TensorShell {
        private final LongLinearTensor tensor;
        
        private LongD5LinearTensor(LongLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public long getCell(int d0index, int d1index, int d2index, int d3index, int d4index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index);
        }
        
        public void setCell(long value,int d0index, int d1index, int d2index, int d3index, int d4index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index);
        }
    }
 
    private static class FloatD5LinearTensor extends FloatD5TensorShell {
        private final FloatLinearTensor tensor;
        
        private FloatD5LinearTensor(FloatLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public float getCell(int d0index, int d1index, int d2index, int d3index, int d4index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index);
        }
        
        public void setCell(float value,int d0index, int d1index, int d2index, int d3index, int d4index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index);
        }
    }
 
    private static class DoubleD5LinearTensor extends DoubleD5TensorShell {
        private final DoubleLinearTensor tensor;
        
        private DoubleD5LinearTensor(DoubleLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public double getCell(int d0index, int d1index, int d2index, int d3index, int d4index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index);
        }
        
        public void setCell(double value,int d0index, int d1index, int d2index, int d3index, int d4index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index);
        }
    }
 
    private static class CharD5LinearTensor extends CharD5TensorShell {
        private final CharLinearTensor tensor;
        
        private CharD5LinearTensor(CharLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public char getCell(int d0index, int d1index, int d2index, int d3index, int d4index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index);
        }
        
        public void setCell(char value,int d0index, int d1index, int d2index, int d3index, int d4index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index);
        }
    }
 
    private static class BooleanD5LinearTensor extends BooleanD5TensorShell {
        private final BooleanLinearTensor tensor;
        
        private BooleanD5LinearTensor(BooleanLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public boolean getCell(int d0index, int d1index, int d2index, int d3index, int d4index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index);
        }
        
        public void setCell(boolean value,int d0index, int d1index, int d2index, int d3index, int d4index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index);
        }
    }
 
    private static class ByteD6LinearTensor extends ByteD6TensorShell {
        private final ByteLinearTensor tensor;
        
        private ByteD6LinearTensor(ByteLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public byte getCell(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index,d5index);
        }
        
        public void setCell(byte value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index);
        }
    }
 
    private static class ShortD6LinearTensor extends ShortD6TensorShell {
        private final ShortLinearTensor tensor;
        
        private ShortD6LinearTensor(ShortLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public short getCell(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index,d5index);
        }
        
        public void setCell(short value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index);
        }
    }
 
    private static class IntD6LinearTensor extends IntD6TensorShell {
        private final IntLinearTensor tensor;
        
        private IntD6LinearTensor(IntLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public int getCell(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index,d5index);
        }
        
        public void setCell(int value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index);
        }
    }
 
    private static class LongD6LinearTensor extends LongD6TensorShell {
        private final LongLinearTensor tensor;
        
        private LongD6LinearTensor(LongLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public long getCell(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index,d5index);
        }
        
        public void setCell(long value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index);
        }
    }
 
    private static class FloatD6LinearTensor extends FloatD6TensorShell {
        private final FloatLinearTensor tensor;
        
        private FloatD6LinearTensor(FloatLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public float getCell(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index,d5index);
        }
        
        public void setCell(float value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index);
        }
    }
 
    private static class DoubleD6LinearTensor extends DoubleD6TensorShell {
        private final DoubleLinearTensor tensor;
        
        private DoubleD6LinearTensor(DoubleLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public double getCell(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index,d5index);
        }
        
        public void setCell(double value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index);
        }
    }
 
    private static class CharD6LinearTensor extends CharD6TensorShell {
        private final CharLinearTensor tensor;
        
        private CharD6LinearTensor(CharLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public char getCell(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index,d5index);
        }
        
        public void setCell(char value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index);
        }
    }
 
    private static class BooleanD6LinearTensor extends BooleanD6TensorShell {
        private final BooleanLinearTensor tensor;
        
        private BooleanD6LinearTensor(BooleanLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public boolean getCell(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index,d5index);
        }
        
        public void setCell(boolean value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index);
        }
    }
 
    private static class ByteD7LinearTensor extends ByteD7TensorShell {
        private final ByteLinearTensor tensor;
        
        private ByteD7LinearTensor(ByteLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public byte getCell(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index,d5index,d6index);
        }
        
        public void setCell(byte value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index,d6index);
        }
    }
 
    private static class ShortD7LinearTensor extends ShortD7TensorShell {
        private final ShortLinearTensor tensor;
        
        private ShortD7LinearTensor(ShortLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public short getCell(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index,d5index,d6index);
        }
        
        public void setCell(short value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index,d6index);
        }
    }
 
    private static class IntD7LinearTensor extends IntD7TensorShell {
        private final IntLinearTensor tensor;
        
        private IntD7LinearTensor(IntLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public int getCell(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index,d5index,d6index);
        }
        
        public void setCell(int value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index,d6index);
        }
    }
 
    private static class LongD7LinearTensor extends LongD7TensorShell {
        private final LongLinearTensor tensor;
        
        private LongD7LinearTensor(LongLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public long getCell(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index,d5index,d6index);
        }
        
        public void setCell(long value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index,d6index);
        }
    }
 
    private static class FloatD7LinearTensor extends FloatD7TensorShell {
        private final FloatLinearTensor tensor;
        
        private FloatD7LinearTensor(FloatLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public float getCell(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index,d5index,d6index);
        }
        
        public void setCell(float value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index,d6index);
        }
    }
 
    private static class DoubleD7LinearTensor extends DoubleD7TensorShell {
        private final DoubleLinearTensor tensor;
        
        private DoubleD7LinearTensor(DoubleLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public double getCell(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index,d5index,d6index);
        }
        
        public void setCell(double value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index,d6index);
        }
    }
 
    private static class CharD7LinearTensor extends CharD7TensorShell {
        private final CharLinearTensor tensor;
        
        private CharD7LinearTensor(CharLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public char getCell(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index,d5index,d6index);
        }
        
        public void setCell(char value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index,d6index);
        }
    }
 
    private static class BooleanD7LinearTensor extends BooleanD7TensorShell {
        private final BooleanLinearTensor tensor;
        
        private BooleanD7LinearTensor(BooleanLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public boolean getCell(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index,d5index,d6index);
        }
        
        public void setCell(boolean value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index,d6index);
        }
    }
 
    private static class ByteD8LinearTensor extends ByteD8TensorShell {
        private final ByteLinearTensor tensor;
        
        private ByteD8LinearTensor(ByteLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public byte getCell(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
        }
        
        public void setCell(byte value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
        }
    }
 
    private static class ShortD8LinearTensor extends ShortD8TensorShell {
        private final ShortLinearTensor tensor;
        
        private ShortD8LinearTensor(ShortLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public short getCell(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
        }
        
        public void setCell(short value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
        }
    }
 
    private static class IntD8LinearTensor extends IntD8TensorShell {
        private final IntLinearTensor tensor;
        
        private IntD8LinearTensor(IntLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public int getCell(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
        }
        
        public void setCell(int value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
        }
    }
 
    private static class LongD8LinearTensor extends LongD8TensorShell {
        private final LongLinearTensor tensor;
        
        private LongD8LinearTensor(LongLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public long getCell(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
        }
        
        public void setCell(long value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
        }
    }
 
    private static class FloatD8LinearTensor extends FloatD8TensorShell {
        private final FloatLinearTensor tensor;
        
        private FloatD8LinearTensor(FloatLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public float getCell(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
        }
        
        public void setCell(float value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
        }
    }
 
    private static class DoubleD8LinearTensor extends DoubleD8TensorShell {
        private final DoubleLinearTensor tensor;
        
        private DoubleD8LinearTensor(DoubleLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public double getCell(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
        }
        
        public void setCell(double value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
        }
    }
 
    private static class CharD8LinearTensor extends CharD8TensorShell {
        private final CharLinearTensor tensor;
        
        private CharD8LinearTensor(CharLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public char getCell(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
        }
        
        public void setCell(char value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
        }
    }
 
    private static class BooleanD8LinearTensor extends BooleanD8TensorShell {
        private final BooleanLinearTensor tensor;
        
        private BooleanD8LinearTensor(BooleanLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public boolean getCell(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
        }
        
        public void setCell(boolean value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
        }
    }
 
    private static class ByteD9LinearTensor extends ByteD9TensorShell {
        private final ByteLinearTensor tensor;
        
        private ByteD9LinearTensor(ByteLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public byte getCell(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index, int d8index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
        }
        
        public void setCell(byte value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index, int d8index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
        }
    }
 
    private static class ShortD9LinearTensor extends ShortD9TensorShell {
        private final ShortLinearTensor tensor;
        
        private ShortD9LinearTensor(ShortLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public short getCell(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index, int d8index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
        }
        
        public void setCell(short value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index, int d8index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
        }
    }
 
    private static class IntD9LinearTensor extends IntD9TensorShell {
        private final IntLinearTensor tensor;
        
        private IntD9LinearTensor(IntLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public int getCell(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index, int d8index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
        }
        
        public void setCell(int value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index, int d8index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
        }
    }
 
    private static class LongD9LinearTensor extends LongD9TensorShell {
        private final LongLinearTensor tensor;
        
        private LongD9LinearTensor(LongLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public long getCell(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index, int d8index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
        }
        
        public void setCell(long value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index, int d8index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
        }
    }
 
    private static class FloatD9LinearTensor extends FloatD9TensorShell {
        private final FloatLinearTensor tensor;
        
        private FloatD9LinearTensor(FloatLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public float getCell(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index, int d8index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
        }
        
        public void setCell(float value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index, int d8index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
        }
    }
 
    private static class DoubleD9LinearTensor extends DoubleD9TensorShell {
        private final DoubleLinearTensor tensor;
        
        private DoubleD9LinearTensor(DoubleLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public double getCell(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index, int d8index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
        }
        
        public void setCell(double value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index, int d8index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
        }
    }
 
    private static class CharD9LinearTensor extends CharD9TensorShell {
        private final CharLinearTensor tensor;
        
        private CharD9LinearTensor(CharLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public char getCell(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index, int d8index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
        }
        
        public void setCell(char value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index, int d8index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
        }
    }
 
    private static class BooleanD9LinearTensor extends BooleanD9TensorShell {
        private final BooleanLinearTensor tensor;
        
        private BooleanD9LinearTensor(BooleanLinearTensor tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public boolean getCell(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index, int d8index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
            return tensor.getCellUnchecked(d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
        }
        
        public void setCell(boolean value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index, int d8index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
            tensor.setCellUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
        }
    }
 
    private static class ObjectD1LinearTensor<T> extends D1TensorShell<T> {
    private final ObjectLinearTensor<T> tensor;
    
        private ObjectD1LinearTensor(ObjectLinearTensor<T> tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public T getValue(int index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),index);
            return tensor.getValueUnchecked(index);
        }
        
        public void setValue(T value,int index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),index);
            tensor.setValueUnchecked(value,index);
        }
    }
 
    private static class ObjectD2LinearTensor<T> extends D2TensorShell<T> {
    private final ObjectLinearTensor<T> tensor;
    
        private ObjectD2LinearTensor(ObjectLinearTensor<T> tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public T getValue(int d0index, int d1index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index);
            return tensor.getValueUnchecked(d0index,d1index);
        }
        
        public void setValue(T value,int d0index, int d1index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index);
            tensor.setValueUnchecked(value,d0index,d1index);
        }
    }
 
    private static class ObjectD3LinearTensor<T> extends D3TensorShell<T> {
    private final ObjectLinearTensor<T> tensor;
    
        private ObjectD3LinearTensor(ObjectLinearTensor<T> tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public T getValue(int d0index, int d1index, int d2index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index);
            return tensor.getValueUnchecked(d0index,d1index,d2index);
        }
        
        public void setValue(T value,int d0index, int d1index, int d2index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index);
            tensor.setValueUnchecked(value,d0index,d1index,d2index);
        }
    }
 
    private static class ObjectD4LinearTensor<T> extends D4TensorShell<T> {
    private final ObjectLinearTensor<T> tensor;
    
        private ObjectD4LinearTensor(ObjectLinearTensor<T> tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public T getValue(int d0index, int d1index, int d2index, int d3index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index);
            return tensor.getValueUnchecked(d0index,d1index,d2index,d3index);
        }
        
        public void setValue(T value,int d0index, int d1index, int d2index, int d3index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index);
            tensor.setValueUnchecked(value,d0index,d1index,d2index,d3index);
        }
    }
 
    private static class ObjectD5LinearTensor<T> extends D5TensorShell<T> {
    private final ObjectLinearTensor<T> tensor;
    
        private ObjectD5LinearTensor(ObjectLinearTensor<T> tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public T getValue(int d0index, int d1index, int d2index, int d3index, int d4index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index);
            return tensor.getValueUnchecked(d0index,d1index,d2index,d3index,d4index);
        }
        
        public void setValue(T value,int d0index, int d1index, int d2index, int d3index, int d4index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index);
            tensor.setValueUnchecked(value,d0index,d1index,d2index,d3index,d4index);
        }
    }
 
    private static class ObjectD6LinearTensor<T> extends D6TensorShell<T> {
    private final ObjectLinearTensor<T> tensor;
    
        private ObjectD6LinearTensor(ObjectLinearTensor<T> tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public T getValue(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index);
            return tensor.getValueUnchecked(d0index,d1index,d2index,d3index,d4index,d5index);
        }
        
        public void setValue(T value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index);
            tensor.setValueUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index);
        }
    }
 
    private static class ObjectD7LinearTensor<T> extends D7TensorShell<T> {
    private final ObjectLinearTensor<T> tensor;
    
        private ObjectD7LinearTensor(ObjectLinearTensor<T> tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public T getValue(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index);
            return tensor.getValueUnchecked(d0index,d1index,d2index,d3index,d4index,d5index,d6index);
        }
        
        public void setValue(T value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index);
            tensor.setValueUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index,d6index);
        }
    }
 
    private static class ObjectD8LinearTensor<T> extends D8TensorShell<T> {
    private final ObjectLinearTensor<T> tensor;
    
        private ObjectD8LinearTensor(ObjectLinearTensor<T> tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public T getValue(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
            return tensor.getValueUnchecked(d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
        }
        
        public void setValue(T value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
            tensor.setValueUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index);
        }
    }
 
    private static class ObjectD9LinearTensor<T> extends D9TensorShell<T> {
    private final ObjectLinearTensor<T> tensor;
    
        private ObjectD9LinearTensor(ObjectLinearTensor<T> tensor) {
            super(tensor);
            this.tensor = tensor;
        }
        
        public T getValue(int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index, int d8index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
            return tensor.getValueUnchecked(d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
        }
        
        public void setValue(T value,int d0index, int d1index, int d2index, int d3index, int d4index, int d5index, int d6index, int d7index, int d8index) {
            TensorImplUtil.checkIndexLengths(getDimensions(),d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
            tensor.setValueUnchecked(value,d0index,d1index,d2index,d3index,d4index,d5index,d6index,d7index,d8index);
        }
    }
}