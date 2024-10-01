package CaseStudies.DesignParkingLot.models;

import java.time.LocalTime;
import java.util.List;

public class Invoice {
    private Long invoiceId;
    private LocalTime exitTime;
    private double amount;
    private Gate gate;
    private Ticket ticket;
    private Operator exitOperator;
    private BillStatus billStatus;
    private List<Payment> paymentsWithPartialPayment;
}
