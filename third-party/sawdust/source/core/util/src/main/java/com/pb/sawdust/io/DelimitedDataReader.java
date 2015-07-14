package com.pb.sawdust.io;

import net.jcip.annotations.Immutable;

import java.nio.charset.Charset;
import java.util.*;
import java.io.File;

import com.pb.sawdust.util.parsing.DelimitedDataParser;
import com.pb.sawdust.util.Filter;

/**
 * The {@code DelimitedDataReader} is used to read delimited data from a file. Delimited data is structured such that
 * each line (or lines) holds a series of data entries, each separated by a specified delimiter. The rules for delimited
 * text spelled out in {@link com.pb.sawdust.util.parsing.DelimitedDataParser} apply here. Additionally:
 * <ul>
 *     <li>Unless the {@code multiline} flag has been set to {@code true}, each line in the file denotes a row of data.</li>
 *     <li>If the {@code multiline} flag is set to {@code true}, then a quoted entry can contain one or more line
 *         termination characters, which will not be used to define a "row" of data. A row of multiline data ends when
 *         a line termination outside of a quoted entry is found.</li>
 * </ul>
 * No other restrictions are made or assumed as far as the internal details of the data; in particular, there is no
 * requirement that each row have the same number of entries, nor that there is a consistency of data "types" across
 * different rows of data.
 * <p>
 * A {@code DelimitedDataReader} instance is immutable, so it is threadsafe and may be used safely without external
 * synchronization.
 *
 * @author crf <br/>
 *         Started: May 15, 2008 7:49:49 PM
 */
@Immutable
public class DelimitedDataReader {
    private final DelimitedDataParser parser;
    private final boolean multilineRows;

    /**
     * Constructor specifying the data delimiter and the multiline row flag.
     *
     * @param delimiter
     *        The data delimiter.
     *
     * @param multilineRows
     *        If {@code true}, multiline rows will be allowed. Enabling multiline rows is less efficient than if it was
     *        not, so it should be enabled only if necessary.
     */
    public DelimitedDataReader(char delimiter, boolean multilineRows) {
        parser = new DelimitedDataParser(delimiter);
        this.multilineRows = multilineRows;
    }

    /**
     * Constructor for a non-multiline row reader specifying the data delimiter.
     *
     * @param delimiter
     *        The data delimiter.
     */
    public DelimitedDataReader(char delimiter) {
        this(delimiter,false);
    }

    private String stripEOL(String s) {
        int end = s.lastIndexOf('\r');
        if (end == -1)
            end = s.lastIndexOf('\n');
        if (end > -1)
            return s.substring(0,end);
        return s;
    }

    /**
     * Get a reader which iterates over the delimited data in a specified file. Each iteration cycle returns a string
     * array which contains the parsed data from one line of the data file. When this iteration cycle is complete
     * (<i>i.e.</i> <tt>hasNext() == false</tt>), the reader (file) will be closed; however, if the iterator is not used
     * to completion, then the reader should be closed by calling the {@code close()} method.
     * <p>
     * If the input file has an unparsable line (<i>e.g.</i> has unmatched quotes), then an {@code IllegalArgumentException}
     * will be thrown when that line is reached.
     * <p>
     * The iterator returned by this method is safe for access by concurrent threads. 
     *
     * @param file
     *        The file to create the reader for.
     *
     * @return an iterator which cycles over the parsed delimited data from {@code file}.
     */
    public IterableReader<String[]> getLineIterator(File file) {
        return getLineIterator(file,null,null);
    }

    /**
     * Get a reader which iterates over the delimited data in a specified file. Each iteration cycle returns a string
     * array which contains the parsed data from one line of the data file. When this iteration cycle is complete
     * (<i>i.e.</i> <tt>hasNext() == false</tt>), the reader (file) will be closed; however, if the iterator is not used
     * to completion, then the reader should be closed by calling the {@code close()} method.
     * <p>
     * If the input file has an unparsable line (<i>e.g.</i> has unmatched quotes), then an {@code IllegalArgumentException}
     * will be thrown when that line is reached.
     * <p>
     * The iterator returned by this method is safe for access by concurrent threads.
     *
     * @param file
     *        The file to create the reader for.
     *
     * @param charset
     *        The character set (encoding) to use when reading the file.
     *
     * @return an iterator which cycles over the parsed delimited data from {@code file}.
     */
    public IterableReader<String[]> getLineIterator(File file, Charset charset) {
        return getLineIterator(file,null,charset);
    }

    /**
     * Get a reader which iterates over the delimited data in a specified file and can skip lines. Each iteration cycle
     * returns a string array which contains the parsed data from one line of the data file. When this iteration cycle
     * is complete (<i>i.e.</i> <tt>hasNext() == false</tt>), the reader (file) will be closed; however, if the iterator
     * is not used to completion, then the reader should be closed by calling the {@code close()} method.
     * <p>
     * A line is only included if it passes the line filter.  The line filter acts on the <i>unparsed</i> line, which
     * allows unparsable lines (such as comments or errant data) to be processed and skipped.
     * <p>
     * If the input file has an unparsable line (<i>e.g.</i> has unmatched quotes) which passes the line filter, then an
     * {@code IllegalArgumentException} will be thrown when that line is reached.
     * <p>
     * The iterator returned by this method is safe for access by concurrent threads.
     *
     * @param file
     *        The file to create the reader for.
     *
     * @param lineFilter
     *        The filter to apply to the lines.
     *
     * @return an iterator which cycles over the parsed delimited data from {@code file}.
     */
    public IterableReader<String[]> getLineIterator(final File file, final Filter<String> lineFilter) {
        return getLineIterator(file,lineFilter,null);
    }



