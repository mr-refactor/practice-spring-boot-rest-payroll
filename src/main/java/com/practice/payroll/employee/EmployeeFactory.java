package com.practice.payroll.employee;

import java.util.List;

public class EmployeeFactory {
    private static final Employee MILTON = new Employee(
            "Milton Waddams",
            "drone");
    private static final Employee PETER = new Employee(
            "Peter Gibbons",
            "programmer");

    public static List<Employee> listOfEmployees(){
        return List.of(MILTON, PETER);
    }
}
