package com.iaito.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.model.ContainerMovementAtFixedReader;

@Repository
public interface ContainerMovementAtFixedReaderRepository extends JpaRepository<ContainerMovementAtFixedReader, Long> {

	public List<ContainerMovementAtFixedReader> findByReaderId(long readerId);
	
	public List<ContainerMovementAtFixedReader> findByTid(String tid);
	
	public List<ContainerMovementAtFixedReader> findByContainerId(long containerId);
}
