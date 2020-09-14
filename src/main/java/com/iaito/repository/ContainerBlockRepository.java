package com.iaito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.model.ContainerBlock;
import com.iaito.model.Vehicle;

@Repository
public interface ContainerBlockRepository extends JpaRepository<ContainerBlock, Long> {

	public Vehicle findContainerBlockByName(String containerBlockName);
}
