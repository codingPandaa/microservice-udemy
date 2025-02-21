package com.ems.employeeservice.service;

import java.util.List;

import com.ems.employeeservice.dto.APIResponseDto;
import com.ems.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto createEmployee(EmployeeDto employeeDto);

	APIResponseDto getEmployeeById(Long employeeId);

	List<EmployeeDto> getAllEmployees();

	EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto);
	
	void deleteEmployee(Long employeeId);
}
