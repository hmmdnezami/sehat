package com.life.support.sehat.service;

import com.life.support.sehat.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User addUser(User user);

    List<User> getAllUsers();

    Optional<User> getUsersById(Long userId);
}
