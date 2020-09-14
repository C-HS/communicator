package com.iaito.service;

import java.util.List;

import com.iaito.dto.ContainerBlockDTO;
import com.iaito.model.ContainerBlock;

public interface ContainerBlockService {

	public void addContainerBlock(ContainerBlock containerBlock);
	public ContainerBlockDTO updateContainerBlock(ContainerBlock containerBlock);
	public ContainerBlockDTO getContainerBlockByID(long blockId);
	public ContainerBlockDTO getContainerBlockByName(String blockName);
	public List<ContainerBlockDTO> getAllContainerBlock();
	public void deleteContainerBlock(ContainerBlock containerBlock);
}
