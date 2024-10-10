package com.example.personal.exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(Long userId) {
        super("User with ID " + userId + " not found.");
    }
}
