package com.example.demo.enums;


/**
 * Enum representing all available component types
 * Used to fill up view
 *
 * @version 1.0
 */
public enum ComponentType {
    COOLER("Cooler", "cooler"),
    CPU("Central processing unit", "cpu"),
    DATA_STORAGE_DEVICE("Long term memory storage", "hdd"),
    MOTHERBOARD("Motherboard", "motherboard"),
    POWER_SUPPLY("Power supply unit", "power_supply"),
    RAM("Random access memory (RAM)", "ram"),
    VIDEO_CARD("Video card", "video_card");


    /**
     * Full name of the component
     */
    private final String fullName;
    /**
     * url used for further usage leading to endpoint
     */
    private final String url;

    ComponentType(String fullName, String url) {
        this.fullName = fullName;
        this.url = "add_component/" + url;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return fullName;
    }
}
