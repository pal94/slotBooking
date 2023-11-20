package com.example.bookingsystem.services;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.example.bookingsystem.entity.Employee;
import com.example.bookingsystem.exception.EmployeeException;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	
	public List<LocalDateTime> getAvailableTimingsForEmployee(Optional<Employee> employee) throws IOException, EmployeeException;
	
	public Optional<Employee> getEmployeeById(int Id);
	
	public Page<Employee> findPaginated(int pageNo, int page);

	
}
