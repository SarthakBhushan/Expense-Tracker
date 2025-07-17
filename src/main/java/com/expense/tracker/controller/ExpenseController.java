package com.expense.tracker.controller;

import com.expense.tracker.entity.ExpenseEntry;
import com.expense.tracker.service.impl.ExpenseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

    @Autowired
    private ExpenseServiceImpl expenseService;


    //add all expense
    @PostMapping
    public ResponseEntity<ExpenseEntry> addExpense(@RequestBody ExpenseEntry expense){
        return ResponseEntity.ok(expenseService.addExpense(expense));
    }


    //get all expense
    @GetMapping
    public ResponseEntity<List<ExpenseEntry>> getAllExpense(){
        return ResponseEntity.ok(expenseService.getAllExpense());
    }


    //get expense by id
    @GetMapping("/{id}")
    public ResponseEntity<ExpenseEntry> getExpenseById(@PathVariable String id){
        return ResponseEntity.ok(expenseService.getExpenseById(id));
    }


    //update expense
    @PutMapping("/{id}")
    public ResponseEntity<ExpenseEntry> updateExpense(@PathVariable String id, @RequestBody ExpenseEntry expense){
        return ResponseEntity.ok(expenseService.updateExpense(id, expense));
    }


    //delete expense
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable String id){
        expenseService.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }

    //get total expense
    @GetMapping("/total")
    public ResponseEntity<Integer> getTotalExpense(){
        return ResponseEntity.ok(expenseService.getTotalExpense());
    }


    //get expense by date
    @GetMapping("/by-date")
    public ResponseEntity<List<ExpenseEntry>> getExpensesByDate(@RequestParam("date") String dateStr) {
        LocalDate date = LocalDate.parse(dateStr); // Format: YYYY-MM-DD
        return ResponseEntity.ok(expenseService.getExpenseByDate(date));
    }
}
