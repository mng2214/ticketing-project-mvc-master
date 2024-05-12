package com.icode.mapper;

import com.icode.dto.RoleDTO;
import com.icode.dto.UserDTO;
import com.icode.entity.Role;
import com.icode.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    // convert to dto
    public UserDTO toUserDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    // convert to entity
    public User toUser(UserDTO user) {
        return modelMapper.map(user, User.class);
    }
}
