package com.example.databasesecurity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository repository;

    @Test
    void searchesEmployeeName() {
        repository.deleteAll();
        repository.save(new Employee("Alex Morgan", "alex@example.com"));
        assertThat(repository.findByNameIgnoreCase("alex morgan")).hasSize(1);
    }

    @Test
    void sqlInputIsNotExecuted() {
        repository.deleteAll();
        repository.save(new Employee("Alex Morgan", "alex@example.com"));
        assertThat(repository.findByNameIgnoreCase("' OR '1'='1")).isEmpty();
    }
}
