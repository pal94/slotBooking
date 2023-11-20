package com.example.bookingsystem.services;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookingsystem.entity.Appointment;
import com.example.bookingsystem.entity.Employee;
import com.example.bookingsystem.repos.EmployeeRepository;

@Service
public class UserServiceImpl implements UserService{
	
	 static Map<String, LocalDateTime> timings = new HashMap<>();
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> listEmployess = employeeRepository.findAll();
		return listEmployess;
	}

	@Override
	public List<Appointment> getAllAppoitments(String user_id) {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	
	@Override
	public Appointment bookAppoitment(String user_id, Appointment appointment) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//this mthod gets date time from this moment
	public static  void getAppointmentDates(Integer from, Integer to) throws IOException {
		
		timings.clear();
		
		LocalDateTime currentTime = LocalDateTime.now();
		LocalDateTime tomorrowTime = currentTime.plusDays(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		//get todays time and store in the hashmap
		for(int i=from;i<to;i++) {
			String todaysTimeString = null;
			
			if(i<10) {
				todaysTimeString = currentTime.toLocalDate() + " 0" + i + ":00";
			}else {
				todaysTimeString = currentTime.toLocalDate() + " " + i + ":00";
				
			}
			
			LocalDateTime dateTime = LocalDateTime.parse(todaysTimeString,formatter);
			
			if(currentTime.isBefore(dateTime)) {
				timings.put("today"+i, dateTime);
			}
			
		}
		
		//get tomorrow's time and store in the hashmap
		for(int i=from;i<=to;i++) {
			String tomorrowTimeString = null;
			
			if(i<10) {
				tomorrowTimeString = tomorrowTime.toLocalDate() + " 0" + i + ":00";
			}else {
				tomorrowTimeString = tomorrowTime.toLocalDate() + " " + i + ":00";
				
			}
			
			LocalDateTime dateTime = LocalDateTime.parse(tomorrowTimeString,formatter);
			
			if(currentTime.isBefore(dateTime)) {
				timings.put("tomorrow"+i, dateTime);
			}
			
		}
		
		
	}
	

}
