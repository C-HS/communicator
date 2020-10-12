package com.iaito.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iaito.dto.BaseStationConfigurationDTO;
import com.iaito.model.BaseStationConfiguration;
import com.iaito.service.BaseStationConfigurationService;

@Controller
public class BaseStationConfigController {

	@Autowired BaseStationConfigurationService baseStationConfigurationService;
	
    @GetMapping("/basestationconfig_list")
    public ModelAndView getAllBasestationconfigConfigs(){
       // return "basestationconfig_list";
        
       	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("basestationconfig_list");
        
        List<BaseStationConfigurationDTO> bsConfigList = new ArrayList<>();
        
        bsConfigList = baseStationConfigurationService.getAllBaseStationConfiguration();
        
        System.out.println("bsConfigList "+bsConfigList.size());
        
        modelAndView.addObject("bsConfigList", bsConfigList);
    	
        return modelAndView;
    }
    
    
    @GetMapping("/basestationconfig_registration")
    public String basestationconfigRegistration(){
        return "basestationconfig_registration";
    }
    
    
    @GetMapping("/basestationconfig_view")
    public ModelAndView basestationconfigView(@RequestParam("bsConfigId") long bsConfigId){
        //return "basestationconfig_view";
    	
    	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("basestationconfig_view");
        BaseStationConfigurationDTO bsConfigDTO = baseStationConfigurationService.getBaseStationConfigurationByID(bsConfigId);
        
        
        modelAndView.addObject("baseStationConfig", bsConfigDTO);
    	
        return modelAndView;
    }
    
    
    @PostMapping("/createBaseStationMQTTConfig")
    public ModelAndView createRFIDReader(@ModelAttribute BaseStationConfiguration baseStationConfiguration)
    {
    	String resp= "";
    	
    	//System.out.println("AAAAAAAAAAAAAAA"+vehicleDevice.getVehicleDeviceNumber());
    	//System.out.println("BBBBBBBBBBBBBB"+vehicleDevice.getDescription());
    	

    
    	baseStationConfiguration.setDateCreated(new Date());
    	baseStationConfiguration.setStatus("ACTIVE");
        	
        resp = baseStationConfigurationService.addBaseStationConfiguration(baseStationConfiguration);
    
   
    	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("basestationconfig_registration");
        
     //   System.out.println("@@@@@@@@@@@@@@@@@@ "+resp);
        
        modelAndView.addObject("resp", resp);
    	
        return modelAndView;
    	
    }
	
}
