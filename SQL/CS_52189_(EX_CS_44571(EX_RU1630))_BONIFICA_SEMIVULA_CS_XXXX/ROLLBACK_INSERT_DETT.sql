-- Inserite 600000 record incompleti su BDS_1_CASEDATA_ATTRIBTDTTGLSST; rollbackiamo


-- per 100.000 1 minuto
declare
cnt integer:=1;
begin
FOR RIGA IN (SELECT T.ROWID
                FROM APPUSER.BDS_1_CASEDATA_ATTRIBTDTTGLSST T
                WHERE dtype IN ('AttrDettaglioAsset') and rownum < 100000
               ) LOOP
     DBMS_OUTPUT.PUT_LINE(RIGA.ROWID);          
     IF CNT > 1000 THEN 
        DBMS_OUTPUT.PUT_LINE('FACCIO COMMIT - ELIMINATE 1000 RIGHE');
        COMMIT;
        CNT:=1;
     ELSE   
         DELETE FROM APPUSER.BDS_1_CASEDATA_ATTRIBTDTTGLSST
          WHERE ROWID = RIGA.ROWID;
         DBMS_OUTPUT.PUT_LINE('ELIMINATE ' || SQL%ROWCOUNT || ' RIGHE'); 
         CNT:=CNT+1;
     END IF;
END LOOP;
end; 
COMMIT;



