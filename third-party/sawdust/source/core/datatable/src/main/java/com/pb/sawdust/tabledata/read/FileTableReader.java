package com.pb.sawdust.tabledata.read;

import com.pb.sawdust.util.exceptions.RuntimeIOException;

import java.io.File;

/**
 * The {@code FileTableReader} class provides a simple {@code TableReader} implementation for use when data tables are
 * to be read from files.
 * 
 * @author crf <br/>
 *         Started: Nov 2, 2008 10:12:43 PM
 */
public abstract class FileTableReader extends AbstractSubTableReader {

    /**
     * The file holding the table data.
     */
    protected final File tableFile;

    private FileTableReader(File tableFilePath, String tableName) {
        super(tableName);
        if (!tableFilePath.exists())
            throw new RuntimeIOException("Table file not found: " + tableFilePath);
        this.tableFile = tableFilePath;
    }

    /**
     * Constructor specifying the file and table name for the table data.
     *
     * @param tableFilePath
     *        The path to the table data file.
     *
     * @param tableName
     *        The name to use for the table.
     *
     * @throws com.pb.sawdust.util.exceptions.RuntimeIOException if {@code tableFilePath} was not found.
     */
    public FileTableReader(String tableFilePath, String tableName) {
        this(new File(tableFilePath),tableName);
    }

    private FileTableReader(File tableFilePath) {
        this(tableFilePath,tableFilePath.getName());
    }

    /**
     * Constructor specifying the file the table data. The file name (excluding directories) will be used as the
     * table name.
     *
     * @param tableFilePath
     *        The path to the table data file.
     *
     * @throws com.pb.sawdust.util.exceptions.RuntimeIOException if {@code tableFilePath} was not found.
     */
    public FileTableReader(String tableFilePath) {
        this(new File(tableFilePath));
    }
}