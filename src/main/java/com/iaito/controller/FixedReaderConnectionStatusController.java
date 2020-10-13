package com.iaito.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iaito.dto.FixedRFIDReaderConnectionStatusDTO;
import com.iaito.service.FixedRFIDReaderConnectionStatusService;

@Controller
public class FixedReaderConnectionStatusController {
	
	@Autowired FixedRFIDReaderConnectionStatusService statusService;

    @GetMapping("/fixedReaderStatus")
    public ModelAndView fixedReaderStatusList(){
      //  return "fixedreader_status_list";
    	
      	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fixedreader_status_list");
        
        List<FixedRFIDReaderConnectionStatusDTO> fixedReaderStatusList = new ArrayList<>();
        
        fixedReaderStatusList = statusService.getAllFixedRFIDReaderConnectionStatus();
        
        System.out.println("fixedReaderStatusList "+fixedReaderStatusList.size());
        
        modelAndView.addObject("fixedReaderStatusList", fixedReaderStatusList);
    	
        return modelAndView;
    }
}
