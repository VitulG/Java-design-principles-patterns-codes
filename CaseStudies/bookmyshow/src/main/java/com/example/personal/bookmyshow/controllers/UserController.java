package com.example.personal.bookmyshow.controllers;

import com.example.personal.bookmyshow.dto.UserLoginRequestDto;
import com.example.personal.bookmyshow.dto.UserLoginResponseDto;
import com.example.personal.bookmyshow.dto.UserSignUpRequestDto;
import com.example.personal.bookmyshow.dto.UserSignUpResponseDto;
import com.example.personal.bookmyshow.enums.ResponseStatus;
import com.example.personal.bookmyshow.models.User;
import com.example.personal.bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public UserSignUpResponseDto signUp(UserSignUpRequestDto request) {
        UserSignUpResponseDto response = new UserSignUpResponseDto();
        try {
            User user = userService.signUp(request.getUsername(), request.getEmail(), request.getPassword());
            response.setUserId(user.getId());
            response.setStatus(ResponseStatus.SUCCESS);
            return response;
        } catch (Exception ex) {
            response.setStatus(ResponseStatus.ERROR);
            return response;
        }
    }

    public UserLoginResponseDto login(UserLoginRequestDto request) {
        UserLoginResponseDto response = new UserLoginResponseDto();
        try {
            User user = userService.login(request.getUsername(), request.getEmail(), request.getPassword());
            response.setUsername(user.getUsername());
            response.setStatus(ResponseStatus.SUCCESS);
            return response;
        }catch (Exception ex) {
            response.setStatus(ResponseStatus.ERROR);
            return response;
        }
    }
}