package com.nttdata.tim.now.core.exception;

public class AccessDeniedException extends Exception {

	private static final long serialVersionUID = -5225586363598383498L;

	public AccessDeniedException() {
		super();
	}

	public AccessDeniedException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccessDeniedException(String message) {
		super(message);
	}

	public AccessDeniedException(Throwable cause) {
		super(cause);
	}

}
