package com.icode.service;

import com.icode.dto.ProjectDTO;
import java.util.List;

public interface ProjectService {

    ProjectDTO getByProjectCode(String code);

    List<ProjectDTO> listAllProjects();

    void save(ProjectDTO project);

    void update(ProjectDTO project);

    void delete(ProjectDTO project);


}
