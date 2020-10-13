package com.iaito.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iaito.dto.ContainerBlockCoordinateDTO;
import com.iaito.dto.ContainerBlockDTO;
import com.iaito.model.ContainerBlock;
import com.iaito.model.ContainerBlockCoordinate;
import com.iaito.service.ContainerBlockCoordinateService;
import com.iaito.service.ContainerBlockService;

@Controller
public class ContainerBlockController {
	
	@Autowired ContainerBlockService containerBlockService;
	@Autowired ContainerBlockCoordinateService containerBlockCoordinateService;
	
	
	  @PostMapping("/createContainerBlock") 
	  public ModelAndView createContainerBlock(@ModelAttribute ContainerBlock containerBlock) 
	  { 
		  String resp= "";
	  
		  containerBlock.setDateCreated(new Date()); containerBlock.setStatus("READY");
		  
		  resp = containerBlockService.addContainerBlock(containerBlock);
		  
		  
		  ModelAndView modelAndView = new ModelAndView();
		  modelAndView.setViewName("container_block_registration");
		  
		  
		  modelAndView.addObject("resp", resp);
		  
		  return modelAndView;
		  
	  }
	 
	
    @GetMapping("/containerBlock")
    public ModelAndView containerBlocks(){
       // return "container_block_list";
    	
       	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("container_block_list");
        
        List<ContainerBlockDTO> blockList = new ArrayList<>();
        
        blockList = containerBlockService.getAllContainerBlock();
        
        System.out.println("blockList "+blockList.size());
        
        modelAndView.addObject("blockList", blockList);
    	
        return modelAndView;
    }
    @GetMapping("/registerContainerBlock")
    public String registerContainerBlock(){
        return "container_block_registration";
    }
    @GetMapping("/editContainerBlock")
    public String editContainerBlock(){
        return "container_block_edit";
    }
    
    @GetMapping("/viewContainerBlock")
    public ModelAndView viewContainerBlock(@RequestParam("blockId") long blockId){
      //  return "container_block_view";
    	
    	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("container_block_view");
        ContainerBlockDTO containerBlockDTO = containerBlockService.getContainerBlockByID(blockId);
        
        List<ContainerBlockCoordinateDTO> containerBlockCoordinateDTOList = containerBlockCoordinateService.getContainerBlockCoordinateByBlockId(blockId);
        
        modelAndView.addObject("containerBlock", containerBlockDTO);
        modelAndView.addObject("coordinateList", containerBlockCoordinateDTOList);
    	
        return modelAndView;
    }
    
    
    @PostMapping("/createContainerBlockCoordinate")
    public ModelAndView createCoordinate(@RequestParam Map<String, String> coordinate)
    {
    	String resp= "";
    	//System.out.println("@@@@@@@@@@@@@@@@@@ "+coordinate);
    	
    	//System.out.println("@@@@@@@@@@@@@@@@@@ "+blockId);
    	
    	
    //	System.out.println("@@@@@@@@@@@@@@@@@@ "+coordinate.keySet());
    	
       int noOfCoordinate = 0;
       
       if(coordinate.keySet().size()>1)
       {
    	   noOfCoordinate = coordinate.keySet().size()-1;
    	   
    	   noOfCoordinate=noOfCoordinate/2;
			
			  for(int i=0; i< noOfCoordinate; i++) { 
				  
				  
				  ContainerBlockCoordinate cbc = new ContainerBlockCoordinate();
				  
				  cbc.setBlockId(Long.parseLong(coordinate.get("blockId")));
				  
				  cbc.setLatitude((String)coordinate.get("coordinate["+i+"][0]"));
				  cbc.setLongitude((String)coordinate.get("coordinate["+i+"][1]"));
				  
				  cbc.setDateCreated(new Date());
				  
				  cbc.setStatus("REGISTERED");
				  
				  
				  
				  
				  resp = containerBlockCoordinateService.addContainerBlockCoordinate(cbc);
				  
				  if(!"success".equals(resp))
				  {
					  break;
					  
				  }
				  
				 // String latitude = (String)coordinate.get("coordinate["+i+"][0]");
				 // String longitude = (String)coordinate.get("coordinate["+i+"][1]");
				 // System.out.println("latitude@@@@@@@@@@@@@@@@@@ "+latitude);
				 // System.out.println("longitude@@@@@@@@@@@@@@@@@@ "+longitude);
			  }
			 
    	   
    	   
    	 //  System.out.println("blockId@@@@@@@@@@@@@@@@@@ "+coordinate.get("blockId"));
    	   
       }
    
    
		/*
		 * containerBlock.setDateCreated(new Date()); containerBlock.setStatus("READY");
		 * 
		 * resp = containerBlockService.addContainerBlock(containerBlock);
		 */
    
   
   	    ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("container_block_view");
        ContainerBlockDTO containerBlockDTO = containerBlockService.getContainerBlockByID(Long.parseLong(coordinate.get("blockId")) );
    
    
        List<ContainerBlockCoordinateDTO> containerBlockCoordinateDTOList = containerBlockCoordinateService.getContainerBlockCoordinateByBlockId(Long.parseLong(coordinate.get("blockId")));
        
        modelAndView.addObject("containerBlock", containerBlockDTO);
        modelAndView.addObject("coordinateList", containerBlockCoordinateDTOList);
	
        
        modelAndView.addObject("resp", resp);
    	
        return modelAndView;
    	
    }
	

}
