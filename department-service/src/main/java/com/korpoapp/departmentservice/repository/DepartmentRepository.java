package com.korpoapp.departmentservice.repository;

import com.korpoapp.departmentservice.model.Department;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<Department, String> {

    List<Department> findByOrganizationId(Long organizationId);

}
