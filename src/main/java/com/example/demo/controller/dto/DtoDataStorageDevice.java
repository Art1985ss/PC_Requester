package com.example.demo.controller.dto;

import com.example.demo.enums.DataStorageType;

public class DtoDataStorageDevice extends DtoComponent{
    private int capacity;
    private DataStorageType type;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public DataStorageType getType() {
        return type;
    }

    public void setType(DataStorageType type) {
        this.type = type;
    }
}
