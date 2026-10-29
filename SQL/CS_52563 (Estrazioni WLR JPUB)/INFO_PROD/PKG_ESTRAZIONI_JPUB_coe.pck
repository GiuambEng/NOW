CREATE OR REPLACE PACKAGE PKG_ESTRAZIONI_JPUB IS

  /*
    INTERFACE PROCEDURES JPUB
  xx/06/2021  C25M48 C07 Nuova procedura
  30/06/2021   C09 RU_1181 (L'invio avviene dopo l'esecuzione del processo C26M27)
  13/08/2021  EVO Modifica inFILENAME per ESTR_WLRISDNBRA_JPUB
   13/08/2021  CS_792  Modifica condizione per ESTR_WLRISDNBRA_JPUB
  07/09/2021  RU_1219 ESTR_WLRISDNBRA_JPUB  sostituire il carattere "_" con il carattere "-"
  19/10/2021  Task_36130 Add Union per WLR AGG in GENERIC_WLRISDNBRA_JPUB
  04/11/2021  SM_10381 Modifica none procedura: ESTR_FWA_APPARATO_JPUB
  30/05/2022	RU_1294 C26M30 ? FWA Estrazione Costi disattivazione per cessazione
  26/01/2023  SM_10894 - (E) EVO C01 2023
  03/02/2023  CS_870 - (E) EVO C02 2023
  06/02/2023  RU_1359 (SM_10915) - (E) EVO C02 2023  sost. LASTUPDATE CON DRO in GENERIC_FWA_ASSET_JPUB
  04/05/2026  RU_1617 EVO - modificata procedura ESTR_WLRISDNBRA_JPUB: estrazione WLR completa (tutti i WLR attivi + aggiuntivi + STS)
  20/05/2026  CS_950 BF - estratto IDRISORSA da BDS_1_CASEDATA_RICHIESTA WLR invece del CODICE di STS
  06/07/2026  ISSUE 37585     - Rollback CS_950 (la parte STS sara gestita in seguito)
  06/07/2026  ISSUE 37585     - MODIFICHE TIPOLINEA in GENERIC_WLRISDNBRA_JPUB ed eliminata la parte STS
  */

	-- C25M48
	PROCEDURE ESTR_WLRISDNBRA_JPUB (ID_FILE            IN NUMBER);

	--RU_1181
	PROCEDURE ESTR_FWA_APPARATO_JPUB (ID_FILE            IN NUMBER);

	-- RU_1294
	PROCEDURE ESTR_FWA_ASSET_JPUB (ID_FILE        IN NUMBER,
									p_CODICE_OLO     IN VARCHAR2,
									p_ANNO           IN VARCHAR2,
									p_CODICEPROGETTO IN VARCHAR2 DEFAULT NULL);

	/*
		UTILITY
	*/

	FUNCTION GET_TIPO_LN_DIRE (inBDSID VARCHAR2) RETURN VARCHAR2;

END PKG_ESTRAZIONI_JPUB;
/
CREATE OR REPLACE PACKAGE BODY PKG_ESTRAZIONI_JPUB IS

  -- xx/06/2021  C25M48 C07 Nuova procedura
  --30/06/2021   C09 RU_1181 (L'invio avviene dopo l'esecuzione del processo C26M27)
  -- 13/08/2021  EVO Modifica inFILENAME per ESTR_WLRISDNBRA_JPUB
  -- 13/08/2021  CS_792  Modifica condizione per ESTR_WLRISDNBRA_JPUB
  -- 07/09/2021  RU_1219 ESTR_WLRISDNBRA_JPUB  sostituire il carattere "_" con il carattere "-"
  -- 19/10/2021  Task_36130 Add Union per WLR AGG in GENERIC_WLRISDNBRA_JPUB
  -- 04/11/2021  SM_10381 Modifica none procedura: ESTR_FWA_APPARATO_JPUB
  -- 30/05/2022  RU_1294 C26M30 ? FWA Estrazione Costi disattivazione per cessazione
  -- 08/06/2022  SM_10715
  -- 19/07/2022  SM_10748 Formato date
  -- 26/01/2022  SM_10894 - (E) EVO C01 2023
  -- 03/02/2023  CS_870 - (E) EVO C02 2023
  -- 06/02/2023  RU_1359 (SM_10915) - (E) EVO C02 2023  sost. LASTUPDATE CON DRO in GENERIC_FWA_ASSET_JPUB
  -- 04/05/2026  RU_1617 EVO - modificata procedura ESTR_WLRISDNBRA_JPUB: estrazione WLR completa (tutti i WLR attivi + aggiuntivi + STS)
  -- 20/05/2026  CS_950 BF - modificata procedura GENERIC_WLRISDNBRA_JPUB per estrarre IDRISORSA da BDS_1_CASEDATA_RICHIESTA WLR invece del CODICE di STS
  -- 06/07/2026  ISSUE 37585     - Rollback CS_950 (la parte STS sara gestita in seguito)
  -- 06/07/2026  ISSUE 37585     - MODIFICHE TIPOLINEA in GENERIC_WLRISDNBRA_JPUB ed eliminata la parte STS

  SUBTYPE tCONTEXT IS VARCHAR2(1);

  kATTIVE     CONSTANT tCONTEXT DEFAULT 'A';
  kCESSATE    CONSTANT tCONTEXT DEFAULT 'C';

  kREGOLATORIO  CONSTANT tCONTEXT DEFAULT 'R';
  kNGAVULA      CONSTANT tCONTEXT DEFAULT 'N';
  kXDSL         CONSTANT tCONTEXT DEFAULT 'X';

  PROCEDURE INFO (TEXT VARCHAR2) IS
    VTIMESTAMP VARCHAR2(30);
  BEGIN
    DBMS_OUTPUT.PUT_LINE('[' || TO_CHAR(SYSTIMESTAMP, 'DD/MM/RR HH24:MI:SS.FF') || '] ' || TEXT);
  END INFO;

  PROCEDURE LOG (TEXT VARCHAR2) IS
  BEGIN
    $IF $$CL_DEBUG $THEN
      INFO (TEXT);
    $END

    NULL;
  END LOG;



