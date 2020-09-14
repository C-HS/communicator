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
public class VehicleDTO {

	private long vehicleId;
	
	private String vehicleNumber;
	
	private String vehicleType;

	private String vehicleInfo;

	private long vehicleDeviceId;

	private String mountingStatus;

	private Date registerDate;

	private Date mountingDate;

	private String status;
}
