package com.pb.sawdust.io;

import com.pb.sawdust.util.exceptions.RuntimeIOException;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.NoSuchElementException;

import com.pb.sawdust.util.Filter;

/**
 * The {@code IterableFileReader} class offers static convenience methods for dealing with reading files. These mainly
 * include methods to read a text file as a {@code LineIterableReader} instance. This class offers the convenience of
 * reading a file, {@code f}, line-by-line using the following convenience idiom:
 * <tt><pre>
 *     for (String line : IterableFileReader.getLineIterableFile(f)) {
 *         //do something with the line...
 *     }
 * </pre></tt>
 * It is noted that a {@code LineIterableReader}'s iterator can only be created (and iterated through) once; on the
 * other hand, this iterator (and the object itself) is thread-safe.
 * <p>
 * For better or for worse, this class also does away with checked {@code IOException}s, wrapping them instead with
 * {@code RuntimeIOException}s. This reduces the up-front coding burden be eliminating the forced acknowledgement of the
 * exception, but also can allow some recoverable exceptional conditions to percolate through to runtime. Therefore,
 * care must be taken to note which methods can throw the {@code RuntimeIOException}, and handle this as needed.
 * 
 * @author crf <br/>
 *         Started: May 16, 2008 10:57:23 AM
 */
public class IterableFileReader {

    //private constructor to prevent instantiation
    private IterableFileReader() {}

    /**
     * Factory method to get a {@code LineIterableReader} for use with a specified file. This reader can iterate over
     * each line in the file, returning a string containing the text in the line, minus any line termations characters.
     *
     * @param file
     *        The to use the reader with.
     *
     * @return a line iterable reader for use with {@code file}.
     *
     * @throws RuntimeIOException if {@code file} is not found.
     */
    public static LineIterableReader getLineIterableFile(File file) {
        return new LineIterableReader(FileUtil.openFile(file));
    }

    /**
     * Factory method to get a filtered {@code LineIterableReader} for use with a specified file. This reader can iterate
     * over each line in the file, skipping lines in which <code>lineFilter(line) == false</code>, returning a string
     * containing the text in the line, minus any line termations characters.
     *
     * @param file
     *        The to use the reader with.
     *
     * @param lineFilter
     *        The filter to use with the line iterator.
     *
     * @return a line iterable reader for use with {@code file}.
     *
     * @throws RuntimeIOException if {@code file} is not found.
     */
    public static LineIterableReader getLineIterableFile(File file, Filter<String> lineFilter) {
        return new LineIterableReader(FileUtil.openFile(file),lineFilter);
    }

    /**
     * Factory method to get a {@code LineIterableReader} which reads line termination characters for use with a
     * specified file. This reader is identical to the one returned in {@code getLineIterableFile(java.io.File)},
     * except it does not strip away the trailing line termination characters.
     *
     * @param file
     *        The to use the reader with.
     *
     * @return a line iterable reader for use with {@code file}.
     *
     * @throws RuntimeIOException if {@code file} is not found.
     */
    public static LineIterableReader getLineIterableFileWithLineTerminator(File file) {
        return new LineIterableReader(openFileWithLineTerminator(file));
    }

    /**
     * Factory method to get a filtered {@code LineIterableReader} which reads line termination characters for use with a
     * specified file. This reader is identical to the one returned in <code>getLineIterableFile(java.io.File,Filter&lt;String&gt;)</code>,
     * except it does not strip away the trailing line termination characters.
     *
     * @param file
     *        The to use the reader with.
     *
     * @param lineFilter
     *        The filter to use with the line iterator.
     *
     * @return a line iterable reader for use with {@code file}.
     *
     * @throws RuntimeIOException if {@code file} is not found.
     */
    public static LineIterableReader getLineIterableFileWithLineTerminator(File file, Filter<String> lineFilter) {
        return new LineIterableReader(openFileWithLineTerminator(file),lineFilter);
    }

    /**
     * Factory method to get a {@code LineIterableReader} for use with a specified file using a specific character encoding.
     * This reader can iterate over each line in the file, returning a string containing the text in the line, minus any
     * line termations characters.
     *
     * @param file
     *        The to use the reader with.
     *
     * @param charset
     *        The character set encoding to use with the reader.
     *
     * @return a line iterable reader for use with {@code file}.
     *
     * @throws RuntimeIOException if {@code file} is not found.
     */
    public static LineIterableReader getLineIterableFile(File file, Charset charset) {
        return new LineIterableReader(FileUtil.openFile(file,charset));
    }

    /**
     * Factory method to get a filtered {@code LineIterableReader} for use with a specified file using a specific character
     * encoding. This reader can iterate over each line in the file, skipping lines in which <code>lineFilter(line) == false</code>,
     * returning a string containing the text in the line, minus any line termations characters.
     *
     * @param file
     *        The to use the reader with.
     *
     * @param charset
     *        The character set encoding to use with the reader.
     *
     * @param lineFilter
     *        The filter to use with the line iterator.
     *
     * @return a line iterable reader for use with {@code file}.
     *
     * @throws RuntimeIOException if {@code file} is not found.
     */
    public static LineIterableReader getLineIterableFile(File file, Charset charset, Filter<String> lineFilter) {
        return new LineIterableReader(FileUtil.openFile(file,charset),lineFilter);
    }

