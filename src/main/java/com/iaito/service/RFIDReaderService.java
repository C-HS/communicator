package com.iaito.service;

import java.util.List;

import com.iaito.dto.RFIDReaderDTO;
import com.iaito.model.RFIDReader;

public interface RFIDReaderService {

	public void addRFIDReader(RFIDReader rfidReader);
	public RFIDReaderDTO updateRFIDReader(RFIDReader rfidReader);
	public RFIDReaderDTO getRFIDReaderByID(long rfidReaderId);
	public RFIDReaderDTO getRFIDReaderByMiddlewareReaderId(String middlewareReaderId);
	public List<RFIDReaderDTO> getAllRFIDReader();
	public void deleteRFIDReader(RFIDReader rfidReader);
}
