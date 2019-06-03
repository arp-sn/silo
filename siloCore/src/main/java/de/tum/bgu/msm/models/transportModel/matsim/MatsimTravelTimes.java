package de.tum.bgu.msm.models.transportModel.matsim;

import com.google.common.collect.Iterables;
import de.tum.bgu.msm.data.Location;
import de.tum.bgu.msm.data.MicroLocation;
import de.tum.bgu.msm.data.Region;
import de.tum.bgu.msm.data.Zone;
import de.tum.bgu.msm.data.geo.GeoData;
import de.tum.bgu.msm.data.travelTimes.TravelTimes;
import de.tum.bgu.msm.properties.Properties;
import de.tum.bgu.msm.util.concurrent.ConcurrentExecutor;
import de.tum.bgu.msm.util.matrices.IndexedDoubleMatrix2D;
import de.tum.bgu.msm.utils.SiloUtil;
import org.apache.log4j.Logger;
import org.locationtech.jts.geom.Coordinate;
import org.matsim.api.core.v01.Coord;
import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.TransportMode;
import org.matsim.api.core.v01.network.Network;
import org.matsim.api.core.v01.network.Node;
import org.matsim.api.core.v01.population.Activity;
import org.matsim.api.core.v01.population.Leg;
import org.matsim.api.core.v01.population.PlanElement;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.network.NetworkUtils;
import org.matsim.core.population.PopulationUtils;
import org.matsim.core.router.*;
import org.matsim.core.router.util.LeastCostPathCalculator;
import org.matsim.core.router.util.TravelDisutility;
import org.matsim.core.router.util.TravelTime;
import org.matsim.core.utils.geometry.CoordUtils;
import org.matsim.facilities.ActivityFacilitiesFactory;
import org.matsim.facilities.ActivityFacilitiesFactoryImpl;
import org.matsim.facilities.ActivityFacility;
import org.matsim.facilities.Facility;
import org.matsim.pt.PtConstants;

import java.util.*;

/**
 * @author dziemke
 */
public final class MatsimTravelTimes implements TravelTimes {
    private final static Logger logger = Logger.getLogger(MatsimTravelTimes.class);

    private final static int NUMBER_OF_CALC_POINTS = 1;
    private Network network;

    private final Map<String, IndexedDoubleMatrix2D> skimsByMode = new HashMap<>();
    private Map<Integer, Zone> zones;

    private TravelTime travelTime;
    private TravelDisutility travelDisutility;

    private TripRouter tripRouter;

    private final Map<Zone, List<Node>> zoneCalculationNodesMap = new HashMap<>();

    private IndexedDoubleMatrix2D travelTimeToRegion;

    public void initialize(GeoData geoData, Network network) {
        this.network = network;
        this.zones = geoData.getZones();
        this.travelTimeToRegion = new IndexedDoubleMatrix2D(geoData.getZones().values(), geoData.getRegions().values());
        this.travelTimeToRegion.assign(-1);
        buildZoneCalculationNodesMap();
    }

    public void update(TravelTime travelTime, TravelDisutility disutility) {
        LeastCostPathCalculator pathCalculator = new FastAStarLandmarksFactory().createPathCalculator(network, disutility, travelTime);
        TripRouter.Builder bd = new TripRouter.Builder(ConfigUtils.createConfig());
        RoutingModule carRoutingModule = new NetworkRoutingModule(TransportMode.car, PopulationUtils.getFactory(), network, pathCalculator);
        bd.setRoutingModule(TransportMode.car, carRoutingModule);
        TeleportationRoutingModule teleportationRoutingModule = new TeleportationRoutingModule(TransportMode.pt, PopulationUtils.getFactory(), 10, 1.3);
        bd.setRoutingModule(TransportMode.pt, teleportationRoutingModule);
        tripRouter = bd.build();
        this.travelTime = travelTime;
        this.travelDisutility = disutility;
        this.skimsByMode.clear();
        if(this.travelTimeToRegion != null) {
            this.travelTimeToRegion.assign(-1);
        }
    }


    // TODO Use travel costs?
    @Override
    public double getTravelTime(Location origin, Location destination, double timeOfDay_s, String mode) {
        // Microlocations case
        Coord originCoord;
        Coord destinationCoord;
        if (origin instanceof MicroLocation && destination instanceof MicroLocation) {
            originCoord = CoordUtils.createCoord(((MicroLocation) origin).getCoordinate());
            destinationCoord = CoordUtils.createCoord(((MicroLocation) destination).getCoordinate());
        } else if (origin instanceof Zone && destination instanceof Zone) {
            // Non-microlocations case
            originCoord = zoneCalculationNodesMap.get(origin).get(0).getCoord();
            destinationCoord = zoneCalculationNodesMap.get(destination).get(0).getCoord();
        } else {
            throw new IllegalArgumentException("Origin and destination have to be consistent in location type!");
        }

        ActivityFacilitiesFactoryImpl activityFacilitiesFactory = new ActivityFacilitiesFactoryImpl();
        Facility fromFacility = ((ActivityFacilitiesFactory) activityFacilitiesFactory).createActivityFacility(Id.create(1, ActivityFacility.class), originCoord);
        Facility toFacility = ((ActivityFacilitiesFactory) activityFacilitiesFactory).createActivityFacility(Id.create(2, ActivityFacility.class), destinationCoord);
        List<? extends PlanElement> planElements = tripRouter.calcRoute(mode, fromFacility, toFacility, timeOfDay_s, null);
        double time = 0;
        for (PlanElement e : planElements) {
            if (e instanceof Leg) {
                time += ((Leg) e).getTravelTime();
            } else if (e instanceof Activity) {
                if (((Activity) e).getType().equalsIgnoreCase(PtConstants.TRANSIT_ACTIVITY_TYPE)) {
                    time += ((Activity) e).getEndTime() - ((Activity) e).getStartTime();
                }
            }
        }

        //convert to minutes
        time /= 60.;
        return time;
    }

