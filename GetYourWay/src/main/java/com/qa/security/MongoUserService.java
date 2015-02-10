package com.qa.security;



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

@Service
@SuppressWarnings({ "deprecation" })
public class MongoUserService implements UserDetailsService
{
    private MongoTemplate mongoTemplate;
 
    @Autowired
    public MongoUserService( MongoTemplate mongoTemplate )
    {
        this.mongoTemplate = mongoTemplate;
    }
 
    @Override
    public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException
    {
    	username = username.toUpperCase();
    	
    	if (username.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$")) {
    			
	        UserDetails user = mongoTemplate.findOne(Query.query(Criteria.where("username").is(username)), MongoUserDetails.class);
			
	        if( user == null ) {
	            throw new UsernameNotFoundException( "Oops!" );
	        }
	 
	        return user;
	       
    	} else {
    		throw new UsernameNotFoundException("Bad username");
    	}
    }
    
    public void addNewUser(String username, String rawPassword) throws GYWSecFormatException {
    	
    	username = username.toUpperCase();
    	    	
    	if (username.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$")
    			&& rawPassword.matches("^[A-Z0-9a-z]{6,20}$")
    			&& ! username.contains(rawPassword.toUpperCase())) {
    	
			PasswordEncoder encoder = new ShaPasswordEncoder();
	    	String password = encoder.encodePassword(rawPassword, username);
	    	
	    	UserDetails user = new MongoUserDetails(username, password);
	    	mongoTemplate.save(user, "users");
    	} else {
    		throw new GYWSecFormatException("Invalid password/username");
    	}
    }
    
    public void addNewPlan(MongoUserDetails user, long planLength) throws GYWSecFormatException {
    	
    	if (planLength >0) {
    	
	    	long now = new Date().getTime();
	    	
	    	long newExpDate;
	    	
	    	if (now < user.getExpiryDate()) {
	    		newExpDate = planLength + user.getExpiryDate();
	    	} else {
	    		newExpDate = planLength + now;
	    	}
	    	
	    	user.setExpiryDate(newExpDate);
	    	mongoTemplate.save(user,"users");
    	} else {
    		throw new GYWSecFormatException("Invalid Plan Length");
    	}
	        
    }
     
}
