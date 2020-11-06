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
public class ContainerBlockDTO {

	private long blockId;

	private String blockName;

	private String description;

	private Date dateCreated;

	private String status;
	
	private String blockJson;
}
