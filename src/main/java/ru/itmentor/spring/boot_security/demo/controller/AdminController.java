package ru.itmentor.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itmentor.spring.boot_security.demo.model.Role;
import ru.itmentor.spring.boot_security.demo.model.User;
import ru.itmentor.spring.boot_security.demo.service.RoleService;
import ru.itmentor.spring.boot_security.demo.service.UserService;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private RoleService roleDAO;
    private final UserService userService;
    @Autowired
    public AdminController(RoleService roleDAO, UserService userService) {
        this.roleDAO = roleDAO;
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.getAll());
        return "index";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }
    @PostMapping("/new")
    public String create(@ModelAttribute("user") User user) {
        String string = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPass(string);
        List<Role> list = new ArrayList<>();
        list.add(roleDAO.getById(1L));
        user.setRoles(list);
        userService.addUser(user);
        return "redirect:/admin";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.editUser(userService.getById(id)));
        return "edit";
    }

    @PatchMapping("/{id}/edit")
    public String update(@ModelAttribute("user") User user) {
        userService.editUser(user);
        return "redirect:/admin";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
