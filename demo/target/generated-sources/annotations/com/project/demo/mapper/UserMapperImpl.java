package com.project.demo.mapper;

import com.project.demo.dto.AddressDTO;
import com.project.demo.dto.UserDTO;
import com.project.demo.model.Address;
import com.project.demo.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-07T21:29:55+0300",
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

        user.setId( dto.getId() );
        user.setName( dto.getName() );
        user.setSurname( dto.getSurname() );
        user.setBirthdate( dto.getBirthdate() );
        user.setGender( genderToGender( dto.getGender() ) );
        user.setAddress( addressDTOToAddress( dto.getAddress() ) );

        return user;
    }

    @Override
    public UserDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setName( user.getName() );
        userDTO.setSurname( user.getSurname() );
        userDTO.setBirthdate( user.getBirthdate() );
        userDTO.setGender( genderToGender1( user.getGender() ) );
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

    protected User.Gender genderToGender(UserDTO.Gender gender) {
        if ( gender == null ) {
            return null;
        }

        User.Gender gender1;

        switch ( gender ) {
            case M: gender1 = User.Gender.M;
            break;
            case F: gender1 = User.Gender.F;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + gender );
        }

        return gender1;
    }

    protected UserDTO.Gender genderToGender1(User.Gender gender) {
        if ( gender == null ) {
            return null;
        }

        UserDTO.Gender gender1;

        switch ( gender ) {
            case M: gender1 = UserDTO.Gender.M;
            break;
            case F: gender1 = UserDTO.Gender.F;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + gender );
        }

        return gender1;
    }
}
