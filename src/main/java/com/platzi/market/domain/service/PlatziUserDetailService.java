package com.platzi.market.domain.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PlatziUserDetailService implements UserDetailsService {

    @Autowired(required = true)
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.platzi.market.domain.User user = userService.getByUserName(username).get();
        return new User(user.getUserName(),("{noop}" + user.getUserPass()), new ArrayList<>());
    }

}
