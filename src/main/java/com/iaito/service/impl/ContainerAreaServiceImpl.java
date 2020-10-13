package com.iaito.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.dto.ContainerAreaDTO;
import com.iaito.dto.ContainerBlockDTO;
import com.iaito.model.ContainerArea;
import com.iaito.repository.ContainerAreaRepository;
import com.iaito.service.ContainerAreaService;

@Service
public class ContainerAreaServiceImpl implements ContainerAreaService{
	
	@Autowired ContainerAreaRepository containerAreaRepository;
	@Autowired ModelMapper modelMapper;

	@Override
	public String addContainerArea(ContainerArea containerArea) {
		
		//containerAreaRepository.save(containerArea);
		
		try
		{
			modelMapper.map(containerAreaRepository.save(containerArea), ContainerAreaDTO.class);
			
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
	public ContainerAreaDTO updateContainerArea(ContainerArea containerArea) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContainerAreaDTO getContainerAreaByID(long areaId) {

		return modelMapper.map(containerAreaRepository.findById(areaId).get(), ContainerAreaDTO.class);
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
