package com.spring.security.jwt.service;

import com.spring.security.jwt.repository.UserRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {
    @Autowired
    private UserRepositry userRepositry;
    @Override
    public UserDetails loadUserByUsername(String username) throws
            UsernameNotFoundException {
        return userRepositry.findByLogin(username);
    }
}
