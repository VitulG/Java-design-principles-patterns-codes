package CaseStudies.DesignParkingLot.models;

import CaseStudies.DesignParkingLot.PaymentStatus;
import CaseStudies.DesignParkingLot.enums.PaymentMode;

import java.time.LocalDateTime;

public class Payment extends BaseModel {
    private double amount;
    private LocalDateTime paidAt;
    private PaymentMode mode;
    private PaymentStatus paymentStatus;
    private Long referenceNumber;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(LocalDateTime paidAt) {
        this.paidAt = paidAt;
    }

    public PaymentMode getMode() {
        return mode;
    }

    public void setMode(PaymentMode mode) {
        this.mode = mode;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Long getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(Long referenceNumber) {
        this.referenceNumber = referenceNumber;
    }
}
