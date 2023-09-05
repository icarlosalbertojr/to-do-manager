package com.icarlosalbertojr.todomanager.service.impl;

import com.icarlosalbertojr.todomanager.entity.ToDoEntity;
import com.icarlosalbertojr.todomanager.repository.ToDoRepository;
import com.icarlosalbertojr.todomanager.service.ToDoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.icarlosalbertojr.todomanager.helper.StringHelper.updateIfChanged;
import static com.icarlosalbertojr.todomanager.valueobject.ToDoStatus.PENDING;
import static org.springframework.util.StringUtils.hasText;

@Slf4j
@RequiredArgsConstructor
@Service
public class ToDoServiceImpl implements ToDoService {

    private final ToDoRepository toDoRepository;

    @Override
    public void save(ToDoEntity entity) {
        if (!entity.isAptToRegister()) {
            log.info("[ToDoServiceImpl] insert correct information to register your to-do");
            throw new RuntimeException("insert correct information to register your to-do");
        }

        entity.setStatus(PENDING);
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setCreatedAt(LocalDateTime.now());

        toDoRepository.save(entity);
    }

    @Override
    public void update(String id, ToDoEntity entity) {
        var existingToDoOptional = toDoRepository.findById(id);
        if (existingToDoOptional.isEmpty()) {
            log.info("[ToDoServiceImpl] to-do not exists");
            throw new RuntimeException("to-do not exists");
        }
        var existingToDo = existingToDoOptional.get();
        var toDo = ToDoEntity.builder()
                .id(existingToDo.getId())
                .title(updateIfChanged(existingToDo.getTitle(), entity.getTitle()))
                .description(updateIfChanged(existingToDo.getDescription(), entity.getDescription()))
                .status(entity.getStatus())
                .expiration(entity.getExpiration())
                .userId(existingToDo.getUserId())
                .updatedAt(LocalDateTime.now())
                .createdAt(existingToDo.getCreatedAt())
                .build();

        toDoRepository.save(toDo);
    }

    @Override
    public void deleteById(String id) {
        var toDo = toDoRepository.findById(id);
        if (toDo.isEmpty()) {
            log.info("[ToDoServiceImpl] to-do not exists");
            throw new RuntimeException("to-do not exists");
        }
        toDoRepository.deleteById(id);
    }

    @Override
    public List<ToDoEntity> findByUserId(String userId, Pageable pageable) {
        if (!hasText(userId)) {
            throw new RuntimeException("user id is empty");
        }
        return toDoRepository.findByUserId(userId, pageable);
    }
}
