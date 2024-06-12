package com.life.support.sehat.service.impl;

import com.life.support.sehat.models.Ambulance;
import com.life.support.sehat.models.Driver;
import com.life.support.sehat.models.User;
import com.life.support.sehat.repository.DriverRepository;
import com.life.support.sehat.repository.RiderRepository;
import com.life.support.sehat.repository.UserRepository;
import com.life.support.sehat.service.UserService;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public DriverRepository driverRepository;

    @Autowired
    public RiderRepository riderRepository;


    @Override
    public User addUser(User user) {
        if (user.isDriver()) driverRepository.save(user);
        else  riderRepository.save(user);
        return userRepository.save(user);
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
        List<User> allDriverList = driverRepository.findAll();
        List<User> allDriverWithoutAmbulance = new ArrayList<>();
        for (User user : allDriverList) {
            if (user.getAmbulance() == null) allDriverWithoutAmbulance.add(user);
        }
        return allDriverWithoutAmbulance;
    }

}
