package com.lassulfi.app.ws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequestModel {
	
	@NotNull(message = "first name cannot be null")
	@Size(min = 2, message = "First name must not be less than {min} characters")
	private String firstName;
	
	@NotNull(message = "last name cannot be null")
	@Size(min = 2, message = "Last name must not be less than {min} characters")
	private String lastName;
	
	@NotNull(message = "email cannot be null")
	@Email
	private String email;
	
	@NotNull(message = "password cannot be null")
	@Size(min = 8, max = 16, message = "Password must be equal or greater than {min} or less then {max} characters")
	private String password;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
