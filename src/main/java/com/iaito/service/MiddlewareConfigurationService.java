package com.iaito.service;

import java.util.List;

import com.iaito.dto.MiddlewareConfigurationDTO;
import com.iaito.model.MiddlewareConfiguration;

public interface MiddlewareConfigurationService {

	public void addMiddlewareConfiguration(MiddlewareConfiguration middlewareConfiguration);
	public MiddlewareConfigurationDTO updateMiddlewareConfiguration(MiddlewareConfiguration middlewareConfiguration);
	public MiddlewareConfigurationDTO getMiddlewareConfigurationByID(long configId);
	public List<MiddlewareConfigurationDTO> getAllMiddlewareConfiguration();
	public void deleteMiddlewareConfiguration(MiddlewareConfiguration middlewareConfiguration);
}
