package CaseStudies.DesignParkingLot.strategies;

import CaseStudies.DesignParkingLot.models.ParkingFloor;
import CaseStudies.DesignParkingLot.models.ParkingLot;
import CaseStudies.DesignParkingLot.models.ParkingSpot;
import CaseStudies.DesignParkingLot.models.Vehicle;

public interface ParkingSpotAssignmentStrategy {
    ParkingSpot assignASpot(ParkingLot parkingLot, Vehicle vehicle);
}
