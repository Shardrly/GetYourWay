package com.qa.web;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Airports {
	private String fs;
	private String iata;
	private String name;
	private String city;
	private String cityCode;
	private String countryName;
	private String regionName;
	private Double latitude;
	private Double longitude;
	private Integer classification;
	
	public String getFs() {
		return fs;
	}
	public void setFs(String fs) {
		this.fs = fs;
	}
	public String getIata() {
		return iata;
	}
	public void setIata(String iata) {
		this.iata = iata;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Integer getClassification() {
		return classification;
	}
	public void setClassification(Integer classification) {
		this.classification = classification;
	}
		
}
