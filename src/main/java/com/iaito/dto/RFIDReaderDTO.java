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
public class RFIDReaderDTO {

	private long readerId;
	
	private String readerIp;
	
	private String readerPort;
	
	private long readerLocationId;
	
	private String readerLocationName;
	
	private String locationAssignStatus;

	private String ipPortConfigurationStatus;
	
	private String readerType;

	private String middlewareReaderId;
	
	private String description;

	private String middlewareMappingStatus;
	
	private Date registerDate;

	private Date middlewareMappingDate;

	private String status;
}
