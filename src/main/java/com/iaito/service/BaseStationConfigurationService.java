package com.iaito.service;

import java.util.List;

import com.iaito.dto.BaseStationConfigurationDTO;
import com.iaito.model.BaseStationConfiguration;

public interface BaseStationConfigurationService {
	
	public String addBaseStationConfiguration(BaseStationConfiguration baseStationConfiguration);
	public BaseStationConfigurationDTO updateBaseStationConfiguration(BaseStationConfiguration baseStationConfiguration);
	public BaseStationConfigurationDTO getBaseStationConfigurationByID(long configId);
	public List<BaseStationConfigurationDTO> getAllBaseStationConfiguration();
	public void deleteBaseStationConfiguration(BaseStationConfiguration baseStationConfiguration);

}
