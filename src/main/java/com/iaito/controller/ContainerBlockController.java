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

import com.iaito.dto.ContainerBlockDTO;
import com.iaito.model.ContainerBlock;
import com.iaito.service.ContainerBlockService;

@Controller
public class ContainerBlockController {
	
	@Autowired ContainerBlockService containerBlockService;
	
    @PostMapping("/createContainerBlock")
    public ModelAndView createRFIDReader(@ModelAttribute ContainerBlock containerBlock)
    {
    	String resp= "";
    	

    
    	containerBlock.setDateCreated(new Date());
    	containerBlock.setStatus("READY");
        	
        resp = containerBlockService.addContainerBlock(containerBlock);
    
   
    	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("container_block_registration");
        
     //   System.out.println("@@@@@@@@@@@@@@@@@@ "+resp);
        
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
        
        
        modelAndView.addObject("containerBlock", containerBlockDTO);
    	
        return modelAndView;
    }

}
