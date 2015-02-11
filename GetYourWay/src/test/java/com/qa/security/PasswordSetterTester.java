package com.qa.security;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.security.PasswordException;
import com.qa.security.PasswordSetter;

public class PasswordSetterTester {
	
	private PasswordSetter passwordObject;

	@Before
	public void setUp() throws Exception {
		passwordObject = new PasswordSetter();
	}
	
	@Test
	public void testBadPasswordTooShort() {
		assertFalse(passwordObject.testPasswordFormat(""));
	}
	
	@Test
	public void testBadPasswordInvalidCharacter() {
		assertFalse(passwordObject.testPasswordFormat("aaaaaa."));
	}
	
	@Test
	public void testBadPasswordTooLong() {
		assertFalse(passwordObject.testPasswordFormat("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa."));
	}
	
	@Test(expected = Exception.class)
	public void testBadPasswordSetter() throws NoSuchAlgorithmException, InvalidKeySpecException, PasswordException {
		passwordObject.setPassword("password..");
	}

	@Test
	public void testLogin() {
		try {
			List<byte[]> pwMeta =  passwordObject.setPassword("password");
			assertTrue(passwordObject.authenticate("password", pwMeta.get(1), pwMeta.get(0)));
		}
		catch (Exception e) {
			System.out.println("Error in Password Generation");
		}
			
	}
	
	@Test
	public void testBadLogin() {
		try {
			List<byte[]> pwMeta =  passwordObject.setPassword("Password");
			assertFalse(passwordObject.authenticate("password", pwMeta.get(1), pwMeta.get(0)));
			}
		catch (Exception e) {
			System.out.println("Error in Password Generation");
		}		
		
	}

}
