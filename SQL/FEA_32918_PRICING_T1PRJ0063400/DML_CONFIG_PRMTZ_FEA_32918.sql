-----------------------
-- FEA_32918
----------------------
SET SERVEROUTPUT ON;
BEGIN
	DBMS_OUTPUT.PUT_LINE ('INSERT PARAMETRI_CFGZ_NOW');
  Insert into APPUSER.PARAMETRI_CFGZ_NOW (CHIAVE,DESCR_PARAMETRO,NOME_PROCSO,OPERATORE,TIMSTP_AGGTO,TIMSTP_INSMTO,VALORE_STRINGA,VALORE_NUMERICO) values 
('ELAB_ANA_MERCATO','Indica il numero di record elaborati per ogni RUN - C26M42','C26M42','OPERATORE',NULL,SYSTIMESTAMP,null,1000);
    COMMIT;              
	DBMS_OUTPUT.PUT_LINE ('Commit executed');
EXCEPTION 
	WHEN OTHERS THEN
		dbms_output.put_line('ERRORE - '||SQLERRM);
		ROLLBACK;
		dbms_output.put_line('Rollback executed');
END;
/
