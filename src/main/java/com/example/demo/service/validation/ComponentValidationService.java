package com.example.demo.service.validation;

import com.example.demo.entites.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Service used to validate Components
 *
 * @version 1.0
 */
@Service
public class ComponentValidationService {
    private final Set<ComponentValidation> validations;

    @Autowired
    public ComponentValidationService(Set<ComponentValidation> validations) {
        this.validations = validations;
    }

    /**
     * @param component component object to be validated
     * @throws RequesterException in case if validation fails
     */
    public void validate(Component component) throws RequesterException {
        validations.forEach(validation -> validation.validate(component));
    }
}
