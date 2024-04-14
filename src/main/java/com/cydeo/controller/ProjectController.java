package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.ProjectService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {
    ProjectService projectService;
    UserService userService;

    public ProjectController(ProjectService projectService, UserService userService) {
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createProject(Model model) {
        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("managers", userService.findManagers());
        return "/project/create";
    }

    @PostMapping("/create")
    public String saveProject(@ModelAttribute("project") ProjectDTO projectDTO) {
        projectService.save(projectDTO);
        return "redirect:/project/create";
    }

    @GetMapping("/delete/{projectCode}")
    public String deleteProject(@PathVariable("projectCode") String projectCode) {
        projectService.deleteById(projectCode);
        return "redirect:/project/create";
    }

    @GetMapping("/complete/{projectCode}")
    public String completeProject(@PathVariable("projectCode") String projectCode) {
        projectService.complete(projectService.findById(projectCode));
        return "redirect:/project/create";
    }

    @GetMapping("/update/{projectCode}")
    public String updateProject(@PathVariable("projectCode") String projectCode, Model model) {
        model.addAttribute("project", projectService.findById(projectCode));
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("managers", userService.findManagers());
        return "/project/update";
    }

    @PostMapping("/update")
    public String updateProject(ProjectDTO project) {
        projectService.update(project);
        return "redirect:/project/create";
    }

    @GetMapping("/update")
    public String projectStatusUpdate(Model model){
        return "/task/status-update";
    }

    @GetMapping("/manager/project-status")
    public String getProjectByManager(Model model){
        UserDTO manager = userService.findById("artur@gmail.com"); // Will be replaced when ORM added
        List<ProjectDTO> projects = projectService.getCountedListOfProjectDTO(manager);
        model.addAttribute("projects",projects);
        return "/manager/project-status";
    }

    @GetMapping("/manager/complete/{projectCode}")
    public String managerCompleteProject(@PathVariable("projectCode") String projectCode) {
        projectService.complete(projectService.findById(projectCode));
        return "redirect:/project/manager/project-status";
    }

}