    /**
     * Get a reader which iterates over the delimited data in a specified file and can skip lines. Each iteration cycle
     * returns a string array which contains the parsed data from one line of the data file. When this iteration cycle
     * is complete (<i>i.e.</i> <tt>hasNext() == false</tt>), the reader (file) will be closed; however, if the iterator
     * is not used to completion, then the reader should be closed by calling the {@code close()} method.
     * <p>
     * A line is only included if it passes the line filter.  The line filter acts on the <i>unparsed</i> line, which
     * allows unparsable lines (such as comments or errant data) to be processed and skipped.
     * <p>
     * If the input file has an unparsable line (<i>e.g.</i> has unmatched quotes) which passes the line filter, then an
     * {@code IllegalArgumentException} will be thrown when that line is reached.
     * <p>
     * The iterator returned by this method is safe for access by concurrent threads.
     *
     * @param file
     *        The file to create the reader for.
     *
     * @param lineFilter
     *        The filter to apply to the lines.
     *
     * @param charset
     *        The character set (encoding) to use when reading the file.
     *
     * @return an iterator which cycles over the parsed delimited data from {@code file}.
     */
    public IterableReader<String[]> getLineIterator(final File file, final Filter<String> lineFilter, final Charset charset) {
        return new IterableReader<String[]>() {
            private final IterableFileReader.LineIterableReader fileReader;
            {
                if (multilineRows)
                    if (lineFilter == null)
                        fileReader = (charset == null) ? IterableFileReader.getLineIterableFileWithLineTerminator(file) :
                                                         IterableFileReader.getLineIterableFileWithLineTerminator(file,charset);
                    else
                        fileReader = (charset == null) ? IterableFileReader.getLineIterableFileWithLineTerminator(file,lineFilter) :
                                                         IterableFileReader.getLineIterableFileWithLineTerminator(file,charset,lineFilter);
                else
                    if (lineFilter == null)
                        fileReader = (charset == null) ? IterableFileReader.getLineIterableFile(file) :
                                                         IterableFileReader.getLineIterableFile(file,charset);
                    else
                        fileReader = (charset == null) ? IterableFileReader.getLineIterableFile(file,lineFilter) :
                                                         IterableFileReader.getLineIterableFile(file,charset,lineFilter);
            }

            public Iterator<String[]> iterator() {
                return new Iterator<String[]>() {
                    private final Iterator<String> fileReaderIterator = fileReader.iterator();
                    private String currentLine = "";

                    public boolean hasNext() {
                        return fileReaderIterator.hasNext();
                    }

                    public String[] next() {
                        if (!multilineRows) {
                            return parser.parse(fileReaderIterator.next());
                        } else {
                            currentLine = fileReaderIterator.next();
                            while (!parser.isParsable(currentLine) && fileReaderIterator.hasNext())
                                currentLine += fileReaderIterator.next();
                            return parser.parse(stripEOL(currentLine));
                        }
                    }

                    public void remove() {
                        throw new UnsupportedOperationException("remove() not allowed by this iterator");
                    }
                };
            }

            public void close() {
                fileReader.close();
            }

            public void setCloseAtIterationEnd(boolean closeAtIterationEnd) {
                fileReader.setCloseAtIterationEnd(closeAtIterationEnd);
            }
        };
    }

    /**
     * Get all of the delimted data from a given file. The returned array contains the parsed data as a series of arrays,
     * each holding one line of data as would be recieved from a {@code getNext()} call to the iterator returned from
     * {@code getLineIterator(file)}.
     * <p>
     * If the input file has an unparsable line (<i>e.g.</i> has unmatched quotes), then an {@code IllegalArgumentException}
     * will be thrown.
     *
     * @param file
     *        The file holding the delimited data.
     *
     * @return an array holding the parsed delimited data from {@code file}.
     */
    public String[][] getData(File file) {
        return getData(file,null);
    }

    /**
     * Get all of the delimted data from a given file. The returned array contains the parsed data as a series of arrays,
     * each holding one line of data as would be recieved from a {@code getNext()} call to the iterator returned from
     * {@code getLineIterator(file)}.
     * <p>
     * If the input file has an unparsable line (<i>e.g.</i> has unmatched quotes), then an {@code IllegalArgumentException}
     * will be thrown.
     *
     * @param file
     *        The file holding the delimited data.
     *
     * @param charset
     *        The character set (encoding) to use when reading the file.
     *
     * @return an array holding the parsed delimited data from {@code file}.
     */
    public String[][] getData(File file, Charset charset) {
        List<String[]> data = new LinkedList<String[]>();
        IterableReader<String[]> ir = getLineIterator(file,charset);
        try {
            for (String[] line : ir)
                data.add(line);
        } finally {
            ir.close();
        }
        return data.toArray(new String[data.size()][]);
    }
}