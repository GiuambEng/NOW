package com.nttdata.tim.now.data.enumeration;

//RU_902
public enum TrackingEventResult {
	
	OK("Ok"),
	KO("Ko");

	private final String description;
	
	private TrackingEventResult( String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
}
