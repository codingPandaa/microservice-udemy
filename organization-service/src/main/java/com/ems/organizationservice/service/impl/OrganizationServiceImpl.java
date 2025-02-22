package com.ems.organizationservice.service.impl;

import org.springframework.stereotype.Service;

import com.ems.organizationservice.dto.OrganizationDto;
import com.ems.organizationservice.entity.Organization;
import com.ems.organizationservice.mapper.OrganizationMapper;
import com.ems.organizationservice.repo.OrganizationRepo;
import com.ems.organizationservice.service.OrganizationService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

	private OrganizationRepo organizationRepo;

	@Override
	public OrganizationDto createOrganzation(OrganizationDto organizationDto) {

		Organization organization = OrganizationMapper.mapToEntity(organizationDto);

		Organization savedOrganization = organizationRepo.save(organization);

		return OrganizationMapper.mapToDto(savedOrganization);
	}

	@Override
	public OrganizationDto getOrganizationByCode(String organizationCode) {

		Organization organization = organizationRepo.findByOrganizationCode(organizationCode);

		return OrganizationMapper.mapToDto(organization);
	}

}
