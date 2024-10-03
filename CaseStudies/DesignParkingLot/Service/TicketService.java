package CaseStudies.DesignParkingLot.Service;

import CaseStudies.DesignParkingLot.Exception.GateNotFoundException;
import CaseStudies.DesignParkingLot.dto.CreateTicketRequestDto;
import CaseStudies.DesignParkingLot.models.Ticket;

public interface TicketService {
    public Ticket issueTicket(CreateTicketRequestDto createTicketRequestDto) throws GateNotFoundException;
}
