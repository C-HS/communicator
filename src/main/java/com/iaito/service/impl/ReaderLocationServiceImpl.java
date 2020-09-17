package com.iaito.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.dto.ReaderLocationDTO;
import com.iaito.model.ReaderLocation;
import com.iaito.repository.ReaderLocationRepository;
import com.iaito.service.ReaderLocationService;

@Service
public class ReaderLocationServiceImpl implements ReaderLocationService{
	
	@Autowired ReaderLocationRepository readerLocationRepository;
	@Autowired ModelMapper modelMapper;

	@Override
	public void addReaderLocation(ReaderLocation readerLocation) {

		readerLocationRepository.save(readerLocation);
		
	}

	@Override
	public ReaderLocationDTO updateReaderLocation(ReaderLocation readerLocation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReaderLocationDTO getReaderLocationByID(long readerLocationId) {

		return modelMapper.map(readerLocationRepository.findById(readerLocationId), ReaderLocationDTO.class);
	}

	@Override
	public ReaderLocationDTO getReaderLocationByName(String readerLocationName) {

		return modelMapper.map(readerLocationRepository.findReaderLocationByReaderLocationName(readerLocationName), ReaderLocationDTO.class);
	}

	@Override
	public List<ReaderLocationDTO> getAllReaderLocation() {

		return readerLocationRepository
				.findAll()
				.stream()
				.map(e -> modelMapper.map(e, ReaderLocationDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteReaderLocation(ReaderLocation readerLocation) {

		readerLocationRepository.delete(readerLocation);
		
	}

}
