package com.capgi.employeepayrollspring.service;

import java.util.List;

import com.capgi.employeepayrollspring.domain.EmployeePayrollDB;
import com.capgi.employeepayrollspring.dto.EmployeePayrollDTO;
import com.capgi.employeepayrollspring.model.EmployeePayrollData;

public interface IEmployeePayrollService {
	List<EmployeePayrollData> getEmployeePayrollData();

	EmployeePayrollData getEmployeePayrollDataById(int empId);

	EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);

	EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO);

	void deleteEmployeePayrollData(int empId);

	List<EmployeePayrollDTO> getAllUserDB();

	EmployeePayrollDTO getUserByIdDB(long empId);

	EmployeePayrollDB createUserDB(EmployeePayrollDTO employeePayrollDTO);

	EmployeePayrollDB updateUserDB(long empId, EmployeePayrollDTO empPayrollDTO);

	void deleteUserDB(long empId);

}
