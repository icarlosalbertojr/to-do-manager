package com.icarlosalbertojr.todomanager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

import static org.springframework.util.StringUtils.hasText;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class UserEntity {

    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String email;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public boolean isAptToRegister() {
        return hasText(name)
                && hasText(email)
                && hasText(password);
    }

}
