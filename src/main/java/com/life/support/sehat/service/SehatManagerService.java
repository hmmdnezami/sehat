package com.life.support.sehat.service;

import com.life.support.sehat.dto.Driver;
import com.life.support.sehat.models.Ambulance;
import com.life.support.sehat.models.Booking;
import com.life.support.sehat.models.Healthcare;

import java.util.List;

public interface SehatManagerService {

    List<Healthcare> getAllHospitals(String cityName);

    List<Ambulance> getAllAmbulaceNearToUser(String cityName);

    Booking bookingForUser(Healthcare healthcare, Ambulance ambulance, Long userId);

    List<Driver> findAllDriverWithoutAmbulance(String status);

    Driver registedAmbulanceToDriver(Long driverId, Ambulance ambulance);
}
