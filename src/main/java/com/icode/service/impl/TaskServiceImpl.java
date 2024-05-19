package com.icode.service.impl;

import com.icode.dto.TaskDTO;
import com.icode.service.TaskService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Override
    public TaskDTO findById(Long id) {
        return null;
    }

    @Override
    public List<TaskDTO> listAllTasks() {
        return List.of();
    }

    @Override
    public void save(TaskDTO taskDTO) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(TaskDTO taskDTO) {

    }
}
