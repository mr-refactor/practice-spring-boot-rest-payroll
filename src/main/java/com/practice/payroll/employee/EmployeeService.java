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

    public Employee getEmployeeDetails(long id) {
       return employeeRepository.findById(id)
               .orElseThrow( () ->
                    new EmployeeNotFoundException("Employee with ID " + id + " NOT FOUND"));
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
}
