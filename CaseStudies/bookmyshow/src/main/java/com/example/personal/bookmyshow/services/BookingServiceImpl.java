package com.example.personal.bookmyshow.services;

import com.example.personal.bookmyshow.enums.BookingStatus;
import com.example.personal.bookmyshow.enums.ShowSeatStatus;
import com.example.personal.bookmyshow.exceptions.ShowNotFoundException;
import com.example.personal.bookmyshow.exceptions.ShowSeatNotFoundException;
import com.example.personal.bookmyshow.exceptions.ShowSeatProcessingException;
import com.example.personal.bookmyshow.exceptions.UserNotFoundException;
import com.example.personal.bookmyshow.models.*;
import com.example.personal.bookmyshow.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    private final UserRepository userRepository;
    private final ShowRepository showRepository;
    private final ShowSeatRepository showSeatRepository;
    private final ShowSeatTypeRepository showSeatTypeRepository;
    private final BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImpl(UserRepository userRepository, ShowRepository showRepository, ShowSeatRepository showSeatRepository,
                              ShowSeatTypeRepository showSeatTypeRepository, BookingRepository bookingRepository) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.showSeatTypeRepository = showSeatTypeRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    @Transactional
    public Booking createBooking(Long userId, List<Long> showSeatIds, Long showId) throws UserNotFoundException, ShowNotFoundException, ShowSeatNotFoundException, ShowSeatProcessingException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("user does not exist"));

        Show show = showRepository.findById(showId)
                .orElseThrow(() -> new ShowNotFoundException("show does not exist"));

        List<ShowSeat> showSeatList = showSeatRepository.findAllByIdIn(showSeatIds);

        if(showSeatList.isEmpty()) {
            throw new ShowSeatNotFoundException("show seats do not exist");
        }

        for(ShowSeat showSeat : showSeatList) {
            if(showSeat.getShowSeatStatus() != ShowSeatStatus.AVAILABLE) {
                throw new ShowSeatProcessingException("current show "+showSeat.getShow().getId()+" seat: "+showSeat.getSeat()
                        .getSeatType()+" is not available");
            }else{
                showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            }
            showSeatRepository.save(showSeat);
        }

        Booking booking = new Booking();
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setBookingNumber("A189634ee");
        booking.setCreatedAt(LocalDateTime.now());
        booking.setUser(user);
        booking.setShow(show);
        booking.setPaymentWithPartialPayment(new ArrayList<>());
        booking.setShowSeatList(showSeatList);
        booking.setTheatre(show.getTheatre());
        booking.setTotalAmount(getTotalAmount(show, showSeatList));

        return bookingRepository.save(booking);
    }

    private double getTotalAmount(Show show, List<ShowSeat> showSeatList) {
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);

        double totalAmount = 0.0d;

        for(ShowSeat seat : showSeatList) {
            for(ShowSeatType type : showSeatTypes) {
                if(seat.getSeat().getSeatType().equals(type.getType())) {
                    totalAmount += type.getPrice();
                    break;
                }
            }
        }
        return totalAmount;
    }
}
