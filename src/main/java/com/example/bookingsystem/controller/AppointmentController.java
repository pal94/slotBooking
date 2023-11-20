package com.example.bookingsystem.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.bookingsystem.dto.AppointmentDTO;
import com.example.bookingsystem.entity.Appointment;
import com.example.bookingsystem.services.AppointmentService;

import jakarta.validation.Valid;

@Controller
@CrossOrigin
public class AppointmentController {
	@Autowired
	AppointmentService appointmentService;
	
//	@RequestMapping("/appointmentConfirmation")
//	public String bookAppointment(@ModelAttribute("appointmentObj") Appointment appointment,ModelMap model) throws IOException {
//		System.out.println("confimratin class");
//		Appointment saveAppointment = appointmentService.bookAppointment(appointment);
//		model.addAttribute("msg", "Appointment Booked Succesfully");
//		return "appointmentConfimation";
//		
//	}
}
