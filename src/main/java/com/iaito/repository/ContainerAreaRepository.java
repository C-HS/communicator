package com.iaito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.model.Asset;
import com.iaito.model.ContainerArea;

@Repository
public interface ContainerAreaRepository extends JpaRepository<ContainerArea, Long>{

	public Asset findContainerAreaByAreaName(String areaName);
}
