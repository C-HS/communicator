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
@Table(name = "ContainerMovementAtFixedReader")
public class ContainerMovementAtFixedReader {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "movement_id")
	private long movementId;
	
	@Column(name = "reader_id")
	private long readerId;
	
	@Column(name = "movement_type")
	private String movementType;
	
	@Column(name = "epc")
	private String epc;
	
	@Column(name = "container_id")
	private long containerId;
	
	@Column(name = "container_no")
	private String containerNo;
	
	@Column(name = "reader_location_id")
	private long readerLocationId;
	
	@Column(name = "reader_location_name")
	private String readerLocationName;
	
	@Column(name = "vehicle_device_no")
	private String vehicleDeviceNo;
	
	@Column(name = "vehicle_no")
	private String vehicleNo;
	
	@Column(name = "latitude")
	private String latitude;
	
	@Column(name = "longitude")
	private String longitude;
	
	@Column(name = "altitude")
	private String altitude;
	
	@Column(name = "area_id")
	private long areaId;
	
	@Column(name = "area_name")
	private String areaName;
	
	@Column(name = "antenna")
	private String antenna;
	
	@Column(name = "ref_reader")
	private String refReader;
	
	@Column(name = "date_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime;
	
	@Column(name = "status")
	private String status;
}
