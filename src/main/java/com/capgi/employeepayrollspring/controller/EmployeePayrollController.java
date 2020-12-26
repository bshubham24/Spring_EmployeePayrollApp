package com.capgi.employeepayrollspring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgi.employeepayrollspring.dto.EmployeePayrollDTO;
import com.capgi.employeepayrollspring.dto.ResponseDTO;
import com.capgi.employeepayrollspring.model.EmployeePayrollData;
import com.capgi.employeepayrollspring.service.IEmployeePayrollService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "Controller to handle API requests")
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
public class EmployeePayrollController {

	@Autowired
	private IEmployeePayrollService employeePayrollService;

	@ApiOperation(value = "Request to get all employees available in the database")
	@GetMapping("/get")
	public ResponseEntity<ResponseDTO> getEmployeePayrollDataFromDB() {
		List<EmployeePayrollDTO> empPayrollList = null;
		empPayrollList = employeePayrollService.getAllUserDB();
		ResponseDTO respDTO = new ResponseDTO("Get call Success", empPayrollList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@ApiOperation(value = "Request to get a particular contact based on Id")
	@GetMapping("/get/{id}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollDataByIdFromDB(@PathVariable long id) {
		EmployeePayrollDTO empPayrollDTO = employeePayrollService.getUserByIdDB(id);
		ResponseDTO respDTO = new ResponseDTO("Get call By id: " + id + " Success", empPayrollDTO);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@ApiOperation(value = "Request to create new contact in the database")
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollDataDB(
			@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeePayrollDB = null;
		employeePayrollDB = employeePayrollService.createUserDB(employeePayrollDTO);
		ResponseDTO respDTO = new ResponseDTO("Created Employee Payroll Data Successfully", employeePayrollDB);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@ApiOperation(value = "Request to update an existing contact based on Id")
	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollDataDB(@Valid @PathVariable("empId") int empId,
			@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeePayrollDB = null;
		employeePayrollDB = employeePayrollService.updateUserDB(empId, employeePayrollDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated Employee Payroll Data Successfully", employeePayrollDB);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@ApiOperation(value = "Request to delete a contact from the database based on Id")
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollDataDB(@PathVariable("empId") int empId) {
		employeePayrollService.deleteUserDB(empId);
		ResponseDTO respDTO = new ResponseDTO("Deleted Employee Payroll Data Successfully", "Deleted id: " + empId);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}
