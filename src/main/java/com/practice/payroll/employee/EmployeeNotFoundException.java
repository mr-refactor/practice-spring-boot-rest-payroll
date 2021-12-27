package com.practice.payroll.employee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No Such Employee")
public class EmployeeNotFoundException extends IllegalArgumentException {

    public EmployeeNotFoundException(String message) {super();}
}
