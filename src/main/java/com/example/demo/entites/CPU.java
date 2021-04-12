package com.example.demo.entites;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Class that represents Central processing unit component of PC
 *
 * @version 1.0
 */
@Entity
public class CPU extends Component {
    /**
     * Variable that represents CPU frequency
     */
    private double frequency;
    /**
     * Variable representing core number of the processor
     */
    private int coreCount;

    /**
     * Empty constructor
     */
    public CPU() {
    }

    /**
     * @param name      name of the CPU
     * @param company   name of the manufacturer
     * @param price     price of the CPU
     * @param frequency frequency of the CPU
     * @param coreCount number of cores CPU have
     */
    public CPU(String name, String company, BigDecimal price, double frequency, int coreCount) {
        super(name, company, price);
        this.frequency = frequency;
        this.coreCount = coreCount;
    }

    /**
     * @return {@link CPU#frequency frequency variable} of the class {@link CPU CPU}
     */
    public double getFrequency() {
        return frequency;
    }

    /**
     * @param frequency initializes of changes value of the {@link CPU#frequency variable frequency}
     *                  in the class CPU
     */
    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    /**
     * @return number of cores this CPU have
     */
    public int getCoreCount() {
        return coreCount;
    }

    /**
     * @param coreCount initializes or changes number of cores this CPU have
     */
    public void setCoreCount(int coreCount) {
        this.coreCount = coreCount;
    }
}
