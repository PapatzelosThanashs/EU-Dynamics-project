package com.project.demo.service;

import com.project.demo.model.User;
import com.project.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.dao.DataAccessException;
import com.project.demo.exception.UserNotFoundException;


/**possible DB exception should be auto-thrown from spring */

@Service
public class UserService {

    private UserRepository userRepository;

    
    public  UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public List<User> findAll() {
            return userRepository.findAll();
    }

    public User findUser(Long id) {

            return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
  
    }

    public User saveUser(User user) {
            return userRepository.save(user);
  
    }

    public void deleteUser(Long id) {

        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }

            userRepository.deleteById(id);
 
  
    }


}
