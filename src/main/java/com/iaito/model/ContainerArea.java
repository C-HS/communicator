package com.iaito.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Entity
@Table(name = "ContainerArea")
public class ContainerArea {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "area_id")
	private long areaId;
	
	@Column(name = "area_name")
	private String areaName;
	
	@Column(name = "block_id")
	private long blockId;
	
	@Column(name = "latitude1")
	private String latitude1;
	
	@Column(name = "longitude1")
	private long longitude1;
	
	@Column(name = "latitude2")
	private String latitude2;
	
	@Column(name = "longitude2")
	private long longitude2;
	
	@Column(name = "latitude3")
	private String latitude3;
	
	@Column(name = "longitude3")
	private long longitude3;
	
	@Column(name = "latitude4")
	private String latitude4;
	
	@Column(name = "longitude4")
	private long longitude4;
	
	@Column(name = "create_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(name = "status")
	private String status;
}
