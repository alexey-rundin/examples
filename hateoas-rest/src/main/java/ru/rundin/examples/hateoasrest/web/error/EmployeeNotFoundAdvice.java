package ru.rundin.examples.hateoasrest.web.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.rundin.examples.hateoasrest.error.EmployeeNotFoundException;

/**
 * @author Alexey Rundin
 * @since 11.12.2020
 */
@ControllerAdvice
public class EmployeeNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String employeeNotFoundHandler(EmployeeNotFoundException employeeNotFoundException) {
        return employeeNotFoundException.getMessage();
    }
}
