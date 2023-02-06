package com.springrest.springrest.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Data
public class Employee {
	private long eId;
	private String name;
	private double salary;
	private  int age;
	private String date;
}
