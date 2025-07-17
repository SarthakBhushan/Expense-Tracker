package com.expense.tracker.service;

import com.expense.tracker.entity.ExpenseEntry;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseService {
    ExpenseEntry addExpense(ExpenseEntry expense);
    List<ExpenseEntry> getAllExpense();
    ExpenseEntry getExpenseById(String id);
    ExpenseEntry updateExpense(String id, ExpenseEntry expense);
    void deleteExpense(String id);
    int getTotalExpense();
    List<ExpenseEntry> getExpenseByDate(LocalDate date);
}
