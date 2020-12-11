package com.capgi.employeepayrollspring.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.capgi.employeepayrollspring.dto.EmployeePayrollDTO;

@Entity
@Table(name = "emp_data")
public class EmployeePayrollDB implements Serializable {

	private static final long serialVersionUID = -8900492704842756948L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private Long salary;

	public EmployeePayrollDB() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public EmployeePayrollDB(Long id, String name, Long salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public EmployeePayrollDB(EmployeePayrollDTO employeePayrollDTO) {
		this.name = employeePayrollDTO.getName();
		this.salary = employeePayrollDTO.getSalary();
	}
}
