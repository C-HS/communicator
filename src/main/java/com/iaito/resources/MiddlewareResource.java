package com.iaito.resources;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.iaito.dto.ContainerDTO;
import com.iaito.dto.MovementAtFixedReaderDTO;
import com.iaito.dto.RFIDReaderDTO;
import com.iaito.dto.response.ResponseDTO;
import com.iaito.model.ContainerMovementAtFixedReader;
import com.iaito.service.ContainerMovementAtFixedReaderService;
import com.iaito.service.ContainerService;
import com.iaito.service.RFIDReaderService;
	
@Controller
public class MiddlewareResource {
	
	@Autowired ContainerMovementAtFixedReaderService movementService;
	
	@Autowired ContainerService containerService;
	
	@Autowired RFIDReaderService readerService;
	
    @PostMapping("/api/middleware/addMovementAtFixedReader")
    public ResponseEntity<ResponseDTO> addTagMovementAtFixedReader(@RequestBody MovementAtFixedReaderDTO movementAtFixedReaderDTO){
    	
    	ResponseDTO response = new ResponseDTO();
    	//System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    	
    	System.out.println("movementAtFixedReaderDTO    "+movementAtFixedReaderDTO);
    	
    	String resp ="error";
    	
    	if(movementAtFixedReaderDTO!=null)
    	{
    		ContainerMovementAtFixedReader movement = new ContainerMovementAtFixedReader();
    		
    		//movement.setReaderId(0);
    		//movement.setContainerId(0);
    		
    		RFIDReaderDTO rFIDReaderDTO = readerService.getRFIDReaderByMiddlewareReaderId(movementAtFixedReaderDTO.getReader_id());
    		
    		if(rFIDReaderDTO!=null && rFIDReaderDTO.getReaderId()!=0)
    		{
    			//System.out.println("rFIDReaderDTO    "+rFIDReaderDTO.getReaderId());
    			movement.setReaderId(rFIDReaderDTO.getReaderId());
    			
    			movement.setReaderLocationId(rFIDReaderDTO.getReaderLocationId());
    			movement.setReaderLocationName(rFIDReaderDTO.getReaderLocationName());	
    		}
    		
    		String tagdata = movementAtFixedReaderDTO.getTagData();
    		
    		tagdata = HextoAscii(tagdata.substring(6));
    		
    		//System.out.println("tagdata    "+tagdata);
    		
    		ContainerDTO containerDTO = containerService.getContainerByContainerNo(tagdata);
    		
    		//System.out.println("containerDTO    "+containerDTO);
    		
    		if(containerDTO!=null && containerDTO.getContainerId()!=0) 
    		{
    		//	System.out.println("containerDTO.getContainerId    "+containerDTO.getContainerId());
    			movement.setContainerId(containerDTO.getContainerId());
    			movement.setContainerNo(containerDTO.getContainerNumber());
    		}
    		
    		
    		movement.setEpc(movementAtFixedReaderDTO.getTagData());
    		
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
    
    public String HextoAscii(String hex){
        byte b[]=new byte[150];
        String ascii="";
        int counter=0,i=0;
        try{

            for(i=0;i<(hex.length());i=i+2,counter++){
                {

                    b[counter]=(byte)Integer.parseInt(hex.substring(i,i+2),16);
                }

            }// end of the for loop
        }catch(Exception ex){ascii="Error";}
        ascii=new String(b).substring(0,counter);
        return ascii;

    }


}