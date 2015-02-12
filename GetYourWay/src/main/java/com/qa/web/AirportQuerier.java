package com.qa.web;

import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

public class AirportQuerier {
	
		public static AirportList queryAirports (String query){
		
	        RestTemplate restTemplate = new RestTemplate();
		    String JSONstring = restTemplate.getForObject(query, String.class);
		    Gson gson = new Gson();
			AirportList airports = gson.fromJson(JSONstring,AirportList.class);
			return airports;
		}
}
