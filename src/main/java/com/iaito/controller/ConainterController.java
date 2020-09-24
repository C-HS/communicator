package com.iaito.controller;

import com.iaito.model.Container;
import com.iaito.repository.ContainerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConainterController {
    private ContainerRepository containerRepository;

    public ConainterController(ContainerRepository containerRepository){
        this.containerRepository = containerRepository;
    }

    @GetMapping("/containerRegistration")
    public String registerContainer(){
        return "container_registration";
    }
    @GetMapping("/listContainer")
    public String listContainer(){
        return "container_list";
    }
}
