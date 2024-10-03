package CaseStudies.DesignParkingLot.strategies;

import CaseStudies.DesignParkingLot.models.ParkingLot;
import CaseStudies.DesignParkingLot.models.ParkingSpot;
import CaseStudies.DesignParkingLot.models.Vehicle;

public class NearestSpotAssignmentStrategy implements ParkingSpotAssignmentStrategy {
    @Override
    public ParkingSpot assignASpot(ParkingLot parkingLot, Vehicle vehicle) {
        return new ParkingSpot();
    }
}
