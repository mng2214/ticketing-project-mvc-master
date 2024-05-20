package com.icode.service.impl;

import com.icode.dto.TaskDTO;
import com.icode.entity.Project;
import com.icode.entity.Task;
import com.icode.entity.User;
import com.icode.enums.Status;
import com.icode.mapper.TaskMapper;
import com.icode.repository.TaskRepository;
import com.icode.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    TaskRepository taskRepository;
    TaskMapper taskMapper;

    @Override
    public TaskDTO findById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.map(value -> taskMapper.convertToDto(value)).orElse(null);
    }

    @Override
    public List<TaskDTO> listAllTasks() {
        return taskRepository.findAll().stream().map(taskMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public void save(TaskDTO taskDTO) {
        taskDTO.setTaskStatus(Status.OPEN);
        taskDTO.setAssignedDate(LocalDate.now());
        Task task = taskMapper.convertToEntity(taskDTO);
        taskRepository.save(task);
    }

    @Override
    public void delete(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            task.get().setIsDeleted(true);
            taskRepository.save(task.get());
        }
    }

    @Override
    public void update(TaskDTO taskDTO) {

        Optional<Task> task = taskRepository.findById(taskDTO.getId());
        Task updatedTask = taskMapper.convertToEntity(taskDTO);

        if (task.isPresent()) {
            updatedTask.setId(task.get().getId());
            updatedTask.setTaskStatus(taskDTO.getTaskStatus());
            updatedTask.setAssignedDate(taskDTO.getAssignedDate());
            taskRepository.save(updatedTask);
        }
    }


}
