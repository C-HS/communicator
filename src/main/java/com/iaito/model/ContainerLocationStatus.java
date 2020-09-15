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
@Table(name = "ContainerLocationStatus")
public class ContainerLocationStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "status_id")
	private long statusId;
	
	@Column(name = "vehicle_device_id")
	private long vehicleDeviceId;
	
	@Column(name = "vehicle_id")
	private long vehicleId;
	
	@Column(name = "tid")
	private String tid;
	
	@Column(name = "container_id")
	private long containerId;
	
	@Column(name = "area_id")
	private long areaId;
	
	@Column(name = "latitude")
	private String latitude;
	
	@Column(name = "longitude")
	private String longitude;
	
	@Column(name = "altitude")
	private String altitude;
	
	@Column(name = "date_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime;
	
	@Column(name = "status")
	private String status;
}
