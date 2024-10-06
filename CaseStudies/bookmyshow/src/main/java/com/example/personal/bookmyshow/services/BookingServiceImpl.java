package com.example.personal.bookmyshow.services;

import com.example.personal.bookmyshow.exceptions.ShowNotFoundException;
import com.example.personal.bookmyshow.exceptions.ShowSeatNotFoundException;
import com.example.personal.bookmyshow.exceptions.UserNotFoundException;
import com.example.personal.bookmyshow.models.Booking;
import com.example.personal.bookmyshow.models.Show;
import com.example.personal.bookmyshow.models.ShowSeat;
import com.example.personal.bookmyshow.models.User;
import com.example.personal.bookmyshow.repositories.ShowRepository;
import com.example.personal.bookmyshow.repositories.ShowSeatRepository;
import com.example.personal.bookmyshow.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    private final UserRepository userRepository;
    private final ShowRepository showRepository;
    private final ShowSeatRepository showSeatRepository;

    @Autowired
    public BookingServiceImpl(UserRepository userRepository, ShowRepository showRepository, ShowSeatRepository showSeatRepository) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
    }

    @Override
    @Transactional
    public Booking createBooking(Long userId, List<Long> showSeatIds, Long showId) throws UserNotFoundException, ShowNotFoundException, ShowSeatNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("user does not exist"));

        Show show = showRepository.findById(showId)
                .orElseThrow(() -> new ShowNotFoundException("show does not exist"));

        List<ShowSeat> showSeatList = showSeatRepository.findAllById(showSeatIds)
                .orElseThrow(() -> new ShowSeatNotFoundException("show does not exist"));

        return null;
    }
}
