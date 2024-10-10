package com.example.personal.controllers;

import com.example.personal.dto.SettleUpGroupRequestDto;
import com.example.personal.dto.SettleUpGroupResponseDto;
import com.example.personal.dto.SettleUpRequestDto;
import com.example.personal.dto.SettleUpResponseDto;
import com.example.personal.enums.ResponseStatus;
import com.example.personal.models.Expense;
import com.example.personal.services.SettleUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SettleUpController {
    private final SettleUpService settleUpService;

    @Autowired
    public SettleUpController(SettleUpService settleUpService) {
        this.settleUpService = settleUpService;
    }

    public SettleUpResponseDto settleUp(SettleUpRequestDto requestDto) {
        SettleUpResponseDto responseDto = new SettleUpResponseDto();
        try {
            responseDto.setExpensesTransactions(settleUpService.settleUpUser(requestDto.getPayerId()));
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
            return responseDto;
        } catch (Exception ex) {
            responseDto.setResponseStatus(ResponseStatus.ERROR);
            return responseDto;
        }
    }

    public SettleUpGroupResponseDto settleUpGroup(SettleUpGroupRequestDto requestDto) {
        SettleUpGroupResponseDto responseDto = new SettleUpGroupResponseDto();

        try {
            responseDto.setExpenses(settleUpService.settleUpGroup(requestDto.getGroupId()));
            responseDto.setStatus(ResponseStatus.SUCCESS);
            return responseDto;
        } catch (Exception exception) {
            responseDto.setStatus(ResponseStatus.ERROR);
            return responseDto;
        }
    }
}
