package com.pb.sawdust.tensor.slice;

import static com.pb.sawdust.util.Range.*;
import com.pb.sawdust.util.test.TestBase;
import org.junit.Test;

/**
 * @author crf <br/>
 *         Started: Feb 27, 2009 12:50:46 PM
 */
public class BaseSliceTest extends SliceTest {
    
    public static void main(String ... args) {
        TestBase.main();
    }

    protected int[] getIndices() {
        int[] indices = new int[random.nextInt(4,20)];
        for (int i : range(indices.length))
            indices[i] = random.nextInt(random.nextInt(1,35));
        return indices;
    }

    protected Slice getSlice(int[] indices) {
        return new BaseSlice(indices);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testBaseSliceConstructorEmpty() {
        new BaseSlice();
    }

    @Test(expected=IllegalArgumentException.class)
    public void testBaseSliceConstructorNegativeElement() {
        int[] indices = getIndices();
        indices[random.nextInt(indices.length)] = -1;
        new BaseSlice(indices);
    }
}