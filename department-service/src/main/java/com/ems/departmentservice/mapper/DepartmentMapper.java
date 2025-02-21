package com.ems.departmentservice.mapper;

import com.ems.departmentservice.dto.DepartmentDto;
import com.ems.departmentservice.entity.Department;

public class DepartmentMapper {

	public static DepartmentDto mapToDto(Department department) {

		DepartmentDto departmentDto = new DepartmentDto(department.getId(), department.getDepartmentName(),
				department.getDepartmentDescription(), department.getDepartmentCode());

		return departmentDto;
	}

	public static Department mapToEntity(DepartmentDto departmentDto) {

		Department department = new Department(departmentDto.getId(), departmentDto.getDepartmentName(),
				departmentDto.getDepartmentDescription(), departmentDto.getDepartmentCode());

		return department;
	}

}
