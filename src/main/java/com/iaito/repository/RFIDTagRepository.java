package com.iaito.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.model.RFIDTag;


@Repository
public interface RFIDTagRepository extends JpaRepository<RFIDTag, String> {

	public RFIDTag findByEpc(String epc);
	public List<RFIDTag> findByStatus(String status);
	
}
