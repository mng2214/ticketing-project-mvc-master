package com.cydeo.converter;

import com.cydeo.dto.TaskDTO;
import com.cydeo.service.TaskService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class TaskDtoConvertor implements Converter<String, TaskDTO> {
    TaskService taskService;

    public TaskDtoConvertor(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public TaskDTO convert(String source) {
        return taskService.findById(Long.parseLong(source));
    }
}
