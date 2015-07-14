package com.pb.sawdust.util;

import com.pb.sawdust.util.test.TestBase;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author crf <br/>
 *         Started: Sep 5, 2008 10:40:18 AM
 */
public class FilterChainTest extends TestBase {

    public static void main(String ... args) {
        TestBase.main();
    }

    @Test
    public void testEmptyFilter() {
        assertTrue((new FilterChain<Integer>()).filter(1));
    }

    @Test
    public void testSingleFilterFailure() {
        assertFalse((new FilterChain<Integer>(get1Filter())).filter(1));
    }

    @Test
    public void testSingleFilterSuccess() {
        assertTrue((new FilterChain<Integer>(get1Filter())).filter(2));
    }

    @Test
    public void testCompositeFilterFailure1() {
        assertFalse((new FilterChain<Integer>(get1Filter()).addFilter(get2Filter())).filter(1));
    }

    @Test
    public void testCompositeFilterFailure2() {
        assertFalse((new FilterChain<Integer>(get1Filter()).addFilter(get2Filter())).filter(2));
    }

    @Test
    public void testCompositeFilterSuccess() {
        assertTrue((new FilterChain<Integer>(get1Filter()).addFilter(get2Filter())).filter(0));
    }

    @Test
    public void testAddFilterFailure1() {
        FilterChain<Integer> f = new FilterChain<Integer>(get1Filter());
        f.addFilter(get2Filter());
        assertFalse(f.filter(1));
    }

    @Test
    public void testAddFilterFailure2() {
        FilterChain<Integer> f = new FilterChain<Integer>(get1Filter());
        f.addFilter(get2Filter());
        assertFalse(f.filter(2));
    }

    @Test
    public void testAddFilterSuccess() {
        FilterChain<Integer> f = new FilterChain<Integer>(get1Filter());
        f.addFilter(get2Filter());
        assertTrue(f.filter(9));
    }

    private Filter<Integer> get1Filter() {
        return new Filter<Integer>() {
            public boolean filter(Integer input) {
                return input != 1;
            }
        };
    }

    private Filter<Integer> get2Filter() {
        return new Filter<Integer>() {
            public boolean filter(Integer input) {
                return input != 2;
            }
        };
    }
}