package com.icarlosalbertojr.todomanager.dto.user;

import lombok.Builder;

@Builder
public record UserRequest(String name, String email, String password) {
}
