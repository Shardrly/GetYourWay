package com.qa.flightsearch;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.qa.web.ScheduledFlights;
import com.qa.web.TimeTest;

public class FlightsSearch {

	    @SuppressWarnings("deprecation")
		public static String BuildQuery(String airportcode, String destinapcode, String date){
		
	    String origincode=airportcode;
		String destcode=destinapcode;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
		int yearint =0;
		int monthint=0;
		int dayint=0;
		
		try {
			Date datetest = sdf.parse(date);
			yearint = datetest.getYear();
			monthint = datetest.getMonth();
			dayint = datetest.getDay();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String year= ""+yearint;
		String month = ""+monthint;
		String day = ""+dayint;
			
	    	
//		   curl -v  -X GET "https://api.flightstats.com/flex/schedules/rest/v1/json/from/LHR/to/CDG/arriving/2015/2/13?appId=208593e7&appKey=24ff9976068fc000c241363fd8434a17&extendedOptions=useInlinedReferences"
		    	
		/*
		 * Building the query from specific inputs from the search page, e.g origin, destination, date.   
		 */
//		   
		String baseSearch = "https://api.flightstats.com/flex/schedules/rest/v1/json/from/";
		String FlightsQuery =null;
		String appId = "appId=208593e7&";
		String appKey = "appKey=24ff9976068fc000c241363fd8434a17";

		FlightsQuery = baseSearch + origincode + "/to/" + destcode
				+ "/arriving/" + year + "/" + month + "/" + day + "?" + appId
				+ appKey + "&extendedOptions=useInlinedReferences";
	
		return FlightsQuery;
		/* Now send the query and prepare the REST setup
		 * 
		 */
				
//	   RestTemplate restTemplate = new RestTemplate();
//	   String JSONstring = restTemplate.getForObject("http://localhost:8080/blegh2/testflights4.json", String.class);
//	   Gson gson = new Gson();
//	   ScheduledFlights ScheduledFlights = gson.fromJson(JSONstring,ScheduledFlights.class);
//	   return ScheduledFlights;
	   
//	   for (int i=0; i<ScheduledFlights.getScheduledFlights().size();i++){
//
//		    long depTime = ScheduledFlights.getScheduledFlights().get(i).getDepartureTime().getTime();
//		    long arrTime = ScheduledFlights.getScheduledFlights().get(i).getArrivalTime().getTime();
//
//		    SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
//			String depInString = "13-02-2015 10:20:56";
//			String arrInString = "13-02-2015 14:20:56";
//			Boolean arrBool = false;
//			Boolean depBool = false;
//		   
//			try {
//				Date inputDep = sdf.parse(depInString);
//				Date inputArr =sdf.parse(arrInString);
//				depBool = TimeTest.getTimeInRange(depTime, inputDep, inputArr);
//				arrBool = TimeTest.getTimeInRange(arrTime, inputDep, inputArr);
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		
//	    	if (arrBool && depBool){
//		       System.out.println("Time of Departure: "+ScheduledFlights.getScheduledFlights().get(i).getDepartureFormattedTime());
//		       System.out.println("Date of Departure: "+ScheduledFlights.getScheduledFlights().get(i).getDepartureDate());
//		 	   System.out.println("Flying from : "+ScheduledFlights.getScheduledFlights().get(i).getdepartureAirport().getName());
//		 	   System.out.println("Leaving from Terminal: "+ ScheduledFlights.getScheduledFlights().get(i).getDepartureTerminal());
//		 	   System.out.println("Weather Zone: " +ScheduledFlights.getScheduledFlights().get(i).getdepartureAirport().getWeatherZone());
//		 	   System.out.println("Departure Country: "+ScheduledFlights.getScheduledFlights().get(i).getdepartureAirport().getCountryName());
//		 	   System.out.println("Country/State Code: "+ScheduledFlights.getScheduledFlights().get(i).getdepartureAirport().getStateCode());
//		 	   System.out.println("Number of Stops: "+ScheduledFlights.getScheduledFlights().get(i).getStops());
//		 	   System.out.println("Arriving at : "+ScheduledFlights.getScheduledFlights().get(i).getarrivalAirport().getName());
//		 	   System.out.println("In Country: "+ScheduledFlights.getScheduledFlights().get(i).getarrivalAirport().getCountryName());
////		 	   System.out.println("With Country/State Code: "+ScheduledFlights.getScheduledFlights().get(i).getarrivalAirport().getStateCode());
//		 	   System.out.println("Time of Arrival: "+ScheduledFlights.getScheduledFlights().get(i).getArrivalFormattedTime());
//		 	   System.out.println("Date of Arrival: "+ScheduledFlights.getScheduledFlights().get(i).getArrivalDate());
//		 	   System.out.println("Flight Number: " +ScheduledFlights.getScheduledFlights().get(i).getFlightNumber());
//		 	   System.out.println("Flight Carrier Name: " +ScheduledFlights.getScheduledFlights().get(i).getCarrier().getName());
////		 	   System.out.println("Flight Carrier Phone Number: " +ScheduledFlights.getScheduledFlights().get(i).getCarrier().getPhoneNumber());
//		 	   System.out.println("Journey time : "+ScheduledFlights.getScheduledFlights().get(i).getJourneyTime());
//		 	   System.out.println("Arriving at Terminal: "+ ScheduledFlights.getScheduledFlights().get(i).getArrivalTerminal());
//	    	}
//	    	else {
//	    		continue;
//	    	}
//	    }
	}	
}
