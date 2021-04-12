package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Interface describing methods for search operation
 *
 * @param <T> generic class
 * @version 1.0
 */
public interface Findable<T> {
    /**
     * Method for searching of the object based on id value
     *
     * @param id value to be used for search operation
     * @return resulting object
     * @throws NoSuchElementException if no object was found
     */
    T findById(long id) throws NoSuchElementException;

    /**
     * Method for searching based on name value
     *
     * @param name value to be used for search operation
     * @return resulting object
     * @throws NoSuchElementException if no object was found
     */
    T findByName(String name) throws NoSuchElementException;

    /**
     * Method for searching of object based on company value
     *
     * @param company value to be used for search operation
     * @return resulting object
     * @throws NoSuchElementException if no object was found
     */
    T findByCompany(String company) throws NoSuchElementException;

    /**
     * Method for searching list of all objects
     *
     * @return list of objects
     */
    List<T> findAll();
}
