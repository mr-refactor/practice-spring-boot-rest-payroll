package com.practice.payroll.controllers;

import com.practice.payroll.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private final EmployeeRepository employeeRepo;

    public EmployeeController(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
}
