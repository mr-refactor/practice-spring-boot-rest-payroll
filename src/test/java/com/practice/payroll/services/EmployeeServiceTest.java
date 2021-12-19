package com.practice.payroll.services;

import static org.assertj.core.api.Assertions.assertThat;

import com.practice.payroll.entities.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    public EmployeeService employeeService;

    @Test
    public void serviceLoads(){
        assertThat(employeeService).isNotNull();
    }

    /* TODO: figure out if we need to test for this or if it's a given
    with Java typing system */
    @Test
    public void getAllEmployeesShouldReturnListOfEmployees() {
    }


}
