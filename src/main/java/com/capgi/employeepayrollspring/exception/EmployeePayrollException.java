//package com.capgi.employeepayrollspring.exception;
//
//import java.sql.SQLException;
//import java.util.NoSuchElementException;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import com.capgi.employeepayrollspring.dto.ResponseDTO;
//
//@ControllerAdvice
//public class EmployeePayrollException {
//
//	@ExceptionHandler(EmployeeNotFoundException.class)
//	public final ResponseEntity<ResponseDTO> employeeNotFoundException(EmployeeNotFoundException e) {
//		ResponseDTO status = new ResponseDTO(e.getMessage());
//		return new ResponseEntity<ResponseDTO>(status, HttpStatus.OK);
//	}
//
//	@ExceptionHandler(DataMissingException.class)
//	public final ResponseEntity<ResponseDTO> dataMissingException(DataMissingException e) {
//		ResponseDTO status = new ResponseDTO(e.getMessage());
//		return new ResponseEntity<ResponseDTO>(status, HttpStatus.OK);
//	}
//
//	@ExceptionHandler(SQLException.class)
//	public final ResponseEntity<ResponseDTO> QueryException(SQLException e) {
//		ResponseDTO status = new ResponseDTO("SQL exception thrown!!");
//		return new ResponseEntity<ResponseDTO>(status, HttpStatus.OK);
//	}
//
//	@ExceptionHandler(NoSuchElementException.class)
//	public final ResponseEntity<ResponseDTO> NoElementException(NoSuchElementException e) {
//		ResponseDTO status = new ResponseDTO("No such element exists!!");
//		return new ResponseEntity<ResponseDTO>(status, HttpStatus.OK);
//	}
//
//	@ExceptionHandler(Exception.class)
//	public final ResponseEntity<ResponseDTO> AnonymousException(Exception e) {
//		ResponseDTO status = new ResponseDTO("Exception thrown!! \nCan't process your request.");
//		return new ResponseEntity<ResponseDTO>(status, HttpStatus.OK);
//	}
//
//}
