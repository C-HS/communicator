package com.iaito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.model.MiddlewareConfiguration;

@Repository
public interface MiddlewareConfigurationRepository  extends JpaRepository<MiddlewareConfiguration, Long> {

}
