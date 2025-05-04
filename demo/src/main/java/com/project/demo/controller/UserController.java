package com.project.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("api/users")
public class UserController {

    /* Get all users */
    @GetMapping
    public String all() {
        return "Get all users";
    }

    /* Create new user */
    @PostMapping
    public String create() {
        return "Post-create new user";
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
