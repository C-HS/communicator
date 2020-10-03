package com.iaito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.iaito.service.RFIDTagService;

@Controller
public class RFIDTagController {
	
	@Autowired RFIDTagService rfidTagService;
	
    @GetMapping("/rfidtag_list")
    public String getAllRFIDTags(){
        return "rfidtag_list";
    }

}
