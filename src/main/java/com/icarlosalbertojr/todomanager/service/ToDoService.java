package com.icarlosalbertojr.todomanager.service;

import com.icarlosalbertojr.todomanager.entity.ToDoEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ToDoService {

    void save(ToDoEntity entity);

    void update(String id, ToDoEntity entity);

    void deleteById(String id);

    List<ToDoEntity> findByUserId(String userId, Pageable pageable);


}
