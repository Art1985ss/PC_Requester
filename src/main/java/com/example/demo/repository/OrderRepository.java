package com.example.demo.repository;

import com.example.demo.entites.Order;
import com.example.demo.enums.OrderState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Order repository
 *
 * @version 1.0
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    /**
     * @param state {@link OrderState enum} representing of the order
     * @return list of orders with state
     */
    List<Order> findByState(OrderState state);

}
