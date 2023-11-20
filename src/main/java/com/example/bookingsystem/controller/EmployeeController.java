package com.example.bookingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.bookingsystem.entity.Employee;
import com.example.bookingsystem.exception.EmployeeException;
import com.example.bookingsystem.services.EmployeeService;

@Controller
@CrossOrigin
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	@GetMapping("employees/all")
	public String getAllEmployees(ModelMap model) throws EmployeeException{
		return findPaginated(1,model);
	}
	
	//paginated employee list display
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable("pageNo") int pageNo, ModelMap model) {
		int pageSize=5;
		Page<Employee> page = employeeService.findPaginated(pageNo, pageSize);
		List<Employee> listEmployees = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("listAll", listEmployees);
		return "index";
	}
}
