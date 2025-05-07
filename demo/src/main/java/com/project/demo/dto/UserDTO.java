package com.project.demo.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    public enum Gender { M, F }

    private Long id;
    private String name;
    private String surname;
    private LocalDate birthdate;
    private Gender gender;  
    private AddressDTO address;
    

}
