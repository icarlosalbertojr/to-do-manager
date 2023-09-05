package com.icarlosalbertojr.todomanager.mapper;

import com.icarlosalbertojr.todomanager.dto.user.UserRequest;
import com.icarlosalbertojr.todomanager.dto.user.UserResponse;
import com.icarlosalbertojr.todomanager.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntity toEntity(UserRequest request);
    UserResponse toDto(UserEntity entity);


}
