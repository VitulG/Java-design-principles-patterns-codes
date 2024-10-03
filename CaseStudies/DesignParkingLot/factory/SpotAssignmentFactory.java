package CaseStudies.DesignParkingLot.factory;

import CaseStudies.DesignParkingLot.enums.ParkingSpotStrategyType;
import CaseStudies.DesignParkingLot.models.ParkingSpot;
import CaseStudies.DesignParkingLot.strategies.CheapestSpotAssignmentStrategy;
import CaseStudies.DesignParkingLot.strategies.NearestSpotAssignmentStrategy;
import CaseStudies.DesignParkingLot.strategies.ParkingSpotAssignmentStrategy;
import CaseStudies.DesignParkingLot.strategies.VIPSpotAssignmentStrategy;

public class SpotAssignmentFactory {
    public static ParkingSpotAssignmentStrategy createSpotAssignmentStrategy(ParkingSpotStrategyType type) {
        if(type == ParkingSpotStrategyType.NEAREST) {
            return new NearestSpotAssignmentStrategy();
        }else if(type == ParkingSpotStrategyType.CHEAPEST) {
            return new CheapestSpotAssignmentStrategy();
        }else if(type == ParkingSpotStrategyType.VIP) {
            return new VIPSpotAssignmentStrategy();
        }
        return null;
    }
}
