package com.korpoapp.employeeservice.repository;

import com.korpoapp.employeeservice.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {

    List<Employee> findByDepartmentId(Long departmentId);

    List<Employee> findByOrganizationId(Long organizationId);

}