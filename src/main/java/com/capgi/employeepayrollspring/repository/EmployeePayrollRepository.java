package com.capgi.employeepayrollspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgi.employeepayrollspring.domain.EmployeePayrollDB;

@Repository
public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollDB, Long> {

}
