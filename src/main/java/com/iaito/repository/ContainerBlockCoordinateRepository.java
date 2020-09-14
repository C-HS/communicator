package com.iaito.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.model.ContainerBlockCoordinate;

@Repository
public interface ContainerBlockCoordinateRepository  extends JpaRepository<ContainerBlockCoordinate, Long> {
	
	public List<ContainerBlockCoordinate> findContainerBlockCoordinateByBlockId(long blockId);

}
