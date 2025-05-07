package com.project.demo.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    public enum Gender { M, F }

    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "Surname is required")
    @Size(max = 12, message = "Surname must be at most 12 characters")
    private String surname;
    
    @NotNull(message = "Birthdate is required")
    private LocalDate birthdate;
    
    @NotNull(message = "Gender is required")
    private Gender gender;  

    private AddressDTO address;
    

}
