package com.example.personal.services;

import com.example.personal.exceptions.GroupNotFoundException;
import com.example.personal.exceptions.UserNotFoundException;
import com.example.personal.models.Expense;
import com.example.personal.models.Group;
import com.example.personal.models.User;
import com.example.personal.models.UserExpense;
import com.example.personal.repositories.GroupRepository;
import com.example.personal.repositories.UserExpenseRepository;
import com.example.personal.repositories.UserRepository;
import com.example.personal.strategy.HeapSettleUpStrategy;
import com.example.personal.strategy.SettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SettleUpServiceImpl implements  SettleUpService {
    private final UserRepository userRepository;
    private final UserExpenseRepository userExpenseRepository;
    private final SettleUpStrategy heapSettleUpStrategy;
    private final GroupRepository groupRepository;

    @Autowired
    public SettleUpServiceImpl(UserRepository userRepository, UserExpenseRepository userExpenseRepository,
                               SettleUpStrategy heapSettleUpStrategy, GroupRepository groupRepository) {
        this.userRepository = userRepository;
        this.userExpenseRepository = userExpenseRepository;
        this.heapSettleUpStrategy = heapSettleUpStrategy;
        this.groupRepository = groupRepository;
    }

    @Override
    public List<Expense> settleUpUser(Long userId) throws UserNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        List<UserExpense> userExpenses = userExpenseRepository.findByUser(user);

        Set<Expense> expenses = new HashSet<>();

        for(UserExpense userExpense : userExpenses) {
             expenses.add(userExpense.getUser_expense());
        }

        List<Expense> expensesList = expenses.stream().toList();

        return heapSettleUpStrategy.settleUp(expensesList);
    }

    @Override
    public List<Expense> settleUpGroup(Long groupId) throws GroupNotFoundException {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new GroupNotFoundException("group does not exist"));

        List<Expense> expenseList = group.getExpenses();

        Set<Expense> expenseSet = new HashSet<>(expenseList);


        return heapSettleUpStrategy.settleUp(new ArrayList<>(expenseSet));

    }
}
