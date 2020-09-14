package com.iaito.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.dto.ContainerAreaDTO;
import com.iaito.model.ContainerArea;
import com.iaito.repository.ContainerAreaRepository;
import com.iaito.service.ContainerAreaService;

@Service
public class ContainerAreaServiceImpl implements ContainerAreaService{
	
	@Autowired ContainerAreaRepository containerAreaRepository;
	@Autowired ModelMapper modelMapper;

	@Override
	public void addContainerArea(ContainerArea containerArea) {
		
		containerAreaRepository.save(containerArea);
		
	}

	@Override
	public ContainerAreaDTO updateContainerArea(ContainerArea containerArea) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContainerAreaDTO getContainerAreaByID(long areaId) {

		return modelMapper.map(containerAreaRepository.findById(areaId), ContainerAreaDTO.class);
	}

	@Override
	public ContainerAreaDTO getContainerAreaByName(String areaName) {

		return modelMapper.map(containerAreaRepository.findContainerAreaByAreaName(areaName), ContainerAreaDTO.class);
	}

	@Override
	public List<ContainerAreaDTO> getAllContainerArea() {

		return containerAreaRepository
				.findAll()
				.stream()
				.map(e -> modelMapper.map(e, ContainerAreaDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteContainerArea(ContainerArea containerArea) {

		containerAreaRepository.delete(containerArea);
		
	}

}
