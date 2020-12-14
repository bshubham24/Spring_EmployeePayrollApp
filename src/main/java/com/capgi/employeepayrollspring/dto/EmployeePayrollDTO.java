package com.capgi.employeepayrollspring.dto;

import java.sql.Date;

import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.capgi.employeepayrollspring.domain.EmployeePayrollDB;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class EmployeePayrollDTO {
	@Id
	private Long id;
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name is Invalid")
	public String name;
	@Min(value = 30000, message = "Min Wage Should be more than 30000")
	@Max(value = 300000, message = "Max Wage Should be less than 300000")
	public long salary;
	@Pattern(regexp = "male|female|Female|Male", message = "Invalid Gender")
	public String gender;
	@NotEmpty(message = "Employee department cannot be null")
	public String department;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	// @PastOrPresent(message = "StartDate should be past or todays date")
	public Date startDate;
	@NotBlank(message = "notes cannot be blank")
	public String notes;

	public EmployeePayrollDTO() {

	}

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
		this.gender = user.getGender();
		this.department = user.getDepartment();
		this.startDate = user.getStartDate();
		this.notes = user.getNotes();
	}

	final static String NAME_PATTERN = "^[A-Z]{1}[a-zA-Z]{2,}";

	public EmployeePayrollDTO(String name, long salary, String gender, String department, Date startDate,
			String notes) {

		this.name = name;
		this.salary = salary;
		this.gender = gender;
		this.department = department;
		this.startDate = startDate;
		this.notes = notes;

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

	@Override
	public String toString() {
		return "EmployeePayrollDTO [id=" + id + ", name=" + name + ", salary=" + salary + ", gender=" + gender
				+ ", department=" + department + ", startDate=" + startDate + ", notes=" + notes + "]";
	}

}
