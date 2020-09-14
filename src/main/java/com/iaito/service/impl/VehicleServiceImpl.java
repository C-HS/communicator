package com.iaito.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.dto.VehicleDTO;
import com.iaito.model.Vehicle;
import com.iaito.repository.VehicleRepository;
import com.iaito.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService{

	@Autowired VehicleRepository vehicleRepository;
	@Autowired ModelMapper modelMapper;
	
	@Override
	public void addVehicle(Vehicle vehicle) {

		vehicleRepository.save(vehicle);
	}

	@Override
	public VehicleDTO updateVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VehicleDTO getVehicleByID(long vehicleId) {

		return modelMapper.map(vehicleRepository.findById(vehicleId), VehicleDTO.class);
	}

	@Override
	public VehicleDTO getVehicleByVehicleNumber(String vehicleNo) {

		return modelMapper.map(vehicleRepository.findVehicleByVehicleNumber(vehicleNo), VehicleDTO.class);
	}

	@Override
	public List<VehicleDTO> getAllVehicle() {

		return vehicleRepository
				.findAll()
				.stream()
				.map(e -> modelMapper.map(e, VehicleDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteVehicle(Vehicle vehicle) {

		vehicleRepository.delete(vehicle);
		
	}

}
