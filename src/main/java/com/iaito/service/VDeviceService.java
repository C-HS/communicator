package com.iaito.service;

import java.util.List;

import com.iaito.dto.VDeviceDTO;
import com.iaito.model.VDevice;

public interface VDeviceService {

	public String addVDevice(VDevice vDevice);
	public VDeviceDTO updateVDevice(VDevice vDevice);
	public VDeviceDTO getVDeviceByID(long vehicleDeviceId);
	public VDeviceDTO getVDeviceByVDeviceNumber(String vehicleDeviceNo);
	public List<VDeviceDTO> getAllVDevice();
	public void deleteVDevice(VDevice vDevice);
}
