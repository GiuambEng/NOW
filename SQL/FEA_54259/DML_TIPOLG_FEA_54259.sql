----------------------------
-- FEA_54259
----------------------------
SET SERVEROUTPUT ON;
BEGIN
	DBMS_OUTPUT.PUT_LINE ('INSERT SISTEMA');
	INSERT INTO APPUSER.SISTEMA VALUES ('FIBERVALUE',59,'N');
	DBMS_OUTPUT.PUT_LINE ('INSERT PROCSO_FILE');
	INSERT INTO APPUSER.PROCSO_FILE VALUES ('FIBERVALUE_G','Processo di estrazione giornaliera delle consistenze verso FIBERVALUE',338);
	INSERT INTO APPUSER.PROCSO_FILE VALUES ('FIBERVALUE_M','Processo di estrazione mensile delle consistenze verso FIBERVALUE',339);
	INSERT INTO APPUSER.PROCSO_FILE VALUES ('FIBERVALUE_VULL','Processo di Estrazione consistenze VULL verso FIBERVALUE',340);
	DBMS_OUTPUT.PUT_LINE ('INSERT INTRFC');
	INSERT INTO APPUSER.INTRFC VALUES ('ID463','Estrazione Giornaliera Consistenze verso FIBERVALUE','6','8','512','338','','1','59','1',' G_NOWATM_AAAAMMGG','','OUTPUT');
	INSERT INTO APPUSER.INTRFC VALUES ('ID464','Estrazione Mensile Consistenze verso FIBERVALUE','6','9','513','339','','1','59','1','M_NOWATM_AAAAMMGG','','OUTPUT');
	INSERT INTO APPUSER.INTRFC VALUES ('ID465','Interfaccia VULL verso FIBERVALUE','1','8','514','340','','1','59','1','VULL_X_FIBERVALUE_NOW_PAAMMGG.csv','','OUTPUT');
	COMMIT;
	DBMS_OUTPUT.PUT_LINE ('Commit executed');
EXCEPTION 
	WHEN OTHERS THEN
		dbms_output.put_line('ERRORE - '||SQLERRM);
		ROLLBACK;
		dbms_output.put_line('Rollback executed');
END;
/