package com.example.databasesecurity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DatabaseSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseSecurityApplication.class, args);
    }

    @Bean
    CommandLineRunner addSampleEmployees(EmployeeRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new Employee("Alex Morgan", "alex@example.com"));
                repository.save(new Employee("Jamie Patel", "jamie@example.com"));
                repository.save(new Employee("Taylor Chen", "taylor@example.com"));
            }
        };
    }
}
