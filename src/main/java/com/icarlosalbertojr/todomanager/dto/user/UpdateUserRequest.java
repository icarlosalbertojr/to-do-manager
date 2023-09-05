package com.icarlosalbertojr.todomanager.dto.user;

import lombok.Builder;

@Builder
public record UpdateUserRequest(String id, String name, String email, String password) {
}
