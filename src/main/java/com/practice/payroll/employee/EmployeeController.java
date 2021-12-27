package com.practice.payroll.employee;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> index() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee show(@PathVariable Long employeeId ) {
        return employeeService.getEmployeeDetails(employeeId);
    }

    @PostMapping("/employees")
    public @ResponseBody Employee create(@RequestBody Employee employeeInfo) {
        return employeeService.addNewEmployee(employeeInfo);
    }
}
