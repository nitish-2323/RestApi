package com.ram.RESTapi.Service;

import com.ram.RESTapi.Model.Mydto;
import com.ram.RESTapi.ReopiStry.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
        public class CustomUserDetailservice implements UserDetailsService {

    @Autowired
    private repository repository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        Mydto userDTO = repository.findByUsername(username);

        if (userDTO == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new User(
                userDTO.getUsername(),
                userDTO.getPassword(),
                new ArrayList<>()
        );
    }
}