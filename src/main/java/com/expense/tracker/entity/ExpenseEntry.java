package com.expense.tracker.entity;


import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "expense_entries")
public class ExpenseEntry {

    @Id
    private ObjectId id;

    @NonNull
    private int amount;

    @NonNull
    private String content;

    private LocalDateTime data;

}
