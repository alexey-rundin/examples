package ru.rundin.examples.hateoasrest.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.rundin.examples.hateoasrest.entity.Employee;
import ru.rundin.examples.hateoasrest.error.EmployeeNotFoundException;
import ru.rundin.examples.hateoasrest.repository.EmployeeRepository;

import java.util.List;

/**
 * @author Alexey Rundin
 * @since 11.12.2020
 */
@RestController
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    @GetMapping("employees")
    public List<Employee> all() {
        return employeeRepository.findAll();
    }

    @PostMapping("/employees")
    public Employee newEmployee(@RequestBody Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    @GetMapping("/employees/{id}")
    public Employee one(@PathVariable Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PutMapping("/employees/{id}")
    public Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return employeeRepository.save(newEmployee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return employeeRepository.save(newEmployee);
                });
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }
}
