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
public class ContainerDTO {

	private long containerId;

	private String containerNumber;

	private String containerType;

	private String containerInfo;

	private String taggingStatus;

	private String tid;

	private Date registerDate;

	private Date taggingDate;

	private String status;
}
