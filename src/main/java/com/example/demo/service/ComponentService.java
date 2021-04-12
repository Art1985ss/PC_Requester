package com.example.demo.service;

import com.example.demo.entites.CPU;
import com.example.demo.entites.Component;
import com.example.demo.entites.Cooler;
import com.example.demo.entites.DataStorageDevice;
import com.example.demo.enums.DataStorageType;
import com.example.demo.repository.ComponentRepository;
import com.example.demo.service.validation.ComponentValidationService;
import com.example.demo.service.validation.RequesterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * Component service class
 * Used for component management
 *
 * @version 1.0
 */
@Service
public class ComponentService implements Findable<Component>, Writable<Component>, Erasable<Component> {
    /**
     * Component {@link ComponentRepository reposiory}
     */
    private final ComponentRepository componentRepository;
    /**
     * Validation {@link ComponentValidationService serice class}
     */
    private final ComponentValidationService validationService;

    @Autowired
    public ComponentService(ComponentRepository componentRepository, ComponentValidationService validationService) {
        this.componentRepository = componentRepository;
        this.validationService = validationService;
    }

    /**
     * Method used to save object data to db
     *
     * @param component to be saved in db
     * @return component with new id assigned
     * @throws RequesterException in case if validation failed
     */
    @Override
    public Component save(Component component) throws RequesterException {
        validationService.validate(component);
        return componentRepository.save(component);
    }

    /**
     * Method used to update object data in db
     *
     * @param component object that needs to be updated in db with new information
     * @return same object that was passed as parameter
     * @throws RequesterException in case if validation failed
     */
    @Override
    public Component update(Component component) throws RequesterException {
        validationService.validate(component);
        componentRepository.save(component);
        return component;
    }

    /**
     * @param name value to be used for search operation
     * @return object that have been found
     * @throws NoSuchElementException in case if no object with name exists
     */
    @Override
    public Component findByName(String name) throws NoSuchElementException {
        return componentRepository.findByName(name)
                .orElseThrow(() -> new NoSuchElementException("No component found with name " + name));
    }

    /**
     * @param company value to be used for search operation
     * @return object that have been found
     * @throws NoSuchElementException in case if no object exists with such company name
     */
    @Override
    public Component findByCompany(String company) throws NoSuchElementException {
        return componentRepository.findByCompany(company)
                .orElseThrow(() -> new NoSuchElementException("No component found with company name " + company));
    }

    /**
     * @param id value to be used for search operation
     * @return onject that have been found
     * @throws NoSuchElementException in case if no object exists with such id in database
     */
    @Override
    public Component findById(long id) throws NoSuchElementException {
        return componentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No component found with id " + id));
    }

    /**
     * Method used to retrieve all components from database
     *
     * @return list of all components in database
     */
    public List<Component> findAll() {
        return componentRepository.findAll();
    }

    @Override
    public void deleteByName(String name) throws NoSuchElementException {
        Optional<Component> component = componentRepository.findByName(name);
        component.ifPresentOrElse(componentRepository::delete,
                () -> {
                    throw new NoSuchElementException("No component with name " + name + " exists.");
                });
    }

    /**
     * Method that deletes component from database based on id
     *
     * @param id value representing id by which objects will be deleted
     */
    @Override
    public void deleteById(long id) {
        componentRepository.deleteById(id);
    }

    /**
     * Method that deletes all components from database
     */
    @Override
    public void deleteAll() {
        componentRepository.deleteAll();
    }

    /**
     * Method placeholder to fill db with some initial components
     */
    public void addComponents() {
        final String goodCompany = "Good company";
        final String badCompany = "Bad company";
        final BigDecimal hundred = BigDecimal.valueOf(100);
        final BigDecimal fiveHundred = BigDecimal.valueOf(500);

        try {
            Component component = new Cooler("Good cooler", goodCompany, fiveHundred, 400);
            save(component);
            component = new Cooler("Bad cooler", badCompany, hundred, 10);
            save(component);
            component = new CPU("Good CPU", goodCompany, fiveHundred, 2.5, 4);
            save(component);
            component = new CPU("Bad CPU", badCompany, hundred, 1.0, 1);
            save(component);
            component = new DataStorageDevice("Good disc", goodCompany, fiveHundred, 400, DataStorageType.SSD);
            save(component);
        } catch (RequesterException e) {
            e.printStackTrace();
        }
    }
}
