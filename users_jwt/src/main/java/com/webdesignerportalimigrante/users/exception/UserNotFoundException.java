package com.webdesignerportalimigrante.users.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("Could not find User with ID: " + id);
    }
}
