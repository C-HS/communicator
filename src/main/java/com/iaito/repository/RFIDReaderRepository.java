package com.iaito.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.model.RFIDReader;

@Repository
public interface RFIDReaderRepository extends JpaRepository<RFIDReader, Long>  {

	public Optional<RFIDReader> findRFIDReaderByMiddlewareReaderId(String middlewareReaderId);
}
