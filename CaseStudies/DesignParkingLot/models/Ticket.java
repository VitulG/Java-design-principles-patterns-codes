package CaseStudies.DesignParkingLot.models;

import java.time.LocalTime;

public class Ticket {
    private Long ticketId;
    private int ticketNumber;
    private LocalTime entryTime;
    private ParkingSpot spot;
    private Operator operator;
    private Gate gate;
}
