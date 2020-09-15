package com.iaito.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.dto.ContainerMovementAtFixedReaderDTO;
import com.iaito.model.ContainerMovementAtFixedReader;
import com.iaito.repository.ContainerMovementAtFixedReaderRepository;
import com.iaito.service.ContainerMovementAtFixedReaderService;

@Service
public class ContainerMovementAtFixedReaderServiceImpl implements ContainerMovementAtFixedReaderService{

	@Autowired ContainerMovementAtFixedReaderRepository repository;
	@Autowired ModelMapper modelMapper;
	
	@Override
	public void addContainerMovementAtFixedReader(ContainerMovementAtFixedReader containerMovementAtFixedReader) {

		repository.save(containerMovementAtFixedReader);
	}

	@Override
	public ContainerMovementAtFixedReaderDTO updateContainerMovementAtFixedReader(
			ContainerMovementAtFixedReader containerMovementAtFixedReader) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContainerMovementAtFixedReaderDTO getContainerMovementAtFixedReaderByID(long movementId) {

		return modelMapper.map(repository.findById(movementId), ContainerMovementAtFixedReaderDTO.class);
	}

	@Override
	public List<ContainerMovementAtFixedReaderDTO> getContainerMovementAtFixedReaderByReaderID(long readerId) {

		return repository
				.findByReaderId(readerId)
				.stream()
				.map(e -> modelMapper.map(e, ContainerMovementAtFixedReaderDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<ContainerMovementAtFixedReaderDTO> getContainerMovementAtFixedReaderByTID(String tid) {

		return repository
				.findByTID(tid)
				.stream()
				.map(e -> modelMapper.map(e, ContainerMovementAtFixedReaderDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<ContainerMovementAtFixedReaderDTO> getContainerMovementAtFixedReaderByContainerID(long containerId) {

		return repository
				.findByContainerId(containerId)
				.stream()
				.map(e -> modelMapper.map(e, ContainerMovementAtFixedReaderDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<ContainerMovementAtFixedReaderDTO> getAllContainerMovementAtFixedReader() {

		return repository
				.findAll()
				.stream()
				.map(e -> modelMapper.map(e, ContainerMovementAtFixedReaderDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteContainerMovementAtFixedReader(ContainerMovementAtFixedReader containerMovementAtFixedReader) {

		repository.delete(containerMovementAtFixedReader);
		
	}

}
