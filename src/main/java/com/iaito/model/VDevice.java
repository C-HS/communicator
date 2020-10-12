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
@Table(name = "VDevice")
public class VDevice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vehicle_device_id")
	private long vehicleDeviceId;
	
	@Column(name = "vehicle_device_number",unique=true, nullable = false)
	@NotNull
	private String vehicleDeviceNumber;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "attach_status")
	private String attachStatus;
	
	@Column(name = "register_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registerDate;
	
	@Column(name = "attach_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date attachDate;
	
	@Column(name = "status")
	private String status;

}
