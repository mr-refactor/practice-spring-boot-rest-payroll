package com.practice.payroll.employee;

import java.util.List;

public class EmployeeFactory {
    private static final Employee MILTON = new Employee(
            "Milton Waddams",
            "drone");
    private static final Employee PETER = new Employee(
            "Peter Gibbons",
            "programmer");
    private static final Employee MILTON_UNHINGED = new Employee(
            "Enraged Milton Waddams",
            "arsonist");

    public static List<Employee> listOfEmployees(){
        return List.of(MILTON, PETER);
    }

    public static Employee getMilton() { return MILTON; }

    public static Employee getMiltonUnhinged() {return MILTON_UNHINGED; }
}
