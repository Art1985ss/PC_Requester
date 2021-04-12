package com.example.demo.entites;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Base abstract class representing basic information about components
 *
 * @version 1.0
 */
@Entity(name = "Component")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Component {
    /**
     * Id of the component
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /**
     * Name of the product
     */
    private String name;
    /**
     * Name of the component manufacturer
     */
    private String company;
    /**
     * Variable representing price of the component in euros (EURO)
     */
    private BigDecimal price;

    @ManyToMany
    @JoinTable(name = "order_components",
            joinColumns = @JoinColumn(name = "component_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private List<Order> order = new ArrayList<>();

    /**
     * Empty constructor
     */
    public Component() {
    }

    /**
     * Constructor with all fields included
     *
     * @param name    name of the component
     * @param company name of the manufacturer
     * @param price   price of the component
     */
    public Component(String name, String company, BigDecimal price) {
        this.name = name;
        this.company = company;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return {@link Component#name variable name}
     * of the class {@link Component Component}
     */
    public String getName() {
        return name;
    }

    /**
     * @param name value to initialize variable {@link Component#name name}
     *             of the class {@link Component Component}
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return {@link Component#company variable company}
     * of the class {@link Component Component}
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company value to initialize or change variable {@link Component#company}
     *                of the class {@link Component Component}
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return {@link Component#price variable price}
     * of the class {@link Component Component}
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price value to initialize or change variable {@link Component#price}
     *              of the class {@link Component Component}
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Component component = (Component) o;
        return id == component.id && name.equals(component.name) && company.equals(component.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, company);
    }
}
