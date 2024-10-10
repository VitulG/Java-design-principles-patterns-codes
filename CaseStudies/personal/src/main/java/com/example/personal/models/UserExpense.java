package com.example.personal.models;

import com.example.personal.enums.ExpenseUserType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "user_expenses")
public class UserExpense extends BaseModel {
    @ManyToOne
    private Expense user_expense;

    @ManyToOne
    private User user;

    private double amount;

    @Enumerated(EnumType.STRING)
    private ExpenseUserType expenseUserType;
}
