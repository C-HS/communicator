package com.iaito.service;

import java.util.List;

import com.iaito.dto.RFIDTagDTO;
import com.iaito.model.RFIDTag;



public interface RFIDTagService {
	
	public RFIDTag addRFIDTag(RFIDTag tag);
	public RFIDTagDTO updateRFIDTag(RFIDTag tag);
	public RFIDTagDTO getRFIDTagByTID(String tid);
	public RFIDTagDTO getRFIDTagByEPC(String epc);
	public List<RFIDTagDTO> getRFIDTagByStatus(String status);
	public List<RFIDTagDTO> getAllRFIDTag();
	public void deleteRFIDTag(RFIDTag tag);

}
