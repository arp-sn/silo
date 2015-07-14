package com.pb.sawdust.tabledata;

import org.junit.Test;
import org.junit.Before;

/**
 * @author crf <br/>
 *         Started: Sep 26, 2008 11:42:04 PM
 */
abstract public class AbstractTableIndexTest<I,K> extends TableIndexTest<I> {
    protected AbstractTableIndex<I,K> abstractIndex;

    @SuppressWarnings({"unchecked", "varargs"})
    protected K getBuildIndexKey(I ... indices) {
        return abstractIndex.buildIndexKey(indices);
    }

    @Before
    @SuppressWarnings("unchecked") //probably a valid warning, but framework ill prevent problems
    public void beforeTest() {
        super.beforeTest();
        abstractIndex = (AbstractTableIndex<I,K>) index;
    }

    @Test
    abstract public void testBuildIndexKey();


}