package com.icode.service.impl;

import com.icode.dto.ProjectDTO;
import com.icode.entity.Project;
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
        return null;
    }

    @Override
    public List<ProjectDTO> listAllProjects() {
        List<Project> allProjects = projectRepository.findAll();
        return allProjects.stream().map(projectMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public void save(ProjectDTO project) {

    }

    @Override
    public void update(ProjectDTO project) {

    }

    @Override
    public void delete(ProjectDTO project) {

    }

}
