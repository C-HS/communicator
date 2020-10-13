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
public class MiddlewareMqttConnectionStatusDTO {

	private long statusId;

	private long mConfigId;

	private String statusType;

	private String description;

	private Date createDate;

	private String status;
}
