package com.iaito.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContainerBlockController {
	
    @GetMapping("/containerBlock")
    public String containerBlocks(){
        return "container_block_list";
    }
    @GetMapping("/registerContainerBlock")
    public String registerContainerBlock(){
        return "container_block_registration";
    }
    @GetMapping("/editContainerBlock")
    public String editContainerBlock(){
        return "container_block_edit";
    }
    @GetMapping("/viewContainerBlock")
    public String viewContainerBlock(){
        return "container_block_view";
    }

}