FUNCTION GET_TIPO_LN_DIRE (inBDSID VARCHAR2)
  RETURN VARCHAR2
  IS
    OUTCOME VARCHAR2(10);
  BEGIN

      SELECT case when count(1) > 0 then '53' else '51' end as ID
      INTO OUTCOME
        FROM APPUSER.BDS_1_CASEDATA_ORDINE ORD
        JOIN APPUSER.BDS_1_CASEDATA_DETTAGLIOORDINE dett ON  DETT.ORDINE_DETTAGLIOORDINE_BDSID = ORD.BDS_ID
        JOIN APPUSER.BDS_1_CASEDATA_ATTRIBTDTTGLRDN ATTR ON ATTR.DTTGLRDN_TTRBTDTTGLIRDIN_BDSID = DETT.BDS_ID
        WHERE dett.nomecomponente = 'ACCESSOWLR'
        AND ATTR.nomeattributo = 'DIREZIONALITA'
        and ATTR.valoreattributo in ('0','1')
        and ORD.bds_id=inBDSID;

    RETURN OUTCOME;
  EXCEPTION
    WHEN OTHERS THEN
      RETURN NULL;
  END GET_TIPO_LN_DIRE;



-- 04/05/2026 RU_1617 EVO - Procedura di estrazione WLR completa (tutti i WLR attivi + aggiuntivi + STS)
-- 20/05/2026 CS_950 BF - estratto IDRISORSA da BDS_1_CASEDATA_RICHIESTA WLR al posto diCODICE per STS
-- 07/07/2026 ISSUE 37585 gestito i TIPOLINEA e SUB DIR e RES
PROCEDURE GENERIC_WLRISDNBRA_JPUB(
                               inFILENAME     IN VARCHAR2,
                               inIDFILE       IN NUMBER)
  IS
    FROM_CLAUSE     VARCHAR2(10000);
    last_rec_seq    NUMBER;
    SQL_STATEMENT   VARCHAR2(20000);

    NOTF_COLS PKG_ESTRAZIONI_UTILITY.tSELECT_COLUMNS DEFAULT PKG_ESTRAZIONI_UTILITY.tSELECT_COLUMNS
    ( 'IDRISORSA',
      'TIPO_CONTR',
      'COD_CONTRATTO',
      'DES',
      'DRO',
      'IDRICHIESTAOLO',
      'CODIFICAOLOAGCOM',
      'TIPOLINEA',
      'SUB_TIPO_LINEA_RESIDENZIALE',
      'SUB_TIPO_LINEA_DIREZIONE',
      'IDRISORSA_PRINCIPALE'
       );
   NOTF_COLS_HEAD PKG_ESTRAZIONI_UTILITY.tSELECT_COLUMNS DEFAULT PKG_ESTRAZIONI_UTILITY.tSELECT_COLUMNS
    ( 'IDRISORSA',
      'TIPO_CONTR',
      'CODE_CONTR',
      'DES',
      'DRO',
      'IDORDINE',
      'CODIFICA_OLO_AGCOM',
      'TIPOLINEA',
      'SUB_TIPO_LINEA_RESIDENZIALE',
      'SUB_TIPO_LINEA_DIREZIONE',
      'IDRISORSA_PRINCIPALE'
    );

  BEGIN

    --1) Tabella Temporanea per WLR Primario (tutti i WLR attivi, senza filtri ISDN/BRA)
  PKG_ESTRAZIONI_UTILITY.DROP_TEMPORARY_TABLE('TMP_BONJPUB_FTWLR');

  LOG ('*** STEP1 - CREATING TABLE TMP_BONJPUB_FTWLR');

  SQL_STATEMENT := q'xCREATE TABLE APPUSER.TMP_BONJPUB_FTWLR NOLOGGING PARALLEL 6 AS
                   select distinct ORD.BDS_ID ORD_BDS_ID ,rich.IDRISORSA AS IDRISORSA, OFF.COD_OFFERTA_JPUB AS TIPO_CONTR,              CO.COD_CONTRATTO,TO_CHAR(ORD.DES,'DD/MM/YYYY') AS DES,TO_CHAR(rich.DRO,'DD/MM/YYYY') AS DRO
                         ,to_char(ORD.IDRICHIESTAOLO)||'-1' AS IDRICHIESTAOLO
                          ,ORD.CODIFICAOLOAGCOM
                        -- INIZIO ISSUE 37585
                        ,PKG_ESTRAZIONI.CODIFICA_CODICE_FATT_NEW(ORD.BDS_ID,'TIPOLINEA') AS TIPOLINEA
                        ,PKG_ESTRAZIONI.CODIFICA_CODICE_FATT_NEW(ORD.BDS_ID,'RES') AS SUB_TIPO_LINEA_RESIDENZIALE
                        ,PKG_ESTRAZIONI.CODIFICA_CODICE_FATT_NEW(ORD.BDS_ID,'DIR') AS SUB_TIPO_LINEA_DIREZIONE
                        -- FINE ISSUE 37585
                      FROM  APPUSER.BDS_1_CASEDATA_ORDINE ORD
                         JOIN APPUSER.BDS_1_CASEDATA_RICHIESTA rich ON ORD.IDRICHIESTAOLO = rich.IDRICHIESTAOLO
                         JOIN APPUSER.OFFERTA OFF ON rich.IDOFFERTA = OFF.ID_OFFERTA
                         JOIN APPUSER.BDS_1_CASEDATA_ASSET ASSET ON ASSET.IDRICHIESTAOLO = ORD.IDRICHIESTAOLO
                         JOIN APPUSER.CONTRATTO CO ON RICH.IDCONTRATTO = CO.ID_CONTRATTO
                         JOIN APPUSER.BDS_1_CASEDATA_DETTAGLIOORDINE DETT ON DETT.ORDINE_DETTAGLIOORDINE_BDSID = ORD.BDS_ID
                         WHERE  ORD.OFFERTA IN ('WLRLINEAATTIVA','WLRLINEANONATTIVA')
                         AND rich.LAVORAZIONE in ('ATTIVAZIONE','VARIAZIONE','MIGRAZIONE')
                         AND ASSET.STATOASSET in ('INLAVORAZIONE','ATTIVO')x';

  LOG('*** SQL_STATEMENT: ' || SQL_STATEMENT);

      EXECUTE IMMEDIATE SQL_STATEMENT;

   SQL_STATEMENT := q'xALTER TABLE APPUSER.TMP_BONJPUB_FTWLR NOPARALLELx';
      LOG('*** SQL_STATEMENT: ' || SQL_STATEMENT);

      EXECUTE IMMEDIATE SQL_STATEMENT;

      LOG('*** SQL_STATEMENT: STATISTICS ');
      DBMS_STATS.GATHER_TABLE_STATS (OWNNAME => 'APPUSER', TABNAME => 'TMP_BONJPUB_FTWLR', DEGREE => 6 );

       --2) Tabella Temporanea per WLR AGGIUNTIVI + WLR Primario + STS
  PKG_ESTRAZIONI_UTILITY.DROP_TEMPORARY_TABLE('TMP_SPOOBONJPUB_FTWLR');

  LOG ('*** STEP2 - CREATING TABLE TMP_SPOOBONJPUB_FTWLR');

  SQL_STATEMENT := q'xCREATE TABLE APPUSER.TMP_SPOOBONJPUB_FTWLR NOLOGGING PARALLEL 6 AS
                   select ORD_BDS_ID,IDRISORSA, TIPO_CONTR, COD_CONTRATTO, DES,DRO
                          ,IDRICHIESTAOLO
                          ,CODIFICAOLOAGCOM
                          ,TIPOLINEA
                          ,SUB_TIPO_LINEA_RESIDENZIALE
                          ,SUB_TIPO_LINEA_DIREZIONE
                          ,NULL AS IDRISORSA_PRINCIPALE
                        from APPUSER.TMP_BONJPUB_FTWLR
                      UNION
                   select ORD_BDS_ID, VALOREATTRIBUTO ,TIPO_CONTR,COD_CONTRATTO,DES,DRO, IDRICHIESTAOLO||'-'||ROWNUM AS IDRICHIESTAOLO,
                          CODIFICAOLOAGCOM,TIPOLINEA,SUB_TIPO_LINEA_RESIDENZIALE,SUB_TIPO_LINEA_DIREZIONE,IDRISORSA_PRINCIPALE
                       FROM (select FTWLR.ORD_BDS_ID,attrd.VALOREATTRIBUTO,FTWLR.TIPO_CONTR, FTWLR.COD_CONTRATTO, FTWLR.DES,FTWLR.DRO
                                  ,FTWLR.IDRICHIESTAOLO AS IDRICHIESTAOLO
                                  ,FTWLR.CODIFICAOLOAGCOM
                                  ,FTWLR.TIPOLINEA
                                  ,FTWLR.SUB_TIPO_LINEA_RESIDENZIALE
                                 ,FTWLR.SUB_TIPO_LINEA_DIREZIONE
                                 ,FTWLR.IDRISORSA AS IDRISORSA_PRINCIPALE
                                  from  APPUSER.TMP_BONJPUB_FTWLR FTWLR
                                  JOIN APPUSER.BDS_1_CASEDATA_DETTAGLIOORDINE dett ON DETT.ORDINE_DETTAGLIOORDINE_BDSID = FTWLR.ORD_BDS_ID
                                  JOIN APPUSER.BDS_1_CASEDATA_ATTRIBTDTTGLRDN attrd ON attrd.DTTGLRDN_TTRBTDTTGLIRDIN_BDSID = DETT.BDS_ID
                                   WHERE dett.BDS_ID = attrd.DTTGLRDN_TTRBTDTTGLIRDIN_BDSID
                                      and dett.NOMECOMPONENTE='AGGIUNTIVO' AND attrd.NOMEATTRIBUTO='NUMEROTELEFONICO'
                              UNION
                                select FTWLR.ORD_BDS_ID,attrd.VALOREATTRIBUTO,FTWLR.TIPO_CONTR, FTWLR.COD_CONTRATTO, FTWLR.DES,FTWLR.DRO
                                  ,FTWLR.IDRICHIESTAOLO AS IDRICHIESTAOLO
                                  ,FTWLR.CODIFICAOLOAGCOM
                                  ,FTWLR.TIPOLINEA
                                  ,FTWLR.SUB_TIPO_LINEA_RESIDENZIALE
                                 ,FTWLR.SUB_TIPO_LINEA_DIREZIONE
                                 ,FTWLR.IDRISORSA AS IDRISORSA_PRINCIPALE
                                  from  APPUSER.TMP_BONJPUB_FTWLR FTWLR
                                  JOIN APPUSER.BDS_1_CASEDATA_DETTAGLIOORDINE dett ON DETT.ORDINE_DETTAGLIOORDINE_BDSID = FTWLR.ORD_BDS_ID
                                  JOIN APPUSER.BDS_1_CASEDATA_ATTRIBTDTTGLRDN attrd ON attrd.DTTGLRDN_TTRBTDTTGLIRDIN_BDSID = DETT.BDS_ID
                                  JOIN APPUSER.BDS_1_CASEDATA_ATTRIBTDTTGLRDN attrd2 ON attrd2.DTTGLRDN_TTRBTDTTGLIRDIN_BDSID = DETT.BDS_ID and  attrd2.NOMEATTRIBUTO in ('STATOAGGIUNTIVO') and attrd2.VALOREATTRIBUTO='ATTIVO'
                                  WHERE dett.BDS_ID = attrd.DTTGLRDN_TTRBTDTTGLIRDIN_BDSID
                                        and dett.NOMECOMPONENTE = 'DTUAGGIUNTIVO' AND attrd.NOMEATTRIBUTO = 'TELAGGIUNTIVO') Tx';
