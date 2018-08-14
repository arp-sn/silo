/*
 * Copyright  2005 PB Consult Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package de.tum.bgu.msm.data;

/**
 * Class to hold job data
 * Author: Rolf Moeckel, PB Albuquerque
 * Created on 22 February 2013 in Santa Fe
 **/

public final class Job {

	private final int id;
    private int workerId;
    private final String type;
    private Location location;

    Job (int id, Location location, int workerId, String type) {
        this.id = id;
        this.location = location;
        this.workerId = workerId;
        this.type = type;
    }
    
    public int determineZoneId() {
    	if (location instanceof MicroLocation) {
    		return ((MicroLocation) location).getZone().getId();
    	} else if (location instanceof Zone) {
    		return ((Zone) location).getId();
    	} else {
    		throw new IllegalStateException("No implementation for Location of type " + location.getClass().getName());
    	}
    }

    public int getId () {
        return id;
    }

    public int getWorkerId() {
        return workerId;
    }

    public String getType() {
        return type;
    }

    public Location getLocation() {
        return location;
    }
    
    public void setLocation(Location location) {
        this.location = location;
    }
    
    public void setWorkerID(int personID) {
        this.workerId = personID;
    }

    @Override
    public String toString() {
        return "Attributes of job       " + id
//                + "\nLocated in zone         " + zone
                + "\nLocated at         " + location // TODO implement toString methods
                + "\nFilled by person        " + workerId
                + "\nJob type                " + type;
    }
 }