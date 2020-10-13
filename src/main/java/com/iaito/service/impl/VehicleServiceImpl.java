package com.iaito.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.iaito.dto.VehicleDTO;
import com.iaito.model.Vehicle;
import com.iaito.repository.VehicleRepository;
import com.iaito.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService{

	 private final VehicleRepository vehicleRepository;
	 private final ModelMapper modelMapper;

	public VehicleServiceImpl(VehicleRepository vehicleRepository, ModelMapper modelMapper) {
		this.vehicleRepository = vehicleRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public VehicleDTO addVehicle(Vehicle vehicle) {
		return modelMapper.map(vehicleRepository.save(vehicle), VehicleDTO.class);
	}

	@Override
	public VehicleDTO updateVehicle(Vehicle vehicle) {
		//return Optional.empty();
		
		return null;
	}

	@Override
	public VehicleDTO getVehicleByID(long vehicleId) {
		return modelMapper.map(vehicleRepository.findById(vehicleId).get(), VehicleDTO.class);
	}

	@Override
	public VehicleDTO getVehicleByVehicleNumber(String vehicleNo) {
		return modelMapper.map(vehicleRepository.findVehicleByVehicleNumber(vehicleNo), VehicleDTO.class);
	}

	@Override
	public List<VehicleDTO> getAllVehicle() {
		return vehicleRepository.findAll()
				.stream()
				.map(e -> modelMapper.map(e,VehicleDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteVehicle(Vehicle vehicle) {
		vehicleRepository.delete(vehicle);
	}
}
