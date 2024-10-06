package com.example.personal.bookmyshow.dto;

import com.example.personal.bookmyshow.models.ShowSeat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookingRequestDto {
    private Long userId;
    private Long showId; // can be skipped as we have show seats
    private List<Long> showSeatIds;
}
