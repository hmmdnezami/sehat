package com.life.support.sehat.service.impl;

import com.life.support.sehat.models.User;
import com.life.support.sehat.repository.UserRepository;
import com.life.support.sehat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;


    @Override
    public User addUser(User user) {
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
}
