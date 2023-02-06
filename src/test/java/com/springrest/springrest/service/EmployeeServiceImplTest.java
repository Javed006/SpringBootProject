package com.springrest.springrest.service;

import com.springrest.springrest.dao.EmployeeDao;
import com.springrest.springrest.entities.EmployeeDTO;
import com.springrest.springrest.exception.AgeDoesNotFoundException;
import com.springrest.springrest.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.ExpectedCount;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeDao employeeDao;
    @InjectMocks
    private EmployeeServiceImpl employeeService;
    List<EmployeeDTO> employeeDTOList;

    @Test
    void getEmployees() {
        employeeDTOList = new ArrayList<>();
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName("Jav");
        employeeDTOList.add(employeeDTO);
    }

    @Test
    void createEmployee() throws ParseException, AgeDoesNotFoundException {
        Employee employee = new Employee();
        employee.setName("Jav");
        employee.setAge(22);
        employee.setSalary(14000.0);
        employee.setEId(67);
        employee.setDate("01/02/2012");
        assertEquals("Successfully saved", employeeService.addEmployee(employee));

    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceeds() {
        Employee employee = new Employee();
        employee.setName("Jav");
        employee.setAge(120);
        employee.setSalary(14000.0);
        employee.setEId(67);
        employee.setDate("01/02/2012");

        Exception exception = assertThrows(AgeDoesNotFoundException.class, () ->
        {
               employeeService.addEmployee(employee);
        });

        String expectedMessage = "InvalidAge";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

 /**    @Test
    void findHighestSalary() {
        Mockito.when(employeeDao.findAll()).thenReturn(employeeDTOList);
    }**/

}