package com.iaito.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.dto.FixedRFIDReaderConnectionStatusDTO;
import com.iaito.model.FixedRFIDReaderConnectionStatus;
import com.iaito.repository.FixedRFIDReaderConnectionStatusRepository;
import com.iaito.service.FixedRFIDReaderConnectionStatusService;

@Service
public class FixedRFIDReaderConnectionStatusServiceImpl implements FixedRFIDReaderConnectionStatusService {

	@Autowired FixedRFIDReaderConnectionStatusRepository repository;
	@Autowired ModelMapper modelMapper;
	
	@Override
	public void addFixedRFIDReaderConnectionStatus(FixedRFIDReaderConnectionStatus fixedRFIDReaderConnectionStatus) {

		repository.save(fixedRFIDReaderConnectionStatus);
		
	}

	@Override
	public FixedRFIDReaderConnectionStatusDTO updateFixedRFIDReaderConnectionStatus(
			FixedRFIDReaderConnectionStatus fixedRFIDReaderConnectionStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FixedRFIDReaderConnectionStatusDTO getFixedRFIDReaderConnectionStatusByID(long statusId) {

		return modelMapper.map(repository.findById(statusId), FixedRFIDReaderConnectionStatusDTO.class);
	}

	@Override
	public FixedRFIDReaderConnectionStatusDTO getFixedRFIDReaderConnectionStatusByReaderId(long readerId) {

		return modelMapper.map(repository.findFixedRFIDReaderConnectionStatusByReaderId(readerId), FixedRFIDReaderConnectionStatusDTO.class);
	}

	@Override
	public List<FixedRFIDReaderConnectionStatusDTO> getAllFixedRFIDReaderConnectionStatus() {

		return repository
				.findAll()
				.stream()
				.map(e -> modelMapper.map(e, FixedRFIDReaderConnectionStatusDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteFixedRFIDReaderConnectionStatus(FixedRFIDReaderConnectionStatus fixedRFIDReaderConnectionStatus) {

		repository.delete(fixedRFIDReaderConnectionStatus);
		
	}

}
