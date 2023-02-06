package com.springrest.springrest.service;


import java.text.ParseException;
import java.util.List;

import com.springrest.springrest.entities.EmployeeDTO;
import com.springrest.springrest.exception.AgeDoesNotFoundException;
import com.springrest.springrest.pojo.Employee;

public interface EmployeeService {
	
	public List<EmployeeDTO> getEmployees();
	public EmployeeDTO getEmployee(long eId);
	public String addEmployee(Employee employee) throws ParseException, AgeDoesNotFoundException;
	public EmployeeDTO updEmployee(Employee employee);
	public EmployeeDTO findHighestSalary();

	
	

}
