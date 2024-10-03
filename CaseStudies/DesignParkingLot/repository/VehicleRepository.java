package CaseStudies.DesignParkingLot.repository;

import CaseStudies.DesignParkingLot.models.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRepository {
    private final Map<String, Vehicle> vehicleMap;

    public VehicleRepository() {
        vehicleMap = new HashMap<>();
    }

    public Vehicle save(Vehicle vehicle) {
        // Save vehicle to the database
        return vehicleMap.put(vehicle.getVehicleNumber(), vehicle);
    }

//    public Optional<Vehicle> findByVehicleId(Long id) {
//        // Retrieve vehicle from the database by vehicle number
//        return ;
//    }

    public Optional<Vehicle> findByVehicleNumber(String vehicleNumber) {
        return Optional.of(vehicleMap.get(vehicleNumber));
    }
}
