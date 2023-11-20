package com.example.bookingsystem.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookingsystem.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{
	
}
