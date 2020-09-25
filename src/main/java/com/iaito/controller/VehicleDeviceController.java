package com.iaito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.iaito.service.VDeviceService;

@Controller
public class VehicleDeviceController {

	@Autowired VDeviceService vehicleDeviceService;
	
    @GetMapping("/vehicleDevice")
    public String getAllVehicleDevices(){
        return "vehicleDevice";
    }
	
    
    @GetMapping("/vehicleDeviceAddPage")
    public String vehicleDeviceAddPage(){
        return "vehicleDeviceAddPage";
    }
    
    @GetMapping("/vehicleDeviceViewPage")
    public String vehicleDeviceViewPage(){
        return "vehicleDeviceViewPage";
    }
}
