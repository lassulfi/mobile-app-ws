package com.lassulfi.app.ws.exceptions;

public class UserServiceException extends NullPointerException {
	private static final long serialVersionUID = 1L;

	public UserServiceException(String msg) {
		super(msg);
	}
}
