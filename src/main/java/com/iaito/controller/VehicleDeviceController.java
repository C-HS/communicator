package com.iaito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.iaito.service.VDeviceService;

@Controller
public class VehicleDeviceController {

	@Autowired VDeviceService vehicleDeviceService;
	
    @GetMapping("/vehicledevice_list")
    public String getAllVehicleDevices(){
        return "vehicledevice_list";
    }
	
    
    @GetMapping("/vehicledevice_registration")
    public String vehicleDeviceAddPage(){
        return "vehicledevice_registration";
    }
    
    @GetMapping("/vehicledevice_view")
    public String vehicleDeviceViewPage(){
        return "vehicledevice_view";
    }
}
