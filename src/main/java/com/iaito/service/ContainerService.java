package com.iaito.service;

import java.util.List;
import java.util.Optional;

import com.iaito.dto.ContainerDTO;
import com.iaito.model.Container;


public interface ContainerService {
	
	public ContainerDTO addContainer(Container container);
	public ContainerDTO getContainerByTID(String tid);
	public Optional<ContainerDTO> getContainerById(long id);
	public List<ContainerDTO> getAllContainer();
	public void deleteContainer(Long id);
	public String createContainer(Container container);
	public ContainerDTO getContainerByContainerNo(String containerNo);

}
