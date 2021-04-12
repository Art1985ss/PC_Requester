package com.example.demo.controller;

import com.example.demo.controller.dto.DtoConverter;
import com.example.demo.controller.dto.DtoOrder;
import com.example.demo.entites.Order;
import com.example.demo.enums.OrderState;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Order rest controller
 * used for all endpoints associated with orders
 *
 * @version 1.0
 */
@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * @return view with list of all orders
     */
    @GetMapping
    public ModelAndView getAll() {
        orderService.clearInProcess();
        ModelAndView modelAndView = new ModelAndView("orders/orders");
        modelAndView.addObject("title", "Orders");
        modelAndView.addObject("orders", orderService.findAll());
        return modelAndView;
    }

    /**
     * @return view with form for new order creation
     */
    @GetMapping("/new")
    public ModelAndView newOrderForm() {
        Order order = new Order();
        order = orderService.save(order);
        ModelAndView modelAndView = new ModelAndView("orders/order");
        modelAndView.addObject("title", "Order management");
        modelAndView.addObject("order", order);
        return modelAndView;
    }

    /**
     * @param dtoOrder {@link DtoOrder dto order} that will be converted to {@link Order} and saved in database
     * @return redirection to {@link OrderController#getAll()  endpoint} that lists all orders
     */
    @PostMapping
    public RedirectView save(@ModelAttribute DtoOrder dtoOrder) {
        Order order = DtoConverter.fromDto(dtoOrder);
        order.setComponents(orderService.findById(order.getId()).getComponents());
        order.setState(OrderState.SUBMITTED);
        orderService.update(order);
        return new RedirectView("/orders");
    }

    /**
     * @param id of the order object that will be used for management
     * @return view that is used for order management (adding removing component)
     */
    @GetMapping("/manage")
    public ModelAndView manage(@RequestParam long id) {
        Order order = orderService.findById(id);
        ModelAndView modelAndView = new ModelAndView("orders/order");
        modelAndView.addObject("title", "Order management");
        modelAndView.addObject("order", order);
        return modelAndView;
    }

    /**
     * @param id of the order object that needs to be deleted
     * @return redirection to the {@link OrderController#getAll() endpoint} with list of all orders
     */
    @PostMapping("/delete")
    public RedirectView delete(@RequestParam long id) {
        orderService.deleteById(id);
        return new RedirectView("/orders");
    }

    /**
     * @param orderId            id of the order object that will be used to remove component from it
     * @param componentId        id of the component that needs to be removed
     * @param redirectAttributes interface to add attributes for redirection
     * @return redirection to {@link OrderController#manage(long) endpoint} with order management
     */
    @PostMapping("/remove_component")
    public RedirectView removeComponent(@RequestParam long orderId,
                                        @RequestParam long componentId,
                                        RedirectAttributes redirectAttributes) {
        orderService.removeComponent(orderId, componentId);
        redirectAttributes.addAttribute("id", orderId);
        return new RedirectView("/orders/manage");
    }

    /**
     * @param orderId            id of the order object that will be used to add component to it
     * @param componentId        id of the component that needs to be added
     * @param redirectAttributes interface to add attributes for redirection
     * @return redirection to {@link OrderController#manage(long) endpoint} with order management
     */
    @PostMapping("/add_component")
    public RedirectView addComponent(@RequestParam long orderId,
                                     @RequestParam long componentId,
                                     RedirectAttributes redirectAttributes) {
        orderService.addComponent(orderId, componentId);
        redirectAttributes.addAttribute("id", orderId);
        return new RedirectView("/orders/manage");
    }
}
