----------------------------
-- CS_53467
----------------------------
SET SERVEROUTPUT ON;
BEGIN
	DBMS_OUTPUT.PUT_LINE ('INSERT ANAG_CAUS_FASE');
	INSERT INTO APPUSER.ANAG_CAUS_FASE VALUES ('TBD','','N','728','1202','2','19','10','15','Y');	COMMIT;              
	DBMS_OUTPUT.PUT_LINE ('Commit executed');
EXCEPTION 
	WHEN OTHERS THEN
		dbms_output.put_line('ERRORE - '||SQLERRM);
		ROLLBACK;
		dbms_output.put_line('Rollback executed');
END;
/