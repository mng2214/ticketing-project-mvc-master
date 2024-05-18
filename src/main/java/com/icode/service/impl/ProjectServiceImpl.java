package com.icode.service.impl;

import com.icode.dto.ProjectDTO;
import com.icode.service.ProjectService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Override
    public ProjectDTO getByProjectCode(String code) {
        return null;
    }

    @Override
    public List<ProjectDTO> listAllProjects() {
        return List.of();
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
