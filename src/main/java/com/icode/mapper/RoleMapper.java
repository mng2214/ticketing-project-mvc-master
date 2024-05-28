package com.icode.mapper;

import com.icode.dto.RoleDTO;
import com.icode.entity.Role;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    private final ModelMapper modelMapper;

    public RoleMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    // convert to entity
    public Role convertToEntity(RoleDTO roleDto) {
        return modelMapper.map(roleDto, Role.class);
    }

    // convert to dto
    public RoleDTO convertToDto(Role roleEntity) {
        return modelMapper.map(roleEntity , RoleDTO.class);
    }

}
