package com.pb.sawdust.tabledata.transform.row;

import com.pb.sawdust.tabledata.DataRow;
import com.pb.sawdust.tabledata.DataTable;

/**
 * The {@code ContextualRowWiseTransformation} class is a row-wise data table transformation which provides structured access
 * to some extra "contextual" information when performing transformations. Access to the context is provided through
 * {@code ContextDataRow} instances provided in the transformation methods.
 *
 * @param <C>
 *        The type of the context.
 *
 * @author crf
 *         Started 1/20/12 7:01 AM
 */
public abstract class ContextualRowWiseTransformation<C> extends RowWiseDataTableTransformation {
    /**
     * Transform a given row of data in the table. The actual transformation should be performed on the <i>table</i> (at
     * the specified row index), and not on the data row, which may be unmodifiable or separated view of the data. On the
     * other hand, access of the row's data (and context) for use in the transformation should occur through the data row
     * parameter.
     *
     * @param row
     *        The {@code ContextDataRow} representation of the row to transform. This object will hold the context which
     *        may be used in the transformation.
     *
     * @param table
     *        The table holding the row to transform.
     *
     * @param rowIndex
     *        The index (in {@code table} of the row to transform.
     */
    abstract protected void transformRow(ContextDataRow<C> row, DataTable table, int rowIndex);

    /**
     * Get the {@code ContextDataRow} for the specified row.
     *
     * @param row
     *        The row which will form the basis of the context data row.
     *
     * @param table
     *        The table that {@code row} came from.
     *
     * @param rowIndex
     *        The index of {@code row} in {@code table}.
     *
     * @return the context data row holding both the context and {@code row}'s information.
     */
    abstract protected ContextDataRow<C> getContextDataRow(DataRow row, DataTable table, int rowIndex);

    @Override
    public void transformRow(DataRow row, DataTable table, int rowIndex) {
        transformRow(getContextDataRow(row,table,rowIndex),table,rowIndex);
    }
}