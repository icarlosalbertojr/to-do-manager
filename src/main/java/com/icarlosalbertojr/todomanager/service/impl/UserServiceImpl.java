package com.icarlosalbertojr.todomanager.service.impl;

import com.icarlosalbertojr.todomanager.entity.UserEntity;
import com.icarlosalbertojr.todomanager.repository.UserRepository;
import com.icarlosalbertojr.todomanager.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.icarlosalbertojr.todomanager.helper.StringHelper.updateIfChanged;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void save(UserEntity entity) {
        if (!entity.isAptToRegister()) {
            log.info("[UserServiceImpl] Insert all information to register - {}", entity);
            throw new RuntimeException("Insert all information to register user");
        }

        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());

        userRepository.save(entity);
        log.info("[UserServiceImpl] user was saved successful");
    }

    @Override
    public void update(String userId, UserEntity entity) {
        var existingUserOptional = userRepository.findById(userId);

        if (existingUserOptional.isEmpty()) {
            log.info("[UserServiceImpl] user not exists");
            throw new RuntimeException("User not exists");
        }

        var existingUser = existingUserOptional.get();
        var user = UserEntity.builder()
                .id(userId)
                .name(updateIfChanged(existingUser.getName(), entity.getName()))
                .email(updateIfChanged(existingUser.getEmail(), entity.getEmail()))
                .password(updateIfChanged(existingUser.getPassword(), entity.getPassword()))
                .updatedAt(LocalDateTime.now())
                .createdAt(existingUser.getCreatedAt())
                .build();

        userRepository.save(user);
        log.info("[UserServiceImpl] user was updated successful");
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("user not exists"));
    }

    @Override
    public UserEntity findById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("user not exists"));
    }
}
