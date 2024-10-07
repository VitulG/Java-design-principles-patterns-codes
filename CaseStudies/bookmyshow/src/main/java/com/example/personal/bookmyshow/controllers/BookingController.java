package com.example.personal.bookmyshow.controllers;

import com.example.personal.bookmyshow.dto.CreateBookingRequestDto;
import com.example.personal.bookmyshow.dto.CreateBookingResponseDto;
import com.example.personal.bookmyshow.enums.BookingStatus;
import com.example.personal.bookmyshow.models.Booking;
import com.example.personal.bookmyshow.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public CreateBookingResponseDto createBooking(CreateBookingRequestDto requestDto) {
        CreateBookingResponseDto response = new CreateBookingResponseDto();
        try {
            Booking booking = bookingService.createBooking(requestDto.getUserId(), requestDto.getShowSeatIds(), requestDto.getShowId());
            response.setBookingId(booking.getId());
            response.setStatus(BookingStatus.BOOKED);
            return response;
        } catch(Exception ex) {
            response.setStatus(BookingStatus.FAILURE);
            return response;
        }
    }
}
