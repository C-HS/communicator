package com.iaito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.model.BaseStationMQTTConnectionStatus;

@Repository
public interface BaseStationMQTTConnectionStatusRepository extends JpaRepository<BaseStationMQTTConnectionStatus, Long> {

	public BaseStationMQTTConnectionStatus findBaseStationMQTTConnectionStatusByBsConfigId(long bsConfigId);
}
