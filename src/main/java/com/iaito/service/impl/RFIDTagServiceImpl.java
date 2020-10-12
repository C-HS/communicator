package com.iaito.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.dto.ContainerDTO;
import com.iaito.dto.RFIDTagDTO;
import com.iaito.model.Container;
import com.iaito.model.RFIDTag;
import com.iaito.repository.RFIDTagRepository;
import com.iaito.service.RFIDTagService;

@Service
public class RFIDTagServiceImpl implements RFIDTagService{

	@Autowired RFIDTagRepository rfidTagRepository;
	@Autowired ModelMapper modelMapper;
	
	@Override
	public RFIDTag addRFIDTag(RFIDTag tag) {
		
		RFIDTag t = rfidTagRepository.save(tag);
		
		//System.out.println("t "+t.toString());

		return t;
		
	}

	@Override
	public RFIDTagDTO updateRFIDTag(RFIDTag tag) {
		// TODO Auto-generated method stub
		return null;
	}

	
	  @Override public RFIDTagDTO getRFIDTagByTID(String tid) {
	  
		  
		  Optional<RFIDTag> obj = rfidTagRepository.findById(tid);
		  
		  RFIDTag tag =null;
		  
		  if(obj.isPresent())
		  {
			  tag = obj.get();
			  
			  RFIDTagDTO dto =modelMapper.map(tag, RFIDTagDTO.class); 
		  
		      return dto;
		  }
		  else
		  {
			  return null;
		  }
		  

	  }
	 
	


	@Override
	public List<RFIDTagDTO> getAllRFIDTag() {

		return rfidTagRepository
				.findAll()
				.stream()
				.map(e -> modelMapper.map(e, RFIDTagDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteRFIDTag(RFIDTag tag) {
		rfidTagRepository.delete(tag);
		
	}

	@Override
	public RFIDTagDTO getRFIDTagByEPC(String epc) {

		return modelMapper.map(rfidTagRepository.findByEpc(epc), RFIDTagDTO.class);
	}

	@Override
	public List<RFIDTagDTO> getRFIDTagByStatus(String status) {

		//return modelMapper.map(rfidTagRepository.findByStatus(status), RFIDTagDTO.class);
		
		return rfidTagRepository
				.findByStatus(status)
				.stream()
				.map(e -> modelMapper.map(e, RFIDTagDTO.class))
				.collect(Collectors.toList());
	}
	
	
	@Override
	public String setStatusAsAttached(String tid,String containerNo) {
		
		try
		{
			
			RFIDTag tag = rfidTagRepository.findById(tid).get();
			
			tag.setStatus("ATTACHED");
			tag.setEpc(containerNo);
			tag.setAttachedDate(new Date());
			
			modelMapper.map(rfidTagRepository.save(tag), RFIDTagDTO.class);
			
			return "success";
		}
		catch(Exception e)
		{
			return "mapping_error";	
		}
	}

}
