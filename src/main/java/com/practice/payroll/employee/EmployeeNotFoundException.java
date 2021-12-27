package com.practice.payroll.employee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class EmployeeNotFoundException extends IllegalArgumentException {

    public EmployeeNotFoundException(String message) {super(message);}
}
