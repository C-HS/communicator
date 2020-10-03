package com.iaito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.iaito.service.MiddlewareConfigurationService;

@Controller
public class MiddlewareConfigController {
	
	@Autowired MiddlewareConfigurationService middlewareConfigurationService;
	
    @GetMapping("/middlewareconfig_list")
    public String getAllMiddlewareConfigs(){
        return "middlewareconfig_list";
    }
    
    
    @GetMapping("/middlewareconfig_registration")
    public String middlewareconfigRegistration(){
        return "middlewareconfig_registration";
    }
    
    
    @GetMapping("/middlewareconfig_view")
    public String middlewareconfigView(){
        return "middlewareconfig_view";
    }
    

}
