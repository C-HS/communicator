package com.iaito.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iaito.dto.RFIDTagDTO;
import com.iaito.service.RFIDTagService;

@Controller
public class RFIDTagController {
	
	@Autowired RFIDTagService rfidTagService;
	
    @GetMapping("/rfidtag_list")
    public ModelAndView getAllRFIDTags(){
		/* return "rfidtag_list"; */
        
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("rfidtag_list");
        
        List<RFIDTagDTO> attachedTagList = new ArrayList<>();
        List<RFIDTagDTO> freeTagList = new ArrayList<>();
        
        attachedTagList = rfidTagService.getRFIDTagByStatus("ATTACHED");
        
        freeTagList = rfidTagService.getRFIDTagByStatus("FREE");
        
        modelAndView.addObject("attachedTagList", attachedTagList);
        modelAndView.addObject("freeTagList", freeTagList);
        
        return modelAndView;
    }

}
