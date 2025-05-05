package com.project.demo.service;

import com.project.demo.model.User;
import com.project.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {

    private UserRepository userRepository;

    
    public  UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public void findAll() {
        
    }

    public void findUser() {
       
  
    }

    public User saveUser(User user) {
       return userRepository.save(user);
  
    }

     public void deleteUser(Long id) {
       userRepository.deleteById(id);
  
    }


}
