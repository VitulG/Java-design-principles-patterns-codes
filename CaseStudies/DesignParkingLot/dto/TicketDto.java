package CaseStudies.DesignParkingLot.dto;

import CaseStudies.DesignParkingLot.enums.ResponseStatus;
import CaseStudies.DesignParkingLot.models.Ticket;

public class TicketDto {
    private Ticket ticket;
    private ResponseStatus status;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
}
