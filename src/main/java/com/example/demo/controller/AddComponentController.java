package com.example.demo.controller;

import com.example.demo.controller.dto.DtoCPU;
import com.example.demo.controller.dto.DtoConverter;
import com.example.demo.controller.dto.DtoCooler;
import com.example.demo.entites.Component;
import com.example.demo.entites.Cooler;
import com.example.demo.enums.ComponentType;
import com.example.demo.repository.ComponentRepository;
import com.example.demo.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


/**
 * Controller used to deal with adding new components to db
 *
 * @version 1.0
 */
@RestController
@RequestMapping("/add_component")
public class AddComponentController {
    //TODO refactor endpoints
    private final ComponentService componentService;

    @Autowired
    public AddComponentController(ComponentService componentService) {
        this.componentService = componentService;
    }

    /**
     * @return view with menu where user can choose what component he wants to create/add new record
     */
    @GetMapping
    public ModelAndView addComponentOptions() {
        ModelAndView modelAndView = new ModelAndView("add_component");
        modelAndView.addObject("options", ComponentType.values());
        return modelAndView;
    }

    /**
     * @return view with form for new cooler component
     */
    @GetMapping("/cooler")
    public ModelAndView coolerForm() {
        ModelAndView modelAndView = new ModelAndView("add_component/cooler");
        modelAndView.addObject("title", "Add cooler");
        return modelAndView;
    }

    /**
     * @param dtoCooler dto object with filled fields to be saved in db
     * @return redirection to endpoint that lists all components
     */
    @PostMapping(path = "/cooler")
    public RedirectView addCooler(@ModelAttribute DtoCooler dtoCooler) {
        Component cooler = DtoConverter.fromDto(dtoCooler);
        componentService.save(cooler);
        return new RedirectView("/components");
    }

    /**
     * @return view with form to add new CPU record
     */
    @GetMapping("/cpu")
    public ModelAndView cpuForm() {
        ModelAndView modelAndView = new ModelAndView("add_component/cpu");
        modelAndView.addObject("title", "Add CPU");
        return modelAndView;
    }

    /**
     * @param dtoCPU new CPU record
     * @return redirection to to endpoint that lists all components
     */
    @PostMapping("/cpu")
    public RedirectView addCPU(@ModelAttribute DtoCPU dtoCPU) {
        Component cpu = DtoConverter.fromDto(dtoCPU);
        componentService.save(cpu);
        return new RedirectView("/components");
    }

    /**
     * Method that fills db with some data
     *
     * @return view with options to add more components
     */
    //TODO add methods to add other component types and remove this method
    @GetMapping("/fill_up")
    public RedirectView fillDB() {
        componentService.addComponents();
        return new RedirectView("/components");
    }

}
