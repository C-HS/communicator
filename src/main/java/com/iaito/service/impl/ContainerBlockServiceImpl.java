package com.iaito.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.dto.ContainerBlockDTO;
import com.iaito.model.ContainerBlock;
import com.iaito.repository.ContainerBlockRepository;
import com.iaito.service.ContainerBlockService;

@Service
public class ContainerBlockServiceImpl implements ContainerBlockService{

	@Autowired ContainerBlockRepository containerBlockRepository;
	@Autowired ModelMapper modelMapper;
	
	@Override
	public void addContainerBlock(ContainerBlock containerBlock) {

		containerBlockRepository.save(containerBlock);
		
	}

	@Override
	public ContainerBlockDTO updateContainerBlock(ContainerBlock containerBlock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContainerBlockDTO getContainerBlockByID(long blockId) {

		return modelMapper.map(containerBlockRepository.findById(blockId), ContainerBlockDTO.class);
	}

	@Override
	public ContainerBlockDTO getContainerBlockByName(String blockName) {

		return modelMapper.map(containerBlockRepository.findByBlockName(blockName), ContainerBlockDTO.class);
	}

	@Override
	public List<ContainerBlockDTO> getAllContainerBlock() {

		return containerBlockRepository
				.findAll()
				.stream()
				.map(e -> modelMapper.map(e, ContainerBlockDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteContainerBlock(ContainerBlock containerBlock) {

		containerBlockRepository.delete(containerBlock);
		
	}

}
