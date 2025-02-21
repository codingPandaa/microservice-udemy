package com.ems.organizationservice.service;

import com.ems.organizationservice.dto.OrganizationDto;

public interface OrganizationService {

	OrganizationDto createOrganzation(OrganizationDto organizationDto);

	OrganizationDto getOrganizationByCode(String organizationCode);
}
