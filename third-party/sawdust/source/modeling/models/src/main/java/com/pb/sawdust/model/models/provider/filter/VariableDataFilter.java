package com.pb.sawdust.model.models.provider.filter;

import com.pb.sawdust.model.models.provider.DataProvider;
import com.pb.sawdust.model.models.trace.CalculationTrace;
import com.pb.sawdust.tensor.factory.TensorFactory;

/**
 * The {@code DataProviderVariableDataFilter} ...
 *
 * @author crf <br/>
 *         Started 3/3/11 10:47 PM
 */
public class VariableDataFilter extends DoubleDataFilter {
    private final String filterVariable;

    public VariableDataFilter(String filterVariable, TensorFactory factory) {
        super(factory);
        this.filterVariable = filterVariable;
    }

    protected double[] getDoubleFilter(DataProvider provider) {
        return provider.getVariableData(filterVariable);
    }

    public CalculationTrace traceFilterCalculation(DataProvider data, int observation) {
        CalculationTrace trace = super.traceFilterCalculation(data,observation);
        trace.addTraceElement(data.getVariableTrace(filterVariable,observation));
        return trace;
    }
}