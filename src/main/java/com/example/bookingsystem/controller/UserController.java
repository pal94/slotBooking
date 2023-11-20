package com.example.bookingsystem.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookingsystem.services.AppointmentService;
import com.example.bookingsystem.services.EmployeeService;
import com.example.bookingsystem.services.UserService;

import jakarta.validation.Valid;

import com.example.bookingsystem.dto.AppointmentDTO;
import com.example.bookingsystem.entity.Appointment;
import com.example.bookingsystem.entity.Employee;
import com.example.bookingsystem.exception.AppointmentException;
import com.example.bookingsystem.exception.EmployeeException;
import com.example.bookingsystem.repos.EmployeeRepository;

@Controller
@CrossOrigin
public class UserController {
	
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	AppointmentService appointmentService;
	
	
	
//	@GetMapping("/employee")
//	public List<Employee> getEmployees() {
//		List<Employee> employees = employeeRepository.findAll();
//		for(Employee emp:employees) {
//			String firstName = emp.getEmployeeFirstName();
//			System.out.print(firstName);
//		}
//		return employees;
//	 
//	}
	

	
//	@GetMapping("/availableTime/{id}")
//	public String getEmployeeTimings(@PathVariable("id") int employeeId, ModelMap model) throws IOException, EmployeeException {
//		Optional<Employee> employee = employeeRepository.findById(employeeId);
//		//String employeeName = employee.get().getEmp_first_name() + employee.get().getEmp_last_name();
//		List<LocalDateTime> listOfAppointment = employeeService.getAvailableTimingsForEmployee(employee);
//		model.addAttribute("listAppointment",listOfAppointment);
//		model.addAttribute("employeeDetails", employee);
//		System.out.println(listOfAppointment.size());
//		
//		return "listEmployeeAppointments";
//		
//	}
	
	
	
	@GetMapping("/showEmployeeTime")
	public String getEmployeeAndSelectedTime(@RequestParam("employeeId") int employeeId, ModelMap model) throws IOException, EmployeeException {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		String empId = employee.get().getID().toString();
		System.out.println("Emplyee ID = " + empId);
		AppointmentDTO appointment = new AppointmentDTO();
		if(employee.isPresent()) {
			appointment.setEmployeeId(employeeId);
			List<LocalDateTime> listOfAppointment = employeeService.getAvailableTimingsForEmployee(employee);
			model.addAttribute("listAppointment",listOfAppointment);
			model.addAttribute("employeeDetails", employee.get());
			model.addAttribute("appointmentObj", appointment);
			model.addAttribute("employeeId", empId);
			System.out.println("employeeid" + appointment.toString());
			System.out.println(listOfAppointment.size());
		}
		return "employeeInfo";
		
	} 
	
	@PostMapping("/appointmentConfirmation")
	public String bookAppointment(@Valid @ModelAttribute("appointmentObj") AppointmentDTO appointment,ModelMap model) throws IOException, AppointmentException {
		System.out.println("Confirmation page"+ appointment.getEmployeeId() + appointment.getUserFirstName());
		if(appointment==null) {
			throw new AppointmentException("No appointment selected");
		}
		appointmentService.bookAppointment(appointment);
		model.addAttribute("msg", "Appointment Booked Succesfully and email sent");
		return "appointmentConfirmation";
		
	}
	
//	@PostMapping("/appointmentConfirmation")
//	public Appointment bookAppointment(@RequestBody Appointment appointment,ModelMap model) throws IOException {
//		System.out.println("confimratin class");
//		appointmentService.bookAppointment(appointment);
//		model.addAttribute("msg", "Appointment Booked Succesfully");
//		return appointment;
//		
//	}
	

}
