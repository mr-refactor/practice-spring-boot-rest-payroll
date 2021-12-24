package com.practice.payroll.employee;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.hamcrest.Matchers.hasSize;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @MockBean
    private EmployeeService employeeService;

    @Autowired
    EmployeeController employeeController;

    @Autowired
    private MockMvc mockMvc;

    // TODO: Refactor tests to check JSON response body is correct
    // currently only checking that status is ok and content type is json
    @Test
    public void getEmployees_ReturnsListOfEmployees() throws Exception {
        given(employeeService.getAllEmployees()).willReturn(EmployeeFactory.listOfEmployees());

        this.mockMvc.perform(get("/employees/"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("$", hasSize(2)),
                        jsonPath("$.[0].name").value("Milton Waddams"),
                        jsonPath("$.[0].role").value("drone"));

        verify(employeeService).getAllEmployees();
    }

    // TODO: Validate that response gives 201 to show it was created
    @Test
    public void postEmployees_ReturnsNewEmployee() throws Exception{

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
    }

//    @Test
//    public void getEmployeeShouldReturnEmployeeWithProperId() {
//        pathReturnsStatusOkAndContentTypeJSON("/employees/1");
//    }

}
