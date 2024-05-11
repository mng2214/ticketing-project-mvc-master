//package com.icode.converter;
//
//import com.icode.dto.ProjectDTO;
//import com.icode.service.ProjectService;
//import com.icode.service.TaskService;
//import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.stereotype.Component;
//
//@Component
//@ConfigurationPropertiesBinding
//public class ProjectDtoConverter implements Converter<String, ProjectDTO> {
//    ProjectService projectService;
//
//    public ProjectDtoConverter(ProjectService projectService) {
//        this.projectService = projectService;
//    }
//
//    @Override
//    public ProjectDTO convert(String source) {
//        return projectService.findById(source);
//    }
//}
