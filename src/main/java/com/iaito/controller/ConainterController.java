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
import com.iaito.model.Container;
import com.iaito.repository.ContainerRepository;
import com.iaito.service.ContainerService;

@Controller
public class ConainterController {
	
	@Autowired ContainerService containerService;
	
    private ContainerRepository containerRepository;

    public ConainterController(ContainerRepository containerRepository){
        this.containerRepository = containerRepository;
    }

    @GetMapping("/containerRegistration")
    public String registerContainer(){
        return "container_registration";
    }
    @GetMapping("/listContainer")
    public ModelAndView listContainer(){
    	
    	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("container_list");
        
        List<ContainerDTO> containerList = new ArrayList<>();
        
        containerList = containerService.getAllContainer();
        
        modelAndView.addObject("containerList", containerList);
    	
        return modelAndView;
    }
    
    
    @PostMapping("/createContainer")
    public ModelAndView createContainer(@ModelAttribute Container container){
    	
		/*
		 * System.out.println("AAAAAAAAAAAAAAA"+container.getContainerNumber());
		 * System.out.println("BBBBBBBBBBBBBB"+container.getContainerType());
		 * System.out.println("CCCCCCCCCCCCCCCCC"+container.getContainerInfo());
		 * System.out.println("EEEEEEEEEEEEEE"+container.getContainerId());
		 * System.out.println("FFFFFFFFFFFFFF"+container.getTaggingStatus());
		 * System.out.println("GGGGGGGGGGGGGGGGG"+container.getTid());
		 */
    	
    	String resp= "";
    	
    	if(container.getContainerNumber()==null || container.getContainerNumber().trim().equals(""))
    	{
    		resp = "enter_container_number";
    	}
    	else
    	{
        	container.setRegisterDate(new Date());
        	
        	container.setTaggingStatus("UNTAGGED");
        	container.setTid("NA");
        	container.setTaggingDate(null);
        	container.setStatus("Registered");
        	resp = containerService.createContainer(container);
    	}
   
    	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("container_registration");
        
        System.out.println("@@@@@@@@@@@@@@@@@@ "+resp);
        
        modelAndView.addObject("resp", resp);
    	
        return modelAndView;
    }
    
    @GetMapping("/viewContainer")
    public ModelAndView viewContainer(@RequestParam("containerNo") String containerNo){
    	
    	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("container_view");
        
        
        ContainerDTO containerDTO = containerService.getContainerByContainerNo(containerNo);
        
        modelAndView.addObject("container", containerDTO);
    	
        return modelAndView;
    }
}
