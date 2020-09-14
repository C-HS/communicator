package com.iaito.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.dto.VDeviceDTO;
import com.iaito.model.VDevice;
import com.iaito.repository.VDeviceRepository;
import com.iaito.service.VDeviceService;


@Service
public class VDeviceServiceImpl implements VDeviceService{

	
	@Autowired VDeviceRepository vDeviceRepository;
	@Autowired ModelMapper modelMapper;
	
	@Override
	public void addVDevice(VDevice vDevice) {

		vDeviceRepository.save(vDevice);
		
	}

	@Override
	public VDeviceDTO updateVDevice(VDevice vDevice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VDeviceDTO getVDeviceByID(long vehicleDeviceId) {

		return modelMapper.map(vDeviceRepository.findById(vehicleDeviceId), VDeviceDTO.class);
	}

	@Override
	public VDeviceDTO getVDeviceByVDeviceNumber(String vehicleDeviceNo) {

		return modelMapper.map(vDeviceRepository.findVDeviceByVDeviceNumber(vehicleDeviceNo), VDeviceDTO.class);
	}

	@Override
	public List<VDeviceDTO> getAllVDevice() {

		return vDeviceRepository
				.findAll()
				.stream()
				.map(e -> modelMapper.map(e, VDeviceDTO.class))
				.collect(Collectors.toList());
		
	}

	@Override
	public void deleteVDevice(VDevice vDevice) {

		vDeviceRepository.delete(vDevice);
		
	}

}
