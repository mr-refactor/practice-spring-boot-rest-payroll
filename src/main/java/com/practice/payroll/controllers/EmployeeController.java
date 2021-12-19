package com.practice.payroll.controllers;

import com.practice.payroll.entities.Employee;
import com.practice.payroll.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeRepository employeeRepo;

    public EmployeeController(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @GetMapping("/employees")
    public List<Employee> getAll() {
        List<Employee> employees = employeeRepo.findAll();
        return employees;
    }
}
