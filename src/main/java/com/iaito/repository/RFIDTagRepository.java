package com.iaito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.model.RFIDTag;


@Repository
public interface RFIDTagRepository extends JpaRepository<RFIDTag, String> {

	public RFIDTag findRFIDTagByEPC(String epc);
	
}
