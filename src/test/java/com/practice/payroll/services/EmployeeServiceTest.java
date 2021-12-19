package com.practice.payroll.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    public EmployeeService employeeService;

    @Test
    public void serviceLoads(){
        assertThat(employeeService).isNotNull();
    }


}
