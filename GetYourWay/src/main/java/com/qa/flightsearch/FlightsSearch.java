package com.qa.flightsearch;

public class FlightsSearch {
	
	   public static void main(String args[]) {
	    	
			
//		   curl -v  -X GET "https://api.flightstats.com/flex/schedules/rest/v1/json/from/LHR/to/CDG/arriving/2015/2/13?appId=208593e7&appKey=24ff9976068fc000c241363fd8434a17&extendedOptions=useInlinedReferences"
		    	
		   String baseSearch = "https://api.flightstats.com/flex/schedules/rest/v1/json/from/";
				String FlightsQuery;
				String origincode = null;
				String destcode = null;	
				String year =null;
				String month = null;
				String day = null;
				String appId= "appId=208593e7&";
				String appKey="appKey=24ff9976068fc000c241363fd8434a17";
				
				FlightsQuery=baseSearch+origincode+"/to/"+destcode+"/arriving/"+year+"/"+month+"/"+day+"?"+appId+appKey+"&extendedOptions=useInlinedReferences";
				}

}
