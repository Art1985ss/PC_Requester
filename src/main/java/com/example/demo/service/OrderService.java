package com.example.demo.service;

import com.example.demo.entites.Component;
import com.example.demo.entites.Order;
import com.example.demo.enums.OrderState;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Order service
 * Used to manage orders
 *
 * @version 1.0
 */
@Service
public class OrderService {
    /**
     * Order {@link OrderRepository repository}
     */
    private final OrderRepository orderRepository;
    /**
     * {@link ComponentService Component service}
     * Used for adding and removing components from order objects
     */
    private final ComponentService componentService;

    @Autowired
    public OrderService(OrderRepository orderRepository, ComponentService componentService) {
        this.orderRepository = orderRepository;
        this.componentService = componentService;
    }

    /**
     * Method used to save orders in database
     *
     * @param order object that needs to be saved in database
     * @return same object with id assigned
     */
    public Order save(Order order) {
        order.setRegistrationDate(LocalDateTime.now());
        return orderRepository.save(order);
    }

    /**
     * Method used to update information in database
     *
     * @param order object that needs to update it's information in database
     * @return same object
     */
    public Order update(Order order) {
        if (order.getRegistrationDate() == null) {
            order.setRegistrationDate(LocalDateTime.now());
        }
        return orderRepository.save(order);
    }

    /**
     * Method used to retrieve all objects
     *
     * @return list of all orders in database
     */
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    /**
     * @param id value to be used for search
     * @return object that have been retrieved from database
     * @throws NoSuchElementException if no object have been found with id
     */
    public Order findById(long id) throws NoSuchElementException {
        return orderRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No order found with id " + id));
    }

    /**
     * Method used to delete object from database based on id
     *
     * @param id value to be used for deleting order object
     */
    public void deleteById(long id) {
        orderRepository.deleteById(id);
    }

    /**
     * @param orderId     {@link Order order} id that will be used for removing component from it
     * @param componentId {@link Component component} id that will be used to find component to be removed from the order object
     * @throws NoSuchElementException in case if component or order haven't been found
     */
    public void removeComponent(long orderId, long componentId) throws NoSuchElementException {
        Order order = findById(orderId);
        Component component = order.getComponents().stream()
                .filter(comp -> comp.getId() == componentId)
                .peek(System.out::println)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("Order number " + orderId + " does not contain component id " + componentId));
        if (component != null) {
            System.out.println(order);
            order.getComponents().remove(component);
            orderRepository.save(order);
        }
    }

    /**
     * @param orderId     {@link Order order} id that will be used for adding component to it
     * @param componentId {@link Component component} id that will be used to find component to be added to the order object
     * @throws NoSuchElementException in case if component or order haven't been found
     */
    public void addComponent(long orderId, long componentId) throws NoSuchElementException {
        Order order = findById(orderId);
        Component component = componentService.findById(componentId);
        order.getComponents().add(component);
        orderRepository.save(order);
    }

    /**
     * Method that removes all orders that have {@link OrderState state} status in_process
     * and order exists longer than one hour
     */
    public void clearInProcess() {
        List<Order> orders = orderRepository.findByState(OrderState.IN_PROCESS);
        orders.stream()
                .filter(order -> order.getRegistrationDate().plusHours(1).isBefore(LocalDateTime.now()))
                .forEach(order -> deleteById(order.getId()));
    }
}
