package com.example.demo.service;

import java.util.NoSuchElementException;

/**
 * Interface describing delete operations
 *
 * @param <T> generic class
 * @version 1.0
 */
public interface Erasable<T> {
    /**
     * Method that deletes based on name value
     *
     * @param name value representing name by which should objects will be deleted
     */
    void deleteByName(String name) throws NoSuchElementException;

    /**
     * Method that deletes based on id value
     *
     * @param id value representing id by which objects will be deleted
     */
    void deleteById(long id);

    /**
     * Method that deletes all entities of the class
     */
    void deleteAll();
}
