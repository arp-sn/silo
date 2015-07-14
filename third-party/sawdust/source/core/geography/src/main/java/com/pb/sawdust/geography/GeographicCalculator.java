package com.pb.sawdust.geography;

import com.pb.sawdust.calculator.tensor.la.TransposedMatrix;
import com.pb.sawdust.calculator.tensor.la.mm.MatrixMultiplication;
import com.pb.sawdust.geography.tensor.GeographicBooleanMatrix;
import com.pb.sawdust.geography.tensor.GeographicDoubleMatrix;
import com.pb.sawdust.geography.tensor.GeographicDoubleVector;
import com.pb.sawdust.tabledata.DataTable;
import com.pb.sawdust.tabledata.basic.OrderedDataTable;
import com.pb.sawdust.tabledata.basic.RowDataTable;
import com.pb.sawdust.tabledata.metadata.DataType;
import com.pb.sawdust.tabledata.metadata.TableSchema;
import com.pb.sawdust.tensor.alias.matrix.primitive.DoubleMatrix;
import com.pb.sawdust.tensor.factory.TensorFactory;
import static com.pb.sawdust.util.Range.*;
import com.pb.sawdust.util.collections.CollectionOrder;
import com.pb.sawdust.util.collections.LinkedSetList;

import java.util.*;

/**
 * The {@code GeographicCalculator} class privides methods for transferring geographic data between different {@code Geogarphy}s.
 *
 * @author crf
 *         Started 10/17/11 9:02 PM
 */
public class GeographicCalculator {

    private GeographicCalculator() {}

    public static <F extends GeographyElement<?>,T extends GeographyElement<?>> GeographicDoubleVector<T> transferValues(GeographicMapping<F,T> mapping, GeographicDoubleVector<F> values, MatrixMultiplication mm) {
        return new GeographicDoubleVector<>(mapping.getToGeography(),mm.multiply(values,mapping.getOverlay()));
    }

    @SuppressWarnings("unchecked") //doing some silly stuff with untyped generics, but in the end it is correct
    public static <F extends GeographyElement<?>,T extends GeographyElement<?>> DataTable transferValueTable(DataTable table, String fromIdField, List<String> fieldsToTransfer, GeographicMapping<F,T> mapping,
                                                                                                             String toIdField, DataType toIdType, TensorFactory factory, MatrixMultiplication mm) {
        Geography<?,F> fromGeography = mapping.getFromGeography();
        Geography fg = fromGeography; //to get around type restrictions
        List<F> fromElements = new LinkedList<>();
        for (Object f : Arrays.<Object>asList(table.getColumn(fromIdField).getData()))
            fromElements.add((F) fg.getElement(f));
        DataTable orderedTable = new OrderedDataTable(table,CollectionOrder.getOrder(fromElements,new LinkedSetList<>(fromGeography.getGeography())));
        orderedTable.setDataCoersion(true);
        DoubleMatrix originalData = factory.doubleMatrix(fieldsToTransfer.size(),orderedTable.getRowCount());
        int counter = 0;
        for (String field : fieldsToTransfer) {
            int r = 0;
            for (double v : orderedTable.getDoubleColumn(field))
                originalData.setCell(v,counter,r++);
            counter++;
        }

        DoubleMatrix transferredData = mm.multiply(originalData,mapping.getOverlay());

        Geography<?,T> toGeography = mapping.getToGeography();
        List<String> labels = new LinkedList<>();
        labels.add(toIdField);
        labels.addAll(fieldsToTransfer);
        List<DataType> types = new LinkedList<>();
        types.add(toIdType);
        for (int i : range(fieldsToTransfer.size()))
            types.add(DataType.DOUBLE);
        TableSchema schema = new TableSchema(table + " (transferred)",labels.toArray(new String[labels.size()]),types.toArray(new DataType[types.size()]));
        DataTable newData = new RowDataTable(schema);
        counter = 0;
        for (T toElement : toGeography.getGeography()) {
            Object[] data = new Object[types.size()];
            data[0] = toElement.getIdentifier();
            for (int f : range(transferredData.size(0))) {
                data[f+1] = transferredData.getCell(f,counter);
            }
            newData.addRow(data);
            counter++;
        }
        return newData;
    }

    public static <F extends GeographyElement<?>,T extends GeographyElement<?>> Map<T,Set<F>> getUsageMap(GeographicMapping<F,T> mapping) {
        GeographicBooleanMatrix<F,T> usageMatrix = mapping.getUsageOverlay();
        Map<T,Set<F>> usageMap = new HashMap<>();
        for (T to : mapping.getToGeography().getGeography()) {
            Set<F> usageSet = new HashSet<>();
            for (F from : mapping.getFromGeography().getGeography())
                if (usageMatrix.getCellById(from,to))
                    usageSet.add(from);
            usageMap.put(to,usageSet);
        }
        return usageMap;
    }

    public static <F extends GeographyElement<?>,T extends GeographyElement<?>> GeographicMapping<T,F> invertMapping(GeographicMapping<F,T> mapping, TensorFactory factory) {
        //note, if size units are not the same, this method is bunk!
        GeographicDoubleMatrix<F,T> overlay = mapping.getOverlay();
        GeographicDoubleMatrix<T,F> inverse = new GeographicDoubleMatrix<>(mapping.getToGeography(),mapping.getFromGeography(),factory);
        for (T to : mapping.getToGeography().getGeography())
            for (F from : mapping.getFromGeography().getGeography())
                inverse.setCellById(overlay.getValueById(from,to)*to.getSize()/from.getSize(),to,from);
        return new FullGeographicMapping<>(inverse);
    }

    //usage inversions are trivial, but useful, so offer second method just form them
    public static <F extends GeographyElement<?>,T extends GeographyElement<?>> GeographicBooleanMatrix<T,F> invertUsage(GeographicMapping<F,T> mapping) {
        return new GeographicBooleanMatrix<>(mapping.getToGeography(),mapping.getFromGeography(),TransposedMatrix.transpose(mapping.getUsageOverlay()));
    }
}