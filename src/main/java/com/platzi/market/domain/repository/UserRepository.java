package com.platzi.market.domain.repository;

import java.util.Optional;

import com.platzi.market.domain.User;

public interface UserRepository {
    
    Optional<User> getUser(int userId);
    
    Optional<User> getByUserName(String userName);
}
