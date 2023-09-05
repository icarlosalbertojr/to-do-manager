package com.icarlosalbertojr.todomanager.repository;

import com.icarlosalbertojr.todomanager.entity.ToDoEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ToDoRepository extends MongoRepository<ToDoEntity, String> {

    List<ToDoEntity> findByUserId(String userId, Pageable pageable);

}
