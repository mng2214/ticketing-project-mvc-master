package com.cydeo.controller;

import com.cydeo.service.ProjectService;
import com.cydeo.service.RoleService;
import com.cydeo.service.TaskService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/status")
public class ProjectStatusController {
    ProjectService projectService;
    RoleService roleService;
    TaskService taskService;
    UserService userService;

    public ProjectStatusController(ProjectService projectService, RoleService roleService, TaskService taskService, UserService userService) {
        this.projectService = projectService;
        this.roleService = roleService;
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping("/update")
    public String projectStatusUpdate(Model model){

        return "/task/status-update";
    }
}
