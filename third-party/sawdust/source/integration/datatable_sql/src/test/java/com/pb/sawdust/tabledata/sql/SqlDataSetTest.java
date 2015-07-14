package com.pb.sawdust.tabledata.sql;

import com.pb.sawdust.tabledata.AbstractDataSetTest;
import com.pb.sawdust.tabledata.TableDataException;
import com.pb.sawdust.tabledata.basic.ListDataTable;
import com.pb.sawdust.tabledata.metadata.TableSchema;
import com.pb.sawdust.util.Filter;
import com.pb.sawdust.util.sql.IsolatedResultSet;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.LinkedList;

/**
 * @author crf <br/>
 *         Started: Sep 28, 2008 3:46:19 PM
 */
abstract public class SqlDataSetTest extends AbstractDataSetTest<SqlDataTable> {
    protected SqlDataSet sqlDataSet;

    protected SqlTableSchema getTableSchema(String tableLabel) {
        return new SqlTableSchema(tableLabel,testData.getColumnNames(),testData.getColumnTypes());
    }

    protected SqlDataTable getDataTable(TableSchema schema, Object[][] data) {
        SqlDataTable table = getDistinctSqlDataSet().addTable(schema);
        table.addDataByRow(data);
        return table;
    }

    abstract protected SqlDataSet getDistinctSqlDataSet();//so we can add a table in a distinct manner

     protected Filter<String> getTableDropFilter() {
        return new Filter<String>() {
            public boolean filter(String input) {
                return true;
            }
        };
    }

    protected void clearTablesFromDataSet(SqlDataSet set) {
        Connection c = null;
        ResultSet r = null;
        SqlDataSet.SqlDataSetPreparedStatement ps = null;
        try {
            c = set.getConnection();
            r = c.getMetaData().getTables(null,null,null,null);
            //sqlite doesn't like "DROP TABLE ?" prepared statement, so use batch commit
            List<String> dropStatements = new LinkedList<String>();
            Filter<String> f = getTableDropFilter();
            while (r.next()) {
                String table = r.getString(3);
                if (f.filter(table))
                    dropStatements.add("DROP TABLE " + SqlTableDataUtil.formQuotedIdentifier(table,set.getIdentifierQuote()));
            }
            try {
                r.close();
            } catch (SQLException e) {
                //ignore
            }
            set.executeSqlBatchFilterless(dropStatements.toArray(new String[dropStatements.size()]));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (r != null)
                    r.close();
            } catch (SQLException e) {
                //ignore
            }
            try {
                if (c != null)
                    c.close();
            } catch (SQLException e) {
                //ignore
            }
        }
    }

    @Before
    public void beforeTest() {
        super.beforeTest();
        sqlDataSet = (SqlDataSet) abstractDataSet;
    }

    @After
    public void afterTest() {
        clearTablesFromDataSet(sqlDataSet);
        clearTablesFromDataSet(getDistinctSqlDataSet());
    }

    public void testTransferTable() {
        String tableLabel = "a_new_table";
        ListDataTable table = new ListDataTable(getTableSchema(tableLabel),getTableData());
        sqlDataSet.addTable(table);
        int randomRow = random.nextInt(table.getRowCount());
        assertArrayAlmostEquals(table.getRow(randomRow).getData(),sqlDataSet.getTable(tableLabel).getRow(randomRow).getData());
    }

    @Test
    public void testExecuteSqlQueryFilterless() {
        sqlDataSet.setSqlFilter(new Filter<String>() {
            public boolean filter(String input) {
                return false;
            }
        });
        //no assert, just need no TableDataException
        IsolatedResultSet irs = null;
        try {
            irs = sqlDataSet.executeSqlQueryFilterless("SELECT * FROM not_a_tabel");
        } catch (SqlTableDataException e) {
            //success
        } finally {
            if (irs != null)
                irs.close();
        }
    }

   @Test
    public void testExecuteSqlUpdateFilterless() {
        sqlDataSet.setSqlFilter(new Filter<String>() {
            public boolean filter(String input) {
                return false;
            }
        });
        //no assert, just need no TableDataException
        try {
            sqlDataSet.executeSqlUpdateFilterless("SELECT * FROM not_a_tabel");
        } catch (SqlTableDataException e) {
            //success
        }
    }

    @Test(expected= TableDataException.class)
    public void testExecuteSqlQueryStopped() {
        sqlDataSet.setSqlFilter(new Filter<String>() {
            public boolean filter(String input) {
                return false;
            }
        });
        IsolatedResultSet irs = null;
        try {
            irs = sqlDataSet.executeSqlQuery("SELECT * FROM not_a_tabel");
        } finally {
            if (irs != null)
                irs.close();
        }
    }

    @Test(expected= TableDataException.class)
    public void testExecuteSqlUpdateStopped() {
        sqlDataSet.setSqlFilter(new Filter<String>() {
            public boolean filter(String input) {
                return false;
            }
        });
        sqlDataSet.executeSqlUpdate("SELECT * FROM not_a_tabel");
    }

    @Test
    public void testExecuteSqlQueryDefault() {
        IsolatedResultSet irs = null;
        //no assert, just need no TableDataException
        try {
            irs = sqlDataSet.executeSqlQuery("SELECT * FROM not_a_tabel");
        } catch (SqlTableDataException e) {
            //success
        } finally {
            if (irs != null)
                irs.close();
        }
    }

    @Test
    public void testExecuteSqlUpdateDefault() {
        //no assert, just need no TableDataException
        try {
            sqlDataSet.executeSqlUpdate("SELECT * FROM not_a_tabel");
        } catch (SqlTableDataException e) {
            //success
        }
    }

    @Test(expected= TableDataException.class)
    public void testExecuteSqlQueryAdditionalStopped() {
        IsolatedResultSet irs = null;
        try {
            irs = sqlDataSet.executeSqlQuery("SELECT * FROM not_a_tabel",
                    new Filter<String>() {
                        public boolean filter(String input) {
                            return false;
                    }
                });
        } finally {
            if (irs != null)
                irs.close();
        }
    }

    @Test(expected= TableDataException.class)
    public void testExecuteSqlUpdateAdditionalStopped() {
        sqlDataSet.executeSqlUpdate("SELECT * FROM not_a_tabel",
                new Filter<String>() {
                    public boolean filter(String input) {
                        return false;
                }
            });
    }
    
}