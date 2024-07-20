package com.life.support.sehat.service.impl;

import com.life.support.sehat.models.Ambulance;
import com.life.support.sehat.models.Booking;
import com.life.support.sehat.models.Status;
import com.life.support.sehat.repository.AmbulanceRepository;
import com.life.support.sehat.repository.BookingRepository;
import com.life.support.sehat.service.BookingService;
import com.life.support.sehat.service.FareService;
import com.life.support.sehat.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private SehatManagerServiceImpl sehatManagerService;

    @Autowired
    private FareService fareService;

    @Autowired
    private AmbulanceRepository ambulanceRepository;

    @Autowired
    private NotificationService notificationService;

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
        List<Ambulance> ambulances = sehatManagerService.getAmbulaceNearToUserLoc(booking.getPickup());
        Ambulance ambulance = null;
        for(Ambulance amb : ambulances){
            if(notificationService.pushNotificationToUser(amb.getCurrentDriver())){
                ambulance = amb;
                break;
            }
        }
        if(ambulance==null){
            throw new RuntimeException("No ambulance available");
        }
        booking.setAmbulanceId(ambulance.getAmid());
        booking.setDriverId(ambulance.getCurrentDriver());
        ambulance.setStatus(Status.BOOKED);
        ambulanceRepository.save(ambulance);
        fareService.calculateFare(booking.getPickup(),booking.getTargetHealthcareId());
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

    /**
     * @param booking 
     * @return
     */
    @Override
    public Booking makeEmergencyBooking(Booking booking) {
        return null;
    }

    /**
     * @param booking 
     * @return
     */
    @Override
    public Boolean cancelBooking(Booking booking) {
        return null;
    }
}
