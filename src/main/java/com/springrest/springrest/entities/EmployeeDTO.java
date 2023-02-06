package com.springrest.springrest.entities;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "employee")
public class EmployeeDTO {

	@Id
	private long eId;
	private String name;
	private double salary;
	private  int age;
	private String status;
	private Date date;
}