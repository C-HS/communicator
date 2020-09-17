package com.iaito.service;

import java.util.List;

import com.iaito.dto.ContainerLocationStatusDTO;
import com.iaito.model.ContainerLocationStatus;

public interface ContainerLocationStatusService {

	public void addContainerLocationStatus(ContainerLocationStatus containerLocationStatus);
	public ContainerLocationStatusDTO updateContainerLocationStatus(ContainerLocationStatus containerLocationStatus);
	public ContainerLocationStatusDTO getContainerLocationStatusByID(long statusId);
	public List<ContainerLocationStatusDTO> getContainerLocationStatusByVehicleDeviceID(long vehicleDeviceId);
	public List<ContainerLocationStatusDTO> getContainerLocationStatusByVehicleID(long vehicleId);
	public List<ContainerLocationStatusDTO> getContainerLocationStatusByAreaID(long areaId);

	/*
	 * public List<ContainerLocationStatusDTO>
	 * getContainerLocationStatusByReaderID(long readerId);
	 */
	public List<ContainerLocationStatusDTO> getContainerLocationStatusByTID(String tid);
	public List<ContainerLocationStatusDTO> getContainerLocationStatusByContainerID(long containerId);
	public List<ContainerLocationStatusDTO> getAllContainerLocationStatus();
	public void deleteContainerLocationStatus(ContainerLocationStatus containerLocationStatus);
}
