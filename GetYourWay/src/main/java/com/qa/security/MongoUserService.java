package com.qa.security;


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
        UserDetails user = mongoTemplate.findOne(Query.query(Criteria.where("username").is(username)), MongoUserDetails.class);
		
        if( user == null ) {
            throw new UsernameNotFoundException( "Oops!" );
        }
 
        return user;
    }
    
    public void addNewUser(String username, String rawPassword) {
    	
		PasswordEncoder encoder = new ShaPasswordEncoder();
    	String password = encoder.encodePassword(rawPassword, username);
    	
    	UserDetails user = new MongoUserDetails(username, password);
    	mongoTemplate.save(user, "users");
    }
     
}
