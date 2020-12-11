package ru.rundin.examples.hateoasrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rundin.examples.hateoasrest.entity.Employee;

/**
 * @author Alexey Rundin
 * @since 11.12.2020
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
