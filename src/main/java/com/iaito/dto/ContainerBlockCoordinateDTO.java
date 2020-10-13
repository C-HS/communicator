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
public class ContainerBlockCoordinateDTO {

	private long coordinateId;

	private long blockId;

	private String latitude;

	private String longitude;

	private Date dateCreated;

	private String status;
}
