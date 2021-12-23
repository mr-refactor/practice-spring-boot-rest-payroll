package com.practice.payroll.employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
        try {
            this.mockMvc.perform(get("/employees/"))
                    .andDo(print())
                    .andExpectAll(
                            status().isOk(),
                            content().contentType(MediaType.APPLICATION_JSON));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // TODO: Validate that response gives 201 to show it was created
    @Test
    public void givenNameAndRolePostEmployeesShouldReturnNewEmployee() {
        try {
            this.mockMvc.perform(post("/employees/")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(
                            "{ " +
                            "\"name\": \"Jane Doe\"," +
                            " \"role\": \"Server\" " +
                            "}"
                    ))
                    .andDo(print())
//                    .andExpect(status().isCreated())
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
