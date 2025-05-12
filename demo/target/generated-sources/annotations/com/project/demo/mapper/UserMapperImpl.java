package com.project.demo.mapper;

import com.project.demo.dto.AddressDTO;
import com.project.demo.dto.UserDTO;
import com.project.demo.dto.UserSummaryDTO;
import com.project.demo.model.Address;
import com.project.demo.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-12T12:55:28+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User userDTOToUser(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setGender( mapDtoGender( dto.getGender() ) );
        user.setId( dto.getId() );
        user.setName( dto.getName() );
        user.setSurname( dto.getSurname() );
        user.setBirthdate( dto.getBirthdate() );
        user.setAddress( addressDTOToAddress( dto.getAddress() ) );

        return user;
    }

    @Override
    public UserDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setGender( mapEntityGender( user.getGender() ) );
        userDTO.setId( user.getId() );
        userDTO.setName( user.getName() );
        userDTO.setSurname( user.getSurname() );
        userDTO.setBirthdate( user.getBirthdate() );
        userDTO.setAddress( addressToAddressDTO( user.getAddress() ) );

        return userDTO;
    }

    @Override
    public Address addressDTOToAddress(AddressDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( dto.getId() );
        address.setWorkAddress( dto.getWorkAddress() );
        address.setHomeAddress( dto.getHomeAddress() );

        return address;
    }

    @Override
    public AddressDTO addressToAddressDTO(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setId( address.getId() );
        addressDTO.setWorkAddress( address.getWorkAddress() );
        addressDTO.setHomeAddress( address.getHomeAddress() );

        return addressDTO;
    }

    @Override
    public UserSummaryDTO userToUserSummaryDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserSummaryDTO userSummaryDTO = new UserSummaryDTO();

        userSummaryDTO.setName( user.getName() );
        userSummaryDTO.setSurname( user.getSurname() );
        userSummaryDTO.setId( user.getId() );

        return userSummaryDTO;
    }
}
