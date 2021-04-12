package com.example.demo.entites;


import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Class represents random access memory component of the PC
 *
 * @version 1.0
 */
@Entity
public class RAM extends Component {
    /**
     * Variable represents capacity of the component in gigabytes (GB)
     */
    private int capacity;

    /**
     * Empty constructor
     */
    public RAM() {
    }

    /**
     * @param name     name of the ram
     * @param company  manufacturer of the ram
     * @param price    price of the ram
     * @param capacity memory capacity of the ram in gigabytes
     */
    public RAM(String name, String company, BigDecimal price, int capacity) {
        super(name, company, price);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
