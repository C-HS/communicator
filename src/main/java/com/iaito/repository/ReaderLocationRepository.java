package com.iaito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.model.ReaderLocation;
import com.iaito.model.Vehicle;

@Repository
public interface ReaderLocationRepository  extends JpaRepository<ReaderLocation, Long> {

	public Vehicle findReaderLocationByName(String readerLocationName);
}
