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

	private Long movementId;

	private Long readerId;

	private String movementType;

	private String tid;
	
	private String antenna;
	
	private String refReader;

	private long containerId;

	private Date dateTime;

	private String status;
}
