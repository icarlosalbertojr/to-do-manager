package com.icarlosalbertojr.todomanager.mapper;

import com.icarlosalbertojr.todomanager.dto.todo.ToDoRequest;
import com.icarlosalbertojr.todomanager.dto.todo.ToDoResumeResponse;
import com.icarlosalbertojr.todomanager.entity.ToDoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ToDoMapper {

    ToDoMapper INSTANCE = Mappers.getMapper(ToDoMapper.class);

    ToDoEntity toEntity(ToDoRequest request);
    ToDoResumeResponse toDto(ToDoEntity request);


}
