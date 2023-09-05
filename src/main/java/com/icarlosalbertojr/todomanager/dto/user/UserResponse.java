package com.icarlosalbertojr.todomanager.dto.user;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UserResponse(String id,
                           String email,
                           String name,
                           LocalDateTime createdAt,
                           LocalDateTime updatedAt) {
}
