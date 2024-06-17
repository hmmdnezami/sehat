package com.life.support.sehat.service.impl;

import com.life.support.sehat.dto.Driver;
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

import java.util.*;

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
//        booking.setUserName(user.get().getName());
        booking.setEmail(user.get().getEmail());
        booking.setHealthcareFacility(healthcareFacility);
        booking.getAmbulanceNumber(ambulance.getVehicle().getNumber());
        booking.setDriverName("Default_Name");
        return bookingRepository.save(booking);
    }

    @Override
    public List<Driver> findAllDriverWithoutAmbulance(String status) {

        List<User> userList = userRepository.findByUserType("DRIVER");
        List<Driver> driverList = new ArrayList<>();
        for (User user : userList) {
            if (user.getAmbulance() == null) {
                Driver d = convertUserToDriver(user);
                driverList.add(d);
            }
        }
        return driverList;
    }

    @Override
    public Driver registedAmbulanceToDriver(Long driverId, Ambulance ambulance) {

        Optional<User> userOptional =  userRepository.findById(driverId);

        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            System.out.println("user is : " + existingUser.toString());
            existingUser.setAmbulance(ambulance);
            userRepository.save(existingUser);

            return convertUserToDriver(existingUser);
        }
        return new Driver();

    }

    public Driver convertUserToDriver(User user) {
        Driver driver = new Driver();
        driver.setId(user.getId());
        driver.setEmail(user.getEmail());
        driver.setAddress(user.getAddress());
        driver.setFirstName(user.getFirstName());
        driver.setLastName(user.getLastName());
        if (user.getLicenseNumber() != null) driver.setLicenseNumber(user.getLicenseNumber());
        if (user.getAmbulance() != null) driver.setAmbulance(user.getAmbulance());
        return driver;
    }


}
