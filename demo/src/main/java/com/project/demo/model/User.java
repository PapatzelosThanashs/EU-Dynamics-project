package com.project.demo.model;

import jakarta.persistence.Entity;
import java.time.LocalDate;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import com.project.demo.model.Address;
import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import lombok.Data;




@Data
@Entity
public class User {

    public enum Gender { M, F }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    @NotBlank(message = "Surname is required")
    @Size(max = 12, message = "Surname must be at most 12 characters")
    private String surname;

    @NotNull(message = "Birthdate is required")
    private LocalDate birthdate;

    
    @NotNull(message = "Gender is required")
    @Enumerated(EnumType.STRING)
    private Gender gender;


/**need for JPA and Jackson  or @NoArgsContructor <- Lombok*/
    public User() {

    }
 
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id", referencedColumnName = "id", unique = true)
    private Address address;
  


}
