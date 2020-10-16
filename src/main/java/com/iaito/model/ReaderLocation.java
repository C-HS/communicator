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
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "ReaderLocation")
public class ReaderLocation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "reader_location_id")
	private long readerLocationId;
	
	@Column(name = "reader_location_name")
	private String readerLocationName;
	
	@Column(name = "date_created")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dateCreated;
	
	@Column(name = "status")
	private String status;
}
