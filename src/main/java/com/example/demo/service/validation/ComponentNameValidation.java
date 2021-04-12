package com.example.demo.service.validation;

import com.example.demo.entites.Component;
import com.example.demo.repository.ComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Component
public class ComponentNameValidation implements ComponentValidation {
    private final ComponentRepository componentRepository;

    @Autowired
    public ComponentNameValidation(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }

    @Override
    public void validate(Component component) throws RequesterException {
        checkNull(component);
        checkIfUnique(component.getName());
    }

    public void checkIfUnique(String name) {
        if (componentRepository.findByName(name).isPresent()) {
            throw new RequesterException("Name of the component should be unique");
        }
    }
}
