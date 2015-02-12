package com.qa.web;

import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

public class FlightQuerier {
		
			public static ScheduledFlights queryFlights (String query){
			
		        RestTemplate restTemplate = new RestTemplate();
			    String JSONstring = restTemplate.getForObject(query, String.class);
			    Gson gson = new Gson();
				ScheduledFlights flights = gson.fromJson(JSONstring,ScheduledFlights.class);
				return flights;
		}
}
