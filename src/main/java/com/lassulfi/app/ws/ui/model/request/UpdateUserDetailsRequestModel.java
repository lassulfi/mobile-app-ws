package com.lassulfi.app.ws.ui.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {

	@NotNull(message = "First name must not be null")
	@Size(min = 2, message = "First name must not be less than {min} characters")
	private String firstName;
	
	@NotNull(message = "Last name must not be null")
	@Size(min = 2, message = "Last name must not be less than {min} characters")
	private String lastName;

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
}
