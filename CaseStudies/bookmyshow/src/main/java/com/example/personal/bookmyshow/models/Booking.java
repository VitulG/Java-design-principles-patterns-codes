package com.example.personal.bookmyshow.models;

import com.example.personal.bookmyshow.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{
    private String bookingNumber;
    @ManyToOne
    private User user;

    @ManyToOne
    private Show show;

    @ManyToOne
    private Theatre theatre;

    @ManyToMany
    private List<ShowSeat> showSeatList;

    private double totalAmount;
    @OneToMany
    private List<Payment> paymentWithPartialPayment;

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
}
