package com.icarlosalbertojr.todomanager.controller;

import com.icarlosalbertojr.todomanager.dto.todo.ToDoRequest;
import com.icarlosalbertojr.todomanager.dto.todo.ToDoResumeResponse;
import com.icarlosalbertojr.todomanager.mapper.ToDoMapper;
import com.icarlosalbertojr.todomanager.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/todo")
public class ToDoController {

    private final ToDoMapper toDoMapper;
    private final ToDoService toDoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void registerNew(@RequestHeader("userId") String userId, @RequestBody ToDoRequest request) {
        var toDo = toDoMapper.toEntity(request);
        toDo.setUserId(userId);
        toDoService.save(toDo);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody ToDoRequest request) {
        var toDo = toDoMapper.toEntity(request);
        toDoService.update(id, toDo);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id){
        toDoService.deleteById(id);
    }

    @GetMapping("/user/{userId}")
    public List<ToDoResumeResponse> findByUserId(@PathVariable String userId,
                                                 @RequestParam(required = false, defaultValue = "0") int page,
                                                 @RequestParam(required = false, defaultValue = "10") int size) {
        return toDoService.findByUserId(userId, PageRequest.of(page, size))
                .stream()
                .map(toDoMapper::toDto)
                .toList();
    }



}
