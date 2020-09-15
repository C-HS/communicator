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
@Table(name = "FixedRFIDReaderConnectionStatus")
public class FixedRFIDReaderConnectionStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "status_id")
	private long statusId;
	
	@Column(name = "reader_id")
	private long readerId;
	
	@Column(name = "status_type")
	private String statusType;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "date_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime;
	
	@Column(name = "status")
	private String status;
}
