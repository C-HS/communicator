package com.iaito.resources;

import java.util.Date;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iaito.dto.ContainerDTO;
import com.iaito.dto.RFIDTagDTO;
import com.iaito.dto.response.ResponseDTO;
import com.iaito.model.RFIDTag;
import com.iaito.service.ContainerService;
import com.iaito.service.RFIDTagService;

@RestController
public class RFIDTagResource {
	
    private final RFIDTagService rfidTagService;
    private final ContainerService containerService;
    private final ModelMapper modelMapper;

    @Autowired
    public RFIDTagResource(RFIDTagService rfidTagService,ContainerService containerService, ModelMapper modelMapper) {
        this.rfidTagService = rfidTagService;
        this.containerService = containerService;
        this.modelMapper = modelMapper;
        
    }

	

	@RequestMapping(value = "/api/rfidtag/register", method = RequestMethod.POST)
	public ResponseEntity<ResponseDTO> registerRFIDTag(@RequestBody RFIDTagDTO rfidTagDTO) {

		System.out.println("rfidTagDTO " + rfidTagDTO.toString());

		// System.out.println("rfidTagDTO "+st);

		RFIDTag tag = new RFIDTag();

		tag.setTid(rfidTagDTO.getTid());
		tag.setEpc("");
		tag.setRegisterDate(new Date());
		tag.setStatus("FREE");
		
		
		RFIDTagDTO existingTag = null;
		
		existingTag = rfidTagService.getRFIDTagByTID(rfidTagDTO.getTid());
		
		System.out.println("existingTag "+existingTag);
		
		ResponseDTO response = new ResponseDTO();
		
		
		  if(existingTag==null) 
		  { 
			      rfidTagService.addRFIDTag(tag);
			  
				  response.setStatus("success"); response.setMessage("Registered");
				  
				  return ResponseEntity.status(201).body(response); 

		  } 
		  else 
		  {
			  response.setStatus("fail"); response.setMessage("Tag Already Registered");
			  
			  return ResponseEntity.status(200).body(response); 
		  }
		 
		
		
			/*
			 * rfidTagService.addRFIDTag(tag); response.setStatus("success");
			 * response.setMessage("Registered");
			 * 
			 * return ResponseEntity.status(201).body(response);
			 */
		
		/*
		 * if(existingTag.getTid()==null ) {
		 * System.out.println("rfidTagService.addRFIDTag(tag) "+rfidTagService.
		 * addRFIDTag(tag)); if(rfidTagService.addRFIDTag(tag)!=null) {
		 * response.setStatus("success"); response.setMessage("Registered");
		 * 
		 * return ResponseEntity.status(201).body(response); } else {
		 * response.setStatus("fail"); response.setMessage("Error");
		 * 
		 * return ResponseEntity.status(201).body(response); } }
		 */
		
	}
	
    @GetMapping("/api/rfidtag/{tid}")
    public ResponseEntity<RFIDTagDTO> getTagById(@PathVariable String tid){
    	
    	RFIDTagDTO tag = rfidTagService.getRFIDTagByTID(tid);
    	
    	if(tag==null)
    		tag = new RFIDTagDTO();
    	
        return ResponseEntity.ok(tag);

    }
    
    
    @PutMapping("/api/rfidtag/mapcontainerandtag")
    public ResponseEntity<ResponseDTO> mapTagWithContainer(@RequestBody ContainerDTO containerDTO){
    	
    	ResponseDTO response = new ResponseDTO();
    	
    	RFIDTagDTO tag = rfidTagService.getRFIDTagByTID(containerDTO.getTid());
    	
    	if(tag!=null)
    	{
    		if("FREE".equals(tag.getStatus()))
    		{
	        	containerDTO.setTaggingDate(new Date());
	        	
	        	String resp = "";
	        	resp = containerService.mapContainerWithRFIDTag(containerDTO);
	        	
	        	if("success".equals(resp))
	        	{
	        		
	        		resp = "";
	        		resp = rfidTagService.setStatusAsAttached(containerDTO.getTid(),containerDTO.getContainerNumber());
	        		
	        		if(resp.equals("success"))
	        		{
	        			response.setStatus("Successfully");
	        			response.setMessage("Mapped ");
	        		}
	        		else
	        		{
	        			response.setStatus("Fail");
	        			response.setMessage("Exception In Updated RfidTag");
	        		}
	        	}
	        	else
	    		{
	    			response.setStatus("Fail");
	    			response.setMessage("Exception In Updated Container");
	    		}
    		}
    		else
    		{
    			response.setStatus("Fail");
    			response.setMessage("Tag Already Attached To Container No "+tag.getEpc());
    		}
    		
    	}
    	else
    	{
    		response.setStatus("Fail");
			response.setMessage("Un Registered Tag");
    	}
    	
    	 return ResponseEntity.status(200).body(response); 

    }

}
