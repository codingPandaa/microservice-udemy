package com.ems.employeeservice.mapper;

import com.ems.employeeservice.dto.EmployeeDto;
import com.ems.employeeservice.entity.Employee;

public class EmployeeMapper {

	public static EmployeeDto mapToDto(Employee employee) {

		EmployeeDto employeeDto = new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(),
				employee.getEmail(), employee.getDepartmentCode(), employee.getOrganizationCode());

		return employeeDto;
	}

	public static Employee mapToEntity(EmployeeDto employeeDto) {

		Employee employee = new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(),
				employeeDto.getEmail(), employeeDto.getDepartmentCode(), employeeDto.getOrganizationCode());

		return employee;
	}
}
