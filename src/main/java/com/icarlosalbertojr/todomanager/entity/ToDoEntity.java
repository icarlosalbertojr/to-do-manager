package com.icarlosalbertojr.todomanager.entity;

import com.icarlosalbertojr.todomanager.valueobject.ToDoStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.springframework.util.StringUtils.hasText;

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
    private ToDoStatus status;
    private LocalDate expiration;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public boolean isAptToRegister() {
        var expirationDateIsValid = expiration.isEqual(LocalDate.now()) || expiration.isAfter(LocalDate.now());
        if (!expirationDateIsValid) {
            throw new RuntimeException("Expiration date is invalid");
        }
        return hasText(title)
                && hasText(description)
                && hasText(userId);
    }

}
