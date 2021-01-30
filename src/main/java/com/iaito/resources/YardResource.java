package com.iaito.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iaito.dto.Area;
import com.iaito.dto.Block;
import com.iaito.dto.ContainerBlockDTO;
import com.iaito.service.ContainerAreaService;
import com.iaito.service.ContainerBlockService;

@RestController
public class YardResource {
	
	@Autowired ContainerBlockService containerBlockService;
	@Autowired ContainerAreaService containerAreaService;
	
    @GetMapping("/api/getContainerBlockList")
    public ResponseEntity<List<ContainerBlockDTO>> containerBlocks(){
    	
        
        List<ContainerBlockDTO> blockList = new ArrayList<>();
        
        blockList = containerBlockService.getAllContainerBlock();

    	
        return ResponseEntity.ok(blockList);
    }
    
	  @PostMapping("/api/addContainerBlock") 
	  public ResponseEntity<String> createContainerBlock(@RequestBody Block Block) 
	  { 		  
			/*
			 * ContainerBlock containerBlock = new ContainerBlock();
			 * 
			 * containerBlock.setDateCreated(new Date()); containerBlock.setStatus("READY");
			 * 
			 * resp = containerBlockService.addContainerBlock(containerBlock);
			 */
		  
		  System.out.println("@@@@@@@@@@@@@@@@@@ "+Block);
		  
		  return ResponseEntity.ok("success");
		  
	  }
	  
	  @PostMapping("/api/addContainerArea") 
	  public ResponseEntity<String> createContainerArea(@RequestBody Area area) 
	  { 		  
			/*
			 * ContainerBlock containerBlock = new ContainerBlock();
			 * 
			 * containerBlock.setDateCreated(new Date()); containerBlock.setStatus("READY");
			 * 
			 * resp = containerBlockService.addContainerBlock(containerBlock);
			 */
		  
		  System.out.println("@@@@@@@@@@@@@@@@@@ "+area);
		  
		  return ResponseEntity.ok("success");
		  
	  }

}
