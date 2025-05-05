package com.project.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.project.demo.model.User;
import com.project.demo.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService= userService;
    } 

    /* Get all users */
    @GetMapping
    public String all() {
        return "Get all users";
    }

    /* Create new user */
    @PostMapping
    public User create(@RequestBody User user) {
        return userService.saveUser(user);
    }

    /* Get user with id=?*/
    @GetMapping("/{id}")
    public String get(@PathVariable Long id) {
        return "Get user "+ id;
    }

    /* Delete user with id=?*/
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return "Delete user " + id;
    }

}
