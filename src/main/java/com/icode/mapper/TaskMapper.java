package com.icode.mapper;

import com.icode.dto.RoleDTO;
import com.icode.dto.TaskDTO;
import com.icode.entity.Role;
import com.icode.entity.Task;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    private final ModelMapper modelMapper;

    public TaskMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    // convert to entity
    public Task convertToEntity(TaskDTO taskDto) {
        return modelMapper.map(taskDto, Task.class);
    }

    // convert to dto
    public TaskDTO convertToDto(Task task) {
        return modelMapper.map(task, TaskDTO.class);
    }

}
