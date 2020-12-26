package com.capgi.employeepayrollspring.service;

import java.util.List;

import com.capgi.employeepayrollspring.dto.EmployeePayrollDTO;
import com.capgi.employeepayrollspring.model.EmployeePayrollData;

public interface IEmployeePayrollService {

	List<EmployeePayrollDTO> getAllUserDB();

	EmployeePayrollDTO getUserByIdDB(long empId);

	EmployeePayrollData createUserDB(EmployeePayrollDTO employeePayrollDTO);

	EmployeePayrollData updateUserDB(long empId, EmployeePayrollDTO empPayrollDTO);

	void deleteUserDB(long empId);

}
