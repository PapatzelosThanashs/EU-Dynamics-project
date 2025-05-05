package com.project.demo.service;

import com.project.demo.model.User;
import com.project.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public void UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public void findAll() {
       
  
    }

    public void findUser() {
       
  
    }

    public void saveUser() {
       
  
    }

     public void deleteUser() {
       
  
    }


}
