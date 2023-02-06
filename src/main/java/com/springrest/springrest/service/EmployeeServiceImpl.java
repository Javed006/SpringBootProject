package com.springrest.springrest.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.springrest.springrest.exception.AgeDoesNotFoundException;
import com.springrest.springrest.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springrest.springrest.dao.EmployeeDao;
import com.springrest.springrest.entities.EmployeeDTO;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeDao employeeDao;
	@Override
	public List<EmployeeDTO> getEmployees() {

		return employeeDao.findAll();
	}
	@Override
	public EmployeeDTO getEmployee(long eId) {
		return 
				employeeDao.getOne(eId);
	}
	@Override
	public String addEmployee(Employee employee) throws ParseException, AgeDoesNotFoundException {

		EmployeeDTO employeeDTO=new EmployeeDTO();
		employeeDTO.setName(employee.getName());
		employeeDTO.setSalary(employee.getSalary());
		employeeDTO.setEId(employee.getEId());
		employeeDTO.setAge(employee.getAge());
		Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(employee.getDate());
		employeeDTO.setDate(date1);
		int age=employee.getAge();

			if(age<=10){
				employeeDTO.setStatus("kid");
			} else if (age>=13 && age<=19) {
				employeeDTO.setStatus("Adult");
			} else if (age>=20 && age<=40) {
				employeeDTO.setStatus("citizen");
			} else if (age>=60 && age<90) {
				employeeDTO.setStatus("oldCitizen");
			}else if(age>=100){
				throw new AgeDoesNotFoundException
						("InvalidAge");
			}

		employeeDao.save(employeeDTO);
		return "Successfully saved";
	}
	@Override
	public EmployeeDTO updEmployee(Employee employee) {
		EmployeeDTO employeeDTO1 =employeeDao.findByeId(employee.getEId());
		employeeDTO1.setName("javed");
		employeeDTO1.setAge(22);
		employeeDTO1.setSalary(14000.0);
		return  employeeDTO1;
	}

	@Override
	public EmployeeDTO findHighestSalary() {
		List<EmployeeDTO> employeeDTOList = employeeDao.findAll();
		Collections.sort(employeeDTOList, new Comparator<EmployeeDTO>() {
			@Override
			public int compare(EmployeeDTO o1, EmployeeDTO o2) {
				return (int) (o2.getSalary()-o1.getSalary());
			}
		});
		EmployeeDTO employeeDTO = employeeDTOList.get(0);
		Employee employee= new Employee();
		employee.setAge(employeeDTO.getAge());
		employee.setSalary(employee.getSalary());
		employee.setName(employee.getName());
		employee.setEId(employee.getEId());
		return employeeDTO;
	}
}
