package com.example.demo.entites;

import com.example.demo.enums.DataStorageType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

/**
 * Class represents long term data storage component of PC
 *
 * @version 1.0
 */
@Entity
public class DataStorageDevice extends Component {
    /**
     * Variable representing data storage capacity in gigabytes (GB)
     */
    private int capacity;
    /**
     * {@link DataStorageType Enum} representing type of data storage
     */
    @Enumerated(value = EnumType.STRING)
    private DataStorageType type;

    /**
     * Empty constructor
     */
    public DataStorageDevice() {
    }

    /**
     * @param name     name of the storage device
     * @param company  name of the manufacturer
     * @param price    price of the storage device
     * @param capacity storage capacity GB
     * @param type     enum {@link DataStorageType storage type} of the device
     */
    public DataStorageDevice(String name, String company, BigDecimal price, int capacity, DataStorageType type) {
        super(name, company, price);
        this.capacity = capacity;
        this.type = type;
    }

    /**
     * @return storage capacity of this storage device
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity sets new value for the storage capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * @return current storage {@link DataStorageType type} of this long term memory
     */
    public DataStorageType getType() {
        return type;
    }

    /**
     * @param type initializes or changes storage {@link DataStorageType type} of long term memory
     */
    public void setType(DataStorageType type) {
        this.type = type;
    }
}
