package com.example.demo.entites;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Class that represents motherboard component of pc
 *
 * @version 1.0
 */
@Entity
public class Motherboard extends Component {
    /**
     * Number of ram slots
     */
    private int ramSlotsCount;

    /**
     * Empty constructor
     */
    public Motherboard() {
    }

    /**
     * @param name          name of the motherboard
     * @param company       name of the manufacturer
     * @param price         price of the motherboard
     * @param ramSlotsCount number of ram slots of this motherboard
     */
    public Motherboard(String name, String company, BigDecimal price, int ramSlotsCount) {
        super(name, company, price);
        this.ramSlotsCount = ramSlotsCount;
    }

    public int getRamSlotsCount() {
        return ramSlotsCount;
    }

    public void setRamSlotsCount(int ramSlotsCount) {
        this.ramSlotsCount = ramSlotsCount;
    }
}
