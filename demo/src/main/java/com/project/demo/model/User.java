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
import java.util.List;
import jakarta.persistence.OneToMany;
import jakarta.persistence.FetchType;
import jakarta.persistence.CascadeType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.FetchType;




@Entity
public class User {

    public enum Gender { M, F }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username is required")
    @Size(max = 12, message = "Username must be at most 12 characters")
    private String name;

    @NotBlank(message = "Surname is required")
    @Size(max = 12, message = "Surname must be at most 12 characters")
    private String surname;

    @NotNull(message = "Birthdate is required")
    private LocalDate birthdate;

    
    @NotNull(message = "Gender is required")
    @Enumerated(EnumType.STRING)
    private Gender gender;


/**need for JPA and Jackson */
    public User() {

    }
 
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Address> addresses;
  



    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name; 
    }

    public String getSurname() { 
        return surname;
    }
    public void setSurname(String surname) { 
        this.surname = surname; 
    }

    public Gender getGender() { 
        return gender; 
    }
    public void setGender(Gender gender) { 
        this.gender = gender; 
    }

    public LocalDate getBirthdate() { 
        return birthdate; 
    }
    public void setBirthdate(LocalDate birthdate) { 
        this.birthdate= birthdate; 
    }


   public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
