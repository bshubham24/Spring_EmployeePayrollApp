package com.capgi.employeepayrollspring.service;

import java.util.List;

import com.capgi.employeepayrollspring.dto.EmployeePayrollDTO;
import com.capgi.employeepayrollspring.model.EmployeePayrollData;

public interface IEmployeePayrollService {
	List<EmployeePayrollData> getEmployeeData();

	EmployeePayrollData getEmployeePayrollById(int empId);

	EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);

	EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO);

	void deleteEmployeePayrollData(int empId);
}
