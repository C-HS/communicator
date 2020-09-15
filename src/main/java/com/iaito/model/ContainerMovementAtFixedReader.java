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
@Table(name = "ContainerMovementAtFixedReader")
public class ContainerMovementAtFixedReader {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "movement_id")
	private Long movementId;
	
	@Column(name = "reader_id")
	private Long readerId;
	
	@Column(name = "movement_type")
	private String movementType;
	
	@Column(name = "tid")
	private String tid;
	
	@Column(name = "container_id")
	private long containerId;
	
	@Column(name = "date_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime;
	
	@Column(name = "status")
	private String status;
}
