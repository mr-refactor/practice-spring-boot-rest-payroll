package com.practice.payroll.employee;

import static org.assertj.core.api.Assertions.assertThat;

import com.practice.payroll.employee.Employee;
import com.practice.payroll.employee.EmployeeService;
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

    /* TODO: figure out if we need to test for this or if it's a given
    with Java typing system */
    @Test
    public void getAllEmployeesShouldReturnListOfEmployees() {

    }

    @Test
    public void givenNewEmployeeAddNewEmployeeShouldAddNewEmployeeToDbAndReturnIt() {
        Employee joanna = new Employee("Joanna", "Server");
        Employee newEmployee = employeeService.addNewEmployee(joanna);
        assertThat(newEmployee.getName()).isEqualTo("Joanna");
        assertThat(newEmployee.getRole()).isEqualTo("Server");
    }


}
