package com.iaito.service;

import java.util.List;

import com.iaito.dto.VehicleDTO;
import com.iaito.model.Vehicle;

public interface VehicleService {

	public VehicleDTO addVehicle(Vehicle vehicle);
	public VehicleDTO updateVehicle(Vehicle vehicle);
	public VehicleDTO getVehicleByID(long vehicleId);
	public VehicleDTO getVehicleByVehicleNumber(String vehicleNo);
	public List<VehicleDTO> getAllVehicle();
	public void deleteVehicle(Vehicle vehicle);
}
