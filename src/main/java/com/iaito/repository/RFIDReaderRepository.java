package com.iaito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.model.RFIDReader;

@Repository
public interface RFIDReaderRepository extends JpaRepository<RFIDReader, Long>  {

	public RFIDReader findRFIDReaderByMiddlewareReaderId(String middlewareReaderId);
}
