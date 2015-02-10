package com.qa.jsonHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;

public class PaymentPlanReader {
	
	public static void main(String args[]) {
		Gson gson = new Gson();
		 
		try {
	 
			BufferedReader br = new BufferedReader(
				new FileReader("C:\\Users\\Administrator\\git\\GetYourWay\\GetYourWay\\src\\main\\webapp\\WEB-INF\\Plans.json"));
	 
			//convert the json string back to object
			PaymentPlan obj = gson.fromJson(br, PaymentPlan.class);
			
	 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
