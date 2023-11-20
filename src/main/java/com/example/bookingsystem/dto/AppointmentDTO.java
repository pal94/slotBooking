package com.example.bookingsystem.dto;

import java.time.LocalDateTime;

import com.example.bookingsystem.entity.Appointment;
import com.example.bookingsystem.entity.Employee;

import lombok.Data;

@Data
public class AppointmentDTO {
	private int employeeId;
	private LocalDateTime appointment;
	private String userFirstName;
	private String userLastName;
	private String userEmail;
	private String userMobile;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public LocalDateTime getAppointment() {
		return appointment;
	}
	public void setAppointment(LocalDateTime appoitment) {
		this.appointment = appoitment;
	}
	@Override
	public String toString() {
		return "AppointmentDTO [employeeId=" + employeeId + "]";
	}
	
	
	
	
	
	
	

}
