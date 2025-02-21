package com.ems.departmentservice.controller;

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

import com.ems.departmentservice.dto.DepartmentDto;
import com.ems.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

	DepartmentService departmentService;

	@PostMapping
	public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {

		DepartmentDto department = departmentService.createDepartment(departmentDto);

		return new ResponseEntity<DepartmentDto>(department, HttpStatus.CREATED);
	}

	@GetMapping("/code/{department-code}")
	public ResponseEntity<DepartmentDto> getDeparmentByCode(@PathVariable("department-code") String departmentCode) {

		DepartmentDto departmentDto = departmentService.getDeparmentByCode(departmentCode);

		return new ResponseEntity<DepartmentDto>(departmentDto, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long departmentId) {

		DepartmentDto departmentDto = departmentService.getDepartmentById(departmentId);

		return new ResponseEntity<DepartmentDto>(departmentDto, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<DepartmentDto>> getAllDepartments() {

		List<DepartmentDto> departments = departmentService.getAllDepartments();

		return new ResponseEntity<List<DepartmentDto>>(departments, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long departmentId,
			@RequestBody DepartmentDto departmentDto) {

		DepartmentDto department = departmentService.updateDepartment(departmentId, departmentDto);

		return new ResponseEntity<DepartmentDto>(department, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId) {

		departmentService.deleteDepartment(departmentId);
		return new ResponseEntity<>("Department deleted successfully!", HttpStatus.OK);
	}

}
