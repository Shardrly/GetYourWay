package com.qa.web;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

public class FlightList {

    public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
	    String JSONstring = restTemplate.getForObject("http://localhost:8080/blegh2/testflights.json", String.class);
	    Gson gson = new Gson();
	    Flights flights = gson.fromJson(JSONstring,Flights.class);
	    
	    System.out.println("Arriving at Terminal: "+ flights.getArrivalTerminal());
	    System.out.println("Date and Time of Departure: "+flights.getDepartureTime());
	    System.out.println("Flying from : "+flights.getdepartureAirport().getName());
	    System.out.println("Leaving from Terminal: "+ flights.getDepartureTerminal());
	    System.out.println("Weather Zone: " +flights.getdepartureAirport().getWeatherZone());
	    System.out.println("Departure Country: "+flights.getdepartureAirport().getCountryName());
	    System.out.println("Country/State Code: "+flights.getdepartureAirport().getStateCode());
	    System.out.println("Number of Stops: "+flights.getStops());
	    System.out.println("Arriving at : "+flights.getarrivalAirport().getName());
	    System.out.println("In Country: "+flights.getarrivalAirport().getCountryName());
	    System.out.println("With Country/State Code: "+flights.getarrivalAirport().getStateCode());
	    System.out.println("Date and Time of Arrival: "+flights.getArrivalTime());
	    System.out.println("Flight Number: " +flights.getFlightNumber());
	    System.out.println("Flight Carrier Name: " +flights.getCarrier().getName());
	    System.out.println("Flight Carrier Phone Number: " +flights.getCarrier().getPhoneNumber());
	    System.out.println("Journey time : "+flights.getJourneyTime());
    }
}