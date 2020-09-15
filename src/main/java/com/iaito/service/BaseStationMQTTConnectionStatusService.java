package com.iaito.service;

import java.util.List;

import com.iaito.dto.BaseStationMQTTConnectionStatusDTO;
import com.iaito.model.BaseStationMQTTConnectionStatus;

public interface BaseStationMQTTConnectionStatusService {

	public void addBaseStationMQTTConnectionStatus(BaseStationMQTTConnectionStatus baseStationMQTTConnectionStatus);
	public BaseStationMQTTConnectionStatusDTO updateBaseStationMQTTConnectionStatus(BaseStationMQTTConnectionStatus baseStationMQTTConnectionStatus);
	public BaseStationMQTTConnectionStatusDTO getBaseStationMQTTConnectionStatusByID(long statusId);
	public BaseStationMQTTConnectionStatusDTO getBaseStationMQTTConnectionStatusByBsConfigId(long bsConfigId);
	public List<BaseStationMQTTConnectionStatusDTO> getAllBaseStationMQTTConnectionStatus();
	public void deleteBaseStationMQTTConnectionStatus(BaseStationMQTTConnectionStatus baseStationMQTTConnectionStatus);
}
