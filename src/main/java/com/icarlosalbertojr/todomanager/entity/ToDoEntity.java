package com.icarlosalbertojr.todomanager.entity;

import com.icarlosalbertojr.todomanager.valueobject.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class ToDoEntity {

    @Id
    private String id;
    private String userId;
    private String title;
    private String description;
    private Status status;
    private LocalDate expiration;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
