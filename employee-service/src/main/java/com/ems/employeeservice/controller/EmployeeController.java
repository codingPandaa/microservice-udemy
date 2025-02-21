package com.ems.employeeservice.controller;

import java.util.List;

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

import com.ems.employeeservice.dto.APIResponseDto;
import com.ems.employeeservice.dto.EmployeeDto;
import com.ems.employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

	EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {

		EmployeeDto employee = employeeService.createEmployee(employeeDto);
		return new ResponseEntity<>(employee, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable("id") Long employeeId) {

		APIResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);

		return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees() {

		List<EmployeeDto> employees = employeeService.getAllEmployees();

		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,
			@RequestBody EmployeeDto employeeDto) {

		EmployeeDto updateEmployee = employeeService.updateEmployee(employeeId, employeeDto);
		return new ResponseEntity<EmployeeDto>(updateEmployee, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {

		employeeService.deleteEmployee(employeeId);

		return new ResponseEntity<>("Employee deleted successfully!", HttpStatus.OK);
	};

}
