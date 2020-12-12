package ru.rundin.examples.hateoasrest.error;

/**
 * @author Alexey Rundin
 * @since 12.12.2020
 */
public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(Long id) {
        super("Could not find order " + id);
    }
}
