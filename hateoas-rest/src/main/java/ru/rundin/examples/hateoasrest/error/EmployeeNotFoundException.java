package ru.rundin.examples.hateoasrest.error;

/**
 * @author Alexey Rundin
 * @since 11.12.2020
 */
public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
