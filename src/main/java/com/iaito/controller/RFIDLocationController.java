package com.iaito.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class RFIDLocationController {
    @GetMapping("/listRfidLoction")
    public String  listRfidReader(){
        return "reader_location_list";
    }

    @GetMapping("/registerRfidLoction")
    public String  registerRfidReader(){
        return "reader_location_registeration";
    }
}
