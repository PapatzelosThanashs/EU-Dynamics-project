package com.project.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import com.project.demo.model.User;




@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String workAddress;

    private String homeAddress;

 


/**need for JPA and Jackson */
    public Address() {

    }
    
   

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkAddress() {
        return workAddress;
    }
    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress; 
    }

     public String getHomeAddress() {
        return homeAddress;
    }
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress; 
    }



   
}
