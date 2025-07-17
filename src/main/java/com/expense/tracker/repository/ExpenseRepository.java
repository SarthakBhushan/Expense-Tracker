package com.expense.tracker.repository;

import com.expense.tracker.entity.ExpenseEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ExpenseRepository extends MongoRepository<ExpenseEntry, ObjectId> {
    List<ExpenseEntry> findByDataBetween(LocalDateTime start, LocalDateTime end);
}
