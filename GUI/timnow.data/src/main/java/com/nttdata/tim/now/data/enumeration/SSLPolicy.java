package com.nttdata.tim.now.data.enumeration;

public enum SSLPolicy {
	EASY("easy"),
	MUTUAL("mutual");
	
	private String identifier;
	
	private SSLPolicy(String identifier) {
		this.identifier = identifier;
	}
	
	public String getIdentifier() {
		return this.identifier;
	}
	
	public static SSLPolicy getPolicyByIdentifier(String identifier) {
		for(SSLPolicy item : SSLPolicy.values()) {
			if (item.getIdentifier().equals(identifier)) {
				return item;				
			}
		}
		return null;
	}
	
}
