package com.life.support.sehat.service.impl;

import com.life.support.sehat.models.Booking;
import com.life.support.sehat.models.Location;
import com.life.support.sehat.service.FareService;
import org.springframework.stereotype.Service;

@Service
public class FareServiceImpl implements FareService {
    /**
     * @param pickup
     * @param targetHospital
     */
    @Override
    public void calculateFare(Location pickup, long targetHospital) {

    }

    /**
     * @param booking
     */
    @Override
    public void makePayment(Booking booking) {

    }

    /**
     * @param booking
     */
    @Override
    public void cancelPayment(Booking booking) {

    }
}
