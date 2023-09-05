package com.icarlosalbertojr.todomanager.dto.todo;

import com.icarlosalbertojr.todomanager.valueobject.ToDoStatus;

import java.time.LocalDate;

public record ToDoResumeResponse(String id, String title, LocalDate expiration, ToDoStatus status) {
}
