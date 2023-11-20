package com.example.bookingsystem.services;

import java.io.IOException;


import com.example.bookingsystem.dto.AppointmentDTO;
import com.example.bookingsystem.entity.Appointment;

public interface AppointmentService {
	
	public Appointment bookAppointment(AppointmentDTO appointmentDTO) throws IOException;

}
