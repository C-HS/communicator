package com.iaito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.iaito.service.BaseStationConfigurationService;

@Controller
public class BaseStationConfigController {

	@Autowired BaseStationConfigurationService baseStationConfigurationService;
	
    @GetMapping("/basestationconfig_list")
    public String getAllBasestationconfigConfigs(){
        return "basestationconfig_list";
    }
    
    
    @GetMapping("/basestationconfig_registration")
    public String basestationconfigRegistration(){
        return "basestationconfig_registration";
    }
    
    
    @GetMapping("/basestationconfig_view")
    public String basestationconfigView(){
        return "basestationconfig_view";
    }
	
}
