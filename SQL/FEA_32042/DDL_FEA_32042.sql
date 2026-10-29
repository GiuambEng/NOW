----------------------------
-- FEA_32042 NOW ERA 5.2.64
----------------------------
ALTER TABLE APPUSER.PRGT 
        ADD FLAG_EREDITA_CODICE_PROGETTO VARCHAR2(2) 
		DEFAULT 'NO' 
        CHECK (FLAG_EREDITA_CODICE_PROGETTO IN ('SI','NO'))
        NOT NULL;
