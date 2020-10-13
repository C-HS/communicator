package com.iaito.service;

import java.util.List;

import com.iaito.dto.ContainerBlockCoordinateDTO;
import com.iaito.model.ContainerBlockCoordinate;

public interface ContainerBlockCoordinateService {

	public String addContainerBlockCoordinate(ContainerBlockCoordinate containerBlockCoordinate);
	public ContainerBlockCoordinateDTO updateContainerBlockCoordinate(ContainerBlockCoordinate containerBlockCoordinate);
	public ContainerBlockCoordinateDTO getContainerBlockCoordinateByID(long coordinateId);
	public List<ContainerBlockCoordinateDTO> getContainerBlockCoordinateByBlockId(long blockId);
	public List<ContainerBlockCoordinateDTO> getAllContainerBlockCoordinate();
	public void deleteContainerBlockCoordinate(ContainerBlockCoordinate containerBlockCoordinate);
	
}
