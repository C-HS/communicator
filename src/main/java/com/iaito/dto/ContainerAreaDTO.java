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
public class ContainerAreaDTO {

	private long areaId;

	private String areaName;

	private long blockId;

	private String latitude1;

	private long longitude1;

	private String latitude2;

	private long longitude2;

	private String latitude3;

	private long longitude3;

	private String latitude4;

	private long longitude4;

	private Date createDate;

	private String status;
}
