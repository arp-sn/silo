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
package de.tum.bgu.msm;

import de.tum.bgu.msm.container.SiloDataContainerImpl;
import de.tum.bgu.msm.container.SiloModelContainer;
import de.tum.bgu.msm.container.SiloModelContainerImpl;
import de.tum.bgu.msm.data.HouseholdDataManager;
import de.tum.bgu.msm.data.SummarizeData;
import de.tum.bgu.msm.data.travelTimes.SkimTravelTimes;
import de.tum.bgu.msm.events.IssueCounter;
import de.tum.bgu.msm.events.MicroEvent;
import de.tum.bgu.msm.events.Simulator;
import de.tum.bgu.msm.models.AnnualModel;
import de.tum.bgu.msm.models.EventModel;
import de.tum.bgu.msm.models.transportModel.matsim.MatsimTransportModel;
import de.tum.bgu.msm.properties.Properties;
import de.tum.bgu.msm.properties.modules.TransportModelPropertiesModule;
import de.tum.bgu.msm.utils.SiloUtil;
import de.tum.bgu.msm.utils.TimeTracker;
import de.tum.bgu.msm.utils.TravelTimeUtil;
import org.apache.log4j.Logger;
import org.matsim.core.config.Config;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static de.tum.bgu.msm.properties.modules.TransportModelPropertiesModule.TransportModelIdentifier.NONE;

/**
 * @author Greg Erhardt
 * Created on Dec 2, 2009
 */
public final class SiloModel {

	private final static Logger logger = Logger.getLogger(SiloModel.class);

	private final Set<Integer> tdmYears = new HashSet<>();
	private final Set<Integer> skimYears = new HashSet<>();
    private final Set<Integer> scalingYears = new HashSet<>();
	private final Properties properties;

	private SiloModelContainer modelContainer;
	private SiloDataContainerImpl data;
	private final Config matsimConfig;
    private Simulator simulator;
    private final TimeTracker timeTracker = new TimeTracker();

    public SiloModel(Properties properties) {
		this(null, properties) ;
	}

	public SiloModel(Config matsimConfig, Properties properties) {
		IssueCounter.setUpCounter();
		this.properties = properties;
		SiloUtil.modelStopper("initialize");
		this.matsimConfig = matsimConfig ;
	}

	public void runModel() {
		logger.info("Scenario: " + properties.main.scenarioName + ", Simulation start year: " + properties.main.startYear);
		long startTime = System.currentTimeMillis();
		try{
			setupModel();
			runYearByYear();
			endSimulation();
		} catch (Exception e){
			logger.error("Error running SILO.");
			throw new RuntimeException(e);
		} finally {
			SiloUtil.closeAllFiles(startTime, timeTracker);
		}

	}

	private void setupModel() {
		logger.info("Setting up SILO Model (Implementation " + properties.main.implementation + ")");
        setupContainer();
        setupYears();
        setupTravelTimes();
        setupAccessibility();
        setupMicroSim();
        IssueCounter.logIssues(data.getGeoData());


		if (properties.main.createPrestoSummary) {
			SummarizeData.preparePrestoSummary(data.getGeoData());
		}
	}

    private void setupContainer() {
        data = SiloDataContainerImpl.loadSiloDataContainer(properties);
		IssueCounter.regionSpecificCounters(data.getGeoData());
		data.getHouseholdData().calculateInitialSettings();
		data.getJobData().calculateEmploymentForecast();
		data.getJobData().identifyVacantJobs();
		data.getJobData().calculateJobDensityByZone();
		data.getRealEstateData().fillQualityDistribution();
		data.getRealEstateData().setHighestVariablesAndCalculateRentShareByIncome();
		data.getRealEstateData().identifyVacantDwellings();
        modelContainer = SiloModelContainerImpl.createSiloModelContainer(data, matsimConfig, properties);
    }

    private void setupTravelTimes() {
		if(properties.transportModel.transportModelIdentifier == TransportModelPropertiesModule.TransportModelIdentifier.MATSIM) {
		    if(properties.transportModel.matsimInitialEventsFile == null) {
                modelContainer.getTransportModel().runTransportModel(properties.main.startYear);
            } else {
                String eventsFile = properties.main.baseDirectory + properties.transportModel.matsimInitialEventsFile;
                ((MatsimTransportModel) modelContainer.getTransportModel()).replayFromEvents(eventsFile);
            }
		} else {
			updateSkims(properties.main.startYear);
		}
	}

	private void updateSkims(int year) {
		TravelTimeUtil.updateCarSkim((SkimTravelTimes) data.getTravelTimes(),
				year, properties);
		TravelTimeUtil.updateTransitSkim((SkimTravelTimes) data.getTravelTimes(),
				year, properties);
	}

