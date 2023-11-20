package com.example.bookingsystem.services;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.bookingsystem.entity.Appointment;
import com.example.bookingsystem.entity.Employee;
import com.example.bookingsystem.exception.EmployeeException;
import com.example.bookingsystem.repos.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;


	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> listOfEmployees = employeeRepository.findAll();
		if(!listOfEmployees.isEmpty()) {
			return listOfEmployees;
		}else {
			return null;
		}
	}
	

	@Override
	public List<LocalDateTime> getAvailableTimingsForEmployee(Optional<Employee> employee) throws IOException, EmployeeException {
		// TODO Auto-generated method stub
		Optional<Employee> currentEmployee = employeeRepository.findById(employee.get().getID());
		List<LocalDateTime> availableTime = new ArrayList<>();
		System.out.println(currentEmployee.get().getEmp_first_name());
		if(currentEmployee.isPresent()) {
			UserServiceImpl.getAppointmentDates(currentEmployee.get().getStartTime(), currentEmployee.get().getEndTime());
			Map<String, LocalDateTime> timings = UserServiceImpl.timings;
			
			List<Appointment> listOfAppointments = currentEmployee.get().getEmployeesAppointments();
			
			System.out.println(listOfAppointments.size());
			
			for(String day: timings.keySet()) {
				Boolean flag = false;
				if(listOfAppointments.isEmpty()) {
					availableTime.add(timings.get(day));
				}
				for(Appointment app: listOfAppointments) {
					LocalDateTime localTime = timings.get(day);
					if(localTime.isEqual(app.getAppointmentDateTime())) {
						flag=true;
						break;
					}
				}
				if(flag==false) {
					availableTime.add(timings.get(day));
				}
			}
			if(!availableTime.isEmpty()) {
				return availableTime;
			}else {
				throw new EmployeeException("No Time Avaialble for appointment");
			}
			
		}else {
			throw new EmployeeException("No Doctor Available with this name");
		}
		
	}

	@Override
	public Optional<Employee> getEmployeeById(int Id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(Id);
	}


	@Override
	public Page<Employee> findPaginated(int pageNo, int page) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNo-1, page);
		return this.employeeRepository.findAll(pageable);
	}

	
	
}
