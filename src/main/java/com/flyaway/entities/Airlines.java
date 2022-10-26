package com.flyaway.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airlines {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int airlineId;
	private String airLineCode;
	private String airLineName;
	
	

	public Airlines() {
		// TODO Auto-generated constructor stub
	}

	public int getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}

	public String getAirLineCode() {
		return airLineCode;
	}

	public void setAirLineCode(String airLineCode) {
		this.airLineCode = airLineCode;
	}
	
	public String getAirLineName() {
		return airLineName;
	}

	public void setAirLineName(String airLineName) {
		this.airLineName = airLineName;
	}
	
	
}
