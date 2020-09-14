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
public class MiddlewareConfigurationDTO {

	private long mConfigId;

	private String dataAquizitionURL;

	private String mqttNotificationTopic;

	private String webServiceIP;

	private String webServicePort;

	private long mqttClientId;

	private String mqttHost;

	private Date dateCreated;
	
	private String status;
}
