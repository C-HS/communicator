package com.iaito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.model.BaseStationConfiguration;

@Repository
public interface BaseStationConfigurationRepository extends JpaRepository<BaseStationConfiguration, Long> {

}
