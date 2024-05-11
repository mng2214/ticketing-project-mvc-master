package com.icode.controller;

import com.icode.dto.UserDTO;
import com.icode.service.RoleService;
import com.icode.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("roles", roleService.listOfAllRoles());
        model.addAttribute("users", userService.listOfAllUsers());
        return "/user/create";
    }
//
//    @PostMapping("/create")
//    public String insertUser(@ModelAttribute("user") UserDTO userDTO) {
//        userService.save(userDTO);
//        return "redirect:/user/create";
//    }
//
//    @GetMapping("/update/{username}")
//    public String updateUser(@PathVariable("username") String username, Model model) {
//        model.addAttribute("user", userService.findById(username));
//        model.addAttribute("roles", roleService.findAll());
//        model.addAttribute("users", userService.findAll());
//        return "user/update";
//    }
//
//    @PostMapping("/update")
//    public String updatedUser(UserDTO user) {
//        userService.update(user);
//        return "redirect:/user/create";
//    }
//
//    @GetMapping("/delete/{username}")
//    public String deleteUser (@PathVariable("username") String username){
//        userService.deleteById(username);
//        return "redirect:/user/create";
//    }


}
