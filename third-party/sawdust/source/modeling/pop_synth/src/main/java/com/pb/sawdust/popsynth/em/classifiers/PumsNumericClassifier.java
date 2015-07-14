package com.pb.sawdust.popsynth.em.classifiers;

import com.pb.sawdust.popsynth.em.BalanceElement;
import com.pb.sawdust.popsynth.em.extensions.PumsBalanceElement;
import com.pb.sawdust.tabledata.DataRow;
import com.pb.sawdust.util.array.ArrayUtil;

import java.util.*;

/**
 * The {@code IntegerClassifier} ...
 *
 * @author crf
 *         Started 10/1/11 11:38 AM
 */
public class PumsNumericClassifier extends AbstractBalanceDimensionClassifier<String> {
    private final boolean household;
    private final String fieldName;
    Map<String,List<double[]>> ranges;

    public PumsNumericClassifier(String name, Map<String,List<List<Double>>> ranges, String fieldName, TargetDataSpec<String> targetDataSpec, boolean household) {
        super(name,ranges.keySet(),targetDataSpec);
        this.household = household;
        this.fieldName = fieldName;
        this.ranges = buildRanges(ranges);
    }

    @Override
    public Map<String,Double> getParticipationMap(BalanceElement element) {
        Map<String,Double> participationMap = new LinkedHashMap<>();
        for (String classification : getClassificationCategories())
            participationMap.put(classification,0.0);
        if (household) {
            String part = getParticipation(element.getElementData().get(PumsBalanceElement.HOUSEHOLD_ROW_KEY));
            if (part != null)
                participationMap.put(part,1.0);
        } else {
            for (Map.Entry<String,DataRow> row : element.getElementData().entrySet()) {
                if (row.getKey().startsWith(PumsBalanceElement.PERSON_ROW_KEY_PREFIX)) {
                    String part = getParticipation(row.getValue());
                    if (part != null)
                        participationMap.put(part,participationMap.get(part)+1.0);
                }
            }
        }
        return participationMap;
    }

    private String getParticipation(DataRow row) {
        for (Map.Entry<String,List<double[]>> entry : ranges.entrySet())
            if (isParticipant(row.getCellAsDouble(fieldName),entry.getValue()))
                return entry.getKey();
        return null;
    }

    private boolean isParticipant(double value, Collection<double[]> participationRanges) {
        for (double[] d : participationRanges)
            if (value >= d[0] && value < d[1])
                return true;
        return false;
    }

    private Map<String,List<double[]>> buildRanges(Map<String,List<List<Double>>> ranges) {
        Map<String,List<double[]>> outRanges = new HashMap<>();
        for (String s : ranges.keySet())
            outRanges.put(s,cleanRanges(ranges.get(s)));
        return outRanges;
    }

    private List<double[]> cleanRanges(List<List<Double>> ranges) {
        Map<Double,double[]> sortedRanges = new TreeMap<>();
        for (List<Double> d : ranges) {
            if (d.size() != 2)
                throw new IllegalArgumentException("Ranges must be of size two: "+ d);
            double[] range = ArrayUtil.toDoubleArray(d);
            Collection<double[]> existingRanges = sortedRanges.values();
            if (isParticipant(range[0],existingRanges) || isParticipant(range[1],existingRanges))
                throw new IllegalArgumentException("Overlapping ranges: (" + Arrays.toString(range) + ") " + ranges);
            sortedRanges.put(range[0],range);
        }
        List<double[]> finalRanges = new LinkedList<>();
        for (Double key : sortedRanges.keySet())
            finalRanges.add(sortedRanges.get(key));
        return finalRanges;
    }
}