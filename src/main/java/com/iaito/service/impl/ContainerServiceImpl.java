package com.iaito.service.impl;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
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
	private ContainerRepository containerRepository;
	private ModelMapper modelMapper;

	public ContainerServiceImpl(ContainerRepository containerRepository, ModelMapper modelMapper) {
		this.containerRepository = containerRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public ContainerDTO addContainer(Container container) {
		return modelMapper.map(containerRepository.save(container), ContainerDTO.class);
	}

	@Override
	public ContainerDTO getContainerByTID(String tid) {

		return modelMapper.map(containerRepository.findContainerByTid(tid), ContainerDTO.class);
	}

	@Override
	public Optional<ContainerDTO> getContainerById(long id) {
		return modelMapper.map(containerRepository.findById(id), (Type) ContainerDTO.class);
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
	public void deleteContainer(Long id) {
		containerRepository.deleteById(id);
	}

}
