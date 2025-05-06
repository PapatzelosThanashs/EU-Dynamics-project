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


    User userDTOToUser(UserDTO dto);


    UserDTO userToUserDTO(User user);


    @Mapping(source = "userId", target = "user.id")  // Mapping to the userId in AddressDTO
    Address addressDTOToAddress(AddressDTO addressDTO);


    @Mapping(source = "user.id", target = "userId")  // Mapping to the User in Address
    AddressDTO addressToAddressDTO(Address address);

    List<AddressDTO> addressesToAddressDTOs(List<Address> addresses);
    List<Address> addressDTOsToAddresses(List<AddressDTO> addressDTOs);
}
