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

import com.iaito.dto.RFIDReaderDTO;
import com.iaito.dto.VDeviceDTO;
import com.iaito.model.RFIDReader;
import com.iaito.service.RFIDReaderService;

@Controller
public class RFIDReaderController {
	
	@Autowired RFIDReaderService rfidReaderService;
	
    @GetMapping("/rfidreader_list")
    public ModelAndView getAllrfidReaders(){
      //  return "rfidreader_list";
    	
    	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("rfidreader_list");
        
        List<RFIDReaderDTO> rfidReaderList = new ArrayList<>();
        
        rfidReaderList = rfidReaderService.getAllRFIDReader();
        
        modelAndView.addObject("rfidReaderList", rfidReaderList);
    	
        return modelAndView;
    }
    
    @GetMapping("/rfidreader_view")
    public ModelAndView rfidReaderViewPage(@RequestParam("readerId") long readerId){
       // return "rfidreader_view";
    	
    	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("rfidreader_view");
        
       // System.out.println("@@@@@@@@@@@@@@@@deviceNo@ "+deviceNo);
        RFIDReaderDTO rfidReaderDTO = rfidReaderService.getRFIDReaderByID(readerId);
        
      //  System.out.println("@@@@@@@@@@@@@@@ID "+vehicleDeviceDTO.getVehicleDeviceId());
     //   System.out.println("@@@@@@@@@@@@@@@No "+vehicleDeviceDTO.getVehicleDeviceNumber());
        
        modelAndView.addObject("rfidReader", rfidReaderDTO);
    	
        return modelAndView;
    }
    
    @GetMapping("/rfidreader_registration")
    public String rfidReaderAddPage(){
        return "rfidreader_registration";
    }
    
    
    
    @PostMapping("/createFixedRFIDReader")
    public ModelAndView createRFIDReader(@ModelAttribute RFIDReader rfidReader)
    {
    	String resp= "";
    	
    	//System.out.println("AAAAAAAAAAAAAAA"+vehicleDevice.getVehicleDeviceNumber());
    	//System.out.println("BBBBBBBBBBBBBB"+vehicleDevice.getDescription());
    	
    	if((rfidReader.getReaderIp()==null || rfidReader.getReaderIp().trim().equals(""))&&(rfidReader.getReaderPort()==null || rfidReader.getReaderPort().trim().equals("")))
    	{
    		resp = "enter_ip_port";
    	}
    	else
    	{
    		rfidReader.setRegisterDate(new Date());
        	
    		rfidReader.setIpPortConfigurationStatus("NO");
    		rfidReader.setLocationAssignStatus("UNASSIGNED");
    		
    		if(rfidReader.getMiddlewareReaderId()==null || rfidReader.getMiddlewareReaderId().trim().equals(""))
    				{
    			rfidReader.setMiddlewareMappingStatus("UNMAPPED");
    			rfidReader.setStatus("REGISTERED");
    				}
		    		else
		    		{

		    			rfidReader.setMiddlewareMappingDate(new Date());
		    			rfidReader.setMiddlewareMappingStatus("MAPPED");
		    			rfidReader.setStatus("READY");
		    		}
        	resp = rfidReaderService.addRFIDReader(rfidReader);
    	}
   
    	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("rfidreader_registration");
        
     //   System.out.println("@@@@@@@@@@@@@@@@@@ "+resp);
        
        modelAndView.addObject("resp", resp);
    	
        return modelAndView;
    	
    }
}
