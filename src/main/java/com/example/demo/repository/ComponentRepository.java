package com.example.demo.repository;

import com.example.demo.entites.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for basic {@link Component Component} class
 *
 * @version 1.0
 */
@Repository
public interface ComponentRepository extends JpaRepository<Component, Long>, Searcher<Component> {
}
