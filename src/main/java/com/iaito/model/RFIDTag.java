package com.iaito.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

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
@Table(name = "RFIDTag")
public class RFIDTag {
	
	@Id
	@Column(name = "tid")
	private String tid;
	
	@Column(name = "epc")
	private String epc;
	
	@Column(name = "registerDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registerDate;
	
	@Column(name = "status")
	private String status;

}
