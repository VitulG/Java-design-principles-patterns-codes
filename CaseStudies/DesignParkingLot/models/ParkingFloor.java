package CaseStudies.DesignParkingLot.models;

import CaseStudies.DesignParkingLot.enums.ParkingFloorStatus;

import java.util.List;

public class ParkingFloor extends BaseModel {
    private Long floorNumber;
    private List<ParkingSpot> parkingSpots;
    private ParkingFloorStatus parkingFloorStatus;

    public Long getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Long floorNumber) {
        this.floorNumber = floorNumber;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public ParkingFloorStatus getParkingFloorStatus() {
        return parkingFloorStatus;
    }

    public void setParkingFloorStatus(ParkingFloorStatus parkingFloorStatus) {
        this.parkingFloorStatus = parkingFloorStatus;
    }
}
