package com.capgi.employeepayrollspring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgi.employeepayrollspring.domain.EmployeePayrollDB;
import com.capgi.employeepayrollspring.dto.EmployeePayrollDTO;
import com.capgi.employeepayrollspring.model.EmployeePayrollData;
import com.capgi.employeepayrollspring.repository.EmployeePayrollRepository;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	@Autowired
	private EmployeePayrollRepository employeePayrollRepository;

	private List<EmployeePayrollData> employeePayrollList = new ArrayList<EmployeePayrollData>();

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeePayrollList;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		return employeePayrollList.get(empId - 1);
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(employeePayrollList.size() + 1, empPayrollDTO);
		employeePayrollList.add(empData);
		return empData;
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = employeePayrollList.get(empId - 1);
		empData.setName(empPayrollDTO.name);
		empData.setSalary(empPayrollDTO.salary);
		employeePayrollList.set(empId - 1, empData);
		return empData;
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		employeePayrollList.remove(empId - 1);
	}

	@Override
	public List<EmployeePayrollDTO> getAllUserDB() {
		return employeePayrollRepository.findAll().stream()
				.map(employeePayroll -> new EmployeePayrollDTO(employeePayroll)).collect(Collectors.toList());

	}

	@Override
	public EmployeePayrollDTO getUserByIdDB(long id) {
		return employeePayrollRepository.findById(id).map(employeePayroll -> new EmployeePayrollDTO(employeePayroll))
				.orElse(null);
	}

	@Override
	public EmployeePayrollDB createUserDB(EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollDB employeePayrollDB = new EmployeePayrollDB(employeePayrollDTO);
		employeePayrollRepository.save(employeePayrollDB);
		return employeePayrollDB;
	}

	@Override
	public EmployeePayrollDB updateUserDB(long empId, EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollDB employeePayrollDB = employeePayrollRepository.findById(empId).get();
		employeePayrollDB.setName(empPayrollDTO.getName());
		employeePayrollDB.setSalary(empPayrollDTO.getSalary());
		employeePayrollRepository.save(employeePayrollDB);
		return employeePayrollDB;
	}

	@Override
	public void deleteUserDB(long empId) {
		employeePayrollRepository.deleteById(empId);
	}

}
