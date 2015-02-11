package com.qa.web;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonIgnoreProperties(ignoreUnknown = true)
public class ArrivalAirport extends DepartureAirport{
	private String arrivalairport;

	@Override
	public String getName() {
		return super.getName();
	}

	public String getArrivalAirport() {
		return arrivalairport;
	}

	@Override
	public String getStateCode() {
		return super.getStateCode();
	}
	
	@Override
	public String getCountryCode() {
		return super.getCountryCode();
	}
	
}
