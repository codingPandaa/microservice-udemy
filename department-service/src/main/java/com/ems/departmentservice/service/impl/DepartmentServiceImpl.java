package com.ems.departmentservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ems.departmentservice.dto.DepartmentDto;
import com.ems.departmentservice.entity.Department;
import com.ems.departmentservice.exception.ResourceNotFoundException;
import com.ems.departmentservice.mapper.DepartmentMapper;
import com.ems.departmentservice.repo.DepartmentRepo;
import com.ems.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepo departmentRepo;

	@Override
	public DepartmentDto createDepartment(DepartmentDto departmentDto) {

		Department department = DepartmentMapper.mapToEntity(departmentDto);

		Department savedDepartment = departmentRepo.save(department);

		return DepartmentMapper.mapToDto(savedDepartment);
	}

	@Override
	public DepartmentDto getDeparmentByCode(String departmentCode) {

		Department department = departmentRepo.findByDepartmentCode(departmentCode)
				.orElseThrow(() -> new ResourceNotFoundException("Department", "code", departmentCode));

		return DepartmentMapper.mapToDto(department);
	}

	@Override
	public DepartmentDto getDepartmentById(Long departmentId) {

		Department department = departmentRepo.findById(departmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Department", "id", departmentId.toString()));

		return DepartmentMapper.mapToDto(department);
	}

	@Override
	public List<DepartmentDto> getAllDepartments() {

		List<Department> departments = departmentRepo.findAll();

		return departments.stream().map(department -> DepartmentMapper.mapToDto(department))
				.collect(Collectors.toList());
	}

	@Override
	public DepartmentDto updateDepartment(Long departmentId, DepartmentDto departmentDto) {

		Department department = departmentRepo.findById(departmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Department", "id", departmentId.toString()));

		department.setDepartmentName(departmentDto.getDepartmentName());
		department.setDepartmentDescription(departmentDto.getDepartmentDescription());
		department.setDepartmentCode(departmentDto.getDepartmentCode());

		Department updatedDepartment = departmentRepo.save(department);

		return DepartmentMapper.mapToDto(updatedDepartment);
	}

	@Override
	public void deleteDepartment(Long departmentId) {

		departmentRepo.findById(departmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Department", "id", departmentId.toString()));

		departmentRepo.deleteById(departmentId);
	}

}
