package CaseStudies.DesignParkingLot.models;

import CaseStudies.DesignParkingLot.enums.BillStatus;

import java.time.LocalTime;
import java.util.List;

public class Invoice extends BaseModel {
    private LocalTime exitTime;
    private double amount;
    private Gate gate;
    private Ticket ticket;
    private Operator exitOperator;
    private BillStatus billStatus;
    private List<Payment> paymentsWithPartialPayment;

    public LocalTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalTime exitTime) {
        this.exitTime = exitTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Operator getExitOperator() {
        return exitOperator;
    }

    public void setExitOperator(Operator exitOperator) {
        this.exitOperator = exitOperator;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }

    public List<Payment> getPaymentsWithPartialPayment() {
        return paymentsWithPartialPayment;
    }

    public void setPaymentsWithPartialPayment(List<Payment> paymentsWithPartialPayment) {
        this.paymentsWithPartialPayment = paymentsWithPartialPayment;
    }
}
