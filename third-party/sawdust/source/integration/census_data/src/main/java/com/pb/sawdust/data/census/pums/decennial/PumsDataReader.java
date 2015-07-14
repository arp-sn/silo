package com.pb.sawdust.data.census.pums.decennial;

import com.pb.sawdust.data.census.pums.AbstractPumaDataReader;
import com.pb.sawdust.tabledata.metadata.DataType;
import com.pb.sawdust.tabledata.read.FixedWidthTextTableReader;
import com.pb.sawdust.tabledata.read.MultiTextTableReader;
import com.pb.sawdust.tabledata.read.TableReader;
import com.pb.sawdust.util.Filter;
import com.pb.sawdust.util.array.ArrayUtil;

import java.util.*;

/**
 * The {@code PumsDataReader} is used to read decennial Census PUMS data. Decennial PUMS data is held in 
 * fixed format files holding both household and person records.
 *       
 * @param <H>
 *        The type of the household field this reader reads, as specified by the data dictionary type. This field must be 
 *        an {@code enum}.  
 *        
 * @param <P>
 *        The type of the person field this reader reads, as specified by the data dictionary type. This field must be an 
 *        {@code enum}.
 *        
 * @param <D>
 *        The type of the data dictionary which defines the metadata about the files this reader reads.
 *
 * @author crf
 *         Started 10/13/11 10:00 PM
 */
public class PumsDataReader<H extends Enum<H> & PumsDataDictionary.PumsHouseholdField,P extends Enum<P> & PumsDataDictionary.PumsPersonField,D extends PumsDataDictionary<H,P>> extends AbstractPumaDataReader<String,H,P,D> {
    private final List<String> files;

    /**
     * Constructor specifying the data dictionary and the files the built table readers will read from.
     * 
     * @param files
     *        The PUMS data file paths.
     * 
     * @param dataDictionary
     *        The data dictionary used by this reader.
     */
    public PumsDataReader(Collection<String> files,D dataDictionary) {
        super(dataDictionary);
        this.files = new LinkedList<>(files);
    }

    @Override
    protected TableReader[] getActualTableReaders() {
        List<TableReader> householdReaders = new LinkedList<>();
        List<TableReader> personReaders = new LinkedList<>();
        Set<H> hhFields = getHouseholdFields();
        Set<P> personFields = getPersonFields();

        List<Integer> widths = new LinkedList<>();
        int[] hhColumns = new int[hhFields.size()];
        DataType[] hhTypes = new DataType[hhFields.size()];
        String[] hhNames = new String[hhFields.size()];
        int counter = 0;
        for (H householdField : getDataDictionary().getAllHouseholdFields()) {
            widths.add(householdField.getWidth());
            if (hhFields.contains(householdField)) {
                hhColumns[counter] = householdField.getColumnOrdinal();
                hhTypes[counter] = householdField.getColumnType();
                hhNames[counter] = householdField.getColumnName();
                counter++;
            }
        }
        int[] hhWidths = ArrayUtil.toIntArray(widths);

        widths = new LinkedList<>();
        int[] personColumns = new int[personFields.size()];
        DataType[] personTypes = new DataType[personFields.size()];
        String[] personNames = new String[personFields.size()];
        counter = 0;
        for (P personField : getDataDictionary().getAllPersonFields()) {
            widths.add(personField.getWidth());
            if (personFields.contains(personField)) {
                personColumns[counter] = personField.getColumnOrdinal();
                personTypes[counter] = personField.getColumnType();
                personNames[counter] = personField.getColumnName();
                counter++;
            }
        }
        int[] personWidths = ArrayUtil.toIntArray(widths);

        for (String file : files) {
            FixedWidthTextTableReader hhReader = new FixedWidthTextTableReader(file,HOUSEHOLD_TABLE_NAME,hhWidths);
            hhReader.setFileHasHeader(false);
            hhReader.setColumnsToKeep(hhColumns);
            hhReader.setColumnNames(hhNames);
            hhReader.setColumnTypes(hhTypes);
            hhReader.addLineFilter(getHouseholdLineFilter());
            hhReader.setRowFilter(getHouseholdDataFilter());

            FixedWidthTextTableReader personReader = new FixedWidthTextTableReader(file,PERSON_TABLE_NAME,personWidths);
            hhReader.setFileHasHeader(false);
            personReader.setColumnsToKeep(personColumns);
            personReader.setColumnNames(personNames);
            personReader.setColumnTypes(personTypes);
            personReader.addLineFilter(getPersonLineFilter());
            personReader.setRowFilter(getPersonDataFilter());

            MultiTextTableReader<String,FixedWidthTextTableReader> reader = new MultiTextTableReader<>(new FixedWidthTextTableReader[]{hhReader,personReader});
            householdReaders.add(reader.getReader(HOUSEHOLD_TABLE_NAME));
            personReaders.add(reader.getReader(PERSON_TABLE_NAME));
        }
        return new TableReader[] {new MultiFilePumsReader(householdReaders),new MultiFilePumsReader(personReaders)};
    }

    protected Filter<String> getHouseholdLineFilter() {
        final Filter<String> hhFilter = super.getHouseholdLineFilter();
        return new Filter<String>() {
            @Override
            public boolean filter(String input) {
                return input.startsWith("H") && hhFilter.filter(input);
            }
        };
    }

    protected Filter<String> getPersonLineFilter() {
        final Filter<String> personFilter = super.getPersonLineFilter();
        return new Filter<String>() {
            @Override
            public boolean filter(String input) {
                return input.startsWith("P") && personFilter.filter(input);
            }
        };
    }
}