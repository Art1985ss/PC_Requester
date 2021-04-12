package com.example.demo.controller.dto;

public class DtoCPU extends DtoComponent {
    private double frequency;
    private int coreCount;

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public int getCoreCount() {
        return coreCount;
    }

    public void setCoreCount(int coreCount) {
        this.coreCount = coreCount;
    }
}
