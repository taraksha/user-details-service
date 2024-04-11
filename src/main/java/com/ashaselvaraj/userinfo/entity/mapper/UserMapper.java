package com.ashaselvaraj.userinfo.entity.mapper;

import com.ashaselvaraj.userinfo.dto.UserDTO;
import com.ashaselvaraj.userinfo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper Instance = Mappers.getMapper(UserMapper.class);
   // @Mapping(source = "userId", target = "userId")
    User mapUserDTOToUser(UserDTO userDTO);

    UserDTO mapUserToUserDTO (User user);


}
