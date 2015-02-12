package com.qa.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qa.flightsearch.AirportSearch;
import com.qa.paymentPlans.PaymentPlanService;
import com.qa.userAccounts.MongoUserDetails;
import com.qa.userAccounts.MongoUserService;
import com.qa.web.AirportList;
import com.qa.web.AirportQuerier;

@Controller
public class SearchController {

	MongoUserService mongoUserService;
	PaymentPlanService paymentPlanService;

	@Autowired
	public SearchController(MongoUserService mongoUserService,
			PaymentPlanService paymentPlayService) {
		System.out.println("main_controller_init");
		this.mongoUserService = mongoUserService;
		this.paymentPlanService = paymentPlayService;
	}

	@RequestMapping(value = "/Search.uspr")
	public String search(
			@AuthenticationPrincipal Principal activeUser)
			throws Exception {
		
		if (mongoUserService.checkUserInDate(activeUser.getName())) {
			return "/FlightSearchPage.jsp";
		} else {
			return "/choosePlan.spr";
		}
		
	}
	
	@Autowired
	@RequestMapping(value = "/SearchResults.uspr")
	public void searchResults(HttpServletRequest request,
			HttpServletResponse response,
			@AuthenticationPrincipal MongoUserDetails activeUser)
			throws Exception {


			if (request.getParameter("mode").equals("DrivingResults")) {
				RequestDispatcher rd = request.getRequestDispatcher("drivingResults.jsp");
				rd.forward(request, response);
				
			} else if (request.getParameter("mode").equals("Flights")) {
				RequestDispatcher rd = request.getRequestDispatcher("flightResults.jsp");
				String originlat  = (String) request.getAttribute("originlat");
				String originlong  = (String) request.getAttribute("originlong");
				String destlat  = (String) request.getAttribute("destlat");
				String destlong  = (String) request.getAttribute("destlong");
				String date = (String) request.getAttribute("date");
				
				List<String> searches = AirportSearch.BuildQuery(originlat, originlong, destlat, destlong);
				AirportList originairports = AirportQuerier.queryAirports((searches.get(0)));
				AirportList destairports = AirportQuerier.queryAirports((searches.get(1)));
				
				List<String> originairportcodes = new ArrayList<String>();
				List<String> destairportcodes = new ArrayList<String>();
					
				  for (int i=0; i<originairports.getAirports().size();i++){
				    	if (originairports.getAirports().get(i).getClassification()>2){
				    		originairportcodes.add(originairports.getAirports().get(i).getFs());
				    	}
				    	else {
				    		continue;
				    	}
				  }
				   
				  for (int i=0; i<destairports.getAirports().size();i++){
				    	if (destairports.getAirports().get(i).getClassification()>2){
				    		destairportcodes.add(destairports.getAirports().get(i).getFs());
				    	}
				    	else {
				    		continue;
				    	}
				  }
				  
				  
				rd.forward(request, response);
				
			} else {
				throw new Exception("Bad flight mode: "
						+ request.getParameter("mode"));
			}
	}
}