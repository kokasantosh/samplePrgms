package com.santosh.microservices.currencyexchangeservice.service;

import com.santosh.microservices.currencyexchangeservice.dbcore.User;
import com.santosh.microservices.currencyexchangeservice.dbcore.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return new User("santosh", "santosh", "santosh", "Bangalore");
    }
}
