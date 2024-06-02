package com.life.support.sehat.service;

import com.life.support.sehat.models.Ambulance;
import com.life.support.sehat.models.Booking;
import com.life.support.sehat.models.HealthcareFacility;

import java.util.List;

public interface SehatManagerService {

    List<HealthcareFacility> getAllHospitals(String cityName);

    List<Ambulance> getAllAmbulaceNearToUser(String cityName);

    Booking bookingForUser(HealthcareFacility healthcareFacility, Ambulance ambulance, Long userId);
}
