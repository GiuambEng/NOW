package com.nttdata.tim.now.data.enumeration;

public enum BackEndResultCode {
	SUCCESS("OK", "SUCCESS"),
	ERROR("KO", "ERROR"),
	ALREADY_EXISTS("2", "Duplicate Entity"),
	USER_NOT_ENABLED("UTENTE_NON_ABILITATO", "Utente non abilitato"),
	FILE_NOT_READY("NOTREADY", "Export file non pronto");

	private final String code;
	private final String message;

	private BackEndResultCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
