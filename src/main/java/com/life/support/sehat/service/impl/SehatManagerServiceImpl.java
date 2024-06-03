package com.life.support.sehat.service.impl;

import com.life.support.sehat.models.Ambulance;
import com.life.support.sehat.models.Booking;
import com.life.support.sehat.models.HealthcareFacility;
import com.life.support.sehat.models.User;
import com.life.support.sehat.repository.AmbulanceRepository;
import com.life.support.sehat.repository.BookingRepository;
import com.life.support.sehat.repository.HospitalRepository;
import com.life.support.sehat.repository.UserRepository;
import com.life.support.sehat.service.SehatManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SehatManagerServiceImpl implements SehatManagerService {

    @Autowired
    public HospitalRepository hospitalRepository;

    @Autowired
    public AmbulanceRepository ambulanceRepository;

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public BookingRepository bookingRepository;

//    @Autowired
//    public Booking booking;

    @Override
    public List<HealthcareFacility> getAllHospitals(String cityName) {
        return hospitalRepository.findHospitalsByCity(cityName);
    }

    @Override
    public List<Ambulance> getAllAmbulaceNearToUser(String cityName) {
        List<Ambulance> ambulanceList = ambulanceRepository.findAmbulanceByCity(cityName);

//         todo - write a function so ambulance can be sort (according to user location)

        return ambulanceList;

    }

    @Override
    public Booking bookingForUser(HealthcareFacility healthcareFacility, Ambulance ambulance, Long userId) {
        Optional<User> user = userRepository.findById(userId);
        Booking booking = new Booking();
        booking.setUserName(user.get().getName());
        booking.setEmail(user.get().getEmail());
        booking.setHealthcareFacility(healthcareFacility);
        booking.getAmbulanceNumber(ambulance.getVehicle().getNumber());
        booking.setDriverName("Default_Name");
        return bookingRepository.save(booking);
    }


}
