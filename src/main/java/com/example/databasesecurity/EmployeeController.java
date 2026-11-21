package com.example.databasesecurity;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    @GetMapping("/search")
    public List<Employee> searchEmployees(@RequestParam String name) {
        return repository.findByNameIgnoreCase(name);
    }
}
