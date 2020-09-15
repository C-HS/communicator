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
public class ContainerLocationStatusDTO {

	private long statusId;

	private long vehicleDeviceId;

	private long vehicleId;

	private String tid;

	private long containerId;

	private long areaId;

	private String latitude;

	private String longitude;

	private String altitude;
	
	private Date dateTime;
	
	private String status;
}
