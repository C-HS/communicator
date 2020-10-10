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

import com.sun.istack.NotNull;

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
@Table(name = "Container")
public class Container {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "container_id",unique=true,nullable = false)
	private long containerId;
	
	
	@Column(name = "container_number", unique=true, nullable = false)
	@NotNull
	private String containerNumber;
	
	@Column(name = "container_type")
	private String containerType;
	
	@Column(name = "container_info")
	private String containerInfo;
	
	@Column(name = "tagging_status")
	private String taggingStatus;
	
	@Column(name = "tid")
	private String tid;
	
	@Column(name = "register_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registerDate;
	
	@Column(name = "tagging_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date taggingDate;
	
	@Column(name = "status")
	private String status;


}
