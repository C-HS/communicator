package com.iaito.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.dto.RFIDReaderDTO;
import com.iaito.dto.RFIDTagDTO;
import com.iaito.dto.VDeviceDTO;
import com.iaito.model.RFIDReader;
import com.iaito.model.RFIDTag;
import com.iaito.repository.RFIDReaderRepository;
import com.iaito.service.RFIDReaderService;

@Service
public class RFIDReaderServiceImpl implements RFIDReaderService{
	
	@Autowired RFIDReaderRepository rfidReaderRepository;
	@Autowired ModelMapper modelMapper;

	@Override
	public String addRFIDReader(RFIDReader rfidReader) {

	//	rfidReaderRepository.save(rfidReader);
		
		try
		{
			modelMapper.map(rfidReaderRepository.save(rfidReader), RFIDReaderDTO.class);
			
			return "success";
		}
		catch(org.springframework.dao.DataIntegrityViolationException e)
		{
			return "already_exist";			
		}
		catch(Exception e)
		{
			return "register_error";	
		}
		
		
	}

	@Override
	public RFIDReaderDTO updateRFIDReader(RFIDReader rfidReader) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RFIDReaderDTO getRFIDReaderByID(long rfidReaderId) {

		return modelMapper.map(rfidReaderRepository.findById(rfidReaderId).get(), RFIDReaderDTO.class);
	}

	@Override
	public RFIDReaderDTO getRFIDReaderByMiddlewareReaderId(String middlewareReaderId) {

		//return modelMapper.map(rfidReaderRepository.findRFIDReaderByMiddlewareReaderId(middlewareReaderId), RFIDReaderDTO.class);
		
		  Optional<RFIDReader> obj = rfidReaderRepository.findRFIDReaderByMiddlewareReaderId(middlewareReaderId);
		  
		  RFIDReader reader =null;
		  
		  if(obj.isPresent())
		  {
			  reader = obj.get();
			  
			  RFIDReaderDTO dto =modelMapper.map(reader, RFIDReaderDTO.class); 
		  
		      return dto;
		  }
		  else
		  {
			  return null;
		  }
		  
	}

	@Override
	public List<RFIDReaderDTO> getAllRFIDReader() {
		return rfidReaderRepository
				.findAll()
				.stream()
				.map(e -> modelMapper.map(e, RFIDReaderDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteRFIDReader(RFIDReader rfidReader) {

		rfidReaderRepository.delete(rfidReader);
		
	}

}
