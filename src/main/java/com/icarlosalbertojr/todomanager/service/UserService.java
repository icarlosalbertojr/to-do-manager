package com.icarlosalbertojr.todomanager.service;

import com.icarlosalbertojr.todomanager.entity.UserEntity;

public interface UserService {

    void save(UserEntity entity);

    void update(String userId, UserEntity entity);

    UserEntity findByEmail(String email);
    UserEntity findById(String id);

}
