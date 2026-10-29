package com.nttdata.tim.now.adapters.exception;

public class AuthSSLRuntimeException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3776940893381888864L;


	public AuthSSLRuntimeException() {
        super();
    }


    public AuthSSLRuntimeException(String message) {
        super(message);
    }


	public AuthSSLRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}


	public AuthSSLRuntimeException(Throwable cause) {
		super(cause);
	}
}
