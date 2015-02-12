package com.qa.userAccounts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Document(collection="users")
public class MongoUserDetails implements UserDetails {
	
	private String username;
	private String password;
	private boolean enabled;
	private List<String> authorities;
	private boolean accountNonExpired;
	private long expiryDate;
	private long joinedDate;
	
	
	public MongoUserDetails() {
		
		super();
		this.username="uname";
		this.password="password";
		this.authorities = new ArrayList<String>();
		this.authorities.add("ROLE_USER");
		this.accountNonExpired=true;
		this.joinedDate = new Date().getTime();
		this.expiryDate = this.joinedDate;
		this.enabled = true;
	}
	public MongoUserDetails(String username, String password) {
		this();
		this.username = username;
		this.password = password;
	}
	
	public MongoUserDetails(String username, String password,
			List<String> authorities) {
		this(username,password);
		this.authorities = authorities;
	}
	
public MongoUserDetails(String username, String password, long expiryDate, long dateJoined) {
		
		this(username,password);
		this.expiryDate = expiryDate;
		this.joinedDate = dateJoined;
		checkAccountExpired();
	}
	
	public MongoUserDetails(String username, String password, long expiryDate, long dateJoined, List<String> authorities) {
		
		this(username,password,expiryDate,dateJoined);
		setAuthorities(authorities);
	}

	public void setAuthorities(List<String> authorities) {
		this.authorities = authorities;
	}
	
	public void setExpiryDate(long expiryDateMs) {
		this.expiryDate = expiryDateMs;
		checkAccountExpired();
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public void checkAccountExpired() {
		this.accountNonExpired= (new Date().getTime() > this.expiryDate);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		for (String authority : authorities) {
			grantedAuthorities.add(new SimpleGrantedAuthority(authority));
			System.out.println("Authority:=" + authority);
		}
		return grantedAuthorities;
	}

	@Override	
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}
	
	public long getExpiryDate() {
		return expiryDate;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
	@Override
	public String toString() {
		return "MongoUserDetails [username=" + username + ", authorities="
				+ authorities + "]";
	}


}