package com.ems.departmentservice.service;

import java.util.List;

import com.ems.departmentservice.dto.DepartmentDto;

public interface DepartmentService {

	DepartmentDto createDepartment(DepartmentDto departmentDto);

	DepartmentDto getDeparmentByCode(String departmentCode);
	
	DepartmentDto getDepartmentById(Long departmentId);
	
	List<DepartmentDto> getAllDepartments();
	
	DepartmentDto updateDepartment(Long departmentId, DepartmentDto departmentDto);
	
	void deleteDepartment(Long departmentId);

}
