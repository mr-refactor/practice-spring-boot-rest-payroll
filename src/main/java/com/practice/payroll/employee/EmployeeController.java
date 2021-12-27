package com.practice.payroll.employee;

import org.springframework.http.HttpStatus;
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

    @PutMapping("/employees/{employeeId}")
    public Employee update(@PathVariable Long employeeId, @RequestBody Employee employeeInfo) {
        return employeeService.updateEmployeeDetails(employeeId, employeeInfo);
    }

    @DeleteMapping("/employees/{employeeId}")
    public @ResponseBody String delete(@PathVariable Long employeeId) {
        return employeeService.removeEmployee(employeeId);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private @ResponseBody String handleEmployeeNotFoundException(EmployeeNotFoundException ex){
        return ex.getMessage();
    }
}