/*
                              -- sar? inserta successivamente
                              UNION
                                -- STS attivi
                                -- CS_950
                                -- select FTWLR.ORD_BDS_ID,attrd.VALOREATTRIBUTO,FTWLR.TIPO_CONTR, FTWLR.COD_CONTRATTO, FTWLR.DES,FTWLR.DRO
                                select FTWLR.ORD_BDS_ID,FTWLR.IDRISORSA,FTWLR.TIPO_CONTR, FTWLR.COD_CONTRATTO, FTWLR.DES,FTWLR.DRO
                                  ,FTWLR.IDRICHIESTAOLO AS IDRICHIESTAOLO
                                  ,FTWLR.CODIFICAOLOAGCOM
                                  ,FTWLR.TIPOLINEA
                                  ,FTWLR.SUB_TIPO_LINEA_RESIDENZIALE
                                 ,FTWLR.SUB_TIPO_LINEA_DIREZIONE
                                 ,FTWLR.IDRISORSA AS IDRISORSA_PRINCIPALE
                                  from  APPUSER.TMP_BONJPUB_FTWLR FTWLR
                                  JOIN APPUSER.BDS_1_CASEDATA_DETTAGLIOORDINE dett ON DETT.ORDINE_DETTAGLIOORDINE_BDSID = FTWLR.ORD_BDS_ID
                                  JOIN APPUSER.BDS_1_CASEDATA_ATTRIBTDTTGLRDN attrd ON attrd.DTTGLRDN_TTRBTDTTGLIRDIN_BDSID = DETT.BDS_ID
                                  JOIN APPUSER.BDS_1_CASEDATA_ATTRIBTDTTGLRDN attrd2 ON attrd2.DTTGLRDN_TTRBTDTTGLIRDIN_BDSID = DETT.BDS_ID
                                  WHERE dett.NOMECOMPONENTE = 'STS'
                                    -- CS_950
                                    -- AND attrd.NOMEATTRIBUTO  = 'CODICE'
                                    AND attrd2.NOMEATTRIBUTO = 'STATO'
                                    AND attrd2.VALOREATTRIBUTO = 'ATTIVO'
*/

  LOG('*** SQL_STATEMENT: ' || SQL_STATEMENT);

      EXECUTE IMMEDIATE SQL_STATEMENT;

   SQL_STATEMENT := q'xALTER TABLE APPUSER.TMP_SPOOBONJPUB_FTWLR NOPARALLELx';
      LOG('*** SQL_STATEMENT: ' || SQL_STATEMENT);

      EXECUTE IMMEDIATE SQL_STATEMENT;

      LOG('*** SQL_STATEMENT: STATISTICS ');
      DBMS_STATS.GATHER_TABLE_STATS (OWNNAME => 'APPUSER', TABNAME => 'TMP_SPOOBONJPUB_FTWLR', DEGREE => 6 );

    FROM_CLAUSE := q'xFROM
                     APPUSER.TMP_SPOOBONJPUB_FTWLRx';

    PKG_ESTRAZIONI_UTILITY.SPOOL_QUERY (inIDFILE,
                                        inFILENAME,
                                        NOTF_COLS,
                                        FROM_CLAUSE,
                                        PKG_ESTRAZIONI_UTILITY.kCSV_SEPARATOR,
                                        HEADER_COLS => NOTF_COLS_HEAD);
     -- inserimento EOF
     SELECT MAX(sequenza) + 1 INTO last_rec_seq from appuser.estrazioni
      WHERE NOME_FILE = inFILENAME AND ID_FILE = inIDFILE;

    INSERT INTO APPUSER.ESTRAZIONI
                      (CREATED,
                       SEQUENZA,
                       NOME_FILE,
                       ID_FILE,
                       RIGA)
                    VALUES
                      (SYSTIMESTAMP,
                       last_rec_seq,
                       inFILENAME,
                       inIDFILE,
                       'EOF');
     COMMIT;
  END GENERIC_WLRISDNBRA_JPUB;


