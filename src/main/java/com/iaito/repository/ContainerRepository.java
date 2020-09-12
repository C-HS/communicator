package com.iaito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.model.Container;
import com.iaito.model.RFIDTag;

@Repository
public interface ContainerRepository extends JpaRepository<Container, Long> {

	public RFIDTag findContainerByTID(String tid);
}
