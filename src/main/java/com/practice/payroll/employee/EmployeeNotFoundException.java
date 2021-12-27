package com.practice.payroll.employee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class EmployeeNotFoundException extends IllegalArgumentException {

    public EmployeeNotFoundException(Long employeeId) {
        super("Employee with ID " + employeeId + " NOT FOUND");
    }

    public EmployeeNotFoundException(String customMessage) {super(customMessage);}
}
