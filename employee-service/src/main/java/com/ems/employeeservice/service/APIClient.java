package com.ems.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ems.employeeservice.dto.DepartmentDto;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {

	@GetMapping("api/departments/code/{department-code}")
	DepartmentDto getDeparmentByCode(@PathVariable("department-code") String departmentCode);
}
