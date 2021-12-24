package com.practice.payroll.employee;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    private EmployeeService employeeService;

    @BeforeEach
    public void setup() {
        this.employeeService = new EmployeeService(employeeRepository);
    }

    @Test
    public void serviceLoads() {
        assertThat(this.employeeService).isNotNull();
    }

    @Test
    public void getAllEmployees_ReturnsListOfEmployees() {
        given(employeeRepository.findAll()).willReturn(EmployeeFactory.listOfEmployees());

        List<Employee> employees = employeeService.getAllEmployees();

        assertThat(employees.size()).isEqualTo(2);
    }

    /* TODO: figure out if we need to test for this or if it's a given
    with Java typing system */


}
