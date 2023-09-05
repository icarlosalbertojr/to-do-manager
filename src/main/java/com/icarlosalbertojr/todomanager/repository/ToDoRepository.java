package com.icarlosalbertojr.todomanager.repository;

import com.icarlosalbertojr.todomanager.entity.ToDoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ToDoRepository extends MongoRepository<ToDoEntity, String> {
}
