package com.icode.service.impl;

import com.icode.dto.ProjectDTO;
import com.icode.dto.UserDTO;
import com.icode.entity.Project;
import com.icode.entity.Task;
import com.icode.entity.User;
import com.icode.enums.Status;
import com.icode.mapper.ProjectMapper;
import com.icode.mapper.UserMapper;
import com.icode.repository.ProjectRepository;
import com.icode.repository.TaskRepository;
import com.icode.service.ProjectService;
import com.icode.service.TaskService;
import com.icode.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    private final UserService userService;
    private final UserMapper userMapper;
    private final TaskService taskService;


    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper, UserService userService, UserMapper userMapper, TaskService taskService) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
        this.userService = userService;
        this.userMapper = userMapper;
        this.taskService = taskService;
    }

    @Override
    public ProjectDTO getByProjectCode(String code) {
        Project byProjectCode = projectRepository.findByProjectCode(code);
        return projectMapper.convertToDto(byProjectCode);
    }

    @Override
    public List<ProjectDTO> listAllProjects() {
        List<Project> allProjects = projectRepository.findAll();
        return allProjects.stream().map(projectMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public void save(ProjectDTO project) {
        project.setProjectStatus(Status.OPEN);
        Project savedProject = projectRepository.save(projectMapper.convertToEntity(project));
        projectRepository.save(savedProject);
    }

    @Override
    public void update(ProjectDTO dto) {
        Project project = projectRepository.findByProjectCode(dto.getProjectCode());
        Project convertedProject = projectMapper.convertToEntity(dto);
        convertedProject.setId(project.getId());
        convertedProject.setProjectStatus(project.getProjectStatus());
        projectRepository.save(convertedProject);
    }

    @Override
    public void delete(String projectCode) {

        Project projectToDelete = projectRepository.findByProjectCode(projectCode);
        projectToDelete.setIsDeleted(true);

        List<Task> tasksBelongsToProject = taskService.taskBelongsToProject(projectCode);
        tasksBelongsToProject.forEach(p->p.setIsDeleted(true));

        projectRepository.save(projectToDelete);
    }

    @Override
    public void complete(String projectCode) {
        Project projectToComplete = projectRepository.findByProjectCode(projectCode);
        projectToComplete.setProjectStatus(Status.COMPLETE);
        projectRepository.save(projectToComplete);
    }

    @Override
    public List<ProjectDTO> listAllProjectDetails() {

        UserDTO currentUserDto = userService.findByUserName("harold@manager.com"); // hardcoded before security is not implemented
        User user = userMapper.convertToEntity(currentUserDto);
        List<Project> list = projectRepository.findAllByAssignedManager(user);

        return list.stream().map(p -> {

           ProjectDTO obj = projectMapper.convertToDto(p);

           obj.setUnfinishedTaskCounts(taskService.totalNonCompletedTask(p.getProjectCode()));
           obj.setCompleteTaskCounts(taskService.totalCompletedTask(p.getProjectCode()));

           return obj;

        }).collect(Collectors.toList());
    }

}
