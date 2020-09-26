package com.iaito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.iaito.service.MiddlewareConfigurationService;

@Controller
public class MiddlewareConfigController {
	
	@Autowired MiddlewareConfigurationService middlewareConfigurationService;
	
    @GetMapping("/middlewareConfig")
    public String getAllMiddlewareConfigs(){
        return "middlewareConfig";
    }
    

}
