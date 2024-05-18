package com.icode.mapper;

import com.icode.dto.ProjectDTO;
import com.icode.dto.RoleDTO;
import com.icode.entity.Project;
import com.icode.entity.Role;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    private final ModelMapper modelMapper;

    public ProjectMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    // convert to entity
    public Project convertToEntity(RoleDTO roleDto) {
        return modelMapper.map(roleDto, Project.class);
    }

    // convert to dto
    public ProjectDTO convertToDto(Role roleEntity) {
        return modelMapper.map(roleEntity, ProjectDTO.class);
    }

}
