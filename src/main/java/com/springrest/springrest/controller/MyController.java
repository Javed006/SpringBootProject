package com.springrest.springrest.controller;

import java.text.ParseException;
import java.util.List;

import com.springrest.springrest.pojo.Employee;
import com.springrest.springrest.exception.AgeDoesNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.springrest.springrest.entities.EmployeeDTO;
import com.springrest.springrest.service.EmployeeService;

@RestController
public class MyController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/emp")
	public List<EmployeeDTO> getEmployees() {
		return this.employeeService.getEmployees();

	}

	@GetMapping("/emp/{empID}")
	public EmployeeDTO getEmployee(long eId) {
		return
				this.employeeService.getEmployee(eId);


	}

	@PostMapping("/createEmployee")
	public String addEmployee(@RequestBody Employee employee) throws ParseException, AgeDoesNotFoundException {
		return
				this.employeeService.addEmployee(employee);
	}

	@PutMapping(value = "/update")
	public EmployeeDTO updateEmployee(@RequestBody Employee employee) {
		return this.employeeService.updEmployee(employee);
	}

	@GetMapping("/findHighestSalary")
	public EmployeeDTO findHighestSalary() {
		return
				this.employeeService.findHighestSalary();

	}

}
