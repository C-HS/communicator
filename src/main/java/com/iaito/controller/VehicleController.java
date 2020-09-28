package com.iaito.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class VehicleController {
    @GetMapping("/vehicleList")
    public String listVehicle(){
        return "vehicle_list";
    }
    @GetMapping("/vehicleRegister")
    public String registerVehicle(){
        return "vehicle_registration";
    }
    @GetMapping("/vehicleEdit")
    public String editVehicle(){
        return "vehicle_edit";
    }
    @GetMapping("/vehicleView")
    public String viewVehicle(){
        return "vehicle_view";
    }


}
