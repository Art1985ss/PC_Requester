package com.example.demo.service;

import com.example.demo.service.validation.RequesterException;

/**
 * Interface describing methods to save or update objects
 *
 * @param <T> generic class
 */
public interface Writable<T> {
    /**
     * @param t object to be saved
     * @return saved object with id field initialized
     * @throws RequesterException if object failed validation
     */
    T save(T t) throws RequesterException;

    /**
     * @param t object that have been changed and needs to be updated in db
     * @return updated object
     * @throws RequesterException if object failed validation
     */
    T update(T t) throws RequesterException;
}
