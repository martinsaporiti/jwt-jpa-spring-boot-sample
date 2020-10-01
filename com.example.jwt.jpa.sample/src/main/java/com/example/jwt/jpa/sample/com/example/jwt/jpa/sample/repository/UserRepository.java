package com.example.jwt.jpa.sample.com.example.jwt.jpa.sample.repository;

import com.example.jwt.jpa.sample.com.example.jwt.jpa.sample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

    User findByUsername(String username);
}
