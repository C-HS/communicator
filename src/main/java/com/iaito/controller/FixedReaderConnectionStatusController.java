package com.iaito.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FixedReaderConnectionStatusController {

    @GetMapping("/fixedReaderStatus")
    public String fixedReaderStatusList(){
        return "fixedreader_status_list";
    }
}
