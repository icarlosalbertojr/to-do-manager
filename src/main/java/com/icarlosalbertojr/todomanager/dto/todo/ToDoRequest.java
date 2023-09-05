package com.icarlosalbertojr.todomanager.dto.todo;

import com.icarlosalbertojr.todomanager.valueobject.ToDoStatus;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ToDoRequest(String title, String description, LocalDate expiration, ToDoStatus status) {
}
