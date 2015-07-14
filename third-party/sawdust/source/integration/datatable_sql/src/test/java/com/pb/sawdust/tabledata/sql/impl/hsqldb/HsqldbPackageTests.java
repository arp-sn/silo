package com.pb.sawdust.tabledata.sql.impl.hsqldb;

import com.pb.sawdust.tabledata.sql.impl.SqlImplTestUtil;
import com.pb.sawdust.tabledata.sql.SqlDataSet;
import com.pb.sawdust.util.test.TestBase;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author crf <br/>
 *         Started: Dec 2, 2008 6:45:25 PM
 */
public class HsqldbPackageTests {
    public static final String HSQLDB_DATA_SET_TYPE_KEY = "hsqldb data set type";
    private static final Map<HsqldbDataSetType,Set<String>> CREATED_DBS = new EnumMap<HsqldbDataSetType, Set<String>>(HsqldbDataSetType.class);

    public static void main(String ... args) {
        TestBase.classStarted();
        HsqldbSqlDataRowTest.main(SqlImplTestUtil.formShouldSkipFinishOperationsMainArgs());
        HsqldbSqlDataTableTest.main(SqlImplTestUtil.formShouldSkipFinishOperationsMainArgs());
        HsqldbSqlDataSetTest.main(SqlImplTestUtil.formShouldSkipFinishOperationsMainArgs());
        HsqldbSqlDataColumnTest.main(SqlImplTestUtil.formShouldSkipFinishOperationsMainArgs());
        TestBase.classFinished(new Runnable() {
            public void run() {
                performTestFinishOperations();
            }
        });
    }

    private static String registerName(HsqldbDataSetType type, String dbName) {
        if (!CREATED_DBS.containsKey(type))
            CREATED_DBS.put(type,new HashSet<String>());
        CREATED_DBS.get(type).add(dbName);
        return dbName;
    }
        
    public static SqlDataSet getDataSet(HsqldbDataSetType type) {
        switch(type) {
            case MEMORY : return new HsqldbMemoryDataSet(registerName(type,"hsqldb_mem" + Thread.currentThread().getId()));
            case FILE : return new HsqldbFileDataSet(registerName(type,SqlImplTestUtil.getDatabasePath("hsqldb_file").getPath()));
            default : throw new RuntimeException("Not ready for " + type + " data set tests");
        }
    }

    public static SqlDataSet getDistinctSqlDataSet() {
        return new HsqldbMemoryDataSet(registerName(HsqldbDataSetType.MEMORY,"distinct" + Thread.currentThread().getId()));
    }

    public static void performTestFinishOperations() {
        for (HsqldbDataSetType type : HsqldbDataSetType.values()) {
            if (CREATED_DBS.containsKey(type)) {
                for (String dbName : CREATED_DBS.get(type)) {
                    SqlDataSet ds;
                    switch (type) {
                        case MEMORY : ds = new HsqldbMemoryDataSet(dbName); break;
                        case FILE : ds = new HsqldbFileDataSet(dbName); break;
                        default : continue; //shouldn't be here, but let cleanup continue
                    }
                    try {
                        ds.executeSqlUpdate("SHUTDOWN");
                    } catch (Exception e) {
                        //swallow - should be because db already shutdown
                        System.out.println(" didn't close " + dbName + ": " + e.getMessage());
                    }
                }
            }
        }
        SqlImplTestUtil.performTestFinishOperations();
    }

    public static enum HsqldbDataSetType {
        MEMORY,
        FILE,
//        SERVER
    }
}