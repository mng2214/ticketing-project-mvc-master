package com.icode.service;

import com.icode.dto.ProjectDTO;
import com.icode.entity.User;

import java.util.List;

public interface ProjectService {

    ProjectDTO getByProjectCode(String code);

    List<ProjectDTO> listAllProjects();

    void save(ProjectDTO project);

    void update(ProjectDTO project);

    void delete(String projectCode);

    void complete(String projectCode);

    List<ProjectDTO> listAllProjectDetails();

    List<ProjectDTO> readAllByAssignedManager(User user);
}
