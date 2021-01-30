package com.iaito.dto;

import java.util.ArrayList;
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
public class Area {

    private String areaId;
    private String areaName;
    private String blockId;
    private String blockName;
    private List<PointCoordinate> pointCoordinateList = new ArrayList<>();
}
