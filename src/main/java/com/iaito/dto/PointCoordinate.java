package com.iaito.dto;

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
public class PointCoordinate {
	
    private String slno;
    private String lat;
    private String lon;
    private String alt;

}
