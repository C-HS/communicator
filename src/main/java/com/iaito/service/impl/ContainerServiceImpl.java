package com.iaito.service.impl;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iaito.dto.ContainerDTO;
import com.iaito.dto.RFIDTagDTO;
import com.iaito.model.Container;
import com.iaito.model.RFIDTag;
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
	public String createContainer(Container container) {
		
		try
		{
			modelMapper.map(containerRepository.save(container), ContainerDTO.class);
			
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
	
	@Override
	public ContainerDTO getContainerByContainerNo(String containerNo) {

	//	return modelMapper.map(containerRepository.findContainerByContainerNumber(containerNo), ContainerDTO.class);
		
		Optional<Container> obj = containerRepository.findContainerByContainerNumber(containerNo);
		  
		Container container =null;
		  
		  if(obj.isPresent())
		  {
			  container = obj.get();
			  
			  ContainerDTO dto =modelMapper.map(container, ContainerDTO.class); 
		  
		      return dto;
		  }
		  else
		  {
			  return null;
		  }
	}


}