--C25M48
PROCEDURE ESTR_WLRISDNBRA_JPUB (ID_FILE            IN NUMBER)
  IS
    inFILENAME      VARCHAR2(100);
    VxDataFile      VARCHAR2(10);
    ID_SEQ          VARCHAR2(2);

  BEGIN
    INFO('*** STARTED PROCEDURE ESTR_WLRISDNBRA_JPUB **');
    INFO('ID_FILE='||ID_FILE);

    VxDataFile := TO_CHAR(SYSTIMESTAMP, 'DDMMYYYY');
    ID_SEQ     := LPAD(SEQ_ID_WLRISDNMULTINUMERO.NEXTVAL, 2, '0');

    inFILENAME := 'BONIFICA_WLR_ISDNMULTINUMERO_' ||VxDataFile||'_'||ID_SEQ||PKG_ESTRAZIONI_UTILITY.kEXT_CSV;

    PKG_ESTRAZIONI_UTILITY.INIT(ID_FILE, inFILENAME);

    GENERIC_WLRISDNBRA_JPUB(inFILENAME, ID_FILE);

    INFO('*** FINISHED PROCEDURE ESTR_WLRISDNBRA_JPUB **');
    PKG_ESTRAZIONI_UTILITY.ROUNDOFF(ID_FILE);
  EXCEPTION
    WHEN OTHERS THEN
      INFO ('*** [ESTR_WLRISDNBRA_JPUB] - FATAL ERROR: ' || SQLERRM);
      PKG_ESTRAZIONI_UTILITY.TRAP (ID_FILE, SQLERRM);
  END ESTR_WLRISDNBRA_JPUB;

