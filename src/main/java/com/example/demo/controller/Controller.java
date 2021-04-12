package com.example.demo.controller;

import com.example.demo.entites.Component;
import com.example.demo.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Basic controller
 *
 * @version 1.0
 */
@RestController
public class Controller {
    ComponentService service;

    @Autowired
    public Controller(ComponentService service) {
        this.service = service;
    }

    /**
     * @return view with main menu
     */
    @GetMapping
    public ModelAndView initial() {
        return new ModelAndView("index");
    }

}
