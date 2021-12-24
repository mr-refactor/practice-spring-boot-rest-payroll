package com.practice.payroll.employee;

import static org.assertj.core.api.Assertions.assertThat;

import com.practice.payroll.employee.Employee;
import com.practice.payroll.employee.EmployeeService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    private EmployeeService employeeService;

    @Before
    public void setup() {
        this.employeeService = new EmployeeService(employeeRepository);
    }

    @Test
    public void getAllEmployees_ReturnsListOfEmployees() {
        given(employeeRepository.findAll()).willReturn(EmployeeFactory.listOfEmployees());

    }

    /* TODO: figure out if we need to test for this or if it's a given
    with Java typing system */


}
