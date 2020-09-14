package com.iaito.service.impl;

import java.util.List;

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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MiddlewareMqttConnectionStatusDTO getMiddlewareMqttConnectionStatusByMConfigId(long mConfigId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MiddlewareMqttConnectionStatusDTO> getAllMiddlewareMqttConnectionStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMiddlewareMqttConnectionStatus(MiddlewareMqttConnectionStatus middlewareMqttConnectionStatus) {
		// TODO Auto-generated method stub
		
	}

}