    @Override
    public double getTravelTimeToRegion(Location origin, Region destination, double timeOfDay_s, String mode) {
        if (origin instanceof Zone) {
            int originZone = origin.getZoneId();
            if (travelTimeToRegion.getIndexed(originZone, destination.getId()) > 0) {
                return travelTimeToRegion.getIndexed(originZone, destination.getId());
            }
            double min = Double.MAX_VALUE;
            for (Zone zoneInRegion : destination.getZones()) {
                double travelTime = getPeakSkim(mode).getIndexed(originZone, zoneInRegion.getZoneId());
                if (travelTime < min) {
                    min = travelTime;
                }
            }
            travelTimeToRegion.setIndexed(originZone, destination.getId(), min);
            return min;
        } else {
            throw new IllegalArgumentException("Not implemented for origins of types other than Zone. Type is of type " + origin.getClass());
        }
    }

    @Override
    public IndexedDoubleMatrix2D getPeakSkim(String mode) {
        if (skimsByMode.containsKey(mode)) {
            return skimsByMode.get(mode);
        } else {
            IndexedDoubleMatrix2D skim = new IndexedDoubleMatrix2D(zones.values(), zones.values());
            logger.info("Calculating skim matrix for mode " + mode + " using " + Properties.get().main.numberOfThreads + " threads.");
            final int partitionSize = (int) ((double) zones.size() / (Properties.get().main.numberOfThreads)) + 1;
            logger.info("Intended size of all of partitions = " + partitionSize);
            Iterable<List<Zone>> partitions = Iterables.partition(zones.values(), partitionSize);
            ConcurrentExecutor<Void> executor = ConcurrentExecutor.fixedPoolService(Properties.get().main.numberOfThreads);

            for (final List<Zone> partition : partitions) {
                if (mode.equalsIgnoreCase(TransportMode.car)) {
                    executor.addTaskToQueue(() -> {
                        try {
                            MultiNodePathCalculator calculator
                                    = (MultiNodePathCalculator) new FastMultiNodeDijkstraFactory(true).createPathCalculator(network, travelDisutility, travelTime);

                            Set<InitialNode> toNodes = new HashSet<>();
                            for (Zone zone : zones.values()) {
                                for (int i = 0; i < NUMBER_OF_CALC_POINTS; i++) {
                                    Node originNode = zoneCalculationNodesMap.get(zone).get(0);
                                    toNodes.add(new InitialNode(originNode, 0., 0.));
                                }
                            }

                            ImaginaryNode aggregatedToNodes = MultiNodeDijkstra.createImaginaryNode(toNodes);

                            for (Zone origin : partition) {
                                Node node = zoneCalculationNodesMap.get(origin).get(0);
                                calculator.calcLeastCostPath(node, aggregatedToNodes, Properties.get().transportModel.peakHour_s, null, null);
                                for (Zone destination : zones.values()) {
                                    double travelTime = calculator.constructPath(node, zoneCalculationNodesMap.get(destination).get(0), Properties.get().transportModel.peakHour_s).travelTime;

                                    //convert to minutes
                                    travelTime /= 60.;

                                    skim.setIndexed(origin.getZoneId(), destination.getZoneId(), travelTime);
                                }
                            }
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        return null;
                    });
                } else {
                    executor.addTaskToQueue(() -> {
                        try {
                            TravelTimes copy = duplicate();
                            for (Zone origin : partition) {
                                for (Zone destination : zones.values()) {
                                    double travelTime = copy.getTravelTime(origin, destination, Properties.get().transportModel.peakHour_s, mode);

                                    //convert to minutes
                                    travelTime /= 60.;

                                    skim.setIndexed(origin.getZoneId(), destination.getZoneId(), travelTime);
                                }
                            }
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        return null;
                    });
                }
            }
            executor.execute();
            skimsByMode.put(mode, skim);
            logger.info("Finished skim for mode " + mode);
            return skim;
        }
    }

    @Override
    public TravelTimes duplicate() {
        logger.warn("Creating another TravelTimes object.");
        MatsimTravelTimes matsimTravelTimes = new MatsimTravelTimes();
        matsimTravelTimes.network = this.network;
        matsimTravelTimes.zones = this.zones;
        matsimTravelTimes.zoneCalculationNodesMap.putAll(this.zoneCalculationNodesMap);
        matsimTravelTimes.update(travelTime, travelDisutility);
        matsimTravelTimes.travelTimeToRegion = this.travelTimeToRegion.copy();
        matsimTravelTimes.skimsByMode.putAll(this.skimsByMode);
        return matsimTravelTimes;
    }


    private void buildZoneCalculationNodesMap() {
        for (Zone zone : zones.values()) {
            // Several points in a given origin zone
            for (int i = 0; i < NUMBER_OF_CALC_POINTS; i++) {
                // TODO Check if random coordinate is the best representative
                Coordinate coordinate = zone.getRandomCoordinate(SiloUtil.getRandomObject());
                Coord originCoord = new Coord(coordinate.x, coordinate.y);
                Node originNode = NetworkUtils.getNearestLink(network, originCoord).getToNode();

                if (!zoneCalculationNodesMap.containsKey(zone)) {
                    zoneCalculationNodesMap.put(zone, new LinkedList<>());
                }
                zoneCalculationNodesMap.get(zone).add(originNode);
            }
        }
        logger.warn("There are " + zoneCalculationNodesMap.keySet().size() + " origin zones.");
    }

    public Network getNetwork() {
        return network;
    }
}