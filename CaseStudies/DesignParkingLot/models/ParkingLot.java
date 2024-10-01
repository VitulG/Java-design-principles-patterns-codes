package CaseStudies.DesignParkingLot.models;

import CaseStudies.DesignParkingLot.enums.ParkingLotStatus;
import CaseStudies.DesignParkingLot.enums.SupportedVehicles;

import java.util.List;

public class ParkingLot {
    private Long parkingLotId;
    private List<ParkingFloor> parkingFloors;
    private List<Gate> gates;
    private List<SupportedVehicles> supportedVehicles;
    private ParkingLotStatus status;
    private List<Ticket> tickets;
}
