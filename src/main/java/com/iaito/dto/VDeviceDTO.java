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

	private String attachStatus;
	
	private String description;

	private Date registerDate;

	private Date attachDate;
	
	private String status;
}
