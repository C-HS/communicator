package com.iaito.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iaito.dto.ContainerDTO;
import com.iaito.model.Container;
import com.iaito.repository.ContainerRepository;
import com.iaito.service.ContainerService;

@Service
public class ContainerServiceImpl implements ContainerService {

	@Autowired ContainerRepository containerRepository;
	@Autowired ModelMapper modelMapper;
	
	@Override
	public void addContainer(Container container) {

		containerRepository.save(container);
		
	}

	@Override
	public ContainerDTO updateContainer(Container container) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContainerDTO getContainerByTID(String tid) {

		return modelMapper.map(containerRepository.findContainerByTid(tid), ContainerDTO.class);
	}

	@Override
	public List<ContainerDTO> getAllContainer() {

		return containerRepository
				.findAll()
				.stream()
				.map(e -> modelMapper.map(e, ContainerDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteContainer(Container container) {

		containerRepository.delete(container);
		
	}

}
