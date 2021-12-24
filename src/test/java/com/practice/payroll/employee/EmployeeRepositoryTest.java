package com.practice.payroll.employee;

import com.fasterxml.jackson.annotation.OptBoolean;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void findByName_returnsCar() {
        Employee savedEmployee = entityManager.persistFlushFind(new Employee("Bob Porter", "Supervisor"));
        Optional<Employee> bob = employeeRepository.findByName("Bob Porter");

        assertThat(bob.isPresent()).isTrue();
        assertThat(bob.get().getName()).isEqualTo(savedEmployee.getName());
        assertThat(bob.get().getRole()).isEqualTo(savedEmployee.getRole());
    }
}
