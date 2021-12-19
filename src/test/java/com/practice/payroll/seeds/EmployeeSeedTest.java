package com.practice.payroll.seeds;

import static org.assertj.core.api.Assertions.assertThat;

import com.practice.payroll.entities.Employee;
import com.practice.payroll.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class EmployeeSeedTest {

    @Autowired
    EmployeeRepository employeeRepo;

    @Test
    void dbShouldLoadTwoEmployees(){
        List<Employee> employees = employeeRepo.findAll();
        assertThat(employees.size()).isEqualTo(2);
    }
}
