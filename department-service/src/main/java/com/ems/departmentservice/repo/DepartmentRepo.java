package com.ems.departmentservice.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.departmentservice.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long> {

	Optional<Department>  findByDepartmentCode(String departmentCode);
}
