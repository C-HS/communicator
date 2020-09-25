package com.iaito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.iaito.service.RFIDReaderService;

@Controller
public class RFIDReaderController {
	
	@Autowired RFIDReaderService rfidReaderService;
	
    @GetMapping("/rfidReader")
    public String getAllrfidReaders(){
        return "rfidReader";
    }
    
    @GetMapping("/rfidReaderViewPage")
    public String rfidReaderViewPage(){
        return "rfidReaderViewPage";
    }

}
