package com.practice.payroll.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee addNewEmployee(Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    public Employee getEmployeeDetails(long employeeId) {
       return employeeRepository.findById(employeeId)
               .orElseThrow( () ->
                    new EmployeeNotFoundException("Employee with ID " + employeeId + " NOT FOUND"));
    }

    @Transactional
    public Employee updateEmployeeDetails(Long employeeId, Employee employeeDetails) {
        return employeeRepository.findById(employeeId)
                .map(employee -> {
                  employee.setName(employeeDetails.getName());
                  employee.setRole(employeeDetails.getRole());
                  return employee;
                })
                .orElseThrow(() ->
                        new EmployeeNotFoundException("Employee with ID " + employeeId + " NOT FOUND")
                );
    }

    public String removeEmployee(Long employeeId) {
        if (!employeeRepository.existsById(employeeId))
            throw new EmployeeNotFoundException("Employee with ID " + employeeId + " NOT FOUND");

        return "Employee with ID" + employeeId + " successfully removed";
    }
}
