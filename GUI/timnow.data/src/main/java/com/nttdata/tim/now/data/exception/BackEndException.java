package com.nttdata.tim.now.data.exception;


public class BackEndException extends IntegrationLayerException{

	private static final long serialVersionUID = -6905124629551640163L;

	public BackEndException() {
		super();
	}

	public BackEndException(String message, Throwable cause) {
		super(message, cause);
	}

	public BackEndException(String message) {
		super(message);
	}

	public BackEndException(Throwable cause) {
		super(cause);
	}

}
