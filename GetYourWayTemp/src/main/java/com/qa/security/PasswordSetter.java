package com.qa.security;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordSetter {
	
	public boolean authenticate(String attemptedPassword, byte[] encryptedPassword, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
		byte[] encryptedAttemptedPassword = getEncryptedPassword(attemptedPassword,salt);
		
		return Arrays.equals(encryptedPassword, encryptedAttemptedPassword);
	}
	
	public byte[] getEncryptedPassword(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
		String algorithm = "PBKDF2WithHmacSHA1";
		int derivedKeyLength = 160;
		
		int iterations = 20000;
		
		KeySpec spec = new PBEKeySpec(password.toCharArray(),salt,iterations,derivedKeyLength);
		
		SecretKeyFactory f = SecretKeyFactory.getInstance(algorithm);
		
		return f.generateSecret(spec).getEncoded();
	}
	
	public byte[] generateSalt() throws NoSuchAlgorithmException {
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
		
		byte[] salt = new byte[8];
		random.nextBytes(salt);
		
		return salt;
	}
	
	public boolean testPasswordFormat(String password) {
		boolean result = false;
		
		if (password != null &&
				password.length()>=6 &&
				password.length()<21 &&
				password.matches("^[a-zA-Z0-9]*$")) {
			result = true;
		}
		return result;
	}
	
	public List <byte[]> setPassword(String newPassword) throws NoSuchAlgorithmException, InvalidKeySpecException, PasswordException {
		
		if (testPasswordFormat(newPassword)) {
			
			byte[] tempSalt = generateSalt();
			List<byte[]> userPasswordProxies = new ArrayList<byte[]>();
			
			userPasswordProxies.add(tempSalt);
			userPasswordProxies.add(getEncryptedPassword(newPassword, tempSalt));

			return userPasswordProxies;
		} else {
			throw new PasswordException("invalid Password");
		}
		
		
	}

}
