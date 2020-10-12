package com.iaito.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.dto.MiddlewareConfigurationDTO;
import com.iaito.dto.RFIDReaderDTO;
import com.iaito.model.MiddlewareConfiguration;
import com.iaito.repository.MiddlewareConfigurationRepository;
import com.iaito.service.MiddlewareConfigurationService;

@Service
public class MiddlewareConfigurationServiceImpl implements MiddlewareConfigurationService {
	
	@Autowired MiddlewareConfigurationRepository middlewareConfigurationRepository;
	@Autowired ModelMapper modelMapper;

	@Override
	public String addMiddlewareConfiguration(MiddlewareConfiguration middlewareConfiguration) {

	//	middlewareConfigurationRepository.save(middlewareConfiguration);
		
		try
		{
			modelMapper.map(middlewareConfigurationRepository.save(middlewareConfiguration), MiddlewareConfigurationDTO.class);
			
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
	public MiddlewareConfigurationDTO updateMiddlewareConfiguration(MiddlewareConfiguration middlewareConfiguration) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MiddlewareConfigurationDTO getMiddlewareConfigurationByID(long configId) {

		return modelMapper.map(middlewareConfigurationRepository.findById(configId).get(), MiddlewareConfigurationDTO.class);
	}

	@Override
	public List<MiddlewareConfigurationDTO> getAllMiddlewareConfiguration() {

		return middlewareConfigurationRepository
				.findAll()
				.stream()
				.map(e -> modelMapper.map(e, MiddlewareConfigurationDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteMiddlewareConfiguration(MiddlewareConfiguration middlewareConfiguration) {

		middlewareConfigurationRepository.delete(middlewareConfiguration);
		
	}

}
