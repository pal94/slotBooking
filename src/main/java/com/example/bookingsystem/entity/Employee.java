package com.example.bookingsystem.entity;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer ID;
	
	private String emp_first_name;

	private String emp_last_name;
	
	@Column(name="phone_number")
	@Pattern(regexp = "^[0-9]{10}$", message = "Please enter valid mobile number")
	private String employeePhoneNum;
	
	@Column(name="is_active")
	private String isActive;
	
	private String email;
	
	@Column(name="start_time")
	private Integer startTime;
	@Column(name="end_time")
	private Integer endTime;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	List<Appointment> employeesAppointments = new ArrayList<>();

	public Integer getID() {
		return ID;
	}

	public String getEmp_first_name() {
		return emp_first_name;
	}

	public void setEmp_first_name(String emp_first_name) {
		this.emp_first_name = emp_first_name;
	}

	public String getEmp_last_name() {
		return emp_last_name;
	}

	public void setEmp_last_name(String emp_last_name) {
		this.emp_last_name = emp_last_name;
	}

	public void setID(Integer iD) {
		ID = iD;
	}


	public String getEmployeePhoneNum() {
		return employeePhoneNum;
	}

	public void setEmployeePhoneNum(String employeePhoneNum) {
		this.employeePhoneNum = employeePhoneNum;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStartTime() {
		return startTime;
	}

	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}

	public Integer getEndTime() {
		return endTime;
	}

	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}
	

	public List<Appointment> getEmployeesAppointments() {
		return employeesAppointments;
	}

	public void setEmployeesAppointments(List<Appointment> employeesAppointments) {
		this.employeesAppointments = employeesAppointments;
	}
	
	
	
	
	
	
}
