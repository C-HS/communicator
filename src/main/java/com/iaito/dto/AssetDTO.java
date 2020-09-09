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
public class AssetDTO {
	private Long id;
	private double longitude;
	private double latitude;
	private double altitude;
	private String tagId;

}
