package com.iaito.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseStationController {
    @GetMapping("/listBaseStation")
    public String listBaseStations(){
        return "base_station_list";
    }
    @GetMapping("/registerBaseStation")
    public String registerBaseStations(){
        return "base_station_registration";
    }
    @GetMapping("/editBaseStation")
    public String editBaseStations(){
        return "base_station_edit";
    }
    @GetMapping("/viewBaseStation")
    public String viewBaseStations(){
        return "base_station_view";
    }
}