--RU_1181:
PROCEDURE GENERIC_FWA_APPARATO_JPUB(
                               inFILENAME     IN VARCHAR2,
                               inIDFILE       IN NUMBER)
  IS
    FROM_CLAUSE     VARCHAR2(10000);
    last_rec_seq    NUMBER;
    SQL_STATEMENT   VARCHAR2(20000);

    NOTF_COLS PKG_ESTRAZIONI_UTILITY.tSELECT_COLUMNS DEFAULT PKG_ESTRAZIONI_UTILITY.tSELECT_COLUMNS
    ( 'ID_ORDINE_CRMWS',
      'IDRISORSA',
      'COD_CONTRATTO',
      'CODE_TIPO_CONTR',
      'DES',
      'DRO'
       );
   NOTF_COLS_HEAD PKG_ESTRAZIONI_UTILITY.tSELECT_COLUMNS DEFAULT PKG_ESTRAZIONI_UTILITY.tSELECT_COLUMNS
    ( 'ID_ORDINE_CRMWS',
      'ID_RISORSA',
      'CODE_CONTR',
      'CODE_TIPO_CONTR',
      'DATA_DES_ATTIVAZIONE',
      'DATA_DRO_CESSAZIONE'
    );


  BEGIN

    --1)  tabella
  PKG_ESTRAZIONI_UTILITY.DROP_TEMPORARY_TABLE('TMP_ESTR_JPUB_FWAAPPARATO');

  LOG ('*** STEP1 - CREATING TABLE TMP_ESTR_JPUB_FWAAPPARATO');

  SQL_STATEMENT := q'xCREATE TABLE APPUSER.TMP_ESTR_JPUB_FWAAPPARATO NOLOGGING PARALLEL 6 AS
                   select DISTINCT  ASSET.BDS_ID AS IDASSET, ASSET.IDRICHIESTAOLO||'-1' as ID_ORDINE_CRMWS , ASSET.IDRISORSA,CO.COD_CONTRATTO
                                   ,OFF.COD_OFFERTA_JPUB AS CODE_TIPO_CONTR,TO_CHAR(ORD.DES,'DD/MM/YYYY') DES,TO_CHAR(RIC.DRO,'DD/MM/YYYY') DRO
                        from BDS_1_CASEDATA_ASSET ASSET
                      join BDS_1_CASEDATA_DETTAGLIOASSET DETT  ON ASSET.BDS_ID=DETT.ASSET_DETTAGLIOASSET_BDSID
                      JOIN BDS_1_CASEDATA_ATTRIBTDTTGLSST ATT ON dett.BDS_ID=ATT.DTTGLSST_TTRBTIDTTGLISST_BDSID
                      JOIN CONTRATTO CO ON CO.ID_CONTRATTO=ASSET.IDCONTRATTO
                       JOIN  APPUSER.OFFERTA OFF ON ASSET.IDOFFERTA = OFF.ID_OFFERTA
                       JOIN APPUSER.BDS_1_CASEDATA_ORDINE ORD ON ASSET.IDPRIMOORDINE=ORD.IDRICHIESTAOLO
                       JOIN APPUSER.BDS_1_CASEDATA_RICHIESTA RIC ON ASSET.IDRICHIESTAOLO=RIC.IDRICHIESTAOLO
                      where 1=1
                      AND ASSET.STATOASSET='CESSATO'
                      AND ASSET.OFFERTA  ='FIXEDWIRELESSACCESS'
                      AND dett.nomecomponente='ACCESSOFWA'
                      AND ATT.NOMEATTRIBUTO =  'STATORESTITUZIONEPRODOTTI'
                      AND ATT.VALOREATTRIBUTO in ( 'NONRESTITUITO','RESTITUITOFUORITEMPO')
                      and not exists (select 1 from STG_NOW_JPUB_NORESO_MODEM_FL STG where STG.IDASSET=ASSET.BDS_ID)x';

  LOG('*** SQL_STATEMENT: ' || SQL_STATEMENT);
      EXECUTE IMMEDIATE SQL_STATEMENT;

   SQL_STATEMENT := q'xALTER TABLE APPUSER.TMP_ESTR_JPUB_FWAAPPARATO NOPARALLELx';
      LOG('*** SQL_STATEMENT: ' || SQL_STATEMENT);
      EXECUTE IMMEDIATE SQL_STATEMENT;

      LOG('*** SQL_STATEMENT: STATISTICS ');
      DBMS_STATS.GATHER_TABLE_STATS (OWNNAME => 'APPUSER', TABNAME => 'TMP_ESTR_JPUB_FWAAPPARATO', DEGREE => 6 );


       --2)  tabella Storico Estrazione
  LOG ('*** STEP1 - INSERT INTO TABLE STG_NOW_JPUB_NORESO_MODEM_FL');

 -- SQL_STATEMENT := q'xINSERT into APPUSER.STG_NOW_JPUB_NORESO_MODEM_FL SELECT IDASSET,$inIDFILE from APPUSER.TMP_ESTR_JPUB_FWAAPPARATOx';

   SQL_STATEMENT := q'xINSERT INTO APPUSER.STG_NOW_JPUB_NORESO_MODEM_FL (CODICE_ID_ORDINE, IDRISORSA, CODE_CONTR, TIPO_CONTR,DATA_DES_ATTIVAZIONE, DATA_DRO_CESSAZIONE,IDASSET,CONTENUTO_RECORD, ID_FILE_PROCSTO_OUT, ID_STATO_ELAB_STAG,NUM_RECORD)
                       SELECT ID_ORDINE_CRMWS,IDRISORSA,COD_CONTRATTO,CODE_TIPO_CONTR,TO_DATE(DES,'DD/MM/YYYY'),TO_DATE(DRO,'DD/MM/YYYY'),IDASSET,ID_ORDINE_CRMWS||'|'||IDRISORSA||'|'||COD_CONTRATTO||'|'||CODE_TIPO_CONTR||'|'||DES||'|'||DRO ,$inIDFILE,2,TO_NUMBER(ROWNUM) from APPUSER.TMP_ESTR_JPUB_FWAAPPARATOx';


   SQL_STATEMENT := REPLACE(SQL_STATEMENT, '$inIDFILE', inIDFILE);

  LOG('*** SQL_STATEMENT: ' || SQL_STATEMENT);
      EXECUTE IMMEDIATE SQL_STATEMENT;



    FROM_CLAUSE := q'xFROM
                     APPUSER.TMP_ESTR_JPUB_FWAAPPARATOx';


    PKG_ESTRAZIONI_UTILITY.SPOOL_QUERY (inIDFILE,
                                        inFILENAME,
                                        NOTF_COLS,
                                        FROM_CLAUSE,
                                        PKG_ESTRAZIONI_UTILITY.kPIPE_SEPARATOR,
                                        HEADER_COLS => NOTF_COLS_HEAD);
     -- inserimento EOF
     /*
     SELECT MAX(sequenza) + 1 INTO last_rec_seq from appuser.estrazioni
      WHERE NOME_FILE = inFILENAME AND ID_FILE = inIDFILE;

    INSERT INTO APPUSER.ESTRAZIONI
                      (CREATED,
                       SEQUENZA,
                       NOME_FILE,
                       ID_FILE,
                       RIGA)
                    VALUES
                      (SYSTIMESTAMP,
                       last_rec_seq,
                       inFILENAME,
                       inIDFILE,
                       'EOF');
     COMMIT;
     */

  END GENERIC_FWA_APPARATO_JPUB;

PROCEDURE ESTR_FWA_APPARATO_JPUB (ID_FILE            IN NUMBER)
  IS
    inFILENAME      VARCHAR2(100);
    VxDataFile      VARCHAR2(10);
    ID_SEQ          VARCHAR2(2) ;

  BEGIN
    INFO('*** STARTED PROCEDURE ESTR_FWA_APPARATO_JPUB **');

    INFO('ID_FILE='||ID_FILE);

    VxDataFile:=TO_CHAR(SYSTIMESTAMP, 'DDMMYYYY')  ;

--    ID_SEQ:= LPAD(SEQ_ID_FWAAPPARTAOJPUB.NEXTVAL,3,'0');


--Nomefile= NOW_JPUB_WILL_PENALI_DDMMYYYY.csv.
    inFILENAME := 'NOW_JPUB_WILL_PENALI_' ||VxDataFile||PKG_ESTRAZIONI_UTILITY.kEXT_CSV;

    PKG_ESTRAZIONI_UTILITY.INIT(ID_FILE, inFILENAME);

    GENERIC_FWA_APPARATO_JPUB(inFILENAME,
                                  ID_FILE);


    INFO('*** FINISHED PROCEDURE ESTR_FWA_APPARATO_JPUB **');
    PKG_ESTRAZIONI_UTILITY.ROUNDOFF(ID_FILE);
  EXCEPTION
    WHEN OTHERS THEN
      INFO ('*** [ESTR_FWA_APPARATO_JPUB] - FATAL ERROR: ' || SQLERRM);
      PKG_ESTRAZIONI_UTILITY.TRAP (ID_FILE, SQLERRM);
  END ESTR_FWA_APPARATO_JPUB;

  --RU_1294 - C26M30F01
