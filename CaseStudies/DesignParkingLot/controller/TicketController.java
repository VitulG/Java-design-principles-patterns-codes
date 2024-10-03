package CaseStudies.DesignParkingLot.controller;

import CaseStudies.DesignParkingLot.Exception.GateNotFoundException;
import CaseStudies.DesignParkingLot.Service.TicketService;
import CaseStudies.DesignParkingLot.dto.CreateTicketRequestDto;
import CaseStudies.DesignParkingLot.dto.TicketDto;
import CaseStudies.DesignParkingLot.enums.ResponseStatus;
import CaseStudies.DesignParkingLot.models.Ticket;

public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public TicketDto createTicket(CreateTicketRequestDto createTicketRequestDto) {
        TicketDto ticketDto = new TicketDto();
        try {
            Ticket generatedTicket = ticketService.issueTicket(createTicketRequestDto);
            ticketDto.setTicket(generatedTicket);
            ticketDto.setStatus(ResponseStatus.SUCCESS);
            return ticketDto;
        } catch (GateNotFoundException notFoundException) {
            ticketDto.setStatus(ResponseStatus.ERROR);
        }
        return ticketDto;
    }
}
