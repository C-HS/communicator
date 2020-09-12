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
public class RFIDTagDTO {
	
	private String tid;
	

	private String epc;

	private Date registerDate;
	
	private String status;
}
