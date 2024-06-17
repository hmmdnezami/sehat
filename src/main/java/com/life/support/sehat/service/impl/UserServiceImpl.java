package com.life.support.sehat.service.impl;

import com.life.support.sehat.dto.Driver;
import com.life.support.sehat.dto.Rider;
import com.life.support.sehat.models.User;
import com.life.support.sehat.repository.UserRepository;
import com.life.support.sehat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public Rider updateRider(User user, Long id) {

        Optional<User> userOptional =  userRepository.findById(id);

        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setAddress(user.getAddress());
            userRepository.save(existingUser);

            return convertUserToRider(existingUser);
        }

        return new Rider();

    }

    public Rider convertUserToRider(User user) {
        Rider rider = new Rider();
        rider.setId(user.getId());
        rider.setEmail(user.getEmail());
        rider.setAddress(user.getAddress());
        rider.setFirstName(user.getFirstName());
        rider.setLastName(user.getLastName());
        return rider;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUsersById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public List<User> findAllDriverWithoutAmbulance() {
//        List<User> allDriverList = driverRepository.findAll();
        List<User> allDriverWithoutAmbulance = new ArrayList<>();
//        for (User user : allDriverList) {
//            if (user.getAmbulance() == null) allDriverWithoutAmbulance.add(user);
//        }
        return allDriverWithoutAmbulance;
    }

    @Override
    public Driver updateDriver(User user, Long driverId) {
        Optional<User> userOptional =  userRepository.findById(driverId);

        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            System.out.println("user is : " + existingUser.toString());
            if (!user.getFirstName().isEmpty())  existingUser.setFirstName(user.getFirstName());
            if (!user.getLastName().isEmpty()) existingUser.setLastName(user.getLastName());
            if (!user.getAddress().isEmpty()) existingUser.setAddress(user.getAddress());
            if (!user.getLicenseNumber().isEmpty())  existingUser.setLicenseNumber(user.getLicenseNumber());
            if (user.getAmbulance() != null)  existingUser.setAmbulance(user.getAmbulance());
//            existingUser.setUsername(existingUser.getUsername());
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
