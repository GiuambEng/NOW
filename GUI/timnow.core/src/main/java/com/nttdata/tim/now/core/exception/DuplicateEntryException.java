package com.nttdata.tim.now.core.exception;

public class DuplicateEntryException extends Exception {

	private static final long serialVersionUID = -5225586363598383498L;

	public DuplicateEntryException() {
		super();
	}

	public DuplicateEntryException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateEntryException(String message) {
		super(message);
	}

	public DuplicateEntryException(Throwable cause) {
		super(cause);
	}
	
}