    /**
     * Factory method to get a {@code LineIterableReader} which reads line termination characters for use with a
     * specified file using a specific character encoding. This reader is identical to the one returned in
     * {@code getLineIterableFile(java.io.File,java.io.Charset)}, except it does not strip away the trailing line termination characters.
     *
     * @param file
     *        The to use the reader with.
     *
     * @param charset
     *        The character set encoding to use with the reader.
     *
     * @return a line iterable reader for use with {@code file}.
     *
     * @throws RuntimeIOException if {@code file} is not found.
     */
    public static LineIterableReader getLineIterableFileWithLineTerminator(File file, Charset charset) {
        return new LineIterableReader(openFileWithLineTerminator(file,charset));
    }

    /**
     * Factory method to get a filtered {@code LineIterableReader} which reads line termination characters for use with a
     * specified file using a specific character encoding. This reader is identical to the one returned in
     * <code>getLineIterableFile(java.io.File,java.io.Charset,Filter&lt;String&gt;)</code>, except it does not strip away
     * the trailing line termination characters.
     *
     * @param file
     *        The to use the reader with.
     *
     * @param charset
     *        The character set encoding to use with the reader.
     *
     * @param lineFilter
     *        The filter to use with the line iterator.
     *
     * @return a line iterable reader for use with {@code file}.
     *
     * @throws RuntimeIOException if {@code file} is not found.
     */
    public static LineIterableReader getLineIterableFileWithLineTerminator(File file, Charset charset, Filter<String> lineFilter) {
        return new LineIterableReader(openFileWithLineTerminator(file,charset),lineFilter);
    }

    /**
     * The {@code LineIterableReader} is an iterable reader which is used to iterate over the lines in a file. It
     * cannot be instantiated externally, but is made available through factory methods in the {@code IterableFileReader} class.
     * It can only iterate through the file once, this is analogous to the fact that a buffered reader (whcih this
     * class uses to read files) can effectively only read through a file once (the {@code mark()...reset()} paradigm
     * only works within the length of the reader's buffer). Thus, any reference to it remaining after it has finished
     * its iteration cycle should be set to {@code null} to allow it to be garbage collected. When the reader is finished
     * iterating (<i>i.e.</i> when {@code hasNext() == false}), it will automatically be closed. This behavior can
     * be changed by calling {@code setCloseIterationAtEnd(boolean)} appropriately. If the iterator is to be discarded
     * before its iteration cycle has completed, then the {@code close()} method should be called explicitly.
     * <p>
     * Though only one iterator may be created through this class, it is possible to access that iterator via multiple
     * threads - this is safe as this class' iterator is thread-safe and guarded by this class' intrinsic object lock.
     */
    @ThreadSafe
    public static class LineIterableReader implements IterableReader<String> {
        private final BufferedReader reader;
        private final Filter<String> lineFilter;
        @GuardedBy("this") private volatile boolean closed = false;
        @GuardedBy("this") private volatile boolean iteratorUsed = false;
        @GuardedBy("this") private volatile boolean closeAtIterationEnd = true;

        //private constructor, used internally by parent class
        private LineIterableReader(BufferedReader reader, Filter<String> lineFilter) {
            this.reader = reader;
            if (lineFilter == null)
                lineFilter =
                    new Filter<String>() {
                        public boolean filter(String s) {
                            return true;
                        }
                    };
            this.lineFilter = lineFilter;
        }

        private LineIterableReader(BufferedReader reader) {
            this(reader,null);
        }

        synchronized public void setCloseAtIterationEnd(boolean closeAtIterationEnd) {
            this.closeAtIterationEnd = closeAtIterationEnd;
        }

