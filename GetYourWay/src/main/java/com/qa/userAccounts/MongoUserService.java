package com.qa.userAccounts;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.qa.exceptions.GYWSecFormatException;
import com.qa.paymentPlans.PaymentPlan;
import com.qa.paymentPlans.PaymentPlanService;

@Service
@SuppressWarnings({ "deprecation" })
public class MongoUserService implements UserDetailsService {
	private MongoTemplate mongoTemplate;
	private PaymentPlanService paymentPlanService;

	@Autowired
	public MongoUserService(MongoTemplate mongoTemplate,
			PaymentPlanService paymentPlanService) {
		this.mongoTemplate = mongoTemplate;
		this.paymentPlanService = paymentPlanService;
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		username = username.toUpperCase();

		if (username.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$")) {

			UserDetails user = mongoTemplate.findOne(
					Query.query(Criteria.where("username").is(username)),
					MongoUserDetails.class);

			if (user == null) {
				System.out.println("Could not find user");
				throw new UsernameNotFoundException("Oops!");
			}

			if (!user.isAccountNonExpired()) {
				mongoTemplate.save(user);
			}

			return user;

		} else {
			System.out.println("Badly Formatted Username");
			throw new UsernameNotFoundException("Bad username");
		}
	}

	public void addNewUser(String username, String rawPassword)
			throws GYWSecFormatException {

		username = username.toUpperCase();

		if (username.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$")
				&& rawPassword.matches("^[A-Z0-9a-z]{6,20}$")
				&& !username.contains(rawPassword.toUpperCase())
				&& !mongoTemplate.exists(
						Query.query(Criteria.where("username").is(username)),
						MongoUserDetails.class)) {

			PasswordEncoder encoder = new ShaPasswordEncoder();
			String password = encoder.encodePassword(rawPassword, username);

			UserDetails user = new MongoUserDetails(username, password);
			mongoTemplate.save(user, "users");
		} else if (mongoTemplate.exists(
				Query.query(Criteria.where("username").is(username)),
				MongoUserDetails.class)) {
			throw new GYWSecFormatException("This username already exists");
		} else {
			throw new GYWSecFormatException("Bad password / username");
		}
	}

	public void addNewPlan(MongoUserDetails user, String plan) throws Exception {

		PaymentPlan pPlan = paymentPlanService.getPaymentPlanByName(plan);

		long now = new Date().getTime();

		long planLength = pPlan.getLength() * 60 * 60 * 1000;

		long newExpDate;

		if (now < user.getExpiryDate()) {
			newExpDate = planLength + user.getExpiryDate();
		} else {
			newExpDate = planLength + now;
		}

		user.setExpiryDate(newExpDate);
		mongoTemplate.save(user, "users");

	}

	public boolean checkUserInDate(MongoUserDetails user) {

		user.checkAccountExpired();
		mongoTemplate.save(user, "users");
		
		return user.isAccountNonExpired();
	}

}
