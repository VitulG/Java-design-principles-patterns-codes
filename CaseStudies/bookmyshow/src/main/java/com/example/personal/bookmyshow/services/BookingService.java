package com.example.personal.bookmyshow.services;

import com.example.personal.bookmyshow.exceptions.ShowNotFoundException;
import com.example.personal.bookmyshow.exceptions.ShowSeatNotFoundException;
import com.example.personal.bookmyshow.exceptions.ShowSeatProcessingException;
import com.example.personal.bookmyshow.exceptions.UserNotFoundException;
import com.example.personal.bookmyshow.models.Booking;

import java.util.List;

public interface BookingService {
    Booking createBooking(Long userId, List<Long> showSeatIds, Long showId) throws UserNotFoundException, ShowNotFoundException, ShowSeatNotFoundException, ShowSeatProcessingException;
}
