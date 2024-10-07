package com.example.personal.bookmyshow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignUpRequestDto {
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
}
