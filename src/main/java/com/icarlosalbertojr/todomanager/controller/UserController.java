package com.icarlosalbertojr.todomanager.controller;

import com.icarlosalbertojr.todomanager.dto.user.UserRequest;
import com.icarlosalbertojr.todomanager.dto.user.UserResponse;
import com.icarlosalbertojr.todomanager.mapper.UserMapper;
import com.icarlosalbertojr.todomanager.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserMapper userMapper;
    private final UserService userService;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void register(@RequestBody UserRequest request) {
        var user = userMapper.toEntity(request);
        userService.save(user);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody UserRequest request) {
        var user = userMapper.toEntity(request);
        userService.update(id, user);
    }

    @GetMapping("/id/{id}")
    public UserResponse findById(@PathVariable String id) {
        var entity = userService.findById(id);
        return userMapper.toDto(entity);
    }

    @GetMapping("/email/{email}")
    public UserResponse findByEmail(@PathVariable String email) {
        var entity = userService.findByEmail(email);
        return userMapper.toDto(entity);
    }

}
