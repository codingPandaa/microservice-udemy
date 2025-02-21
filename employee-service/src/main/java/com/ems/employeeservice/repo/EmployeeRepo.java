package com.ems.employeeservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.employeeservice.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
