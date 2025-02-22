package com.ems.organizationservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.organizationservice.entity.Organization;

public interface OrganizationRepo extends JpaRepository<Organization, Long> {

	Organization findByOrganizationCode(String organizationCode);
}