        /**
         * Get an iterator which will iterate over the lines in the file associated with this reader. If an
         * io exception occurs during this iterators operation, then an {@code RuntimeIOException} will be thrown.
         *
         * @return a line iterator.
         *
         * @throws IllegalStateException if the iterator for this instance has already been accessed through this method,
         *                               or if the iterator is used after this reader is closed..
         */
        public Iterator<String> iterator() {
            //ensure that only one iterator may be accessed through this object from multiple threads
            synchronized(this) {
                if (iteratorUsed)
                    throw new IllegalStateException("Iterator for LineIterableReader can only be accessed once.");
                else if (closed)
                    throw new IllegalStateException("Iterator cannot be created for closed reader.");
                else
                    iteratorUsed = true;
            }
            return new Iterator<String>() {
                @GuardedBy("LineIterableReader.this") private boolean incremented = false;
                @GuardedBy("LineIterableReader.this") private String nextLine = "";

                public boolean hasNext() {
                    synchronized(LineIterableReader.this) {
                        if (closed)
                            throw new IllegalStateException("Line iterable reader has been closed while iterator still in use.");
                        try {
                            if (!incremented) {
                                nextLine = reader.readLine();
                                while (nextLine != null && !lineFilter.filter(nextLine))
                                    nextLine = reader.readLine();
                                if (nextLine != null)
                                    incremented = true;
                                else if (closeAtIterationEnd)
                                    close();
                            }
                        } catch(IOException e) {
                            throw new RuntimeIOException(e);
                        }
                        return incremented;
                    }
                }

                public String next() {
                    synchronized(LineIterableReader.this) {
                        if (hasNext()) {
                            incremented = false;
                            return nextLine;
                        } else {
                            throw new NoSuchElementException("No more lines in file.");
                        }
                    }
                }

                public void remove() {
                    throw new UnsupportedOperationException("remove() not allowed in LineIterableReader iterator.");
                }
            };
        }

        /**
         * Determine whether this reader is closed or not.
         *
         * @return {@code true} if this reader is closed, {@code false} if not.
         */
        public boolean isClosed() {
            return closed;
        }

        public synchronized void close() {
            try {
                reader.close();
                closed = true;
            } catch(IOException e) {
                throw new RuntimeIOException(e);
            }
        }

        /**
         * This method is overridden in this class to ensure that the file has been closed when this object is
         * garbage collected. This should not be used as a replacement for calling {@code close()} explicitly
         * in code, just to ensure that the resources are properly freed up in unexpected or exceptional situations.
         * @throws Throwable
         */
        public void finalize() throws Throwable {
            try {
                close();
            } finally {
                super.finalize();
            }
        }
    }

    private static LineTerminatorBufferedReader openFileWithLineTerminator(File file, Charset charset) {
        if (file.getPath().contains("!"))
            return openFileWithLineTerminatorFromResource(file,charset); //I'm assuming this is correct
        try {
            return new LineTerminatorBufferedReader(charset == null ?
                    new FileReader(file) :
                    new InputStreamReader(new FileInputStream(file),charset));
        }
        catch (IOException e) {
            throw new RuntimeIOException(e);
        }
    }

    private static LineTerminatorBufferedReader openFileWithLineTerminatorFromResource(File file, Charset charset) {
        return new LineTerminatorBufferedReader(charset == null ?
                new InputStreamReader(ClassLoader.getSystemResourceAsStream(file.getName())) :
                new InputStreamReader(ClassLoader.getSystemResourceAsStream(file.getName()),charset));
    }

    private static LineTerminatorBufferedReader openFileWithLineTerminator(File file) {
        return openFileWithLineTerminator(file,null);
    }

    //this class is an extension of Buffered reader so we can read lines and include the line terminators
    @ThreadSafe
    private static class LineTerminatorBufferedReader extends BufferedReader {
        private static final int bufferSize = 8192;

        private LineTerminatorBufferedReader(Reader in) {
            super(in,bufferSize);
        }

        //reads a line, but includes line terminator
        @GuardedBy("lock")
        public String readLine() throws IOException{
            StringBuilder sb = null;
            char[] internalBuffer = new char[bufferSize];
            boolean checkForLineFeed = false;
            synchronized(lock) {
                bufferLoop : while (true) {
                    mark(bufferSize); //mark the start of the current read
                    //check for line feed, as needed
                    if (checkForLineFeed) {
                        int character = read();
                        if (character == -1) //end of file
                            return sb.toString();
                        if (character == ((int) '\n'))
                            sb.append('\n');
                        else
                            reset();
                        return sb.toString();
                    }
                    int length = read(internalBuffer);
                    if (length == -1)
                        if (sb == null)
                            return null; //end of file
                        else
                            return sb.toString();
                    if (sb == null)
                        sb = new StringBuilder();
                    //loop through buffer and see if we see eol
                    // eol is \n, \r, or \r\n
                    for (int i = 0; i < length; i++) {
                        char c = internalBuffer[i];
                        if (c == '\n' || c == '\r') {
                            //found an eol
                            int lineEndPoint = i+1;
                            if (c == '\r' && lineEndPoint != length && internalBuffer[lineEndPoint] == '\n')
                                lineEndPoint++; //\r\n eol
                            //go back to beginning of line, and reread only what we want
                            if (lineEndPoint != length) {
                                reset();
                                read(internalBuffer,0,lineEndPoint);
                            }
                            sb.append(internalBuffer,0,lineEndPoint);
                            if (c == '\r' && i == (length-1)) {
                                //make sure line end didn't wrap
                                checkForLineFeed = true;
                                continue bufferLoop;
                            }
                            return sb.toString();
                        }
                    }
                    //no eol
                    sb.append(internalBuffer,0,length);
                    if (length < bufferSize)
                        return sb.toString(); //end of file
                }
            }
        }

    }


}