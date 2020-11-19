package com.iaito.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.iaito.dto.ContainerDTO;
import com.iaito.dto.ContainerMovementAtFixedReaderDTO;
import com.iaito.service.ContainerMovementAtFixedReaderService;

@Controller
public class ContainerMovementAtFixedReaderController {
	
	@Autowired ContainerMovementAtFixedReaderService movementAtFixedReaderService;

    @GetMapping("/movemetAtFixedReader")
    public ModelAndView movementAtFixedReaderList(){
       // return "movement_at_fixedreader_list";
    	
      	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("movement_at_fixedreader_list");
        
        List<ContainerMovementAtFixedReaderDTO> containerMovementAtFixedReaderList = new ArrayList<>();
        
        containerMovementAtFixedReaderList = movementAtFixedReaderService.getAllContainerMovementAtFixedReader();
        
        System.out.println("movementList "+containerMovementAtFixedReaderList.size());
        
        modelAndView.addObject("movementList", containerMovementAtFixedReaderList);
    	
        return modelAndView;
    }
    
    @GetMapping("/containerHistory/{containerNo}")
    public ResponseEntity<List<ContainerMovementAtFixedReaderDTO>> containerHistory(@PathVariable String containerNo){
    	
    	System.out.println("containerNo "+containerNo);
        
        List<ContainerMovementAtFixedReaderDTO> containerMovementAtFixedReaderList = new ArrayList<>();
        
       containerMovementAtFixedReaderList = movementAtFixedReaderService.getContainerMovementByContainerNumber(containerNo);
        
       // System.out.println("movementList "+containerMovementAtFixedReaderList);

        return ResponseEntity.status(200).body(containerMovementAtFixedReaderList);
    }
    
    @GetMapping("/locateContainer/{containerNo}")
    public ResponseEntity<ContainerMovementAtFixedReaderDTO> locateContainer(@PathVariable String containerNo){
    	
    	System.out.println("containerNo "+containerNo);
        
        ContainerMovementAtFixedReaderDTO containerMovementAtFixedReader = null;
        
        containerMovementAtFixedReader = movementAtFixedReaderService.getLastLocationByContainerNumber(containerNo);
        
        System.out.println("########################################### "+containerMovementAtFixedReader);

        return ResponseEntity.status(200).body(containerMovementAtFixedReader);
    }
	
}
