package com.practice.payroll.entities;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
public class EmployeeTest {

    @Autowired
    private Employee employee;

    @Test
    public void employeeLoads() {
        assertThat(employee).isNotNull();
    }
}
