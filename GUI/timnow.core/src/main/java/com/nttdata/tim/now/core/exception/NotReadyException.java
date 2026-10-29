package com.nttdata.tim.now.core.exception;


public class NotReadyException extends BusinessLayerException{

	private static final long serialVersionUID = -4494024973945689462L;

	public NotReadyException() {
		super();
	}

	public NotReadyException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotReadyException(String message) {
		super(message);
	}

	public NotReadyException(Throwable cause) {
		super(cause);
	}

}
