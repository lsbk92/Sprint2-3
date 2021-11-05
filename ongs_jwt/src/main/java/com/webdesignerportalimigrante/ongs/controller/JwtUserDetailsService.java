package com.webdesignerportalimigrante.ongs.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.webdesignerportalimigrante.ongs.domain.Ongs;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    OngsController controller;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Ongs OngsFound = controller.getByEmail(email);
        if (OngsFound.getEmail().equals(email)) {
            return new User(email, OngsFound.getPassword(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
    }
}