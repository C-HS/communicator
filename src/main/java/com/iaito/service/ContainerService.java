package com.iaito.service;

import java.util.List;

import com.iaito.dto.ContainerDTO;
import com.iaito.model.Container;


public interface ContainerService {
	
	public void addContainer(Container container);
	public ContainerDTO updateContainer(Container container);
	public ContainerDTO getContainerByTID(String tid);
	public List<ContainerDTO> getAllContainer();
	public void deleteContainer(Container container);

}
