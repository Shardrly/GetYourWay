package com.qa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qa.security.MongoUserDetails;
import com.qa.security.MongoUserService;

@Controller
public class UserController {
	
	MongoUserService mongoUserService;
	
	@Autowired
    public UserController( MongoUserService mongoUserService )
    {
		System.out.println("controller_init");
        this.mongoUserService = mongoUserService;
    }
	
	@RequestMapping(value="/SearchPage.spr", method=RequestMethod.GET)
	public String login() {
		
		return "SearchPage";
		
	}
	
	@RequestMapping(value="/registerdetails.spr")
	public String newUser(@RequestParam String j_username, @RequestParam String j_password) {
		
		mongoUserService.addNewUser(j_username, j_password);
		
		return "/choosePlan";
		
	}
	
	@RequestMapping(value="/registerplan.spr")
	public String newPlan(@AuthenticationPrincipal MongoUserDetails activeUser, @RequestParam String plan) {
		
		
		long planLength = new Long(plan);
		
		mongoUserService.addNewPlan(activeUser, planLength);
		
		return "/about";
		
	}

}
