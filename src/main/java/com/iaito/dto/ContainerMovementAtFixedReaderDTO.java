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
public class ContainerMovementAtFixedReaderDTO {

	private long movementId;

	private long readerId;

	private String movementType;

	private String epc;

	private long containerId;

	private String containerNo;

	private long readerLocationId;

	private String readerLocationName;

	private String vehicleDeviceNo;

	private String vehicleNo;

	private String latitude;

	private String longitude;

	private String altitude;

	private long areaId;

	private String areaName;

	private String antenna;

	private String refReader;

	private Date dateTime;

	private String status;
}