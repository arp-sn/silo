package com.pb.sawdust.tabledata.read;

import com.pb.sawdust.io.DelimitedDataReader;
import com.pb.sawdust.io.IterableReader;

/**
 * The {@code DelimitedTextTableReader} class allows data tables to be read from delimited data text files. Internally,
 * the class uses a {@code DelimitedDataReader} with the specified delimiter, so the
 * parsing rules set out in that class apply to table files read by this class.
 *
 * @see com.pb.sawdust.io.DelimitedDataReader
 *
 * @author crf <br/>
 *         Started: Nov 3, 2008 6:42:31 AM
 */
public class DelimitedTextTableReader extends TextFileTableReader<String[]> {
    private final DelimitedDataReader dataReader;

    /**
     * Constructor specifying the file and table name for the csv data.
     *
     * @param filePath
     *        The path to the csv data file.
     *
     * @param tableName
     *        The name to use for the table.
     *
     * @param delimiter
     *        The character the data is delimited by.
     *
     * @param multiline
     *        Boolean specifying if {@code DelimitedDataReader} reader should allow multiline data entries or not.
     *
     * @throws com.pb.sawdust.util.exceptions.RuntimeIOException if {@code fileName} was not found.
     */
    public DelimitedTextTableReader(String filePath, String tableName, char delimiter, boolean multiline) {
        super(filePath, tableName);
        dataReader = new DelimitedDataReader(delimiter,multiline);
    }

    /**
     * Constructor specifying the file and table name for the csv data. Multiline data entries will not be allowed.
     *
     * @param filePath
     *        The path to the csv data file.
     *
     * @param tableName
     *        The name to use for the table.
     *
     * @param delimiter
     *        The character the data is delimited by.
     *
     * @throws com.pb.sawdust.util.exceptions.RuntimeIOException if {@code fileName} was not found.
     */
    public DelimitedTextTableReader(String filePath, String tableName, char delimiter) {
        this(filePath,tableName,delimiter,false);
    }

    /**
     * Constructor specifying the file the csv data. The file name (excluding directories) will be used as the
     * table name.
     *
     * @param filePath
     *        The path to the csv data file.
     *
     * @param delimiter
     *        The character the data is delimited by.
     *
     * @param multiline
     *        Boolean specifying if {@code DelimitedDataReader} reader should allow multiline data entries or not.
     *
     * @throws com.pb.sawdust.util.exceptions.RuntimeIOException if {@code filePath} was not found.
     */
    public DelimitedTextTableReader(String filePath, char delimiter, boolean multiline) {
        super(filePath);
        dataReader = new DelimitedDataReader(delimiter,multiline);
    }

    /**
     * Constructor specifying the file the csv data. The file name (excluding directories) will be used as the
     * table name. Multiline data entries will not be allowed.
     *
     * @param filePath
     *        The path to the csv data file.
     *
     * @param delimiter
     *        The character the data is delimited by.
     *
     * @throws com.pb.sawdust.util.exceptions.RuntimeIOException if {@code filePath} was not found.
     */
    public DelimitedTextTableReader(String filePath, char delimiter) {
        this(filePath,delimiter,false);
    }

    protected IterableReader<String[]> getReader() {
        return dataReader.getLineIterator(tableFile);
    }

    protected String[] getRowData(String[] row) {
        return row;
    }
}