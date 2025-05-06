package com.project.demo.mapper;

import com.project.demo.model.User;
import com.project.demo.dto.UserDTO;
import com.project.demo.model.Address;
import com.project.demo.dto.AddressDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "workAddress", target = "address.workAddress")
    @Mapping(source = "homeAddress", target = "address.homeAddress")
    User userDTOToUser(UserDTO dto);


    @Mapping(source = "address.workAddress", target = "workAddress")
    @Mapping(source = "address.homeAddress", target = "homeAddress")
    UserDTO userToUserDTO(User user);



    Address addressDTOToAddress(AddressDTO addressDTO);



    AddressDTO addressToAddressDTO(Address address);

}
