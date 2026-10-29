package com.nttdata.tim.now.adapters.exception;


public class RESTServiceException extends Exception {

	private static final long serialVersionUID = 301644076148674417L;

	public RESTServiceException() {
        super();
    }

    public RESTServiceException(String mex) {
        super(mex);
    }

    public RESTServiceException(String mex, Throwable t) {
        super(mex, t);
    }

    public RESTServiceException(Throwable t) {
        super(t);
    }
}
