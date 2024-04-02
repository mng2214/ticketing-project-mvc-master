package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.Role;
import com.cydeo.service.RoleService;
import com.cydeo.service.impl.RoleServiceImpl;
import com.cydeo.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    RoleServiceImpl roleService;

    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("user", new UserDTO());
       model.addAttribute("roles", roleService.findAll());
        return "user/create";
    }
}
