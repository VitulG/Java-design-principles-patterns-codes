package CaseStudies.DesignParkingLot.models;

import CaseStudies.DesignParkingLot.PaymentStatus;
import CaseStudies.DesignParkingLot.enums.PaymentMode;

import java.time.LocalDateTime;

public class Payment {
    private Long paymentId;
    private double amount;
    private PaymentMode mode;
    private LocalDateTime createdAt;
    private PaymentStatus paymentStatus;
    private Long referenceNumber;
}
