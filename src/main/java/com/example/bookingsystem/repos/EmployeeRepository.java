package com.example.bookingsystem.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookingsystem.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
}
