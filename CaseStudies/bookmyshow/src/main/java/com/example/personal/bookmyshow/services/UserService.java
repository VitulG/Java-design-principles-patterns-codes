package com.example.personal.bookmyshow.services;

import com.example.personal.bookmyshow.exceptions.UserAlreadyExistException;
import com.example.personal.bookmyshow.exceptions.UserNotFoundException;
import com.example.personal.bookmyshow.models.User;

public interface UserService {
    User signUp(String name, String email, String password) throws UserAlreadyExistException;
    User login(String username, String email, String password) throws UserNotFoundException;
}
