package com.capgi.employeepayrollspring.dto;

import com.capgi.employeepayrollspring.domain.EmployeePayrollDB;

import lombok.Data;

@Data
public class EmployeePayrollDTO {
	private Long id;
	public String name;
	public long salary;

	public EmployeePayrollDTO(Long id, String name, long salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public EmployeePayrollDTO(EmployeePayrollDB user) {
		this.id = user.getId();
		this.name = user.getName();
		this.salary = user.getSalary();
	}

	@Override
	public String toString() {
		return "EmployeePayrollDTO [id=" + id + ", name=" + name + ", salary=" + salary + "]";
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

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

}
