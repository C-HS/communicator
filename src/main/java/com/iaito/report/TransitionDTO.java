package com.iaito.report;

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
public class TransitionDTO {
	
	private int id;
	private String source;
	private String destination;
	private double timeTaken;
	private Date startTime;
	private Date endTime;
	private double distanceTravelled;
	private double lat;
	private double lon;

}
