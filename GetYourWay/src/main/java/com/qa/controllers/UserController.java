package com.qa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qa.exceptions.GYWSecFormatException;
import com.qa.paymentPlans.PaymentPlanService;
import com.qa.userAccounts.MongoUserDetails;
import com.qa.userAccounts.MongoUserService;

@Controller
public class UserController {
	
	MongoUserService mongoUserService;
	PaymentPlanService paymentPlanService;
	
	@Autowired
    public UserController( MongoUserService mongoUserService, PaymentPlanService paymentPlayService )
    {
		System.out.println("controller_init");
        this.mongoUserService = mongoUserService;
        this.paymentPlanService = paymentPlayService;
    }
	
	@RequestMapping(value="/SearchPage.spr", method=RequestMethod.GET)
	public String login() {
		
		return "SearchPage";
		
	}
	
	@RequestMapping(value="/registerdetails.spr")
	public String newUser(@RequestParam String j_username, @RequestParam String j_password) {
		try {
			mongoUserService.addNewUser(j_username, j_password);
			
			return "/choosePlan";
		} catch (GYWSecFormatException e) {
			return "/register";
		}
		
	}
	
	@RequestMapping(value="/registerplan.spr")
	public String newPlan(@AuthenticationPrincipal MongoUserDetails activeUser, @RequestParam String plan) {
		
		try {
			mongoUserService.addNewPlan(activeUser, plan);
		
			return "/about";
		} catch (Exception e) {
			return "/choosePlan";
		}
		
	}

}
