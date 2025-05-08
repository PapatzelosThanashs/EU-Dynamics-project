package com.project.demo.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;
import com.project.demo.dto.validation.OnCreate;
import com.project.demo.dto.validation.OnPatch;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    public enum Gender { M, F }

    private Long id;

    @NotBlank(message = "name is required", groups = OnCreate.class )
    private String name;

    @NotBlank(message = "Surname is required", groups = OnCreate.class)
    @Size(max = 12, message = "Surname must be at most 12 characters", groups = OnCreate.class)
    private String surname;
    
    @NotNull(message = "Birthdate is required", groups = OnCreate.class)
    private LocalDate birthdate;
    
    @NotNull(message = "Gender is required", groups = OnCreate.class)
    private Gender gender;  

    private AddressDTO address;
    

}
