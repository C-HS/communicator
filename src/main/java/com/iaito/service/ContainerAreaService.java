package com.iaito.service;

import java.util.List;

import com.iaito.dto.ContainerAreaDTO;
import com.iaito.model.ContainerArea;

public interface ContainerAreaService {

	public void addContainerArea(ContainerArea containerArea);
	public ContainerAreaDTO updateContainerArea(ContainerArea containerArea);
	public ContainerAreaDTO getContainerAreaByID(long areaId);
	public ContainerAreaDTO getContainerAreaByName(String areaName);
	public List<ContainerAreaDTO> getAllContainerArea();
	public void deleteContainerArea(ContainerArea containerArea);
}
