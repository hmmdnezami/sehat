package com.life.support.sehat.service;

import com.life.support.sehat.dto.Driver;
import com.life.support.sehat.dto.Rider;
import com.life.support.sehat.models.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {
    Rider updateRider(User user, Long id);

    List<User> getAllUsers();

    Optional<User> getUsersById(Long userId);

    List<User> findAllDriverWithoutAmbulance();

    Driver updateDriver(User user, Long driverId);
}
