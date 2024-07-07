package com.life.support.sehat.service.impl;

import com.life.support.sehat.models.Booking;
import com.life.support.sehat.repository.BookingRepository;
import com.life.support.sehat.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    private static final Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);
    /**
     * @param userId 
     * @return
     */
    @Override
    public Booking getLatestBookingByUserId(long userId, boolean isPatient) {
        if(isPatient){
            return bookingRepository.findTop1ByUserIdOrderByCreatedAtDesc(userId);
        }
        return bookingRepository.findTop1ByDriverIdOrderByCreatedAtDesc(userId);
    }

    /**
     * @param bookingId 
     * @return
     */
    @Override
    public Booking getBookingByBookingId(long bookingId) {
        return bookingRepository.getReferenceById(bookingId);
    }

    /**
     * @param booking 
     * @return
     */
    @Override
    public Booking makeBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    /**
     * @param booking 
     * @return
     */
    @Override
    public Booking updateBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    /**
     * @param userId 
     * @return
     */
    @Override
    public List<Booking> searchBookingHistoryOfUser(long userId, boolean isPatient) {
        if(isPatient){
            return bookingRepository.findByUserIdOrderByCreatedAtDesc(userId);
        }
        return bookingRepository.findByDriverIdOrderByCreatedAtDesc(userId);
    }
}
