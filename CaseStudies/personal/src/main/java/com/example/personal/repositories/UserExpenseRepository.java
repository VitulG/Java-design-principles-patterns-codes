package com.example.personal.repositories;

import com.example.personal.models.Expense;
import com.example.personal.models.User;
import com.example.personal.models.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserExpenseRepository extends JpaRepository<UserExpense, Long> {
    List<UserExpense> findByUser(User user);
}
