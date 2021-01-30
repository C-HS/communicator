package com.iaito.dto;

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
public class Block {
	
    private String blockId;
    private String blockName;
    private List<PointCoordinate> pointCoordinateList = new ArrayList<>();

}
