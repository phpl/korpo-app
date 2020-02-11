package com.korpoapp.organizationservice.controller;

import com.korpoapp.organizationservice.client.DepartmentClient;
import com.korpoapp.organizationservice.client.EmployeeClient;
import com.korpoapp.organizationservice.model.Organization;
import com.korpoapp.organizationservice.repository.OrganizationRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@AllArgsConstructor
@RestController
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OrganizationController {
    
    OrganizationRepository repository;
    DepartmentClient departmentClient;
    EmployeeClient employeeClient;

    @PostMapping
    public Organization add(@RequestBody Organization organization) {
        log.info("Organization add: {}", organization);
        return repository.save(organization);
    }

    @GetMapping
    public Iterable<Organization> findAll() {
        log.info("Organization find");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Organization findById(@PathVariable("id") String id) {
        log.info("Organization find: id={}", id);
        return repository.findById(id).orElse(null);
    }

    @GetMapping("/{id}/with-departments")
    public Organization findByIdWithDepartments(@PathVariable("id") String id) {
        log.info("Organization find: id={}", id);
        Optional<Organization> organization = repository.findById(id);
        organization.ifPresent(o -> o.setDepartments(departmentClient.findByOrganization(o.getId())));
        return organization.orElse(null);
    }

    @GetMapping("/{id}/with-departments-and-employees")
    public Organization findByIdWithDepartmentsAndEmployees(@PathVariable("id") String id) {
        log.info("Organization find: id={}", id);
        Optional<Organization> organization = repository.findById(id);
        organization.ifPresent(o -> o.setDepartments(departmentClient.findByOrganizationWithEmployees(o.getId())));
        return organization.orElse(null);
    }

    @GetMapping("/{id}/with-employees")
    public Organization findByIdWithEmployees(@PathVariable("id") String id) {
        log.info("Organization find: id={}", id);
        Optional<Organization> organization = repository.findById(id);
        organization.ifPresent(o -> o.setEmployees(employeeClient.findByOrganization(o.getId())));
        return organization.orElse(null);
    }
}
