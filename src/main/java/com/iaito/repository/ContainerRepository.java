package com.iaito.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.model.Container;

@Repository
public interface ContainerRepository extends JpaRepository<Container, Long> {

	public Container findContainerByTid(String tid);
	public Optional<Container> findContainerByContainerNumber(String containerNumber);
}
