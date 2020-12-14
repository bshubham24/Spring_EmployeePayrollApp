package com.capgi.employeepayrollspring.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.capgi.employeepayrollspring.dto.EmployeePayrollDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "emp_data")
public class EmployeePayrollDB implements Serializable {

	private static final long serialVersionUID = -8900492704842756948L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Long salary;
	private String gender;
	private String department;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date startDate;
	private String profilePic;
	private String notes;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

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

	public EmployeePayrollDB(Long id, String name, Long salary, String gender, String department, Date startDate,
			String profilePic, String notes) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.gender = gender;
		this.department = department;
		this.startDate = startDate;
		this.profilePic = profilePic;
		this.notes = notes;
	}

	public EmployeePayrollDB(EmployeePayrollDTO employeePayrollDTO) {
		this.name = employeePayrollDTO.getName();
		this.salary = employeePayrollDTO.getSalary();
		this.department = employeePayrollDTO.getDepartment();
		this.gender = employeePayrollDTO.getGender();
		this.startDate = employeePayrollDTO.getStartDate();
		this.profilePic = employeePayrollDTO.getProfilePic();
		this.notes = employeePayrollDTO.getNotes();
	}

}
