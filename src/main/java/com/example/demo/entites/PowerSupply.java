package com.example.demo.entites;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Class representing power supply unit
 *
 * @version 1.0
 */
@Entity
public class PowerSupply extends Component {
    /**
     * Variable representing capacity of the power supply unit in watts (W)
     */
    private int capacity;

    /**
     * Empty constructor
     */
    public PowerSupply() {
    }

    /**
     * @param name     name of the power supply unit
     * @param company  name of the manufacturer
     * @param price    price of the power supply unit
     * @param capacity capacity of the power supply units in watts (W)
     */
    public PowerSupply(String name, String company, BigDecimal price, int capacity) {
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
