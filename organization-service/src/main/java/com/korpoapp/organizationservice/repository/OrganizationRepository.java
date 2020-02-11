package com.korpoapp.organizationservice.repository;

import com.korpoapp.organizationservice.model.Organization;
import org.springframework.data.repository.CrudRepository;

public interface OrganizationRepository extends CrudRepository<Organization, String> {

}