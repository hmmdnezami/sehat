package com.life.support.sehat.controller;

import com.life.support.sehat.models.User;
import com.life.support.sehat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v2")
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
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
