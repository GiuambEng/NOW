package com.nttdata.tim.now.data.enumeration;

public enum TrackingOperationType {
	LOGIN("LOGIN"), 
	LOGOUT("LOGOUT");

	private String operationType;

	private TrackingOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getOperationType() {
		return operationType;
	}
}