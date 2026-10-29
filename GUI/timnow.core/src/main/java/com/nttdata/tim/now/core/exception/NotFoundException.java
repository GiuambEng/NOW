package com.nttdata.tim.now.core.exception;


public class NotFoundException extends BusinessLayerException{

	private static final long serialVersionUID = 6174213010521181450L;

	public NotFoundException() {
		super();
	}

	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotFoundException(String message) {
		super(message);
	}

	public NotFoundException(Throwable cause) {
		super(cause);
	}

}
