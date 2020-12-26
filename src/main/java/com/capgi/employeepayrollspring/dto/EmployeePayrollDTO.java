package com.capgi.employeepayrollspring.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.capgi.employeepayrollspring.model.EmployeePayrollData;
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
	public List<String> departments;
	@JsonFormat(pattern = "dd MMM yyyy")
	@PastOrPresent(message = "StartDate should be past or todays date")
	public LocalDate startDate;
	@NotBlank(message = "Profile Pic cannot be blank")
	public String profilePic;
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

	public EmployeePayrollDTO(EmployeePayrollData user) {
		this.id = user.getId();
		this.name = user.getName();
		this.salary = user.getSalary();
		this.gender = user.getGender();
		this.departments = user.getDepartments();
		this.startDate = user.getStartDate();
		this.profilePic = user.getProfilePic();
		this.notes = user.getNotes();
	}

	public EmployeePayrollDTO(String name, long salary, String gender, List<String> department, LocalDate startDate,
			String profilePic, String notes) {

		this.name = name;
		this.salary = salary;
		this.gender = gender;
		this.departments = department;
		this.startDate = startDate;
		this.profilePic = profilePic;
		this.notes = notes;

	}

}
