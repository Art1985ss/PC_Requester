package com.example.demo.entites;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Class represents video card component of the PC
 *
 * @version 1.0
 */
@Entity
public class VideoCard extends Component {
    /**
     * Variable represents GPU speed of the video card in Megahertz (MHz)
     */
    private int gpuSpeed;

    /**
     * Empty constructor
     */
    public VideoCard() {
    }

    /**
     * @param name     name of the video card
     * @param company  manufacturer of the video card
     * @param price    price of the video card
     * @param gpuSpeed gpu speed of the video card (MHz)
     */
    public VideoCard(String name, String company, BigDecimal price, int gpuSpeed) {
        super(name, company, price);
        this.gpuSpeed = gpuSpeed;
    }

    public int getGpuSpeed() {
        return gpuSpeed;
    }

    public void setGpuSpeed(int gpuSpeed) {
        this.gpuSpeed = gpuSpeed;
    }
}
