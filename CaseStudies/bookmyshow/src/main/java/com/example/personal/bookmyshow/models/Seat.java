package com.example.personal.bookmyshow.models;

import com.example.personal.bookmyshow.enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {
    private int seatRowNumber;
    private int seatColumnNumber;
    private String number;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;
}
