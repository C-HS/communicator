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

import com.iaito.dto.MiddlewareConfigurationDTO;
import com.iaito.dto.RFIDReaderDTO;
import com.iaito.model.MiddlewareConfiguration;
import com.iaito.service.MiddlewareConfigurationService;

@Controller
public class MiddlewareConfigController {
	
	@Autowired MiddlewareConfigurationService middlewareConfigurationService;
	
    @GetMapping("/middlewareconfig_list")
    public ModelAndView getAllMiddlewareConfigs(){
      //  return "middlewareconfig_list";
    	
    	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("middlewareconfig_list");
        
        List<MiddlewareConfigurationDTO> mConfigList = new ArrayList<>();
        
        mConfigList = middlewareConfigurationService.getAllMiddlewareConfiguration();
        
System.out.println("mConfig "+mConfigList.size());
        
        modelAndView.addObject("mConfigList", mConfigList);
    	
        return modelAndView;
    }
    
    
    @GetMapping("/middlewareconfig_registration")
    public String middlewareconfigRegistration(){
        return "middlewareconfig_registration";
    }
    
    
    
    
    
    @GetMapping("/middlewareconfig_view")
    public ModelAndView middlewareconfigView(@RequestParam("mConfigId") long mConfigId){
        //return "middlewareconfig_view";
    	
    	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("middlewareconfig_view");
        MiddlewareConfigurationDTO mConfigDTO = middlewareConfigurationService.getMiddlewareConfigurationByID(mConfigId);
        
        
        modelAndView.addObject("middlewareConfig", mConfigDTO);
    	
        return modelAndView;
    }
    
    
    @PostMapping("/createMiddlewareMQTTConfig")
    public ModelAndView createRFIDReader(@ModelAttribute MiddlewareConfiguration middlewareConfiguration)
    {
    	String resp= "";
    	
    	//System.out.println("AAAAAAAAAAAAAAA"+vehicleDevice.getVehicleDeviceNumber());
    	//System.out.println("BBBBBBBBBBBBBB"+vehicleDevice.getDescription());
    	

    
    	middlewareConfiguration.setDateCreated(new Date());
    	middlewareConfiguration.setStatus("ACTIVE");
        	
        resp = middlewareConfigurationService.addMiddlewareConfiguration(middlewareConfiguration);
    
   
    	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("middlewareconfig_registration");
        
     //   System.out.println("@@@@@@@@@@@@@@@@@@ "+resp);
        
        modelAndView.addObject("resp", resp);
    	
        return modelAndView;
    	
    }
    

}
