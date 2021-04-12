package com.example.demo.entites;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Class representing colling component of the PC
 *
 * @version 1.0
 */
@Entity
public class Cooler extends Component {
    /**
     * Variable representing cooling capacity of the cooler
     */
    private int coolingCapacity;

    /**
     * Empty constructor
     */
    public Cooler() {
    }

    /**
     * @param name            name of the component
     * @param company         name of the manufacturer
     * @param price           price of the component
     * @param coolingCapacity cooling capacity of the cooler
     */
    public Cooler(String name, String company, BigDecimal price, int coolingCapacity) {
        super(name, company, price);
        this.coolingCapacity = coolingCapacity;
    }

    /**
     * @return {@link Cooler#coolingCapacity cooling capacity variable} of the class {@link Cooler Cooler}
     */
    public int getCoolingCapacity() {
        return coolingCapacity;
    }

    /**
     * @param coolingCapacity Value to initialize or change {@link Cooler#coolingCapacity variable} of the class {@link Cooler Cooler}
     */
    public void setCoolingCapacity(int coolingCapacity) {
        this.coolingCapacity = coolingCapacity;
    }
}