    private void setupAccessibility() {
        modelContainer.getAcc().initialize();
        modelContainer.getAcc().calculateHansenAccessibilities(properties.main.startYear);
    }

	private void setupYears() {
		scalingYears.addAll(properties.main.scalingYears);
		if (!scalingYears.isEmpty()) {
			SummarizeData.readScalingYearControlTotals();
		}
		tdmYears.addAll(properties.transportModel.transportModelYears);
		skimYears.addAll(properties.accessibility.skimYears);
	}

	private void setupMicroSim() {
        simulator = new Simulator(timeTracker);
        for(Map.Entry<Class<? extends MicroEvent>, EventModel> eventModel: modelContainer.getEventModels().entrySet()) {
        	simulator.registerEventModel(eventModel.getKey(), eventModel.getValue());
		}
		for(AnnualModel annualModel: modelContainer.getAnnualModels()) {
			simulator.registerAnnualModel(annualModel);
		}
    }

	private void runYearByYear() {

        final HouseholdDataManager householdData = data.getHouseholdData();

        for (int year = properties.main.startYear; year < properties.main.endYear; year ++) {

            logger.info("Simulating changes from year " + year + " to year " + (year + 1));
            IssueCounter.setUpCounter();    // setup issue counter for this simulation period
            SiloUtil.trackingFile("Simulating changes from year " + year + " to year " + (year + 1));
            timeTracker.setCurrentYear(year);

            timeTracker.reset();
            if (scalingYears.contains(year)) {
                SummarizeData.scaleMicroDataToExogenousForecast(year, data);
            }
            timeTracker.recordAndReset("scaleDataToForecast");

            if (year != properties.main.implementation.BASE_YEAR) {
				data.getJobData().identifyVacantJobs();
			}
			timeTracker.recordAndReset("setupJobChange");

			modelContainer.getDdOverwrite().addDwellings(year);
            timeTracker.recordAndReset("addOverwriteDwellings");

			if (year != properties.main.implementation.BASE_YEAR) {
			    householdData.adjustIncome();
            }
			timeTracker.record("planIncomeChange");

			if (year == properties.main.implementation.BASE_YEAR || year != properties.main.startYear) {
                SiloUtil.summarizeMicroData(year, modelContainer, data);
            }

            simulator.simulate(year);

			timeTracker.reset();
			int[] carChangeCounter = modelContainer.getUpdateCarOwnershipModel().updateCarOwnership(householdData.getUpdatedHouseholds());
			householdData.clearUpdatedHouseholds();
			timeTracker.recordAndReset("updateCarOwnership");


			int avSwitchCounter = 0;
			if (properties.main.implementation == Implementation.MUNICH){
				avSwitchCounter = modelContainer.getSwitchToAutonomousVehicleModel().switchToAV(householdData.getConventionalCarsHouseholds(), year);
				householdData.clearConventionalCarsHouseholds();
				timeTracker.recordAndReset("switchToAV");
			}

			if (skimYears.contains(year) && year != properties.main.startYear) {
				updateSkims(year);
				timeTracker.recordAndReset("Skim update");
			}

			if ( properties.transportModel.transportModelIdentifier != NONE && tdmYears.contains(year + 1)) {
                    modelContainer.getTransportModel().runTransportModel(year + 1);
					timeTracker.recordAndReset("transportModel");
            }

			modelContainer.getAcc().calculateHansenAccessibilities(year+1);
			timeTracker.recordAndReset("calcAccessibilities");

			modelContainer.getPrm().updatedRealEstatePrices();
			timeTracker.record("updateRealEstatePrices");

			simulator.finishYear(year, carChangeCounter, avSwitchCounter, data);
			IssueCounter.logIssues(data.getGeoData());           // log any issues that arose during this simulation period

			logger.info("  Finished this simulation period with " + householdData.getPersonCount() +
					" persons, " + householdData.getHouseholds().size() + " households and "  +
					data.getRealEstateData().getDwellings().size() + " dwellings.");

			if (SiloUtil.modelStopper("check")) {
			    break;
            }
            timeTracker.endYear();
		}
	}

	private void endSimulation() {
		if (scalingYears.contains(properties.main.endYear)) {
            SummarizeData.scaleMicroDataToExogenousForecast(properties.main.endYear, data);
        }

		if (properties.main.printOutFinalSyntheticPopulation) {
			SummarizeData.writeOutSyntheticPopulation(properties.main.endYear, data);
			SummarizeData.writeOutDevelopmentFile(data);
		}


		SiloUtil.summarizeMicroData(properties.main.endYear, modelContainer, data);
		SiloUtil.finish(modelContainer);
		SiloUtil.modelStopper("removeFile");
        SiloUtil.writeOutTimeTracker(timeTracker);
		logger.info("Scenario results can be found in the directory scenOutput/" + properties.main.scenarioName + ".");
	}
}
