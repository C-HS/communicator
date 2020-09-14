package com.iaito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.model.MiddlewareMqttConnectionStatus;
import com.iaito.model.RFIDTag;

@Repository
public interface MiddlewareMqttConnectionStatusRepository extends JpaRepository<MiddlewareMqttConnectionStatus, Long>{

	public RFIDTag findMiddlewareMqttConnectionStatusByMConfigId(long mConfigId);
}
