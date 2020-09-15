package com.iaito.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.dto.BaseStationMQTTConnectionStatusDTO;
import com.iaito.model.BaseStationMQTTConnectionStatus;
import com.iaito.repository.BaseStationMQTTConnectionStatusRepository;
import com.iaito.service.BaseStationMQTTConnectionStatusService;

@Service
public class BaseStationMQTTConnectionStatusServiceImpl implements BaseStationMQTTConnectionStatusService{

	@Autowired BaseStationMQTTConnectionStatusRepository repository;
	@Autowired ModelMapper modelMapper;
	
	@Override
	public void addBaseStationMQTTConnectionStatus(BaseStationMQTTConnectionStatus baseStationMQTTConnectionStatus) {

		repository.save(baseStationMQTTConnectionStatus);
	}

	@Override
	public BaseStationMQTTConnectionStatusDTO updateBaseStationMQTTConnectionStatus(
			BaseStationMQTTConnectionStatus baseStationMQTTConnectionStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseStationMQTTConnectionStatusDTO getBaseStationMQTTConnectionStatusByID(long statusId) {

		return modelMapper.map(repository.findById(statusId), BaseStationMQTTConnectionStatusDTO.class);
	}

	@Override
	public BaseStationMQTTConnectionStatusDTO getBaseStationMQTTConnectionStatusByBsConfigId(long bsConfigId) {

		return modelMapper.map(repository.findBaseStationMQTTConnectionStatusByBsConfigId(bsConfigId), BaseStationMQTTConnectionStatusDTO.class);
	}

	@Override
	public List<BaseStationMQTTConnectionStatusDTO> getAllBaseStationMQTTConnectionStatus() {

		return repository
				.findAll()
				.stream()
				.map(e -> modelMapper.map(e, BaseStationMQTTConnectionStatusDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteBaseStationMQTTConnectionStatus(BaseStationMQTTConnectionStatus baseStationMQTTConnectionStatus) {

		repository.delete(baseStationMQTTConnectionStatus);
		
	}

}
