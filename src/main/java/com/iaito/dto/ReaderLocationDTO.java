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
public class ReaderLocationDTO {

	private long readerLocationId;
	
	private String readerLocationName;
	
	private Date dateCreated;

	private String status;
}
