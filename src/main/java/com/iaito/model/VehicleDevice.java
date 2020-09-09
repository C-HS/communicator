package com.iaito.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VehicleDevice {
	@JsonProperty("longitude")
	private String longitude;
	@JsonProperty("latitude")
	private String latitude;
	@JsonProperty("altitude")
	private String altitude;
	@JsonProperty("tagId")
	private String tagId;

}
