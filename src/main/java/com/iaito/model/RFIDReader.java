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
@Table(name = "RFIDReader")
public class RFIDReader {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "reader_id")
	private long readerId;
	
	@Column(name = "reader_ip")
	private String readerIp;
	
	@Column(name = "reader_port")
	private String readerPort;
	
	@Column(name = "reader_location_id")
	private long readerLocationId;
	
	@Column(name = "location_assign_status")
	private String locationAssignStatus;
	
	@Column(name = "ip_port_configuration_status")
	private String ipPortConfigurationStatus;
	
	@Column(name = "reader_type")
	private String readerType;
	
	@Column(name = "middleware_reader_id")
	private String middlewareReaderId;
	
	@Column(name = "middleware_mapping_status")
	private String middlewareMappingStatus;
	
	@Column(name = "register_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registerDate;
	
	@Column(name = "middleware_mapping_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date middlewareMappingDate;
	
	@Column(name = "status")
	private String status;

}
