package com.iaito.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.model.ContainerLocationStatus;

@Repository
public interface ContainerLocationStatusRepository extends JpaRepository<ContainerLocationStatus, Long>{

	public List<ContainerLocationStatus> findByVehicleDeviceId(long vehicleDeviceId);
	
	public List<ContainerLocationStatus> findByVehicleId(long vehicleId);
	
	public List<ContainerLocationStatus> findByAreaId(long areaId);
	
	/* public List<ContainerLocationStatus> findByReaderId(long readerId); */
	
	public List<ContainerLocationStatus> findByTid(String tid);
	
	public List<ContainerLocationStatus> findByContainerId(long containerId);
}
