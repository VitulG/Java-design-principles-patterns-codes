package CaseStudies.DesignParkingLot.repository;

import CaseStudies.DesignParkingLot.models.Ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TicketRepository {
    private final Map<Long, Ticket> ticketMap;

    public TicketRepository() {
        ticketMap = new HashMap<>();
    }

    public Optional<Ticket> getTicketById(Long ticketId) {
        return Optional.of(ticketMap.get(ticketId));
    }

    public Ticket save(Ticket ticket) {
        ticketMap.put(ticket.getId(), ticket);
        return ticket;
    }
}
