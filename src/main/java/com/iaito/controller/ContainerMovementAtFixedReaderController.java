package com.iaito.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContainerMovementAtFixedReaderController {

    @GetMapping("/movemetAtFixedReader")
    public String movemetAtFixedReaderList(){
        return "movement_at_fixedreader_list";
    }
	
}
