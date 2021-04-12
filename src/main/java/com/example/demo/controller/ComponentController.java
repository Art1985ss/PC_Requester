package com.example.demo.controller;

import com.example.demo.entites.Order;
import com.example.demo.service.ComponentService;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Component controller used for components endpoints
 *
 * @version 1.0
 */
@RestController
@RequestMapping("/components")
public class ComponentController {
    private final ComponentService componentService;
    private final OrderService orderService;

    @Autowired
    public ComponentController(ComponentService componentService, OrderService orderService) {
        this.componentService = componentService;
        this.orderService = orderService;
    }

    /**
     * @param orderId optional parameter to be used for view
     * @return reusable view to list components in database or in order if order id passed as parameter
     */
    @GetMapping
    public ModelAndView getAllComponents(@RequestParam(required = false) Long orderId) {
        Order order = null;
        ModelAndView modelAndView = new ModelAndView("components");
        if (orderId != null) {
            order = orderService.findById(orderId);
        }
        modelAndView.addObject("title", "Components");
        modelAndView.addObject("order", order);
        modelAndView.addObject("components", componentService.findAll());
        return modelAndView;
    }

    /**
     * @param id value that will be used to delete component
     * @return redirection to {@link ComponentController#getAllComponents(Long)  endpoint} that lists all components
     */
    @GetMapping("/delete")
    public RedirectView deleteById(@RequestParam long id) {
        componentService.deleteById(id);
        return new RedirectView("/components");
    }
}
