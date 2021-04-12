package com.example.demo.service.validation;

import com.example.demo.entites.Component;

public interface ComponentValidation {
    void validate(Component component);

    default void checkNull(Component component) {
        if (component == null) {
            throw new RequesterException("Component should not be null");
        }
    }
}
