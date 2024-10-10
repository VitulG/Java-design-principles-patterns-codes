package com.example.personal.dto;

import com.example.personal.enums.ResponseStatus;
import com.example.personal.models.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpResponseDto {
    List<Expense> expensesTransactions;
    ResponseStatus responseStatus;
}
