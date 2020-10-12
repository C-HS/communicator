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

import com.iaito.dto.ContainerDTO;
import com.iaito.dto.VDeviceDTO;
import com.iaito.model.Container;
import com.iaito.model.VDevice;
import com.iaito.service.VDeviceService;

@Controller
public class VehicleDeviceController {

	@Autowired VDeviceService vehicleDeviceService;
	
    @GetMapping("/vehicledevice_list")
    public ModelAndView getAllVehicleDevices(){
        //return "vehicledevice_list";
    	
    	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("vehicledevice_list");
        
        List<VDeviceDTO> vehicleDeviceList = new ArrayList<>();
        
        vehicleDeviceList = vehicleDeviceService.getAllVDevice();
        
        modelAndView.addObject("vehicleDeviceList", vehicleDeviceList);
    	
        return modelAndView;
    }
	
    
    @GetMapping("/vehicledevice_registration")
    public String vehicleDeviceAddPage(){
       return "vehicledevice_registration";
    	

    }
    
    @PostMapping("/createVehicleDevice")
    public ModelAndView createVehicleDevice(@ModelAttribute VDevice vehicleDevice)
    {
    	String resp= "";
    	
    	//System.out.println("AAAAAAAAAAAAAAA"+vehicleDevice.getVehicleDeviceNumber());
    	//System.out.println("BBBBBBBBBBBBBB"+vehicleDevice.getDescription());
    	
    	if(vehicleDevice.getVehicleDeviceNumber()==null || vehicleDevice.getVehicleDeviceNumber().trim().equals(""))
    	{
    		resp = "enter_device_number";
    	}
    	else
    	{
    		vehicleDevice.setRegisterDate(new Date());
        	
    		vehicleDevice.setAttachStatus("UNATTACHED");
        	vehicleDevice.setAttachDate(null);
        	vehicleDevice.setStatus("Registered");
        	resp = vehicleDeviceService.addVDevice(vehicleDevice);
    	}
   
    	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("vehicledevice_registration");
        
     //   System.out.println("@@@@@@@@@@@@@@@@@@ "+resp);
        
        modelAndView.addObject("resp", resp);
    	
        return modelAndView;
    	
    }
    
    @GetMapping("/vehicledevice_view")
    public ModelAndView vehicleDeviceViewPage(@RequestParam("deviceNo") long deviceNo){
    	
    	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("vehicledevice_view");
        
       // System.out.println("@@@@@@@@@@@@@@@@deviceNo@ "+deviceNo);
        VDeviceDTO vehicleDeviceDTO = vehicleDeviceService.getVDeviceByID(deviceNo);
        
      //  System.out.println("@@@@@@@@@@@@@@@ID "+vehicleDeviceDTO.getVehicleDeviceId());
     //   System.out.println("@@@@@@@@@@@@@@@No "+vehicleDeviceDTO.getVehicleDeviceNumber());
        
        modelAndView.addObject("vehicleDevice", vehicleDeviceDTO);
    	
        return modelAndView;
    	
    }
}
