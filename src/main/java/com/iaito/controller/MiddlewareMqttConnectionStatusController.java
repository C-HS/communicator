package com.iaito.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iaito.dto.MiddlewareMqttConnectionStatusDTO;
import com.iaito.service.MiddlewareMqttConnectionStatusService;

@Controller
public class MiddlewareMqttConnectionStatusController {
	
	@Autowired MiddlewareMqttConnectionStatusService statusService;

    @GetMapping("/middewareStatus")
    public ModelAndView middlewareStatusList(){
       // return "middleware_status_list";
        
        
      	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("middleware_status_list");
        
        List<MiddlewareMqttConnectionStatusDTO> middlewareStatusList = new ArrayList<>();
        
        middlewareStatusList = statusService.getAllMiddlewareMqttConnectionStatus();
        
        System.out.println("middlewareStatusList "+middlewareStatusList.size());
        
        modelAndView.addObject("middlewareStatusList", middlewareStatusList);
    	
        return modelAndView;
    }
	/*
	 * @GetMapping("/registerContainerArea") public String registerContainerArea(){
	 * return "container_area_registration"; }
	 * 
	 * @GetMapping("/editContainerArea") public String editContainerArea(){ return
	 * "container_area_edit"; }
	 * 
	 * @GetMapping("/viewContainerArea") public String viewContainerArea(){ return
	 * "container_area_view"; }
	 */
	
}
