CREATE OR REPLACE PACKAGE APPUSER.PKG_NOW_MIGRAZIONE_ULLSLU AS

   -- Description :
   --
   -- Modification Log:
   --
   --   Author           Date       Version  Changes
   --   ---------------- ---------  -------  -----------------------------------
   --   DP               23/01/2026 1.0      Creato

    PROCEDURE main (v_id_f_procso_input IN NUMBER);


END PKG_NOW_MIGRAZIONE_ULLSLU;
/
CREATE OR REPLACE PACKAGE BODY APPUSER.PKG_NOW_MIGRAZIONE_ULLSLU AS
   -- Description :
   --
   -- Modification Log:
   --
   --   Author           Date       Version  Changes
   --   ---------------- ---------  -------  -----------------------------------
   --   DP               23/01/2026 1.0      Creato
   --   DP               03/02/2026 2.0      NOW_SM_11921  -- Modificata la condizione di Where delle update su STATO_ALLINEAMENTI
                                                           -- invece di usare la ID_ESEC_PROCSO_FILE usa la ID_FILE
   --   DP               04/02/2026 3.0      NOW_SM_11921 (AGGIORNAMENTO) -- Valorizzati in uscita i campi RECORD_TRG_OK e RECORD_TRG_KO con il valore
                                                                          -- dei campi RECORD_STG_OK e RECORD_STG_KO
   --   GG               05/02/2026          NOW_SM_11925 dettaglio_linea_now  not in ('RTG+ADSL', 'RTG', 'ADSL')
   --   GG               03/04/2026          NOW_SM_12000 aggiunto statoasset='ATTIVO'
   --   DP               16/07/2026          FEA 42245 (Ex ISSUE 40494) Aggiunto controllo esistenza di almeno una 
   --                                        offerta di tipo ULL* e modificato un controllo sulla ricerca risorsa
   --   DP               25/08/2026          FEA_44061 Aggiunto valore ENT per il check su SEGMENTO_LINEA_NOW

