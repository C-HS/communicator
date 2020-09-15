package com.iaito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.model.FixedRFIDReaderConnectionStatus;

@Repository
public interface FixedRFIDReaderConnectionStatusRepository extends JpaRepository<FixedRFIDReaderConnectionStatus, Long> {

	public FixedRFIDReaderConnectionStatus findFixedRFIDReaderConnectionStatusByReaderId(long readerId);
}
