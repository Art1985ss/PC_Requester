package com.example.demo.enums;

/**
 * Enum representing order states
 */
public enum OrderState {
    /**
     * User still filling thins order and this order valid for removing if not submitted in reasonable time
     */
    IN_PROCESS,
    /**
     * Order is submitted and should be processed
     */
    //TODO remove manage ability from orders with such state
    SUBMITTED
}
