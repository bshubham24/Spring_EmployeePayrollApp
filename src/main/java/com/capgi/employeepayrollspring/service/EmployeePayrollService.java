package com.capgi.employeepayrollspring.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgi.employeepayrollspring.dto.EmployeePayrollDTO;
import com.capgi.employeepayrollspring.exception.EmployeeNotFoundException;
import com.capgi.employeepayrollspring.model.EmployeePayrollData;
import com.capgi.employeepayrollspring.repository.EmployeePayrollRepository;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	@Autowired
	private EmployeePayrollRepository employeePayrollRepository;

	@Override
	public List<EmployeePayrollDTO> getAllUserDB() {
		return employeePayrollRepository.findAll().stream()
				.map(employeePayroll -> new EmployeePayrollDTO(employeePayroll)).collect(Collectors.toList());

	}

	@Override
	public EmployeePayrollDTO getUserByIdDB(long id) {
		EmployeePayrollDTO employeePayrollDTO = employeePayrollRepository.findById(id)
				.map(employeePayroll -> new EmployeePayrollDTO(employeePayroll)).orElse(null);
		if (employeePayrollDTO == null) {
			throw new EmployeeNotFoundException("Employee Not Found");
		} else {
			return employeePayrollDTO;
		}

	}

	@Override
	public EmployeePayrollData createUserDB(EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeePayrollDB = new EmployeePayrollData(employeePayrollDTO);
		employeePayrollRepository.save(employeePayrollDB);
		return employeePayrollDB;

	}

	@Override
	public EmployeePayrollData updateUserDB(long empId, EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData employeePayrollDB = employeePayrollRepository.findById(empId).get();
		if (employeePayrollDB != null && employeePayrollDB.getId() == empId) {
			if (Objects.nonNull(empPayrollDTO.getName())) {
				employeePayrollDB.setName(empPayrollDTO.getName());
			}
			if (Objects.nonNull(empPayrollDTO.getSalary())) {
				employeePayrollDB.setSalary(empPayrollDTO.getSalary());
			}
			if (Objects.nonNull(empPayrollDTO.getDepartments())) {
				employeePayrollDB.setDepartments(empPayrollDTO.getDepartments());
			}
			if (Objects.nonNull(empPayrollDTO.getGender())) {
				employeePayrollDB.setGender(empPayrollDTO.getGender());
			}
			if (Objects.nonNull(empPayrollDTO.getStartDate())) {
				employeePayrollDB.setStartDate(empPayrollDTO.getStartDate());
			}
			if (Objects.nonNull(empPayrollDTO.getProfilePic())) {
				employeePayrollDB.setProfilePic(empPayrollDTO.getProfilePic());
			}
			if (Objects.nonNull(empPayrollDTO.getNotes())) {
				employeePayrollDB.setNotes(empPayrollDTO.getNotes());
			}
			employeePayrollRepository.save(employeePayrollDB);
			return employeePayrollDB;
		}
		return null;

	}

	@Override
	public void deleteUserDB(long empId) {
		EmployeePayrollData employeePayrollDB = employeePayrollRepository.findById(empId).get();
		if (employeePayrollDB.getName() != null) {
			employeePayrollRepository.deleteById(empId);
		} else {
			throw new EmployeeNotFoundException("Employee not found!!!");
		}
	}

}
