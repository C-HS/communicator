package com.iaito.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Entity
@Table(name = "MiddlewareConfiguration")
public class MiddlewareConfiguration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mconfig_id")
	private long mConfigId;
	
	@Column(name = "data_aquizition_url")
	private String dataAquizitionURL;
	
	@Column(name = "mqtt_notification_topic")
	private String mqttNotificationTopic;
	
	@Column(name = "web_service_ip")
	private String webServiceIP;
	
	@Column(name = "web_service_port")
	private String webServicePort;
	
	@Column(name = "mqtt_client_id")
	private String mqttClientId;
	
	@Column(name = "mqtt_host")
	private String mqttHost;
	
	@Column(name = "date_created")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	
	@Column(name = "status")
	private String status;
	
}
