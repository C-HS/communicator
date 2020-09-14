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
@Table(name = "BaseStationConfiguration")
public class BaseStationConfiguration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bsconfig_id")
	private long bsConfigId;
	
	@Column(name = "mqtt_data_topic")
	private String mqttDataTopic;
	
	@Column(name = "mqtt_client_id")
	private long mqttClientId;
	
	@Column(name = "mqtt_host")
	private String mqttHost;
	
	@Column(name = "date_created")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	
	@Column(name = "status")
	private String status;

}
