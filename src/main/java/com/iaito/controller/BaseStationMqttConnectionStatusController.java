package com.iaito.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iaito.dto.BaseStationMQTTConnectionStatusDTO;
import com.iaito.service.BaseStationMQTTConnectionStatusService;

@Controller
public class BaseStationMqttConnectionStatusController {
	
	@Autowired BaseStationMQTTConnectionStatusService statusService;
	
    @GetMapping("/baseStationStatus")
    public ModelAndView baseStationStatusList(){
      //  return "basestation_status_list";
        
      	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("basestation_status_list");
        
        List<BaseStationMQTTConnectionStatusDTO> baseStationStatusList = new ArrayList<>();
        
        baseStationStatusList = statusService.getAllBaseStationMQTTConnectionStatus();
        
        System.out.println("baseStationStatusList "+baseStationStatusList.size());
        
        modelAndView.addObject("baseStationStatusList", baseStationStatusList);
    	
        return modelAndView;
    }

}
