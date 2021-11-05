package com.webdesignerportalimigrante.companies.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.webdesignerportalimigrante.companies.domain.Companies;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    com.webdesignerportalimigrante.companies.Controller.CompaniesController controller;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Companies companiesFound = controller.getByEmail(email);
        if (companiesFound.getEmail().equals(email)) {
            return new User(email, companiesFound.getPassword(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
    }
}
