package com.pb.sawdust.model.models.provider.filter;

import com.pb.sawdust.model.models.provider.DataProvider;
import com.pb.sawdust.tensor.alias.vector.primitive.BooleanVector;
import com.pb.sawdust.tensor.slice.Slice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * The {@code CompositeDataFilter} ...
 *
 * @author crf <br/>
 *         Started 3/3/11 10:15 PM
 */
public class CompositeDataFilter extends CachedDataFilter {
    private final List<DataFilter> filters;

    public CompositeDataFilter(List<DataFilter> filters) {
        this.filters = new LinkedList<DataFilter>(filters);
    }

    public CompositeDataFilter(DataFilter ... filters) {
        this.filters = Arrays.asList(filters);
    }

    @Override
    protected BooleanVector getFilterUncached(DataProvider provider) {
        BooleanVector v = null;
        boolean first = true;
        int len = -1;
        for (DataFilter filter : filters) {
            BooleanVector vv = filter.getFilter(provider);
            if (first) {
                v = vv;
                first = false;
                len = v.size(0);
            } else {
                for (int i = 0; i < len; i++) {
                    if (v.getCell(i) && !vv.getCell(i))
                        v.setCell(false,i);
                }
            }
        }
        return v;
    }
}