package com.life.support.sehat.service;

import com.life.support.sehat.models.Booking;

import java.util.List;

public interface BookingService {

    Booking getLatestBookingByUserId(long userId, boolean isPatient);
    Booking getBookingByBookingId(long bookingId);
    Booking makeBooking(Booking booking, String city);
    Booking updateBooking(Booking booking);
    List<Booking> searchBookingHistoryOfUser(long userId, boolean isPatient);
    Booking makeEmergencyBooking(Booking booking);   //the payload will only consist of userId and pick up location
    Boolean cancelBooking(Booking booking);


}
