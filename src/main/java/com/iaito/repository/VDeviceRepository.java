package com.iaito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.model.VDevice;

@Repository
public interface VDeviceRepository  extends JpaRepository<VDevice, Long> {
	
	public VDevice findByVehicleDeviceNumber(String vehicleDeviceNumber);

}
