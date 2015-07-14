package com.pb.sawdust.model.models.provider.hub;

import com.pb.sawdust.model.models.provider.AbstractIdData;
import com.pb.sawdust.model.models.provider.DataProvider;

import java.util.Set;

/**
 * The {@code SubDataProviderHub} class is a data provider hub which is a (contiguous) partition of a {@code DataProviderHub}.
 * Its intended use is to fulfill the requirements of {@link com.pb.sawdust.model.models.provider.hub.DataProviderHub#getSubDataHub(int, int)}
 * in a simple and efficient manner.
 *
 * @author crf <br/>
 *         Started Sep 14, 2010 9:33:58 PM
 */
public class SubDataProviderHub<K> extends AbstractIdData implements DataProviderHub<K> {
    private final DataProviderHub<K> hub;

    /**
     * The start (inclusive) of the data provider hub partition.
     */
    protected final int start;

    /**
     * The end (exclusive) of the data provider hub partition.
     */
    protected final int end;

    /**
     * Constructor specifying the base data provider hub and the bounds of the partition.
     *
     * @param hub
     *        The base data provider hub.
     *
     * @param start
     *        The start of the partition (inclusive).
     *
     * @param end
     *        The end of the partition (exclusive).
     *
     * @throws IllegalArgumentException if <code>end &lt;= start</code> or if {@code start} and/or {@code end} are out of
     *                                  {@code hub}'s data bounds (<i>i.e.</i> if either are less than zero or greater
     *                                  than the data hub's length).
     */
    public SubDataProviderHub(DataProviderHub<K> hub, int start, int end) {
        if (end <= start)
            throw new IllegalArgumentException("Subdata hub must have a strictly positive range (start=" + start + ", end=" + end + ")");
        int length = hub.getDataLength();
        if (end > length  || start < 0)
            throw new IllegalArgumentException(String.format("Subdata hub (start: %d, end: %d) out of bounds for hub of length %d",start,end,length));

        this.hub = hub;
        this.start = start;
        this.end = end;
    }

    public DataProvider getProvider(K choice) {
        return hub.getProvider(choice).getSubData(start,end);
    }

    public int getDataLength() {
        return end-start;
    }

    @Override
    public Set<K> getDataKeys() {
        return hub.getDataKeys();
    }

    public DataProviderHub<K> getSubDataHub(int s, int e) {
        if (e > getDataLength()  || s < 0)
            throw new IllegalArgumentException(String.format("Subdata hub (start: %d, end: %d) out of bounds for hub of length %d",s,e,getDataLength()));
        return hub.getSubDataHub(start+s,start+e);
    }

    public int getAbsoluteStartIndex() {
        return start + hub.getAbsoluteStartIndex();
    }

    public DataProvider getSharedProvider() {
        return hub.getSharedProvider().getSubData(start,end);
    }
}