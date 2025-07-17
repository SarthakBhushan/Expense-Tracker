package com.expense.tracker.service.impl;


import com.expense.tracker.entity.ExpenseEntry;
import com.expense.tracker.repository.ExpenseRepository;
import com.expense.tracker.service.ExpenseService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public ExpenseEntry addExpense(ExpenseEntry expense){
        expense.setData(LocalDateTime.now());
        return expenseRepository.save(expense);
    }

    @Override
    public List<ExpenseEntry> getAllExpense() {
        return expenseRepository.findAll();
    }

    @Override
    public ExpenseEntry getExpenseById(String id) {
        return expenseRepository.findById(new ObjectId(id))
                .orElseThrow(() -> new RuntimeException("Expense not found"));
    }

    @Override
    public ExpenseEntry updateExpense(String id, ExpenseEntry updatedExpense) {
        ExpenseEntry existing = getExpenseById(id);
        existing.setAmount(updatedExpense.getAmount());
        existing.setContent(updatedExpense.getContent());
        existing.setData(LocalDateTime.now());
        return expenseRepository.save(existing);
    }

    @Override
    public void deleteExpense(String id) {
        expenseRepository.deleteById(new ObjectId(id));
    }

    @Override
    public int getTotalExpense() {
        return expenseRepository.findAll()
                .stream()
                .mapToInt(ExpenseEntry::getAmount)
                .sum();
    }

    @Override
    public List<ExpenseEntry> getExpenseByDate(LocalDate date) {
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.plusDays(1).atStartOfDay();
        return expenseRepository.findByDataBetween(startOfDay, endOfDay);
    }

}
