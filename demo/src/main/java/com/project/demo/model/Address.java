package com.project.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import com.project.demo.model.User;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;



@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String work_address;

    private String home_address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // Foreign key to User


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
        return work_address;
    }
    public void setWorkAddress(String work_address) {
        this.work_address = work_address; 
    }

     public String getHomeAddress() {
        return home_address;
    }
    public void setHomeAddress(String home_address) {
        this.home_address = home_address; 
    }


    public User getUser() {
        return user; 
    }  
    public void setUser(User user) {
        this.user = user;
    }  

   
}
