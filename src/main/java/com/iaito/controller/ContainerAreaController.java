package com.iaito.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContainerAreaController {

    @GetMapping("/containerArea")
    public String containerAreas(){
        return "container_area_list";
    }
    @GetMapping("/registerContainerArea")
    public String registerContainerArea(){
        return "container_area_registration";
    }
    @GetMapping("/editContainerArea")
    public String editContainerArea(){
        return "container_area_edit";
    }
    @GetMapping("/viewContainerArea")
    public String viewContainerArea(){
        return "container_area_view";
    }
}
