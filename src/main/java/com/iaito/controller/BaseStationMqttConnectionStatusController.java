package com.iaito.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseStationMqttConnectionStatusController {
	
    @GetMapping("/baseStationStatus")
    public String baseStationStatusList(){
        return "basestation_status_list";
    }

}
