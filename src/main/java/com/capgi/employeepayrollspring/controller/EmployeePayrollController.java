package com.capgi.employeepayrollspring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgi.employeepayrollspring.domain.EmployeePayrollDB;
import com.capgi.employeepayrollspring.dto.EmployeePayrollDTO;
import com.capgi.employeepayrollspring.dto.ResponseDTO;
import com.capgi.employeepayrollspring.model.EmployeePayrollData;
import com.capgi.employeepayrollspring.service.IEmployeePayrollService;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

	@Autowired
	private IEmployeePayrollService employeePayrollService;

	@RequestMapping(value = { "", "/", "/get" })
	public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
		List<EmployeePayrollData> empPayrollList = null;
		empPayrollList = employeePayrollService.getEmployeePayrollData();
		ResponseDTO respDTO = new ResponseDTO("Get call Success", empPayrollList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@RequestMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
		EmployeePayrollData empData = null;
		empData = employeePayrollService.getEmployeePayrollDataById(empId);
		ResponseDTO respDTO = new ResponseDTO("Get call for id: " + empId + " Successfull", empData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData empData = null;
		empData = employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
		ResponseDTO respDTO = new ResponseDTO("Created Employee Payroll Data Successfully", empData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,
			@RequestBody EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData empData = null;
		empData = employeePayrollService.updateEmployeePayrollData(empId, employeePayrollDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated Employee Payroll Data Successfully", empData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
		employeePayrollService.deleteEmployeePayrollData(empId);
		ResponseDTO respDTO = new ResponseDTO("Deleted Employee Payroll Data Successfully", "Deleted id: " + empId);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@GetMapping("/sql")
	public ResponseEntity<ResponseDTO> getEmployeePayrollDataFromDB() {
		List<EmployeePayrollDTO> empPayrollList = null;
		empPayrollList = employeePayrollService.getAllUserDB();
		ResponseDTO respDTO = new ResponseDTO("Get call Success", empPayrollList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@GetMapping("/sql/{id}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollDataByIdFromDB(@PathVariable long id) {
		EmployeePayrollDTO empPayrollDTO = employeePayrollService.getUserByIdDB(id);
		ResponseDTO respDTO = new ResponseDTO("Get call By id: " + id + " Success", empPayrollDTO);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@PostMapping("/sql/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollDataDB(
			@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollDB employeePayrollDB = null;
		employeePayrollDB = employeePayrollService.createUserDB(employeePayrollDTO);
		ResponseDTO respDTO = new ResponseDTO("Created Employee Payroll Data Successfully", employeePayrollDB);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@PutMapping("/sql/update/{empId}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollDataDB(@Valid @PathVariable("empId") int empId,
			@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollDB employeePayrollDB = null;
		employeePayrollDB = employeePayrollService.updateUserDB(empId, employeePayrollDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated Employee Payroll Data Successfully", employeePayrollDB);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@DeleteMapping("/sql/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollDataDB(@PathVariable("empId") int empId) {
		employeePayrollService.deleteUserDB(empId);
		ResponseDTO respDTO = new ResponseDTO("Deleted Employee Payroll Data Successfully", "Deleted id: " + empId);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}
