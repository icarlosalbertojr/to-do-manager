package com.icarlosalbertojr.todomanager.config;

import com.icarlosalbertojr.todomanager.mapper.ToDoMapper;
import com.icarlosalbertojr.todomanager.mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public UserMapper userMapper() {
        return UserMapper.INSTANCE;
    }

    @Bean
    public ToDoMapper toDoMapper() {
        return ToDoMapper.INSTANCE;
    }

}
