package com.capgi.employeepayrollspring.dto;

import java.sql.Date;
import java.time.LocalDate;
import java.util.regex.Pattern;

import javax.persistence.Id;

import com.capgi.employeepayrollspring.domain.EmployeePayrollDB;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class EmployeePayrollDTO {
	@Id
	private Long id;
	public String name;
	public long salary;
	public String gender;
	public String department;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	public Date startDate;
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
		if (validate(name, salary, gender, department, startDate)) {
			this.id = user.getId();
			this.name = user.getName();
			this.salary = user.getSalary();
			this.gender = user.getGender();
			this.department = user.getDepartment();
			this.startDate = user.getStartDate();
			this.notes = user.getNotes();
		}
	}

	final static String NAME_PATTERN = "^[A-Z]{1}[a-zA-Z]{2,}";

	public EmployeePayrollDTO(String name, long salary, String gender, String department, Date startDate,
			String notes) {

		if (validate(name, salary, gender, department, startDate)) {
			this.name = name;
			this.salary = salary;
			this.gender = gender;
			this.department = department;
			this.startDate = startDate;
			this.notes = notes;
		}

	}

	public static boolean validate(String name, long salary, String gender, String department, Date startDate) {
		boolean b1 = Pattern.matches(NAME_PATTERN, name);
		boolean b2 = (salary >= 100000 && salary <= 500000) ? true : false;
		boolean b3 = (gender.equalsIgnoreCase("female") || gender.equalsIgnoreCase("male")) ? true : false;
		boolean b4 = department.contains("HR") || department.contains("sales") || department.contains("Engineering")
				|| department.contains("Marketing");
		Date current = Date.valueOf(LocalDate.now());
		boolean b5 = (startDate.before(current)) ? true : false;

		return b1 && b2 && b3 && b4 && b5;
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
