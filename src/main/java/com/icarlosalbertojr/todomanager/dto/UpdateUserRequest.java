package com.icarlosalbertojr.todomanager.dto;

import lombok.Builder;

@Builder
public record UpdateUserRequest(String id, String name, String email, String password) {
}
