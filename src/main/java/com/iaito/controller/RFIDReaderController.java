package com.iaito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.iaito.service.RFIDReaderService;

@Controller
public class RFIDReaderController {
	
	@Autowired RFIDReaderService rfidReaderService;
	
    @GetMapping("/rfidreader_list")
    public String getAllrfidReaders(){
        return "rfidreader_list";
    }
    
    @GetMapping("/rfidreader_view")
    public String rfidReaderViewPage(){
        return "rfidreader_view";
    }
    
    @GetMapping("/rfidreader_registration")
    public String rfidReaderAddPage(){
        return "rfidreader_registration";
    }

}
