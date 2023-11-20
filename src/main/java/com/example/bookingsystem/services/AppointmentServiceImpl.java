package com.example.bookingsystem.services;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookingsystem.dto.AppointmentDTO;
import com.example.bookingsystem.entity.Appointment;
import com.example.bookingsystem.entity.EmailBody;
import com.example.bookingsystem.entity.Employee;
import com.example.bookingsystem.entity.User;
import com.example.bookingsystem.repos.AppointmentRepository;
import com.example.bookingsystem.repos.EmployeeRepository;
import com.example.bookingsystem.repos.UserRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService, Runnable{
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AppointmentRepository appointmentRepository;
	
	@Autowired
	EmailBody email;
	
	@Autowired
	EmailSenderService emailSenderService;
	
	@Autowired
	Appointment saveAppointment;
	
	
	public AppointmentServiceImpl(Appointment saveAppointment, EmailSenderService emailSenderService, EmailBody emailBody) {
		this.saveAppointment=saveAppointment;
		this.emailSenderService = emailSenderService;
		this.email= emailBody;
	}
	

	@Override
	public Appointment bookAppointment(AppointmentDTO appointmentDTO) throws IOException {
		// TODO Auto-generated method stub
		Integer employeeID = appointmentDTO.getEmployeeId();
		Employee employee = employeeRepository.findById(employeeID).get();
		UserServiceImpl.getAppointmentDates(employee.getStartTime(), employee.getEndTime());
		List<Appointment> appointmentList = employee.getEmployeesAppointments();
		Boolean flag1=false;
		Boolean flag2=false;
		
		for(Appointment eachAppointment : appointmentList) {
			if(eachAppointment.getAppointmentDateTime().isEqual(appointmentDTO.getAppointment())) {
				flag1=true;
			}
		}
		Map<String, LocalDateTime> timings = UserServiceImpl.timings;
		for(String str :timings.keySet()) {
			if(timings.get(str).isEqual(appointmentDTO.getAppointment())) {
				flag2=true;
			}
		}
		Appointment saveAppointment = null;
		User user = new User();
		Appointment appointment = new Appointment();
		User saveUser = null;
		if(!flag1 && flag2) {
			user.setFirstName(appointmentDTO.getUserFirstName());
			user.setLastName(appointmentDTO.getUserLastName());
			user.setUserEmail(appointmentDTO.getUserEmail());
			user.setUserMobile(appointmentDTO.getUserMobile());
			saveUser = userRepository.save(user);
			
			appointment.setAppointmentDateTime(appointmentDTO.getAppointment());
			appointment.setEmployee(employee);
			appointment.setUser(saveUser);
			saveAppointment = appointmentRepository.save(appointment);
			email.setEmailBody("Dear Sir/Maam, \n Your appointmnet is confirmed with "+ appointment.getEmployee().getEmp_first_name()+" "+appointment.getEmployee().getEmp_last_name()+
					"at "+ appointment.getAppointmentDateTime()+ "\n Please make sure to contact over "+ appointment.getEmployee().getEmp_first_name() + " if you have any queries."
							+ "\n"
					+"Thanks and Regards,\n"
							
							+"App");
			email.setEmailSubject("Your Appointment Is Confirmed at: " + appointment.getAppointmentDateTime());
			
			AppointmentServiceImpl appointmentServiceImpl =  new AppointmentServiceImpl(saveAppointment, emailSenderService, email);
			Thread emaiThread = new Thread(appointmentServiceImpl);
			
			emaiThread.start();
			
			employee.getEmployeesAppointments().add(appointment);
			employeeRepository.save(employee);
			
		}
		
		
		return saveAppointment;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			emailSenderService.sendMailToUser(saveAppointment.getUser().getUserEmail(), email);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
