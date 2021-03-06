package com.webdesignerportalimigrante.users.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    UserController controller;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        com.webdesignerportalimigrante.users.domain.User userFound = controller.getByEmail(email);
        if (userFound.getEmail().equals(email)) {
            return new User(email, userFound.getPassword(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
    }
}
