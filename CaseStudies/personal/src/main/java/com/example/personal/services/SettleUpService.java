package com.example.personal.services;

import com.example.personal.exceptions.GroupNotFoundException;
import com.example.personal.exceptions.UserNotFoundException;
import com.example.personal.models.Expense;

import java.util.List;

public interface SettleUpService {
    List<Expense> settleUpUser(Long userId) throws UserNotFoundException;
    List<Expense> settleUpGroup(Long groupId) throws GroupNotFoundException;
}
