package com.iaito.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.dto.BaseStationConfigurationDTO;
import com.iaito.dto.MiddlewareConfigurationDTO;
import com.iaito.model.BaseStationConfiguration;
import com.iaito.repository.BaseStationConfigurationRepository;
import com.iaito.service.BaseStationConfigurationService;

@Service
public class BaseStationConfigurationServiceImpl implements BaseStationConfigurationService {

	@Autowired BaseStationConfigurationRepository baseStationConfigurationRepository;
	@Autowired ModelMapper modelMapper;
	
	@Override
	public String addBaseStationConfiguration(BaseStationConfiguration baseStationConfiguration) {
		
		//baseStationConfigurationRepository.save(baseStationConfiguration);
		
		
		try
		{
			modelMapper.map(baseStationConfigurationRepository.save(baseStationConfiguration), BaseStationConfigurationDTO.class);
			
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
	public BaseStationConfigurationDTO updateBaseStationConfiguration(
			BaseStationConfiguration baseStationConfiguration) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseStationConfigurationDTO getBaseStationConfigurationByID(long configId) {

		return modelMapper.map(baseStationConfigurationRepository.findById(configId).get(), BaseStationConfigurationDTO.class);
	}

	@Override
	public List<BaseStationConfigurationDTO> getAllBaseStationConfiguration() {

		return baseStationConfigurationRepository
				.findAll()
				.stream()
				.map(e -> modelMapper.map(e, BaseStationConfigurationDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteBaseStationConfiguration(BaseStationConfiguration baseStationConfiguration) {

		baseStationConfigurationRepository.delete(baseStationConfiguration);
		
	}

}
