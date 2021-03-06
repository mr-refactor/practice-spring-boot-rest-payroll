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
import static org.mockito.Mockito.any;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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

    @Test
    public void indexEmployees_returnsListOfEmployees() throws Exception {
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

    @Test
    public void showEmployee_returnsTheExistingEmployee() throws Exception {
        given(employeeService.getEmployeeDetails(1L)).willReturn(EmployeeFactory.getMilton());

        this.mockMvc.perform(get("/employees/1"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("$.name").value("Milton Waddams"),
                        jsonPath("$.role").value("drone")
                );

        verify(employeeService).getEmployeeDetails(1L);
    }

    @Test
    public void showEmployee_returns404GivenInvalidID() throws Exception {
        given(employeeService.getEmployeeDetails(99))
                .willThrow(new EmployeeNotFoundException(99L));

        this.mockMvc.perform(get("/employees/99"))
                .andDo(print())
                .andExpectAll(
                        status().isNotFound(),
                        jsonPath("$").isNotEmpty()
                );

        verify(employeeService).getEmployeeDetails(99L);
    }

    // TODO: Validate that response gives 201 to show it was created
    @Test
    public void createEmployee_returnsNewEmployee() throws Exception{
        Employee milton = EmployeeFactory.getMilton();
        given(employeeService.addNewEmployee(milton))
                .willReturn(milton);

        this.mockMvc.perform(post("/employees/")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(
                            "{ " +
                            "\"name\": \"Milton Waddams\"," +
                            " \"role\": \"drone\" " +
                            "}"
                    ))
                    .andDo(print())
//                    .andExpect(status().isCreated())
                    .andExpectAll(
                            status().isOk(),
                            content().contentType(MediaType.APPLICATION_JSON),
                            jsonPath("$.name").value("Milton Waddams"),
                            jsonPath("$.role").value("drone")
                    );

        verify(employeeService).addNewEmployee(milton);
    }

    @Test
    public void updateEmployee_returnsNewEmployee() throws Exception {
        Long employeeId = 1L;
        Employee miltonUnhinged = EmployeeFactory.getMiltonUnhinged();
        given(employeeService.updateEmployeeDetails(employeeId, miltonUnhinged))
                .willReturn(miltonUnhinged);

        this.mockMvc.perform(put("/employees/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                        "{ " +
                                "\"name\": \"Enraged Milton Waddams\"," +
                                " \"role\": \"arsonist\" " +
                                "}"
                ))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("$.name").value("Enraged Milton Waddams"),
                        jsonPath("$.role").value("arsonist")
                );

        verify(employeeService).updateEmployeeDetails(employeeId, miltonUnhinged);
    }

    @Test void updateEmployee_returns404GivenInvalidID() throws Exception{
        given(employeeService.updateEmployeeDetails(any(Long.class), any(Employee.class)))
                .willThrow(new EmployeeNotFoundException(99L));

        this.mockMvc.perform(put("/employees/99")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                        "{ " +
                            "\"name\": \"Enraged Milton Waddams\"," +
                            " \"role\": \"arsonist\" " +
                        "}"
                ))
                    .andDo(print())
                    .andExpectAll(
                        status().isNotFound(),
                        jsonPath("$").isNotEmpty()
                    );

        verify(employeeService).updateEmployeeDetails(any(Long.class), any(Employee.class));
    }

    @Test void deleteEmployee_returnsSuccessMessage() throws Exception {
        Long employeeId = 1L;
        given(employeeService.removeEmployee(employeeId))
                .willReturn("Employee with ID " + employeeId + " has been removed");

        this.mockMvc.perform(delete("/employees/1"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        jsonPath("$").isNotEmpty());

        verify(employeeService).removeEmployee(employeeId);
    }
}
