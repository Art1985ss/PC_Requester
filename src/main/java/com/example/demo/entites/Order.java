package com.example.demo.entites;

import com.example.demo.enums.OrderState;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing order application
 */
@Entity(name = "order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /**
     * List of components that were ordered by this application
     */
    @ManyToMany
    @JoinTable(
            name = "order_components",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "component_id")
    )
    private List<Component> components = new ArrayList<>();
    /**
     * Justification for this order
     */
    private String justification;
    /**
     * Date when order created
     */
    private LocalDateTime registrationDate;
    /**
     * Value representing state of order
     */
    @Enumerated(EnumType.STRING)
    private OrderState state;

    /**
     * Empty constructor
     */
    public Order() {
        state = OrderState.IN_PROCESS;
    }

    public Order(List<Component> components, String justification, LocalDateTime registrationDate) {
        this.components = components;
        this.justification = justification;
        this.registrationDate = registrationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public BigDecimal getTotalPrice() {
        return components.stream()
                .map(Component::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
