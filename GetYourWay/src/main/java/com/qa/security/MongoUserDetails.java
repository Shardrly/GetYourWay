package com.qa.security;

import java.util.ArrayList;
import java.util.Collection;
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
	
	
	public MongoUserDetails() {
		
		super();
		this.username="uname";
		this.password="password";
		this.authorities = new ArrayList<String>();
		this.authorities.add("ROLE_USER");
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

	public void setAuthorities(List<String> authorities) {
		this.authorities = authorities;
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

	@Override
	public boolean isAccountNonExpired() {
		return true;
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
		return true;
	}
	
	
	
	@Override
	public String toString() {
		return "MongoUserDetails [username=" + username + ", authorities="
				+ authorities + "]";
	}


}