package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.demo.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

 }