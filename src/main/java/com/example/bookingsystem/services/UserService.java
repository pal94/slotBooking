package com.example.bookingsystem.services;

import java.util.List;

import com.example.bookingsystem.entity.Appointment;
import com.example.bookingsystem.entity.Employee;

public interface UserService {
	
	List<Employee> getAllEmployees();
	List<Appointment> getAllAppoitments(String user_id);
	
	Appointment bookAppoitment(String user_id, Appointment appointment);
}
