package com.example.personal.bookmyshow.models;

import com.example.personal.bookmyshow.enums.PaymentGateway;
import com.example.personal.bookmyshow.enums.PaymentMode;
import com.example.personal.bookmyshow.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {
    private String referenceNumber;
    private double amount;

    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;

    @Enumerated(EnumType.STRING)
    private PaymentGateway paymentProvider;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

}
