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
import static org.hamcrest.Matchers.any;
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

    @Test
    public void addNewEmployee_ReturnsNewEmployee(){
        Employee milton = EmployeeFactory.getMilton();
        given(employeeRepository.save(milton)).willReturn(milton);

        Employee newEmployee = employeeService.addNewEmployee(milton);

        assertThat(newEmployee).isEqualTo(milton);
    }

    // TODO: not sure how to test updateEmployee since
    //  it's transactional and doesn't call employeeRepository directly

}
