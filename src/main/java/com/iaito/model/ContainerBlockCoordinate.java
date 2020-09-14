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
@Table(name = "ContainerBlockCoordinate")
public class ContainerBlockCoordinate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "coordinate_id")
	private long coordinateId;
	
	@Column(name = "block_id")
	private long blockId;
	
	
	@Column(name = "latitude")
	private String latitude;
	
	@Column(name = "longitude")
	private long longitude;
	
	@Column(name = "date_created")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	
	@Column(name = "status")
	private String status;
}
