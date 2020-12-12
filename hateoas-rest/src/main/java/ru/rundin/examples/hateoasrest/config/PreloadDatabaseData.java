package ru.rundin.examples.hateoasrest.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.rundin.examples.hateoasrest.entity.Employee;
import ru.rundin.examples.hateoasrest.entity.Order;
import ru.rundin.examples.hateoasrest.entity.Status;
import ru.rundin.examples.hateoasrest.repository.EmployeeRepository;
import ru.rundin.examples.hateoasrest.repository.OrderRepository;

/**
 * @author Alexey Rundin
 * @since 11.12.2020
 */
@Slf4j
@Configuration
public class PreloadDatabaseData {

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository) {
        return args -> {
            log.info("Preloading " + employeeRepository.save(new Employee("Petya", "Pipkin", "Manager")));
            log.info("Preloading " + employeeRepository.save(new Employee("Fedor", "Sumkins", "Director")));
            log.info("Preloading " + employeeRepository.save(new Employee("Vasya", "Pupkin", "Driver")));

            employeeRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));

            orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
            orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));

            orderRepository.findAll().forEach(order -> log.info("Preloaded " + order));
        };
    }
}
