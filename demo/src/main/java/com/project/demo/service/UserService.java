package com.project.demo.service;

import com.project.demo.model.User;
import com.project.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.dao.DataAccessException;
import com.project.demo.exception.UserNotFoundException;
import com.project.demo.model.Address;
import com.project.demo.dto.UserDTO;
import com.project.demo.dto.AddressDTO;
import com.project.demo.mapper.UserMapper;
import java.util.stream.Collectors;





/**possible DB exception should be auto-thrown from spring */

@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    
    public  UserService(UserRepository userRepository, UserMapper userMapper){
        this.userRepository=userRepository;
        this.userMapper = userMapper;
    }
    

    public List<UserDTO> findAll() {
            return userRepository.findAll().stream().map(userMapper::userToUserDTO).collect(Collectors.toList());
    }

    public UserDTO findUser(Long id) {

        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));

            return userMapper.userToUserDTO(user);  // Use MapStruct to map User to UserDTO
  
    }

    public UserDTO saveUser(UserDTO userDTO) {

         User user = userMapper.userDTOToUser(userDTO);  // Use MapStruct to map UserDTO to User

        System.out.println(user.getName());
        //if (user.getAddresses() != null) {
           // for (Address address : user.getAddresses()) {
                //address.setUser(user);  // Set the back-reference
             //  }
        //}

 

        User savedUser = userRepository.save(user);
        return userMapper.userToUserDTO(savedUser);  // Use MapStruct to map saved User to UserDTO

  
    }

    public void deleteUser(Long id) {

        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }

            userRepository.deleteById(id);
 
  
    }



}
