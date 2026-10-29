package com.nttdata.tim.now.web.exception;

public class AuthenticationException extends Exception {

	private static final long serialVersionUID = -5364946055567207714L;

	public AuthenticationException() {
		super();
	}

	public AuthenticationException(String mex) {
		super(mex);
	}

	public AuthenticationException(String mex, Throwable t) {
		super(mex, t);
	}

	public AuthenticationException(Throwable t) {
		super(t);
	}
}
