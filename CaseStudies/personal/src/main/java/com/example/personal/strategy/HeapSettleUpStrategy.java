package com.example.personal.strategy;

import com.example.personal.models.Expense;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

@Component
public class HeapSettleUpStrategy implements SettleUpStrategy {
    @Override
    public List<Expense> settleUp(List<Expense> expenses) {
        return expenses;
    }
}
