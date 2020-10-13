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

import com.iaito.dto.ContainerAreaDTO;
import com.iaito.dto.ContainerBlockDTO;
import com.iaito.model.ContainerArea;
import com.iaito.service.ContainerAreaService;
import com.iaito.service.ContainerBlockService;

@Controller
public class ContainerAreaController {
	
	@Autowired ContainerAreaService containerAreaService;
	
	@Autowired ContainerBlockService containerBlockService;
	
    @PostMapping("/createContainerArea")
    public ModelAndView createContainerArea(@ModelAttribute ContainerArea containerArea)
    {
    	String resp= "";
    	

    
    	containerArea.setCreateDate(new Date());
    	containerArea.setStatus("READY");
        	
        resp = containerAreaService.addContainerArea(containerArea);
    
   
    	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("container_area_registration");
        
     //   System.out.println("@@@@@@@@@@@@@@@@@@ "+resp);
        
        modelAndView.addObject("resp", resp);
    	
        return modelAndView;
    	
    }

    @GetMapping("/containerArea")
    public ModelAndView containerAreas(){
      //  return "container_area_list";
    	
       	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("container_area_list");
        
        List<ContainerAreaDTO> areaList = new ArrayList<>();
        
        areaList = containerAreaService.getAllContainerArea();
        
        System.out.println("areaList "+areaList.size());
        
        modelAndView.addObject("areaList", areaList);
    	
        return modelAndView;
    }
    
    @GetMapping("/registerContainerArea")
    public ModelAndView registerContainerArea(){
    	
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("container_area_registration");
      //  return "container_area_registration";
        
        
        List<ContainerBlockDTO> blockList = new ArrayList<>();
        
        blockList = containerBlockService.getAllContainerBlock();
        
        System.out.println("blockList "+blockList.size());
        
        modelAndView.addObject("blockList", blockList);
        
        return modelAndView;
    }
    
    @GetMapping("/editContainerArea")
    public String editContainerArea(){
        return "container_area_edit";
    }
    
    @GetMapping("/viewContainerArea")
    public ModelAndView viewContainerArea(@RequestParam("areaId") long areaId){
       // return "container_area_view";
    	
    	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("container_area_view");
        ContainerAreaDTO containerAreaDTO = containerAreaService.getContainerAreaByID(areaId);
        
        modelAndView.addObject("containerArea", containerAreaDTO);
    	
        return modelAndView;
    }
}
