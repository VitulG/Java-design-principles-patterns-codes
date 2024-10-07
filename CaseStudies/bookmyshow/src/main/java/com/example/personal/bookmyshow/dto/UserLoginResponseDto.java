package com.example.personal.bookmyshow.dto;

import com.example.personal.bookmyshow.enums.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginResponseDto {
    private String username;
    private ResponseStatus status;
}
