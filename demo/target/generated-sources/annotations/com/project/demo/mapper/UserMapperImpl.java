package com.project.demo.mapper;

import com.project.demo.dto.AddressDTO;
import com.project.demo.dto.UserDTO;
import com.project.demo.model.Address;
import com.project.demo.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-06T20:21:50+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 24.0.1 (Oracle Corporation)"
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
        user.setGender( genderToGender( dto.getGender() ) );
        user.setBirthdate( dto.getBirthdate() );
        user.setAddresses( addressDTOsToAddresses( dto.getAddresses() ) );

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
        userDTO.setAddresses( addressesToAddressDTOs( user.getAddresses() ) );

        return userDTO;
    }

    @Override
    public Address addressDTOToAddress(AddressDTO addressDTO) {
        if ( addressDTO == null ) {
            return null;
        }

        Address address = new Address();

        address.setUser( addressDTOToUser( addressDTO ) );
        address.setId( addressDTO.getId() );
        address.setWorkAddress( addressDTO.getWorkAddress() );
        address.setHomeAddress( addressDTO.getHomeAddress() );

        return address;
    }

    @Override
    public AddressDTO addressToAddressDTO(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setUserId( addressUserId( address ) );
        addressDTO.setId( address.getId() );
        addressDTO.setWorkAddress( address.getWorkAddress() );
        addressDTO.setHomeAddress( address.getHomeAddress() );

        return addressDTO;
    }

    @Override
    public List<AddressDTO> addressesToAddressDTOs(List<Address> addresses) {
        if ( addresses == null ) {
            return null;
        }

        List<AddressDTO> list = new ArrayList<AddressDTO>( addresses.size() );
        for ( Address address : addresses ) {
            list.add( addressToAddressDTO( address ) );
        }

        return list;
    }

    @Override
    public List<Address> addressDTOsToAddresses(List<AddressDTO> addressDTOs) {
        if ( addressDTOs == null ) {
            return null;
        }

        List<Address> list = new ArrayList<Address>( addressDTOs.size() );
        for ( AddressDTO addressDTO : addressDTOs ) {
            list.add( addressDTOToAddress( addressDTO ) );
        }

        return list;
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

    protected User addressDTOToUser(AddressDTO addressDTO) {
        if ( addressDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( addressDTO.getUserId() );

        return user;
    }

    private Long addressUserId(Address address) {
        if ( address == null ) {
            return null;
        }
        User user = address.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
