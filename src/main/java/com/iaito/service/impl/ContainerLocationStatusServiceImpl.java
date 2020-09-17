package com.iaito.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.dto.ContainerLocationStatusDTO;
import com.iaito.model.ContainerLocationStatus;
import com.iaito.repository.ContainerLocationStatusRepository;
import com.iaito.service.ContainerLocationStatusService;


@Service
public class ContainerLocationStatusServiceImpl implements ContainerLocationStatusService{

	@Autowired ContainerLocationStatusRepository repository;
	@Autowired ModelMapper modelMapper;
	
	@Override
	public void addContainerLocationStatus(ContainerLocationStatus containerLocationStatus) {

		repository.save(containerLocationStatus);
		
	}

	@Override
	public ContainerLocationStatusDTO updateContainerLocationStatus(ContainerLocationStatus containerLocationStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContainerLocationStatusDTO getContainerLocationStatusByID(long statusId) {

		return modelMapper.map(repository.findById(statusId), ContainerLocationStatusDTO.class);
	}

	@Override
	public List<ContainerLocationStatusDTO> getContainerLocationStatusByVehicleDeviceID(long vehicleDeviceId) {

		return repository
				.findByVehicleDeviceId(vehicleDeviceId)
				.stream()
				.map(e -> modelMapper.map(e, ContainerLocationStatusDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<ContainerLocationStatusDTO> getContainerLocationStatusByVehicleID(long vehicleId) {

		return repository
				.findByVehicleId(vehicleId)
				.stream()
				.map(e -> modelMapper.map(e, ContainerLocationStatusDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<ContainerLocationStatusDTO> getContainerLocationStatusByAreaID(long areaId) {

		return repository
				.findByAreaId(areaId)
				.stream()
				.map(e -> modelMapper.map(e, ContainerLocationStatusDTO.class))
				.collect(Collectors.toList());
	}

	/*
	 * @Override public List<ContainerLocationStatusDTO>
	 * getContainerLocationStatusByReaderID(long readerId) {
	 * 
	 * return repository .findByReaderId(readerId) .stream() .map(e ->
	 * modelMapper.map(e, ContainerLocationStatusDTO.class))
	 * .collect(Collectors.toList()); }
	 */

	@Override
	public List<ContainerLocationStatusDTO> getContainerLocationStatusByTID(String tid) {
		
		return repository
				.findByTid(tid)
				.stream()
				.map(e -> modelMapper.map(e, ContainerLocationStatusDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<ContainerLocationStatusDTO> getContainerLocationStatusByContainerID(long containerId) {

		return repository
				.findByContainerId(containerId)
				.stream()
				.map(e -> modelMapper.map(e, ContainerLocationStatusDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<ContainerLocationStatusDTO> getAllContainerLocationStatus() {

		return repository
				.findAll()
				.stream()
				.map(e -> modelMapper.map(e, ContainerLocationStatusDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteContainerLocationStatus(ContainerLocationStatus containerLocationStatus) {

		repository.delete(containerLocationStatus);
		
	}



}
