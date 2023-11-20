package com.example.bookingsystem.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookingsystem.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
