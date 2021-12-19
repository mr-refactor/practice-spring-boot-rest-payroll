package com.practice.payroll.controllers;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

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
        getPathReturnsStatusOkAndContentTypeJSON("/employees/");
    }


    @Test
    public void givenNameAndRolePostEmployeesShouldReturnNewEmployee() {
        postPathReturnsStatusOkAndContentTypeJSON("/employees/");
    }

//    @Test
//    public void getEmployeeShouldReturnEmployeeWithProperId() {
//        pathReturnsStatusOkAndContentTypeJSON("/employees/1");
//    }


    private void getPathReturnsStatusOkAndContentTypeJSON(String path) {
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

    // TODO: Validate that response gives 201 to show it was created
    private void postPathReturnsStatusOkAndContentTypeJSON(String path) {
        try {
            this.mockMvc.perform(post(path)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{ \"name\": \"Jane Doe\", \"role\": \"Server\" }"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
