package com.iaito.service;

import java.util.List;

import com.iaito.dto.ReaderLocationDTO;
import com.iaito.model.ReaderLocation;

public interface ReaderLocationService {
	
	public ReaderLocationDTO addReaderLocation(ReaderLocation readerLocation);
	public ReaderLocationDTO updateReaderLocation(ReaderLocation readerLocation);
	public ReaderLocationDTO getReaderLocationByID(long readerLocationId);
	public ReaderLocationDTO getReaderLocationByName(String readerLocationName);
	public List<ReaderLocationDTO> getAllReaderLocation();
	public void deleteReaderLocation(ReaderLocation readerLocation);

}
