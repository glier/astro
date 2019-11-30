package com.asn.astro.controller.persons;

import com.asn.astro.domain.persons.emploee.Employee;
import com.asn.astro.services.persons.EmployeeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController extends PersonAbstractController<Employee, EmployeeService> {

    public EmployeeController(EmployeeService service) {
        super(service);
    }

}
