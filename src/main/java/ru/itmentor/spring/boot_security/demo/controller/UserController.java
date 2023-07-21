package ru.itmentor.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itmentor.spring.boot_security.demo.model.Role;
import ru.itmentor.spring.boot_security.demo.model.User;
import ru.itmentor.spring.boot_security.demo.service.RoleService;

import ru.itmentor.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController( UserService userService) {
        this.userService = userService;
    }
    @GetMapping()
    public String userInfo(Principal principal, Model model) {
        model.addAttribute("user", userService.getByName(principal.getName()));
        return "show2";
    }
//     @GetMapping("/{id}")
//    public String show(@PathVariable("id")Long id, Model model) {
//        model.addAttribute("user", userService.getById(id));
//
//        return "show";
//    }


}
