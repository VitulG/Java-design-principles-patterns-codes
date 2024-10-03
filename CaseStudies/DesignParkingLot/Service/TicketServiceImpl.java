package CaseStudies.DesignParkingLot.Service;

import CaseStudies.DesignParkingLot.Exception.GateNotFoundException;
import CaseStudies.DesignParkingLot.dto.CreateTicketRequestDto;
import CaseStudies.DesignParkingLot.models.Gate;
import CaseStudies.DesignParkingLot.models.Ticket;
import CaseStudies.DesignParkingLot.models.Vehicle;
import CaseStudies.DesignParkingLot.repository.GateRepository;
import CaseStudies.DesignParkingLot.repository.VehicleRepository;
import CaseStudies.DesignParkingLot.strategies.ParkingSpotAssignmentStrategy;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public class TicketServiceImpl implements TicketService {
    private final GateRepository gateRepository;
    private final VehicleRepository vehicleRepository;
    private final ParkingSpotAssignmentStrategy parkingSpotAssignmentStrategy;

    public TicketServiceImpl(GateRepository gateRepository, VehicleRepository vehicleRepository,
                             ParkingSpotAssignmentStrategy parkingSpotAssignmentStrategy) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingSpotAssignmentStrategy = parkingSpotAssignmentStrategy;
    }

    @Override
    public Ticket issueTicket(CreateTicketRequestDto createTicketRequestDto) throws GateNotFoundException {
        Ticket ticket = new Ticket();

        ticket.setTicketNumber(generateTicketNumber());

        Gate gate = gateRepository.getGateById(createTicketRequestDto.getGateId())
                .orElseThrow(() -> new GateNotFoundException("gate does not exist"));
        ticket.setGate(gate);

        ticket.setOperator(gate.getGateOperator());
        Optional<Vehicle> optionalVehicle = vehicleRepository.findByVehicleNumber(createTicketRequestDto.getVehicleNumber());
        Vehicle vehicle = null;
        if(optionalVehicle.isEmpty()) {
            Vehicle newVehicle =  new Vehicle();
            newVehicle.setVehicleNumber(createTicketRequestDto.getVehicleNumber());
            newVehicle.setOwnerName(createTicketRequestDto.getUserName());
            vehicle = vehicleRepository.save(newVehicle);
            ticket.setVehicle(vehicle);
        }else{
            vehicle = optionalVehicle.get();
        }
        ticket.setVehicle(vehicle);
        ticket.setEntryTime(LocalDateTime.now());
        ticket.setCreatedAt(LocalDateTime.now());
        ticket.setId(generateTicketId());
        ticket.setSpot(parkingSpotAssignmentStrategy.assignASpot(gate.getParkingLot(), vehicle));


        return ticket;

    }
    private String generateTicketNumber() {
        // Implementation to generate a unique ticket number
        return UUID.randomUUID().toString();
    }

    private Long generateTicketId() {
        // Implementation to generate a unique ticket id
        return (long) UUID.randomUUID().hashCode();
    }
}
