package com.example.demo.repository;

import java.util.Optional;

/**
 * @param <T> interface to expand
 */
public interface Searcher<T> {
    Optional<T> findByName(String name);

    Optional<T> findByCompany(String company);
}
