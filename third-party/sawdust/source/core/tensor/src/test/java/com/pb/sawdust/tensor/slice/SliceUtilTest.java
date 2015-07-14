package com.pb.sawdust.tensor.slice;

import org.junit.Test;
import static com.pb.sawdust.util.Range.*;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.LinkedList;

import com.pb.sawdust.util.test.TestBase;
import com.pb.sawdust.util.array.ArrayUtil;

/**
 * @author crf <br/>
 *         Started: Feb 28, 2009 6:14:17 PM
 */
public class SliceUtilTest extends TestBase {

    public static void main(String ... args) {
        TestBase.main();
    }

    static void runSliceTests(final Slice rslice, final int[] rindices) {
        SliceTest st = new SliceTest() {

            protected int[] getIndices() {
                return rindices;
            }

            protected Slice getSlice(int[] indices) {
                return rslice;
            }
        };
        st.beforeTest();
        for (Method m : st.getClass().getMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                try {
                    m.invoke(st);
                } catch (InvocationTargetException ie) {
                    if (ie.getTargetException() instanceof AssertionError)
                        throw new RuntimeException(ie.getTargetException());
                    Exception e = (Exception) ie.getTargetException();
                    if (m.getAnnotation(Test.class).expected() != null) {
                        if (!m.getAnnotation(Test.class).expected().isAssignableFrom(e.getClass())) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        throw new RuntimeException(e);
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static Slice getRandomSlice() {
        switch(random.nextInt(10)) {
            case 0 : return ReducingSlice.reducingSlice(random.nextInt(33));
            case 1 : return FullSlice.fullSlice(random.nextInt(3,9));
            default : return new BaseSlice(getRandomIndices());
        }
    }

    static int[] getRandomIndices() {
        int[] indices = new int[random.nextInt(4,20)];
        for (int i : range(indices.length))
            indices[i] = random.nextInt(random.nextInt(1,35));
        return indices;
    }

    @Test
    public void testSliceOneIndex() {
        int[] indices = new int[] {random.nextInt(0,45)};
        runSliceTests(SliceUtil.slice(indices[0]),indices);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSliceOneIndexBadIndex() {
        SliceUtil.slice(-1);
    }

    @Test
    public void testFullSlice() {
        int[] indices = range(random.nextInt(4,45)).getRangeArray();
        runSliceTests(SliceUtil.fullSlice(indices.length),indices);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testFullSliceZeroLength() {
        SliceUtil.fullSlice(0);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testFullSliceNegativeLength() {
        SliceUtil.fullSlice(-1);
    }

    @Test
    public void testSpan() {
        int start = random.nextInt(4,8);
        int end = start + random.nextInt(10,40);
        int[] indices = range(start,end+1).getRangeArray();
        runSliceTests(SliceUtil.span(start,end),indices);

    }

    @Test
    public void testSpanDecreasing() {
        int end = random.nextInt(4,8);
        int start = end + random.nextInt(40);
        int[] indices = range(start,end-1).getRangeArray();
        runSliceTests(SliceUtil.span(start,end),indices);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSpanStartNegative() {
        SliceUtil.span(-1,random.nextInt(22));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSpanEndNegative() {
        SliceUtil.span(random.nextInt(22),-1);
    }

    @Test
    public void testRange() {
        int start = random.nextInt(4,8);
        int end = start + random.nextInt(10,40);
        int[] indices = range(start,end).getRangeArray();
        runSliceTests(SliceUtil.range(start,end),indices);
    }

    @Test
    public void testRangeDecreasing() {
        int end = random.nextInt(4,8);
        int start = end + random.nextInt(40);
        int[] indices = range(start,end).getRangeArray();
        runSliceTests(SliceUtil.range(start,end),indices);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testRangeStartNegative() {
        SliceUtil.range(-1,random.nextInt(22));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testRangeEndNegative() {
        SliceUtil.range(random.nextInt(22),-2);
    }

    @Test
    public void testSliceIndices() {
        int[] indices = getRandomIndices();
        runSliceTests(SliceUtil.slice(indices),indices);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSliceIndicesNegativeIndex() {
        int[] indices = getRandomIndices();
        indices[random.nextInt(indices.length)] = -1;
        SliceUtil.slice(indices);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSliceIndicesEmptyIndices() {
        SliceUtil.slice(new int[0]);
    }
    
    //aren't testing compositeSlice because it returns a CompositeSlice instance, which is already tested

    @Test(expected=IllegalArgumentException.class)
    public void testCompositeSliceFailure() {
        SliceUtil.compositeSlice();
    }

    @Test
    public void testSliceSlices() {
        Slice[] slices = new Slice[random.nextInt(4,10)];
        List<Integer> inds = new LinkedList<Integer>();
        for (int i : range(slices.length)) {
            Slice s = getRandomSlice();
            slices[i] = s;
            for (int j : s.getSliceIndices())
                inds.add(j);
        }
        runSliceTests(SliceUtil.slice(slices), ArrayUtil.toPrimitive(inds.toArray(new Integer[inds.size()])));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSliceSlicesEmptySlices() {
        SliceUtil.slice(new Slice[0]);
    }
}