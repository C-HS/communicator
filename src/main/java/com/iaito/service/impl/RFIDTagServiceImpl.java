package com.iaito.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.dto.RFIDTagDTO;
import com.iaito.model.RFIDTag;
import com.iaito.repository.RFIDTagRepository;
import com.iaito.service.RFIDTagService;

@Service
public class RFIDTagServiceImpl implements RFIDTagService{

	@Autowired RFIDTagRepository rfidTagRepository;
	@Autowired ModelMapper modelMapper;
	
	@Override
	public void addRFIDTag(RFIDTag tag) {

		rfidTagRepository.save(tag);
		
	}

	@Override
	public RFIDTagDTO updateRFIDTag(RFIDTag tag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RFIDTagDTO getRFIDTagByTID(String tid) {

		return modelMapper.map(rfidTagRepository.findById(tid), RFIDTagDTO.class);
	}

	@Override
	public List<RFIDTagDTO> getAllRFIDTag() {

		return rfidTagRepository
				.findAll()
				.stream()
				.map(e -> modelMapper.map(e, RFIDTagDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteRFIDTag(RFIDTag tag) {
		rfidTagRepository.delete(tag);
		
	}

	@Override
	public RFIDTagDTO getRFIDTagByEPC(String epc) {

		return modelMapper.map(rfidTagRepository.findByEpc(epc), RFIDTagDTO.class);
	}

	@Override
	public List<RFIDTagDTO> getRFIDTagByStatus(String status) {

		//return modelMapper.map(rfidTagRepository.findByStatus(status), RFIDTagDTO.class);
		
		return rfidTagRepository
				.findByStatus(status)
				.stream()
				.map(e -> modelMapper.map(e, RFIDTagDTO.class))
				.collect(Collectors.toList());
	}

}
