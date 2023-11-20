package com.example.bookingsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.validation.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user")
@PrimaryKeyJoinColumn(name="ID")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer ID;
	@NotEmpty(message="Name should not be empty")
	@Column(name="usr_firstName")
	@Size(min=3,max=30, message="size should be between 3 and 30")
	private String firstName;
	
	@Column(name="usr_lastName")
	@NotEmpty(message="Last Name should not be empty")
	@Size(min=3,max=30)
	private String lastName;
	
	@Column(name="usr_phone")
	@NotEmpty(message="Phone should not be empty")
	@Pattern(regexp = "^[0-9]{10}$", message = "Please enter valid mobile number")
	private String userMobile;
	
	@Column(name="usr_email")
	@Email
	@NotEmpty(message="Email should not be empty")
	private String userEmail;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
	
}
