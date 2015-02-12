package com.qa.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

public class FlightList {

    public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
//        String JSONstring1 = restTemplate.getForObject("http://localhost:8080/blegh2/testflights3.json",String.class);
	    String JSONstring = restTemplate.getForObject("http://localhost:8080/blegh2/testflights4.json", String.class);
	    Gson gson = new Gson();
//	    AirportList airports = gson.fromJson(JSONstring1,AirportList.class);
	    ScheduledFlights ScheduledFlights = gson.fromJson(JSONstring,ScheduledFlights.class);
	  
//	     for (int i=0; i<airports.getAirports().size();i++){
//	    	if (airports.getAirports().get(i).getClassification()>2){
//	    		continue;
//	    	}
//	    	else {
//	      		 System.out.println("Airport Name: "+airports.getAirports().get(i).getName());
//	       		 System.out.println("Airport International Air Transport Association Code; "+airports.getAirports().get(i).getIata());
//	    		 System.out.println("Associated City: "+airports.getAirports().get(i).getCity());
//	    		 System.out.println("City Code: "+airports.getAirports().get(i).getCityCode());
//	    		 System.out.println("Country: "+airports.getAirports().get(i).getCountryName());
//	       		 System.out.println("International Region:  " +airports.getAirports().get(i).getRegionName());
//	       		 System.out.println("Latitude: "+airports.getAirports().get(i).getLatitude());
//	       		 System.out.println("Longitude: "+airports.getAirports().get(i).getLongitude());
//	       		 
//	    	}
//	    }
	  
	    for (int i=0; i<ScheduledFlights.getScheduledFlights().size();i++){

		    long depTime = ScheduledFlights.getScheduledFlights().get(i).getDepartureTime().getTime();
		    long arrTime = ScheduledFlights.getScheduledFlights().get(i).getArrivalTime().getTime();

		    SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
			String depInString = "13-02-2015 10:20:56";
			String arrInString = "13-02-2015 14:20:56";
			Boolean arrBool = false;
			Boolean depBool = false;
		   
			try {
				Date inputDep = sdf.parse(depInString);
				Date inputArr =sdf.parse(arrInString);
				depBool = TimeTest.getTimeInRange(depTime, inputDep, inputArr);
				arrBool = TimeTest.getTimeInRange(arrTime, inputDep, inputArr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	    	if (arrBool && depBool){
		       System.out.println("Time of Departure: "+ScheduledFlights.getScheduledFlights().get(i).getDepartureFormattedTime());
		       System.out.println("Date of Departure: "+ScheduledFlights.getScheduledFlights().get(i).getDepartureDate());
		 	   System.out.println("Flying from : "+ScheduledFlights.getScheduledFlights().get(i).getdepartureAirport().getName());
		 	   System.out.println("Leaving from Terminal: "+ ScheduledFlights.getScheduledFlights().get(i).getDepartureTerminal());
		 	   System.out.println("Weather Zone: " +ScheduledFlights.getScheduledFlights().get(i).getdepartureAirport().getWeatherZone());
		 	   System.out.println("Departure Country: "+ScheduledFlights.getScheduledFlights().get(i).getdepartureAirport().getCountryName());
		 	   System.out.println("Country/State Code: "+ScheduledFlights.getScheduledFlights().get(i).getdepartureAirport().getStateCode());
		 	   System.out.println("Number of Stops: "+ScheduledFlights.getScheduledFlights().get(i).getStops());
		 	   System.out.println("Arriving at : "+ScheduledFlights.getScheduledFlights().get(i).getarrivalAirport().getName());
		 	   System.out.println("In Country: "+ScheduledFlights.getScheduledFlights().get(i).getarrivalAirport().getCountryName());
//		 	   System.out.println("With Country/State Code: "+ScheduledFlights.getScheduledFlights().get(i).getarrivalAirport().getStateCode());
		 	   System.out.println("Time of Arrival: "+ScheduledFlights.getScheduledFlights().get(i).getArrivalFormattedTime());
		 	   System.out.println("Date of Arrival: "+ScheduledFlights.getScheduledFlights().get(i).getArrivalDate());
		 	   System.out.println("Flight Number: " +ScheduledFlights.getScheduledFlights().get(i).getFlightNumber());
		 	   System.out.println("Flight Carrier Name: " +ScheduledFlights.getScheduledFlights().get(i).getCarrier().getName());
//		 	   System.out.println("Flight Carrier Phone Number: " +ScheduledFlights.getScheduledFlights().get(i).getCarrier().getPhoneNumber());
		 	   System.out.println("Journey time : "+ScheduledFlights.getScheduledFlights().get(i).getJourneyTime());
		 	   System.out.println("Arriving at Terminal: "+ ScheduledFlights.getScheduledFlights().get(i).getArrivalTerminal());
    		}
	    	else {
	    		continue;
	    	}
	    }
    }
}