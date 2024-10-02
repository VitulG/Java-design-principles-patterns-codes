package CaseStudies.DesignParkingLot.models;

import CaseStudies.DesignParkingLot.enums.SpotStatus;
import CaseStudies.DesignParkingLot.enums.VehicleType;

import java.util.List;

public class ParkingSpot extends BaseModel{
    private Long parkingSpotNumber;
    private ParkingFloor floor;
    private List<VehicleType> vehicleTypes;
    private SpotStatus status;

    public Long getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public void setParkingSpotNumber(Long parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }

    public ParkingFloor getFloor() {
        return floor;
    }

    public void setFloor(ParkingFloor floor) {
        this.floor = floor;
    }

    public List<VehicleType> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(List<VehicleType> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }

    public SpotStatus getStatus() {
        return status;
    }

    public void setStatus(SpotStatus status) {
        this.status = status;
    }
}
