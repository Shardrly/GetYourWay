/**
 * This script validates both logging in and new user creation
 */

function loginFormValidator() {
	if (usernameCheck() && passwordCheck()) {
		return true;
	} else {
		alert("Please enter a valid username and password");
		return false;
	}
}

function usernameCheck(formObject) {
	var uname = formObject.j_username.value;
	var unameDiv = document.getElementById("usernameText");
	
	if (/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/.test(uname.toUpperCase())) {
		unameDiv.style.color="green";
		unameDiv.innerHTML = "OK";
		return true;
	} else {
		unameDiv.style.color="red";
		unameDiv.innerHTML = "Username must be a valid email address";
		return false;
	}
	}

function passwordCheckRegisterFormatter(pword,pdiv) {
	
		if (formObject.j_username.value.indexOf(pword) >= 0){
			pdiv.innerHTML = "Password cannot match email address.";		
		} else if ( pword.length < 6 || pword.length > 20){
			pdiv.innerHTML = "Password must be between 6 and 20 characters in length";
		} else {
			pdiv.innerHTML = "Password must be between 6 and 20 characters in length";
		}
	}

function passwordCheck(formObject) {
	var pword = formObject.j_password.value;
	var pwordDiv = document.getElementById("passwordText");

	if (/^[A-Z0-9a-z]{6,20}$/.test(pword) && formObject.j_username.value.indexOf(pword) < 0) {
		pwordDiv.style.color="green";
		pwordDiv.innerHTML = "OK";
		return true;
	} else {
		pwordDiv.style.color="red";
		if (formObject.name == "registerForm") {
			passwordCheckRegisterFormatter(pword,pwordDiv);
		} else {
			pwordDiv.innerHTML = "Incorrect password. Check caps lock";
		}
		return false;
	}
}