package com.example.demo.controller.dto;

import com.example.demo.enums.OrderState;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DtoOrder {
    private long id;
    private List<DtoComponent> components = new ArrayList<>();
    private String justification;
    private LocalDateTime registrationDate;
    private OrderState state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<DtoComponent> getComponents() {
        return components;
    }

    public void setComponents(List<DtoComponent> components) {
        this.components = components;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }
}
