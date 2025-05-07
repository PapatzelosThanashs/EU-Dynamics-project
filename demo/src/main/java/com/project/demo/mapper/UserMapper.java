package com.project.demo.mapper;

import com.project.demo.model.User;
import com.project.demo.dto.UserDTO;
import com.project.demo.model.Address;
import com.project.demo.dto.AddressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {


    User userDTOToUser(UserDTO dto);


    UserDTO userToUserDTO(User user);



    Address addressDTOToAddress(AddressDTO dto);



    AddressDTO addressToAddressDTO(Address address);

}
