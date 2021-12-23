package com.practice.payroll.employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {

    private static final Logger log = LoggerFactory.getLogger(EmployeeConfig.class);

    @Bean
    CommandLineRunner seedDbWithEmployees(EmployeeRepository repository) {
        return args -> {
            log.info("Preloading "
                    + repository.save(
                            new Employee(
                                    "Milton Waddams",
                                    "drone")
            ));
            log.info("Preloading "
                    + repository.save(
                            new Employee(
                                    "Peter Gibbons",
                                    "programmer")
            ));
        };
    }
}
