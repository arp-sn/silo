package com.pb.sawdust.model.models.provider;

import com.pb.sawdust.tensor.factory.TensorFactory;

import java.util.*;

/**
 * The {@code ExpandableDataProvider} class is a data provider which to which variables can be added dynamically.  It holds
 * its data as double arrays which are passed via the {@link #addVariable(String, double[])} method.
 *
 * @author crf <br/>
 *         Jul 27, 2010
 */                                    
public class ExpandableDataProvider extends MapDataProvider {

    /**
     * Constructor specifying the data identifier, length, and tensor factory used to build data results.
     *
     * @param dataId
     *        The data id to use for this provider.
     *
     * @param dataLength
     *        The data length for this data provider.
     *
     * @param factory
     *        The tensor factory used to build data results.
     *
     * @throws IllegalArgumentException if {@code dataLength} is less then one, or if {@code dataId} has not already been
     *                                  allocated via {@code AbstractIdData}.
     */
    public ExpandableDataProvider(int dataId, int dataLength, TensorFactory factory) {
        super(dataId,factory,dataLength,null);
    }

    /**
     * Constructor specifying the data length and tensor factory used to build data results.
     *
     * @param dataLength
     *        The data length for this data provider.
     *
     * @param factory
     *        The tensor factory used to build data results.
     *
     * @throws IllegalArgumentException if {@code dataLength} is less then one.
     */
    public ExpandableDataProvider(int dataLength, TensorFactory factory) {
        super(factory,dataLength,null);
    }

    @Override
    Map<String, double[]> getDataMap(Map<String,double[]> initialData) {
        return new HashMap<String,double[]>();
    }

    /**
     * Add a variable to this provider. The {@code data} array is used directly to hold the data, so changes to the
     * array values after calling this method will be reflected in the data returned by this provider.
     *
     * @param name
     *        The name of the variable to add.
     *
     * @param data
     *        The variable data.
     *
     * @throws IllegalArgumentException if {@code data.length} does not equal the length of this provider, or if this
     *                                  provider already contains another variable named {@code name}.
     */
    public void addVariable(String name, double[] data) {
        if (data.length != getDataLength())
            throw new IllegalArgumentException("New variable length (" + data.length + ") does not equal that of this data provider (" + getDataLength() + ")");
        else if (hasVariable(name))
            throw new IllegalArgumentException("Variable name already exists: " + name);
        this.data.put(name,data);
    }
}