--  INIZIO PKG
-- ** NOTE : Procedura MAIN

    PROCEDURE main (v_id_f_procso_input IN NUMBER) IS
      -- Il parametro in input rappresenta il valore contenuto nella colonna ID_FILE della tabella STATO_ALLINEAMENTI
      cnt NUMBER;
      v_stato VARCHAR2(100);
      v_msg VARCHAR2(100);
      v_recs_ok NUMBER:=0;
      v_recs_ko NUMBER:=0;
      v_numero VARCHAR2(100);
    BEGIN
       FOR REC IN (SELECT * FROM ANALITICO_MIGRAZIONI_ULLSLU
                    WHERE ID_FILE_PROCSO_INPUT=v_id_f_procso_input 
                      AND id_stato_elab_stag=2 
                    ORDER BY ID) LOOP
           -- Check obbligatoriet  campi
           v_numero:=REC.DISTRETTO_TELEFONO;
           if (REC.CLLI IS NULL AND REC.ARMADIO_CLLI_UNICARA IS NULL)
               OR REC.DISTRETTO_TELEFONO IS NULL
               OR REC.DETTAGLIO_LINEA_NOW IS NULL
               OR REC.SEGMENTO_LINEA_NOW IS NULL then
              if (REC.CLLI IS NULL AND REC.ARMADIO_CLLI_UNICARA IS NULL) THEN v_msg:= 'CLLI';
              ELSIF REC.DISTRETTO_TELEFONO IS NULL THEN v_msg:= 'DISTRETTO_TELEFONO';
              ELSIF REC.DETTAGLIO_LINEA_NOW IS NULL THEN v_msg:= 'DETTAGLIO_LINEA_NOW';
              ELSIF REC.SEGMENTO_LINEA_NOW IS NULL THEN v_msg:= 'SEGMENTO_LINEA_NOW';
              ELSE v_msg:=NULL;
              END IF;
              UPDATE ANALITICO_MIGRAZIONI_ULLSLU inf_port
              SET inf_port.id_stato_elab_stag = 3,
                  INF_PORT.Tmstp_Aggto = SYSTIMESTAMP,
                  inf_port.descrizione_errore = 'A0 - Assenza di campi obbligatori nel tracciato: ' || v_msg
                  WHERE ID = REC.ID;
                  v_recs_ko:=v_recs_ko+1;
                  CONTINUE;
           end if;
           if REPLACE(upper(rec.dettaglio_linea_now),' ',NULL) not in ('RTG+ADSL', 'RTG', 'ADSL') then
              UPDATE ANALITICO_MIGRAZIONI_ULLSLU inf_port
              SET inf_port.id_stato_elab_stag = 3,
                  INF_PORT.Tmstp_Aggto = SYSTIMESTAMP,
                  inf_port.descrizione_errore = 'A0 - Assenza di campi obbligatori nel tracciato: DETTAGLIO_LINEA_NOW'
                  WHERE ID = REC.ID;
                  v_recs_ko:=v_recs_ko+1;
                  CONTINUE;
           end if;
           -- FEA_44061
           if upper(rec.segmento_linea_now) not in ('SMB', 'ENT', 'TIM RESIDENZIALI') then
              UPDATE ANALITICO_MIGRAZIONI_ULLSLU inf_port
              SET inf_port.id_stato_elab_stag = 3,
                  INF_PORT.Tmstp_Aggto = SYSTIMESTAMP,
                  inf_port.descrizione_errore = 'A0 - Assenza di campi obbligatori nel tracciato: SEGMENTO_LINEA_NOW'
                  WHERE ID = REC.ID;
                  v_recs_ko:=v_recs_ko+1;
                  CONTINUE;
           end if;

           -- Check duplicazione IDRISORSA
           SELECT COUNT(*) INTO cnt
             FROM ANALITICO_MIGRAZIONI_ULLSLU
            WHERE DISTRETTO_TELEFONO=REC.DISTRETTO_TELEFONO
              AND ID_FILE_PROCSO_INPUT=v_id_f_procso_input;
           if cnt > 1 then
              UPDATE ANALITICO_MIGRAZIONI_ULLSLU inf_port
                 SET inf_port.id_stato_elab_stag = 3,
                     INF_PORT.Tmstp_Aggto = SYSTIMESTAMP,
                     inf_port.descrizione_errore = 'A - Risorsa presente piu volte nel file'
               WHERE DISTRETTO_TELEFONO=REC.DISTRETTO_TELEFONO
                 AND ID = REC.ID
                 AND ID_FILE_PROCSO_INPUT=v_id_f_procso_input
                 AND id_stato_elab_stag=2;
              v_recs_ko:=v_recs_ko+1;
              CONTINUE;
           end if;
           
           -- 16/07/2026 FEA 42245 (Ex ISSUE 40494) Aggiunte nuove OFFERTE
           SELECT COUNT(*) INTO cnt
             FROM BDS_1_CASEDATA_ASSET BDS
            WHERE IDRISORSA = REC.DISTRETTO_TELEFONO
              AND BDS.CODIFICAOLOAGCOM='TLC'
              --AND OFFERTA IN ('ULLLINEANONATTIVA','ULLLINEAATTIVA','ULLDATILINEANONATTIVA')
              AND OFFERTA IN ('ULLLINEANONATTIVA','ULLLINEAATTIVA','ULLDATILINEANONATTIVA','ULL LINEA NON ATTIVA',
                            'ULLDATILINEAATTIVA','ULLDATILINEAATTIVANP','ULLLINEAATTIVANP')
              AND STATOASSET='ATTIVO';
           IF cnt > 0 THEN
              REC.IDRISORSA_NOW := REC.DISTRETTO_TELEFONO;
           ELSE
              IF SUBSTR(REC.DISTRETTO_TELEFONO,1,1)='U' THEN
                 BEGIN
                     SELECT NUMERO_TELEFONICO
                       INTO REC.IDRISORSA_NOW
                       FROM ASSOCZ_DN_IDRISORSA_DIN
                      WHERE ID_RISORSA_DIN=REC.DISTRETTO_TELEFONO
                        AND ROWNUM = 1;
                 EXCEPTION
                    WHEN OTHERS THEN
                      REC.IDRISORSA_NOW:=NULL;
                 END;
              ELSE
                 BEGIN
                     SELECT ID_RISORSA_DIN
                       INTO REC.IDRISORSA_NOW
                       FROM ASSOCZ_DN_IDRISORSA_DIN
                      WHERE NUMERO_TELEFONICO=REC.DISTRETTO_TELEFONO
                        AND ROWNUM=1;
                 EXCEPTION
                    WHEN OTHERS THEN
                      REC.IDRISORSA_NOW:=NULL;
                 END;
              END IF;
           END IF;
           IF REC.IDRISORSA_NOW IS NULL THEN
              UPDATE ANALITICO_MIGRAZIONI_ULLSLU inf_port
                 SET inf_port.id_stato_elab_stag = 3,
                     INF_PORT.Tmstp_Aggto = SYSTIMESTAMP,
                     inf_port.descrizione_errore = 'B - Risorsa Attiva non presente in base dati per olo TLC'
               WHERE ID = REC.ID;
              v_recs_ko:=v_recs_ko+1;
              CONTINUE;
         /*  ELSE
              BEGIN
                    SELECT STATOASSET
                      INTO V_STATO
                      FROM BDS_1_CASEDATA_ASSET
                     WHERE IDRISORSA = REC.IDRISORSA_NOW
                       AND CODIFICAOLOAGCOM='TLC'
                       AND OFFERTA IN ('ULLLINEANONATTIVA','ULLLINEAATTIVA','ULLDATILINEANONATTIVA')
                       AND STATOASSET = 'ATTIVO';
              EXCEPTION
                 WHEN OTHERS THEN
                    REC.IDRISORSA_NOW:=NULL;
                    UPDATE ANALITICO_MIGRAZIONI_ULLSLU inf_port
                       SET inf_port.id_stato_elab_stag = 3,
                           inf_port.descrizione_errore = 'C - Risorsa non in stato ATTIVO'
                     WHERE ID = REC.ID;
                    v_recs_ko:=v_recs_ko+1;
                    CONTINUE;
              END; */
           END IF;
           
           -- INIZIO 16/07/2026 FEA 42245 (Ex ISSUE 40494) Aggiunto controllo esistenza di almmeno una OFFERTA DI TIPO ULL*
           SELECT COUNT(*) 
             INTO CNT 
             FROM BDS_1_CASEDATA_ASSET 
            WHERE IDRISORSA=REC.IDRISORSA_NOW
              AND OFFERTA IN ('ULL LINEA NON ATTIVA',
                            'ULLDATILINEAATTIVA',
                            'ULLDATILINEAATTIVANP',
                            'ULLDATILINEANONATTIVA',
                            'ULLLINEAATTIVA',
                            'ULLLINEAATTIVANP',
                            'ULLLINEANONATTIVA'
                            );
           IF CNT = 0 THEN
                UPDATE ANALITICO_MIGRAZIONI_ULLSLU inf_port
                   SET inf_port.id_stato_elab_stag = 3,
                       inf_port.descrizione_errore = 'Offerta di partenza diversa da ULL - ' || REC.IDRISORSA_NOW
                 WHERE ID = REC.ID;
                v_recs_ko:=v_recs_ko+1;              
                CONTINUE;
           END IF;
           -- FINE 16/07/2026 FEA 42245 (Ex ISSUE 40494) Aggiunto controllo esistenza di almmeno una OFFERTA DI TIPO ULL*           
           
           UPDATE ANALITICO_MIGRAZIONI_ULLSLU inf_port
              SET inf_port.id_stato_elab_stag = 4,
                  INF_PORT.Tmstp_Aggto = SYSTIMESTAMP,
                  inf_port.descrizione_errore = NULL,
                  inf_port.idrisorsa_now=rec.idrisorsa_now
            WHERE ID = REC.ID;
            v_recs_ok:=v_recs_ok+1;
            COMMIT;
       END LOOP;
       UPDATE STATO_ALLINEAMENTI SA
          SET SA.RECORD_STG_OK=v_recs_ok,
              SA.RECORD_STG_KO=v_recs_ko,
              SA.RECORD_TRG_OK=v_recs_ok,
              SA.RECORD_TRG_KO=v_recs_ko,
              SA.DESCR_ERRORE=NULL,
              SA.STATO='OK',
              SA.LAST_UPD=SYSTIMESTAMP
        WHERE SA.ID_FILE = v_id_f_procso_input;   --- Attenzione! Non ID_ESEC_PROCSO_FILE
       COMMIT;
    EXCEPTION
        WHEN OTHERS THEN
           ROLLBACK;
           v_msg:=SQLERRM;
           UPDATE STATO_ALLINEAMENTI SA
              SET SA.RECORD_STG_OK=v_recs_ok,
                  SA.RECORD_STG_KO=v_recs_ko,
                  SA.RECORD_TRG_OK=v_recs_ok,
                  SA.RECORD_TRG_KO=v_recs_ko,
                  SA.DESCR_ERRORE=v_msg,
                  SA.STATO='KO',
                  SA.LAST_UPD=SYSTIMESTAMP
            WHERE SA.ID_FILE = v_id_f_procso_input;   --- Attenzione! Non ID_ESEC_PROCSO_FILE
           COMMIT;
    END;

END PKG_NOW_MIGRAZIONE_ULLSLU;
/
