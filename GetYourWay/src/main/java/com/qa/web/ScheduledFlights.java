package com.qa.web;

import java.util.List;


public class ScheduledFlights {
	
	private List<Flights> scheduledFlights;

	public List<Flights> getScheduledFlights() {
		return scheduledFlights;
	}

	@Override
	public String toString() {
		return "ScheduledFlights [scheduledFlights=" + scheduledFlights + "]";
	}

	public void setScheduledFlights(List<Flights> scheduledFlights) {
		scheduledFlights = scheduledFlights;
	}



}
