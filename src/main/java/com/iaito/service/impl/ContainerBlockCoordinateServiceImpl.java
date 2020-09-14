package com.iaito.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.dto.ContainerBlockCoordinateDTO;
import com.iaito.model.ContainerBlockCoordinate;
import com.iaito.repository.ContainerBlockCoordinateRepository;
import com.iaito.service.ContainerBlockCoordinateService;

@Service
public class ContainerBlockCoordinateServiceImpl implements ContainerBlockCoordinateService{
	
	@Autowired ContainerBlockCoordinateRepository containerBlockCoordinateRepository;
	@Autowired ModelMapper modelMapper;

	@Override
	public void addContainerBlockCoordinate(ContainerBlockCoordinate containerBlockCoordinate) {

		containerBlockCoordinateRepository.save(containerBlockCoordinate);
		
	}

	@Override
	public ContainerBlockCoordinateDTO updateContainerBlockCoordinate(
			ContainerBlockCoordinate containerBlockCoordinate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContainerBlockCoordinateDTO getContainerBlockCoordinateByID(long coordinateId) {

		return modelMapper.map(containerBlockCoordinateRepository.findById(coordinateId), ContainerBlockCoordinateDTO.class);
	}

	@Override
	public List<ContainerBlockCoordinateDTO> getContainerBlockCoordinateByBlockId(long blockId) {

		return containerBlockCoordinateRepository
				.findContainerBlockCoordinateByBlockId(blockId)
				.stream()
				.map(e -> modelMapper.map(e, ContainerBlockCoordinateDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<ContainerBlockCoordinateDTO> getAllContainerBlockCoordinate() {

		return containerBlockCoordinateRepository
				.findAll()
				.stream()
				.map(e -> modelMapper.map(e, ContainerBlockCoordinateDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteContainerBlockCoordinate(ContainerBlockCoordinate containerBlockCoordinate) {

		containerBlockCoordinateRepository.delete(containerBlockCoordinate);
		
	}

}