PROCEDURE GENERIC_FWA_ASSET_JPUB(inFILENAME         IN VARCHAR2,
                  inIDFILE           IN NUMBER,
                  p_CODICE_OLO       IN VARCHAR2,
                  p_ANNO             IN VARCHAR2,
                  p_CODICEPROGETTO   IN VARCHAR2 DEFAULT NULL) IS

    FROM_CLAUSE       VARCHAR2(10000);
    last_rec_seq      NUMBER;
    SQL_STATEMENT     VARCHAR2(20000);
    lstrProfilo_fwa     VARCHAR2(20000);

    emp_refcur        SYS_REFCURSOR;
    v_query_string    VARCHAR2(2000);
    v_attributo      BDS_1_CASEDATA_ATTRIBTDTTGLSST%ROWTYPE;
    v_i         Number:=0;

    NOTF_COLS PKG_ESTRAZIONI_UTILITY.tSELECT_COLUMNS DEFAULT PKG_ESTRAZIONI_UTILITY.tSELECT_COLUMNS
        (-- 'IDRICHIESTAOLO', -- SM_10715
        'OAO',
        'ANNO_ELABORAZIONE',
        'CODICE_PROGETTO',
        'IDRISORSA',
        'DATA_DI_ATTIVAZIONE',
        'DATI_DI_CESSAZIONE',
        'PROFILO',
        'TIPOLOGIA_CONTRATTO',
        'ID_ORDINE_CRMWS',
        'CODE_CONTR',
        'CODE_TIPO_CONTR'
        );

    NOTF_COLS_HEAD PKG_ESTRAZIONI_UTILITY.tSELECT_COLUMNS DEFAULT PKG_ESTRAZIONI_UTILITY.tSELECT_COLUMNS
        (-- 'IDRICHIESTAOLO',  -- SM_10715
        'OAO',
        'ANNO_ELABORAZIONE',
        'CODICE_PROGETTO',
        'IDRISORSA',
        'DATA_DI_ATTIVAZIONE',
        'DATI_DI_CESSAZIONE',
        'PROFILO',
        'TIPOLOGIA_CONTRATTO',
        'ID_ORDINE_CRMWS',
        'CODE_CONTR',
        'CODE_TIPO_CONTR'
        );
  BEGIN
    -- 1)  tabella
    PKG_ESTRAZIONI_UTILITY.DROP_TEMPORARY_TABLE('TMP_GENERIC_FWA_ASSET_JPUB');

    LOG ('*** STEP1 - CREATING TABLE TMP_GENERIC_FWA_ASSET_JPUB');

    /* Commentato con SM_10894
           lstrProfilo_fwa:='SELECT p.cod_profilo_fwa'
            ||CHR(13)||' FROM TIPOLOG_CONTR_FWA TC'
            ||CHR(13)||' INNER JOIN ASS_TIPOLOG_CONTR_FWA_PROF atc on atc.id_tipolog_contr_fwa=tc.id_tipolog_contr_fwa and sysdate between atc.data_inizio_validita and atc.data_fine_validita'
            ||CHR(13)||' INNER JOIN PROFILO_FWA P ON p.id_profilo_fwa=atc.id_profilo_fwa'
            ||CHR(13)||' Where tc.descr_tipolog_contr_fwa=''CONTRATTO FWA PLUS'''
            ||CHR(13)||' and sysdate between tc.data_inizio_validita and tc.data_fine_validita';

    SQL_STATEMENT:='CREATE TABLE APPUSER.TMP_GENERIC_FWA_ASSET_JPUB NOLOGGING PARALLEL 6 AS'
            ||CHR(13)||' SELECT'
            ||CHR(13)||' a.IDRICHIESTAOLO,'
            ||CHR(13)||' a.CODIFICAOLOAGCOM  OAO,'                            -- descrizione breve dell?OLO (3 char)
            ||CHR(13)||' to_char(a.LASTUPDATE,''yyyy'') ANNO_ELABORAZIONE, '    -- valorizzato con il valore inviato dalla LU WS al BO di NOW
            ||CHR(13)||' o.CODICEPROGETTO  CODICE_PROGETTO,'                -- (opzionale), valorizzato con il valore inviato dalla LU WS al BO di NOW
            ||CHR(13)||' a.IDRISORSA,'                                        -- Identificativo della Risorsa
            -- ||CHR(13)||' o.DES  DATA_DI_ATTIVAZIONE,'                        -- Data DES riferita all?ordine di attivazione SM_10748
             ||CHR(13)||' to_char(o.des,''yyyymmdd'')  DATA_DI_ATTIVAZIONE,'       -- Data DES riferita all?ordine di attivazione SM_10748
            ||CHR(13)||' to_char(r.DRO,''yyyymmdd'')  DATI_DI_CESSAZIONE,'     -- Data DRO riferita all?ordine di cessazione SM_10748
            -- ||CHR(13)||' r.DRO  DATI_DI_CESSAZIONE,'                         -- Data DRO riferita all?ordine di cessazione SM_10748
            ||CHR(13)||' ATT.VALOREATTRIBUTO PROFILO,'                        -- dovrebbe essere sempre valorizzato a B;
            ||CHR(13)||' ''CONTRATTO FWA PLUS''    TIPOLOGIA_CONTRATTO,'        -- dovrebbe essere sempre valorizzato a ?CONTRATTO FWA PLUS?;
            ||CHR(13)||' A.IDRICHIESTAOLO||''-1'' as ID_ORDINE_CRMWS,'          -- Numero Ordine CRMWS dell?OdL di Cessazione
            ||CHR(13)||' co.COD_CONTRATTO   CODE_CONTR,'                     -- Codice Contratto dell?OLO
            ||CHR(13)||' o.COD_OFFERTA_JPUB  CODE_TIPO_CONTR,'
            ||CHR(13)||' dett.BDS_ID DTTGLSST_TTRBTIDTTGLISST_BDSID'
            ||CHR(13)||' FROM BDS_1_CASEDATA_ASSET A'
            ||CHR(13)||' JOIN BDS_1_CASEDATA_DETTAGLIOASSET DETT ON A.BDS_ID=DETT.ASSET_DETTAGLIOASSET_BDSID and DETT.NOMECOMPONENTE=''ACCESSOFWA'''
            ||CHR(13)||' JOIN BDS_1_CASEDATA_ATTRIBTDTTGLSST ATT ON dett.BDS_ID=ATT.DTTGLSST_TTRBTIDTTGLISST_BDSID AND '
            ||CHR(13)||'                     ATT.NOMEATTRIBUTO=''PROFILO'' AND'
            ||CHR(13)||'                     ATT.VALOREATTRIBUTO In ('||lstrProfilo_fwa||')'
            ||CHR(13)||' JOIN BDS_1_CASEDATA_ORDINE o ON o.idrichiestaolo=a.IDPRIMOORDINE';
    If p_CODICEPROGETTO is not null Then
      SQL_STATEMENT:=SQL_STATEMENT||CHR(13)||' and o.CODICEPROGETTO='||chr(39)||p_CODICEPROGETTO||chr(39);
    End If;

    SQL_STATEMENT:=SQL_STATEMENT
            ||CHR(13)||' JOIN APPUSER.BDS_1_CASEDATA_RICHIESTA r ON r.IDRICHIESTAOLO = a.IDRICHIESTAOLO'
            ||CHR(13)||' JOIN CONTRATTO co ON co.ID_CONTRATTO=A.IDCONTRATTO'
            ||CHR(13)||' JOIN OFFERTA O ON upper(NOME_OFFERTA_CATLG)= a.OFFERTA'  -- e valorizzare TIPO_CONTR con CODICE_OFFERTA_JPUB
            ||CHR(13)||' WHERE '
            ||CHR(13)||'   a.OFFERTA=''FIXEDWIRELESSACCESS'' and'
            ||CHR(13)||'   a.STATOASSET = ''CESSATO'' And'
            ||CHR(13)||'   a.CODIFICAOLOAGCOM = '||chr(39)||p_CODICE_OLO||chr(39)||' and'
            ||CHR(13)||'   to_char(a.LASTUPDATE,''yyyy'') = '||chr(39)||p_ANNO||chr(39)||' And'
            ||CHR(13)||'   not exists (select  1'
            ||CHR(13)||'       From BDS_1_CASEDATA_ATTRIBTDTTGLSST ATT1 '
            ||CHR(13)||'       Where dett.BDS_ID=ATT1.DTTGLSST_TTRBTIDTTGLISST_BDSID and ATT1.NOMEATTRIBUTO = ''CONTRIBUTOCESSAZIONEFWA'''
            ||CHR(13)||'       )';
            */

    lstrProfilo_fwa:='SELECT p.cod_profilo_fwa
                      FROM TIPOLOG_CONTR_FWA TC
                      INNER JOIN ASS_TIPOLOG_CONTR_FWA_PROF atc on atc.id_tipolog_contr_fwa=tc.id_tipolog_contr_fwa and sysdate between atc.data_inizio_validita and atc.data_fine_validita
                      INNER JOIN PROFILO_FWA P ON p.id_profilo_fwa=atc.id_profilo_fwa
                        Where tc.descr_tipolog_contr_fwa=''CONTRATTO FWA PLUS''
                        and sysdate between tc.data_inizio_validita and tc.data_fine_validita';

   --RU_1359 modificato ANNO_ELABORAZIONE e p_ANNO
    SQL_STATEMENT:='CREATE TABLE APPUSER.TMP_GENERIC_FWA_ASSET_JPUB NOLOGGING PARALLEL 6 AS
                         SELECT
                         a.IDRICHIESTAOLO,
                         a.CODIFICAOLOAGCOM  OAO,
                         to_char(r.DRO,''yyyy'') ANNO_ELABORAZIONE,
                         o.CODICEPROGETTO  CODICE_PROGETTO,
                         a.IDRISORSA,
                         to_char(o.des,''yyyymmdd'')  DATA_DI_ATTIVAZIONE,
                         to_char(r.DRO,''yyyymmdd'')  DATI_DI_CESSAZIONE,
                         ATT.VALOREATTRIBUTO PROFILO,
                         ''CONTRATTO FWA PLUS'' TIPOLOGIA_CONTRATTO,
                         A.IDRICHIESTAOLO||''-1'' ID_ORDINE_CRMWS,
                         co.COD_CONTRATTO   CODE_CONTR,
                         o.COD_OFFERTA_JPUB  CODE_TIPO_CONTR,
                         dett.BDS_ID DTTGLSST_TTRBTIDTTGLISST_BDSID
                         FROM BDS_1_CASEDATA_ASSET A
                         JOIN BDS_1_CASEDATA_DETTAGLIOASSET DETT ON A.BDS_ID=DETT.ASSET_DETTAGLIOASSET_BDSID and DETT.NOMECOMPONENTE=''ACCESSOFWA''
                         JOIN BDS_1_CASEDATA_ATTRIBTDTTGLSST ATT ON dett.BDS_ID=ATT.DTTGLSST_TTRBTIDTTGLISST_BDSID
                                                                     AND ATT.NOMEATTRIBUTO=''PROFILO'' AND ATT.VALOREATTRIBUTO In ('||lstrProfilo_fwa||')
                         JOIN BDS_1_CASEDATA_ORDINE o ON o.idrichiestaolo=a.IDPRIMOORDINE';
    If p_CODICEPROGETTO is not null Then
      SQL_STATEMENT:=SQL_STATEMENT||' and o.CODICEPROGETTO='''||p_CODICEPROGETTO||'''';
    End If;

    SQL_STATEMENT:=SQL_STATEMENT||' JOIN APPUSER.BDS_1_CASEDATA_RICHIESTA r ON r.IDRICHIESTAOLO = a.IDRICHIESTAOLO
            JOIN CONTRATTO co ON co.ID_CONTRATTO=A.IDCONTRATTO
            JOIN OFFERTA O ON upper(NOME_OFFERTA_CATLG)= a.OFFERTA
            WHERE
             a.OFFERTA=''FIXEDWIRELESSACCESS''
             and a.STATOASSET = ''CESSATO''
             And a.CODIFICAOLOAGCOM = '||chr(39)||p_CODICE_OLO||chr(39)||
             ' and to_char(r.DRO,''yyyy'') = '||chr(39)||p_ANNO||chr(39)||
              ' And not exists (select 1 From BDS_1_CASEDATA_ATTRIBTDTTGLSST ATT1 Where dett.BDS_ID=ATT1.DTTGLSST_TTRBTIDTTGLISST_BDSID
                                                                                         and ATT1.NOMEATTRIBUTO = ''CONTRIBUTOCESSAZIONEFWA'')';


    LOG('*** SQL_STATEMENT: ' || SQL_STATEMENT);
    EXECUTE IMMEDIATE SQL_STATEMENT;

    SQL_STATEMENT := q'xALTER TABLE APPUSER.TMP_GENERIC_FWA_ASSET_JPUB NOPARALLELx';
    LOG('*** SQL_STATEMENT: ' || SQL_STATEMENT);
    EXECUTE IMMEDIATE SQL_STATEMENT;

    LOG('*** SQL_STATEMENT: STATISTICS ');
    DBMS_STATS.GATHER_TABLE_STATS (OWNNAME => 'APPUSER', TABNAME => 'TMP_GENERIC_FWA_ASSET_JPUB', DEGREE => 6 );

    v_query_string := 'SELECT  max(DTYPE) DTYPE'
              ||' ,max(IDASSET) IDASSET'
              ||' ,''PKG_ESTRAZIONI_JPUB.ESTR_FWA_ASSET_JPUB'' OPERATORE'  -- SM_10715
              ||' ,MAX(IDDETTAGLIOASSET) IDDETTAGLIOASSET'
              ||' ,MAX(BDS_OWNER_ID) BDS_OWNER_ID'
              ||' ,DTTGLSST_TTRBTIDTTGLISST_BDSID'
              ||' ,COUNT(1)'
              ||' FROM BDS_1_CASEDATA_ATTRIBTDTTGLSST ATT '
              ||' WHERE EXISTS (SELECT 1 FROM APPUSER.TMP_GENERIC_FWA_ASSET_JPUB dett where dett.DTTGLSST_TTRBTIDTTGLISST_BDSID=ATT.DTTGLSST_TTRBTIDTTGLISST_BDSID)'
              ||' GROUP BY DTTGLSST_TTRBTIDTTGLISST_BDSID';

    LOG('*** SQL_STATEMENT: INSERT ATTRIBUTO CONTRIBUTOCESSAZIONEFWA');
    OPEN emp_refcur FOR v_query_string;

    LOOP
      v_attributo:=NULL;
      FETCH emp_refcur INTO v_attributo.DTYPE
                  ,v_attributo.IDASSET
                  ,v_attributo.OPERATORE
                  ,v_attributo.IDDETTAGLIOASSET
                  ,v_attributo.BDS_OWNER_ID
                  ,v_attributo.DTTGLSST_TTRBTIDTTGLISST_BDSID
                  ,v_attributo.DTTGLISST_TTRIBTIDTTGLISST_IDX;
      EXIT WHEN emp_refcur%NOTFOUND;

      v_attributo.BDS_ID      :=  S_BDS_ID.NEXTVAL;
      v_attributo.CREATED      :=  sysdate;
      v_attributo.LASTUPDATE    :=  sysdate;
      v_attributo.NOMEATTRIBUTO  :=  'CONTRIBUTOCESSAZIONEFWA';
      v_attributo.VALOREATTRIBUTO  :=  'SI';
      v_attributo.TIPOLOGIADATO  :=  'VARCHAR2';

      Insert into BDS_1_CASEDATA_ATTRIBTDTTGLSST (BDS_ID,DTYPE,IDASSET,CREATED,LASTUPDATE,OPERATORE
                            ,NOMEATTRIBUTO,VALOREATTRIBUTO,TIPOLOGIADATO
                            ,IDDETTAGLIOASSET,BDS_OWNER_ID,DTTGLSST_TTRBTIDTTGLISST_BDSID
                            ,DTTGLISST_TTRIBTIDTTGLISST_IDX)
      values(v_attributo.BDS_ID
          ,v_attributo.DTYPE
          ,v_attributo.IDASSET
          ,v_attributo.CREATED
          ,v_attributo.LASTUPDATE
          ,v_attributo.OPERATORE
          ,v_attributo.NOMEATTRIBUTO
          ,v_attributo.VALOREATTRIBUTO
          ,v_attributo.TIPOLOGIADATO
          ,v_attributo.IDDETTAGLIOASSET
          ,v_attributo.BDS_OWNER_ID
          ,v_attributo.DTTGLSST_TTRBTIDTTGLISST_BDSID
          ,v_attributo.DTTGLISST_TTRIBTIDTTGLISST_IDX
        );

      v_i:=v_i+1;

      If mod (v_i,5000)=0 then Commit; End If;

    END LOOP;
    CLOSE emp_refcur;

    COMMIT;

    LOG('*** SQL_STATEMENT: ESTRAZIONE');

    FROM_CLAUSE := q'xFROM APPUSER.TMP_GENERIC_FWA_ASSET_JPUBx';

    PKG_ESTRAZIONI_UTILITY.SPOOL_QUERY (inIDFILE,
                      inFILENAME,
                      NOTF_COLS,
                      FROM_CLAUSE,
                      PKG_ESTRAZIONI_UTILITY.kPIPE_SEPARATOR,
                      HEADER_COLS => NOTF_COLS_HEAD);
  Exception
    When others Then
      INFO ('*** [GENERIC_FWA_ASSET_JPUB] - FATAL ERROR: ' || SQLERRM);
      raise_application_error(-20001, 'GENERIC_FWA_ASSET_JPUB Fail.');
  END GENERIC_FWA_ASSET_JPUB;


  -- RU_1294
  PROCEDURE ESTR_FWA_ASSET_JPUB (ID_FILE        IN NUMBER,
                  p_CODICE_OLO     IN VARCHAR2,
                  p_ANNO           IN VARCHAR2,
                  p_CODICEPROGETTO IN VARCHAR2 DEFAULT NULL) IS
    inFILENAME      VARCHAR2(100);
  BEGIN
    INFO('*** STARTED PROCEDURE ESTR_FWA_ASSET_JPUB **');

    INFO('ID_FILE='||ID_FILE);

    inFILENAME := 'NOW_JPUB_WILL_CONTRIBUTO_CESSAZIONE_ANNO_' ||p_ANNO||'_'||SEQ_ID_CONTR_CESS_ANNO.nextval||PKG_ESTRAZIONI_UTILITY.kEXT_CSV;

    INFO('fILE NAME='||inFILENAME);

    PKG_ESTRAZIONI_UTILITY.INIT(ID_FILE, inFILENAME);

    GENERIC_FWA_ASSET_JPUB(inFILENAME,
                ID_FILE,
                p_CODICE_OLO,
                p_ANNO,
                p_CODICEPROGETTO);

    INFO('*** FINISHED PROCEDURE ESTR_FWA_ASSET_JPUB **');

    PKG_ESTRAZIONI_UTILITY.ROUNDOFF(ID_FILE);
  EXCEPTION
    WHEN OTHERS THEN
      INFO ('*** [ESTR_FWA_ASSET_JPUB] - FATAL ERROR: ' || SQLERRM);
      PKG_ESTRAZIONI_UTILITY.TRAP (ID_FILE, SQLERRM);
  END ESTR_FWA_ASSET_JPUB;

END PKG_ESTRAZIONI_JPUB;
/
