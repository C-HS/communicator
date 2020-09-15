package com.iaito.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.dto.MiddlewareMqttConnectionStatusDTO;
import com.iaito.model.MiddlewareMqttConnectionStatus;
import com.iaito.repository.MiddlewareMqttConnectionStatusRepository;
import com.iaito.service.MiddlewareMqttConnectionStatusService;

@Service
public class MiddlewareMqttConnectionStatusServiceImpl implements MiddlewareMqttConnectionStatusService{
	
	@Autowired MiddlewareMqttConnectionStatusRepository repository;
	@Autowired ModelMapper modelMapper;

	@Override
	public void addMiddlewareMqttConnectionStatus(MiddlewareMqttConnectionStatus middlewareMqttConnectionStatus) {

		repository.save(middlewareMqttConnectionStatus);
		
	}

	@Override
	public MiddlewareMqttConnectionStatusDTO updateMiddlewareMqttConnectionStatus(
			MiddlewareMqttConnectionStatus middlewareMqttConnectionStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MiddlewareMqttConnectionStatusDTO getMiddlewareMqttConnectionStatusByID(
			long middlewareMqttConnectionStatusId) {

		return modelMapper.map(repository.findById(middlewareMqttConnectionStatusId), MiddlewareMqttConnectionStatusDTO.class);
	}

	@Override
	public MiddlewareMqttConnectionStatusDTO getMiddlewareMqttConnectionStatusByMConfigId(long mConfigId) {

		return modelMapper.map(repository.findMiddlewareMqttConnectionStatusByMConfigId(mConfigId), MiddlewareMqttConnectionStatusDTO.class);
	}

	@Override
	public List<MiddlewareMqttConnectionStatusDTO> getAllMiddlewareMqttConnectionStatus() {

		return repository
				.findAll()
				.stream()
				.map(e -> modelMapper.map(e, MiddlewareMqttConnectionStatusDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteMiddlewareMqttConnectionStatus(MiddlewareMqttConnectionStatus middlewareMqttConnectionStatus) {

		repository.delete(middlewareMqttConnectionStatus);
		
	}

}
