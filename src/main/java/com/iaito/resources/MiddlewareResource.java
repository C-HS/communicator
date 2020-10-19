package com.iaito.resources;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.iaito.dto.MovementAtFixedReaderDTO;
import com.iaito.dto.response.ResponseDTO;
import com.iaito.model.ContainerMovementAtFixedReader;
import com.iaito.service.ContainerMovementAtFixedReaderService;

@Controller
public class MiddlewareResource {
	
	ContainerMovementAtFixedReaderService movementService;
	
    @PostMapping("/api/middleware/addMovementAtFixedReader")
    public ResponseEntity<ResponseDTO> addTagMovementAtFixedReader(@RequestBody MovementAtFixedReaderDTO movementAtFixedReaderDTO){
    	
    	ResponseDTO response = new ResponseDTO();
    	
    	String resp ="error";
    	
    	if(movementAtFixedReaderDTO!=null)
    	{
    		ContainerMovementAtFixedReader movement = new ContainerMovementAtFixedReader();
    		
    		movement.setRefReader(movementAtFixedReaderDTO.getReader_id());
    		movement.setAntenna(movementAtFixedReaderDTO.getAntenna());
    		movement.setMovementType(movementAtFixedReaderDTO.getMovementType());
    		movement.setDateTime(new Date());
    		
    		resp = movementService.addContainerMovementAtFixedReader(movement);
    	}
    	
    	response.setStatus(resp);
    	response.setMessage(resp);
    	
    	
    	return ResponseEntity.status(200).body(response); 
    }

}
