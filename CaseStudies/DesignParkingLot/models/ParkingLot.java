package CaseStudies.DesignParkingLot.models;

import CaseStudies.DesignParkingLot.enums.ParkingLotStatus;
import CaseStudies.DesignParkingLot.enums.SupportedVehicles;

import java.util.List;

public class ParkingLot extends BaseModel {
    private List<ParkingFloor> parkingFloors;
    private List<Gate> gates;
    private List<SupportedVehicles> supportedVehicles;
    private ParkingLotStatus status;
    private List<Ticket> tickets;

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public List<SupportedVehicles> getSupportedVehicles() {
        return supportedVehicles;
    }

    public void setSupportedVehicles(List<SupportedVehicles> supportedVehicles) {
        this.supportedVehicles = supportedVehicles;
    }

    public ParkingLotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingLotStatus status) {
        this.status = status;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
