package com.nttdata.tim.now.core.exception;

public class InvalidFilenameException extends BusinessLayerException {
	private static final long serialVersionUID = 952357000151664905L;
	
	public InvalidFilenameException() {
		super();
	}

	public InvalidFilenameException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidFilenameException(String message) {
		super(message);
	}

	public InvalidFilenameException(Throwable cause) {
		super(cause);
	}
}
