package com.icode.service.impl;

import com.icode.dto.ProjectDTO;
import com.icode.entity.Project;
import com.icode.entity.User;
import com.icode.enums.Status;
import com.icode.mapper.ProjectMapper;
import com.icode.repository.ProjectRepository;
import com.icode.service.ProjectService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
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
        projectRepository.save(projectToDelete);
    }

    @Override
    public void complete(String projectCode) {
        Project projectToComplete = projectRepository.findByProjectCode(projectCode);
        projectToComplete.setProjectStatus(Status.COMPLETE);
        projectRepository.save(projectToComplete);
    }

}
