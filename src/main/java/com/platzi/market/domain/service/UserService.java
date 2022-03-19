package com.platzi.market.domain.service;

import java.util.Optional;

import com.platzi.market.domain.User;
import com.platzi.market.domain.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUser(int userId) {
        return userRepository.getUser(userId);
    }

    public Optional<User> getByUserName(String userName) {
        return userRepository.getByUserName(userName);
    }
}
