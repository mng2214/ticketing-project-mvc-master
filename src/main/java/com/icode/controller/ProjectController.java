package com.icode.controller;

import com.icode.dto.ProjectDTO;
import com.icode.service.ProjectService;
import com.icode.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;
    private final UserService userService;

    public ProjectController(ProjectService projectService, UserService userService) {
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createProject(Model model) {

        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("projects", projectService.listAllProjects());
        model.addAttribute("managers", userService.listAllByRole("manager"));

        return "/project/create";

    }

    @PostMapping("/create")
    public String insertProject(@Valid @ModelAttribute("project") ProjectDTO project, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("projects", projectService.listAllProjects());
            model.addAttribute("managers", userService.listAllByRole("manager"));

            return "/project/create";

        }

        projectService.save(project);
        return "redirect:/project/create";
    }


    @GetMapping("/delete/{projectcode}")
    public String deleteProject(@PathVariable("projectcode") String projectCode) {
        projectService.delete(projectCode);
        return "redirect:/project/create";
    }

    @GetMapping("/complete/{projectcode}")
    public String completeProject(@PathVariable("projectcode") String projectCode) {
        projectService.complete(projectCode);
        return "redirect:/project/create";
    }
//
//
//
//    @GetMapping("/update/{projectcode}")
//    public String editProject(@PathVariable("projectcode") String projectcode, Model model) {
//
//        model.addAttribute("project", projectService.getByProjectCode(projectcode));
//        model.addAttribute("projects", projectService.listAllProjects());
//        model.addAttribute("managers", userService.listAllByRole("manager"));
//
//        return "/project/update";
//
//    }
//
//    @PostMapping("/update")
//    public String updateProject(@Valid @ModelAttribute("project") ProjectDTO project, BindingResult bindingResult, Model model) {
//
//        if (bindingResult.hasErrors()) {
//
//            model.addAttribute("projects", projectService.listAllProjects());
//            model.addAttribute("managers", userService.listAllByRole("manager"));
//
//            return "/project/update";
//
//        }
//
//        projectService.update(project);
//        return "redirect:/project/create";
//
//    }
//
//    @GetMapping("/manager/project-status")
//    public String getProjectByManager(Model model) {
//
//        UserDTO manager = userService.findById("john@cydeo.com");
//
//        List<ProjectDTO> projects = projectService.getCountedListOfProjectDTO(manager);
//
//        model.addAttribute("projects", projects);
//
//        return "/manager/project-status";
//    }
//
//    @GetMapping("/manager/complete/{projectCode}")
//    public String managerCompleteProject(@PathVariable("projectCode") String projectCode) {
//        projectService.complete(projectService.findById(projectCode));
//        return "redirect:/project/manager/project-status";
//    }
}
