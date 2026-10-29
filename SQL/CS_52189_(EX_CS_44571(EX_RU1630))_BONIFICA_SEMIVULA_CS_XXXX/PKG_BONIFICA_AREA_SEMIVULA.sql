CREATE OR REPLACE PACKAGE APPUSER.PKG_BONIFICA_AREA_SEMIVULA IS
   -- 03/07/2026 RU_1630 C25M64F03/F04
   -- 13/07/2026 RU_1630 eliminati i parametri in input
   -- 04/09 2026 RU_1630 Modificata la insert sulla tabella BDS_1_CASEDATA_ATTRIBTDTTGLSST
   PROCEDURE PRC_BONIF_AREA_SEMIVULA;
   PROCEDURE PRC_INVIO_BON_AREA_SMVULA_JPUB;

END PKG_BONIFICA_AREA_SEMIVULA;
/

CREATE OR REPLACE PACKAGE BODY APPUSER.PKG_BONIFICA_AREA_SEMIVULA IS
   ------------------------------------------------------------------------------------------------
   -- 03/07/2026 RU_1630 C25M64F03 - Bonifica asset campo AREA
   -- 03/07/2026 RU_1630 C25M64F04 - Invio verso JPUB
   -- NB: la creazione del file tappo .OK e l'invio SFTP sono gestiti esternamente
   --     (scheduler/middleware) tramite configurazione INTRFC cod. ID459,
   --     PROCSO_FILE cod. FILE_JPUB_BONIFICA_AREA
   -- 13/07/2026 RU_1630 eliminati i parametri in input
   -- 21/07/2026 RU_1630 aggiunta valorizzazione ID_STATO_ELAB_STAGING per accordo con BW
   -- 31/07/2026 CS_44571 OPERA non disponde del BDS_ID che era NOT NULL nella tabella ANALITICO;
   -- si e'' stabilito di lasciarlo in tabella, ma OPERA ce lo manda vuoto e noi lo togliamo dalla logica
   -- 03/08/2026 mail Rende luned? 03/08/2026 16:41 ORA-00936: missing expression eliminato ON alla riga 117
   -- 03/09/2026 CS_XXXX popolamento completo in fase di inserimento sulla tabella BDS_1_CASEDATA_ATTRIBTDTTGLSST
   -- e pulizia delle variabili di appoggio
   ------------------------------------------------------------------------------------------------

   PROCEDURE INFO (TEXT VARCHAR2) IS
   BEGIN
      DBMS_OUTPUT.PUT_LINE('[' || TO_CHAR(SYSTIMESTAMP, 'DD/MM/RR HH24:MI:SS.FF') || '] ' || TEXT);
   END INFO;


   -- C25M64F04 - Invio verso JPUB
   -- Inserisce in ESTRAZIONI i record bonificati con STATO_INVIO_JPUB=0 (DA INVIARE).
   -- Eseguita solo se il parametro INVIO_JPUB_BON_AREA_SMVULA = 'Y'.
   -- Naming file atteso in input: NOW_JPUB_COLOR_SEMIVULA_DDMMYYYY.csv
   PROCEDURE PRC_INVIO_BON_AREA_SMVULA_JPUB IS

      last_rec_seq        NUMBER;
      v_flag_invio        VARCHAR2(1);
      FROM_CLAUSE         VARCHAR2(2000);
      V_CHECK_FILE_READY  NUMBER:=0;
      v_nome_file         VARCHAR2(4000);
      p_id_file           NUMBER;
      p_id_file_input     NUMBER;


      COLS PKG_ESTRAZIONI_UTILITY.tSELECT_COLUMNS DEFAULT PKG_ESTRAZIONI_UTILITY.tSELECT_COLUMNS
         ( 'ASSET.CODIFICAOLOAGCOM',
           'CO.COD_CONTRATTO',
           'ANALITICO.ID_RISORSA',
           'TO_CHAR(ASSET.DES, ''YYYY-MM-DD'')',
           'ATT.VALOREATTRIBUTO'
         );

      COLS_HEAD PKG_ESTRAZIONI_UTILITY.tSELECT_COLUMNS DEFAULT PKG_ESTRAZIONI_UTILITY.tSELECT_COLUMNS
         ( 'CODICE_OAO',
           'CODICE_CONTRATTO',
           'ID_RISORSA',
           'DATA_DES',
           'AREA_COLORE'
         );

   BEGIN
      INFO('*** STARTED PROCEDURE PRC_INVIO_BON_AREA_SMVULA_JPUB');

      BEGIN
         select ID_PROCSO_FILE into p_id_file_input from intrfc where COD_INTRFC='ID457';
      EXCEPTION
         WHEN OTHERS THEN
         DBMS_OUTPUT.put_line('La tabella INTRFC non e'' configurata per COD_INTRFC=''ID457''');
         RETURN;
       END;


      BEGIN
         SELECT ID_PROCSO_FILE, REPLACE(NAMING_CONVENTION,'DDMMYYYY',TO_CHAR(SYSDATE,'DDMMYYYY'))
            into p_id_file, v_nome_file
            FROM INTRFC WHERE COD_INTRFC = 'ID459';
      EXCEPTION
         WHEN OTHERS THEN
         DBMS_OUTPUT.put_line('La tabella INTRFC non e'' configurata per COD_INTRFC=''ID459''');
         RETURN;
       END;

      -- verifica che il file sia stato completamente bonificato cioe tutti i record per l'ID_FILE in input hanno STATO_BONIFICA_ASSET <> 0
      SELECT COUNT(*) INTO V_CHECK_FILE_READY FROM ANALITICO_D_BON_AREA_SEMIVULA
         WHERE STATO_BONIFICA_ASSET=0 AND CONTENUTO_RECORD <> 'EOF' AND ID_FILE=p_id_file_input;

      IF V_CHECK_FILE_READY > 0  THEN
         DBMS_OUTPUT.put_line('Il file con ID_FILE ' || p_id_file || ' non e'' pronto per essere spedito a JPUB.');
         DBMS_OUTPUT.put_line('Attendere la fine della bonifica o lanciare ancora la procedura di bonifica.');
         RETURN;
      END IF;

      -- Verifica parametro abilitazione invio
      BEGIN
         SELECT VALORE_STRINGA
           INTO v_flag_invio
           FROM PARAMETRI_CFGZ_NOW
          WHERE CHIAVE = 'INVIO_JPUB_BON_AREA_SMVULA';
      EXCEPTION
         WHEN NO_DATA_FOUND THEN
            v_flag_invio := 'N';
      END;

      IF NVL(v_flag_invio, 'N') != 'Y' THEN
         INFO('*** INVIO JPUB DISABILITATO (parametro INVIO_JPUB_BON_AREA_SMVULA != Y)');
         INFO('*** FINISHED PROCEDURE PRC_INVIO_BON_AREA_SMVULA_JPUB');
         RETURN;
      END IF;

      PKG_ESTRAZIONI_UTILITY.INIT(p_id_file, v_nome_file);


      FROM_CLAUSE := q'[FROM APPUSER.ANALITICO_D_BON_AREA_SEMIVULA ANALITICO
         JOIN APPUSER.BDS_1_CASEDATA_ASSET ASSET
              -- CS_44571
              -- ON ASSET.BDS_ID = ANALITICO.BDS_ID
                 ON ASSET.IDASSET = ANALITICO.ID_ASSET AND ASSET.IDRISORSA = ANALITICO.ID_RISORSA
         JOIN APPUSER.CONTRATTO CO
              ON CO.ID_CONTRATTO = ASSET.IDCONTRATTO
         JOIN APPUSER.BDS_1_CASEDATA_DETTAGLIOASSET DETT
              ON DETT.ASSET_DETTAGLIOASSET_BDSID = ASSET.BDS_ID
             AND DETT.NOMECOMPONENTE = 'ACCESSOVULAFTTH'
             AND DETT.IDRISORSA = ANALITICO.ID_RISORSA
         JOIN APPUSER.BDS_1_CASEDATA_ATTRIBTDTTGLSST ATT
              ON ATT.DTTGLSST_TTRBTIDTTGLISST_BDSID = DETT.BDS_ID
             AND ATT.NOMEATTRIBUTO = 'AREA']';

      PKG_ESTRAZIONI_UTILITY.SPOOL_QUERY(
            inIDFILE       => p_id_file,
            inFILENAME     => v_nome_file,
            SELECT_COLUMNS => COLS,
            FROM_CLAUSE    => FROM_CLAUSE,
            SEPARATOR      => PKG_ESTRAZIONI_UTILITY.kPIPE_SEPARATOR,
            WHERE_CLAUSE   => 'WHERE ANALITICO.STATO_BONIFICA_ASSET = 1 AND ANALITICO.STATO_INVIO_JPUB = 0',
            HEADER_COLS    => COLS_HEAD
         );

      -- Aggiornamento stato invio a 1 (INVIATO) dopo inserimento in ESTRAZIONI
      UPDATE APPUSER.ANALITICO_D_BON_AREA_SEMIVULA
         SET STATO_INVIO_JPUB    = 1,
             DATA_AGGIORNAMENTO  = SYSTIMESTAMP
       WHERE STATO_BONIFICA_ASSET = 1
         AND STATO_INVIO_JPUB    = 0;

      -- Inserimento record EOF
      SELECT NVL(MAX(SEQUENZA), 0) + 1 INTO last_rec_seq
        FROM APPUSER.ESTRAZIONI
       WHERE NOME_FILE = v_nome_file AND ID_FILE = p_id_file;

      INSERT INTO APPUSER.ESTRAZIONI (CREATED, SEQUENZA, NOME_FILE, ID_FILE, RIGA)
         VALUES (SYSTIMESTAMP, last_rec_seq, v_nome_file, p_id_file, 'EOF');
      COMMIT;

      PKG_ESTRAZIONI_UTILITY.ROUNDOFF(p_id_file);
      INFO('*** FINISHED PROCEDURE PRC_INVIO_BON_AREA_SMVULA_JPUB');

   EXCEPTION
      WHEN OTHERS THEN
         INFO('*** [PRC_INVIO_BON_AREA_SMVULA_JPUB] - FATAL ERROR: ' || SQLERRM);
         -- Aggiornamento stato invio a 2 (NON INVIATO) in caso di errore
         UPDATE APPUSER.ANALITICO_D_BON_AREA_SEMIVULA
            SET STATO_INVIO_JPUB   = 2,
                ID_STATO_ELAB_STAGING = 46,  -- 21/07/2026 VALORIZZATO CAMPO PER ACCORDO BW CON SCARTATO
                DATA_AGGIORNAMENTO = SYSTIMESTAMP
          WHERE STATO_BONIFICA_ASSET = 1
            AND STATO_INVIO_JPUB    = 0;
         COMMIT;
         PKG_ESTRAZIONI_UTILITY.TRAP(p_id_file, SQLERRM);
         INFO('*** FINISHED PROCEDURE PRC_INVIO_BON_AREA_SMVULA_JPUB');

   END PRC_INVIO_BON_AREA_SMVULA_JPUB;


   -- C25M64F03 - Bonifica asset campo AREA
   -- Aggiorna BDS_1_CASEDATA_ATTRIBTDTTGLSST con i valori del campo AREA da OPERA.
   -- Considera i record con STATO_BONIFICA_ASSET = 0 (DA BONIFICARE).
   -- Codici KO:
   --   A - Asset non trovato
   --   B - Asset in lavorazione
   --   C - Offerta non congruente
   PROCEDURE PRC_BONIF_AREA_SEMIVULA IS

      V_AREA_DA_SCRIVERE  VARCHAR2(100);
      V_CURR_ROWID        VARCHAR2(100);
      V_BDS_ID            BDS_1_CASEDATA_ASSET.BDS_ID%TYPE; -- CS_44571
      V_DETT_BDS_ID       BDS_1_CASEDATA_DETTAGLIOASSET.BDS_ID%TYPE;
      V_ATT_BDS_ID        BDS_1_CASEDATA_ATTRIBTDTTGLSST.BDS_ID%TYPE;
      V_STATOASSET        BDS_1_CASEDATA_ASSET.STATOASSET%TYPE;
      V_OFFERTA           BDS_1_CASEDATA_ASSET.OFFERTA%TYPE;
      V_MSG_ERR           VARCHAR2(4000);
      V_CHECK_FILE_READY  NUMBER:=0;
      p_id_file           NUMBER;
      V_ATTRIBUTE_IDX     NUMBER; -- CS_XXXX

   BEGIN
      INFO('*** STARTED PROCEDURE PRC_BONIF_AREA_SEMIVULA');

      BEGIN
         select ID_PROCSO_FILE into p_id_file from intrfc where COD_INTRFC='ID457';
      EXCEPTION
         WHEN OTHERS THEN
         DBMS_OUTPUT.put_line('La tabella INTRFC non e'' configurata per COD_INTRFC=''ID457''');
         RETURN;
       END;

      -- verifica che il caricamento del file sia terminato (BW inserisce il record con EOF)
      SELECT COUNT(*) INTO V_CHECK_FILE_READY FROM ANALITICO_D_BON_AREA_SEMIVULA
         WHERE CONTENUTO_RECORD = 'EOF' AND ID_FILE=p_id_file;

      IF V_CHECK_FILE_READY = 0 THEN
         DBMS_OUTPUT.put_line('Il file con ID_FILE ' || p_id_file || ' e'' ancora in fase di caricamento.');
         DBMS_OUTPUT.put_line('Attendere la fine del caricamento per procedere con la bonifica.');
         RETURN;
      END IF;

      -- CS_44571 nella tabella ANALITICO_D_BON_AREA_SEMIVULA e'' presente BDS_ID, ma OPERA ce lo passa a NULL
      -- e percio'' non va utilizzato nella logica
      FOR RIGA IN (SELECT t.ROWID, t.*
                     FROM ANALITICO_D_BON_AREA_SEMIVULA t
                    WHERE t.STATO_BONIFICA_ASSET = 0
                      AND ID_STATO_ELAB_STAGING = 42 -- 21/07/2026 IMPOSTATO A 42 (DA ELABORARE) PER ACCORDO CON BW
                      AND ID_FILE = p_id_file
                      AND NVL(CONTENUTO_RECORD, ' ') <> 'EOF'
                      AND ROWNUM <= (SELECT VALORE_NUMERICO FROM PARAMETRI_CFGZ_NOW
                                      WHERE CHIAVE = 'BONIF_AREA_SEMIVULA'))
      LOOP
         BEGIN
            V_CURR_ROWID := RIGA.ROWID;
            -- CS_XXXX
            V_AREA_DA_SCRIVERE:=null;
            V_BDS_ID:=null;
            V_STATOASSET:=null;
            V_OFFERTA:=null;
            V_DETT_BDS_ID:=null;
            V_ATT_BDS_ID:=null;
            V_ATTRIBUTE_IDX:=0;

            -- Recupera ASSET: caso A - asset non trovato
            BEGIN
               -- CS_44571
               -- SELECT ASSET.STATOASSET, ASSET.OFFERTA
               SELECT ASSET.BDS_ID, ASSET.STATOASSET, ASSET.OFFERTA
                 -- CS_44571
                 -- INTO V_STATOASSET, V_OFFERTA
                 INTO V_BDS_ID, V_STATOASSET, V_OFFERTA
                 FROM BDS_1_CASEDATA_ASSET ASSET
                -- CS_44571
                WHERE -- ASSET.BDS_ID   = RIGA.BDS_ID AND
                  ASSET.IDASSET   = RIGA.ID_ASSET
                  AND ASSET.IDRISORSA = RIGA.ID_RISORSA;
            EXCEPTION
               WHEN NO_DATA_FOUND THEN
                  UPDATE ANALITICO_D_BON_AREA_SEMIVULA
                     SET STATO_BONIFICA_ASSET = 2,
                         ID_STATO_ELAB_STAGING = 46, -- 21/07/2026 VALORIZZATO CAMPO PER ACCORDO CON BW CON SCARTATO
                         DESCR_KO_BONIFICA    = 'A - Asset non trovato',
                         DATA_AGGIORNAMENTO   = SYSTIMESTAMP
                   WHERE ROWID = V_CURR_ROWID;
                  COMMIT;
                  CONTINUE;
            END;
            -- DBMS_OUTPUT.put_line('V_OFFERTA: ' || V_OFFERTA);
            -- DBMS_OUTPUT.put_line('V_STATOASSET: ' || V_STATOASSET);
            -- Verificare se possibile e cosa fare se OFFERTA IS NULL oppure STATOASSET IS NULL

            -- Caso E - STATOASSET NON VALORIZZATO
            IF V_STATOASSET IS NULL THEN
               UPDATE ANALITICO_D_BON_AREA_SEMIVULA
                  SET STATO_BONIFICA_ASSET = 2,
                      DESCR_KO_BONIFICA    = 'E - StatoAsset non valorizzato',
                      ID_STATO_ELAB_STAGING = 46, -- 21/07/2026 VALORIZZATO CAMPO PER ACCORDO CON BW CON SCARTATO
                      DATA_AGGIORNAMENTO   = SYSTIMESTAMP
                WHERE ROWID = V_CURR_ROWID;
               COMMIT;
               CONTINUE;
            END IF;

            -- Caso F - OFFERTA NON VALORIZZATA
            IF V_OFFERTA IS NULL THEN
               UPDATE ANALITICO_D_BON_AREA_SEMIVULA
                  SET STATO_BONIFICA_ASSET = 2,
                      DESCR_KO_BONIFICA    = 'F - Offerta non valorizzata',
                      ID_STATO_ELAB_STAGING = 46, -- 21/07/2026 VALORIZZATO CAMPO PER ACCORDO CON BW CON SCARTATO
                      DATA_AGGIORNAMENTO   = SYSTIMESTAMP
                WHERE ROWID = V_CURR_ROWID;
               COMMIT;
               CONTINUE;
            END IF;

            -- Caso B - asset in lavorazione VERIFICARE SE CORRETTO
            IF V_STATOASSET = 'INLAVORAZIONE' THEN
               UPDATE ANALITICO_D_BON_AREA_SEMIVULA
                  SET STATO_BONIFICA_ASSET = 2,
                      DESCR_KO_BONIFICA    = 'B - Asset in lavorazione',
                      ID_STATO_ELAB_STAGING = 46, -- 21/07/2026 VALORIZZATO CAMPO PER ACCORDO CON BW CON SCARTATO
                      DATA_AGGIORNAMENTO   = SYSTIMESTAMP
                WHERE ROWID = V_CURR_ROWID;
               COMMIT;
               CONTINUE;
            END IF;

            -- Caso C - offerta non congruente
            IF V_OFFERTA != 'SEMIVULAFTTH' THEN
               UPDATE ANALITICO_D_BON_AREA_SEMIVULA
                  SET STATO_BONIFICA_ASSET = 2,
                      DESCR_KO_BONIFICA    = 'C - Offerta non congruente',
                      ID_STATO_ELAB_STAGING = 46, -- 21/07/2026 VALORIZZATO CAMPO PER ACCORDO CON BW CON SCARTATO
                      DATA_AGGIORNAMENTO   = SYSTIMESTAMP
                WHERE ROWID = V_CURR_ROWID;
               COMMIT;
               CONTINUE;
            END IF;

            -- Valore AREA da scrivere: se null usa il default 'NERO'
            V_AREA_DA_SCRIVERE := NVL(RIGA.AREA, 'NERO');

            -- Recupera il DETTAGLIO ASSET sotto ACCESSOVULAFTTH
            -- Aggiornare Analisi con msg 'D - Componente Asset non trovato'
            BEGIN
               SELECT DETT.BDS_ID INTO V_DETT_BDS_ID
                 FROM BDS_1_CASEDATA_DETTAGLIOASSET DETT
                -- WHERE DETT.ASSET_DETTAGLIOASSET_BDSID = RIGA.BDS_ID
                WHERE DETT.ASSET_DETTAGLIOASSET_BDSID = V_BDS_ID
                  AND DETT.NOMECOMPONENTE = 'ACCESSOVULAFTTH'
                  AND DETT.IDRISORSA = RIGA.ID_RISORSA;
            EXCEPTION
               WHEN NO_DATA_FOUND THEN
                  UPDATE ANALITICO_D_BON_AREA_SEMIVULA
                     SET STATO_BONIFICA_ASSET = 2,
                         DESCR_KO_BONIFICA    = 'D - Componente Asset non trovato',
                         ID_STATO_ELAB_STAGING = 46, -- 21/07/2026 VALORIZZATO CAMPO PER ACCORDO CON BW CON SCARTATO
                         DATA_AGGIORNAMENTO   = SYSTIMESTAMP
                   WHERE ROWID = V_CURR_ROWID;
                  COMMIT;
                  CONTINUE;
            END;

            -- Verifica se esiste l'attributo AREA sotto ACCESSOVULAFTTH
            BEGIN
               SELECT ATT.BDS_ID INTO V_ATT_BDS_ID
                 FROM BDS_1_CASEDATA_ATTRIBTDTTGLSST ATT
                WHERE ATT.DTTGLSST_TTRBTIDTTGLISST_BDSID = V_DETT_BDS_ID
                  AND ATT.NOMEATTRIBUTO = 'AREA';

               -- Attributo esistente: aggiorna
               UPDATE BDS_1_CASEDATA_ATTRIBTDTTGLSST
                  SET VALOREATTRIBUTO = V_AREA_DA_SCRIVERE,
                      LASTUPDATE      = SYSTIMESTAMP
                WHERE BDS_ID = V_ATT_BDS_ID;

            EXCEPTION
               WHEN NO_DATA_FOUND THEN
                  -- Attributo non esistente: crea
                  -- CS_XXXX 
                  SELECT NVL(MAX(DTTGLISST_TTRIBTIDTTGLISST_IDX) + 1, 0) INTO V_ATTRIBUTE_IDX 
                     FROM BDS_1_CASEDATA_ATTRIBTDTTGLSST ATTR
                        WHERE ATTR.DTTGLSST_TTRBTIDTTGLISST_BDSID = V_DETT_BDS_ID; -- V_DETT_BDS_ID=id della componente
                                    
                  INSERT INTO BDS_1_CASEDATA_ATTRIBTDTTGLSST
                     (BDS_ID, 
                      DTYPE, 
                      IDASSET, 
                      CREATED, 
                      LASTUPDATE,
                      NOMEATTRIBUTO, 
                      VALOREATTRIBUTO,
                      DTTGLSST_TTRBTIDTTGLISST_BDSID,
                      OPERATORE, 
                      TIPOLOGIADATO, 
                      IDDETTAGLIOASSET, 
                      BDS_OWNER_ID,
                      DTTGLISST_TTRIBTIDTTGLISST_IDX)
                  VALUES
                     (S_BDS_ID.NEXTVAL, -- BDS_ID
                      'it.telecomitalia.it.NOW.casedata.AttributiDettaglioAsset', --DTYPE
                      RIGA.ID_ASSET, -- IDASSET
                      SYSTIMESTAMP, -- CREATED
                      SYSTIMESTAMP, -- LASTUPDATE
                      'AREA', -- NOMEATTRIBUTO
                      V_AREA_DA_SCRIVERE, -- VALOREATTRIBUTO
                      V_DETT_BDS_ID, -- DTTGLSST_TTRBTIDTTGLISST_BDSID
                      'BPM', -- OPERATORE
                      PKG_MIGRAZIONI.GET_TIPOLOGIADATO(V_AREA_DA_SCRIVERE), -- TIPOLOGIADATO
                      1, -- IDDETTAGLIOASSET
                      RIGA.ID_ASSET, -- BDS_OWNER_ID
                      V_ATTRIBUTE_IDX -- DTTGLISST_TTRIBTIDTTGLISST_IDX
                      );
            END;

            UPDATE ANALITICO_D_BON_AREA_SEMIVULA
               SET STATO_BONIFICA_ASSET = 1,
                   DESCR_KO_BONIFICA    = NULL,
                   ID_STATO_ELAB_STAGING = 47, -- 21/07/2026 VALORIZZATO CAMPO PER ACCORDO CON BW CON ELABORATO
                   DATA_AGGIORNAMENTO   = SYSTIMESTAMP
             WHERE ROWID = V_CURR_ROWID;

            COMMIT;

         EXCEPTION
            WHEN OTHERS THEN
               V_MSG_ERR := SUBSTR(SQLERRM, 1, 4000);
               UPDATE ANALITICO_D_BON_AREA_SEMIVULA
                  SET STATO_BONIFICA_ASSET = 2,
                      DESCR_KO_BONIFICA    = V_MSG_ERR,
                      ID_STATO_ELAB_STAGING = 46, -- 21/07/2026 VALORIZZATO CAMPO PER ACCORDO CON BW CON SCARTATO
                      DATA_AGGIORNAMENTO   = SYSTIMESTAMP
                WHERE ROWID = V_CURR_ROWID;
               COMMIT;
         END;
      END LOOP;

      INFO('*** FINISHED PROCEDURE PRC_BONIF_AREA_SEMIVULA');

      -- chiamata da shell
      -- PRC_INVIO_BON_AREA_SMVULA_JPUB(p_id_file, V_NOME_FILE);


   EXCEPTION
      WHEN OTHERS THEN
         V_MSG_ERR := SUBSTR(SQLERRM, 1, 4000);
         UPDATE ANALITICO_D_BON_AREA_SEMIVULA
            SET STATO_BONIFICA_ASSET = 2,
                DESCR_KO_BONIFICA    = V_MSG_ERR,
                ID_STATO_ELAB_STAGING = 46, -- 21/07/2026 VALORIZZATO CAMPO PER ACCORDO CON BW CON SCARTATO
                DATA_AGGIORNAMENTO   = SYSTIMESTAMP
          WHERE ROWID = V_CURR_ROWID;
          INFO('*** [PRC_BONIF_AREA_SEMIVULA] - FATAL ERROR: ' || SQLERRM);
   END PRC_BONIF_AREA_SEMIVULA;



END PKG_BONIFICA_AREA_SEMIVULA;
/