package com.asn.astro.repositories.persons;

import com.asn.astro.domain.persons.emploee.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends PersonRepository<Employee> {
}
