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
public class FixedRFIDReaderConnectionStatusDTO {

	private long statusId;

	private long readerId;

	private String statusType;

	private String description;

	private Date dateTime;

	private String status;
}
