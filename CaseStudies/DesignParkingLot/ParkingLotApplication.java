package CaseStudies.DesignParkingLot;

import CaseStudies.DesignParkingLot.Service.TicketService;
import CaseStudies.DesignParkingLot.Service.TicketServiceImpl;
import CaseStudies.DesignParkingLot.controller.TicketController;
import CaseStudies.DesignParkingLot.dto.CreateTicketRequestDto;
import CaseStudies.DesignParkingLot.dto.TicketDto;
import CaseStudies.DesignParkingLot.enums.ParkingSpotStrategyType;
import CaseStudies.DesignParkingLot.enums.VehicleType;
import CaseStudies.DesignParkingLot.factory.SpotAssignmentFactory;
import CaseStudies.DesignParkingLot.repository.GateRepository;
import CaseStudies.DesignParkingLot.repository.VehicleRepository;
import CaseStudies.DesignParkingLot.strategies.NearestSpotAssignmentStrategy;
import CaseStudies.DesignParkingLot.strategies.ParkingSpotAssignmentStrategy;

public class ParkingLotApplication {
    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingSpotAssignmentStrategy strategy = SpotAssignmentFactory.createSpotAssignmentStrategy(ParkingSpotStrategyType.NEAREST);

        TicketService ticketService = new TicketServiceImpl(gateRepository, vehicleRepository, strategy);
        TicketController controller = new TicketController(ticketService);

        CreateTicketRequestDto requestDto = new CreateTicketRequestDto();
        requestDto.setGateId(1L);
        requestDto.setUserName("Vitul Gupta");
        requestDto.setVehicleNumber("ABC123");
        requestDto.setVehicleType(VehicleType.CAR.toString());
        requestDto.setOperatorId(1L);

        TicketDto ticket = controller.createTicket(requestDto);

        System.out.println("Ticket Number: "+ticket.getTicket().getTicketNumber());
        System.out.println("Owner: "+ticket.getTicket().getVehicle().getOwnerName());
        System.out.println("Gate: "+ticket.getTicket().getGate().getGateNumber());
        System.out.println("Operator: "+ticket.getTicket().getOperator().getEmployeeName());

    }
}
