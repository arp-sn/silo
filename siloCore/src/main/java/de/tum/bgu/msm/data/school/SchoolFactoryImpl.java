package de.tum.bgu.msm.data.school;

import de.tum.bgu.msm.Implementation;
import de.tum.bgu.msm.properties.Properties;
import org.locationtech.jts.geom.Coordinate;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SchoolFactoryImpl implements SchoolFactory {
    private final Map<String, Map<Integer,Double>> startTimeDistributionBySchoolType = new ConcurrentHashMap<>();
    private final Map<String, Map<Integer,Double>> studyTimeDistributionBySchoolType = new ConcurrentHashMap<>();
    private int intervalInSecondsForPreferredTimes;

    @Override
    public School createSchool(int id, int type, int capacity, int occupancy, Coordinate coordinate, int zoneId) {
        School school = new SchoolImpl(id, type, capacity, occupancy, coordinate, zoneId);

        //TODO: same as job? element and secondary school have same schoolTime, university has a distribution?
        if (Properties.get().main.implementation.equals(Implementation.MUNICH)) {
            //school.setSchoolStudyingTime();
        }

        return school;
    }


}
