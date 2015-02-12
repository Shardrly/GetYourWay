package com.qa.web;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Flights {

	private String flightNumber;
	private int stops;
	private String departureTerminal;
	private String arrivalTerminal;
	private String departureTime;
	private String arrivalTime;
	private Carrier carrier = new Carrier();
	private DepartureAirport departureAirport = new DepartureAirport();
	private ArrivalAirport arrivalAirport = new ArrivalAirport();
	private String journeyTime;

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public int getStops() {
		return stops;
	}

	public void setStops(int stops) {
		this.stops = stops;
	}

	public String getDepartureTerminal() {
		return departureTerminal;
	}

	public void setDepartureTerminal(String departureTerminal) {
		this.departureTerminal = departureTerminal;
	}

	public String getArrivalTerminal() {
		return arrivalTerminal;
	}

	public void setArrivalTerminal(String arrivalTerminal) {
		this.arrivalTerminal = arrivalTerminal;
	}

	public Date getDepartureTime() {

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
		Date newstring = null;
		try {
			newstring = format.parse(departureTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return newstring;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	
	/* Use this method to return a simple string for the date
	 * rather than the complicated annoying date object in 'getDepartureTime'
	 */
	
	public String getArrivalFormattedTime() {
		long val = getArrivalTime().getTime();
		Date date = new Date(val);
		SimpleDateFormat df2 = new SimpleDateFormat("HH:mm");
		String dateText = df2.format(date);
		return dateText;
	}
	
	public String getDepartureFormattedTime() {
		long val = getDepartureTime().getTime();
		Date date = new Date(val);
		SimpleDateFormat df2 = new SimpleDateFormat("HH:mm");
		String dateText = df2.format(date);
		return dateText;
	}
	
	
	/* Use this method to return a simple string for the date
	 * rather than the complicated annoying date object in 'getDepartureTime'
	 */
	
	public String getArrivalDate() {
		long val = getArrivalTime().getTime();
		Date date = new Date(val);
		SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
		String dateText = df2.format(date);
		return dateText;
	}
	/* Use this method to return a simple string for the date
	 * rather than the complicated annoying date object in 'getDepartureTime'
	 */
	
	public String getDepartureDate() {
		long val = getDepartureTime().getTime();
		Date date = new Date(val);
		SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
		String dateText = df2.format(date);
		return dateText;
	}

	public Date getArrivalTime() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
		Date newdate = null;
		try {
			newdate = format.parse(arrivalTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newdate;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	public DepartureAirport getdepartureAirport() {
		return departureAirport;
	}

	public void setdepartureAirport(DepartureAirport departureAirport) {
		this.departureAirport = departureAirport;
	}

	public ArrivalAirport getarrivalAirport() {
		return arrivalAirport;
	}

	public void setarrivalAirport(ArrivalAirport arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public String getJourneyTime() {

//		SimpleDateFormat format = new SimpleDateFormat(
//				"yyyy-MM-dd'T'HH:mm:ss.SSS");

		long d1 = 0;
		long d2 = 0;
		long diffSeconds = 0;
		long diffMinutes = 0;
		long diffHours = 0;
		long diffDays = 0;
		// try {
		// d1 = format.parse(departureTime);
		// d2 = format.parse(arrivalTime);
		//
		// //in milliseconds

		d1 = getDepartureTime().getTime();
		d2 = getArrivalTime().getTime();
		long diff = d2 - d1;

		diffSeconds = diff / 1000 % 60;
		diffMinutes = diff / (60 * 1000) % 60;
		diffHours = diff / (60 * 60 * 1000) % 24;
		diffDays = diff / (24 * 60 * 60 * 1000);

		if (diffDays < 1) {
			journeyTime = diffHours + " Hours and " + diffMinutes + " Minutes";
			return journeyTime;
		}

		else {
			journeyTime = "" + diffDays + " Days, " + diffHours + " Hours and "
					+ diffMinutes + " Minutes";
			return journeyTime;
		}

	}

}
