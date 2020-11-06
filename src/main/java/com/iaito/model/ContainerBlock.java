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
@Table(name = "ContainerBlock")
public class ContainerBlock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "block_id")
	private long blockId;
	
	@Column(name = "block_name")
	private String blockName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "date_created")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	
	@Column(name = "block_json", length = 2000)
	private String blockJson;
	
	@Column(name = "status")
	private String status;
}
