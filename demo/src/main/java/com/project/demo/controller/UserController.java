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
import java.util.List;
import jakarta.validation.Valid;
import com.project.demo.dto.UserDTO;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.validation.annotation.Validated; // for Validate
import org.springframework.web.bind.annotation.CrossOrigin; //<--- delete this. only for testing vue
import com.project.demo.dto.validation.OnCreate;
import com.project.demo.dto.validation.OnPatch;
import com.project.demo.dto.UserSummaryDTO;



@CrossOrigin(origins = "http://localhost:8080") 

@RestController

@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService= userService;
    } 

    /* Get all users */
    @GetMapping
    public List<UserSummaryDTO> all() {
        return userService.findAll();
    }

    /* Create new user */
    @PostMapping
    public UserDTO create(@RequestBody @Validated(OnCreate.class) UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    /* Get user with id=?*/
    @GetMapping("/{id}")
    public UserDTO get(@PathVariable Long id) {
        return userService.findUser(id);
    }

    /* Delete user with id=?*/
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
         userService.deleteUser(id);
    }

    /* Patch user */
    @PatchMapping("/{id}")
    public UserDTO patch(@PathVariable Long id, @RequestBody @Validated(OnPatch.class) UserDTO userDTO) {
      return  userService.patchUser(id,userDTO);
        
    }

      /* Update user */
    @PutMapping("/{id}")
    public UserDTO put(@PathVariable Long id, @RequestBody @Validated(OnCreate.class) UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }


}
