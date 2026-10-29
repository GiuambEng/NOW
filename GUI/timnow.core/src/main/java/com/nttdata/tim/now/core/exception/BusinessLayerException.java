package com.nttdata.tim.now.core.exception;


public class BusinessLayerException extends Exception{

	private static final long serialVersionUID = 4688406761031553823L;

	public BusinessLayerException() {
		super();
	}

	public BusinessLayerException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessLayerException(String message) {
		super(message);
	}

	public BusinessLayerException(Throwable cause) {
		super(cause);
	}

}
