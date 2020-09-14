package com.iaito.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BaseStationConfigurationDTO {

	private long bsConfigId;

	private String mqttDataTopic;

	private long mqttClientId;

	private String mqttHost;
	
	private Date dateCreated;

	private String status;
}
