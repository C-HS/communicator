package com.iaito.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.iaito.dto.RFIDReaderDTO;
import com.iaito.model.RFIDReader;
import com.iaito.repository.RFIDReaderRepository;
import com.iaito.service.RFIDReaderService;

public class RFIDReaderServiceImpl implements RFIDReaderService{
	
	@Autowired RFIDReaderRepository rfidReaderRepository;
	@Autowired ModelMapper modelMapper;

	@Override
	public void addRFIDReader(RFIDReader rfidReader) {

		rfidReaderRepository.save(rfidReader);
		
	}

	@Override
	public RFIDReaderDTO updateRFIDReader(RFIDReader rfidReader) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RFIDReaderDTO getRFIDReaderByID(long rfidReaderId) {

		return modelMapper.map(rfidReaderRepository.findById(rfidReaderId), RFIDReaderDTO.class);
	}

	@Override
	public RFIDReaderDTO getRFIDReaderByMiddlewareReaderId(String middlewareReaderId) {

		return modelMapper.map(rfidReaderRepository.findRFIDReaderByMiddlewareReaderId(middlewareReaderId), RFIDReaderDTO.class);
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
