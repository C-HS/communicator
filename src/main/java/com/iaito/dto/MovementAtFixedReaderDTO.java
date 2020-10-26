package com.iaito.dto;

import java.io.Serializable;

public class MovementAtFixedReaderDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String tagData;
    private String reader_id;
    private String time;
    private String movementType;
    private String antenna;
    private String readZone;
	public MovementAtFixedReaderDTO(String tagData, String reader_id,
			String time, String movementType, String antenna, String readZone) {
		super();
		this.tagData = tagData;
		this.reader_id = reader_id;
		this.time = time;
		this.movementType = movementType;
		this.antenna = antenna;
		this.readZone = readZone;
	}
	@Override
	public String toString() {
		String input = "{\"tagData\":\""+tagData+"\",\"reader_id\":\""+reader_id+"\",\"time\":\""+time+"\",\"movementType\":\""+movementType+"\",\"antenna\":\""+antenna+"\",\"readZone\":\""+readZone+"\"}";
		   return input;
	}
	public String getTagData() {
		return tagData;
	}
	public void setTagData(String tagData) {
		this.tagData = tagData;
	}
	public String getReader_id() {
		return reader_id;
	}
	public void setReader_id(String reader_id) {
		this.reader_id = reader_id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getMovementType() {
		return movementType;
	}
	public void setMovementType(String movementType) {
		this.movementType = movementType;
	}
	public String getAntenna() {
		return antenna;
	}
	public void setAntenna(String antenna) {
		this.antenna = antenna;
	}
	public String getReadZone() {
		return readZone;
	}
	public void setReadZone(String readZone) {
		this.readZone = readZone;
	}
    
	
}
