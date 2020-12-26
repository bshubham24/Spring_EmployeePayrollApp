package com.capgi.employeepayrollspring.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.capgi.employeepayrollspring.dto.EmployeePayrollDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "emp_data")
public class EmployeePayrollData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Long salary;
	private String gender;
	@JsonFormat(pattern = "dd MMM yyyy")
	private LocalDate startDate;
	private String profilePic;
	private String notes;
	@ElementCollection
	@CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "department")
	private List<String> departments;

	public EmployeePayrollData() {

	}

	public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		this.name = employeePayrollDTO.getName();
		this.salary = employeePayrollDTO.getSalary();
		this.departments = employeePayrollDTO.getDepartments();
		this.gender = employeePayrollDTO.getGender();
		this.startDate = employeePayrollDTO.getStartDate();
		this.profilePic = employeePayrollDTO.getProfilePic();
		this.notes = employeePayrollDTO.getNotes();
	}

}
