package com.nttdata.tim.now.data.exception;


public class IntegrationLayerException extends Exception{

	private static final long serialVersionUID = -8726951831209951746L;

	public IntegrationLayerException() {
		super();
	}

	public IntegrationLayerException(String message, Throwable cause) {
		super(message, cause);
	}

	public IntegrationLayerException(String message) {
		super(message);
	}

	public IntegrationLayerException(Throwable cause) {
		super(cause);
	}

}
