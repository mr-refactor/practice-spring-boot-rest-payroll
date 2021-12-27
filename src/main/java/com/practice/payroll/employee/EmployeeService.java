package com.practice.payroll.employee;

import com.practice.payroll.employee.Employee;
import com.practice.payroll.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Object getEmployeeDetails(long l) {
        return null;
    }
}
