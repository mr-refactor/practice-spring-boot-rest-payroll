package com.practice.payroll.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import com.practice.payroll.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeControllerTest {

    @Autowired
    public EmployeeController employeeController;

    @Test
    void controllerLoads() {
        assertThat(employeeController).isNotNull();
    }

}
