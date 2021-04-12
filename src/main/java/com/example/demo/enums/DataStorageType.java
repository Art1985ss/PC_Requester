package com.example.demo.enums;

/**
 * Enum represents type of long term data storage
 *
 * @version 1.0
 */
public enum DataStorageType {
    /**
     * Solid-state drive
     */
    SSD("Solid-state drive"),
    /**
     * Hard disk drive
     */
    HDD("Hard disk drive");

    /**
     * Variable represents full name of the enum
     */
    private final String fullName;

    /**
     * Constructor of the enum
     *
     * @param fullName full name of the enum
     */
    DataStorageType(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Method to retrieve full name of the device
     *
     * @return full name of the enum as String type
     */
    public String getFullName() {
        return fullName;
    }
}
