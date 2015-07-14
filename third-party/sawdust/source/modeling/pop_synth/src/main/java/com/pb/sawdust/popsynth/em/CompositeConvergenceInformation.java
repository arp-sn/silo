package com.pb.sawdust.popsynth.em;

import java.util.*;

/**
 * The {@code CompositeConvergenceInformation} is a simple {@code ConvergenceInformation} implementation which combines
 * multiple {@code ConvergenceInformation} instances. Its only requirement is that the dimension names for all the composited
 * convergence information instances have distinct dimension names.
 *
 * @author crf
 *         Started 10/8/11 7:25 PM
 */
public class CompositeConvergenceInformation implements ConvergenceInformation {
    private final Map<String,ConvergenceInformation> convergenceInformations;
    private final String name;

    /**
     * Construtor specifying the convergence information instances which will be collected.
     *
     * @param convergenceInformation
     *        The convergence information instances to be composited.
     *
     * @param name
     *        The name for the composite convergence information. This name will be returne by {@link #getAssociationName()}.
     *
     * @throws IllegalArgumentException if any of the convergence information instances in {@code convergenceInformation}
     *                                  have dimensions with identical names.
     */
    public CompositeConvergenceInformation(List<ConvergenceInformation> convergenceInformation, String name) {
        convergenceInformations = new HashMap<>();
        this.name = name;
        for (ConvergenceInformation ci : convergenceInformation) {
            for (String dimension : ci.getDimensionNames()) {
                if (convergenceInformations.containsKey(dimension) && convergenceInformations.get(dimension) != ci)
                    throw new IllegalArgumentException("Cannot combine convergence informations with identical dimension names: " + dimension);
                convergenceInformations.put(dimension,ci);
            }
        }
    }

    private ConvergenceInformation getDimensionConvergenceInformation(String dimensionName) {
        return convergenceInformations.get(dimensionName);
    }

    @Override
    public String getAssociationName() {
        return name;
    }

    @Override
    public Set<String> getDimensionNames() {
        return convergenceInformations.keySet();
    }

    @Override
    public Set<?> getDimensionIndices(String dimensionName) {
        return getDimensionConvergenceInformation(dimensionName).getDimensionIndices(dimensionName);
    }

    @Override
    public Map<?,ConvergenceInformationElement> getConvergenceInformation(String dimension) {
        return getDimensionConvergenceInformation(dimension).getConvergenceInformation(dimension);
    }

    @Override
    public Map<String,Map<?,ConvergenceInformationElement>> getConvergenceInformation() {
        Map<String,Map<?,ConvergenceInformationElement>> ci = new HashMap<>();
        for (String dimension : convergenceInformations.keySet())
            ci.putAll(getDimensionConvergenceInformation(dimension).getConvergenceInformation());
        return ci;
    }

    @Override
    public Map<?,ConvergenceInformationElement> getPreviousUpdateConvergenceInformation(String dimension) {
        return getDimensionConvergenceInformation(dimension).getPreviousUpdateConvergenceInformation(dimension);
    }

    @Override
    public Map<String,Map<?,ConvergenceInformationElement>> getPreviousUpdateConvergenceInformation() {
        Map<String,Map<?,ConvergenceInformationElement>> ci = new HashMap<>();
        for (String dimension : convergenceInformations.keySet())
            ci.putAll(getDimensionConvergenceInformation(dimension).getPreviousUpdateConvergenceInformation());
        return ci;
    }

    @Override
    public double computeConvergenceMeasure(double target, double value) {
        throw new UnsupportedOperationException("Cannot compute convergence measure for composite information.");
    }

    @Override
    public double getConvergenceCriterion(String dimensionName) {
        return getDimensionConvergenceInformation(dimensionName).getConvergenceCriterion(dimensionName);
    }

    @Override
    public void updateDimension(String dimensionName, Map<?,Double> values) {
        getDimensionConvergenceInformation(dimensionName).updateDimension(dimensionName,values);
    }

    @Override
    public boolean isConverged(String dimensionName) {
        return getDimensionConvergenceInformation(dimensionName).isConverged(dimensionName);
    }

    @Override
    public boolean isConverged() {
        for (ConvergenceInformation ci : convergenceInformations.values())
            if (!ci.isConverged())
                return false;
        return true;
    }

    @Override
    public boolean meetsStoppingCriteria(String dimensionName) {
        return getDimensionConvergenceInformation(dimensionName).meetsStoppingCriteria(dimensionName);
    }

    @Override
    public boolean meetsStoppingCriteria() {
        for (ConvergenceInformation ci : convergenceInformations.values())
            if (!ci.meetsStoppingCriteria())
                return false;
        return true;
    }

    @Override
    public int getUpdateCount(String dimensionName) {
        return getDimensionConvergenceInformation(dimensionName).getUpdateCount(dimensionName);
    }
}