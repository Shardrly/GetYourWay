package com.qa.flightsearch;

import java.util.ArrayList;
import java.util.List;


public class AirportSearch {

//	
//	public void setOriginlat(Double originlat) {
//		this.originlat = originlat;
//	}
//	public void setOriginlong(Double originlong) {
//		this.originlong = originlong;
//	}
//
//	public void setDestinationlat(Double destinationlat) {
//		this.destlat = destinationlat;
//	}
//
//	public void setDestinationlong(Double destinationlong) {
//		this.destlong = destinationlong;
//	}

	
    public static List<String> BuildQuery(String originl, String originlo, String destl, String destlo){
    	
//    	 Double originlat=Double.parseDouble(originl);
//    	 Double originlong=Double.parseDouble(originlo);
//    	 Double destlat=Double.parseDouble(destl);
//    	 Double destlong=Double.parseDouble(destlo);
	//			curl -v  -X GET
	//	Long			+ "-0.453/
//    	Lat				+	51.469/
//    	Radius (mi)		+	40?"
	//					+ "appId=208593e7&"
	//					+ "appKey=24ff9976068fc000c241363fd8434a17";
	//	
    	String baseSearch = "https://api.flightstats.com/flex/airports/rest/v1/json/withinRadius/";
		String airportQueryOri;
		String airportQueryDest;
	
		Integer radius = 50;
		String appId= "appId=208593e7&";
		String appKey="appKey=24ff9976068fc000c241363fd8434a17";
	
		String origin = ""+originlo+"/"+originl+"/";
		String destination =""+destlo+"/"+destl+"/";
		
//		String origin = ""+originlat+"/"+originlong+"/";
//		String destination =""+destlat+"/"+destlong+"/";
		airportQueryOri=baseSearch+""+origin+radius+"?"+appId+appKey;
		airportQueryDest=baseSearch+""+destination+radius+"?"+appId+appKey;
		List<String> airportList = new ArrayList<String>(); 
		airportList.add(airportQueryOri);
		airportList.add(airportQueryDest);
	
		return airportList;
		}
}

