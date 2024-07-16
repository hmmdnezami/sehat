package com.life.support.sehat.service;

import com.life.support.sehat.models.Booking;
import com.life.support.sehat.models.Location;

public interface FareService {
    void calculateFare(Location pickup, long targetHospital);
    void makePayment(Booking booking);
    void cancelPayment(Booking booking);
}
