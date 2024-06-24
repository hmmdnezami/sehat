package com.life.support.sehat.controller;

import com.life.support.sehat.dto.Driver;
import com.life.support.sehat.dto.Rider;
import com.life.support.sehat.models.User;
import com.life.support.sehat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v2")
public class UserController {

    @Autowired
    public UserService userService;

    @PutMapping("/rider/{riderId}")
    public Rider updateRiderUser(@RequestBody User user, Long riderId) {
        return userService.updateRider(user, riderId);
    }


    @PutMapping("/driver/{driverId}")
    public Driver updateDriverUser(@RequestBody User user, @PathVariable  Long driverId) {
        return userService.updateDriver(user, driverId);
    }

    @GetMapping("/users")
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{userId}")
    public Optional<User> getUserById (@PathVariable Long userId) {
        return userService.getUsersById(userId);
    }
    



}
