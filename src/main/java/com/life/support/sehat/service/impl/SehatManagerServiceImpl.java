package com.life.support.sehat.service.impl;

import com.life.support.sehat.dto.Driver;
import com.life.support.sehat.models.*;
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

    public List<Ambulance> getAmbulaceNearToUserLoc(DetailedLocation location) {
        if(location.getCity()==null || location.getCity().isEmpty()){
            throw new IllegalArgumentException("city is not provided for booking");
        }
//        List<Ambulance> ambulances = ambulanceRepository.findAmbulanceNearUser(location.getCity());
        List<Ambulance> ambulances = ambulanceRepository.findAmbulanceByCity(location.getCity());
        List<Ambulance> assignedAmbulances = null;
//         TODO - write a function so ambulance can be sort (according to user location)
        return assignedAmbulances;

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

    /**
     * @param booking 
     * @return
     */
    @Override
    public HealthcareFacility getOptimalHospitalForBooking(Booking booking) {
        return null;
    }

    /**
     * @param city 
     * @return
     */
    @Override
    public List<HealthcareFacility> rankHospitalsBasedOnReviews(String city) {
        return List.of();
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
