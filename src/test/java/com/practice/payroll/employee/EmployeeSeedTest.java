package com.practice.payroll.employee;

import static org.assertj.core.api.Assertions.assertThat;

import com.practice.payroll.employee.Employee;
import com.practice.payroll.employee.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class EmployeeSeedTest {

    @Autowired
    public EmployeeRepository employeeRepo;

    @Test
    void dbShouldLoadTwoEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        assertThat(employees.size()).isEqualTo(2);
    }

    @Test
    void givenMiltonFirstEmployeeShouldBeMilton() {
        Employee milton = employeeRepo.findById(1L)
                .orElseThrow(() -> new RuntimeException());
        assertThat(milton.getName()).isEqualTo("Milton Waddams");
    }

    @Test
    void givenPeterSecondEmployeeShouldBePeter() {
        Employee peter = employeeRepo.findById(2L)
                .orElseThrow(() -> new RuntimeException());
        assertThat(peter.getName()).isEqualTo("Peter Gibbons");
    }
}
