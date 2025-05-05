package com.project.demo.model;

import javax.persistence.Entity;
import java.time.LocalDate;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

     public enum Gender { M, F }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;

    private LocalDate birthdate;

   
    @Enumerated(EnumType.STRING)
    private Gender gender;


    public User() {

    }
 

    
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
}
