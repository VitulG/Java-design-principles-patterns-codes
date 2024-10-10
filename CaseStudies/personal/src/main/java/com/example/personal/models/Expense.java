package com.example.personal.models;

import com.example.personal.enums.ExpenseType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "expenses")
public class Expense extends BaseModel {
    private String description;
    private double amount;

    @Enumerated(EnumType.STRING)
    private ExpenseType type;

    @ManyToOne
    private Group group;

    @OneToMany(mappedBy = "user_expense")
    private List<UserExpense> userExpenses;
}
