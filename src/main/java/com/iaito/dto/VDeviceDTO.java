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
public class VDeviceDTO {

	private long vehicleDeviceId;

	private String vehicleDeviceNumber;

	private String configurationStatus;

	private Date registerDate;

	private Date configurationDate;
	
	private String status;
}
