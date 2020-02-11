package com.korpoapp.organizationservice;

import com.korpoapp.organizationservice.model.Department;
import com.korpoapp.organizationservice.model.Organization;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class OrganizationServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void test() {;
		Organization organization = new Organization("3", "3","3", null, null);
		Organization organization2 = new Organization("3", "3","3", null, null);

		Department department = new Department(3L, "3", null);
		Optional<Organization> org = Optional.of(organization);
		Optional<Organization> org2 = Optional.of(organization2);
		org.ifPresent(o -> o.setDepartments(List.of(department)));


		Organization o3;
		if (org2.isPresent()) {
            Organization o = org.get();
			o.setDepartments(List.of(department));
            o3 = o;
        } else {
            o3 = null;
        }

		Assertions.assertEquals(org.orElse(null), o3);

	}
}
