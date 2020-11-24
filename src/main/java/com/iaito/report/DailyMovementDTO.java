package com.iaito.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
public class DailyMovementDTO {
	
	private String dateStr;
	private String source;
	private String destination;
	private double timeTaken;
	private Date startTime;
	private Date endTime;
	private double distanceTravelled;
	List<TransitionDTO> transitionList = new ArrayList();

}
