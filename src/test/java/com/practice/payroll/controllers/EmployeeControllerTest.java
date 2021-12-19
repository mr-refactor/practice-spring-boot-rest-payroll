package com.practice.payroll.controllers;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // TODO: Refactor tests to check JSON response body is correct
    // currently only checking that status is ok and content type is json
    @Test
    public void getEmployeesShouldReturnListOfEmployees() {
        pathReturnsStatusOkAndContentTypeJSON("/employees/");
    }

    private void pathReturnsStatusOkAndContentTypeJSON(String path) {
        try {
            this.mockMvc.perform(get(path))
                    .andDo(print())
                    .andExpectAll(
                            status().isOk(),
                            content().contentType(MediaType.APPLICATION_JSON));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void getEmployeeShouldReturnEmployeeWithProperId() {
//        pathReturnsStatusOkAndContentTypeJSON("/employees/1");
//    }

}
