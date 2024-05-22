package com.icode.service;

import com.icode.dto.ProjectDTO;
import com.icode.dto.TaskDTO;
import com.icode.entity.Task;
import com.icode.enums.Status;

import java.util.List;

public interface TaskService {

    TaskDTO findById(Long id);

    List<TaskDTO> listAllTasks();

    void save(TaskDTO taskDTO);

    void delete(Long id);

    void update(TaskDTO taskDTO);

    int totalNonCompletedTask(String projectCode);

    int totalCompletedTask(String projectCode);

//    List<Task> taskBelongsToProject(String projectCode);

    void deleteByProject(ProjectDTO projectDTO);

    void completeByProject(ProjectDTO projectDTO);

    List<TaskDTO> listAllTasksByStatusIsNot(Status status);

    void updateStatus(TaskDTO task);
}
