package com.qa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qa.paymentPlans.PaymentPlanService;
import com.qa.userAccounts.MongoUserService;

@Controller
public class MainController {
	
	MongoUserService mongoUserService;
	PaymentPlanService paymentPlanService;
	
	@Autowired
    public MainController( MongoUserService mongoUserService, PaymentPlanService paymentPlayService )
    {
		System.out.println("main_controller_init");
        this.mongoUserService = mongoUserService;
        this.paymentPlanService = paymentPlayService;
    }
	
	@RequestMapping(value="/login.spr")
	public String login() {
		return "login.jsp";
	}
	
	@RequestMapping(value="/about.spr")
	public String about() {
		return "about.jsp";
	}
	
	@RequestMapping(value="/Frontpage.spr")
	public String frontPage() {
		return "Frontpage.jsp";
	}
	
	@RequestMapping(value="/logoutSuccess.spr")
	public String logoutSuccess() {
		return "logoutSuccess.jsp";
	}
	
	@RequestMapping(value="/errorGeneral.spr")
	public String errorGeneral() {
		return "general-error.jsp";
	}
	
	@RequestMapping(value="/logoutGeneralError.spr")
	public String logoutGeneralError() {
		return "login_generic_error_page.jsp";
	}


}
