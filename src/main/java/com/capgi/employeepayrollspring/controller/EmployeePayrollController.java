package com.capgi.employeepayrollspring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgi.employeepayrollspring.dto.EmployeePayrollDTO;
import com.capgi.employeepayrollspring.dto.ResponseDTO;
import com.capgi.employeepayrollspring.model.EmployeePayrollData;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

	@RequestMapping(value = { "", "/", "/get" })
	public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(1, new EmployeePayrollDTO("pankaj", 30000));
		ResponseDTO respDTO = new ResponseDTO("Get call Success", empData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@RequestMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(empId, new EmployeePayrollDTO("pankaj", 30000));
		ResponseDTO respDTO = new ResponseDTO("Get call for id: " + empId + " Successfull", empData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(1, employeePayrollDTO);
		ResponseDTO respDTO = new ResponseDTO("Created Employee Payroll Data Successfully", empData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(1, employeePayrollDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated Employee Payroll Data Successfully", empData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
		ResponseDTO respDTO = new ResponseDTO("Deleted Employee Payroll Data Successfully", "Deleted id: " + empId);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}
