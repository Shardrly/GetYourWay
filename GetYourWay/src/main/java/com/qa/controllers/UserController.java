package com.qa.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.qa.exceptions.GYWSecFormatException;
import com.qa.paymentPlans.PaymentPlan;
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
	
	@RequestMapping(value="/registerdetails.spr*")
	public String newUser(@RequestParam String j_username, @RequestParam String j_password) {
		try {
			mongoUserService.addNewUser(j_username, j_password);
			System.out.println("Registration Succesful");
			
			return "/choosePlan.spr";
		} catch (GYWSecFormatException e) {
			return "/registerdetails.spr";
		}
	}
	
	@RequestMapping(value="/choosePlan.spr*")
	public ModelAndView choosePlan() {
		
		ArrayList<PaymentPlan> planList = (ArrayList<PaymentPlan>)paymentPlanService.getAllPaymentPlans();
		return new ModelAndView("/choosePlan","PlanList",planList);
	}
	
	@RequestMapping(value="/registerplan.spr*")
	public String newPlan(@AuthenticationPrincipal MongoUserDetails activeUser, @RequestParam String planType) {
		
		try {
			mongoUserService.addNewPlan(activeUser, planType);
		
			return "/about";
		} catch (Exception e) {
			return "/choosePlan";
		}
		
	}

}
