package com.practice.payroll.controllers;


import com.practice.payroll.constants.Globals;
import com.practice.payroll.entities.Employee;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getEmployeesShouldReturnListOfEmployees() {
        List<Employee> employeeList = getResponseFromEndpointAsEmployeeList();
        System.out.println(employeeList);
        if (employeeList.size() > 0) {
            Employee employee = employeeList.get(0);
            assert(employee instanceof Employee);
        }
    }

    private List<Employee> getResponseFromEndpointAsEmployeeList() {
        ResponseEntity<List<Employee>> response = this.restTemplate
                .exchange(
                        Globals.LOCAL_URL + this.port + "/employees/",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Employee>>() {});
        return response.getBody();
    }


}
