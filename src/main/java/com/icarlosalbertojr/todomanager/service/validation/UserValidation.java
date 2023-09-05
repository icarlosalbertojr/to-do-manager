package com.icarlosalbertojr.todomanager.service.validation;

import com.icarlosalbertojr.todomanager.entity.UserEntity;
import org.springframework.util.StringUtils;

import static org.springframework.util.StringUtils.hasText;

public class UserValidation {

    public static boolean validateToSave(UserEntity entity) {
        return hasText(entity.getEmail()) &&
                hasText(entity.getName()) &&
                hasText(entity.getPassword());
    }

}
