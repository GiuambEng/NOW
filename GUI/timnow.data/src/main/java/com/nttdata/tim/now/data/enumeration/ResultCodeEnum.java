package com.nttdata.tim.now.data.enumeration;

public enum ResultCodeEnum {
	
	ALREADY_EXISTS("2", "Entita gia esitente"),
	
	NOT_READY ("1", "Risorsa non pronta"),
	
	OK ("0", "OK"),
	
	GENERIC_ERROR ("-1", "Errore Generico"),
	
	NOT_FOUND ("2", "Risorsa non trovata"),
	
    VALIDATION_ERROR ("-20", "Errore Validazione Dati"),

	BACK_END_ERROR ("-666", "Errore Back End");

    private final String code;       
    private final String message;       

    private ResultCodeEnum(String c, String m) {
        code = c;
        message = m;
    }

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
