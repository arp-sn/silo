package com.pb.sawdust.tabledata.sql.impl.h2;

import com.pb.sawdust.tabledata.sql.SqlDataColumnTest;
import com.pb.sawdust.tabledata.sql.SqlDataSet;
import com.pb.sawdust.tabledata.metadata.DataType;
import com.pb.sawdust.tabledata.sql.impl.SqlImplTestUtil;
import com.pb.sawdust.util.test.TestBase;
import org.junit.Before;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author crf <br/>
 *         Started: Dec 7, 2008 5:34:41 PM
 */
public class H2SqlDataColumnTest<T> extends SqlDataColumnTest<T> {
    public static final String DATA_TYPE_KEY = "data type key";

    protected DataType type;

    public static void main(String ... args) {
        TestBase.main();
        if (SqlImplTestUtil.shouldPerformTestFinishOperations(args))
            H2PackageTests.performTestFinishOperations();
    }

    protected Collection<Class<? extends TestBase>> getAdditionalTestClasses() {
        List<Map<String,Object>> context = new LinkedList<Map<String,Object>>();
        for (DataType type : DataType.values()) {
            for (H2PackageTests.H2DataSetType dataSetType : H2PackageTests.H2DataSetType.values()) {
                Map<String,Object> ct = buildContext(DATA_TYPE_KEY,type);
                ct.put(H2PackageTests.H2_DATA_SET_TYPE_KEY,dataSetType);
                context.add(ct);
            }
        }
        addClassRunContext(this.getClass(),context);
        return super.getAdditionalTestClasses();
    }

    @Before
    public void beforeTest() {
        type = (DataType) getTestData(DATA_TYPE_KEY);
        super.beforeTest();
    }

    protected DataType getColumnDataType() {
        return type;
    }

    protected SqlDataSet getSqlDataSet() {
        return H2PackageTests.getDataSet((H2PackageTests.H2DataSetType) getTestData(H2PackageTests.H2_DATA_SET_TYPE_KEY));
    }
}