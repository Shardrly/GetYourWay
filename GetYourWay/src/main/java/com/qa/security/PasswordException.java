package com.qa.security;

import java.util.ArrayList;
import java.util.Collection;

public class PasswordException extends Exception {
	
	private Collection<PasswordException> problems = new ArrayList<PasswordException>();

	public PasswordException() {
		super();
	}

	public PasswordException(String message, Throwable cause) {
		super(message, cause);
	}

	public PasswordException(String message) {
		super(message);
	}

	public PasswordException(Throwable cause) {
		super(cause);
	}

	public Collection<PasswordException> getProblems() {
		return problems;
	}

	public void addProblem(PasswordException problem) {
		problems.add(problem);
	}
	
	public int problemCount() {
		return problems.size();
	}
	

}
