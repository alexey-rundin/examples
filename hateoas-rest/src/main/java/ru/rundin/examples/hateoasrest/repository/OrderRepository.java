package ru.rundin.examples.hateoasrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rundin.examples.hateoasrest.entity.Order;

/**
 * @author Alexey Rundin
 * @since 12.12.2020
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
