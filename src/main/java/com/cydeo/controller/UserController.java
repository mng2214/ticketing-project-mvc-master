package com.cydeo.controller;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    RoleService roleService;
    UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("user", new UserDTO());
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());
        return "/user/create";
    }

    @PostMapping("/create")
    public String insertUser(@ModelAttribute("user") UserDTO userDTO) {
        userService.save(userDTO);
        return "redirect:/user/create";
    }

    @GetMapping("/update/{username}")
    public String updateUser(@PathVariable("username") String username, Model model) {

//        UserDTO userUpdate = userService.findById(username);
//        RoleDTO roleUpdate = roleService.findById(userUpdate.getRole().getId());
//        List<UserDTO> allUsersUpdate = userService.findAll();

        model.addAttribute("user", new UserDTO());
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());

        return "user/update";
    }

//    @PostMapping("/update/{username}")
//    public String updateUser1(@PathVariable("username") String username, Model model) {
//
//        return "user/update";
//    }


}
