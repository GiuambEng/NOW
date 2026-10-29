CREATE OR REPLACE PACKAGE BODY APPUSER.PKG_ESTRAZIONI
-- CHRISTIAN LAO
-- 01/06/2016
-- CHANGES IN LOTTO2
-- ORD.DRO -> RICH.DRO
-- ORD.IDTIPOLOGIALAVORAZIONE -> ORD.TIPOLOGIALAVORAZIONE
-- ORD.IDTIPOLOGIASOTTOLAV -> ORD.TIPOLOGIASOTTOLAV
-- ORD.DATAACQUISIZIONE -> NULL
-- ORD.CODICEOLOAGCOM -> ORD.CODIFICAOLOAGCOM
--27/02/2019 SM_8368 Aggiunto IF per non inviare  le NP con rientro
--23/05/2019 RU_825  Per ESTRAI_INCONTRA  Modificata estrazione per PORTABILITA SUCCESSIVA
--21/10/2019 RU_825  Per ESTRAI_ACCESSI_GUI non considerare gli accessi su Workspace/Openspace  includere nella logica tutti i profili OLO (quindi anche i SUPER)
--21/02/2020 CS_576 Modificata select per ESTRAI_UTENTI_INATTIVI
--06/04/2020 RU_975 Introdotta CPS in ESTRAI_INCONTRA + NEW PROCEDURA VS RAES per CPS
--19/05/2020 SM_9239 - C6 2020 Modificata outLAST_UPDATE per estr CPS
--10/08/2020 RU_1037 Modificata ESTRAI_UTENTI_INATTIVI
--15/09/2020 SM_9481 SM_9482 Eliminato parametro GIORNI_INATT in  ESTRAI_UTENTI_INATTIVI
--20/10/2020 RU_1087  NOW_DISUTE separatore= ";"
--20/11/2020 SM_9629  Modificata ESTRAI_GENERIC_ASSET inserita UNION per estrazione per ESTRAI_INCONTRA
--09/02/2021 Task_XXX C01/C02 Modifica ACCESSOWLR per calcolo TIPO_LINEA
--10/02/2021 RU_1100 C02 Caricamento FILE INCONTRA  in tabella STAG_INCONTRA_OUTPUT_FILE
--09/03/2021 SM_9851 C02 Modifica insert per STAG_INCONTRA_OUTPUT_FILE
--11/03/2021 SM_9817 Modifica ACCESSOWLR per calcolo TIPO_LINEA
--25/03/2021 C03  RU_1143 Aggiunta nuovi campi per ULLD; VULL; WLR+STS; SHA - in pkg RA: ULL;SLU;NP;ORDINI_GIACENTI;BSATM;BSGBE;EASYIP
--28/04/2021 C04  RU_1153 modificato tracciato per ULLD/ SHA e degli ordini NGAVULA/XDSL/REG
--18/08/2022  RU_1322 - Modifica Flussi Sistina e Scarti Sistina
--20/10/2022  SM_10778 - Modifica VPI E VCI per Sistina Mensile
-- 02/11/2022 CS_856 - 2 Rilascio nuova ESTRAI_SISTINA_MENSILE per miglioramento performance
-- 17/11/2022 SM_10806 Mod campi Sistina MOD_FATTURAZIONE e TRASPORTO
-- 25/01/2022 SM_10899 (E) - EVO C01 2023 Modifica logica VelocitaAccessoOLO CAPAC_TRASM_ACCESSO
-- 26/01/2023 SM_10906 Modifica Flag Trasporto Urbano --Sistina
-- 09/02/2023 CS_871 Aggiunti ROWNUM < 2 in Estrazione Sistina
-- 14/03/2023 RU_1370 C03 2023  Modifica logiche di valorizzazione del campo Velocit? Accesso OLO
-- 06/07/2023 Task.44881 Miglioramento performance
-- 06/09/2023 RU_1436 C10 2023 Modifica dati sporchi e prestazionali in SISTINA MENSILE
-- 14/04/2024 RU_1469 C05 2024 Modifica Logica campi per INCONTRA E CPS
-- 16/05/2024 SM_11338 Elominazione di un carefuso dalla produzione del flusso NWIC.ZZNZCONS. ((NP, WLR e VULL):)
-- 06/07/2026 ISSUE 37585  inserita CODIFICA_CODICE_FATT_NEW per gestire il ritorno 53 per DIR G

IS
  TYPE tAMBITO IS TABLE OF OFFERTA.ID_FAMIG_OFFERTA%TYPE;

  TYPE T_SERVICE_MAP IS TABLE OF T_IDS_OFFERTA INDEX BY VARCHAR2(50);
  SERVICE_MAP T_SERVICE_MAP;

  APICE                   CONSTANT CHAR(1) DEFAULT q'x'x';

  kDATEFORMAT             CONSTANT VARCHAR2(10) DEFAULT 'YYYY-MM-DD';

  --GLOBALS FOR FILTER CRITERIA -> DETERMINE WHERE CONDITION
  ESTRAI_ATTIVI           CONSTANT VARCHAR2(30) DEFAULT 'ESTRAI_ATTIVI';
  ESTRAI_CESSATI          CONSTANT VARCHAR2(30) DEFAULT 'ESTRAI_CESSATI';
  ESTRAI_F1_TD            CONSTANT VARCHAR2(30) DEFAULT 'ESTRAI_F1_TD';
  ESTRAI_F2_TD            CONSTANT VARCHAR2(30) DEFAULT 'ESTRAI_F2_TD';
  ESTRAI_F1_TD_NISIDA     CONSTANT VARCHAR2(30) DEFAULT 'ESTRAI_F1_TD_NISIDA';
  ESTRAI_F2_TD_NISIDA     CONSTANT VARCHAR2(30) DEFAULT 'ESTRAI_F2_TD_NISIDA';
  ESTRAI_ATTIVI_RI        CONSTANT VARCHAR2(30) DEFAULT 'ESTRAI_ATTIVI_RI';
  ESTRAI_SISTINA_G        CONSTANT VARCHAR2(30) DEFAULT 'ESTRAI_SISTINA_G';
  ESTRAI_SISTINA_M        CONSTANT VARCHAR2(30) DEFAULT 'ESTRAI_SISTINA_M';
 ESTRAI_SISTINA_NOT_NULL    CONSTANT VARCHAR2(50) DEFAULT 'ESTRAI_SISTINA_NOT_NULL'; -- RU_371
 -- ESTRAI_SISTINA_NULL        CONSTANT VARCHAR2(50) DEFAULT 'ESTRAI_SISTINA_NOT_NULL'; -- RU_371
  ESTRAI_X_INCONTRA       CONSTANT VARCHAR2(30) DEFAULT 'ESTRAI_X_INCONTRA'; -- Luca Abbate, Lotto6, INCONTRA

  ESTRAI_X_CPS       CONSTANT VARCHAR2(30) DEFAULT 'ESTRAI_X_CPS'; --RU_975

  -- ESTRAI_NPG_X_INCONTRA   CONSTANT VARCHAR2(30) DEFAULT 'ESTRAI_NPG_X_INCONTRA'; -- Luca Abbate, Lotto 5, INCONTRA
  --MODALITA' TRASFERIMENTO

  kASIMMETRICO            CONSTANT OFFERTA.MODO_TRASFERIMENTO%TYPE DEFAULT q'x'ASIMMETRICO'x';
  kSIMMETRICO             CONSTANT OFFERTA.MODO_TRASFERIMENTO%TYPE DEFAULT q'x'SIMMETRICO'x';

  $IF NOT $$CL_RUNQUERY $THEN
  gRUNQUERY BOOLEAN DEFAULT FALSE;
  $ELSE
  gRUNQUERY BOOLEAN DEFAULT TRUE;
  $END

  FUNCTION TODAY(FORMAT_IN IN VARCHAR DEFAULT 'DDMMYYYY')
  RETURN VARCHAR2
  IS
  BEGIN
    RETURN TO_CHAR(SYSTIMESTAMP, FORMAT_IN);
  END;

  FUNCTION FORMAT_DATE(STRING_IN IN VARCHAR2,
                       OUT_FORMAT IN VARCHAR2)
  RETURN VARCHAR2
  DETERMINISTIC
  PARALLEL_ENABLE
  IS
    FORMATTED_DATE VARCHAR2(20);
  BEGIN
    FORMATTED_DATE := TO_CHAR(TO_DATE(STRING_IN, kDATEFORMAT), OUT_FORMAT);
    RETURN FORMATTED_DATE;
  END FORMAT_DATE;


  FUNCTION TECNOLOGIA_TIPO_PROT(ORD_BDS_ID          NUMBER,
                                MOD_TRASFERIMENTO   VARCHAR2,
                                inIDOFFERTA         NUMBER)
  RETURN VARCHAR2
  IS
    OUTCOME       VARCHAR2(1);
  BEGIN
    IF MOD_TRASFERIMENTO <> 'SIMMETRICO' THEN
      OUTCOME := 'A';
    ELSE
      <<ASIMMETRICO_BLOCK>>
      DECLARE
        ATTRIBUTE_VALUE   VARCHAR2(100);
        PROFILO           VARCHAR2(50);
      BEGIN
        PROFILO := TO_CHAR(CODIFICA_ATTRIBUTO_ORDINE(ORD_BDS_ID, 'PROFILOTECNICOLINEA'));

        IF PROFILO IS NOT NULL THEN
          SELECT TECNOLOGIA_OLO
          INTO ATTRIBUTE_VALUE
          FROM PROFILO_TCNC_LINEA
          WHERE PROFILO_TCNC_LINEA = PROFILO
            AND ID_OFFERTA = inIDOFFERTA;
        END IF;

        CASE
          WHEN ATTRIBUTE_VALUE IN ('SHDSL', 'SDH', 'SHDSL (DSLAM bonding fisico)') THEN
            OUTCOME := 'S';
          WHEN ATTRIBUTE_VALUE = 'SSHDSL' THEN
            OUTCOME := 'X';
          ELSE
            OUTCOME := NULL;
        END CASE;

        RETURN OUTCOME;
      EXCEPTION
        WHEN OTHERS THEN
          RETURN NULL;
      END ASIMMETRICO_BLOCK;
    END IF;

    RETURN OUTCOME;

  EXCEPTION
    WHEN OTHERS THEN
      RETURN NULL;
  END TECNOLOGIA_TIPO_PROT;

FUNCTION DECODE_TIPO_NISIDA_F2 --SM_4415 TUTTA LA FUNZIONE   MNP
(
  OFFERTA                IN BDS_1_CASEDATA_ORDINE.OFFERTA%TYPE,
  TIPOLOGIALAVORAZIONE   IN BDS_1_CASEDATA_ORDINE.OFFERTA%TYPE,
  TIPOLOGIALINEA         IN BDS_1_CASEDATA_ORDINE.OFFERTA%TYPE,
  STATORICHIESTANOW      IN BDS_1_CASEDATA_RICHIESTA.OFFERTA%TYPE,
  STATOASSET             IN BDS_1_CASEDATA_ASSET.STATOASSET%TYPE
)
RETURN VARCHAR2
IS
    RESULT_TIPO VARCHAR2(10);
BEGIN

/*
  Il campo ? valorizzato:
  In base allo stato del Servizio (BITSTREAM e EasyIP)
  I = per i record per i quali esiste un ordine di ATTIVAZIONE in stato acquisito ma non espletato (OK e KO)
  C: Per i record in consistenza in stato CESSATO
  A: Per i record in consistenza con ordini di attivazione o variazione (solo passaggio a LNF da POTS) in stato Scartato o Annullato
  F: Per gli ordini EasyIP in Consistenza che si trovano in stato Attivo,    in Variazione, in Cessazione, in Attivazione.
*/

    RESULT_TIPO := '';

    IF OFFERTA LIKE 'BITSTREAM%' THEN

      IF TIPOLOGIALAVORAZIONE = 'ATTIVAZIONE' AND STATORICHIESTANOW NOT IN ('ESPLETAMENTOTECNICO','ESPLETAMENTOTECNICOKO') THEN
         RESULT_TIPO := 'I';
      END IF;

      IF STATORICHIESTANOW = 'CESSATO' THEN
         RESULT_TIPO := 'C';
      END IF;

      IF TIPOLOGIALAVORAZIONE IN ('ATTIVAZIONE', 'VARIAZIONE') AND UPPER(TIPOLOGIALINEA) = 'LINEANONFONIA' AND STATORICHIESTANOW  IN ('SCARTATO','ANNULLATO') THEN
         RESULT_TIPO := 'A';
      END IF;

    END IF;

    IF OFFERTA LIKE 'EASYIP%' THEN
      IF STATOASSET = 'ATTIVO' AND TIPOLOGIALAVORAZIONE IN ('ATTIVAZIONE', 'CESSAZIONE','VARIAZIONE') THEN
         RESULT_TIPO := 'A';
      END IF;
    END IF;

   RETURN RESULT_TIPO;

EXCEPTION WHEN OTHERS THEN
      RETURN NULL;
END DECODE_TIPO_NISIDA_F2;





FUNCTION GET_FOUND_STATO_ESTRAZIONI (IDFILE_IN      IN NUMBER)
  RETURN NUMBER
  IS
  FOUND NUMBER;
  BEGIN
    SELECT COUNT(1)
    INTO FOUND
    FROM STATO_ESTRAZIONI SE
    WHERE SE.ID_FILE = IDFILE_IN;
    RETURN FOUND;
  END GET_FOUND_STATO_ESTRAZIONI;

  FUNCTION CAN_START(IDFILE_IN      IN NUMBER,
                     FILENAME       IN VARCHAR2 DEFAULT NULL)
  RETURN BOOLEAN
  IS
    FOUND             PLS_INTEGER := 0;
    ERRMSG            STATO_ESTRAZIONI.DESCR_ERRORE%TYPE;
    FLAG              STATO_ESTRAZIONI.STATUS%TYPE DEFAULT NULL;
    LIMIT_FOUND       NUMBER;
    SERVIZIO          VARCHAR2(30) DEFAULT 'ALTRO';
    FOUND_SOLO_WLR    NUMBER := 0;
  BEGIN

    FOUND := GET_FOUND_STATO_ESTRAZIONI(IDFILE_IN);

    CASE WHEN SUBSTR(FILENAME, 1, 11) IN (FILE_NAME_WLR_ATT, FILE_NAME_WLR_CESS)
      THEN
        SERVIZIO := 'WLR';
        SELECT COUNT(1)
        INTO FOUND_SOLO_WLR
        FROM STATO_ESTRAZIONI SE
        WHERE SE.ID_FILE = IDFILE_IN
          AND SE.STATUS = FLAG_SOLO_WLR;
        IF FOUND > 0 and FOUND_SOLO_WLR = 1 THEN
          LIMIT_FOUND := 1;
        ELSE
          LIMIT_FOUND := 0;
        END IF;
      ELSE
        LIMIT_FOUND := 0;
    END CASE;

    IF FOUND > LIMIT_FOUND THEN
      FLAG := FLAG_KO;
      ERRMSG := 'ESTRAZIONE IN CORSO O COMPLETATA PER IL GIORNO RICHIESTO';
    ELSE
      FLAG := FLAG_LOADING;
    END IF;

    IF SERVIZIO = 'ALTRO' OR (SERVIZIO = 'WLR' AND FOUND_SOLO_WLR = 0) THEN
      INSERT INTO STATO_ESTRAZIONI
          (CREATED,
           LAST_UPD,
           NOME_FILE,
           ID_FILE,
           STATUS,
           DESCR_ERRORE)
        VALUES
          (SYSTIMESTAMP,
           SYSTIMESTAMP,
           NVL(FILENAME, 'N/A'),
           IDFILE_IN,
           FLAG,
           ERRMSG);
          COMMIT;
    END IF;

    IF FOUND <= LIMIT_FOUND THEN -- nel caso di WLR e STS pu? essere OK 0 e 1
      RETURN TRUE;
    ELSE
      RETURN FALSE;
    END IF;

  END CAN_START;

  FUNCTION DISTRETTO_INCONTRA(VAL IN VARCHAR2)
  RETURN VARCHAR2
  DETERMINISTIC
  PARALLEL_ENABLE
  IS
    OUTCOME VARCHAR2(10) DEFAULT NULL;
  BEGIN
    IF SUBSTR(VAL, 2, 1) IN (2, 6) THEN
      OUTCOME := SUBSTR(VAL, 1, 2);
    ELSIF SUBSTR(VAL, 3, 1) IN (0, 1, 5, 9) THEN
      OUTCOME := SUBSTR(VAL, 1, 3);
    ELSE
      OUTCOME := SUBSTR(VAL, 1, 4);
    END IF;

    RETURN OUTCOME;
  EXCEPTION
    WHEN OTHERS THEN
      RETURN OUTCOME;
  END DISTRETTO_INCONTRA;

  FUNCTION DISTRETTO(VAL IN VARCHAR2)
  RETURN VARCHAR2
  DETERMINISTIC
  PARALLEL_ENABLE
  IS
    OUTCOME VARCHAR2(10) DEFAULT NULL;
  BEGIN
    IF NVL(LENGTH(TRIM(VAL)),0) > 0 THEN --Verifico che il valore non sia NULL prima di concatenare lo 0
      OUTCOME := '0' || TO_CHAR(TO_NUMBER(VAL));
    END IF;

    RETURN OUTCOME;
  EXCEPTION
    WHEN OTHERS THEN
      RETURN OUTCOME;
  END DISTRETTO;

  PROCEDURE UPDATE_STATUS(IDFILE_IN  IN NUMBER,
                           STATO      IN VARCHAR2 DEFAULT 'LOADING',
                           ERRMSG     IN VARCHAR2 DEFAULT NULL)
  IS
    FOUND PLS_INTEGER;
  BEGIN

    UPDATE STATO_ESTRAZIONI SE
    SET LAST_UPD = SYSTIMESTAMP,
        STATUS = STATO,
        DESCR_ERRORE = SUBSTR(ERRMSG, 1, 2000)
    WHERE SE.ID_FILE = IDFILE_IN;

    IF SQL%ROWCOUNT = 0 THEN
      RAISE_APPLICATION_ERROR(-20977, 'ID_FILE NOT FOUND IN STATO_ESTRAZIONI: ' || IDFILE_IN);
    END IF;

    COMMIT;
  END UPDATE_STATUS;

  PROCEDURE INFO (TEXT VARCHAR2)
  IS
    VTIMESTAMP VARCHAR2(30);
  BEGIN
    DBMS_OUTPUT.PUT_LINE('[' || TO_CHAR(SYSTIMESTAMP, 'DD/MM/RR HH24:MI:SS.FF') || '] ' || TEXT);
  END INFO;

  PROCEDURE LOG (TEXT VARCHAR2)
  IS
  BEGIN
    $IF $$CL_DEBUG $THEN
    INFO (TEXT);
    $END
    NULL;
  END LOG;

  -- UTILITIES
  PROCEDURE TRUNCATE_ESTRAZIONI (inIDFILE      IN NUMBER)
  IS
    kLIMIT NUMBER DEFAULT 100000;
  BEGIN
    IF inIDFILE IS NULL THEN
      RAISE_APPLICATION_ERROR(-20999, 'ID_FILE CANNOT BE EMPTY');
    END IF;

    UPDATE_STATUS(inIDFILE, FLAG_DELETING);

    LOOP
      DELETE
      FROM ESTRAZIONI
      WHERE ID_FILE = inIDFILE
        AND ROWNUM <= kLIMIT;

      EXIT WHEN SQL%ROWCOUNT = 0;
      COMMIT;
    END LOOP;

    UPDATE_STATUS(inIDFILE, FLAG_DELETED);

  EXCEPTION
    WHEN OTHERS THEN
      UPDATE_STATUS(inIDFILE, 'KO_DELETED', SQLCODE || SQLERRM);
  END TRUNCATE_ESTRAZIONI;

  FUNCTION FOOTER_ROW(SERVICE IN tSERVICE,
                      SEPARATOR IN VARCHAR2,
                      OPTIONAL_IN1 IN NUMBER DEFAULT 0,
                      OPTIONAL_IN2 IN VARCHAR2 DEFAULT NULL,
                      OPTIONAL_IN3 IN VARCHAR2 DEFAULT NULL)
  RETURN VARCHAR2
  DETERMINISTIC
  PARALLEL_ENABLE
  IS
    FOOTER_TO_STRING tROW;
  BEGIN
    CASE
      WHEN OPTIONAL_IN2 IN (ESTRAI_SISTINA_G, ESTRAI_SISTINA_M) THEN
        FOOTER_TO_STRING := 'N_REC' || SEPARATOR || OPTIONAL_IN1 || SEPARATOR;
      WHEN OPTIONAL_IN2 = ESTRAI_SISTINA_NOT_NULL THEN -- RU_371
        FOOTER_TO_STRING := '999999999999' || TODAY('DD/MM/YYYY') || RPAD(OPTIONAL_IN1,13,' ');--SM_4252
      WHEN SERVICE IN( SERVICE_INCONTRA,SERVICE_CPS_INCONTRA ,SERVICE_CPS_FRMSFRAUD) THEN --RU_975
        FOOTER_TO_STRING := '03' ||SEPARATOR|| 'NOW' ||SEPARATOR|| OPTIONAL_IN1 ||SEPARATOR;
      WHEN SERVICE = SERVICE_RAC THEN
        FOOTER_TO_STRING := '3' ||SEPARATOR|| TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS') ||SEPARATOR|| OPTIONAL_IN2 ||SEPARATOR|| OPTIONAL_IN3 ||SEPARATOR|| OPTIONAL_IN1;
      ELSE
        FOOTER_TO_STRING := NULL;
    END CASE;

    RETURN FOOTER_TO_STRING;
  END FOOTER_ROW;

  FUNCTION HEADER_ROW(SERVICE IN tSERVICE,
                      SEPARATOR     IN VARCHAR2,
                      OPTIONAL_IN1 IN VARCHAR2 DEFAULT NULL,
                      OPTIONAL_IN2 IN VARCHAR2 DEFAULT NULL)
  RETURN VARCHAR2
  DETERMINISTIC
  PARALLEL_ENABLE
  IS
    TYPE tFIELDS IS TABLE OF tROW;
    TYPE tTRACCIATI IS TABLE OF tFIELDS INDEX BY tSERVICE;

    TRACCIATI tTRACCIATI;

    NOW_RI_ULL_FIELDS tFIELDS := tFIELDS('ID_ORD_CRMWS',
                                      'DATA_DRO',
                                      'DATA_DES',
                                      'CODICE_PROGETTO',
                                      'TIPO_CONTR',
                                      'CODE_CLLI',
                                      'CODE_PREST_AGG',
                                      'ID_RIS',
                                      'ID_RIS_PRINC',
                                      'CODE_GEST_REC',
                                      'CODE_GEST_RET',
                                      'TIPO_FAMIGLIA',
                                      'OPZ_COMM',
                                      'TIPO_LINEA',
                                      'FLAG_NP',
                                      'SUB_TIPO_LINEA',
                                      'SUB_TIPO_LINEA_RESIDENZIALE',
                                      'SUB_TIPO_LINEA_DIREZIONE',
                                      'MOD_VENDITA_ACCESSO',
                                      'DATA_INIZIO_NOL',
                                      'CODE_ID_ULLCO',
                                      'CODE_DISTR',
                                      'FLAG_PERMUTA',
                                      'FLAG_MIGRAZIONE',
                                      'FLAG_QUALIFICAZIONE',
                                      'ID_RIS_OLD',
                                      'DATA_DEC',
                                      'DATA_RICHIESTA_CESSAZIONE',
                                      'DATA_CESSAZIONE',
                                      'DATA_INVIO_DELIVERY',
                                      'CODE_TIPO_INVIO',
                                      'TIPO_ORDINE',
                                      'CAUSALE_TIPO_ORDINE',
                                      'STATO_ORDINE',
                                      'DATA_INVIO_BILLING',
                                      'ESITO_ACQUISIZONE_BILLING');

    NOW_RI_SLU_FIELDS tFIELDS := tFIELDS ('ID_ORD_CRMWS',
                                          'DATA_DRO',
                                          'DATA_DES',
                                          'CODICE_PROGETTO',
                                          'TIPO_CONTR',
                                          'CODE_CLLI',
                                          'CODE_PREST_AGG',
                                          'ID_RIS',
                                          'ID_RIS_PRINC',
                                          'CODE_GEST_REC',
                                          'TIPO_FAMIGLIA',
                                          'OPZ_COMM',
                                          'TIPO_LINEA',
                                          'FLAG_NP',
                                          'SUB_TIPO_LINEA',
                                          'SUB_TIPO_LINEA_RESIDENZIALE',
                                          'SUB_TIPO_LINEA_DIREZIONE',
                                          'MOD_VENDITA_ACCESSO',
                                          'DATA_INIZIO_NOL',
                                          'CODE_ID_SLUCO          ',
                                          'CODE_DISTR',
                                          'FLAG_PERMUTA',
                                          'FLAG_MIGRAZIONE',
                                          'FLAG_QUALIFICAZIONE',
                                          'ID_RIS_OLD',
                                          'DATA_DEC',
                                          'DATA_RICHIESTA_CESSAZIONE',
                                          'DATA_CESSAZIONE',
                                          'DATA_INVIO_DELIVERY',
                                          'DATA_INVIO_BI');

    NOW_RI_ATM_FIELDS tFIELDS := tFIELDS ('ID_RISORSA',
                                          'OLO',
                                          'VELOCITA',
                                          'TIPO_LINEA',
                                          'MOD_FAT',
                                          'TIPO_CONTR',
                                          'CODE_CONTR',
                                          'TIPO_FAMIGLIA',
                                          'DATA_DRO',
                                          'DATA_DES',
                                          'DATA_DEC',
                                          'DATA_VAR',
                                          'DATA_CESSAZIONE',
                                          'TIPO_ORDINE',
                                          'CAUSALE_ORDINE',
                                          'FLAG_SPLITTER',
                                          'FLAG_MODEM',
                                          'ID_ORDINE_CRM',
                                          'ID_CORRELAZIONE',
                                          'ORDER_ID',
                                          'DATA_RICHIESTA_CESSAZIONE',
                                          'DATA_INVIO_DELIVERY',
                                          'ESITO_ACQUISIZIONE_BILLING',
                                          'STATO_ORDINE',
                                          'DATA_INVIO_BILLING');

    NOW_RI_GBE_FIELDS tFIELDS := tFIELDS ('ID_RISORSA',
                                          'OLO',
                                          'VELOCITA',
                                          'TIPO_LINEA',
                                          'MOD_FAT',
                                          'TIPO_CONTR',
                                          'CODE_CONTR',
                                          'TIPO_FAMIGLIA',
                                          'DATA_DRO',
                                          'DATA_DES',
                                          'DATA_DEC',
                                          'DATA_VAR',
                                          'DATA_CESSAZIONE',
                                          'TIPO_ORDINE',
                                          'CAUSALE_ORDINE',
                                          'FLAG_SPLITTER',
                                          'FLAG_MODEM',
                                          'ID_ORDINE_CRM',
                                          'CODE_AREA',
                                          'CODE_MACRO_AREA',
                                          'ID_CORRELAZIONE',
                                          'ORDER_ID',
                                          'DATA_RICHIESTA_CESSAZIONE',
                                          'DATA_INVIO_DELIVERY',
                                          'ESITO_ACQUISIZIONE_BILLING',
                                          'STATO_ORDINE',
                                          'DATA_INVIO_BILLING');

    NOW_RI_EASYIP_FIELDS tFIELDS := tFIELDS ('ID_RISORSA',
                                              'OLO',
                                              'TIPO_CONTR',
                                              'CODE_CONTR',
                                              'TIPO_LINEA',
                                              'OPZ_CONTRATTUALE',
                                              'TIPO_FAMIGLIA',
                                              'MOD_FAT',
                                              'TIPO_TRASP',
                                              'MOD_FAT_TRASP',
                                              'DATA_DRO',
                                              'DATA_DES',
                                              'DATA_DEC',
                                              'DATA_VAR',
                                              'DATA_CESSAZIONE',
                                              'TIPO_ORDINE',
                                              'CAUSALE_ORDINE',
                                              'CODE_AREA',
                                              'SUBNET_EASYIP',
                                              'FLAG_SPLITTER',
                                              'ID_ORDINE_CRM',
                                              'ID_CORRELAZIONE',
                                              'ORDER_ID',
                                              'DATA_RICHIESTA_CESSAZIONE',
                                              'DATA_INVIO_DELIVERY',
                                              'Opzione_Commerciale',
                                              'ESITO_ACQUISIZIONE_BILLING',
                                              'STATO_ORDINE',
                                              'DATA_INVIO_BILLING');

    NOW_RI_NGAVULA_FIELDS tFIELDS := tFIELDS ('ID_RISORSA',
                                            'OLO',
                                            'TIPO_LINEA',
                                            'MOD_FAT',
                                            'TIPO_CONTR',
                                            'CODE_CONTR',
                                            'TIPO_FAMIGLIA',
                                            'MOD_ACCESSO',
                                            'TECNOLOGIA',
                                            'CODE_CLLI',
                                            'PROFILO_ACCESSO',
                                            'PCR_UP',
                                            'PCR_DOWN',
                                            'TIPO',
                                            'MOD_TAG',
                                            'UTENZA_RIF',
                                            'TIPO_MODULAZ',
                                            'TIPO_VALID',
                                            'CODE_AREA',
                                            'CODE_MACRO_AREA',
                                            'MOD_FAT',
                                            'ID_CORRELAZIONE',
                                            'ORDER_ID',
                                            'ID_ORDINE_CRM',
                                            'DATA_DRO',
                                            'DATA_DES',
                                            'DATA_DEC',
                                            'DATA_CESSAZIONE',
                                            'DATA_RICHIESTA_CESSAZIONE',
                                            'DATA_INVIO_DELIVERY',
                                            'ESITO_ACQUISIZONE_BILLING',
                                            'TIPO_ORDINE',
                                            'CAUSALE_ORDINE',
                                            'STATO_ORDINE',
                                            'ID_RISORSA_TI',
                                            'ID_RISORSA_LOTTO',
                                            'DATA_INVIO_BILLING');

    ULISSE_TD_F1_FIELDS tFIELDS := tFIELDS ('Id OLO Alf',
                                            'Id OLO Num',
                                            'Descrizione Codice OLO',
                                            'Codice Tipo Prestazione',
                                            'Codice Tipo Offerta',
                                            'Flag_Billing',
                                            'Tipo Offerta Commerciale',
                                            'Tipo Servizio OM',
                                            'Protocollo UF',
                                            'Flag Offerta Lotto',
                                            'Codice Lotto/VP',
                                            'Codifica VPI Lotto/VP lato OLO',
                                            'Codifica Area Raccolta lato OLO',
                                            'Descrizione Area Raccolta',
                                            'Flag_Trasporto',
                                            'TGU UF',
                                            'TD UF',
                                            'TD OLO',
                                            'Codice XDSL',
                                            'Stato dell''utenza',
                                            'Codice Comune',
                                            'Data espletamento',
                                            'Classe di servizio',
                                            'Profilo VBR',
                                            'DLCI UF',
                                            'VCI UF',
                                            'VPI UF',
                                            'MCR_DOWN',
                                            'MCR_UP',
                                            'PCR_DOWN',
                                            'PCR_UP',
                                            'SCR_DOWN',
                                            'SCR_UP',
                                            'CODE_STATO_PS_ULL_OFFERTA',
                                            'CODE_STATO_PS_ULL_LINEA',
                                            'CODE_STATO_PS_ULL_LOTTO',
                                            'DESC_ID_XDSL',
                                            'CODICE_CLLI',
                                            'CODICE_PROGETTO',
                                            'CODE_VPI_VCI',
                                            'VALO_VPI_OLO',
                                            'VALO_VCI_OLO',
                                            'CODE_DLCI',
                                            'VALO_CAPAC_TRASM_MBITS',
                                            'TIPO_SERVIZIO',
                                            'FLAG_TRAFFICO',
                                            'UF_PREFISSO',
                                            NULL);

  REGIA0_GIACENZE_FIELDS tFIELDS := tFIELDS ('ROOT_ORDER_ITEM',
                                      'OLO_RECIPIENT',
                                      'OLO_DONATING_1',
                                      'OLO_DONATING_2',
                                      'ROW_ID_S_ORDER',
                                      'ID_RISORSA',
                                      'ORDER_NUM',
                                      'NUMERAZIONE_PRIMARIA',
                                      'NP_DELIBERA_35',
                                      'CODICE_ORDINE_TI',
                                      'CODICE_ORDINE_OLO',
                                      'CODICE_PROGETTO',
                                      'CODE_PIATTAFORMA',
                                      'PRODOTTO',
                                      'TIPO_DN',
                                      'TIPO LINEA',
                                      'FLAG_AGGIUNTIVI_NP',
                                      'QUANTITA_LINEE',
                                      'CODE_CAUSALE_TI',
                                      'DESCRIZIONE_CAUSALE_TI',
                                      'CODE_CAUSALE_OLO',
                                      'DESCRIZIONE_CAUSALE_OLO',
                                      'CAUSALE_ORDINE',
                                      'TIPO_CAUSALE_ORDINE',
                                      'RIENTRO_IN_TI',
                                      'GIORNI_DAL_ARRIVO',
                                      'GIORNI_DAL_CAMBIO_STATO',
                                      'DATA_ACQUISIZIONE_ORDINE',
                                      'DATA_DRO',
                                      'DATA_DAC_OLO',
                                      'DATA_DAC_RIM',
                                      'NUMERO_DI_RIMODULAZIONI',
                                      'DATA_ACCETTAZIONE_ORDINE',
                                      'PRESENZA_DI_NP',
                                      'CODICE_OL_RETAIL',
                                      'NOME',
                                      'COGNOME_RAG_SOC',
                                      'CF_PIVA',
                                      'NUMERAZIONE_VOIP',
                                      'ROUTING_NUMBER',
                                      'CODICE_SEDE_GAT',
                                      'SCENARIO_LAVORAZIONE',
                                      'NOME_FILE_INPUT_OLO',
                                      'NPD_FLAG',
                                      'ID_OL',
                                      'ID_PACCHETTO',
                                      'STATO_OLO',
                                      'STATO_TECNICO',
                                      'ID_CRM',
                                      --'DATA_A_TGU_001', Cristiano x S6
                                      --'DATA_R_TGU_001',
                                      --'STATO_TGU_001_A',
                                      --'STATO_TGU_001_R',
                                      --'ESITO_ANDATA_TGU_001',
                                      --'ESITO_RITORNO_TGU_001',
                                      --'ESITO_KO_TGU_001',
                                      --'DATA_A_TGU_003',
                                      --'DATA_R_TGU_003',
                                      --'STATO_TGU_003_A',
                                      --'STATO_TGU_003_R',
                                      --'ESITO_ANDATA_TGU_003',
                                      --'ESITO_RITORNO_TGU_003',
                                      --'ESITO_KO_TGU_003',
                                      --'DATA_INVIO_TGU_004',
                                      --'DATA_R_TGU_004',
                                      --'STATO_TGU_004_A',
                                      --'STATO_TGU_004_R',
                                      --'ESITO_A_TGU_004',
                                      --'ESITO_R_TGU_004',
                                      --'ESITO_KO_TGU_004',
                                      --'DATA_A_TGU_010',
                                      --'DATA_R_TGU_010',
                                      --'ESITO_ANDATA_TGU_010',
                                      --'ESITO_RITORNO_TGU_010',
                                      --'STATO_TGU_010_A',
                                      --'STATO_TGU_010_R',
                                      --'ESITO_KO_TGU_010',
                                      'DATA_INVIO_SCF_001',
                                      'DATA_RITORNO_SCF_001',
                                      'DATA_INVIO_SCF_003',
                                      'DATA_RITORNO_SCF_003',
                                      'DATA_INVIO_SCF_002',
                                      'DATA_RITORNO_SCF_002',
                                      'DATA_INVIO_SCF_007',
                                      'DATA_RITORNO_SCF_007',
                                      'DATA_INVIO_SCF_O_013',
                                      'DATA_INVIO_SCF_O_008',
                                      'DATA_INVIO_SCF_010',
                                      'DATA_RITORNO_SCF_010',
                                      'DATA_INVIO_SCF_011',
                                      'DATA_RITORNO_SCF_011',
                                      'DATA_INVIO_SCF_009',
                                      'DATA_RITORNO_SCF_009',
                                      --'DATA_RITORNO_SOC_010_NP', Cristiano x S6
                                      --'DATA_RITORNO_SOC_005',
                                      --'DATA_RITORNO_SOC_006',
                                      --'DATA_RITORNO_SOC_007_008',
                                      --'DATA_RITORNO_SOC_005_WLRLNA',
                                      --'DATA_RITORNO_SOC_006_WLRLNA',
                                      --'DATA_RITORNO_SOC_007_08_WLRLNA',
                                      --'DATA_RITORNO_SOC_010_WLRLNA',
                                      --'DATA_RITORNO_SOC_005_NP',
                                      --'DATA_RITORNO_SOC_I_006_NP',
                                      --'DATA_RITORNO_SOC_I_007_008_NP',
                                      'DATA_R_DISP_MOI',
                                      'DATA_R_PRESA_APP',
                                      'HUB_Data Inizio SOSPENSIONE',
                                      'DATA_R__SOSP',
                                      'DATA_R_TENT_DI_CHM',
                                      'DATA_R_ACCODAMENTO',
                                      'DATA_R_ANN_RETE',
                                      'DATA_R_RIMODULAZIONE_DPNR',
                                      'DATA_R_OP_SPE_EPA',
                                      'DATA_R_OP_SPE_OPA',
                                      'DATA_RITORNO_EMISSIONE',
                                      'DATA_R_IN_CARICO_DELIVERY',
                                      'DATA_R_DISP_A_MOS',
                                      'DATA_INVIO_EFD',
                                      'DATA_RITORNO_EFD',
                                      'DATA_ELAB_LAV_MAN');

    REGIA0_KO_FIELD tFIELDS := tFIELDS('CODICE_ORDINE_OLO',
                                      'CODICE_OLO',
                                      'TIPO_ORDINE',
                                      'CAUSALE',
                                      'TIPO_SERVIZIO',
                                      'CARATTERISTICA',
                                      'IDRISORSA',
                                      'UTENZA_PRIMARIA',
                                      'DIRECTORY_NUMBER',
                                      'STATO',
                                      'CODICE_CAUSALE',
                                      'DESCRIZIONE_CAUSALE',
                                      'CODICE_CAUSALE_OLO',
                                      'DESCRIZIONE_CAUSALE_OLO',
                                      'DATA_RICEZIONE_ORDINE',
                                      'DATA_ATTESA_CONSEGNA_OLO',
                                      'DATA_ULTIMA_MODIFICA_ORDINE',
                                      'DATA_V_FATT_TEC',
                                      'DATA_V_FORM_CONTR',
                                      'SCENARIO',
                                      'AMBITO');

-- ANDREA GARAVINI
-- 30/08/2016
-- LOTTO4

    ORD_ESPL_FIELD tFIELDS := tFIELDS('Codice Ordine Olo',
                                      'Olo',
                                      'Codice Ordine TI',
                                      'Tipo Notifica',
                                      'Esito Espletamento',
                                      'Nome File Notifica',
                                      '');

--/ ANDREA GARAVINI

  BEGIN
    TRACCIATI(SERVICE_ULL_RI)     := NOW_RI_ULL_FIELDS;
    TRACCIATI(SERVICE_ULLD_RI)    := NOW_RI_ULL_FIELDS;
    TRACCIATI(SERVICE_SLU_RI)     := NOW_RI_SLU_FIELDS;
    TRACCIATI(SERVICE_ATM_RI)     := NOW_RI_ATM_FIELDS;
    TRACCIATI(SERVICE_GBE_RI)     := NOW_RI_GBE_FIELDS;
    TRACCIATI(SERVICE_EASYIP_RI)  := NOW_RI_EASYIP_FIELDS;
    TRACCIATI(SERVICE_VULA_RI)    := NOW_RI_NGAVULA_FIELDS;
    TRACCIATI(ULISSE_TD_F1)       := ULISSE_TD_F1_FIELDS;
    TRACCIATI(REGIA0_GIACENZE)    := REGIA0_GIACENZE_FIELDS;
    TRACCIATI(REGIA0_KO)          := REGIA0_KO_FIELD;
    TRACCIATI(F1_TD_INNOV)        := ULISSE_TD_F1_FIELDS;
    TRACCIATI(F1_TD_INNOV_NISIDA) := ULISSE_TD_F1_FIELDS;

-- ANDREA GARAVINI
-- 30/08/2016
-- LOTTO4

    TRACCIATI(ORD_ESPL)          := ORD_ESPL_FIELD;

--/ ANDREA GARAVINI

    DECLARE
      HEADERS tFIELDS;
      HEADERS_TO_STRING tROW;
      FIRST_RECORD BOOLEAN DEFAULT TRUE;
    BEGIN
      <<SERVIZI>>
      CASE
        WHEN OPTIONAL_IN1 = ESTRAI_SISTINA_G THEN
          HEADERS_TO_STRING := 'NOW GIORNALIERO ATM' ||SEPARATOR|| TO_CHAR(SYSDATE, 'YYYYMMDD HH24:MI:SS'); --TODAY('YYYYMMDD'); SM_4214
        WHEN OPTIONAL_IN1 = ESTRAI_SISTINA_M THEN
          HEADERS_TO_STRING := 'NOW MENSILE ATM' ||SEPARATOR|| TO_CHAR(SYSDATE, 'YYYYMMDD HH24:MI:SS'); -- SM_4214
        WHEN SERVICE in (SERVICE_INCONTRA,SERVICE_CPS_INCONTRA ,SERVICE_CPS_FRMSFRAUD) THEN --RU_975
          HEADERS_TO_STRING := '01' ||SEPARATOR|| 'NOW' ||SEPARATOR|| TODAY('DD/MM/YYYY')|| SEPARATOR;
        WHEN SERVICE = SERVICE_SISTINA_VULL_NOT_NULL THEN  --RU_371
             HEADERS_TO_STRING := '000000000000' || TODAY('DD/MM/YYYY') || '             ';
        WHEN SERVICE = SERVICE_RAC THEN
          HEADERS_TO_STRING := '1' ||SEPARATOR|| TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS') ||SEPARATOR|| OPTIONAL_IN1 ||SEPARATOR|| OPTIONAL_IN2;
      ELSE
        HEADERS := TRACCIATI(SERVICE);

        FOR I IN HEADERS.FIRST..HEADERS.LAST LOOP
          IF FIRST_RECORD THEN
            HEADERS_TO_STRING := HEADERS(I);
          ELSE
            HEADERS_TO_STRING := HEADERS_TO_STRING || SEPARATOR || HEADERS(I);
          END IF;

          FIRST_RECORD := FALSE;
        END LOOP;
      END CASE SERVIZI;

      RETURN HEADERS_TO_STRING;
    EXCEPTION
      WHEN NO_DATA_FOUND THEN
        RETURN NULL;
    END;

  END HEADER_ROW;

  FUNCTION TIPOLINEA(ORDINE_BDS_ID        IN NUMBER,
                    inCODICEOFFERTAJPUB   IN OFFERTA.COD_OFFERTA_JPUB%TYPE,
                    inIDAMBITO            IN NUMBER)
  RETURN VARCHAR2
  RESULT_CACHE RELIES_ON(TRASCODFC_ESTERNA)
  IS
    OUTCOME           VARCHAR2(20);
    ATTRIBUTE_VALUE   VARCHAR2(100);
    inATTRIBUTE_NAME  VARCHAR2(100);
    inAMBITO          VARCHAR2(1);
  BEGIN

    LOG('    CHECKING ATTRIBUTE ' || inATTRIBUTE_NAME || '  USING COD_JPUB ' || inCODICEOFFERTAJPUB);

    CASE
      WHEN inIDAMBITO = FAMIGLIA_REGOLATORIO THEN
        inATTRIBUTE_NAME := 'DESTINAZIONEUSO';
        inAMBITO         := 'R';
      WHEN inIDAMBITO IN (FAMIGLIA_EASYIP, FAMIGLIA_BITSTREAM, FAMIGLIA_VULA, FAMIGLIA_NGA) THEN
        inATTRIBUTE_NAME := 'TIPOLINEA';
        inAMBITO         := 'X';
    END CASE;

    ATTRIBUTE_VALUE := CODIFICA_ATTRIBUTO_ORDINE(ORDINE_BDS_ID, inATTRIBUTE_NAME);

    LOG ('     ATTRIBUTE_VALUE: ' || ATTRIBUTE_VALUE);

    SELECT TE.VALORE_TRASCODFCTO
      INTO OUTCOME
    FROM TRASCODFC_ESTERNA TE
    WHERE TE.AMBITO = inAMBITO
      AND TE.NOME_ATTR_VALORE = inATTRIBUTE_NAME
      AND TE.TAG = 'TIPO_LINEA'
      AND TE.ID_SISTEMA = 3
      AND TE.VALORE_DA_TRASCODFCRE = ATTRIBUTE_VALUE
      AND TE.COD_OFFERTA_JPUB = inCODICEOFFERTAJPUB;

      RETURN OUTCOME;
  EXCEPTION
    WHEN OTHERS THEN
      LOG('ERROR IN MODULE [TIPOLINEA]: ' || SQLERRM);
      RETURN OUTCOME;
  END TIPOLINEA;

  FUNCTION ID_EVENTO_NOW(ID_RICHIESTA_IN IN BDS_1_CASEDATA_RICHIESTA.IDRICHIESTAOLO%TYPE)
  RETURN NUMBER
  RESULT_CACHE RELIES_ON(EVENTO_ORDN_NOW_WHLS)
  IS
    IDEVENTO EVENTO_ORDN_NOW_WHLS.ID_EVENTO_ORDN_NOW_WHLS%TYPE;
  BEGIN
    SELECT ID_EVENTO_ORDN_NOW_WHLS
    INTO IDEVENTO
    FROM EVENTO_ORDN_NOW_WHLS
    WHERE ID_RICH_OLO = ID_RICHIESTA_IN
    ORDER BY TIMSTP_INSMTO_EVENTO DESC
    FETCH FIRST 1 ROW ONLY;

    RETURN IDEVENTO;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RETURN NULL;
  END ID_EVENTO_NOW;

  FUNCTION DATA_INVIO_BILLING(inIDRISORSA IN BDS_1_CASEDATA_ASSET.IDRISORSA%TYPE)
  RETURN VARCHAR2
  RESULT_CACHE RELIES_ON(EVENTO_JPUB, TIPOLG_STATO_EVENTO_JPUB)
  IS
    RESULT_DATE VARCHAR2(10);
  BEGIN
    SELECT SET_DATE(TIMSTP_INSMTO_EVENTO)
    INTO RESULT_DATE
    FROM EVENTO_JPUB EJ
      JOIN TIPOLG_STATO_EVENTO_JPUB TIP ON EJ.IDTPLG_STATO_EVENTO_JPUB = TIP.IDTPLG_STATO_EVENTO_JPUB AND TIP.DESCR_STATO_EVENTO_JPUB = 'INVIATO'
    WHERE EJ.ID_RISORSA = inIDRISORSA
    ORDER BY TIMSTP_INSMTO_EVENTO DESC
    FETCH FIRST ROW ONLY;

    RETURN RESULT_DATE;

  EXCEPTION
    WHEN OTHERS THEN
      RETURN NULL;
  END DATA_INVIO_BILLING;

  FUNCTION DATA_INVIO_RICHIESTA (IDRICHIESTAOLO IN EVENTO_DTU.ID_RICH_OLO%TYPE,
                                 IDEVENTO       IN EVENTO_DTU.ID_EVENTO_ORDN_NOW_WHLS%TYPE,
                                 STATO_DTU      IN TIPOLG_STATO_EVENTO_DTU.DESCR_STATO_EVENTO_DTU%TYPE)
  RETURN VARCHAR2
  RESULT_CACHE RELIES_ON(EVENTO_DTU, TIPOLG_STATO_EVENTO_DTU)
  IS
    RESULT_DATE VARCHAR2(10);
  BEGIN

    SELECT SET_DATE(DATA_INVIO_RICH)
    INTO RESULT_DATE
    FROM EVENTO_DTU EV
      JOIN TIPOLG_STATO_EVENTO_DTU TPLG ON TPLG.IDTPLG_STATO_EVENTO_DTU = EV.IDTPLG_STATO_EVENTO_DTU
    WHERE EV.ID_RICH_OLO = IDRICHIESTAOLO
      AND EV.ID_EVENTO_ORDN_NOW_WHLS = IDEVENTO
      AND TPLG.DESCR_STATO_EVENTO_DTU = STATO_DTU;

    RETURN RESULT_DATE;

  EXCEPTION
    WHEN OTHERS THEN
      RETURN NULL;
  END DATA_INVIO_RICHIESTA;

  FUNCTION FLAG_TRAFFICO(TRASPORTO            IN VARCHAR2,
                         ID_PAGAMENTO_ACCESSO IN OFFERTA.IDTPLG_PAGAMENTO_ACCS%TYPE)
  RETURN NUMBER
  DETERMINISTIC
  PARALLEL_ENABLE
  IS
    CALCULATEDVALUE NUMBER;
  BEGIN
    IF TRASPORTO IS NULL THEN
      CALCULATEDVALUE := 0;
    ELSE
      IF ID_PAGAMENTO_ACCESSO = 1 THEN
        CALCULATEDVALUE := 2;
      ELSIF ID_PAGAMENTO_ACCESSO IN (2, 3) THEN
        CALCULATEDVALUE := 1;
      ELSE
        CALCULATEDVALUE := 3;
      END IF;
    END IF;
    RETURN CALCULATEDVALUE;
  END;
-- SM_2746 INIZIO

-- SOSTITUIRE CON QUESTA - CHRISTIAN
  FUNCTION CODE_AREA_RACC_DETT(DETT_BDS_ID IN BDS_1_CASEDATA_DETTAGLIOASSET.BDS_ID%TYPE,
                               COLUMN_NAME IN VARCHAR2)
  RETURN VARCHAR2
  IS
    CODE_VP BDS_1_CASEDATA_ATTRIBTDTTGLSST.VALOREATTRIBUTO%TYPE;
    CODE_TD BDS_1_CASEDATA_ATTRIBTDTTGLSST.VALOREATTRIBUTO%TYPE;
    SQL_STATEMENT VARCHAR2(200);
    VP_VALUE VARCHAR2 (300);
    KIT_VALUE VARCHAR2 (300);
  BEGIN
  CASE PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT_BDS_ID, 'TIPOBANDACONSEGNA')
  WHEN 'DEDICATA' THEN
    BEGIN
      CODE_TD := PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT_BDS_ID, 'CODICETD');
      IF CODE_TD IS NULL THEN
        RAISE NO_DATA_FOUND;
      END IF;

      IF COLUMN_NAME = 'COD_KIT' THEN
        RETURN CODE_TD;
      END IF;

      SQL_STATEMENT := 'SELECT ' || COLUMN_NAME || ' FROM ANAG_KIT VP WHERE VP.COD_KIT = ' || DBMS_ASSERT.ENQUOTE_LITERAL(CODE_TD);
      EXECUTE IMMEDIATE SQL_STATEMENT INTO KIT_VALUE; --USING CODE_VP;
      RETURN KIT_VALUE;
    EXCEPTION
     WHEN NO_DATA_FOUND THEN RETURN NULL;
    END;
  WHEN 'CONDIVISA' THEN
    BEGIN
      CODE_VP := PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT_BDS_ID, 'CODICEVP');
      IF CODE_VP IS NULL THEN
        RAISE NO_DATA_FOUND;
      END IF;
      SQL_STATEMENT := 'SELECT ' || COLUMN_NAME || ' FROM ANAG_VP VP WHERE VP.COD_VP = ' || DBMS_ASSERT.ENQUOTE_LITERAL(CODE_VP);
      EXECUTE IMMEDIATE SQL_STATEMENT INTO VP_VALUE; --USING CODE_VP;
      RETURN VP_VALUE;
    EXCEPTION
     WHEN NO_DATA_FOUND THEN RETURN NULL;
    END;
  ELSE RETURN NULL;
   END CASE;
  END CODE_AREA_RACC_DETT;

--Modifica PRESTAZIONALE
FUNCTION CODE_AREA_RACC_DETT_SC (DETT_BDS_ID IN BDS_1_CASEDATA_DETTAGLIOASSET.BDS_ID%TYPE,
                               COLUMN_NAME IN VARCHAR2)
  RETURN VARCHAR2
  IS
    CODE_VP BDS_1_CASEDATA_ATTRIBTDTTGLSST.VALOREATTRIBUTO%TYPE;
    CODE_TD BDS_1_CASEDATA_ATTRIBTDTTGLSST.VALOREATTRIBUTO%TYPE;
    VX_TIPOBANDACONSEGNA BDS_1_CASEDATA_ATTRIBTDTTGLSST.VALOREATTRIBUTO%TYPE;

    SQL_STATEMENT VARCHAR2(200);
    VP_VALUE VARCHAR2 (300);
    KIT_VALUE VARCHAR2 (300);
  BEGIN
--  CASE PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT_BDS_ID, 'TIPOBANDACONSEGNA')

           BEGIN --PRESTAZIONALE
            SELECT  VALOREATTRIBUTO INTO VX_TIPOBANDACONSEGNA
           FROM BDS_1_CASEDATA_ATTRIBTDTTGLSST ATT
           JOIN BDS_1_CASEDATA_DETTAGLIOASSET DETT ON ATT.DTTGLSST_TTRBTIDTTGLISST_BDSID = DETT.BDS_ID
           WHERE DETT.BDS_ID = DETT_BDS_ID
           AND ATT.NOMEATTRIBUTO = 'TIPOBANDACONSEGNA'
          FETCH FIRST 1 ROWS ONLY;
      EXCEPTION
            WHEN OTHERS THEN
            VX_TIPOBANDACONSEGNA := NULL;
        END;

  CASE VX_TIPOBANDACONSEGNA
  WHEN 'DEDICATA' THEN
    BEGIN
      --CODE_TD := PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT_BDS_ID, 'CODICETD');
      BEGIN --PRESTAZIONALE
            SELECT  VALOREATTRIBUTO INTO CODE_TD
           FROM BDS_1_CASEDATA_ATTRIBTDTTGLSST ATT
           JOIN BDS_1_CASEDATA_DETTAGLIOASSET DETT ON ATT.DTTGLSST_TTRBTIDTTGLISST_BDSID = DETT.BDS_ID
           WHERE DETT.BDS_ID = DETT_BDS_ID
           AND ATT.NOMEATTRIBUTO = 'CODICETD'
          FETCH FIRST 1 ROWS ONLY;
      EXCEPTION
            WHEN OTHERS THEN
            CODE_TD := NULL;
        END;

      IF CODE_TD IS NULL THEN
        RAISE NO_DATA_FOUND;
      END IF;

      IF COLUMN_NAME = 'COD_KIT' THEN
        RETURN CODE_TD;
      END IF;

      SQL_STATEMENT := 'SELECT ' || COLUMN_NAME || ' FROM ANAG_KIT VP WHERE VP.COD_KIT = ' || DBMS_ASSERT.ENQUOTE_LITERAL(CODE_TD);
      EXECUTE IMMEDIATE SQL_STATEMENT INTO KIT_VALUE; --USING CODE_VP;
      RETURN KIT_VALUE;
    EXCEPTION
     WHEN NO_DATA_FOUND THEN RETURN NULL;
    END;

  WHEN 'CONDIVISA' THEN
    BEGIN
      --CODE_VP := PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT_BDS_ID, 'CODICEVP');
        BEGIN --PRESTAZIONALE
            SELECT  VALOREATTRIBUTO INTO CODE_VP
           FROM BDS_1_CASEDATA_ATTRIBTDTTGLSST ATT
           JOIN BDS_1_CASEDATA_DETTAGLIOASSET DETT ON ATT.DTTGLSST_TTRBTIDTTGLISST_BDSID = DETT.BDS_ID
           WHERE DETT.BDS_ID = DETT_BDS_ID
           AND ATT.NOMEATTRIBUTO = 'CODICEVP'
          FETCH FIRST 1 ROWS ONLY;
      EXCEPTION
            WHEN OTHERS THEN
            CODE_VP := NULL;
        END;

      IF CODE_VP IS NULL THEN
        RAISE NO_DATA_FOUND;
      END IF;
      SQL_STATEMENT := 'SELECT ' || COLUMN_NAME || ' FROM ANAG_VP VP WHERE VP.COD_VP = ' || DBMS_ASSERT.ENQUOTE_LITERAL(CODE_VP);
      EXECUTE IMMEDIATE SQL_STATEMENT INTO VP_VALUE; --USING CODE_VP;
      RETURN VP_VALUE;
    EXCEPTION
     WHEN NO_DATA_FOUND THEN RETURN NULL;
    END;
  ELSE RETURN NULL;
   END CASE;
  END CODE_AREA_RACC_DETT_SC;

-- DA RIVEDERE - CHRISTIAN
FUNCTION CODE_AREA_RACC(ASSET_ID IN BDS_1_CASEDATA_ASSET.BDS_ID%TYPE,
                      COLUMN_NAME IN VARCHAR2)
  RETURN VARCHAR2
  IS
    CODE_VP BDS_1_CASEDATA_ATTRIBTDTTGLSST.VALOREATTRIBUTO%TYPE;
    CODE_TD BDS_1_CASEDATA_ATTRIBTDTTGLSST.VALOREATTRIBUTO%TYPE;
    SQL_STATEMENT VARCHAR2(200);
    VP_VALUE VARCHAR2 (300);
    KIT_VALUE VARCHAR2 (300);
  BEGIN
  CASE CODIFICA_ATTRIBUTO_ASSET (ASSET_ID, 'TIPOBANDACONSEGNA')
  WHEN 'DEDICATA' THEN
    BEGIN
      CODE_TD := DBMS_ASSERT.ENQUOTE_LITERAL(CODIFICA_ATTRIBUTO_ASSET(ASSET_ID, 'CODICETD','ATMVC'));
      IF CODE_TD IS NULL THEN
        RAISE NO_DATA_FOUND;
      END IF;
      SQL_STATEMENT := 'SELECT ' || COLUMN_NAME || ' FROM ANAG_KIT VP WHERE VP.COD_KIT = to_char('|| CODE_TD ||')';
      EXECUTE IMMEDIATE SQL_STATEMENT INTO KIT_VALUE; --USING CODE_VP;
      RETURN KIT_VALUE;
    EXCEPTION
     WHEN NO_DATA_FOUND THEN RETURN NULL;
    END;
  WHEN 'CONDIVISA' THEN
    BEGIN
      CODE_VP := DBMS_ASSERT.ENQUOTE_LITERAL(CODIFICA_ATTRIBUTO_ASSET(ASSET_ID, 'CODICEVP','ATMVC'));
      IF CODE_VP IS NULL THEN
        RAISE NO_DATA_FOUND;
      END IF;
      SQL_STATEMENT := 'SELECT ' || COLUMN_NAME || ' FROM ANAG_VP VP WHERE VP.COD_VP = to_char('|| CODE_VP || ')';
      EXECUTE IMMEDIATE SQL_STATEMENT INTO VP_VALUE; --USING CODE_VP;
      RETURN VP_VALUE;
    EXCEPTION
     WHEN NO_DATA_FOUND THEN RETURN NULL;
    END;
  else return ' ';
   END CASE;
  END;

/*
FUNCTION CODE_AREA_RACC(ASSET_ID IN BDS_1_CASEDATA_ASSET.BDS_ID%TYPE,
                      COLUMN_NAME IN VARCHAR2)
  RETURN VARCHAR2
  IS
    CODE_VP BDS_1_CASEDATA_ATTRIBTDTTGLSST.VALOREATTRIBUTO%TYPE;
    CODE_TD BDS_1_CASEDATA_ATTRIBTDTTGLSST.VALOREATTRIBUTO%TYPE;
    SQL_STATEMENT VARCHAR2(200);
    VP_VALUE VARCHAR2 (300);
    KIT_VALUE VARCHAR2 (300);
  BEGIN
  CASE CODIFICA_ATTRIBUTO_ASSET (ASSET_ID, 'TIPOBANDACONSEGNA')
  WHEN 'DEDICATA' THEN
    BEGIN
      CODE_TD := CODIFICA_ATTRIBUTO_ASSET(ASSET_ID, 'CODICETD','ATMVC');
      IF CODE_TD IS NULL THEN
        RAISE NO_DATA_FOUND;
      END IF;
      SQL_STATEMENT := 'SELECT ' || COLUMN_NAME || ' FROM ANAG_KIT VP WHERE VP.COD_KIT ='|| CODE_TD;
      EXECUTE IMMEDIATE SQL_STATEMENT INTO KIT_VALUE; --USING CODE_VP;
      RETURN KIT_VALUE;
    EXCEPTION
     WHEN NO_DATA_FOUND THEN RETURN NULL;
    END;
  WHEN 'CONDIVISA' THEN
    BEGIN
      CODE_VP := CODIFICA_ATTRIBUTO_ASSET(ASSET_ID, 'CODICEVP','ATMVC');
      IF CODE_VP IS NULL THEN
        RAISE NO_DATA_FOUND;
      END IF;
      SQL_STATEMENT := 'SELECT ' || COLUMN_NAME || ' FROM ANAG_VP VP WHERE VP.COD_VP :='|| CODE_VP;
      EXECUTE IMMEDIATE SQL_STATEMENT INTO VP_VALUE; --USING CODE_VP;
      RETURN VP_VALUE;
    EXCEPTION
     WHEN NO_DATA_FOUND THEN RETURN NULL;
    END;
   END CASE;
  END;
*/



-- SM_2746 FINE
  FUNCTION MODALITA_VENDITA (BDS_COMPONENT_ID IN BDS_1_CASEDATA_DETTAGLIOASSET.BDS_ID%TYPE,
                             ID_OFFERTA IN NUMBER)
  RETURN NUMBER
  IS
    MOD_VENDITA DECIMAL;
  BEGIN
    CASE
      WHEN ID_OFFERTA IN (8, 9, 10,39,40) THEN            -- BS ATM
        CASE ASSET_ATTR_BY_COMPONENT_ID (BDS_COMPONENT_ID, 'TIPOBANDACONSEGNA')
          WHEN 'CONDIVISA' THEN MOD_VENDITA := 4;--SM_2746
          WHEN 'DEDICATA' THEN MOD_VENDITA := 5;--SM_2746
          ELSE MOD_VENDITA := NULL;
        END CASE;
      WHEN ID_OFFERTA = 7 THEN   -- BS GBE
        MOD_VENDITA := 6;
      WHEN ID_OFFERTA IN (11, 12, 13, 14) THEN      -- EASYIP
        MOD_VENDITA := 5;
      ELSE
        MOD_VENDITA := NULL;
    END CASE;
    RETURN MOD_VENDITA;
  END;

  FUNCTION DENORMALIZZA_RISORSA(inRISORSA IN VARCHAR2)
                               RETURN VARCHAR2 IS
    V_PREFISSO VARCHAR2(50);
    V_RISORSA VARCHAR2(50);
  BEGIN

      IF inRISORSA IS NULL THEN
         RETURN inRISORSA;
      END IF;

      V_PREFISSO := SUBSTR(inRISORSA,0,3);
      V_RISORSA := SUBSTR(inRISORSA,4);

      IF SUBSTR(V_PREFISSO,0,1) = 0 AND SUBSTR(V_PREFISSO,2,1) = 0 THEN
        V_RISORSA := SUBSTR(V_PREFISSO,2)||V_RISORSA;
      ELSIF SUBSTR(V_PREFISSO,0,1) <> 0 THEN
        V_RISORSA := '0'||V_PREFISSO||V_RISORSA;
      ELSE
        V_RISORSA := V_PREFISSO||V_RISORSA;
      END IF;

      RETURN V_RISORSA;

  END DENORMALIZZA_RISORSA;

  FUNCTION VLAN_VALUE(ASSET_ID IN BDS_1_CASEDATA_ASSET.BDS_ID%TYPE,
                      COLUMN_NAME IN VARCHAR2)
  RETURN VARCHAR2
  IS
    CODE_VLAN BDS_1_CASEDATA_ATTRIBTDTTGLSST.VALOREATTRIBUTO%TYPE;
    SQL_STATEMENT VARCHAR2(200);
    VLAN_VALUE VARCHAR2 (300);
  BEGIN
    SQL_STATEMENT := 'SELECT ' || COLUMN_NAME || ' FROM ANAG_VLAN VLAN WHERE VLAN.COD_VLAN = :CODVLAN';
    CODE_VLAN := CODIFICA_ATTRIBUTO_ASSET(ASSET_ID, 'SVLANCODE');

    IF CODE_VLAN IS NULL THEN
      RAISE NO_DATA_FOUND;
    END IF;

    EXECUTE IMMEDIATE SQL_STATEMENT INTO VLAN_VALUE USING CODE_VLAN;
    RETURN VLAN_VALUE;

  EXCEPTION
    WHEN NO_DATA_FOUND THEN RETURN NULL;
  END;
-- S7 INIZIO
  FUNCTION VLAN_VALUE_ORD(BDS_ID IN BDS_1_CASEDATA_ORDINE.BDS_ID%TYPE,
                      COLUMN_NAME IN VARCHAR2)
  RETURN VARCHAR2
  IS
    CODE_VLAN BDS_1_CASEDATA_ATTRIBTDTTGLRDN.VALOREATTRIBUTO%TYPE;
    SQL_STATEMENT VARCHAR2(200);
    VLAN_VALUE_ORD VARCHAR2 (300);
  BEGIN
    SQL_STATEMENT := 'SELECT ' || COLUMN_NAME || ' FROM ANAG_VLAN VLAN WHERE VLAN.COD_VLAN = :CODE_VLAN';
    IF COLUMN_NAME = 'TIPO_COS_NO_GBE' THEN
      SQL_STATEMENT := 'SELECT TIPO_COS FROM ANAG_VLAN VLAN WHERE VLAN.COD_VLAN = :CODE_VLAN';
    END IF;

    IF COLUMN_NAME = 'TIPO_COS' THEN
        CODE_VLAN := CODIFICA_ATTRIBUTO_ORDINE(BDS_ID, 'SVLANCODE', 'GBEVC');  --SM_4156 (17S07B)
    ELSE
      CODE_VLAN := CODIFICA_ATTRIBUTO_ORDINE(BDS_ID, 'SVLANCODE');
    END IF;

    IF CODE_VLAN IS NULL THEN
      RAISE NO_DATA_FOUND;
    END IF;

    EXECUTE IMMEDIATE SQL_STATEMENT INTO VLAN_VALUE_ORD USING CODE_VLAN;

    IF VLAN_VALUE_ORD IN ('BMC','BMD') THEN
       RETURN '1';
    END IF;

    RETURN VLAN_VALUE_ORD;

  EXCEPTION
    WHEN NO_DATA_FOUND THEN RETURN NULL;
  END;
 -- S7 FINE

FUNCTION VP_VALUE(ASSET_ID IN BDS_1_CASEDATA_ASSET.BDS_ID%TYPE,
                      COLUMN_NAME IN VARCHAR2)
  RETURN VARCHAR2
  IS
    CODE_VP BDS_1_CASEDATA_ATTRIBTDTTGLSST.VALOREATTRIBUTO%TYPE;
    SQL_STATEMENT VARCHAR2(200);
    VP_VALUE VARCHAR2 (300);
  BEGIN
   CODE_VP := CODIFICA_ATTRIBUTO_ASSET(ASSET_ID, 'CODICEVP','ATMVC');
   IF CODE_VP IS NULL THEN
      RAISE NO_DATA_FOUND;
   END IF;
  -- SQL_STATEMENT := 'SELECT ' || COLUMN_NAME || ' FROM ANAG_VP VP WHERE VP.COD_VP :='|| CODE_VP;
   SQL_STATEMENT := 'SELECT ' || COLUMN_NAME || ' FROM ANAG_VP VP WHERE VP.COD_VP  = :CODE_VP';
    EXECUTE IMMEDIATE SQL_STATEMENT INTO VP_VALUE USING CODE_VP;
    RETURN VP_VALUE;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN RETURN NULL;
  END;

  FUNCTION OPZIONE_COMMERCIALE(ASSET_ID IN BDS_1_CASEDATA_ASSET.BDS_ID%TYPE,
                               CODICEOFFERTAJPUB IN OFFERTA.COD_OFFERTA_JPUB%TYPE)
  RETURN NUMBER
  IS
    TIPO_TRASPORTO VARCHAR2(400);
    OUTCOME PLS_INTEGER;
  BEGIN
  CASE CODIFICA_ATTRIBUTO_ASSET (ASSET_ID, 'TIPOBANDACONSEGNA')
  WHEN 'DEDICATA' THEN
    BEGIN
      OUTCOME := Null;
    END;
  WHEN 'CONDIVISA' THEN
    BEGIN
    TIPO_TRASPORTO := VP_VALUE(ASSET_ID, 'TIPO_TRASPORTO');
     CASE
      WHEN CODICEOFFERTAJPUB = 47 AND TIPO_TRASPORTO='Assente' THEN OUTCOME := 3;
      WHEN CODICEOFFERTAJPUB = 47 AND TIPO_TRASPORTO='Presente' THEN OUTCOME := 4;
      ELSE OUTCOME := 5;
     END CASE;
     RETURN OUTCOME;
    END;
       ELSE OUTCOME := Null; -- SM_3936
   END CASE;
   RETURN OUTCOME;
  END;

 /* FUNCTION OPZIONE_COMMERCIALE(ASSET_ID IN BDS_1_CASEDATA_ASSET.BDS_ID%TYPE,
                               TIPO_CONTRATTO IN OFFERTA.COD_OFFERTA_JPUB%TYPE) -- SM_392 'TIPOLG_CONTRATTO.COD_CONTRATTO_JPUB%TYPE'
  RETURN NUMBER
  IS
    TIPO_TRASPORTO VARCHAR2(400);
    OUTCOME PLS_INTEGER;
  BEGIN
    TIPO_TRASPORTO := CODIFICA_ATTRIBUTO_ASSET(ASSET_ID, 'TRASPORTO');

    CASE
      WHEN TIPO_CONTRATTO = 47 AND TIPO_TRASPORTO IS NULL THEN OUTCOME := 3;
      WHEN TIPO_CONTRATTO = 47 AND TIPO_TRASPORTO IS NOT NULL THEN OUTCOME := 4;
      ELSE OUTCOME := 5;
    END CASE;

    RETURN OUTCOME;

  END OPZIONE_COMMERCIALE;*/
   -------- INIZIO SM_2746
  FUNCTION TIPO_OFFERTA(ASSET_ID IN BDS_1_CASEDATA_ASSET.BDS_ID%TYPE)
  RETURN NUMBER
  IS
    V_TIPO VARCHAR2(400);
    OUTCOME PLS_INTEGER;
  BEGIN
  CASE CODIFICA_ATTRIBUTO_ASSET (ASSET_ID, 'TIPOBANDACONSEGNA')
  WHEN 'DEDICATA' THEN
    BEGIN
      OUTCOME := Null;
    END;
  WHEN 'CONDIVISA' THEN
    BEGIN
    V_TIPO := VP_VALUE(ASSET_ID, 'TIPO');
     CASE
      WHEN V_TIPO='Standard' THEN OUTCOME := 25;
      WHEN V_TIPO='Special' THEN OUTCOME := 26;
      WHEN V_TIPO='Lite' THEN OUTCOME := 27;
      ELSE OUTCOME := Null;
     END CASE;
     RETURN OUTCOME;
    END;
    ELSE OUTCOME := Null;
   END CASE;
   RETURN OUTCOME;
  END;
  -------- FINE SM_2746


  FUNCTION MOD_FAT_TRASP (ASSET_ID IN BDS_1_CASEDATA_ASSET.BDS_ID%TYPE,
                          MOD_FAT  IN VARCHAR2)
  RETURN NUMBER
  DETERMINISTIC
  PARALLEL_ENABLE
  IS
    RETURN_VALUE VARCHAR2(1);
    TIPO_TRASPORTO VARCHAR2(400);
  BEGIN

    TIPO_TRASPORTO := CODIFICA_ATTRIBUTO_ASSET(ASSET_ID, 'TRASPORTO');

    IF TIPO_TRASPORTO IS NOT NULL THEN
      IF MOD_FAT = 1 THEN
        RETURN_VALUE := 1;
      ELSIF MOD_FAT IN (2, 3) THEN
        RETURN_VALUE := 2;
      END IF;
    ELSE
      RETURN_VALUE := 3;
    END IF;

    RETURN RETURN_VALUE;
  END MOD_FAT_TRASP;

  FUNCTION FLAG_TRASPORTO_INT (ASSET_ID IN BDS_1_CASEDATA_ASSET.BDS_ID%TYPE,
                               MOD_FAT  IN NUMBER)
  RETURN VARCHAR2
  DETERMINISTIC
  PARALLEL_ENABLE
  IS
    RETURN_VALUE VARCHAR2(1);
    TIPO_TRASPORTO VARCHAR2(400);
  BEGIN

    TIPO_TRASPORTO := CODIFICA_ATTRIBUTO_ASSET(ASSET_ID, 'TRASPORTO');

 --SM_10806
      IF ( TIPO_TRASPORTO IS NOT NULL  AND UPPER(TIPO_TRASPORTO) ='PRESENTE' ) THEN
      IF MOD_FAT = 1 THEN
        RETURN_VALUE := 'F';
      ELSIF MOD_FAT IN (2, 3) THEN
        RETURN_VALUE := 'C';
      END IF;
    ELSE
      RETURN_VALUE := NULL;
    END IF;

    RETURN RETURN_VALUE;
  END FLAG_TRASPORTO_INT;

  FUNCTION GET_TIPO_FAMIGLIA (ORD_BDS_ID IN VARCHAR2,
                              ID_OFF IN OFFERTA.ID_OFFERTA%TYPE)
  RETURN NUMBER
  DETERMINISTIC
  PARALLEL_ENABLE
  IS
  OFF_JPUB OFFERTA.COD_OFFERTA_JPUB%TYPE;
  MOD_TRASF OFFERTA.MODO_TRASFERIMENTO%TYPE;

  ACCESSONUMERICO BDS_1_CASEDATA_ATTRIBTDTTGLRDN.VALOREATTRIBUTO%TYPE;
  SELEZIONEPASSANTE BDS_1_CASEDATA_ATTRIBTDTTGLRDN.VALOREATTRIBUTO%TYPE;
  TIPOSTRUTTURA BDS_1_CASEDATA_ATTRIBTDTTGLRDN.VALOREATTRIBUTO%TYPE;
  RETURN_VALUE_41 NUMBER;
  BEGIN
    SELECT COD_OFFERTA_JPUB, MODO_TRASFERIMENTO
    INTO OFF_JPUB, MOD_TRASF
    FROM OFFERTA
    WHERE ID_OFFERTA = ID_OFF;

    IF OFF_JPUB = '41' THEN
      select PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD_BDS_ID, 'ACCESSONUMERICO') into ACCESSONUMERICO from dual;
      select PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD_BDS_ID, 'SELEZIONEPASSANTE') into SELEZIONEPASSANTE from dual;
      select PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD_BDS_ID, 'STRUTTURALINEA') into TIPOSTRUTTURA from dual;
    END IF;

    CASE
      WHEN OFF_JPUB IN (9,37,52,17,23) THEN
          CASE UPPER(PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD_BDS_ID, 'STRUTTURALINEA'))
              WHEN 'SIMPLEX' THEN return 56;
              WHEN 'GNR' THEN return 50;
              WHEN 'PBX' THEN return 55;
              ELSE return Null;
          END CASE;
      WHEN OFF_JPUB = 41 THEN
          CASE ACCESSONUMERICO WHEN '0' THEN
              CASE TIPOSTRUTTURA WHEN 'GNR' THEN
                  CASE SELEZIONEPASSANTE
                      WHEN '0'   THEN RETURN 50;
                      WHEN NULL  THEN RETURN 50;
                      WHEN '1'   THEN RETURN 51;
                  END CASE;
              ELSE
                  RETURN NULL;
              END CASE;
          WHEN '1' THEN
              CASE TIPOSTRUTTURA WHEN 'GNR' THEN
                  CASE SELEZIONEPASSANTE
                      WHEN '0'   THEN RETURN 52;
                      WHEN NULL  THEN RETURN 52;
                      WHEN '1'   THEN RETURN 53;
                  END CASE;
          ELSE
              RETURN NULL;
          END CASE;
          else return null;
        END CASE;
      WHEN OFF_JPUB IN (47, 48) AND MOD_TRASF = 'ASIMMETRICO' THEN RETURN 2;
      WHEN OFF_JPUB = 42 AND MOD_TRASF = 'ASIMMETRICO' THEN RETURN 7;
      WHEN OFF_JPUB = 44 AND MOD_TRASF = 'ASIMMETRICO' THEN RETURN 10;
      WHEN OFF_JPUB = 50 AND MOD_TRASF = 'ASIMMETRICO'  THEN RETURN 15;
      WHEN OFF_JPUB = 51 AND MOD_TRASF = 'ASIMMETRICO'  THEN RETURN 16;
      WHEN OFF_JPUB = 42 AND MOD_TRASF = 'SIMMETRICO'  THEN RETURN 8; --- BS ATM SIMMETRICI S7
      WHEN OFF_JPUB = 44 AND MOD_TRASF = 'SIMMETRICO'  THEN RETURN 14; -- BS GBE SIMMETRICI S7
      ELSE RETURN NULL;
    END CASE;
  END GET_TIPO_FAMIGLIA;

  FUNCTION TIPO_FAMIGLIA (ID_OFFERTA IN OFFERTA.ID_OFFERTA%TYPE)
  RETURN NUMBER
  DETERMINISTIC
  PARALLEL_ENABLE
  IS
  BEGIN
    CASE
      WHEN ID_OFFERTA = 7 THEN RETURN 10;
      WHEN ID_OFFERTA IN (15, 16) THEN RETURN 15;
      WHEN ID_OFFERTA IN (17, 18) THEN RETURN 16;
      WHEN ID_OFFERTA IN (8,9,10) THEN RETURN 7;  -- CRIS SM_1935
      WHEN ID_OFFERTA IN (39, 40) THEN RETURN 8;  -- TIPO FAMIGLIA BTS ATM SIMMETRICO S7
      ELSE RETURN NULL;
    END CASE;
  END TIPO_FAMIGLIA;

  FUNCTION PROCESSED_FLAG (STATUS IN VARCHAR2)
  RETURN VARCHAR2
  DETERMINISTIC
  PARALLEL_ENABLE
  IS
  BEGIN
    IF STATUS IN ('CHIUSO', 'ESPLETAMENTOTECNICOKO', 'SCARTATO', 'FATTURAZIONEKO', 'INVIATOAFATTURAZIONE', 'ANNULLATO') THEN
      RETURN 'N';
    ELSE
      RETURN 'Y';
    END IF;
  END PROCESSED_FLAG;

  FUNCTION CODIFICA_TIPO_ORDINE (TIPOLOGIA_LAVORAZIONE IN BDS_1_CASEDATA_ORDINE.TIPOLOGIALAVORAZIONE%TYPE, TIPOLOGIA_SOTTOLAV IN BDS_1_CASEDATA_ORDINE.TIPOLOGIASOTTOLAV%TYPE DEFAULT NULL)
  RETURN NUMBER
  DETERMINISTIC
  PARALLEL_ENABLE
  IS
 -- ID_TIP_LAVORAZIONE TIPOLG_LAVRZ.IDTPLG_LAVRZ%TYPE;
 -- SQL_STAT VARCHAR2(200);
  BEGIN
    --SQL_STAT := 'SELECT IDTPLG_LAVRZ FROM TIPOLG_LAVRZ WHERE TIPOLG_LAVRZ = '''||TIPOLOGIA_LAVORAZIONE||'''';
   -- EXECUTE IMMEDIATE SQL_STAT INTO ID_TIP_LAVORAZIONE;
     -- Mapping esplicito fatto da Lao
    CASE TIPOLOGIA_LAVORAZIONE
      WHEN 'ATTIVAZIONE' THEN RETURN 1;
      WHEN 'CESSAZIONE' THEN RETURN 2;
      WHEN 'VARIAZIONE' THEN RETURN 3;
      --WHEN 'MIGRAZIONE OLO' THEN RETURN 4;
      WHEN 'MIGRAZIONE' THEN --RETURN 4;
      IF TIPOLOGIA_SOTTOLAV IS NOT NULL THEN
       CASE TIPOLOGIA_SOTTOLAV
        WHEN 'MIGRAZIONEOLO' THEN RETURN 4;
        WHEN 'ATTIVAZIONE274' THEN RETURN 5;
        WHEN 'MIGRAZIONEADSLRETAIL' THEN RETURN 6;
        WHEN 'RIENTROINTI' THEN RETURN 7;
       END CASE;
      ELSE
        RETURN 4;
      END IF;
      ELSE RETURN NULL;
    END CASE;
  END CODIFICA_TIPO_ORDINE;


  FUNCTION CODIFICA_STATO_RICHIESTA (STATO IN VARCHAR2)
  RETURN VARCHAR2
  DETERMINISTIC
  PARALLEL_ENABLE
  IS
  BEGIN
    CASE STATO
      WHEN STATO_RICH_FATT_KO THEN RETURN 'KO';
      WHEN STATO_RICH_FATT_CHIUSO THEN RETURN 'OK';
      ELSE RETURN NULL;
    END CASE;
  END CODIFICA_STATO_RICHIESTA;

-- ANDREA GARAVINI
-- 30/08/2016
-- LOTTO4

  FUNCTION MAPP_STATO_RICH (STRUTTRICH              IN BDS_1_CASEDATA_RICHIESTA.STRUTTURARICHIESTA%TYPE,
                            STATORICH               IN BDS_1_CASEDATA_RICHIESTA.STATORICHIESTANOW%TYPE,
                            CODTIPNTF               IN RICH_ORDN_COMUNIC_NOTF.COD_TIPOLG_NOTF%TYPE)
  RETURN VARCHAR2
  DETERMINISTIC
  PARALLEL_ENABLE
  IS
  BEGIN

    CASE
      WHEN STRUTTRICH = 'REGOLATORIO' THEN
            CASE
                WHEN STATORICH IN ('ESPLETAMENTOTECNICOKO', 'ANNULLATO', 'SCARTATO') AND CODTIPNTF = 'KD' THEN RETURN 'KO';
                WHEN STATORICH IN('CHIUSO', 'ESPLETAMENTOTECNICO', 'FATTURAZIONEKO', 'INVIATOAFATTURAZIONE') AND CODTIPNTF = 'OK' THEN RETURN 'OK';
                ELSE RETURN NULL;
            END CASE;
      WHEN STRUTTRICH IN ('XDSL', 'NGA') THEN
            CASE
                WHEN STATORICH IN ('ESPLETAMENTOTECNICOKO', 'SCARTATO') AND CODTIPNTF = 'KO' THEN RETURN 'KO';  -- RU 245 Cristiano Conte
                --WHEN STATORICH IN ('ESPLETAMENTOTECNICOKO') AND CODTIPNTF = 'KO' THEN RETURN 'KO';
                WHEN STATORICH IN('CHIUSO', 'ESPLETAMENTOTECNICO', 'FATTURAZIONEKO', 'INVIATOAFATTURAZIONE') AND CODTIPNTF = 'OK' THEN RETURN 'OK';
                ELSE RETURN NULL;
            END CASE;
      ELSE RETURN NULL;
    END CASE;

  END MAPP_STATO_RICH;

  FUNCTION MAPP_NOME_FILE (NOMEFILE              IN FILE_PROCSTO.NOME_FILE%TYPE,
                           STATONOTF             IN RICH_ORDN_COMUNIC_NOTF.IDTPLG_STNTF_FILE_ORARIO%TYPE)
  RETURN VARCHAR2
  DETERMINISTIC
  PARALLEL_ENABLE
  IS
  BEGIN

    IF STATONOTF = 2 THEN
        RETURN NOMEFILE;
    ELSE
        RETURN NULL;
    END IF;

  END MAPP_NOME_FILE;

--/ ANDREA GARAVINI

-- Luca Abbate, Lotto6
 FUNCTION GET_CAUSALE (TIP_SOTTO_LAV     IN BDS_1_CASEDATA_ORDINE.TIPOLOGIASOTTOLAV%TYPE,
                       TIP_SCEN          IN BDS_1_CASEDATA_ORDINE.TIPOLOGIASCENARIO%TYPE,
                       ID_OFFERTA_IN     IN BDS_1_CASEDATA_ASSET.IDOFFERTA%TYPE)
    RETURN VARCHAR2
    DETERMINISTIC
    PARALLEL_ENABLE
    IS
    CODICE_DEST_RET TRASCODFC_COD_CAUS_DEST.COD_CAUS_DESTNRIO%TYPE;
    SQL_SELECT   VARCHAR2(1000) := 'SELECT COD_CAUS_DESTNRIO FROM TRASCODFC_COD_CAUS_DEST TRAS_COD';
    SQL_WHERE_1  VARCHAR2(500) := ' WHERE TRAS_COD.STRUTTURA_RICH = ''REGOLATORIO'' AND TRAS_COD.ID_SISTEMA = ''JPUB'' AND TRAS_COD.ATTR = ''CODE_CAUS'' AND TRAS_COD.SOTTO_LAVRZ = '''||TIP_SOTTO_LAV||'''';
    SQL_WHERE_2  VARCHAR2(500) := ' WHERE TRAS_COD.STRUTTURA_RICH = ''REGOLATORIO'' AND TRAS_COD.ID_SISTEMA = ''JPUB'' AND TRAS_COD.ATTR = ''CODE_CAUS'' AND TRAS_COD.ID_SCENARIO = (SELECT ID_SCENARIO FROM TIPOLG_SCENARIO WHERE SCENARIO_BPM = '''||TIP_SCEN||''')';
    SQL_WHERE_3  VARCHAR2(500) := ' WHERE TRAS_COD.STRUTTURA_RICH = ''REGOLATORIO'' AND TRAS_COD.ID_SISTEMA = ''JPUB'' AND TRAS_COD.ATTR = ''CODE_CAUS'' AND TRAS_COD.ID_OFFERTA = '||ID_OFFERTA_IN||'';

  BEGIN
    IF TIP_SOTTO_LAV IS NULL AND TIP_SCEN IS NULL
      THEN RETURN Null;
    ELSE
      EXECUTE IMMEDIATE SQL_SELECT || SQL_WHERE_1 INTO CODICE_DEST_RET;
    END IF;
    RETURN CODICE_DEST_RET;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      begin
        execute immediate SQL_SELECT || SQL_WHERE_2 INTO CODICE_DEST_RET;
        return CODICE_DEST_RET;
      exception
      when no_data_found then
        begin
          execute immediate SQL_SELECT || SQL_WHERE_3 INTO CODICE_DEST_RET;
          return CODICE_DEST_RET;
        exception
          when others then
          INFO('** FATAL ERROR: ' || SQLCODE || ' - ' || SQLERRM || ' **');
          INFO('** SQL STATEMENT: ' || SQL_SELECT || SQL_WHERE_3 || ' **');
          return null;
        end;
      when others then
        INFO('** FATAL ERROR: ' || SQLCODE || ' - ' || SQLERRM || ' **');
        INFO('** SQL STATEMENT: ' || SQL_SELECT || SQL_WHERE_2 || ' **');
        return null;
      end;
     WHEN OTHERS THEN
      INFO('** FATAL ERROR: ' || SQLCODE || ' - ' || SQLERRM || ' **');
      INFO('** SQL STATEMENT: ' || SQL_SELECT || SQL_WHERE_1 || ' **');
      RETURN NULL;
  END GET_CAUSALE;

FUNCTION CODIFICA_CODICE_FATT (BDS_ID IN BDS_1_CASEDATA_ORDINE.BDS_ID%TYPE,TIPO_LINEA IN VARCHAR2)
  RETURN NUMBER
  DETERMINISTIC
  PARALLEL_ENABLE
IS
 ATTRIBUTE_VALUE   VARCHAR2(100);

BEGIN
 ATTRIBUTE_VALUE := CODIFICA_ATTRIBUTO_ORDINE(BDS_ID, 'CODICEFATTURAZIONE');
 IF TIPO_LINEA ='RES' THEN
  CASE
     WHEN ATTRIBUTE_VALUE IN ('A','B','C','U') THEN RETURN 50;
     WHEN ATTRIBUTE_VALUE IN ('D','E','F','G','H','I','L','M','N','O','P','Q','R','S','T') THEN RETURN 51;
      ELSE RETURN NULL;
  END CASE;
 ELSIF TIPO_LINEA ='DIR' THEN
   CASE
     WHEN ATTRIBUTE_VALUE IN ('C','E','H','M') THEN RETURN 51;
     WHEN ATTRIBUTE_VALUE IN ('A','B','D','G','I','L','N','O','P','Q','R','S','T','U') THEN RETURN 52;
     WHEN ATTRIBUTE_VALUE IN ('F') THEN RETURN 53;
      ELSE RETURN NULL;
   END CASE;
 END IF;
END CODIFICA_CODICE_FATT;
--/ Luca Abbate, Lotto6

-- ISSUE 37585
FUNCTION CODIFICA_CODICE_FATT_NEW (BDS_ID IN BDS_1_CASEDATA_ORDINE.BDS_ID%TYPE,TIPO_LINEA IN VARCHAR2)
  RETURN NUMBER
  DETERMINISTIC
  PARALLEL_ENABLE
IS
 ATTRIBUTE_VALUE   VARCHAR2(100);

BEGIN
 ATTRIBUTE_VALUE := CODIFICA_ATTRIBUTO_ORDINE(BDS_ID, 'CODICEFATTURAZIONE');
 IF TIPO_LINEA ='RES' THEN
  CASE
     WHEN ATTRIBUTE_VALUE IN ('A','B','C','U') THEN RETURN 50;
     WHEN ATTRIBUTE_VALUE IN ('D','E','F','G','H','I','L','M','N','O','P','Q','R','S','T') THEN RETURN 51;
      ELSE RETURN NULL;
  END CASE;
 ELSIF TIPO_LINEA ='DIR' THEN
   CASE
     WHEN ATTRIBUTE_VALUE IN ('C','E','H','M') THEN RETURN 51;
     WHEN ATTRIBUTE_VALUE IN ('A','B','D','F','I','L','N','O','P','Q','R','S','T','U') THEN RETURN 52;
     WHEN ATTRIBUTE_VALUE IN ('G') THEN RETURN 53;
      ELSE RETURN NULL;
   END CASE;
 ELSIF TIPO_LINEA ='TIPOLINEA' THEN
   CASE
     WHEN ATTRIBUTE_VALUE IN ('A','C','D','E','U') THEN RETURN 55;
     WHEN ATTRIBUTE_VALUE IN ('B','F','G','H','I','L') THEN RETURN 53;
     WHEN ATTRIBUTE_VALUE IN ('M','N','Q','P') THEN RETURN 54;
      ELSE RETURN NULL;
   END CASE;
 END IF;
END CODIFICA_CODICE_FATT_NEW;


--/ Lotto6
FUNCTION GET_TIP_PAG_ACCS (OFF_IDTPLG_PAGAMENTO_ACCS IN OFFERTA.IDTPLG_PAGAMENTO_ACCS%TYPE,FAT IN VARCHAR2)
   RETURN VARCHAR2
   DETERMINISTIC
   PARALLEL_ENABLE
   IS
   DESC_PAG TIPOLG_PAGAMENTO_ACCS.DESCR_PAGAMENTO%TYPE;
   SQL_STAT VARCHAR2(200);
 BEGIN
    SQL_STAT := 'SELECT DESCR_PAGAMENTO FROM TIPOLG_PAGAMENTO_ACCS WHERE IDTPLG_PAGAMENTO_ACCS = '||OFF_IDTPLG_PAGAMENTO_ACCS;
    EXECUTE IMMEDIATE SQL_STAT INTO DESC_PAG;
     IF FAT ='MOD_FAT' THEN
      CASE
        WHEN DESC_PAG ='FLAT' THEN RETURN 'F';
        WHEN DESC_PAG ='HIGH' THEN RETURN 'H';
        WHEN DESC_PAG ='LITE' THEN RETURN 'C';
        ELSE RETURN NULL;
      END CASE;
     ELSIF FAT ='TIPO_MOD_FAT' THEN
     CASE
       WHEN DESC_PAG ='FLAT' THEN RETURN '2';
       WHEN DESC_PAG IN('HIGH','LITE') THEN RETURN '1';
       ELSE RETURN NULL;
     END CASE;
    END IF;
  END GET_TIP_PAG_ACCS;
--/ Lotto 6
  FUNCTION CLASSE_SERV(ORDINE_BDS_ID        IN NUMBER,
                    inCODICEOFFERTAJPUB   IN OFFERTA.COD_OFFERTA_JPUB%TYPE)
  RETURN VARCHAR2
  IS
    OUTCOME           VARCHAR2(20);
    ATTRIBUTE_VALUE   VARCHAR2(100);

  BEGIN

    LOG('    CHECKING ATTRIBUTE VALUE USING COD_JPUB ' || inCODICEOFFERTAJPUB);
    ATTRIBUTE_VALUE := CODIFICA_ATTRIBUTO_ORDINE(ORDINE_BDS_ID, 'TIPOPROFILOVC');
    LOG ('     ATTRIBUTE_VALUE: ' || ATTRIBUTE_VALUE);
    SELECT TE.VALORE_TRASCODFCTO
      INTO OUTCOME
    FROM TRASCODFC_ESTERNA TE
    WHERE TE.AMBITO = 'X'
      AND TE.NOME_ATTR_VALORE = 'TIPOPROFILOVC'
      AND TE.TAG = 'CLASSE_SERV'
      AND TE.ID_SISTEMA = 3
      AND TE.VALORE_DA_TRASCODFCRE = ATTRIBUTE_VALUE
      AND TE.COD_OFFERTA_JPUB = inCODICEOFFERTAJPUB;
    RETURN OUTCOME;
  EXCEPTION
    WHEN OTHERS THEN
      LOG('ERROR IN MODULE [CLASS_SERV]: ' || SQLERRM);
      RETURN OUTCOME;
  END CLASSE_SERV;

--/ Lotto 6
FUNCTION OPZ_COMM_ORD (ORDINE_BDS_ID          IN BDS_1_CASEDATA_ORDINE.BDS_ID%TYPE,
                    inCODICEOFFERTAJPUB   IN OFFERTA.COD_OFFERTA_JPUB%TYPE,
                    inIDAMBITO            IN NUMBER,
                    inOFFERTA             IN OFFERTA.OFFERTA%TYPE)
  RETURN NUMBER
  DETERMINISTIC
  PARALLEL_ENABLE
IS
 ATTRIBUTE_VALUE   VARCHAR2(100);
 TIPO_TRASPORTO VARCHAR2(400);

BEGIN
   ATTRIBUTE_VALUE := CODIFICA_ATTRIBUTO_ORDINE(ORDINE_BDS_ID, 'FLAGDNDONOROLO');
   TIPO_TRASPORTO := CODIFICA_ATTRIBUTO_ORDINE(ORDINE_BDS_ID,'TRASPORTO');
   CASE
     WHEN inIDAMBITO = FAMIGLIA_REGOLATORIO THEN
        CASE
          WHEN inCODICEOFFERTAJPUB = '9' THEN
            IF inOFFERTA='ULL LINEA ATTIVA NP' THEN
               IF ATTRIBUTE_VALUE='Y' THEN
                  RETURN 52;
               ELSE
                  RETURN 50;
               END IF;
            ELSE
              RETURN 51;
            END IF;
          WHEN inCODICEOFFERTAJPUB = '37' THEN
            IF inOFFERTA='ULL DATI LINEA ATTIVA NP' THEN
               IF ATTRIBUTE_VALUE='Y' THEN
                  RETURN 52;
               ELSE
                  RETURN 50;
               END IF;
            ELSE
              RETURN 51;
            END IF;
          WHEN inCODICEOFFERTAJPUB = '52' THEN
            IF inOFFERTA='SLU LINEA ATTIVA NP' THEN
               IF ATTRIBUTE_VALUE='Y' THEN
                  RETURN 52;
               ELSE
                  RETURN 50;
               END IF;
            ELSE
              RETURN 51;
            END IF;
          WHEN inCODICEOFFERTAJPUB = '23' THEN
            RETURN 51;
          ELSE
            RETURN NULL;
        END CASE;
      WHEN inIDAMBITO IN (FAMIGLIA_BITSTREAM, FAMIGLIA_EASYIP) THEN
        CASE
          WHEN inCODICEOFFERTAJPUB ='47'  THEN
            IF TIPO_TRASPORTO ='0' THEN
              RETURN 3;
            ELSIF TIPO_TRASPORTO ='1' THEN
              RETURN 4;
            ELSE
              RETURN 5;
            END IF;
            WHEN inCODICEOFFERTAJPUB ='48'  THEN
              RETURN 5;
            ELSE
              RETURN NULL;
          END CASE;
      ELSE RETURN NULL;
    END CASE;
END OPZ_COMM_ORD;


  -- SM_6018 --
  FUNCTION GET_STATI_F1_TD (IDRIS IN BDS_1_CASEDATA_RICHIESTA.IDRISORSA%TYPE, CAMPO IN VARCHAR2)
  RETURN NUMBER
  DETERMINISTIC
  PARALLEL_ENABLE
    IS
    STATO NUMBER;
    IDASSET bds_1_casedata_assettarget.idasset%TYPE;
    STATORICHIESTANOW bds_1_casedata_richiesta.statorichiestanow%TYPE;
    LAVORAZIONE  bds_1_casedata_richiesta.lavorazione%TYPE;
    IDRICHIESTAOLO bds_1_casedata_richiesta.idrichiestaolo%TYPE;
    IDRISORSAVC bds_1_casedata_attribtdttglrdn.valoreattributo%TYPE;
    BEGIN
      BEGIN
        SELECT ASSTRGRICH.IDASSET IDASSET,
               ASSTRGRICH.STATORICHIESTANOW,
               ASSTRGRICH.LAVORAZIONE,
               ASSTRGRICH.IDRICHIESTAOLO
        INTO IDASSET, STATORICHIESTANOW, LAVORAZIONE, IDRICHIESTAOLO
        FROM (
              SELECT ASSTRG.IDASSET,
                     RICH.STATORICHIESTANOW,
                     RICH.LAVORAZIONE,
                     RICH.IDRICHIESTAOLO,
                     RANK() OVER (PARTITION BY RICH.IDRISORSA ORDER BY RICH.CREATED DESC NULLS LAST, ASSTRG.RICHIESTA_ASSETTARGET_IDX DESC) RN,
                     FLAGINLAVORAZIONE,
                     RICH.CREATED
              FROM APPUSER.BDS_1_CASEDATA_ASSETTARGET ASSTRG
              JOIN APPUSER.BDS_1_CASEDATA_RICHIESTA RICH ON ASSTRG.RICHIESTA_ASSETTARGET_BDSID = RICH.BDS_ID
              WHERE ASSTRG.FLAGINLAVORAZIONE = 1
              AND RICH.IDRISORSA = IDRIS
              ) ASSTRGRICH
              WHERE ASSTRGRICH.RN = 1;
      EXCEPTION WHEN NO_DATA_FOUND THEN
        RETURN 1;
      END;
    IF CAMPO = 'STATO_UTENZA' THEN
      CASE
        WHEN LAVORAZIONE IS NULL THEN STATO:=1;
        WHEN LAVORAZIONE = 'CESSAZIONE' THEN STATO:=6;
        WHEN LAVORAZIONE = 'VARIAZIONE' THEN STATO:=9;
        ELSE STATO := 1;
      END CASE; -- STATO UTENZA -- SM_6018
    ELSIF CAMPO = 'CODE_STATO_PS_ULL_OFFERTA' THEN
      CASE
        WHEN STATORICHIESTANOW IS NULL OR STATORICHIESTANOW IN ('SCARTATO', 'ANNULLATO', 'ESPLETAMENTOTECNICO', 'CHIUSO', 'INVIATOAFATTURAZIONE', 'FATTURAZIONEKO') THEN STATO := 1;
        WHEN STATORICHIESTANOW NOT IN ('SCARTATO', 'ANNULLATO', 'ESPLETAMENTOTECNICO', 'CHIUSO', 'INVIATOAFATTURAZIONE', 'FATTURAZIONEKO') AND LAVORAZIONE = 'CESSAZIONE' THEN STATO := 6;
        WHEN STATORICHIESTANOW NOT IN ('SCARTATO', 'ANNULLATO', 'ESPLETAMENTOTECNICO', 'CHIUSO', 'INVIATOAFATTURAZIONE', 'FATTURAZIONEKO') AND LAVORAZIONE = 'VARIAZIONE' THEN STATO := 9;
        ELSE STATO := 1;
      END CASE; -- CODE_STATO_PS_ULL_OFFERTA (34)  -- SM_6018
    ELSIF CAMPO = 'CODE_STATO_PS_ULL_LINEA' THEN
      CASE
        WHEN STATORICHIESTANOW IS NULL OR STATORICHIESTANOW IN ('SCARTATO', 'ANNULLATO', 'ESPLETAMENTOTECNICO' ,  'CHIUSO', 'INVIATOAFATTURAZIONE', 'FATTURAZIONEKO') THEN STATO := 1;
        WHEN STATORICHIESTANOW NOT IN ('SCARTATO', 'ANNULLATO', 'ESPLETAMENTOTECNICO' ,  'CHIUSO', 'INVIATOAFATTURAZIONE', 'FATTURAZIONEKO') AND CODIFICA_ATTRIBUTO_ASSET(IDASSET, 'AZIONE','ATMVC') = 'D' THEN STATO := 6;
        WHEN STATORICHIESTANOW NOT IN ('SCARTATO', 'ANNULLATO', 'ESPLETAMENTOTECNICO' ,  'CHIUSO', 'INVIATOAFATTURAZIONE', 'FATTURAZIONEKO') AND CODIFICA_ATTRIBUTO_ASSET(IDASSET, 'AZIONE','ATMVC') = 'M' THEN STATO := 9;
        ELSE STATO := 1;
      END CASE; -- CODE_STATO_PS_ULL_LINEA (35) -- SM_6018
    END IF;
  RETURN STATO;
  EXCEPTION WHEN OTHERS THEN
  DBMS_OUTPUT.PUT_LINE ('ERRORE per '||IDASSET||': '||SQLERRM);
    RETURN NULL;
 END GET_STATI_F1_TD;

  FUNCTION ASSET_ATTR_BY_COMPONENT_ID (BDS_COMPONENT_ID IN BDS_1_CASEDATA_DETTAGLIOASSET.BDS_ID%TYPE,
                                      ATTRIBUTE_NAME IN VARCHAR2,
                                      CHECKNUMBER IN DECIMAL DEFAULT 0)
  RETURN VARCHAR2
  RESULT_CACHE RELIES_ON (BDS_1_CASEDATA_DETTAGLIOASSET, BDS_1_CASEDATA_ATTRIBTDTTGLSST)
  IS
    ATTRIBUTE_VALUE BDS_1_CASEDATA_ATTRIBTDTTGLSST.VALOREATTRIBUTO%TYPE;
  BEGIN
    SELECT VALOREATTRIBUTO
    INTO ATTRIBUTE_VALUE
    FROM BDS_1_CASEDATA_ATTRIBTDTTGLSST ATT
      JOIN BDS_1_CASEDATA_DETTAGLIOASSET DETT ON ATT.DTTGLSST_TTRBTIDTTGLISST_BDSID = DETT.BDS_ID
    WHERE DETT.BDS_ID = BDS_COMPONENT_ID
      AND ATT.NOMEATTRIBUTO = ATTRIBUTE_NAME
      FETCH FIRST 1 ROWS ONLY;

    IF CHECKNUMBER = 1 THEN
      DECLARE
        ATTRIBUTE_TO_NUMBER NUMBER;
      BEGIN
        ATTRIBUTE_TO_NUMBER := TO_NUMBER(ATTRIBUTE_VALUE);
      EXCEPTION
        WHEN OTHERS THEN
          ATTRIBUTE_VALUE := NULL;
      END;
    END IF;

    RETURN ATTRIBUTE_VALUE;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RETURN NULL;
  END ASSET_ATTR_BY_COMPONENT_ID;

FUNCTION BANDA_UTENTE_FINALE_SC (BDS_COMPONENT_ID IN BDS_1_CASEDATA_DETTAGLIOASSET.BDS_ID%TYPE,   --PRESTAZIONALE  RISCRITTA
                                ORDINE_BDSID     IN NUMBER,
                                ASSET_BDS_ID     IN NUMBER,
                                IDOFFERTA        IN NUMBER,
                                CAMPO            IN VARCHAR2)
  RETURN VARCHAR2
  IS


    ATTRIBUTE_NAME    BDS_1_CASEDATA_ATTRIBTDTTGLSST.NOMEATTRIBUTO%TYPE;
    ATTRIBUTE_VALUE   BDS_1_CASEDATA_ATTRIBTDTTGLSST.VALOREATTRIBUTO%TYPE;
    vIDPROFILOVC      NUMBER;
    vMCR_DOWN         NUMBER;
    vPCR_DOWN         NUMBER;
    vSCR_DOWN         NUMBER;
  BEGIN



    CASE
      WHEN IDOFFERTA IN (8, 9, 10) THEN
        -- 8 = BITSTREAM ATM ASIMMETRICO            BitstreamATMAsimmetricoFlat
        -- 9 = FLAT BITSTREAM ATM ASIMMETRICO       BitstreamATMAsimmetricoHL
        --10 = HL BITSTREAM ATM ASIMMETRICO LITE    BitstreamATMAsimmetricoLite
        /*CASE PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(BDS_COMPONENT_ID, 'TIPOPROFILOVC')
          WHEN 'ABR' THEN ATTRIBUTE_NAME := 'MCRDOWN';
          WHEN 'VBR' THEN ATTRIBUTE_NAME := 'PCRDOWN';
          WHEN 'CBR' THEN ATTRIBUTE_NAME := NULL;
          ELSE ATTRIBUTE_NAME := NULL;
        END CASE;*/
        BEGIN --PRESTAZIONALE
            SELECT CASE WHEN VALOREATTRIBUTO = 'ABR' THEN 'MCRDOWN'
                        WHEN VALOREATTRIBUTO = 'VBR' THEN 'PCRDOWN'
                        WHEN VALOREATTRIBUTO = 'CBR' THEN NULL
                        ELSE NULL END
                INTO ATTRIBUTE_NAME
           FROM BDS_1_CASEDATA_ATTRIBTDTTGLSST ATT
           JOIN BDS_1_CASEDATA_DETTAGLIOASSET DETT ON ATT.DTTGLSST_TTRBTIDTTGLISST_BDSID = DETT.BDS_ID
           WHERE DETT.BDS_ID = BDS_COMPONENT_ID
           AND ATT.NOMEATTRIBUTO = 'TIPOPROFILOVC'
          FETCH FIRST 1 ROWS ONLY;
      EXCEPTION
            WHEN OTHERS THEN
            ATTRIBUTE_NAME := NULL;
        END;

      WHEN IDOFFERTA IN (39, 40) THEN
          -- 39 = BITSTREAM ATM SIMMETRICO FLAT  BitstreamATMSimmetricoFlat
          -- 40 = BITSTREAM ATM SIMMETRICO HL    BitstreamATMSimmetricoHL
          IF CAMPO = 'VelocitaAccessoOLO' THEN
             -- ATTRIBUTE_NAME := 'CAPAC_TRASM_ACCESSO'; --RU_1370
              ATTRIBUTE_NAME := 'CAPAC_TRASM_KDC';   --RU_1370
          END IF;

          IF CAMPO = 'BandaOLO' THEN
               /* CASE PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(BDS_COMPONENT_ID, 'TIPOPROFILOVC')
                    WHEN 'VBR' THEN ATTRIBUTE_NAME := 'PCRDOWN';
                    WHEN 'ABR' THEN ATTRIBUTE_NAME := 'CAPAC_TRASM_ACCESSO';
                    ELSE ATTRIBUTE_NAME := NULL;
                END CASE;*/
                BEGIN --PRESTAZIONALE
            SELECT CASE WHEN VALOREATTRIBUTO = 'VBR' THEN 'PCRD'
                        WHEN VALOREATTRIBUTO = 'ABR' THEN 'CAPAC_TRASM_ACCESSO'
                        ELSE NULL END
                INTO ATTRIBUTE_NAME
           FROM BDS_1_CASEDATA_ATTRIBTDTTGLSST ATT
           JOIN BDS_1_CASEDATA_DETTAGLIOASSET DETT ON ATT.DTTGLSST_TTRBTIDTTGLISST_BDSID = DETT.BDS_ID
           WHERE DETT.BDS_ID = BDS_COMPONENT_ID
           AND ATT.NOMEATTRIBUTO = 'TIPOPROFILOVC'
          FETCH FIRST 1 ROWS ONLY;
      EXCEPTION
            WHEN OTHERS THEN
            ATTRIBUTE_NAME := NULL;
        END;


          END IF;
          IF CAMPO = 'BandaUtenteFinale' THEN
                /*CASE PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(BDS_COMPONENT_ID, 'TIPOPROFILOVC')
                    WHEN 'VBR' THEN ATTRIBUTE_NAME := 'SCRDOWN';
                    WHEN 'ABR' THEN ATTRIBUTE_NAME := 'CAPAC_TRASM_ACCESSO';
                    ELSE ATTRIBUTE_NAME := NULL;
                END CASE;*/
                BEGIN --PRESTAZIONALE
            SELECT CASE WHEN VALOREATTRIBUTO = 'VBR' THEN 'SCRDOWN'
                        WHEN VALOREATTRIBUTO = 'ABR' THEN 'CAPAC_TRASM_ACCESSO'
                        ELSE NULL END
                INTO ATTRIBUTE_NAME
           FROM BDS_1_CASEDATA_ATTRIBTDTTGLSST ATT
           JOIN BDS_1_CASEDATA_DETTAGLIOASSET DETT ON ATT.DTTGLSST_TTRBTIDTTGLISST_BDSID = DETT.BDS_ID
           WHERE DETT.BDS_ID = BDS_COMPONENT_ID
           AND ATT.NOMEATTRIBUTO = 'TIPOPROFILOVC'
          FETCH FIRST 1 ROWS ONLY;
      EXCEPTION
            WHEN OTHERS THEN
            ATTRIBUTE_NAME := NULL;
        END;

          END IF;
      ELSE
        NULL;
    END CASE;

    IF ATTRIBUTE_NAME IS NOT NULL AND ATTRIBUTE_NAME IN ('MCRDOWN','PCRDOWN','SCRDOWN')  THEN --MNP
         --vIDPROFILOVC := TO_NUMBER(PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(BDS_COMPONENT_ID, 'IDPROFILOVC'),'999999999D9999','nls_numeric_characters=.,'); --, '999999999.9');
          BEGIN --PRESTAZIONALE
             SELECT TO_NUMBER(VALOREATTRIBUTO,'999999999D9999','nls_numeric_characters=.,')
                    INTO vIDPROFILOVC
               FROM BDS_1_CASEDATA_ATTRIBTDTTGLSST ATT
               JOIN BDS_1_CASEDATA_DETTAGLIOASSET DETT ON ATT.DTTGLSST_TTRBTIDTTGLISST_BDSID = DETT.BDS_ID
               WHERE DETT.BDS_ID = BDS_COMPONENT_ID
               AND ATT.NOMEATTRIBUTO = 'IDPROFILOVC'
              FETCH FIRST 1 ROWS ONLY;
         EXCEPTION
            WHEN OTHERS THEN
            vIDPROFILOVC := NULL;
        END;

         SELECT  MCR_DOWN,  PCR_DOWN ,  SCR_DOWN
           INTO vMCR_DOWN, vPCR_DOWN , vSCR_DOWN
           FROM PROFILO_VC
          WHERE ID_PRFL_VC = vIDPROFILOVC;

         CASE ATTRIBUTE_NAME
              WHEN 'MCRDOWN' THEN ATTRIBUTE_VALUE := vMCR_DOWN;
              WHEN 'PCRDOWN' THEN ATTRIBUTE_VALUE := vPCR_DOWN;
              WHEN 'SCRDOWN' THEN ATTRIBUTE_VALUE := vSCR_DOWN;
         ELSE
              ATTRIBUTE_VALUE := NULL;
         END CASE;
    END IF;

    IF ATTRIBUTE_NAME IS NOT NULL AND ATTRIBUTE_NAME = 'CAPAC_TRASM_ACCESSO'  THEN --MNP
        DECLARE
            PROFILO PROFILO_TCNC_LINEA.PROFILO_TCNC_LINEA%TYPE;
        BEGIN
            --PROFILO := TO_CHAR(PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET_BDS_ID, 'PROFILOTECNICOLINEA'));
             BEGIN --PRESTAZIONALE
                SELECT to_char(VALOREATTRIBUTO) INTO PROFILO
                    FROM BDS_1_CASEDATA_ATTRIBTDTTGLSST ATT
                      JOIN BDS_1_CASEDATA_ASSET ASSET ON ASSET.IDASSET = ATT.IDASSET
                    WHERE ASSET.BDS_ID = ASSET_BDS_ID
                      AND ATT.NOMEATTRIBUTO = 'PROFILOTECNICOLINEA'
                      FETCH FIRST 1 ROW ONLY;
                  EXCEPTION
                  WHEN OTHERS THEN
                  PROFILO := NULL;
               END;

            IF PROFILO IS NOT NULL THEN
              SELECT TO_CHAR(PROFILO_COMMERCIALE_UP) || '.0'
                INTO ATTRIBUTE_VALUE
                FROM PROFILO_TCNC_LINEA
               WHERE PROFILO_TCNC_LINEA = PROFILO
                 AND ID_OFFERTA = IDOFFERTA;

              RETURN ATTRIBUTE_VALUE;
            END IF;
        EXCEPTION
            WHEN OTHERS THEN NULL;
        END;
    END IF;


    IF ATTRIBUTE_NAME IS NOT NULL AND ATTRIBUTE_NAME = 'CAPAC_TRASM_KDC'  THEN --MNP
     DECLARE
            VX_CODICE VARCHAR2(100);
            COD_KIT   VARCHAR2(100);
            VELOCITA  ANAG_KIT.VELOCITA_TRASMISSIVA_KIT%TYPE;
        BEGIN
            -- COD_KIT := TO_CHAR(PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET_BDS_ID, 'CODICETD'));
                BEGIN --PRESTAZIONALE
                SELECT to_char(VALOREATTRIBUTO) INTO COD_KIT
                    FROM BDS_1_CASEDATA_ATTRIBTDTTGLSST ATT
                      JOIN BDS_1_CASEDATA_ASSET ASSET ON ASSET.IDASSET = ATT.IDASSET
                    WHERE ASSET.BDS_ID = ASSET_BDS_ID
                      AND ATT.NOMEATTRIBUTO = 'CODICETD'
                      FETCH FIRST 1 ROW ONLY;
                  EXCEPTION
                  WHEN OTHERS THEN
                  COD_KIT := NULL;
               END;


             IF COD_KIT is null  THEN
               -- VX_CODICE := TO_CHAR(PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET_BDS_ID, 'CODICEVP'));
                  BEGIN --PRESTAZIONALE
                SELECT to_char(VALOREATTRIBUTO) INTO VX_CODICE
                    FROM BDS_1_CASEDATA_ATTRIBTDTTGLSST ATT
                      JOIN BDS_1_CASEDATA_ASSET ASSET ON ASSET.IDASSET = ATT.IDASSET
                    WHERE ASSET.BDS_ID = ASSET_BDS_ID
                      AND ATT.NOMEATTRIBUTO = 'CODICEVP'
                      FETCH FIRST 1 ROW ONLY;
                  EXCEPTION
                  WHEN OTHERS THEN
                  VX_CODICE := NULL;
               END;


                IF VX_CODICE is not null THEN
                  select COD_KIT INTO COD_KIT from ANAG_VP where COD_VP = VX_CODICE;
                ELSE
                  RETURN NULL;
                END IF;
             END IF;
         IF COD_KIT is NOT NULL  THEN
           select case WHEN VELOCITA_TRASMISSIVA_KIT ='2 Mbit/s' THEN TO_CHAR(2*1024)||'.0'
                        WHEN VELOCITA_TRASMISSIVA_KIT ='4 Mbit/s' THEN TO_CHAR(4*1024)||'.0'
                        WHEN VELOCITA_TRASMISSIVA_KIT ='6 Mbit/s' THEN TO_CHAR(6*1024)||'.0'
                        WHEN VELOCITA_TRASMISSIVA_KIT ='8 Mbit/s' THEN TO_CHAR(8*1024)||'.0'
                        WHEN VELOCITA_TRASMISSIVA_KIT ='155 Mbit/s' THEN TO_CHAR(155*1024)||'.0'
                        WHEN VELOCITA_TRASMISSIVA_KIT ='34 Mbit/s' THEN TO_CHAR(34*1024)||'.0'
                    END  INTO ATTRIBUTE_VALUE
              from ANAG_KIT where cod_kit = COD_KIT;

               RETURN ATTRIBUTE_VALUE;
           END IF;
     EXCEPTION
        WHEN OTHERS THEN
              ATTRIBUTE_VALUE:=NULL;
        END;
    END IF;

    RETURN ATTRIBUTE_VALUE;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RETURN NULL;
  END BANDA_UTENTE_FINALE_SC;


  FUNCTION BANDA_UTENTE_FINALE (BDS_COMPONENT_ID IN BDS_1_CASEDATA_DETTAGLIOASSET.BDS_ID%TYPE,   --SM_5171   RISCRITTA
                                ORDINE_BDSID     IN NUMBER,
                                ASSET_BDS_ID     IN NUMBER,
                                IDOFFERTA        IN NUMBER,
                                CAMPO            IN VARCHAR2)
  RETURN VARCHAR2
  IS
    ATTRIBUTE_NAME    BDS_1_CASEDATA_ATTRIBTDTTGLSST.NOMEATTRIBUTO%TYPE;
    ATTRIBUTE_VALUE   BDS_1_CASEDATA_ATTRIBTDTTGLSST.VALOREATTRIBUTO%TYPE;
    vIDPROFILOVC      NUMBER;
    vMCR_DOWN         NUMBER;
    vPCR_DOWN         NUMBER;
    vSCR_DOWN         NUMBER;
  BEGIN

  --CAMPO =>>  BandaUtenteFinale    VelocitaAccessoOLO   BandaOLO

    CASE
      WHEN IDOFFERTA IN (8, 9, 10) THEN
        -- 8 = BITSTREAM ATM ASIMMETRICO            BitstreamATMAsimmetricoFlat
        -- 9 = FLAT BITSTREAM ATM ASIMMETRICO       BitstreamATMAsimmetricoHL
        --10 = HL BITSTREAM ATM ASIMMETRICO LITE    BitstreamATMAsimmetricoLite
        CASE ASSET_ATTR_BY_COMPONENT_ID(BDS_COMPONENT_ID, 'TIPOPROFILOVC')
          WHEN 'ABR' THEN ATTRIBUTE_NAME := 'MCRDOWN';
          WHEN 'VBR' THEN ATTRIBUTE_NAME := 'PCRDOWN';
          WHEN 'CBR' THEN ATTRIBUTE_NAME := NULL;
          ELSE ATTRIBUTE_NAME := NULL;
        END CASE;
      WHEN IDOFFERTA IN (39, 40) THEN
          -- 39 = BITSTREAM ATM SIMMETRICO FLAT  BitstreamATMSimmetricoFlat
          -- 40 = BITSTREAM ATM SIMMETRICO HL    BitstreamATMSimmetricoHL
          IF CAMPO = 'VelocitaAccessoOLO' THEN
             -- ATTRIBUTE_NAME := 'CAPAC_TRASM_ACCESSO'; --RU_1370
              ATTRIBUTE_NAME := 'CAPAC_TRASM_KDC';   --RU_1370
          END IF;
          /* Commentato con SM_10899
          IF CAMPO = 'VelocitaAccessoOLO' THEN
                CASE ASSET_ATTR_BY_COMPONENT_ID(BDS_COMPONENT_ID, 'TIPOPROFILOVC')
                    WHEN 'VBR' THEN ATTRIBUTE_NAME := 'SCRDOWN';
                    WHEN 'ABR' THEN ATTRIBUTE_NAME := 'CAPAC_TRASM_ACCESSO';
                    ELSE ATTRIBUTE_NAME := NULL;
                END CASE;
          END IF;
          */
          IF CAMPO = 'BandaOLO' THEN
                CASE ASSET_ATTR_BY_COMPONENT_ID(BDS_COMPONENT_ID, 'TIPOPROFILOVC')
                    WHEN 'VBR' THEN ATTRIBUTE_NAME := 'PCRDOWN';
                    WHEN 'ABR' THEN ATTRIBUTE_NAME := 'CAPAC_TRASM_ACCESSO';
                    ELSE ATTRIBUTE_NAME := NULL;
                END CASE;
          END IF;
          IF CAMPO = 'BandaUtenteFinale' THEN
                CASE ASSET_ATTR_BY_COMPONENT_ID(BDS_COMPONENT_ID, 'TIPOPROFILOVC')
                    WHEN 'VBR' THEN ATTRIBUTE_NAME := 'SCRDOWN';
                    WHEN 'ABR' THEN ATTRIBUTE_NAME := 'CAPAC_TRASM_ACCESSO';
                    ELSE ATTRIBUTE_NAME := NULL;
                END CASE;
          END IF;
      ELSE
        NULL;
    END CASE;

    IF ATTRIBUTE_NAME IS NOT NULL AND ATTRIBUTE_NAME IN ('MCRDOWN','PCRDOWN','SCRDOWN')  THEN --MNP
         vIDPROFILOVC := TO_NUMBER(PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(BDS_COMPONENT_ID, 'IDPROFILOVC'),'999999999D9999','nls_numeric_characters=.,'); --, '999999999.9');
         SELECT  MCR_DOWN,  PCR_DOWN ,  SCR_DOWN
           INTO vMCR_DOWN, vPCR_DOWN , vSCR_DOWN
           FROM PROFILO_VC
          WHERE ID_PRFL_VC = vIDPROFILOVC;

         CASE ATTRIBUTE_NAME
              WHEN 'MCRDOWN' THEN ATTRIBUTE_VALUE := vMCR_DOWN;
              WHEN 'PCRDOWN' THEN ATTRIBUTE_VALUE := vPCR_DOWN;
              WHEN 'SCRDOWN' THEN ATTRIBUTE_VALUE := vSCR_DOWN;
         ELSE
              ATTRIBUTE_VALUE := NULL;
         END CASE;
    END IF;

    IF ATTRIBUTE_NAME IS NOT NULL AND ATTRIBUTE_NAME = 'CAPAC_TRASM_ACCESSO'  THEN --MNP
        DECLARE
            PROFILO PROFILO_TCNC_LINEA.PROFILO_TCNC_LINEA%TYPE;
        BEGIN
            PROFILO := TO_CHAR(CODIFICA_ATTRIBUTO_ASSET(ASSET_BDS_ID, 'PROFILOTECNICOLINEA'));

            IF PROFILO IS NOT NULL THEN
              SELECT TO_CHAR(PROFILO_COMMERCIALE_UP) || '.0'
                INTO ATTRIBUTE_VALUE
                FROM PROFILO_TCNC_LINEA
               WHERE PROFILO_TCNC_LINEA = PROFILO
                 AND ID_OFFERTA = IDOFFERTA;

              RETURN ATTRIBUTE_VALUE;
            END IF;
        EXCEPTION
            WHEN OTHERS THEN NULL;
        END;
    END IF;

    --RU_1370
    IF ATTRIBUTE_NAME IS NOT NULL AND ATTRIBUTE_NAME = 'CAPAC_TRASM_KDC'  THEN --MNP
     DECLARE
            VX_CODICE VARCHAR2(100);
            COD_KIT   VARCHAR2(100);
            VELOCITA  ANAG_KIT.VELOCITA_TRASMISSIVA_KIT%TYPE;
        BEGIN
             COD_KIT := TO_CHAR(CODIFICA_ATTRIBUTO_ASSET(ASSET_BDS_ID, 'CODICETD'));
             IF COD_KIT is null  THEN
                VX_CODICE := TO_CHAR(CODIFICA_ATTRIBUTO_ASSET(ASSET_BDS_ID, 'CODICEVP'));
                IF VX_CODICE is not null THEN
                  select COD_KIT INTO COD_KIT from ANAG_VP where COD_VP = VX_CODICE;
                ELSE
                  RETURN NULL;
                END IF;
             END IF;
         IF COD_KIT is NOT NULL  THEN
           select case WHEN VELOCITA_TRASMISSIVA_KIT ='2 Mbit/s' THEN TO_CHAR(2*1024)||'.0'
                        WHEN VELOCITA_TRASMISSIVA_KIT ='4 Mbit/s' THEN TO_CHAR(4*1024)||'.0'
                        WHEN VELOCITA_TRASMISSIVA_KIT ='6 Mbit/s' THEN TO_CHAR(6*1024)||'.0'
                        WHEN VELOCITA_TRASMISSIVA_KIT ='8 Mbit/s' THEN TO_CHAR(8*1024)||'.0'
                        WHEN VELOCITA_TRASMISSIVA_KIT ='155 Mbit/s' THEN TO_CHAR(155*1024)||'.0'
                        WHEN VELOCITA_TRASMISSIVA_KIT ='34 Mbit/s' THEN TO_CHAR(34*1024)||'.0'
                    END  INTO ATTRIBUTE_VALUE
              from ANAG_KIT where cod_kit = COD_KIT;

               RETURN ATTRIBUTE_VALUE;
           END IF;
     EXCEPTION
        WHEN OTHERS THEN
              ATTRIBUTE_VALUE:=NULL;
        END;
    END IF;
    --FINE_RU_1370


    RETURN ATTRIBUTE_VALUE;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RETURN NULL;
  END BANDA_UTENTE_FINALE;



  FUNCTION CODIFICA_ATTRIBUTO_ASSET (BDS_ASSET_ID IN VARCHAR2,
                                     ATTRIBUTE_NAME IN VARCHAR2,
                                     NOMECOMPONENTE IN VARCHAR2 DEFAULT NULL)

  RETURN VARCHAR2
  IS
    ATTRIBUTE_VALUE BDS_1_CASEDATA_ATTRIBTDTTGLSST.VALOREATTRIBUTO%TYPE;
    V_OFFERTA       BDS_1_CASEDATA_ASSET.OFFERTA%TYPE;
    SQL_STATEMENT  VARCHAR2(1000);
  BEGIN

    BEGIN

      IF NOMECOMPONENTE IS NOT NULL AND NOMECOMPONENTE <> 'ProtocolloUF' THEN
        SQL_STATEMENT := q'xSELECT VALOREATTRIBUTO,ASSET.IDOFFERTA
                                          FROM BDS_1_CASEDATA_ATTRIBTDTTGLSST ATT
                                            JOIN BDS_1_CASEDATA_DETTAGLIOASSET DETT ON ATT.DTTGLSST_TTRBTIDTTGLISST_BDSID = DETT.BDS_ID
                                            JOIN BDS_1_CASEDATA_ASSET ASSET ON ASSET.BDS_ID = DETT.ASSET_DETTAGLIOASSET_BDSID
                                          WHERE ASSET.BDS_ID = :BDS_ASSET_ID
                                            AND ATT.NOMEATTRIBUTO = :ATTRIBUTE_NAME
                                            AND DETT.NOMECOMPONENTE = '$NOMECOMPONENTE'x';

        SQL_STATEMENT := REPLACE (SQL_STATEMENT, '$NOMECOMPONENTE', NOMECOMPONENTE);
      ELSE
        SQL_STATEMENT := 'SELECT VALOREATTRIBUTO,ASSET.IDOFFERTA
                                          FROM BDS_1_CASEDATA_ATTRIBTDTTGLSST ATT
                                            JOIN BDS_1_CASEDATA_ASSET ASSET ON ASSET.IDASSET = ATT.IDASSET
                                          WHERE ASSET.BDS_ID = :BDS_ASSET_ID
                                            AND ATT.NOMEATTRIBUTO = :ATTRIBUTE_NAME';
      END IF;

      SQL_STATEMENT := SQL_STATEMENT || ' FETCH FIRST 1 ROW ONLY';

      EXECUTE IMMEDIATE SQL_STATEMENT
        INTO ATTRIBUTE_VALUE,V_OFFERTA
        USING BDS_ASSET_ID, ATTRIBUTE_NAME;
    EXCEPTION
      WHEN NO_DATA_FOUND THEN ATTRIBUTE_VALUE := NULL;
      WHEN OTHERS THEN RAISE;
    END;

    IF ATTRIBUTE_NAME = 'TECNOLOGIA' THEN
      RETURN 'A';
      /*CASE UPPER(ATTRIBUTE_VALUE)
        WHEN 'SSHDSL'                 THEN RETURN 'X';
        WHEN 'SDSL/SHDSL'             THEN RETURN 'S';
        WHEN 'ADSL'                   THEN RETURN 'A';
        WHEN 'ALTRO CDN (EX HDSL)'    THEN RETURN 'H';
        WHEN 'HSHDSL'                 THEN RETURN 'K';
        WHEN 'SHDSL4F'                THEN RETURN 'G';
        WHEN 'SHDSL6F'                THEN RETURN 'L';
        WHEN 'SHDSL8F'                THEN RETURN 'M';
        WHEN 'SETH'                   THEN RETURN 'E';
        ELSE RETURN NULL;
      END CASE; */
     ELSIF ATTRIBUTE_NAME = 'DESTINAZIONEUSO' THEN
      CASE UPPER(ATTRIBUTE_VALUE)
        WHEN 4     THEN RETURN 50;
        --WHEN 'DECT'     THEN RETURN 51;
        WHEN 5     THEN RETURN 52;
        WHEN 2     THEN RETURN 53;
        WHEN 3     THEN RETURN 54;
        WHEN 1     THEN RETURN 55;
        WHEN 9     THEN RETURN 56;
        WHEN 10    THEN RETURN 60;
        ELSE RETURN ATTRIBUTE_VALUE;
      END CASE;
      ELSIF ATTRIBUTE_NAME = 'CODICEPIATTAFORMA' THEN  --  lotto6 campo SUB_TIPO_LINEA_RESIDENZIALE per WLR
      CASE UPPER(ATTRIBUTE_VALUE)
        WHEN 'RES' THEN RETURN 50;
        ELSE RETURN 51;
      END CASE;
      ELSIF ATTRIBUTE_NAME = 'PROFILOTECNICOLINEA' AND NOMECOMPONENTE = 'ProtocolloUF' THEN --SM_5578
         BEGIN
           SELECT PROTOCOLLO
             INTO ATTRIBUTE_VALUE
             FROM APPUSER.PROFILO_TCNC_LINEA PTL
            WHERE PTL.PROFILO_TCNC_LINEA = ATTRIBUTE_VALUE
              AND ID_OFFERTA = V_OFFERTA;
         EXCEPTION
           WHEN OTHERS THEN
             ATTRIBUTE_VALUE := NULL;
         END;

    END IF;

    RETURN ATTRIBUTE_VALUE;

  END CODIFICA_ATTRIBUTO_ASSET;


  FUNCTION GET_IDUTENTE_FINALE (BDS_ASSET_ID  IN VARCHAR2,
                                SISTEMA       IN VARCHAR2 DEFAULT NULL)

  RETURN VARCHAR2
  IS
    ATTRIBUTE_VALUE BDS_1_CASEDATA_ATTRIBTDTTGLSST.VALOREATTRIBUTO%TYPE;
    ATTRIBUTE_NAME BDS_1_CASEDATA_ATTRIBTDTTGLSST.NOMEATTRIBUTO%TYPE;

    SQL_STATEMENT VARCHAR2(1000) DEFAULT 'SELECT VALOREATTRIBUTO
                                          FROM BDS_1_CASEDATA_ATTRIBTDTTGLSST ATT
                                            JOIN BDS_1_CASEDATA_DETTAGLIOASSET DETT ON ATT.DTTGLSST_TTRBTIDTTGLISST_BDSID = DETT.BDS_ID
                                            JOIN BDS_1_CASEDATA_ASSET ASSET ON ASSET.BDS_ID = DETT.ASSET_DETTAGLIOASSET_BDSID
                                          WHERE ASSET.BDS_ID = :BDS_ASSET_ID
                                            AND ATT.NOMEATTRIBUTO = :ATTRIBUTE_NAME';
    BEGIN
      IF SISTEMA IS NOT NULL AND SISTEMA = 'SISTINA' THEN
        ATTRIBUTE_NAME := 'TIPOLINEA';
        SQL_STATEMENT := SQL_STATEMENT || ' AND DETT.NOMECOMPONENTE = ANY (''ACCESSOATMASIMFLAT'', ''ACCESSOATMASIMHL'', ''ACCESSOATMASIMLITE'', ''ACCESSOGBEASIMFLAT'')';
      END IF;

      SQL_STATEMENT := SQL_STATEMENT || ' FETCH FIRST 1 ROW ONLY';

      EXECUTE IMMEDIATE SQL_STATEMENT
        INTO ATTRIBUTE_VALUE
        USING BDS_ASSET_ID, ATTRIBUTE_NAME;
      RETURN ATTRIBUTE_VALUE;
    EXCEPTION
      WHEN NO_DATA_FOUND
        THEN ATTRIBUTE_VALUE := NULL;
                RETURN ATTRIBUTE_VALUE;
      WHEN OTHERS THEN RAISE;

    RETURN ATTRIBUTE_VALUE;
  END GET_IDUTENTE_FINALE;

  FUNCTION GET_CODE_AREA (DISTRETTO IN VARCHAR2)

  RETURN VARCHAR2
  IS
    MACRO_AREA_VALUE DISTR.MACRO_AREA%TYPE;
    V_DISTRETTO      DISTR.COD_DISTR%TYPE;

    SQL_STATEMENT VARCHAR2(1000) DEFAULT 'SELECT MACRO_AREA
                                            FROM DISTR
                                           WHERE COD_DISTR = :V_DISTRETTO';
    BEGIN

      --Se il DISTRETTO ? diverso da 3 non pu? essere normalizzato quindi restituisco NULL
      IF LENGTH(DISTRETTO) = 3 THEN
         IF LENGTH(DISTRETTO) = 3 AND SUBSTR(DISTRETTO,2,1) IN ('1','5','9') THEN
           V_DISTRETTO := DISTRETTO;
         ELSIF LENGTH(DISTRETTO) = 3 AND SUBSTR(DISTRETTO,3,1) IN ('2','6') THEN
           V_DISTRETTO := SUBSTR(DISTRETTO,2);
         ELSE
           V_DISTRETTO := '0'||DISTRETTO;
         END IF;
      ELSE
        RETURN NULL;
      END IF;

      SQL_STATEMENT := SQL_STATEMENT || ' FETCH FIRST 1 ROW ONLY';

      EXECUTE IMMEDIATE SQL_STATEMENT
        INTO MACRO_AREA_VALUE
        USING V_DISTRETTO;
      RETURN MACRO_AREA_VALUE;
    EXCEPTION
      WHEN NO_DATA_FOUND
        THEN MACRO_AREA_VALUE := NULL;
                RETURN MACRO_AREA_VALUE;
      WHEN OTHERS THEN RAISE;

    RETURN MACRO_AREA_VALUE;
  END GET_CODE_AREA;

  FUNCTION FLAG_QUALIFICA (BITRATE    IN VARCHAR2)
  RETURN VARCHAR2
  DETERMINISTIC
  PARALLEL_ENABLE
  IS
    OUTCOME VARCHAR2(10);
  BEGIN
    IF REGEXP_LIKE(BITRATE, '[[:digit:]]') THEN
      IF TO_NUMBER(BITRATE) < 800 THEN
        OUTCOME := '1';
      ELSE
        OUTCOME := '0';
      END IF;
    END IF;

    RETURN OUTCOME;
  EXCEPTION
    WHEN OTHERS THEN
      RETURN NULL;
  END FLAG_QUALIFICA;

  FUNCTION CODIFICA_ATTRIBUTO_ORDINE (ORD_BDS_ID IN VARCHAR2,
                                      ATTRIBUTE_NAME IN VARCHAR2,
                                      NOMECOMPONENTE IN VARCHAR2 DEFAULT NULL)

  RETURN VARCHAR2
  IS
    ATTRIBUTE_VALUE BDS_1_CASEDATA_ATTRIBTDTTGLRDN.VALOREATTRIBUTO%TYPE;

    SQL_STATEMENT VARCHAR2(1000) DEFAULT 'SELECT VALOREATTRIBUTO
                                          FROM BDS_1_CASEDATA_ATTRIBTDTTGLRDN ATT
                                            JOIN BDS_1_CASEDATA_DETTAGLIOORDINE DETT ON ATT.DTTGLRDN_TTRBTDTTGLIRDIN_BDSID = DETT.BDS_ID
                                            JOIN BDS_1_CASEDATA_ORDINE ORD ON DETT.ORDINE_DETTAGLIOORDINE_BDSID = ORD.BDS_ID
                                          WHERE ORD.BDS_ID = :ORD_BDS_ID
                                            AND ATT.NOMEATTRIBUTO = :ATTRIBUTE_NAME';
  BEGIN

    BEGIN

      IF NOMECOMPONENTE IS NOT NULL THEN
        SQL_STATEMENT := SQL_STATEMENT || ' AND DETT.NOMECOMPONENTE = ''' || NOMECOMPONENTE || '''';
      END IF;

      SQL_STATEMENT := SQL_STATEMENT || ' FETCH FIRST 1 ROW ONLY';

      EXECUTE IMMEDIATE SQL_STATEMENT
        INTO ATTRIBUTE_VALUE
        USING ORD_BDS_ID, ATTRIBUTE_NAME;
    EXCEPTION
      WHEN NO_DATA_FOUND THEN ATTRIBUTE_VALUE := NULL;
      WHEN OTHERS THEN RAISE;
    END;

    IF ATTRIBUTE_NAME = 'STRUTTURALINEA' THEN
      RETURN ATTRIBUTE_VALUE;
    ELSE
      CASE UPPER(ATTRIBUTE_VALUE)
        WHEN 'GNR' THEN RETURN 50;
        WHEN 'PBX' THEN RETURN 55;
        WHEN 'SIMPLEX' THEN RETURN 56;
        ELSE RETURN ATTRIBUTE_VALUE;
      END CASE;
    END IF;

  END CODIFICA_ATTRIBUTO_ORDINE;

  FUNCTION GET_DATE(DATE_STRING IN VARCHAR2)
  RETURN VARCHAR2
  IS
    DATE_FORMATTED VARCHAR2(200);
  BEGIN
    DATE_FORMATTED := 'TO_TIMESTAMP(';
    DATE_FORMATTED := DATE_FORMATTED || APICE || DATE_STRING || APICE || ', ';
    DATE_FORMATTED := DATE_FORMATTED || APICE || kDATEFORMAT || APICE;
    DATE_FORMATTED := DATE_FORMATTED || ')';

    RETURN DATE_FORMATTED;
  END GET_DATE;

  FUNCTION SET_DATE(DATE_STRING IN TIMESTAMP,
                    DATEFORMAT IN VARCHAR2 DEFAULT 'DD/MM/YYYY')
  RETURN VARCHAR2
  DETERMINISTIC
  PARALLEL_ENABLE
  IS
  BEGIN
    RETURN TO_CHAR(DATE_STRING, DATEFORMAT);
  END SET_DATE;

  FUNCTION IDS_OFFERTA (SERVICE IN VARCHAR2)
  RETURN VARCHAR2
  IS
    FIRST_RECORD BOOLEAN DEFAULT TRUE;
    IDS T_IDS_OFFERTA;
    IDS_STRING VARCHAR2(100);
  BEGIN

    BEGIN
      IDS := SERVICE_MAP(SERVICE);
    EXCEPTION
      WHEN NO_DATA_FOUND THEN
        RAISE_APPLICATION_ERROR(-20966, 'IDS OFFERTA NOT FOUND FOR SERVICE ' || SERVICE);
      WHEN OTHERS THEN
        RAISE;
    END;

    FOR I IN 1..IDS.COUNT LOOP
      IF FIRST_RECORD THEN
        IDS_STRING := '(' || IDS(I);
      ELSE
        IDS_STRING := IDS_STRING || ', ' || IDS(I);
      END IF;

      FIRST_RECORD := FALSE;
    END LOOP;

    IDS_STRING := IDS_STRING || ')';
    RETURN IDS_STRING;
  END IDS_OFFERTA;

-- Lotto5 x ID128 (F1_TD_INNOVATIVA)
  FUNCTION GET_COMUNE (ASSET_COD_TOPON IN BDS_1_CASEDATA_ASSET.CODICETOPONOMASTICA%TYPE)
  RETURN COMUNE_O_LOCALITA.DESCR_COMUNE%TYPE
  DETERMINISTIC
  PARALLEL_ENABLE
  IS
    COMUNE COMUNE_O_LOCALITA.DESCR_COMUNE%TYPE;
  BEGIN
    SELECT DISTINCT COMLOC.DESCR_COMUNE
    INTO COMUNE
    FROM BDS_1_CASEDATA_ASSET ASSET JOIN NUMERO_CIVICO NUMCIV ON ASSET.CODICETOPONOMASTICA = NUMCIV.COD_TOPON
    JOIN VIA ON NUMCIV.COD_STRADA=VIA.COD_STRADA
    JOIN COMUNE_O_LOCALITA COMLOC ON VIA.COD_ISTAT_COMUNE=COMLOC.COD_ISTAT_COMUNE AND COMLOC.FLAG_COMUNE='S'
    WHERE ASSET.CODICETOPONOMASTICA = ASSET_COD_TOPON;
    RETURN COMUNE;
  EXCEPTION WHEN NO_DATA_FOUND THEN
    LOG('** WARNING LA FUNCTION GET_COMUNE NON RESTITUISCE VALORI **');
    RETURN NULL;
  END GET_COMUNE;

  FUNCTION GET_FLAG_TRASPORTO (OFFERTA IN BDS_1_CASEDATA_ASSET.OFFERTA%TYPE,
                               BDS_ID IN BDS_1_CASEDATA_ASSET.BDS_ID%TYPE)
  RETURN NUMBER
  DETERMINISTIC
  PARALLEL_ENABLE
  IS
    FLAG_TRASPORTO NUMBER;
  BEGIN
    SELECT CASE
            WHEN UPPER(OFFERTA) IN ('BITSTREAMATMASIMMETRICOFLAT', 'BITSTREAMATMASIMMETRICOHL', 'BITSTREAMATMASIMMETRICOLITE','BITSTREAMATMSIMMETRICOFLAT','BITSTREAMATMSIMMETRICOHL') THEN -- ESTENSIONE A SIMMETRICI S7
              CASE
                WHEN UPPER(PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET (BDS_ID, 'TRASPORTO', 'ATMVC')) = 'ASSENTE' THEN 0
                WHEN UPPER(PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET (BDS_ID, 'TRASPORTO', 'ATMVC')) = 'PRESENTE' THEN 1
                ELSE 0
              END
            WHEN UPPER(OFFERTA) IN ('BITSTREAMGBEASIMMETRICOFLAT','BITSTREAMGBESIMMETRICOFLAT') -- ESTENSIONE A SIMMETRICI S7
              THEN DECODE(PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET (BDS_ID, 'TIPOTRASPORTO', 'GBEVC'), NULL, 0, 1)
            ELSE NULL
           END
    INTO FLAG_TRASPORTO
    FROM DUAL;

   RETURN FLAG_TRASPORTO;
  END GET_FLAG_TRASPORTO;

  FUNCTION GET_PROF_COMM_BS (IDOFFERTA    IN BDS_1_CASEDATA_ASSET.IDOFFERTA%TYPE,
                             BDS_ID       IN BDS_1_CASEDATA_ASSET.BDS_ID%TYPE,
                             DIRECTION    IN VARCHAR2)
  RETURN VARCHAR2
  DETERMINISTIC
  PARALLEL_ENABLE
  IS
    PROF_TCNC_LINEA PROFILO_TCNC_LINEA.PROFILO_TCNC_LINEA%TYPE;
    RETURN_VALUE VARCHAR2(500);
    SELECT_COL VARCHAR2(100);
    SQL_SELECT VARCHAR2(500);
  BEGIN
  SELECT PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET (BDS_ID, 'PROFILOTECNICOLINEA') INTO PROF_TCNC_LINEA FROM DUAL;

    CASE DIRECTION
    WHEN 'UP'       THEN SELECT_COL := 'PROFILO_COMMERCIALE_UP';
    WHEN 'DOWN'     THEN SELECT_COL := 'PROFILO_COMMERCIALE_DOWN';
    WHEN 'ACCESSO'  THEN SELECT_COL := 'MODELLO_ACCS'; --SM_3936
  END CASE;

  SQL_SELECT := 'SELECT '||SELECT_COL|| ' FROM PROFILO_TCNC_LINEA PROFT WHERE PROFT.PROFILO_TCNC_LINEA = '''||PROF_TCNC_LINEA||''' AND PROFT.ID_OFFERTA = '||IDOFFERTA;
  SQL_SELECT := SQL_SELECT || ' FETCH FIRST 1 ROW ONLY';
  EXECUTE IMMEDIATE SQL_SELECT INTO RETURN_VALUE;
  RETURN RETURN_VALUE;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      LOG('** WARNING LA FUNCTION GET_PROF_COMM_BS NON RESTITUISCE VALORI **');
      RETURN NULL;
    WHEN OTHERS THEN
      RAISE;
  END GET_PROF_COMM_BS;

--/ Lotto5
  PROCEDURE FETCH_AND_WRITE (SQL_STATEMENT IN VARCHAR2,
                             FILENAME IN VARCHAR2)
  IS
    TYPE T_SPOOL_ROWS IS TABLE OF tROW;
    SPOOL_ROWS T_SPOOL_ROWS;
    SPOOL_BUFFER VARCHAR2(32767);

    RESULTSET SYS_REFCURSOR;
    SPOOL_FILE UTL_FILE.FILE_TYPE;
    RECORDS_WRITTEN PLS_INTEGER DEFAULT 0;
    FIRST_RECORD BOOLEAN DEFAULT TRUE;
  BEGIN

    --SECURITY CHECK FOR BUFFER SIZES
    IF 32767 < LINES_BLOCK * (2000 + LENGTH(NEW_LINE)) THEN
      RAISE_APPLICATION_ERROR(-20981, 'BUFFER VARIABLE TOO BIG');
    END IF;

    LOG('   OPENING SPOOL FILE: ' || DEFAULT_DIR || FILENAME);
    SPOOL_FILE := SYS.UTL_FILE.FOPEN(DEFAULT_DIR_OBJECT, FILENAME, 'w', 32767);

    LOG('   EXECUTING QUERY');

    OPEN RESULTSET FOR SQL_STATEMENT;

    LOOP
      FETCH RESULTSET BULK COLLECT INTO SPOOL_ROWS LIMIT LINES_BLOCK;

      FOR I IN 1..SPOOL_ROWS.COUNT LOOP
        LOG ('   WRITING RECORD: ' || SPOOL_ROWS(I));
        IF FIRST_RECORD THEN
          SPOOL_BUFFER := SPOOL_ROWS(I);
        ELSE
          SPOOL_BUFFER := SPOOL_BUFFER || NEW_LINE || SPOOL_ROWS(I);
        END IF;

        RECORDS_WRITTEN := RECORDS_WRITTEN + 1;
        FIRST_RECORD := FALSE;
      END LOOP;

      SYS.UTL_FILE.PUT(SPOOL_FILE, SPOOL_BUFFER);
      SYS.UTL_FILE.FFLUSH(SPOOL_FILE);

      EXIT WHEN RESULTSET%NOTFOUND;
    END LOOP;

    SYS.UTL_FILE.FCLOSE(SPOOL_FILE);

    LOG('   FILE CLOSED');
    LOG('   TOTAL RECORDS WRITTEN: ' || RECORDS_WRITTEN);
  END FETCH_AND_WRITE;

  PROCEDURE FETCH_AND_COMMIT (SQL_STATEMENT IN VARCHAR2,
                              IDFILE_IN     IN NUMBER,
                              FILENAME      IN VARCHAR2,
                              SERVICE       IN tSERVICE,
                              SEPARATOR     IN VARCHAR2,
                              OPTIONAL_IN1 IN VARCHAR2 DEFAULT NULL,
                              OPTIONAL_IN2 IN VARCHAR2 DEFAULT NULL)
  IS
    TYPE T_SPOOL_ROWS IS TABLE OF tROW;
    SPOOL_ROWS T_SPOOL_ROWS;

    RESULTSET SYS_REFCURSOR;
    RECORDS_WRITTEN     PLS_INTEGER DEFAULT 0;
    ADDITIONAL_RECORDS  PLS_INTEGER DEFAULT 0;
    ADDITIONAL_ROW tROW;
	v_count Number:=0; -- Task.44881
  BEGIN

    LOG('   OPENING SPOOL FOR FILE: ' || FILENAME);
    LOG('   CLEANING ESTRAZIONI TABLE');

/*
    DELETE FROM ESTRAZIONI ES
    WHERE ES.ID_FILE = IDFILE_IN;
    COMMIT;
*/
  -- DBMS_OUTPUT.PUT_LINE('SQL 11  :' || SQL_STATEMENT);
    LOG('   CHECKING HEADERS');
    IF SERVICE IN (SERVICE_RAC, SERVICE_SISTINA, SERVICE_SISTINA_VULL_NOT_NULL) THEN
      ADDITIONAL_ROW := HEADER_ROW(SERVICE, SEPARATOR, OPTIONAL_IN1, OPTIONAL_IN2);
    ELSE
      ADDITIONAL_ROW := HEADER_ROW(SERVICE, SEPARATOR);
    END IF;

    IF ADDITIONAL_ROW IS NOT NULL THEN
      ADDITIONAL_RECORDS := ADDITIONAL_RECORDS + 1;
      INSERT INTO ESTRAZIONI
          (CREATED,
           SEQUENZA,
           NOME_FILE,
           ID_FILE,
           RIGA)
        VALUES
          (SYSTIMESTAMP,
           ADDITIONAL_RECORDS,
           FILENAME,
           IDFILE_IN,
           ADDITIONAL_ROW);
    END IF;

    LOG('   EXECUTING QUERY');

    OPEN RESULTSET FOR SQL_STATEMENT;

    LOOP
      FETCH RESULTSET BULK COLLECT INTO SPOOL_ROWS LIMIT LINES_BLOCK;

      FOR I IN 1..SPOOL_ROWS.COUNT LOOP
        LOG ('   WRITING RECORD: ' || SPOOL_ROWS(I));

        RECORDS_WRITTEN := RECORDS_WRITTEN + 1;

        INSERT INTO ESTRAZIONI
          (CREATED,
           SEQUENZA,
           NOME_FILE,
           ID_FILE,
           RIGA)
        VALUES
          (SYSTIMESTAMP,
           ADDITIONAL_RECORDS + RECORDS_WRITTEN,
           FILENAME,
           IDFILE_IN,
           SPOOL_ROWS(I));

		-- Task.44881
		v_count:=v_count+1;
		if mod(v_count,1000)=0 Then
			Commit;
		End If;
      END LOOP;

      COMMIT;

      EXIT WHEN RESULTSET%NOTFOUND;
    END LOOP;

    LOG('   CHECKING FOOTER ROW');
    IF SERVICE IN (SERVICE_RAC, SERVICE_SISTINA, SERVICE_SISTINA_VULL_NOT_NULL) THEN
      ADDITIONAL_ROW := FOOTER_ROW(SERVICE, SEPARATOR, RECORDS_WRITTEN, OPTIONAL_IN1, OPTIONAL_IN2);
    ELSE
      ADDITIONAL_ROW := FOOTER_ROW(SERVICE, SEPARATOR, OPTIONAL_IN1 => RECORDS_WRITTEN);
    END IF;

    IF ADDITIONAL_ROW IS NOT NULL THEN
      INSERT INTO ESTRAZIONI
          (CREATED,
           SEQUENZA,
           NOME_FILE,
           ID_FILE,
           RIGA)
        VALUES
          (SYSTIMESTAMP,
           ADDITIONAL_RECORDS + RECORDS_WRITTEN + 1,
           FILENAME,
           IDFILE_IN,
           ADDITIONAL_ROW);
    END IF;

    LOG('   TABLE WRITTEN');
    LOG('   TOTAL RECORDS WRITTEN: ' || RECORDS_WRITTEN);
  EXCEPTION
    WHEN OTHERS THEN
       DBMS_OUTPUT.PUT_LINE('SQL  :' || SQL_STATEMENT);
       RAISE_APPLICATION_ERROR(-20999, 'ERROR IN MODULE [FETCH_AND_COMMIT]: ' || SQLERRM);
  END FETCH_AND_COMMIT;


  FUNCTION JOIN_TABLES(SERVICE IN VARCHAR2)
  RETURN VARCHAR2
  IS
    JOIN_TABLES_ASSET VARCHAR2(2000) DEFAULT ' LEFT JOIN BDS_1_CASEDATA_ORDINE ORD ON ASSET.IDRICHIESTAOLO = ORD.IDRICHIESTAOLO
        LEFT JOIN BDS_1_CASEDATA_RICHIESTA RICH ON ASSET.IDRICHIESTAOLO = RICH.IDRICHIESTAOLO  --SM_2907 Inserite Outer join e modificato legame tra offerta e asset
        LEFT OUTER JOIN TRASCODFC_OFFERTA TSO ON NOME_OFFERTA_ESTERNA = ASSET.OFFERTA AND PROVENIENZA = ''BPM''
        JOIN OFFERTA OFF on TSO.ID_OFFERTA=off.id_offerta
        LEFT JOIN CONTRATTO AGREE ON AGREE.ID_CONTRATTO = ASSET.IDCONTRATTO' || CHR(10);

    JOIN_TABLES_ASSET_NO_LEFT_JOIN VARCHAR2(2000) DEFAULT ' JOIN BDS_1_CASEDATA_ORDINE ORD ON ASSET.IDRICHIESTAOLO = ORD.IDRICHIESTAOLO
        LEFT JOIN BDS_1_CASEDATA_RICHIESTA RICH ON ASSET.IDRICHIESTAOLO = RICH.IDRICHIESTAOLO  --SM_2907 Inserite Outer join e modificato legame tra offerta e asset
        LEFT OUTER JOIN TRASCODFC_OFFERTA TSO ON NOME_OFFERTA_ESTERNA = ASSET.OFFERTA AND PROVENIENZA = ''BPM''
        JOIN OFFERTA OFF on TSO.ID_OFFERTA=off.id_offerta
        LEFT JOIN CONTRATTO AGREE ON AGREE.ID_CONTRATTO = ASSET.IDCONTRATTO' || CHR(10);

    JOIN_TABLES_ORDINI VARCHAR2(4000) DEFAULT '  RIGHT OUTER JOIN BDS_1_CASEDATA_RICHIESTA RICH ON ORD.IDRICHIESTAOLO = RICH.IDRICHIESTAOLO
        -- JOIN BDS_1_CASEDATA_ASSET ASSET ON ASSET.IDRICHIESTAOLO = ORD.IDRICHIESTAOLO -- S7
        LEFT OUTER JOIN ANAG_CAUS CAUS ON RICH.IDANAGRAFICACAUSALE = CAUS.ID_ANAG_CAUS --S7
        LEFT OUTER JOIN SISTEMA ON SISTEMA.ID_SISTEMA = CAUS.ID_SISTEMA -- RU_543
        JOIN OFFERTA OFF ON OFF.ID_OFFERTA = RICH.IDOFFERTA' || CHR(10);

  --aggiunto il 18/01/2016  SM 2129
    JOIN_TABLES_ORDINIREGIA0_KO VARCHAR2(2000) DEFAULT ' RIGHT JOIN BDS_1_CASEDATA_RICHIESTA RICH ON ORD.IDRICHIESTAOLO = RICH.IDRICHIESTAOLO
        LEFT JOIN ANAG_CAUS CAUS ON RICH.IDANAGRAFICACAUSALE = CAUS.ID_ANAG_CAUS
        JOIN OFFERTA OFF ON OFF.ID_OFFERTA = RICH.IDOFFERTA
        JOIN TRASCODFC_OFFERTA TRO ON TRO.ID_OFFERTA = OFF.ID_OFFERTA AND TRO.PROVENIENZA = ''OUTPUT'' ' || CHR(10);

  -- Lotto5 -- Numero Aggiuntivo per ORDINI
  JOIN_TABLES_ORDINI_NUMAGG VARCHAR2(2000) DEFAULT ' LEFT JOIN (SELECT ATT_NUMERO.BDS_ID ATT_ID, ATT_NUMERO.DTTGLRDN_TTRBTDTTGLIRDIN_BDSID DETT_ID, ORDINE.BDS_ID ORD_ID, DETT.NOMECOMPONENTE, ATT_NUMERO.NOMEATTRIBUTO,
         ATT_NUMERO.VALOREATTRIBUTO NUMEROAGGIUNTIVO, ATT_STATO.NOMEATTRIBUTO STATO, ATT_STATO.VALOREATTRIBUTO VALORE_STATO, ORDINE.OFFERTA
          FROM BDS_1_CASEDATA_ATTRIBTDTTGLRDN ATT_NUMERO
            JOIN BDS_1_CASEDATA_ATTRIBTDTTGLRDN ATT_STATO ON ATT_NUMERO.DTTGLRDN_TTRBTDTTGLIRDIN_BDSID = ATT_STATO.DTTGLRDN_TTRBTDTTGLIRDIN_BDSID
            JOIN BDS_1_CASEDATA_DETTAGLIOORDINE DETT ON ATT_STATO.DTTGLRDN_TTRBTDTTGLIRDIN_BDSID = DETT.BDS_ID
            JOIN BDS_1_CASEDATA_ORDINE ORDINE ON DETT.ORDINE_DETTAGLIOORDINE_BDSID = ORDINE.BDS_ID
          WHERE
            (ORDINE.OFFERTA = ''NP''
                                   AND DETT.NOMECOMPONENTE = ''NUMERIAGGIUNTIVI''
                                   AND ATT_NUMERO.NOMEATTRIBUTO = ''NUMEROTELEFONICO''
                                   AND ATT_STATO.NOMEATTRIBUTO = ''STATO''
                                   AND UPPER(ATT_STATO.VALOREATTRIBUTO) = ''ATTIVO'')
            OR (ORDINE.OFFERTA IN (''WLR'', ''WLRLINEAATTIVA'', ''WLRLINEANONATTIVA'', ''VULL'', ''VULLLINEANONATTIVA'')
                                   AND DETT.NOMECOMPONENTE = ''AGGIUNTIVO''
                                   AND ATT_NUMERO.NOMEATTRIBUTO = ''NUMEROTELEFONICO''
                                   AND ATT_STATO.NOMEATTRIBUTO = ''STATO''
                                   AND UPPER(ATT_STATO.VALOREATTRIBUTO) = ''ATTIVO'')
            OR (ORDINE.OFFERTA IN (''ULLLINEAATTIVA'', ''ULLDATILINEAATTIVA'', ''SLULINEAATTIVA'',
                                ''ULLLINEAATTIVANP'', ''ULLDATILINEAATTIVANP'', ''SLULINEAATTIVANP'')
                                   AND DETT.NOMECOMPONENTE = ''NUMBERPORTABILITY''
                                   AND ATT_NUMERO.NOMEATTRIBUTO = ''NUMEROTELEFONICO''))
           NP_NUMAGG ON NP_NUMAGG.ORD_ID = ORD.BDS_ID' || CHR(10);

  -- Numero Aggiuntivo DEDICATO per NP-SLU-ULL-ULLD (ASSET)
  JOIN_TABLES_NP_NUMAGG VARCHAR2(2000) DEFAULT ' LEFT JOIN (with numtel as (select PRINC.BDS_ID, PRINC.NUMEROTELEFONICO NUMEROPRINCIPALE,  AGGIUNT.NUMEROTELEFONICO NUMEROAGGIUNTIVO from bds_1_casedata_asset PRINC
        LEFT JOIN bds_1_casedata_asset AGGIUNT on PRINC.NUMEROTELEFONICO=AGGIUNT.NUMTELPRINCIPALE) select * from numtel
        where numtel.numeroprincipale not in (select numtel.numeroaggiuntivo from numtel where numeroaggiuntivo is not null)) numtelefonico
       on ASSET.numerotelefonico=NVL(numtelefonico.NUMEROAGGIUNTIVO, numtelefonico.NUMEROPRINCIPALE)' || CHR(10);
  --/ Lotto5

  -- Lotto6 -- Numero Aggiuntivo per ASSET (WLR e VULL)
  JOIN_TABLES_ASSET_NUMAGG VARCHAR2(2000) DEFAULT ' LEFT JOIN (SELECT ATT_NUMERO.BDS_ID ATT_ID, ATT_NUMERO.DTTGLSST_TTRBTIDTTGLISST_BDSID DETT_ID, ASSET.BDS_ID ASSET_ID, DETT.NOMECOMPONENTE, ATT_NUMERO.NOMEATTRIBUTO,
         ATT_NUMERO.VALOREATTRIBUTO NUMEROAGGIUNTIVO, ATT_STATO.NOMEATTRIBUTO STATO, ATT_STATO.VALOREATTRIBUTO VALORE_STATO, ASSET.OFFERTA
          FROM BDS_1_CASEDATA_ATTRIBTDTTGLSST ATT_NUMERO
            JOIN BDS_1_CASEDATA_ATTRIBTDTTGLSST ATT_STATO ON ATT_NUMERO.DTTGLSST_TTRBTIDTTGLISST_BDSID = ATT_STATO.DTTGLSST_TTRBTIDTTGLISST_BDSID
            JOIN BDS_1_CASEDATA_DETTAGLIOASSET DETT ON ATT_STATO.DTTGLSST_TTRBTIDTTGLISST_BDSID = DETT.BDS_ID
            JOIN BDS_1_CASEDATA_ASSET ASSET ON DETT.ASSET_DETTAGLIOASSET_BDSID = ASSET.BDS_ID
          WHERE DETT.NOMECOMPONENTE = ''AGGIUNTIVO''
           AND ATT_NUMERO.NOMEATTRIBUTO = ''NUMEROTELEFONICO''
           AND ATT_STATO.NOMEATTRIBUTO = ''STATO''
           AND ATT_STATO.VALOREATTRIBUTO = ''ATTIVO'') ASSET_NUMAGG ON ASSET_NUMAGG.ASSET_ID = ASSET.BDS_ID' || CHR(10);

  -- Ricerca STS per i WLR
  JOIN_TABLES_STS_WLR VARCHAR2(2000) DEFAULT '  JOIN (SELECT DETT.BDS_ID DETT_BDS_ID, ATT_STS.BDS_ID ATT_ID, ATT_STS.DTTGLSST_TTRBTIDTTGLISST_BDSID DETT_ID, --SM_4173 ELIMINATA LEFT JOIN
          ASSET.BDS_ID ASSET_ID, DETT.NOMECOMPONENTE, ATT_STS.NOMEATTRIBUTO, ATT_STS.VALOREATTRIBUTO PROD_NAME
          FROM BDS_1_CASEDATA_ATTRIBTDTTGLSST ATT_STS
            JOIN BDS_1_CASEDATA_DETTAGLIOASSET DETT ON ATT_STS.DTTGLSST_TTRBTIDTTGLISST_BDSID = DETT.BDS_ID
            JOIN BDS_1_CASEDATA_ASSET ASSET ON DETT.ASSET_DETTAGLIOASSET_BDSID = ASSET.BDS_ID
          WHERE DETT.NOMECOMPONENTE = ''STS''
           AND ATT_STS.NOMEATTRIBUTO = ''DESCRIZIONE'') STS_WLR ON STS_WLR.ASSET_ID = ASSET.BDS_ID' || CHR(10);
   --/ Lotto6

  BEGIN
    CASE
      -- Luca Abbate, Aggiunti SERVICE_NP (RA, RAES), SERVICE_INC_NPG (INCONTRA) per Lotto5  --
      -- Luca Abbate, Aggiunti SERVICE_VULL, SERVICE_STS_WLR, SERVICE_STS_WLR, SERVICE_SHA, SERVICE_INCONTRA per Lotto6 --
      WHEN SERVICE IN (SERVICE_ULL, SERVICE_ULLD, SERVICE_SLU, F1_TD_INNOV,  F1_TD_INNOV_NISIDA, SERVICE_ULL_RI, SERVICE_ULLD_RI, SERVICE_SLU_RI, SERVICE_ATM_RI,
                       SERVICE_GBE_RI, SERVICE_EASYIP_RI, SERVICE_VULA_RI, ULISSE_TD_F1, SERVICE_NP, SERVICE_INCONTRA, SERVICE_VULL, SERVICE_WLR,
                       SERVICE_STS_WLR, SERVICE_SHA, SERVICE_VULL_RI, SERVICE_WLR_RI, SERVICE_SHA_RI) THEN
        IF SERVICE IN (F1_TD_INNOV, F1_TD_INNOV_NISIDA) THEN
          JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || q'x  JOIN BDS_1_CASEDATA_DETTAGLIOASSET DETT ON DETT.ASSET_DETTAGLIOASSET_BDSID = ASSET.BDS_ID AND DETT.NOMECOMPONENTE = ANY ('x' || VC_USER_COMPONENTE || q'x', 'x' || VLAN_COMPONENTE || q'x', 'x' || VC_ATM_COMPONENTE || q'x')x' || CHR(10);
          --JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || q'x  JOIN BDS_1_CASEDATA_ATTRIBTDTTGLSST ATTR ON ATTR.DTTGLSST_TTRBTIDTTGLISST_BDSID = DETT.BDS_ID AND ATTR.NOMEATTRIBUTO = ANY ('x' || VC_USER_ATTRIBUTO || q'x', 'x' || VLAN_ATTRIBUTO || q'x', 'x' || VC_ATM_ATTRIBUTO || q'x')x' || CHR(10);
          IF SERVICE IN (F1_TD_INNOV, F1_TD_INNOV_NISIDA) THEN
            JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || '  JOIN OLO ON OLO.CODFC_OLO_AGCOM = ASSET.CODIFICAOLOAGCOM' || CHR(10);
            JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || q'x  LEFT OUTER JOIN ANAG_VP AN_VP ON PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'CODICEVP') = AN_VP.COD_VPx' || CHR(10);
            JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || '  LEFT OUTER JOIN TRASCODFC_OFFERTA T_OFF ON ASSET.IDOFFERTA=T_OFF.ID_OFFERTA AND T_OFF.PROVENIENZA = ''OUTPUT'' ' || CHR(10); -- SERVIZIO S7
            JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || q'x  LEFT OUTER JOIN PROFILO_VC PROF_VC ON PROF_VC.ID_PRFL_VC = TO_NUMBER(PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'IDPROFILOVC'), '999999999.9')x' || CHR(10);
            JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || '  OUTER APPLY (SELECT tipologialavorazione FROM BDS_1_CASEDATA_ORDINE ULTIMO WHERE ULTIMO.IDRISORSA = ASSET.IDRISORSA ORDER BY ULTIMO.CREATED DESC FETCH FIRST 1 ROWS ONLY) ULT_ORD' || CHR(10);
          END IF;
        ELSIF SERVICE = SERVICE_INCONTRA THEN --SM_4034
          JOIN_TABLES_ASSET_NO_LEFT_JOIN := JOIN_TABLES_ASSET_NO_LEFT_JOIN || '  JOIN OLO ON OLO.CODFC_OLO_AGCOM = ASSET.CODIFICAOLOAGCOM' || CHR(10); --SM_4034
          JOIN_TABLES_ASSET_NO_LEFT_JOIN := JOIN_TABLES_ASSET_NO_LEFT_JOIN || '  LEFT OUTER JOIN TIPOLG_SOTTO_LAVRZ TIP_S_LAV ON TIP_S_LAV.DESCR = ORD.TIPOLOGIASOTTOLAV' || CHR(10); -- SM_5000 TIPOLOGIA SOTTOLAVORAZIONE GUI
          JOIN_TABLES_ASSET := JOIN_TABLES_ASSET_NO_LEFT_JOIN;
        ELSIF SERVICE = ULISSE_TD_F1 THEN
          JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || q'x  JOIN BDS_1_CASEDATA_DETTAGLIOASSET DETT ON DETT.ASSET_DETTAGLIOASSET_BDSID = ASSET.BDS_ID AND DETT.NOMECOMPONENTE = 'x' || VC_ATM_COMPONENTE || q'x'x' || CHR(10);
          JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || q'x  LEFT OUTER JOIN TRASCODFC_OFFERTA TSO_OUT ON OFF.ID_OFFERTA = TSO_OUT.ID_OFFERTA AND TSO_OUT.PROVENIENZA = 'OUTPUT'x' || CHR(10);
          JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || '  JOIN OLO ON OLO.CODFC_OLO_AGCOM = ASSET.CODIFICAOLOAGCOM' || CHR(10);
          JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || q'x LEFT OUTER JOIN ANAG_VP AN_VP ON PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'CODICEVP') = AN_VP.COD_VPx' || CHR(10);
          --JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || '  JOIN TIPOLG_PAGAMENTO_ACCS PAG ON PAG.IDTPLG_PAGAMENTO_ACCS = OFF.IDTPLG_PAGAMENTO_ACCS' || CHR(10);
          JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || q'x LEFT OUTER JOIN PROFILO_VC PROF_VC ON TO_NUMBER(PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'IDPROFILOVC'), '999999999.9') = PROF_VC.ID_PRFL_VCx' || CHR(10);
          JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || '  OUTER APPLY (SELECT tipologialavorazione FROM BDS_1_CASEDATA_ORDINE ULTIMO WHERE ULTIMO.IDRISORSA = ASSET.IDRISORSA ORDER BY ULTIMO.CREATED DESC FETCH FIRST 1 ROWS ONLY) ULT_ORD' || CHR(10);
        ELSIF SERVICE IN (SERVICE_ULL_RI, SERVICE_ULLD_RI, SERVICE_SLU_RI, SERVICE_ATM_RI, SERVICE_GBE_RI, SERVICE_EASYIP_RI, SERVICE_VULA_RI) THEN
          JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || '  LEFT OUTER JOIN TIPOLG_CONTRATTO TPL_CON ON TPL_CON.IDTPLG_CONTRATTO = AGREE.IDTPLG_CONTRATTO' || CHR(10);
          --JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || '  JOIN EVENTO_ORDN_NOW_WHLS EVENT ON EVENT.ID_RICH_OLO = ORD.IDRICHIESTAOLO' || CHR(10);
          JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || '  JOIN OLO ON OLO.CODFC_OLO_AGCOM = ASSET.CODIFICAOLOAGCOM' || CHR(10);
          IF SERVICE = SERVICE_VULA_RI THEN
            JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || ' LEFT OUTER JOIN PROFILO_TCNC_LINEA PROF ON PROF.ID_OFFERTA = OFF.ID_OFFERTA' || CHR(10);
          --ELSIF SERVICE = SERVICE_EASYIP_RI THEN
          --JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || '  JOIN TIPOLG_PAGAMENTO_ACCS PAG ON PAG.IDTPLG_PAGAMENTO_ACCS = OFF.IDTPLG_PAGAMENTO_ACCS' || CHR(10);
          END IF;
        ELSIF SERVICE IN (SERVICE_WLR,SERVICE_VULL) THEN
          JOIN_TABLES_ASSET := JOIN_TABLES_ASSET_NUMAGG || JOIN_TABLES_ASSET;
           JOIN_TABLES_ASSET := JOIN_TABLES_ASSET|| '  LEFT JOIN TIPOLG_RICH_COMSTNOW TIP_RICH ON RICH.STATORICHIESTANOW=TIP_RICH.STATO_RICH_NOW' || CHR(10); -- SM_4022 STATO RICHIESTA NOW -- SM_4173 AGG LEFT JOIN
        ELSIF SERVICE = SERVICE_STS_WLR THEN
          JOIN_TABLES_ASSET := JOIN_TABLES_STS_WLR || JOIN_TABLES_ASSET;
           JOIN_TABLES_ASSET := JOIN_TABLES_ASSET|| '  LEFT JOIN TIPOLG_RICH_COMSTNOW TIP_RICH ON RICH.STATORICHIESTANOW=TIP_RICH.STATO_RICH_NOW' || CHR(10); -- SM_4022 STATO RICHIESTA NOW -- SM_4173 AGG LEFT JOIN
        ELSIF SERVICE = SERVICE_SHA THEN
        JOIN_TABLES_ASSET := JOIN_TABLES_ASSET|| ' LEFT JOIN TIPOLG_RICH_COMSTNOW TIP_RICH ON RICH.STATORICHIESTANOW=TIP_RICH.STATO_RICH_NOW' || CHR(10); -- SM_4022 STATO RICHIESTA NOW --SM_4577 INTRODOTTA LEFT JOIN
        ELSIF SERVICE = SERVICE_NP THEN
          JOIN_TABLES_ASSET := JOIN_TABLES_ASSET|| ' LEFT JOIN TIPOLG_RICH_COMSTNOW TIP_RICH ON RICH.STATORICHIESTANOW=TIP_RICH.STATO_RICH_NOW' || CHR(10);
          JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || q'x LEFT JOIN BDS_1_CASEDATA_ASSET ASSETS ON ASSET.NUMEROTELEFONICO = ASSETS.NUMTELPRINCIPALE AND ASSETS.OFFERTA = 'NP'x' || CHR(10);
        ELSIF SERVICE IN (SERVICE_ULL, SERVICE_ULLD, SERVICE_SLU) THEN
          JOIN_TABLES_ASSET := JOIN_TABLES_ASSET|| ' LEFT JOIN TIPOLG_RICH_COMSTNOW TIP_RICH ON RICH.STATORICHIESTANOW=TIP_RICH.STATO_RICH_NOW' || CHR(10); -- SM_4022 STATO RICHIESTA NOW  --SM_4577 INTRODOTTA LEFT JOIN
          JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || q'x LEFT OUTER JOIN BDS_1_cASEDATA_ASSET AGGIUNTIVO ON (AGGIUNTIVO.NUMTELPRINCIPALE = ASSET.NUMEROTELEFONICO AND ASSET.IDRISORSA <> AGGIUNTIVO.NUMEROTELEFONICO)x' || CHR(10);
        END IF;
        RETURN JOIN_TABLES_ASSET;
      WHEN SERVICE IN (SERVICE_BSATM, SERVICE_BSGBE, SERVICE_EASYIP) THEN
        -- JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || '  LEFT OUTER JOIN PROFILO_TCNC_LINEA PROF ON PROF.ID_OFFERTA = OFF.ID_OFFERTA' || CHR(10);
        JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || '  LEFT OUTER JOIN TIPOLG_CONTRATTO TPL_CON ON TPL_CON.IDTPLG_CONTRATTO = AGREE.IDTPLG_CONTRATTO' || CHR(10);
        JOIN_TABLES_ASSET := JOIN_TABLES_ASSET|| ' LEFT JOIN TIPOLG_RICH_COMSTNOW TIP_RICH ON RICH.STATORICHIESTANOW=TIP_RICH.STATO_RICH_NOW' || CHR(10); -- SM_4022 STATO RICHIESTA NOW --SM_4577 INTRODOTTA LEFT JOIN
        IF SERVICE = SERVICE_EASYIP THEN
          JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || '  LEFT OUTER JOIN ANAG_CAUS CAUS ON RICH.IDANAGRAFICACAUSALE = CAUS.ID_ANAG_CAUS' || CHR(10);
        END IF;
        IF SERVICE = SERVICE_BSATM THEN -- SM_2746
          JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || '  LEFT OUTER JOIN TIPOLG_SOTTO_LAVRZ TIP_S_LAV ON TIP_S_LAV.DESCR = ORD.TIPOLOGIASOTTOLAV' || CHR(10); --  TIPOLOGIA SOTTOLAVORAZIONE GUI
        END IF;
        JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || ' OUTER APPLY (select tipologialavorazione from BDS_1_CASEDATA_ORDINE cdo where idrisorsa = ASSET.IDRISORSA order by created desc FETCH FIRST 1 ROWS ONLY) ULTIMA_LAV' || CHR(10);
        RETURN JOIN_TABLES_ASSET;
      WHEN SERVICE = SERVICE_SISTINA THEN
        JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || q'x  JOIN BDS_1_CASEDATA_DETTAGLIOASSET DETT ON DETT.ASSET_DETTAGLIOASSET_BDSID = ASSET.BDS_ID AND DETT.NOMECOMPONENTE = 'x' || VC_ATM_COMPONENTE || q'x'x' || CHR(10);
        JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || q'x  JOIN BDS_1_CASEDATA_ATTRIBTDTTGLSST ATTR ON ATTR.DTTGLSST_TTRBTIDTTGLISST_BDSID = DETT.BDS_ID AND ATTR.NOMEATTRIBUTO = 'x' || VC_ATM_ATTRIBUTO || q'x'x' || CHR(10);
        --JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || '  JOIN TIPOLG_PAGAMENTO_ACCS PAG ON PAG.IDTPLG_PAGAMENTO_ACCS = OFF.IDTPLG_PAGAMENTO_ACCS' || CHR(10);
        RETURN JOIN_TABLES_ASSET;
      WHEN SERVICE= SERVICE_SISTINA_VULL_NOT_NULL THEN -- RU_371 INIZIO
       JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || '  JOIN BDS_1_CASEDATA_CLIENTE CLIENTE ON CLIENTE.ASSET_CLIENTE_BDSID = ASSET.BDS_ID' || CHR(10);
       RETURN JOIN_TABLES_ASSET;
       WHEN SERVICE= SERVICE_SISTINA_VULL_NULL THEN
       JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || '  JOIN BDS_1_CASEDATA_CLIENTE CLIENTE ON CLIENTE.ASSET_CLIENTE_BDSID = ASSET.BDS_ID' || CHR(10);
       RETURN JOIN_TABLES_ASSET;  -- RU_371 FINE
      WHEN SERVICE IN (VC_ATM, NOWRI_VC_ATM) THEN
        JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || '  LEFT OUTER JOIN ANAG_CAUS CAUS ON RICH.IDANAGRAFICACAUSALE = CAUS.ID_ANAG_CAUS' || CHR(10);
        JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || q'x  JOIN BDS_1_CASEDATA_DETTAGLIOASSET DETT ON DETT.ASSET_DETTAGLIOASSET_BDSID = ASSET.BDS_ID AND DETT.NOMECOMPONENTE = 'x' || VC_ATM_COMPONENTE || q'x'x' || CHR(10);
        JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || q'x  JOIN BDS_1_CASEDATA_ATTRIBTDTTGLSST ATTR ON ATTR.DTTGLSST_TTRBTIDTTGLISST_BDSID = DETT.BDS_ID AND ATTR.NOMEATTRIBUTO  = 'x' || VC_ATM_ATTRIBUTO || q'x'x' || CHR(10);
        JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || q'x  LEFT OUTER JOIN PROFILO_VC PROF_VC ON PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'IDPROFILOVC', 1) = PROF_VC.ID_PRFL_VCx' || CHR(10);
        JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || q'x  LEFT OUTER JOIN ANAG_VP AN_VP ON PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'CODICEVP') = AN_VP.COD_VPx' || CHR(10);
        JOIN_TABLES_ASSET := JOIN_TABLES_ASSET|| ' LEFT JOIN TIPOLG_RICH_COMSTNOW TIP_RICH ON RICH.STATORICHIESTANOW=TIP_RICH.STATO_RICH_NOW' || CHR(10); -- SM_4022 STATO RICHIESTA NOW --SM_4577 INTRODOTTA LEFT JOIN
        JOIN_TABLES_ASSET := JOIN_TABLES_ASSET|| ' OUTER APPLY (SELECT DISTINCT TSL.TIPOLG_SOTTO_LAVRZ_GUI FROM BDS_1_CASEDATA_ORDINE ORD, TIPOLG_SOTTO_LAVRZ TSL WHERE ASSET.IDRICHIESTAOLO = ORD.IDRICHIESTAOLO AND ORD.TIPOLOGIASOTTOLAV = TSL.DESCR) ULT_LAV' || CHR(10);
        RETURN JOIN_TABLES_ASSET;
      WHEN SERVICE = NOWRI_CVLAN THEN
        JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || '  JOIN ANAG_CAUS CAUS ON RICH.IDANAGRAFICACAUSALE = CAUS.ID_ANAG_CAUS' || CHR(10);
        JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || q'x  JOIN BDS_1_CASEDATA_DETTAGLIOASSET DETT ON DETT.ASSET_DETTAGLIOASSET_BDSID = ASSET.BDS_ID AND DETT.NOMECOMPONENTE = 'x' || VC_USER_COMPONENTE || q'x'x' || CHR(10);
        JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || q'x  JOIN BDS_1_CASEDATA_ATTRIBTDTTGLSST ATTR ON ATTR.DTTGLSST_TTRBTIDTTGLISST_BDSID = DETT.BDS_ID AND ATTR.NOMEATTRIBUTO  = 'x' || VC_USER_ATTRIBUTO || q'x'x' || CHR(10);
        --JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || q'x  JOIN PROFILO_VC PROF_VC ON PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'IDPROFILOVC', 1) = PROF_VC.ID_PRFL_VCx' || CHR(10);
        --JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || q'x  JOIN ANAG_VP AN_VP ON PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'CODICEVP') = AN_VP.COD_VPx' || CHR(10);
        RETURN JOIN_TABLES_ASSET;
      WHEN SERVICE = NOWRI_UVLAN THEN
        JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || '  JOIN ANAG_CAUS CAUS ON RICH.IDANAGRAFICACAUSALE = CAUS.ID_ANAG_CAUS' || CHR(10);
        JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || q'x  JOIN BDS_1_CASEDATA_DETTAGLIOASSET DETT ON DETT.ASSET_DETTAGLIOASSET_BDSID = ASSET.BDS_ID AND DETT.NOMECOMPONENTE = 'x' || VLAN_COMPONENTE || q'x'x' || CHR(10);
        JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || q'x  JOIN PROFILO_VLAN_BMD PROF_BMD ON PROF_BMD.ID_PROFILO_BMD = PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'PROFILOBMD', 1)x' || CHR(10);
        RETURN JOIN_TABLES_ASSET;
      WHEN SERVICE = VC_VLAN THEN
        JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || '  LEFT OUTER JOIN ANAG_CAUS CAUS ON RICH.IDANAGRAFICACAUSALE = CAUS.ID_ANAG_CAUS' || CHR(10);
        JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || q'x  JOIN BDS_1_CASEDATA_DETTAGLIOASSET DETT ON DETT.ASSET_DETTAGLIOASSET_BDSID = ASSET.BDS_ID AND DETT.NOMECOMPONENTE = ANY ('x' || VC_USER_COMPONENTE || q'x', 'x' || VLAN_COMPONENTE || q'x')x' || CHR(10);
        JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || q'x  JOIN BDS_1_CASEDATA_ATTRIBTDTTGLSST ATTR ON ATTR.DTTGLSST_TTRBTIDTTGLISST_BDSID = DETT.BDS_ID AND ATTR.NOMEATTRIBUTO = ANY ('x' || VC_USER_ATTRIBUTO || q'x', 'x' || VLAN_ATTRIBUTO || q'x')x' || CHR(10);
        JOIN_TABLES_ASSET := JOIN_TABLES_ASSET || q'x  LEFT OUTER JOIN PROFILO_VLAN_BMD PROF_BMD ON PROF_BMD.ID_PROFILO_BMD = PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'PROFILOBMD', 1)x' || CHR(10);
        JOIN_TABLES_ASSET := JOIN_TABLES_ASSET|| ' LEFT JOIN TIPOLG_RICH_COMSTNOW TIP_RICH ON RICH.STATORICHIESTANOW=TIP_RICH.STATO_RICH_NOW' || CHR(10); -- SM_4022 STATO RICHIESTA NOW --SM_4577 INTRODOTTA LEFT JOIN
        RETURN JOIN_TABLES_ASSET;
    --RU_975
     WHEN SERVICE='CPS' THEN
          JOIN_TABLES_ASSET_NO_LEFT_JOIN := JOIN_TABLES_ASSET_NO_LEFT_JOIN || '  JOIN OLO ON OLO.CODFC_OLO_AGCOM = ASSET.CODIFICAOLOAGCOM' || CHR(10); --SM_4034
          JOIN_TABLES_ASSET_NO_LEFT_JOIN := JOIN_TABLES_ASSET_NO_LEFT_JOIN || '  LEFT OUTER JOIN TIPOLG_SOTTO_LAVRZ TIP_S_LAV ON TIP_S_LAV.DESCR = ORD.TIPOLOGIASOTTOLAV' || CHR(10); -- SM_5000 TIPOLOGIA SOTTOLAVORAZIONE GUI
          JOIN_TABLES_ASSET := JOIN_TABLES_ASSET_NO_LEFT_JOIN;
      RETURN JOIN_TABLES_ASSET;
      WHEN SERVICE IN (ORDINI_GIACENTI_NGAVULA, ORDINI_GIACENTI_REG, ORDINI_GIACENTI_XDSL, ORDINI_NOW_RI_NGAVULA, ORDINI_NOW_RI_XDSL, ORDINI_NOW_RI_REG, REGIA0_GIACENZE, REGIA0_KO, SERVICE_RAC) THEN  --SM_1819- SM_2073
        IF  (SERVICE = ORDINI_GIACENTI_NGAVULA OR SERVICE = ORDINI_GIACENTI_XDSL) THEN  --SM_1819
          JOIN_TABLES_ORDINI := JOIN_TABLES_ORDINI || '  LEFT OUTER JOIN CONTRATTO AGREE ON AGREE.ID_CONTRATTO = RICH.IDCONTRATTO' || CHR(10); --S7
          JOIN_TABLES_ORDINI := JOIN_TABLES_ORDINI || '  JOIN TIPOLG_LAVRZ TIP_LAV ON TIP_LAV.TIPOLG_LAVRZ = RICH.LAVORAZIONE' || CHR(10); --  TIPOLOGIA LAVORAZIONE GUI Lotto 6 --S7
          JOIN_TABLES_ORDINI := JOIN_TABLES_ORDINI || '  LEFT OUTER JOIN TIPOLG_SOTTO_LAVRZ TIP_S_LAV ON TIP_S_LAV.DESCR = ORD.TIPOLOGIASOTTOLAV' || CHR(10); --  TIPOLOGIA SOTTOLAVORAZIONE GUI Lotto 6 --S7
          JOIN_TABLES_ORDINI := JOIN_TABLES_ORDINI || '  LEFT OUTER JOIN TIPOLG_RICH_COMSTOLO TIP_RICH_OLO ON RICH.STATORICHIESTAOLO=TIP_RICH_OLO.STATO_RICH_OLO' || CHR(10); -- X_OLO_STATUS Lotto 6
          JOIN_TABLES_ORDINI := JOIN_TABLES_ORDINI || '  JOIN TIPOLG_RICH_COMSTNOW TIP_RICH ON RICH.STATORICHIESTANOW=TIP_RICH.STATO_RICH_NOW' || CHR(10); -- (STATO_SOI) Lotto 6
          JOIN_TABLES_ORDINI := JOIN_TABLES_ORDINI || '  JOIN TRASCODFC_OFFERTA T_OFF ON RICH.IDOFFERTA=T_OFF.ID_OFFERTA AND T_OFF.PROVENIENZA = ''OUTPUT'' ' || CHR(10); -- SERVIZIO Lotto 6
        ELSIF SERVICE = ORDINI_GIACENTI_REG  THEN
           JOIN_TABLES_ORDINI := JOIN_TABLES_ORDINI_NUMAGG || JOIN_TABLES_ORDINI || '  LEFT OUTER JOIN CONTRATTO AGREE ON AGREE.ID_CONTRATTO = RICH.IDCONTRATTO' || CHR(10); --S7
           JOIN_TABLES_ORDINI := JOIN_TABLES_ORDINI || '  JOIN TIPOLG_LAVRZ TIP_LAV ON TIP_LAV.TIPOLG_LAVRZ = RICH.LAVORAZIONE' || CHR(10); -- TIPOLOGIA LAVORAZIONE GUI Lotto 6 --S7
           JOIN_TABLES_ORDINI := JOIN_TABLES_ORDINI || '  LEFT OUTER JOIN TIPOLG_SOTTO_LAVRZ TIP_S_LAV ON TIP_S_LAV.DESCR = ORD.TIPOLOGIASOTTOLAV' || CHR(10); -- TIPOLOGIA SOTTOLAVORAZIONE GUI Lotto 6 --S7
           JOIN_TABLES_ORDINI := JOIN_TABLES_ORDINI || '  LEFT OUTER JOIN TIPOLG_RICH_COMSTOLO TIP_RICH_OLO ON RICH.STATORICHIESTAOLO=TIP_RICH_OLO.STATO_RICH_OLO' || CHR(10); -- X_OLO_STATUS Lotto 6
           JOIN_TABLES_ORDINI := JOIN_TABLES_ORDINI || '  JOIN TIPOLG_RICH_COMSTNOW TIP_RICH ON RICH.STATORICHIESTANOW=TIP_RICH.STATO_RICH_NOW' || CHR(10); -- (STATO_SOI) Lotto 6
           JOIN_TABLES_ORDINI := JOIN_TABLES_ORDINI || '  JOIN TRASCODFC_OFFERTA T_OFF ON RICH.IDOFFERTA=T_OFF.ID_OFFERTA AND T_OFF.PROVENIENZA = ''OUTPUT'' ' || CHR(10); -- SERVIZIO Lotto 6
        ELSIF (SERVICE = ORDINI_NOW_RI_NGAVULA OR SERVICE = ORDINI_NOW_RI_XDSL) THEN
            JOIN_TABLES_ORDINI := JOIN_TABLES_ORDINI || '  LEFT OUTER JOIN CONTRATTO AGREE ON AGREE.ID_CONTRATTO = RICH.IDCONTRATTO' || CHR(10);-- S7
           JOIN_TABLES_ORDINI := JOIN_TABLES_ORDINI || q'x JOIN BDS_1_CASEDATA_DETTAGLIOORDINE DETT_ORD ON DETT_ORD.ORDINE_DETTAGLIOORDINE_BDSID = ORD.BDS_ID AND DETT_ORD.NOMECOMPONENTE <> 'CONSISTENZADATI'x'|| CHR(10); --S7
           JOIN_TABLES_ORDINI := JOIN_TABLES_ORDINI || ' JOIN BDS_1_CASEDATA_ATTRIBTDTTGLRDN ORD_ATT ON ORD_ATT.DTTGLRDN_TTRBTDTTGLIRDIN_BDSID = DETT_ORD.BDS_ID AND ORD_ATT.NOMEATTRIBUTO = ''PROFILOTECNICOLINEA'' '|| CHR(10); --S7
          JOIN_TABLES_ORDINI := JOIN_TABLES_ORDINI || '  LEFT OUTER JOIN TIPOLG_CONTRATTO TPL_CON ON TPL_CON.IDTPLG_CONTRATTO = AGREE.IDTPLG_CONTRATTO' || CHR(10);
          JOIN_TABLES_ORDINI := JOIN_TABLES_ORDINI || '  LEFT OUTER JOIN PROFILO_TCNC_LINEA PROF ON PROF.ID_OFFERTA = OFF.ID_OFFERTA AND ORD_ATT.VALOREATTRIBUTO = PROF.PROFILO_TCNC_LINEA'; --SM_3209
           JOIN_TABLES_ORDINI := JOIN_TABLES_ORDINI || '  JOIN TIPOLG_RICH_COMSTNOW TIP_RICH ON RICH.STATORICHIESTANOW=TIP_RICH.STATO_RICH_NOW' || CHR(10); -- (STATO_SOI) Lotto 6
          JOIN_TABLES_ORDINI := JOIN_TABLES_ORDINI || '  JOIN TIPOLG_RICH_COMSTOLO TIP_RICH_OLO ON TIP_RICH.IDRICH_COM_STRC = TIP_RICH_OLO.IDRICH_COM_STRC';--SM_3209
        ELSIF SERVICE = ORDINI_NOW_RI_REG THEN
          JOIN_TABLES_ORDINI := JOIN_TABLES_ORDINI_NUMAGG || JOIN_TABLES_ORDINI;
           JOIN_TABLES_ORDINI := JOIN_TABLES_ORDINI || '  LEFT OUTER JOIN CONTRATTO AGREE ON AGREE.ID_CONTRATTO = RICH.IDCONTRATTO' || CHR(10); --S7
          JOIN_TABLES_ORDINI := JOIN_TABLES_ORDINI || '  LEFT OUTER JOIN TIPOLG_CONTRATTO TPL_CON ON TPL_CON.IDTPLG_CONTRATTO = AGREE.IDTPLG_CONTRATTO' || CHR(10);
          JOIN_TABLES_ORDINI := JOIN_TABLES_ORDINI || '  LEFT OUTER JOIN PROFILO_TCNC_LINEA PROF ON PROF.ID_OFFERTA = OFF.ID_OFFERTA' || CHR(10);
          JOIN_TABLES_ORDINI := JOIN_TABLES_ORDINI || '  JOIN TIPOLG_RICH_COMSTNOW TIP_RICH ON RICH.STATORICHIESTANOW=TIP_RICH.STATO_RICH_NOW' || CHR(10); -- (STATO_SOI) Lotto 6
          JOIN_TABLES_ORDINI := JOIN_TABLES_ORDINI || '  JOIN TIPOLG_RICH_COMSTOLO TIP_RICH_OLO ON TIP_RICH.IDRICH_COM_STRC = TIP_RICH_OLO.IDRICH_COM_STRC';--SM_3209
        ELSIF SERVICE = REGIA0_GIACENZE THEN
          JOIN_TABLES_ORDINI := JOIN_TABLES_ORDINI || '  JOIN BDS_1_CASEDATA_DETTAGLIOORDINE DETT ON DETT.ORDINE_DETTAGLIOORDINE_BDSID = ORD.BDS_ID' || CHR(10);
          JOIN_TABLES_ORDINI := JOIN_TABLES_ORDINI || '  JOIN CONTRATTO AGREE ON AGREE.ID_CONTRATTO = ASSET.IDCONTRATTO' || CHR(10);
        ELSIF SERVICE = REGIA0_KO THEN
          JOIN_TABLES_ORDINIREGIA0_KO := JOIN_TABLES_ORDINIREGIA0_KO || '  JOIN OLO ON OLO.CODFC_OLO_AGCOM = RICH.CODIFICAOLOAGCOM' || CHR(10);
        ELSIF SERVICE = SERVICE_RAC THEN
          JOIN_TABLES_ORDINI := JOIN_TABLES_ORDINI || '  JOIN OLO ON OLO.CODFC_OLO_AGCOM = ORD.CODIFICAOLOAGCOM' || CHR(10); --SM_4460
        END IF;
        IF SERVICE = REGIA0_KO THEN --aggiunto il 18/01/2016  SM 2129
            RETURN JOIN_TABLES_ORDINIREGIA0_KO;
        ELSE
            RETURN JOIN_TABLES_ORDINI;
        END IF;
      ELSE
        NULL;
    END CASE;
  EXCEPTION
    WHEN OTHERS THEN
      RAISE_APPLICATION_ERROR(-20999, 'ERROR IN MODULE [JOIN_TABLES]: ' || SQLERRM);
  END JOIN_TABLES;

  FUNCTION BUILD_SQL_STATEMENT (SELECT_COLUMNS    IN T_SELECT_COLUMNS,
                                FROM_CLAUSE       IN VARCHAR2,
                                WHERE_CLAUSE      IN VARCHAR2 DEFAULT NULL,
                                FILE_NAME         IN VARCHAR2 DEFAULT NULL,
                                SEPARATOR         IN VARCHAR2 DEFAULT NULL,
                                SKIP_DISTINCT     IN BOOLEAN DEFAULT FALSE)
  RETURN VARCHAR2
  DETERMINISTIC
  IS
    SQL_STATEMENT VARCHAR2(15000);
    SELECT_CLAUSE VARCHAR2(10000);
    FIRST_RECORD BOOLEAN DEFAULT TRUE;
    CONCAT_SEPARATOR  VARCHAR2(20);
  BEGIN
    LOG('   BUILDING DYNAMIC STATEMENT');

    IF SELECT_COLUMNS IS NULL THEN
      RAISE_APPLICATION_ERROR(-20999, 'SELECT_COLUMNS CANNOT BE NULL');
    ELSIF FROM_CLAUSE IS NULL THEN
      RAISE_APPLICATION_ERROR(-20998, 'FROM_CLAUSE CANNOT BE NULL');
    END IF;

    IF SKIP_DISTINCT THEN
      SELECT_CLAUSE := ' SELECT ';
    ELSE
      SELECT_CLAUSE := ' SELECT DISTINCT ';
    END IF;

    IF SEPARATOR = EMPTY_STRING THEN -- SEPARATORE = 'ES'
      CONCAT_SEPARATOR := ' || ';
    ELSIF SEPARATOR IS NOT NULL THEN -- SEPARATOR <> 'ES' AND SEPARATOR <> NULL
       CONCAT_SEPARATOR := ' || ' || APICE || SEPARATOR || APICE || ' || ';
    ELSE -- SEPARATOR = NULL
      CONCAT_SEPARATOR := ', ';
    END IF;

    IF SELECT_COLUMNS.COUNT = 0 THEN
      SELECT_CLAUSE := SELECT_CLAUSE || '*';
    ELSE
      FOR I IN 1..SELECT_COLUMNS.LAST LOOP  --SM 2159
        IF SELECT_COLUMNS.EXISTS(I) THEN
          IF FIRST_RECORD THEN
            SELECT_CLAUSE := SELECT_CLAUSE || SELECT_COLUMNS(I);
          ELSE
            DECLARE
              ACTUAL_VALUE VARCHAR2(1000);
            BEGIN
              IF SELECT_COLUMNS(I) IS NULL THEN
                ACTUAL_VALUE := 'NULL';
              ELSIF SELECT_COLUMNS(I) = 'CL_CURRENT_FILE_NAME' THEN
                ACTUAL_VALUE := APICE || FILE_NAME || APICE;
              ELSE
                ACTUAL_VALUE := SELECT_COLUMNS(I);
              END IF;
              SELECT_CLAUSE := SELECT_CLAUSE || CONCAT_SEPARATOR || ACTUAL_VALUE;
            END;
          END IF;
          FIRST_RECORD := FALSE;
        END IF;
      END LOOP;
    END IF;

    SQL_STATEMENT := SELECT_CLAUSE || ' ' || FROM_CLAUSE;

    IF WHERE_CLAUSE IS NOT NULL THEN
      SQL_STATEMENT := SQL_STATEMENT || ' ' || WHERE_CLAUSE;
    END IF;

    RETURN SQL_STATEMENT;
  EXCEPTION
    WHEN OTHERS THEN
      RAISE_APPLICATION_ERROR(-20999, 'ERROR IN MODULE [BUILD_SQL_STATEMENT]: ' || SQLERRM);
  END BUILD_SQL_STATEMENT;

  FUNCTION STATI_ORDINE(ESTRAZIONE IN VARCHAR2)
  RETURN VARCHAR2
  IS
    TYPE tSTATUSES    IS TABLE OF VARCHAR2(100);
    TYPE tESTRAZIONI  IS TABLE OF tSTATUSES INDEX BY VARCHAR2(20);

    FULL_STRING     VARCHAR2(1000);
    REGIA0_STATI_GIACENZE  tSTATUSES := tSTATUSES ('ACCODATO',
                                                  'ACQUISITO',
                                                  'ANNULLAMENTOMANUALENP',
                                                  'ANOMALIAPERANNULLAMENTONP',
                                                  'AVVENUTAFASE2',
                                                  'CERTIFICAZIONELAMANUALE',
                                                  'CERTIFICAZIONELINEAATTIVA',
                                                  'COMPLETAMENTOMANUALEGNR',
                                                  'EFDVCO',
                                                  'EFDVFT',
                                                  'EMESSOINDELIVERY',
                                                  'EMISSIONEOLMANUALE',
                                                  'INACCETTAZIONEOPERESPECIALI',
                                                  'INANNULLAMENTOSUDELIVERY',
                                                  'INATTESACODICESEGRETO',
                                                  'INATTESAPORTABILITAVOIP',
                                                  'INDELIVERY',
                                                  'INLAVORAZIONECRM',
                                                  'INLAVORAZIONEOPERESPECIALI',
                                                  'INVERIFICACAPACITAEVASIONE',
                                                  'INWAITINGLIST',
                                                  'INSERIMENTOCENTRALE',
                                                  'INVIATOADELIVERY',
                                                  'LAVORAZIONEHD',
                                                  'LAVORAZIONEMANUALEGNR',
                                                  'LAVORAZIONEMANUALENPVOIP',
                                                  'PERVENUTO',
                                                  'SOSPESO',
                                                  'VALIDAZIONEPACCHETTO',
                                                  'VERIFICHECOLOCAZIONE',
                                                  'VERIFICHEEFDVCO',
                                                  'VERIFICHEEFDVFT',
                                                  'VERIFICHESI',
                                                  'VERIFICHETECNICHE',
                                                  'VERIFICHEVENDIBILITA',
                                                  'LAVORAZIONEMANUALESLU',
                                                  'LAVORAZIONEMANUALE');

/*  cambiato il 18/01/2016 a seguito di SM 2129 documentazione modificata
    REGIA0_STATI_KO tSTATUSES := tSTATUSES('RIFIUTATO',
                                           'ESPLETAMENTOTECNICOKO',
                                           'SCARTATO',
                                           'ANNULLATO',
                                           'CHIUSO KO',
                                           'ESPLETATOTECNICOKO');
*/
    REGIA0_STATI_KO tSTATUSES := tSTATUSES(
                                           'ESPLETAMENTOTECNICOKO',
                                           'SCARTATO',
                                           'ANNULLATO');


    FIRST_RECORD  BOOLEAN DEFAULT TRUE;
    STATUSES tSTATUSES;
    ESTRAZIONI tESTRAZIONI;
  BEGIN
    ESTRAZIONI(REGIA0_GIACENZE) := REGIA0_STATI_GIACENZE;
    ESTRAZIONI(REGIA0_KO)       := REGIA0_STATI_KO;

    STATUSES := ESTRAZIONI(ESTRAZIONE);
    FOR I IN STATUSES.FIRST..STATUSES.LAST LOOP
      IF FIRST_RECORD THEN
        FULL_STRING := APICE || STATUSES(I) || APICE;
      ELSE
        FULL_STRING := FULL_STRING || ', ' || APICE || STATUSES(I) || APICE;
      END IF;
      FIRST_RECORD := FALSE;
    END LOOP;
    RETURN FULL_STRING;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20977, 'STATI_ORDINE: MISSING SETUP FOR ' || ESTRAZIONE);
      RETURN NULL;
  END STATI_ORDINE;

  FUNCTION AMBITI_ORDINE(AMBITO IN tAMBITO)
  RETURN VARCHAR2
  IS
    FIRST_RECORD  BOOLEAN DEFAULT TRUE;
    AMBITI_STRING VARCHAR2(100);
  BEGIN
    FOR I IN AMBITO.FIRST..AMBITO.LAST LOOP
      IF FIRST_RECORD THEN
        AMBITI_STRING :=  AMBITO(I);
      ELSE
        AMBITI_STRING := AMBITI_STRING || ', ' || AMBITO(I);
      END IF;
      FIRST_RECORD := FALSE;
    END LOOP;
    RETURN AMBITI_STRING;
  END AMBITI_ORDINE;

  PROCEDURE ESTRAI_GENERIC_OPERA (inID_FILE         IN NUMBER,
                                  inID_AGGIUNTIVO  IN NUMBER,
                                  --AMBITO           IN tAMBITO,
                                  TIPO_ESTRAZIONE  IN VARCHAR2,
                                  RUN_QUERY        IN BOOLEAN,
                                  NOMEFILE         IN VARCHAR2 --,
                                   -- TIPOLOGIA_FLUSSO IN VARCHAR2,
                                   -- SERVICE          IN VARCHAR2 DEFAULT NULL
                                  )
  IS
    TYPE TOPERA_RECORD IS RECORD(DATA_FOTO OGG_NOW_TO_OPERA_MENSILE_ASSET.DATA_FOTO%TYPE,
                                 COD_ORDN_TI OGG_NOW_TO_OPERA_MENSILE_ASSET.COD_ORDN_TI%TYPE,
                                 CODFC_OLO_AGCOM OGG_NOW_TO_OPERA_MENSILE_ASSET.CODFC_OLO_AGCOM%TYPE,
                                 DISTR OGG_NOW_TO_OPERA_MENSILE_ASSET.DISTR%TYPE,
                                 TIPO_LINEA OGG_NOW_TO_OPERA_MENSILE_ASSET.TIPO_LINEA%TYPE,
                                 ID_RISORSA_NOW OGG_NOW_TO_OPERA_MENSILE_ASSET.ID_RISORSA_NOW%TYPE,
                                 ID_RISORSA OGG_NOW_TO_OPERA_MENSILE_ASSET.ID_RISORSA%TYPE,
                                 DESCR_STATO_ASSET OGG_NOW_TO_OPERA_MENSILE_ASSET.DESCR_STATO_ASSET%TYPE,
                                 TIMSTP_AGGTO_ASSET OGG_NOW_TO_OPERA_MENSILE_ASSET.TIMSTP_AGGTO_ASSET%TYPE,
                                 DES_PRIMO_ORDN OGG_NOW_TO_OPERA_MENSILE_ASSET.DES_PRIMO_ORDN%TYPE,
                                 DES_CESSAZIONE OGG_NOW_TO_OPERA_MENSILE_ASSET.DES_CESSAZIONE%TYPE,
                                 OFFERTA OGG_NOW_TO_OPERA_MENSILE_ASSET.OFFERTA%TYPE,
                                 ID_OFFERTA OGG_NOW_TO_OPERA_MENSILE_ASSET.ID_OFFERTA%TYPE,
                                 CLLI OGG_NOW_TO_OPERA_MENSILE_ASSET.CLLI%TYPE,
                                 NUMERO_FITTIZIO OGG_NOW_TO_OPERA_MENSILE_ASSET.NUMERO_FITTIZIO%TYPE,
                                 ADC OGG_NOW_TO_OPERA_MENSILE_ASSET.ADC%TYPE,
                                 COD_OLO_NUMERICO OGG_NOW_TO_OPERA_MENSILE_ASSET.COD_OLO_NUMERICO%TYPE,
                                 DES OGG_NOW_TO_OPERA_MENSILE_ASSET.DES%TYPE,
                                 NUMERO_TELEFONICO OGG_NOW_TO_OPERA_MENSILE_ASSET.NUMERO_TELEFONICO%TYPE,
                                 TIPOLG_FLUSSO OGG_NOW_TO_OPERA_MENSILE_ASSET.TIPOLG_FLUSSO%TYPE,
                                 CODE_CENTRALE_ACLRR OGG_NOW_TO_OPERA_MENSILE_ASSET.CODE_CENTRALE_ACLRR%TYPE,
                                 COD_GAT OGG_NOW_TO_OPERA_MENSILE_ASSET.COD_GAT%TYPE,
                                 OPZIONE_DINAMICA OGG_NOW_TO_OPERA_MENSILE_ASSET.OPZIONE_DINAMICA%TYPE);

    TYPE tOPERA_RECORDS IS TABLE OF tOPERA_RECORD;
    TYPE tOPERA_CURSOR IS REF CURSOR;

    OPERA_RECORDS   tOPERA_RECORDS;
    cOPERA          tOPERA_CURSOR;

    INNER_CLAUSE    VARCHAR2(2000);
    FROM_CLAUSE     VARCHAR2(5000);
    WHERE_CLAUSE    VARCHAR2(2000);
    SQL_STATEMENT   VARCHAR2(10000);

    V_MESE_01       VARCHAR2(20);
    V_MESE_PREC     VARCHAR2(20);
    D_MESE_01       DATE;
    D_MESE_PREC     DATE;

   BEGIN
    D_MESE_01 := to_date (TO_CHAR(SYSDATE, 'YYYYMM') || '01', 'YYYYMMDD');
    D_MESE_PREC := ADD_MONTHS (D_MESE_01, -1 ) - ( 1 /86400 );
    V_MESE_01 := TO_CHAR(D_MESE_01, 'YYYYMMDD HH24MISS');
    V_MESE_PREC := TO_CHAR(D_MESE_PREC, 'YYYYMMDD HH24MISS');

    LOG('   SPOOL GENERIC OPERA');

    IF RUN_QUERY AND NOT CAN_START(inID_FILE, NOMEFILE) THEN
      LOG ('   EXITING BECAUSE OF CAN_START RETURNING FALSE: CHECK TABLE STATO_ESTRAZIONI.');
      RETURN;
    END IF;

    UPDATE STATO_ESTRAZIONI
    SET ID_AGGIUNTIVO = inID_AGGIUNTIVO
    WHERE ID_FILE = inID_FILE;

    COMMIT;

    INNER_CLAUSE := q'x (SELECT /*+ parallel ( 2 ) */ MIN ( CNC.ADC ) as adc, MIN ( CNC.GAT ) as gat, ASSET.BDS_IDx';
    INNER_CLAUSE := INNER_CLAUSE  || ' FROM BDS_1_CASEDATA_ASSET ASSET INNER JOIN NUMERO_CIVICO NC ON nc.COD_TOPON = ASSET.CODICETOPONOMASTICA' || CHR(10);
    INNER_CLAUSE := INNER_CLAUSE  || ' INNER JOIN  CENTRALE_NUMERO_CIVICO CNC ON CNC.COD_NUMERO_CIVICO = NC.COD_NUMERO_CIVICO' || CHR(10);
    INNER_CLAUSE := INNER_CLAUSE  || q'x WHERE ((ASSET.STATOASSET = 'CESSATO' AND ASSET.DES > TO_DATE('x'||V_MESE_PREC||q'x', 'YYYYMMDD HH24MISS') AND asset.created < TO_DATE('x'||V_MESE_01||q'x', 'YYYYMMDD HH24MISS'))x' || CHR(10);
    INNER_CLAUSE := INNER_CLAUSE  || q'x OR (ASSET.STATOASSET  <> 'CESSATO' AND ASSET.DES < TO_DATE('x'||V_MESE_01||q'x', 'YYYYMMDD HH24MISS'))) group by ASSET.BDS_ID) CENTRx';

    FROM_CLAUSE := CHR(10) || ' FROM BDS_1_CASEDATA_ASSET ASSET' || CHR(10);
    FROM_CLAUSE := FROM_CLAUSE || ' JOIN BDS_1_CASEDATA_RICHIESTA RICH ON RICH.IDRICHIESTAOLO  = ASSET.IDRICHIESTAOLO' || CHR(10);
    FROM_CLAUSE := FROM_CLAUSE || ' JOIN OFFERTA OFF ON REPLACE ( OFF.OFFERTA, '' '', '''' ) = ASSET.OFFERTA' || CHR(10); -- Lotto 5, Luca Abbate
    FROM_CLAUSE := FROM_CLAUSE || ' JOIN OLO ON OLO.CODFC_OLO_AGCOM  = ASSET.CODIFICAOLOAGCOM' || CHR(10);
    FROM_CLAUSE := FROM_CLAUSE || q'x LEFT OUTER JOIN BDS_1_CASEDATA_ATTRIBTDTTGLSST ATTR1 ON ASSET.IDASSET = ATTR1.IDASSET AND ATTR1.NOMEATTRIBUTO = 'TIPO_LINEA'x' || CHR(10);
    FROM_CLAUSE := FROM_CLAUSE || q'x LEFT OUTER JOIN BDS_1_CASEDATA_ATTRIBTDTTGLSST ATTR2 ON ASSET.IDASSET = ATTR2.IDASSET AND ATTR2.NOMEATTRIBUTO = 'CODECENTRALEACLRR'x' || CHR(10);
    FROM_CLAUSE := FROM_CLAUSE || ' LEFT OUTER JOIN '|| INNER_CLAUSE ||' ON CENTR.BDS_ID = ASSET.BDS_ID' || CHR(10);

    WHERE_CLAUSE := q'xWHERE RICH.AMBITO = 'NOW' and ASSET.CODIFICAOLOAGCOM NOT IN ('OLS', 'OLO')x' || CHR(10);
    WHERE_CLAUSE := WHERE_CLAUSE || q'x AND ASSET.IDRICHIESTAOLO IS NOT NULLx' || CHR(10);
    WHERE_CLAUSE := WHERE_CLAUSE || q'x AND (( ASSET.STATOASSET = 'CESSATO' AND ASSET.DES > TO_DATE('x'||V_MESE_PREC||q'x', 'YYYYMMDD HH24MISS') AND asset.created < TO_DATE('x'||V_MESE_01||q'x', 'YYYYMMDD HH24MISS'))x' || CHR(10);
    WHERE_CLAUSE := WHERE_CLAUSE || q'x OR ( ASSET.STATOASSET <> 'CESSATO' AND ASSET.DES < TO_DATE('x'||V_MESE_01||q'x', 'YYYYMMDD HH24MISS')))x' || CHR(10);

/* IF SERVICE = REGIA0_KO THEN --aggiunto il 18/01/2016  SM 2129
        WHERE_CLAUSE := WHERE_CLAUSE || ' ' ; --aggiunto il 18/01/2016  SM 2129
    ELSE
        WHERE_CLAUSE := WHERE_CLAUSE || ' AND ASSET.IDASSETCRMWS IS NULL' || CHR(10);
    END IF;
    WHERE_CLAUSE := WHERE_CLAUSE || q'x AND RICH.AMBITO = 'NOW'x' ||  CHR(10); -- Lotto 5, Luca Abbate
   ---
    WHERE_CLAUSE := WHERE_CLAUSE || ' AND OFF.ID_FAMIG_OFFERTA = ANY ';
    WHERE_CLAUSE := WHERE_CLAUSE || '(' || AMBITI_ORDINE(AMBITO) || ')';
  IF SERVICE IS NOT NULL THEN
     WHERE_CLAUSE :=  WHERE_CLAUSE || ' AND OFF.ID_OFFERTA = ANY ' || IDS_OFFERTA(SERVICE) || CHR(10);
  END IF;
*/

    SQL_STATEMENT := BUILD_SQL_STATEMENT(FILE_COLUMNS(TIPO_ESTRAZIONE), FROM_CLAUSE, WHERE_CLAUSE);

    LOG('   BUILT STATEMENT: ' || CHR(10) || SQL_STATEMENT);

    IF NOT RUN_QUERY THEN
      INFO('   BUILT STATEMENT: ' || CHR(10) || SQL_STATEMENT);
    ELSE
      EXECUTE IMMEDIATE 'TRUNCATE TABLE OGG_NOW_TO_OPERA_MENSILE_ASSET';
      OPEN cOPERA FOR SQL_STATEMENT;

      LOOP
        FETCH cOPERA BULK COLLECT INTO OPERA_RECORDS LIMIT 1000;
        EXIT WHEN OPERA_RECORDS.COUNT = 0;

        FORALL I IN 1..OPERA_RECORDS.COUNT
          INSERT INTO OGG_NOW_TO_OPERA_MENSILE_ASSET
            (DATA_FOTO,
             COD_ORDN_TI,
             CODFC_OLO_AGCOM,
             DISTR,
             TIPO_LINEA,
             ID_RISORSA_NOW,
             ID_RISORSA,
             DESCR_STATO_ASSET,
             TIMSTP_AGGTO_ASSET,
             DES_PRIMO_ORDN,
             DES_CESSAZIONE,
             OFFERTA,
             ID_OFFERTA,
             CLLI,
             NUMERO_FITTIZIO,
             ADC,
             COD_OLO_NUMERICO,
             DES,
             NUMERO_TELEFONICO,
             TIPOLG_FLUSSO,
             CODE_CENTRALE_ACLRR,
             COD_GAT,
             OPZIONE_DINAMICA)
          VALUES
           (OPERA_RECORDS(I).DATA_FOTO,
             OPERA_RECORDS(I).COD_ORDN_TI,
             OPERA_RECORDS(I).CODFC_OLO_AGCOM,
             OPERA_RECORDS(I).DISTR,
             OPERA_RECORDS(I).TIPO_LINEA,
             OPERA_RECORDS(I).ID_RISORSA_NOW,
             OPERA_RECORDS(I).ID_RISORSA,
             OPERA_RECORDS(I).DESCR_STATO_ASSET,
             OPERA_RECORDS(I).TIMSTP_AGGTO_ASSET,
             OPERA_RECORDS(I).DES_PRIMO_ORDN,
             OPERA_RECORDS(I).DES_CESSAZIONE,
             OPERA_RECORDS(I).OFFERTA,
             OPERA_RECORDS(I).ID_OFFERTA,
             OPERA_RECORDS(I).CLLI,
             OPERA_RECORDS(I).NUMERO_FITTIZIO,
             OPERA_RECORDS(I).ADC,
             OPERA_RECORDS(I).COD_OLO_NUMERICO,
             OPERA_RECORDS(I).DES,
             OPERA_RECORDS(I).NUMERO_TELEFONICO,
             OPERA_RECORDS(I).TIPOLG_FLUSSO,
             OPERA_RECORDS(I).CODE_CENTRALE_ACLRR,
             OPERA_RECORDS(I).COD_GAT,
             OPERA_RECORDS(I).OPZIONE_DINAMICA);
        COMMIT;
      END LOOP;

      CLOSE cOPERA;

      INSERT INTO OGG_NOW_TO_OPERA_FOTO_ASSET (DATA_FOTO,
                                               TIMSTP_INSMTO)
      VALUES (TRUNC(SYSTIMESTAMP),
              SYSTIMESTAMP);
      COMMIT;
    END IF;

    IF RUN_QUERY THEN
      UPDATE_STATUS(inID_FILE, FLAG_OK);
    END IF;

    LOG ('   FINISHED OPERA DATA SPOOL');
  EXCEPTION
    WHEN OTHERS THEN
    INFO('** FATAL ERROR: ' || SQLCODE || ' - ' || SQLERRM || ' **');
    UPDATE_STATUS(inID_FILE, FLAG_KO, SUBSTR(SQLCODE || SQLERRM, 1, 2000));
  END ESTRAI_GENERIC_OPERA;

  PROCEDURE ESTRAI_GENERIC_ORDINI (ID_FILE          IN NUMBER,
                                   AMBITO           IN tAMBITO,
                                   TIPO_ESTRAZIONE  IN VARCHAR2,
                                   FULL_FILE_NAME   IN VARCHAR2,
                                   RUN_QUERY        IN BOOLEAN,
                                   DATA_INIZIO      IN VARCHAR2 DEFAULT NULL,
                                   DATA_FINE        IN VARCHAR2 DEFAULT NULL,
                                   SEPARATOR        IN VARCHAR2 DEFAULT PIPE_SEPARATOR)
  IS
    FROM_CLAUSE     VARCHAR2(5000);
    WHERE_CLAUSE    VARCHAR2(2000);
    SQL_STATEMENT   VARCHAR2(10000);
    LAST_UPDATE_ORDINI_GIACENTI DATE;
    SELECT_CFG_ORDINI_GIACENTI VARCHAR2(1000);
    V_LIMIT_ORDINI_GIACENTI VARCHAR2(30);
  BEGIN
    IF FULL_FILE_NAME IS NULL THEN
      RAISE_APPLICATION_ERROR(-20993, 'FILE_NAME CANNOT BE NULL');
    END IF;

    LOG('   SPOOL GENERIC ORDINI FOR FILE ' || FULL_FILE_NAME);

    IF RUN_QUERY AND NOT CAN_START(ID_FILE, FULL_FILE_NAME) THEN
      LOG ('   EXITING BECAUSE OF CAN_START RETURNING FALSE: CHECK TABLE STATO_ESTRAZIONI.');
      RETURN;
    END IF;


    FROM_CLAUSE := CHR(10) || ' FROM BDS_1_CASEDATA_ORDINE ORD' || CHR(10) || JOIN_TABLES(TIPO_ESTRAZIONE);

     IF (TIPO_ESTRAZIONE = ORDINI_GIACENTI_NGAVULA OR TIPO_ESTRAZIONE = ORDINI_GIACENTI_REG OR TIPO_ESTRAZIONE = ORDINI_GIACENTI_XDSL) THEN
      SELECT_CFG_ORDINI_GIACENTI := q'xSELECT TRUNC(LAST_UPDATE)
                                      FROM CFG_START_ESTRAZIONI
                                      WHERE ESTRAZIONE = :TIPO_ESTRAZIONE
                                        AND SISTEMA = 'RA'x';

      EXECUTE IMMEDIATE SELECT_CFG_ORDINI_GIACENTI
      INTO LAST_UPDATE_ORDINI_GIACENTI
      USING ORDINI_GIACENTI_NGAVULA;

      IF LAST_UPDATE_ORDINI_GIACENTI IS NOT NULL THEN
        V_LIMIT_ORDINI_GIACENTI := TO_CHAR(LAST_UPDATE_ORDINI_GIACENTI-1, 'DDMMYYYY');
       ELSE
        V_LIMIT_ORDINI_GIACENTI := TO_CHAR(SYSDATE-8, 'DDMMYYYY');
      END IF;
      WHERE_CLAUSE := WHERE_CLAUSE || q'xWHERE (RICH.STATORICHIESTANOW <> ALL ('CHIUSO', 'ESPLETAMENTOTECNICOKO', 'ANNULLATO', 'SCARTATO')x' || CHR(10);
      WHERE_CLAUSE := WHERE_CLAUSE || q'x OR RICH.STATORICHIESTANOW IN ('CHIUSO', 'ESPLETAMENTOTECNICOKO', 'ANNULLATO', 'SCARTATO')x';
      WHERE_CLAUSE := WHERE_CLAUSE || q'x AND RICH.LASTUPDATE BETWEEN TO_DATE('x'||V_LIMIT_ORDINI_GIACENTI||q'x', 'DDMMYYYY') AND SYSDATE)x' || CHR(10);
      WHERE_CLAUSE := WHERE_CLAUSE || q'x AND RICH.TIPORICHIESTA = 'ORDINE'x';
      WHERE_CLAUSE := WHERE_CLAUSE || q'x AND RICH.AMBITO = 'NOW' x' || CHR(10);
    ELSIF (TIPO_ESTRAZIONE = ORDINI_NOW_RI_NGAVULA OR TIPO_ESTRAZIONE = ORDINI_NOW_RI_REG OR TIPO_ESTRAZIONE = ORDINI_NOW_RI_XDSL) THEN
      WHERE_CLAUSE := WHERE_CLAUSE || q'xWHERE RICH.STATORICHIESTANOW = ANY x';
      WHERE_CLAUSE := WHERE_CLAUSE || q'x('ESPLETAMENTOTECNICO', 'FATTURAZIONEKO', 'INVIATOAFATTURAZIONE')x' || CHR(10);
    ELSIF TIPO_ESTRAZIONE = REGIA0_GIACENZE THEN
      WHERE_CLAUSE := WHERE_CLAUSE || q'xWHERE RICH.STATORICHIESTANOW = ANY x';
      WHERE_CLAUSE := WHERE_CLAUSE || '(' || STATI_ORDINE(TIPO_ESTRAZIONE) || ')' || CHR(10);
    ELSIF TIPO_ESTRAZIONE = REGIA0_KO THEN
      WHERE_CLAUSE := WHERE_CLAUSE || q'xWHERE RICH.STATORICHIESTANOW = ANY x';
      WHERE_CLAUSE := WHERE_CLAUSE || '(' || STATI_ORDINE(TIPO_ESTRAZIONE) || ')' || CHR(10);
      IF DATA_INIZIO IS NOT NULL AND DATA_FINE IS NOT NULL THEN
        WHERE_CLAUSE := WHERE_CLAUSE || q'x  AND RICH.LASTUPDATE BETWEEN TO_DATE('x' || DATA_INIZIO || q'x', 'YYYY-MM-DD')x' || q'x AND TO_DATE('x' || DATA_FINE || q'x', 'YYYY-MM-DD')x' || CHR(10);
      ELSE
        WHERE_CLAUSE := WHERE_CLAUSE || '  AND TRUNC(RICH.LASTUPDATE) = TRUNC(SYSDATE)' || CHR(10);
      END IF;
    ELSIF TIPO_ESTRAZIONE = SERVICE_RAC THEN
      WHERE_CLAUSE := WHERE_CLAUSE || ' AND OFF.ID_OFFERTA = ANY ' || IDS_OFFERTA(TIPO_ESTRAZIONE) || CHR(10);
      WHERE_CLAUSE := WHERE_CLAUSE || q'x  AND TRUNC(ORD.DES) BETWEEN TRUNC(TO_DATE('x' || DATA_INIZIO || q'x', 'YYYY-MM-DD'))x' || q'x AND TRUNC(TO_DATE('x' || DATA_FINE || q'x', 'YYYY-MM-DD'))x' || CHR(10);
    ELSE
      RAISE_APPLICATION_ERROR(-20990, 'INVALID TIPO_ESTRAZIONE ' || TIPO_ESTRAZIONE);
    END IF;

  --  IF TIPO_ESTRAZIONE != REGIA0_KO THEN  --SM 2129 --S7 inizio
   --   WHERE_CLAUSE := WHERE_CLAUSE || '  AND ASSET.IDASSETCRMWS IS NULL' || CHR(10);
  --  END IF; --S7 fine
    IF AMBITO IS NOT NULL THEN
      WHERE_CLAUSE := WHERE_CLAUSE || '  AND OFF.ID_FAMIG_OFFERTA = ANY ';
      WHERE_CLAUSE := WHERE_CLAUSE || '(' || AMBITI_ORDINE(AMBITO) || ')';
    END IF;

    SQL_STATEMENT := BUILD_SQL_STATEMENT(FILE_COLUMNS(TIPO_ESTRAZIONE), FROM_CLAUSE, WHERE_CLAUSE, FULL_FILE_NAME, SEPARATOR);

    LOG('   BUILT STATEMENT: ' || CHR(10) || SQL_STATEMENT);

    IF NOT RUN_QUERY THEN
      INFO('   BUILT STATEMENT: ' || CHR(10) || SQL_STATEMENT);
    ELSIF WRITE_ON_TABLE THEN
      IF TIPO_ESTRAZIONE = SERVICE_RAC THEN
        FETCH_AND_COMMIT(SQL_STATEMENT, ID_FILE, FULL_FILE_NAME, TIPO_ESTRAZIONE, SEPARATOR, DATA_INIZIO, DATA_FINE);
      ELSE
        FETCH_AND_COMMIT(SQL_STATEMENT, ID_FILE, FULL_FILE_NAME, TIPO_ESTRAZIONE, SEPARATOR);
      END IF;
    ELSE
      FETCH_AND_WRITE(SQL_STATEMENT, FULL_FILE_NAME);
    END IF;
    IF RUN_QUERY THEN
      UPDATE_STATUS(ID_FILE, FLAG_OK);
    END IF;

    LOG ('   FINISHED ORDINI DATA SPOOL');
  EXCEPTION
    WHEN OTHERS THEN
    INFO('** FATAL ERROR: ' || SQLCODE || ' - ' || SQLERRM || ' **');
    UPDATE_STATUS(ID_FILE, FLAG_KO, SUBSTR(SQLCODE || SQLERRM, 1, 2000));
  END ESTRAI_GENERIC_ORDINI;

  PROCEDURE ESTRAI_GENERIC_ASSET (ID_FILE             IN NUMBER,
                                  RUN_QUERY           IN BOOLEAN,
                                  ESTRAI              IN VARCHAR2,
                                  FULL_FILE_NAME      IN VARCHAR2,
                                  SERVICE             IN VARCHAR2,
                                  DATA_DA             IN VARCHAR2,
                                  DATA_A              IN VARCHAR2,
                                  CODICE_OLO          IN VARCHAR2,
                                  SEPARATOR           IN VARCHAR2 DEFAULT PIPE_SEPARATOR,
                                  SKIP_CRMESTRATTORE  IN BOOLEAN DEFAULT FALSE)
  IS
    FROM_CLAUSE       VARCHAR2(20000); --SM_9629
    WHERE_CLAUSE      VARCHAR2(2000);
    SQL_STATEMENT     VARCHAR2(20000);
    CONSISTENZA_NOW PARAMETRI_CFGZ_NOW.VALORE_STRINGA%TYPE; -- Lotto6
    FOUND             NUMBER;
    FLAG_STATO        VARCHAR2(50);
  BEGIN
    IF DATA_DA IS NULL THEN
      IF ESTRAI = ESTRAI_ATTIVI THEN
        RAISE_APPLICATION_ERROR(-20997, 'DATA_DA CANNOT BE NULL');
      END IF;
    ELSIF DATA_A IS NULL THEN
      IF ESTRAI != ESTRAI_X_INCONTRA THEN
        RAISE_APPLICATION_ERROR(-20996, 'DATA_A CANNOT BE NULL');
      END IF;
    ELSIF FULL_FILE_NAME IS NULL THEN
      RAISE_APPLICATION_ERROR(-20995, 'FILE_NAME CANNOT BE NULL');
    ELSIF SERVICE IS NULL THEN
      RAISE_APPLICATION_ERROR(-20994, 'SERVICE_NAME CANNOT BE NULL');
    END IF;

    LOG('   SPOOL GENERIC ASSET FOR FILE ' || FULL_FILE_NAME);

    IF RUN_QUERY AND NOT CAN_START(ID_FILE, FULL_FILE_NAME) THEN
      LOG ('   EXITING BECAUSE OF CAN_START RETURNING FALSE: CHECK TABLE STATO_ESTRAZIONI.');
      RETURN;
    END IF;
    -- Lotto6: Controllo sul valore OWNER_CONSISTENZA (per il transitorio)
    SELECT VALORE_STRINGA INTO CONSISTENZA_NOW FROM PARAMETRI_CFGZ_NOW WHERE CHIAVE = 'OWNER_CONSISTENZA';
    --/ Lotto6

    IF ESTRAI IN(ESTRAI_F2_TD, ESTRAI_F2_TD_NISIDA) THEN
      FROM_CLAUSE := q'xFROM (SELECT 'C' AS TIPO, ASSET.IDRISORSA IDRISORSA, ASSET.BDS_ID IDASSET, ASSET.CRMESTRATTORE CRMESTRATTORE
 FROM BDS_1_CASEDATA_ASSET ASSET
 WHERE ASSET.IDOFFERTA IN (7, 8, 9, 10, 11, 12, 13, 14, 39, 40, 41)
  AND ASSET.STATOASSET = 'CESSATO'
  AND DES > SYSDATE - INTERVAL '180' DAY(3)
 UNION ALL
 SELECT 'A' AS TIPO, ASSET.IDRISORSA IDRISORSA, ASSET.BDS_ID IDASSET, ASSET.CRMESTRATTORE CRMESTRATTORE
 FROM BDS_1_CASEDATA_RICHIESTA RICH
  JOIN BDS_1_CASEDATA_ASSET ASSET ON ASSET.IDRICHIESTAOLO = RICH.IDRICHIESTAOLO
 WHERE RICH.IDOFFERTA IN (7, 8, 9, 10, 11, 12, 13, 14, 39, 40, 41)
  AND RICH.STATORICHIESTANOW = ANY ('ANNULLATO', 'SCARTATO')
  AND RICH.LAVORAZIONE = 'VARIAZIONE'
  AND RICH.DRO > SYSDATE - INTERVAL '180' DAY(3)
 UNION ALL
SELECT 'A' AS TIPO, ORD.IDRISORSA IDRISORSA, NULL IDASSET, NULL CRMESTRATTORE
 FROM BDS_1_CASEDATA_RICHIESTA RICH
  JOIN BDS_1_CASEDATA_ORDINE ORD ON ORD.IDRICHIESTAOLO = RICH.IDRICHIESTAOLO
 WHERE RICH.IDOFFERTA IN (7, 8, 9, 10, 11, 12, 13, 14, 39, 40, 41)
  AND RICH.STATORICHIESTANOW = ANY ('ANNULLATO', 'SCARTATO')
  AND RICH.LAVORAZIONE = 'ATTIVAZIONE'
  AND RICH.DRO > SYSDATE - INTERVAL '180' DAY(3)
UNION ALL
SELECT 'I' AS TIPO, ORD.IDRISORSA IDRISORSA, NULL IDASSET, NULL CRMESTRATTORE
 FROM BDS_1_CASEDATA_RICHIESTA RICH
  JOIN BDS_1_CASEDATA_ORDINE ORD ON ORD.IDRICHIESTAOLO = RICH.IDRICHIESTAOLO
 WHERE RICH.IDOFFERTA IN (11, 12, 13, 14)
  AND RICH.STATORICHIESTANOW <> ALL ('SCARTATO', 'ANNULLATO', 'ESPLETAMENTOTECNICO', 'CHIUSO', 'INVIATOAFATTURAZIONE', 'FATTURAZIONEKO')
  AND RICH.LAVORAZIONE = 'ATTIVAZIONE'
  AND RICH.DRO > SYSDATE - INTERVAL '180' DAY(3)
UNION ALL
SELECT 'I' AS TIPO, ASSET.IDRISORSA IDRISORSA, ASSET.BDS_ID IDASSET, ASSET.CRMESTRATTORE CRMESTRATTORE
FROM BDS_1_CASEDATA_ASSET ASSET
WHERE ASSET.IDOFFERTA IN (11, 12, 13, 14)
 AND ASSET.STATOASSET ='ATTIVO'
UNION ALL
SELECT CASE AST.LAVORAZIONE
         WHEN 'VARIAZIONE' THEN '9'
         WHEN 'CESSAZIONE' THEN '6'
        END AS TIPO, ASSET.IDRISORSA IDRISORSA, ASSET.BDS_ID IDASSET, ASSET.CRMESTRATTORE CRMESTRATTORE
FROM BDS_1_CASEDATA_ASSET ASSET
CROSS APPLY (SELECT TO_CHAR(RICH.LAVORAZIONE) LAVORAZIONE,
                   ROW_NUMBER() OVER (PARTITION BY AST.IDASSET ORDER BY CREATED DESC) ROW_NUMBER
              FROM BDS_1_CASEDATA_RICHIESTA RICH
              JOIN BDS_1_CASEDATA_ASSETTARGET AST ON AST.RICHIESTA_ASSETTARGET_BDSID = RICH.BDS_ID
              WHERE AST.IDASSET = ASSET.IDASSET) AST
WHERE ASSET.IDOFFERTA IN (11, 12, 13, 14)
 AND ASSET.STATOASSET ='INLAVORAZIONE'
 AND AST.ROW_NUMBER = 1
 AND AST.LAVORAZIONE = ANY ('VARIAZIONE', 'CESSAZIONE')
UNION ALL
SELECT 'I' AS TIPO, ORD.IDRISORSA IDRISORSA, NULL IDASSET, NULL CRMESTRATTORE
 FROM BDS_1_CASEDATA_RICHIESTA RICH
  JOIN BDS_1_CASEDATA_ORDINE ORD ON ORD.IDRICHIESTAOLO = RICH.IDRICHIESTAOLO
 WHERE RICH.IDOFFERTA IN (7, 8, 9, 10, 39, 40, 41)
  AND RICH.STATORICHIESTANOW <> ALL ('SCARTATO', 'ANNULLATO', 'ESPLETAMENTOTECNICO', 'CHIUSO', 'INVIATOAFATTURAZIONE', 'FATTURAZIONEKO')
  AND RICH.LAVORAZIONE = 'ATTIVAZIONE'
  AND RICH.DRO > SYSDATE - INTERVAL '180' DAY(3)) ASSETx';
    ELSE
      FROM_CLAUSE := CHR(10) || ' FROM BDS_1_CASEDATA_ASSET ASSET' || CHR(10) || JOIN_TABLES(SERVICE);
      WHERE_CLAUSE :=  'WHERE OFF.ID_OFFERTA = ANY ' || IDS_OFFERTA(SERVICE) || CHR(10);
    END IF;

    IF CODICE_OLO IS NOT NULL THEN
      WHERE_CLAUSE := WHERE_CLAUSE || CHR(10) || ' AND ASSET.CODIFICAOLOAGCOM = ' || APICE || CODICE_OLO || APICE || CHR(10);
    END IF;
    IF ESTRAI = ESTRAI_ATTIVI THEN
      WHERE_CLAUSE := WHERE_CLAUSE || ' AND (';
      WHERE_CLAUSE := WHERE_CLAUSE || '(ASSET.STATOASSET = ANY (''' || STATUS_INLAVORAZIONE || ''', ''' || STATUS_ATTIVO || ''')';
      WHERE_CLAUSE := WHERE_CLAUSE || ' AND ASSET.DES <= ' || GET_DATE(DATA_A) || ')' || CHR(10);
      WHERE_CLAUSE := WHERE_CLAUSE || '   OR (ASSET.STATOASSET = ''' || STATUS_CESSATO || '''';
      WHERE_CLAUSE := WHERE_CLAUSE || ' AND ASSET.DES > ' || GET_DATE(DATA_DA);
      WHERE_CLAUSE := WHERE_CLAUSE || ' AND ASSET.DESPRIMOORDINE < ' || GET_DATE(DATA_A) || ')';
      WHERE_CLAUSE := WHERE_CLAUSE || ')' || CHR(10);
    ELSIF ESTRAI = ESTRAI_ATTIVI_RI THEN
      WHERE_CLAUSE := WHERE_CLAUSE || ' AND (';
      WHERE_CLAUSE := WHERE_CLAUSE || '(ASSET.STATOASSET = ANY (''' || STATUS_INLAVORAZIONE || ''', ''' || STATUS_ATTIVO || ''')';
      WHERE_CLAUSE := WHERE_CLAUSE || ' AND ASSET.DESPRIMOORDINE <= ' || GET_DATE(DATA_A) || ')' || CHR(10);
      WHERE_CLAUSE := WHERE_CLAUSE || '   OR (ASSET.STATOASSET = ''' || STATUS_CESSATO || '''';
      WHERE_CLAUSE := WHERE_CLAUSE || ' AND ASSET.DES > ' || GET_DATE(DATA_DA);
      WHERE_CLAUSE := WHERE_CLAUSE || ' AND ASSET.DESPRIMOORDINE < ' || GET_DATE(DATA_A);
      WHERE_CLAUSE := WHERE_CLAUSE || ' AND ASSET.DESPRIMOORDINE < ASSET.DES)';
      WHERE_CLAUSE := WHERE_CLAUSE || ')' || CHR(10);
      WHERE_CLAUSE := WHERE_CLAUSE || q'x AND ASSET.CODIFICAOLOAGCOM <> 'TIM'x' || CHR(10);
    ELSIF ESTRAI = ESTRAI_CESSATI THEN
      WHERE_CLAUSE := WHERE_CLAUSE || ' AND (';
      WHERE_CLAUSE := WHERE_CLAUSE || 'ASSET.STATOASSET = ''' || STATUS_CESSATO || '''';
      WHERE_CLAUSE := WHERE_CLAUSE || ' AND ASSET.DES BETWEEN ' || GET_DATE(DATA_A) || q'x - INTERVAL '12' MONTH AND x' || GET_DATE(DATA_A);
      WHERE_CLAUSE := WHERE_CLAUSE || ')' || CHR(10);
    ELSIF ESTRAI IN (ESTRAI_F1_TD, ESTRAI_F1_TD_NISIDA) THEN
      WHERE_CLAUSE := WHERE_CLAUSE || ' AND (';
      WHERE_CLAUSE := WHERE_CLAUSE || q'x(ASSET.STATOASSET = 'ATTIVO' $CRMESTRATTORE)x';
      WHERE_CLAUSE := WHERE_CLAUSE || ' OR (ASSET.STATOASSET = ''' || STATUS_INLAVORAZIONE ||'''  AND ULT_ORD.TIPOLOGIALAVORAZIONE = ANY (' || ORDINE_VARIAZIONE || ' , ' || ORDINE_CESSAZIONE || '))';
      WHERE_CLAUSE := WHERE_CLAUSE || ')' || CHR(10);
    ELSIF ESTRAI = ESTRAI_SISTINA_G THEN
      WHERE_CLAUSE := WHERE_CLAUSE || ' AND TRUNC(ASSET.LASTUPDATE) = ' || GET_DATE(DATA_A) || CHR(10);
--RU_1322    ELSIF ESTRAI = ESTRAI_SISTINA_M THEN
--RU_1322      WHERE_CLAUSE := WHERE_CLAUSE || ' AND ASSET.LASTUPDATE BETWEEN ' || GET_DATE(DATA_DA) || ' AND ' || GET_DATE(DATA_A) || CHR(10);
    ELSIF ESTRAI = ESTRAI_SISTINA_NOT_NULL THEN                           -- RU_371 INIZIO
      DECLARE
        DATE_ATTIVI   VARCHAR2(500);
        DATE_CESSATI  VARCHAR2(500);
      BEGIN
        IF DATA_DA IS NOT NULL AND DATA_A IS NOT NULL THEN
          DATE_ATTIVI := 'ASSET.LASTUPDATE BETWEEN ' || GET_DATE(DATA_DA) || ' AND ' || GET_DATE(DATA_A);
          DATE_CESSATI := q'xASSET.LASTUPDATE BETWEEN TRUNC(ADD_MONTHS(x' || GET_DATE(DATA_DA) || q'x, -6)) + INTERVAL '1' DAY AND x' || GET_DATE(DATA_A);
        ELSE
          DATE_ATTIVI := q'xTRUNC(ASSET.LASTUPDATE) = TRUNC(SYSDATE) - INTERVAL '1' DAYx';
          DATE_CESSATI := q'xASSET.LASTUPDATE BETWEEN TRUNC(ADD_MONTHS(SYSDATE, -6)) AND TRUNC(SYSDATE) - INTERVAL '1' DAYx';
        END IF;

        WHERE_CLAUSE := WHERE_CLAUSE || ' AND (';
        WHERE_CLAUSE := WHERE_CLAUSE || '(ASSET.STATOASSET = ANY (''' || STATUS_INLAVORAZIONE || ''', ''' || STATUS_ATTIVO || ''')';
        WHERE_CLAUSE := WHERE_CLAUSE || ' AND '|| DATE_ATTIVI || ')'; --
        WHERE_CLAUSE := WHERE_CLAUSE || '   OR (ASSET.STATOASSET = ''' || STATUS_CESSATO || '''';
        WHERE_CLAUSE := WHERE_CLAUSE || ' AND '|| DATE_CESSATI || ')';
        WHERE_CLAUSE := WHERE_CLAUSE || ')' || CHR(10);
        WHERE_CLAUSE := WHERE_CLAUSE || ' AND ASSET.IDRISORSA is not null';
        WHERE_CLAUSE := WHERE_CLAUSE || ' AND ASSET.DESPRIMOORDINE is not null';
        WHERE_CLAUSE := WHERE_CLAUSE || ' AND ASSET.DES is not null';
        WHERE_CLAUSE := WHERE_CLAUSE || ' AND ASSET.CODIFICAOLOAGCOM is not null';
        WHERE_CLAUSE := WHERE_CLAUSE || ' AND CLIENTE.COGNOMERAGIONESOCIALE is not null'; -- RU_371 FINE
      END;
    ELSIF ESTRAI = ESTRAI_X_INCONTRA THEN -- ru_412
      WHERE_CLAUSE := WHERE_CLAUSE || ' AND ';
      WHERE_CLAUSE := WHERE_CLAUSE || '(ASSET.STATOASSET = ANY (''' || STATUS_INLAVORAZIONE || ''', ''' || STATUS_ATTIVO || ''', ''' || STATUS_CESSATO || ''')';

      IF DATA_DA IS NOT NULL AND DATA_A IS NOT NULL THEN
        WHERE_CLAUSE := WHERE_CLAUSE || ' AND TRUNC(ASSET.DES) BETWEEN TRUNC(' || GET_DATE(DATA_DA) || ') AND TRUNC(' || GET_DATE(DATA_A)||')';
      ELSE
        WHERE_CLAUSE := WHERE_CLAUSE || q'x AND TRUNC(ASSET.DES) = TRUNC(SYSDATE) - INTERVAL '1' DAYx';
      END IF;

      WHERE_CLAUSE := WHERE_CLAUSE || ')' || CHR(10);
      --RU_412
      --20,27,28,29 --NP
      --22,25,33    --WLR
      --21,26       --VULL
      WHERE_CLAUSE := WHERE_CLAUSE || ' AND ';
      WHERE_CLAUSE := WHERE_CLAUSE || '( ';
      --INIZIO RU_825
      if ESTRAI = ESTRAI_X_INCONTRA THEN
      WHERE_CLAUSE := WHERE_CLAUSE || '( (ORD.TIPOLOGIALAVORAZIONE = ''ATTIVAZIONE'' AND TIP_S_LAV.TIPOLG_SOTTO_LAVRZ_GUI  IN (''NORMALE'',''USCITA DA TI'') OR ( ORD.TIPOLOGIALAVORAZIONE = ''ATTIVAZIONE'' AND TIP_S_LAV.TIPOLG_SOTTO_LAVRZ_GUI = ''PORTABILITA SUCCESSIVA'' and ORD.CODIFICAOLOAGCOM <> ''TLC'')) ) ';  --SM_5000
      ELSE
      WHERE_CLAUSE := WHERE_CLAUSE || '(ORD.TIPOLOGIALAVORAZIONE = ''ATTIVAZIONE'' AND TIP_S_LAV.TIPOLG_SOTTO_LAVRZ_GUI  IN (''NORMALE'',''PORTABILITA SUCCESSIVA'',''USCITA DA TI'')) ';  --SM_5000
      END IF;
      --Fine RU_825
      WHERE_CLAUSE := WHERE_CLAUSE || 'OR ';
      --SM_8368 Aggiunto IF per non inviare  le NP con rientro
      if ESTRAI = ESTRAI_X_INCONTRA THEN
       WHERE_CLAUSE := WHERE_CLAUSE || '(ORD.TIPOLOGIALAVORAZIONE = ''CESSAZIONE'' AND TIP_S_LAV.TIPOLG_SOTTO_LAVRZ_GUI  IN (''NORMALE'',''USCITA DA TI'')) '; --SM_5000
      Else
       WHERE_CLAUSE := WHERE_CLAUSE || '(ORD.TIPOLOGIALAVORAZIONE = ''CESSAZIONE'' AND TIP_S_LAV.TIPOLG_SOTTO_LAVRZ_GUI  IN (''NORMALE'',''RIENTRO IN TI'',''USCITA DA TI'')) '; --SM_5000
      END IF;
      WHERE_CLAUSE := WHERE_CLAUSE || 'OR ';
      WHERE_CLAUSE := WHERE_CLAUSE || '(ORD.TIPOLOGIALAVORAZIONE = ''MIGRAZIONE'' AND TIP_S_LAV.TIPOLG_SOTTO_LAVRZ_GUI  IN (''MIGRAZIONE OLO'', ''ATTIVAZIONE 274'')) ';  --SM_5000
      WHERE_CLAUSE := WHERE_CLAUSE || 'OR ';
      WHERE_CLAUSE := WHERE_CLAUSE || '(ORD.TIPOLOGIALAVORAZIONE = ''VARIAZIONE'' AND TIP_S_LAV.TIPOLG_SOTTO_LAVRZ_GUI  IN ( ';   --SM_5000
      WHERE_CLAUSE := WHERE_CLAUSE || ' ''CAMBIO NUMERO 3'',''CAMBIO NUMERO 4'',''TRASLOCO WLR 13'',''TRASLOCO WLR 14'', ';
      WHERE_CLAUSE := WHERE_CLAUSE || ' ''TRASLOCO WLR 15'',''TRASLOCO WLR 16'', ''DECREMENTO NP'' ';
      WHERE_CLAUSE := WHERE_CLAUSE || ')) ';
      WHERE_CLAUSE := WHERE_CLAUSE || ')' || CHR(10);
    --ELSE
     -- RAISE_APPLICATION_ERROR(-20999, 'INVALID MODE: ' || ESTRAI);
    END IF;

  /*  IF ESTRAI = ESTRAI_X_INCONTRA THEN
      WHERE_CLAUSE := WHERE_CLAUSE || ' AND ASSET.IDASSETCRMWS IS NULL';
      WHERE_CLAUSE := WHERE_CLAUSE || ' AND ((ORD.TIPOLOGIALAVORAZIONE = '|| ORDINE_CESSAZIONE ||'  AND ORD.TIPOLOGIASOTTOLAV = '|| SOTT_ORD_NORMALE ||')';
      WHERE_CLAUSE := WHERE_CLAUSE || ' OR ';
      WHERE_CLAUSE := WHERE_CLAUSE || ' (ORD.TIPOLOGIALAVORAZIONE = '|| ORDINE_ATTIVAZIONE ||'  AND ORD.TIPOLOGIASOTTOLAV IN ('|| SOTT_ORD_NORMALE ||', '|| SOTT_ORD_PORTSUCCESSIVA ||')))';
      WHERE_CLAUSE := WHERE_CLAUSE || q'x AND RICH.AMBITO = 'NOW'x' || CHR(10);
    ELSE
      WHERE_CLAUSE := WHERE_CLAUSE || ' AND (ASSET.IDASSETCRMWS IS NULL';
      WHERE_CLAUSE := WHERE_CLAUSE || ' OR (ORD.TIPOLOGIALAVORAZIONE = ' || ORDINE_CESSAZIONE || q'x AND RICH.AMBITO = 'NOW')x';
      WHERE_CLAUSE := WHERE_CLAUSE || ')' || CHR(10);
    END IF;*/


    -- Lotto6: Controllo sul valore OWNER_CONSISTENZA (per il transitorio) -- SM_2994 Invertito blocco con estrai_sistina_g
    -- Valido per: SISTINA, ULISSE, INCONTRA, RI, RAES, RA
    IF NOT SKIP_CRMESTRATTORE THEN --RU_397
      IF CONSISTENZA_NOW = 'N' THEN
        IF ESTRAI = ESTRAI_F2_TD_NISIDA THEN
          WHERE_CLAUSE := WHERE_CLAUSE || q'x WHERE (ASSET.CRMESTRATTORE = 'NOW' OR ASSET.CRMESTRATTORE IS NULL)x' || CHR(10);
        ELSIF ESTRAI IN (ESTRAI_F1_TD, ESTRAI_F1_TD_NISIDA) THEN
          WHERE_CLAUSE := REPLACE (WHERE_CLAUSE, '$CRMESTRATTORE', q'xAND ASSET.CRMESTRATTORE = 'NOW'x');
        ELSIF ESTRAI IN (ESTRAI_SISTINA_G, ESTRAI_SISTINA_M) THEN
          WHERE_CLAUSE := WHERE_CLAUSE || q'x AND PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'VPISP','ATMVC') IS NOT NULLx' || CHR(10); --SM_5717
          WHERE_CLAUSE := WHERE_CLAUSE || q'x AND PKG_ESTRAZIONI.BANDA_UTENTE_FINALE(DETT.BDS_ID, ORD.BDS_ID, ASSET.BDS_ID, OFF.ID_OFFERTA, 'BandaOLO') IS NOT NULLx' || CHR(10); --SM_5777
          WHERE_CLAUSE := WHERE_CLAUSE || q'x AND (ASSET.CRMESTRATTORE = 'NOW' OR ASSET.STATOASSET = 'INLAVORAZIONE')x';
        ELSE
          WHERE_CLAUSE := WHERE_CLAUSE || q'x AND ASSET.CRMESTRATTORE = 'NOW'x' || CHR(10); -- NULL
        END IF;
      END IF;
    END IF;

    WHERE_CLAUSE := REPLACE (WHERE_CLAUSE, ' $CRMESTRATTORE', NULL);
    --/ Lotto6
    -- SORT ORDER, CURRENTLY JUST SISTINA
    IF ESTRAI IN (ESTRAI_SISTINA_G, ESTRAI_SISTINA_M) THEN
      WHERE_CLAUSE := WHERE_CLAUSE || CHR(10) || REPLACE(q'x AND NOT EXISTS (SELECT 1
      FROM SCARTI_ATM_SISTINA SC
      WHERE SC.DETT_BDSID = DETT.BDS_ID
        AND SC.IDFILE = $IDFILE)x', '$IDFILE', ID_FILE);
 --RU_1436 Commentata order by perchp portata in script esterno
/*    WHERE_CLAUSE := WHERE_CLAUSE || q'x ORDER BY CASE PKG_ESTRAZIONI.GET_IDUTENTE_FINALE(ASSET.BDS_ID, 'SISTINA')
                                                        WHEN 'POTS' THEN LPAD(ASSET.NUMEROTELEFONICO, 12, '0')
                                                        WHEN 'LineaNonFonia' THEN LPAD(ASSET.NUMEROFITTIZIO, 12, '1')
                                                        WHEN 'ISDN' THEN LPAD(ASSET.NUMEROFITTIZIO, 12, '1')
                                                        WHEN 'LnF' THEN LPAD(ASSET.NUMEROFITTIZIO, 12, '1')
                                                        ELSE ASSET.IDRISORSA END NULLS FIRST,
                                                        PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'VPIRETE'),
                                                        PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'VCIRETE')x' || CHR(10);*/
    END IF;
    /*
    IF SERVICE = SERVICE_NP THEN
       WHERE_CLAUSE := WHERE_CLAUSE || q'xAND ASSET.NUMEROTELEFONICO = ASSET.NUMTELPRINCIPALEx';
    END IF;
    */

    --INIZIO SM_9629  --Inserita Union Per Incontra
    IF SERVICE = SERVICE_INCONTRA THEN
    WHERE_CLAUSE:=NULL;
    FROM_CLAUSE := q'xFROM (select ASSET.IDRICHIESTAOLO AS RICHIESTA ,ASSET.STATOASSET,ASSET.IDRISORSA,RICH.DRO,ASSET.DES,
                            ASSET.BDS_ID as ASSET_BDS_ID,
                            ORD.TIPOLOGIALAVORAZIONE,TIP_S_LAV.TIPOLG_SOTTO_LAVRZ_GUI,OFF.NOME_OFFERTA_CATLG,
                            ORD.BDS_ID AS ORD_BDS_ID,
                            OLO.COD_OLO,
                            ASSET.CODIFICAOLOAGCOM
                            FROM BDS_1_CASEDATA_ASSET ASSET
                            JOIN BDS_1_CASEDATA_ORDINE ORD ON ASSET.IDRICHIESTAOLO = ORD.IDRICHIESTAOLO
                            LEFT JOIN BDS_1_CASEDATA_RICHIESTA RICH ON ASSET.IDRICHIESTAOLO = RICH.IDRICHIESTAOLO
                            LEFT OUTER JOIN TRASCODFC_OFFERTA TSO ON NOME_OFFERTA_ESTERNA = ASSET.OFFERTA AND PROVENIENZA = 'BPM'
                            JOIN OFFERTA OFF on TSO.ID_OFFERTA=off.id_offerta
                            LEFT JOIN CONTRATTO AGREE ON AGREE.ID_CONTRATTO = ASSET.IDCONTRATTO
                            JOIN OLO ON OLO.CODFC_OLO_AGCOM = ASSET.CODIFICAOLOAGCOM
                            LEFT OUTER JOIN TIPOLG_SOTTO_LAVRZ TIP_S_LAV ON TIP_S_LAV.DESCR = ORD.TIPOLOGIASOTTOLAV
                            WHERE OFF.ID_OFFERTA = ANY (20, 22, 25,33, 21, 26)x';
                          IF CODICE_OLO IS NOT NULL THEN
                            FROM_CLAUSE := FROM_CLAUSE || CHR(10) || ' AND ASSET.CODIFICAOLOAGCOM = ' || APICE || CODICE_OLO || APICE || CHR(10);
                         END IF;

                            FROM_CLAUSE := FROM_CLAUSE ||q'x AND (ASSET.STATOASSET = ANY ('INLAVORAZIONE', 'ATTIVO', 'CESSATO')x';

                         IF DATA_DA IS NOT NULL AND DATA_A IS NOT NULL THEN
                            FROM_CLAUSE := FROM_CLAUSE || ' AND TRUNC(ASSET.DES) BETWEEN TRUNC(' || GET_DATE(DATA_DA) || ') AND TRUNC(' || GET_DATE(DATA_A)||')';
                          ELSE
                            FROM_CLAUSE := FROM_CLAUSE || q'x AND TRUNC(ASSET.DES) = TRUNC(SYSDATE) - INTERVAL '1' DAYx';
                          END IF;
                         FROM_CLAUSE := FROM_CLAUSE || ')' || CHR(10);
                         FROM_CLAUSE := FROM_CLAUSE || q'x AND ( ( (ORD.TIPOLOGIALAVORAZIONE = 'ATTIVAZIONE'
                                                            AND TIP_S_LAV.TIPOLG_SOTTO_LAVRZ_GUI IN ('NORMALE','USCITA DA TI') OR
                                                             ( ORD.TIPOLOGIALAVORAZIONE = 'ATTIVAZIONE' AND TIP_S_LAV.TIPOLG_SOTTO_LAVRZ_GUI = 'PORTABILITA SUCCESSIVA'  and ORD.CODIFICAOLOAGCOM <> 'TLC')) )
                                                              OR (ORD.TIPOLOGIALAVORAZIONE = 'CESSAZIONE' AND TIP_S_LAV.TIPOLG_SOTTO_LAVRZ_GUI  IN ('NORMALE','USCITA DA TI'))
                                                              OR (ORD.TIPOLOGIALAVORAZIONE = 'MIGRAZIONE'
                                                              AND TIP_S_LAV.TIPOLG_SOTTO_LAVRZ_GUI IN ('MIGRAZIONE OLO', 'ATTIVAZIONE 274'))
                                                              OR (ORD.TIPOLOGIALAVORAZIONE = 'VARIAZIONE'
                                                               AND TIP_S_LAV.TIPOLG_SOTTO_LAVRZ_GUI  IN (  'CAMBIO NUMERO 3','CAMBIO NUMERO 4','TRASLOCO WLR 13','TRASLOCO WLR 14',  'TRASLOCO WLR15','TRASLOCO WLR 16', 'DECREMENTO NP' )) )
                                                            AND ASSET.CRMESTRATTORE = 'NOW'x';
                         FROM_CLAUSE := FROM_CLAUSE || q'x UNION ALL
                                          select ASSET.IDPRIMOORDINE AS RICHIESTA ,ASSET.STATOASSET,ASSET.IDRISORSA,RICH.DRO,ASSET.DES,
                                          ASSET.BDS_ID as ASSET_BDS_ID,
                                          ORD.TIPOLOGIALAVORAZIONE,TIP_S_LAV.TIPOLG_SOTTO_LAVRZ_GUI,OFF.NOME_OFFERTA_CATLG,
                                          ORD.BDS_ID AS ORD_BDS_ID,
                                          OLO.COD_OLO,
                                          ASSET.CODIFICAOLOAGCOM
                                          FROM APPUSER.BDS_1_CASEDATA_ASSET ASSET
                                          JOIN APPUSER.BDS_1_CASEDATA_ORDINE ORD ON ASSET.IDPRIMOORDINE = ORD.IDRICHIESTAOLO
                                          LEFT JOIN APPUSER.BDS_1_CASEDATA_RICHIESTA RICH ON ASSET.IDPRIMOORDINE = RICH.IDRICHIESTAOLO
                                          LEFT OUTER JOIN APPUSER.TRASCODFC_OFFERTA TSO ON NOME_OFFERTA_ESTERNA = ASSET.OFFERTA AND PROVENIENZA = 'BPM'
                                          JOIN APPUSER.OFFERTA OFF on TSO.ID_OFFERTA=off.id_offerta
                                          LEFT JOIN APPUSER.CONTRATTO AGREE ON AGREE.ID_CONTRATTO = ASSET.IDCONTRATTO
                                          JOIN APPUSER.OLO ON OLO.CODFC_OLO_AGCOM = ASSET.CODIFICAOLOAGCOM
                                          LEFT OUTER JOIN APPUSER.TIPOLG_SOTTO_LAVRZ TIP_S_LAV ON TIP_S_LAV.DESCR = ORD.TIPOLOGIASOTTOLAV
                                          WHERE OFF.ID_OFFERTA = ANY (20, 22, 25,33, 21, 26)x';
                                        IF CODICE_OLO IS NOT NULL THEN
                                          FROM_CLAUSE := FROM_CLAUSE || CHR(10) || ' AND ASSET.CODIFICAOLOAGCOM = ' || APICE || CODICE_OLO || APICE || CHR(10);
                                       END IF;

                                          FROM_CLAUSE := FROM_CLAUSE ||q'x AND (ASSET.STATOASSET = ANY ('INLAVORAZIONE', 'ATTIVO', 'CESSATO')x';

                                       IF DATA_DA IS NOT NULL AND DATA_A IS NOT NULL THEN
                                          FROM_CLAUSE := FROM_CLAUSE || ' AND TRUNC(ASSET.DES) BETWEEN TRUNC(' || GET_DATE(DATA_DA) || ') AND TRUNC(' || GET_DATE(DATA_A)||')';
                                        ELSE
                                          FROM_CLAUSE := FROM_CLAUSE || q'x AND TRUNC(ASSET.DES) = TRUNC(SYSDATE) - INTERVAL '1' DAYx';
                                        END IF;
                                       FROM_CLAUSE := FROM_CLAUSE || ')' || CHR(10);
                                      FROM_CLAUSE := FROM_CLAUSE || q'x  AND ( ( (ORD.TIPOLOGIALAVORAZIONE = 'ATTIVAZIONE'
                                                          AND TIP_S_LAV.TIPOLG_SOTTO_LAVRZ_GUI IN ('NORMALE','USCITA DA TI') OR
                                                         ( ORD.TIPOLOGIALAVORAZIONE = 'ATTIVAZIONE' AND TIP_S_LAV.TIPOLG_SOTTO_LAVRZ_GUI = 'PORTABILITA SUCCESSIVA'  and ORD.CODIFICAOLOAGCOM <> 'TLC')) )
                                                          OR (ORD.TIPOLOGIALAVORAZIONE = 'CESSAZIONE' AND TIP_S_LAV.TIPOLG_SOTTO_LAVRZ_GUI  IN ('NORMALE','USCITA DA TI'))
                                                          OR (ORD.TIPOLOGIALAVORAZIONE = 'MIGRAZIONE'
                                                          AND TIP_S_LAV.TIPOLG_SOTTO_LAVRZ_GUI IN ('MIGRAZIONE OLO', 'ATTIVAZIONE 274'))
                                                          OR (ORD.TIPOLOGIALAVORAZIONE = 'VARIAZIONE'
                                                           AND TIP_S_LAV.TIPOLG_SOTTO_LAVRZ_GUI  IN (  'CAMBIO NUMERO 3','CAMBIO NUMERO 4','TRASLOCO WLR 13','TRASLOCO WLR 14',  'TRASLOCO WLR15','TRASLOCO WLR 16', 'DECREMENTO NP' )) )
                                                        AND ASSET.DES=ORD.DES
                                                        AND ASSET.CRMESTRATTORE = 'NOW'
                                                        ) Tx';


    END IF;
 --FINE SM_9629  --Inserita Union Per Incontra


    SQL_STATEMENT := BUILD_SQL_STATEMENT(FILE_COLUMNS(SERVICE), FROM_CLAUSE, WHERE_CLAUSE, SEPARATOR => SEPARATOR, SKIP_DISTINCT => (ESTRAI IN (ESTRAI_SISTINA_G, ESTRAI_SISTINA_M)));

    LOG('   BUILT STATEMENT: ' || CHR(10) || SQL_STATEMENT);


--DBMS_OUTPUT.PUT_LINE('  ---   ');
--DBMS_OUTPUT.PUT_LINE('SQL_STATEMENT: ');
--DBMS_OUTPUT.PUT_LINE(SQL_STATEMENT);
--DBMS_OUTPUT.PUT_LINE('  ---   ');

    IF NOT RUN_QUERY THEN
      INFO('   BUILT STATEMENT: ' || CHR(10) || SQL_STATEMENT);
    ELSIF WRITE_ON_TABLE THEN
      FETCH_AND_COMMIT(SQL_STATEMENT, ID_FILE, FULL_FILE_NAME, SERVICE, SEPARATOR, ESTRAI);
    ELSE
      FETCH_AND_WRITE(SQL_STATEMENT, FULL_FILE_NAME);
    END IF;

    FOUND := GET_FOUND_STATO_ESTRAZIONI (ID_FILE);
    IF SERVICE = SERVICE_WLR THEN
      IF FOUND = 1 THEN
        FLAG_STATO := FLAG_SOLO_WLR;
      END IF;
    ELSE
      FLAG_STATO := FLAG_OK;
    END IF;

    IF RUN_QUERY THEN
      UPDATE_STATUS(ID_FILE, FLAG_STATO);
    END IF;
    LOG ('   FINISHED ASSET DATA SPOOL');

  EXCEPTION
    WHEN OTHERS THEN
    INFO('** FATAL ERROR: ' || SQLCODE || ' - ' || SQLERRM || ' **');
    UPDATE_STATUS(ID_FILE, FLAG_KO, SUBSTR(SQLCODE || SQLERRM, 1, 2000));
  END ESTRAI_GENERIC_ASSET;

-- INIZIO RU_975
  PROCEDURE ESTRAI_GENERIC_ASSET_CPS (ID_FILE             IN NUMBER,
                                  RUN_QUERY           IN BOOLEAN,
                                  ESTRAI              IN VARCHAR2,
                                  FULL_FILE_NAME      IN VARCHAR2,
                                  SERVICE             IN VARCHAR2,
                                  DATA_DA             IN VARCHAR2,
                                  DATA_A              IN VARCHAR2,
                                  CODICE_OLO          IN VARCHAR2,
                                  SEPARATOR           IN VARCHAR2 DEFAULT PIPE_SEPARATOR,
                                  SKIP_CRMESTRATTORE  IN BOOLEAN DEFAULT FALSE)
  IS
    FROM_CLAUSE       VARCHAR2(5000);
    WHERE_CLAUSE      VARCHAR2(2000);
    SQL_STATEMENT     VARCHAR2(20000);
    CONSISTENZA_NOW PARAMETRI_CFGZ_NOW.VALORE_STRINGA%TYPE; -- Lotto6
    outLAST_UPDATE  VARCHAR2(10):=NULL;

    FOUND             NUMBER;
    FLAG_STATO        VARCHAR2(50);
  BEGIN
    IF FULL_FILE_NAME IS NULL THEN
      RAISE_APPLICATION_ERROR(-20995, 'FILE_NAME CANNOT BE NULL');
    ELSIF SERVICE IS NULL THEN
      RAISE_APPLICATION_ERROR(-20994, 'SERVICE_NAME CANNOT BE NULL');
    END IF;

    LOG('   SPOOL GENERIC ASSET CPS FOR FILE ' || FULL_FILE_NAME);

    IF RUN_QUERY AND NOT CAN_START(ID_FILE, FULL_FILE_NAME) THEN
      LOG ('   EXITING BECAUSE OF CAN_START RETURNING FALSE: CHECK TABLE STATO_ESTRAZIONI.');
      RETURN;
    END IF;
    -- Lotto6: Controllo sul valore OWNER_CONSISTENZA (per il transitorio)
    SELECT VALORE_STRINGA INTO CONSISTENZA_NOW FROM PARAMETRI_CFGZ_NOW WHERE CHIAVE = 'OWNER_CONSISTENZA';
    --/ Lotto6

  BEGIN
    IF SERVICE='CPS_INC' then
      SELECT to_char(LAST_UPDATE,'YYYYMMDD')  INTO outLAST_UPDATE FROM CFG_START_ESTRAZIONI
        WHERE SISTEMA = 'INCONTRA' AND ESTRAZIONE = 'CONSISTENZE_CPS_GIORNALIERO';
    ELSE
       SELECT  to_char(LAST_UPDATE,'YYYYMMDD')  INTO outLAST_UPDATE FROM CFG_START_ESTRAZIONI
        WHERE SISTEMA = 'FRMSFRAUD' AND ESTRAZIONE = 'CONSISTENZE_CPS_GIORNALIERO';
    END IF;
  EXCEPTION
  WHEN OTHERS THEN
    LOG ('  NON TROVATA CONFIGURAZIONE per CPS SU CFG_START_ESTRAZIONI');
    RETURN;
  END;

      FROM_CLAUSE := CHR(10) || ' FROM BDS_1_CASEDATA_ASSET ASSET' || CHR(10) || JOIN_TABLES('CPS');
      WHERE_CLAUSE :=  'WHERE OFF.ID_OFFERTA = 47 '  || CHR(10);
      WHERE_CLAUSE := WHERE_CLAUSE || ' AND ';
      WHERE_CLAUSE := WHERE_CLAUSE || ' ASSET.STATOASSET = ANY (''' || STATUS_INLAVORAZIONE || ''', ''' || STATUS_ATTIVO || ''', ''' || STATUS_CESSATO || ''')';

 WHERE_CLAUSE := WHERE_CLAUSE || ' AND ( (ORD.TIPOLOGIALAVORAZIONE IN (''CESSAZIONE'',''ATTIVAZIONE'') AND TIP_S_LAV.TIPOLG_SOTTO_LAVRZ_GUI  = ''NORMALE'')';
 WHERE_CLAUSE := WHERE_CLAUSE || ' OR (TIP_S_LAV.TIPOLG_SOTTO_LAVRZ_GUI = ''RIENTROCPS'') )';

    IF CODICE_OLO IS NOT NULL THEN
      WHERE_CLAUSE := WHERE_CLAUSE || CHR(10) || ' AND ASSET.CODIFICAOLOAGCOM = ' || APICE || CODICE_OLO || APICE || CHR(10);
    END IF;
    IF nvl(CONSISTENZA_NOW,'x') IN ('N','Y') THEN
        WHERE_CLAUSE := WHERE_CLAUSE || q'x AND ASSET.CRMESTRATTORE = 'NOW'x' || CHR(10); -- NULL
    END IF;

    IF outLAST_UPDATE is not null THEN
    WHERE_CLAUSE := WHERE_CLAUSE ||' AND TO_CHAR(ASSET.DES,''YYYYMMDD'') >= ' || APICE ||outLAST_UPDATE|| APICE ;
    END IF;

    SQL_STATEMENT := BUILD_SQL_STATEMENT(FILE_COLUMNS(SERVICE), FROM_CLAUSE, WHERE_CLAUSE, FULL_FILE_NAME, SEPARATOR);

    LOG('   BUILT STATEMENT: ' || CHR(10) || SQL_STATEMENT);


--DBMS_OUTPUT.PUT_LINE('  ---   ');
--DBMS_OUTPUT.PUT_LINE('SQL_STATEMENT: ');
--DBMS_OUTPUT.PUT_LINE(SQL_STATEMENT);
--DBMS_OUTPUT.PUT_LINE('  ---   ');

    IF NOT RUN_QUERY THEN
      INFO('   BUILT STATEMENT: ' || CHR(10) || SQL_STATEMENT);
    ELSIF WRITE_ON_TABLE THEN
      FETCH_AND_COMMIT(SQL_STATEMENT, ID_FILE, FULL_FILE_NAME, SERVICE, SEPARATOR, ESTRAI);
    ELSE
      FETCH_AND_WRITE(SQL_STATEMENT, FULL_FILE_NAME);
    END IF;


      FLAG_STATO := FLAG_OK;


    IF RUN_QUERY THEN
      UPDATE_STATUS(ID_FILE, FLAG_STATO);
    END IF;
    LOG ('   FINISHED ASSET DATA SPOOL');

  EXCEPTION
    WHEN OTHERS THEN
    INFO('** FATAL ERROR: ' || SQLCODE || ' - ' || SQLERRM || ' **');
    UPDATE_STATUS(ID_FILE, FLAG_KO, SUBSTR(SQLCODE || SQLERRM, 1, 2000));
  END ESTRAI_GENERIC_ASSET_CPS;

--FINE_RU_975




  PROCEDURE ESTRAI_ULL_ATTIVI(ID_FILE       IN NUMBER,
                              DATA_INIZIO   IN VARCHAR2,
                              DATA_FINE     IN VARCHAR2,
                              CODICE_OLO    IN VARCHAR2)
  IS
  BEGIN
    PKG_ESTRAZIONI_RA.ESTRAI_ULL_ATTIVI(ID_FILE,
                                        DATA_INIZIO,
                                        DATA_FINE,
                                        CODICE_OLO);
    /*INFO('** STARTED PROCEDURE ESTRAI_ULL_ATTIVI **');
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_ATTIVI,
                          FILE_NAME_ULL_ATT || '_' || TODAY || FILE_EXT,
                          SERVICE_ULL,
                          DATA_INIZIO,
                          DATA_FINE,
                          CODICE_OLO,
                          SKIP_CRMESTRATTORE => TRUE);
    INFO('** FINISHED PROCEDURE ESTRAI_ULL_ATTIVI **');*/
  END ESTRAI_ULL_ATTIVI;

  PROCEDURE ESTRAI_ULL_CESSATI(ID_FILE           IN NUMBER,
                               DATA_ESPLETAMENTO IN VARCHAR2)
  IS
  BEGIN
    PKG_ESTRAZIONI_RA.ESTRAI_ULL_CESSATI(ID_FILE,
                                          DATA_ESPLETAMENTO);
    /*INFO('** STARTED PROCEDURE ESTRAI_ULL_CESSATI **');
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_CESSATI,
                          FILE_NAME_ULL_CESS || '_' || TODAY || FILE_EXT,
                          SERVICE_ULL,
                          NULL,
                          DATA_ESPLETAMENTO,
                          NULL,
                          SKIP_CRMESTRATTORE => TRUE);
    INFO('** FINISHED PROCEDURE ESTRAI_ULL_CESSATI **');*/
  END ESTRAI_ULL_CESSATI;

 PROCEDURE ESTRAI_ULLD_ATTIVI(ID_FILE       IN NUMBER,
                              DATA_INIZIO   IN VARCHAR2,
                              DATA_FINE     IN VARCHAR2,
                              CODICE_OLO    IN VARCHAR2)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_ULLD_ATTIVI **');
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_ATTIVI,
                          FILE_NAME_ULLD_ATT || '_' || TODAY || FILE_EXT,
                          SERVICE_ULLD,
                          DATA_INIZIO,
                          DATA_FINE,
                          CODICE_OLO,
                          SKIP_CRMESTRATTORE => TRUE);
    INFO('** FINISHED PROCEDURE ESTRAI_ULLD_ATTIVI **');
  END ESTRAI_ULLD_ATTIVI;

  PROCEDURE ESTRAI_ULLD_CESSATI(ID_FILE           IN NUMBER,
                                DATA_ESPLETAMENTO IN VARCHAR2)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_ULLD_CESSATI **');
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_CESSATI,
                          FILE_NAME_ULLD_CESS || '_' || TODAY || FILE_EXT,
                          SERVICE_ULLD,
                          NULL,
                          DATA_ESPLETAMENTO,
                          NULL,
                          SKIP_CRMESTRATTORE => TRUE);
    INFO('** FINISHED PROCEDURE ESTRAI_ULLD_CESSATI **');
  END ESTRAI_ULLD_CESSATI;

  PROCEDURE ESTRAI_SLU_ATTIVI(ID_FILE       IN NUMBER,
                              DATA_INIZIO   IN VARCHAR2,
                              DATA_FINE     IN VARCHAR2,
                              CODICE_OLO    IN VARCHAR2)
  IS
  BEGIN
    PKG_ESTRAZIONI_RA.ESTRAI_SLU_ATTIVI(ID_FILE,
                                    DATA_INIZIO,
                                    DATA_FINE,
                                    CODICE_OLO);
    /*INFO('** STARTED PROCEDURE ESTRAI_SLU_ATTIVI **');
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_ATTIVI,
                          FILE_NAME_SLU_ATT || '_' || TODAY || FILE_EXT,
                          SERVICE_SLU,
                          DATA_INIZIO,
                          DATA_FINE,
                          CODICE_OLO,
                          SKIP_CRMESTRATTORE => TRUE);
    INFO('** FINISHED PROCEDURE ESTRAI_SLU_ATTIVI **');*/
  END ESTRAI_SLU_ATTIVI;

  PROCEDURE ESTRAI_SLU_CESSATI(ID_FILE           IN NUMBER,
                               DATA_ESPLETAMENTO IN VARCHAR2)
  IS
  BEGIN
    PKG_ESTRAZIONI_RA.ESTRAI_SLU_CESSATI(ID_FILE,
                                          DATA_ESPLETAMENTO);
   /* INFO('** STARTED PROCEDURE ESTRAI_SLU_CESSATI **');
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_CESSATI,
                          FILE_NAME_SLU_CESS || '_' || TODAY || FILE_EXT,
                          SERVICE_SLU,
                          NULL,
                          DATA_ESPLETAMENTO,
                          NULL,
                          SKIP_CRMESTRATTORE => TRUE);
    INFO('** FINISHED PROCEDURE ESTRAI_SLU_CESSATI **');*/
  END ESTRAI_SLU_CESSATI;

  PROCEDURE ESTRAI_ORDINI_GIACENTI_REG(ID_FILE      IN NUMBER)
  IS
    AMBITO tAMBITO;
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_ORDINI_GIACENTI_REG **');

    APPUSER.PKG_ESTRAZIONI_RA.ESTRAI_ORDINI_GIACENTI_REG(ID_FILE);
    /*
    AMBITO := tAMBITO(FAMIGLIA_REGOLATORIO);

    ESTRAI_GENERIC_ORDINI(ID_FILE,
                          AMBITO,
                          ORDINI_GIACENTI_REG, --sm_1819
                          FILE_NAME_REGOLATORIO || '_' || TODAY || FILE_EXT,
                          gRUNQUERY);
    */
    INFO('** FINISHED PROCEDURE ESTRAI_ORDINI_GIACENTI_REG **');
  END ESTRAI_ORDINI_GIACENTI_REG;

  PROCEDURE ESTRAI_ORDINI_GIACENTI_XDSL(ID_FILE      IN NUMBER)
  IS
    AMBITO tAMBITO;
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_ORDINI_GIACENTI_XDSL **');

    APPUSER.PKG_ESTRAZIONI_RA.ESTRAI_ORDINI_GIACENTI_XDSL(ID_FILE);
    /*
    AMBITO := tAMBITO(FAMIGLIA_BITSTREAM, FAMIGLIA_EASYIP);

    ESTRAI_GENERIC_ORDINI(ID_FILE,
                          AMBITO,
                          ORDINI_GIACENTI_XDSL,  --SM_1819
                          FILE_NAME_XDSL || '_' || TODAY || FILE_EXT,
                          gRUNQUERY);
    */
    INFO('** FINISHED PROCEDURE ESTRAI_ORDINI_GIACENTI_XDSL **');
  END ESTRAI_ORDINI_GIACENTI_XDSL;

  PROCEDURE ESTRAI_ORDINI_GIACENTI_NGAVULA(ID_FILE      IN NUMBER)
  IS
    AMBITO tAMBITO;
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_ORDINI_GIACENTI_NGAVULA **');

    APPUSER.PKG_ESTRAZIONI_RA.ESTRAI_ORDINI_GIACENTI_NGAVULA(ID_FILE);
    /*
    AMBITO := tAMBITO(FAMIGLIA_NGA, FAMIGLIA_VULA);

    ESTRAI_GENERIC_ORDINI(ID_FILE,
                          AMBITO,
                          ORDINI_GIACENTI_NGAVULA,
                          FILE_NAME_NGAVULA || '_' || TODAY || FILE_EXT,
                          gRUNQUERY);
    */
    INFO('** FINISHED PROCEDURE ESTRAI_ORDINI_GIACENTI_NGAVULA **');
  END ESTRAI_ORDINI_GIACENTI_NGAVULA;

PROCEDURE ESTRAI_ORDINI_NOW_RI_REG(ID_FILE      IN NUMBER)
  IS
    AMBITO tAMBITO;
  BEGIN
    -- PKG_ESTRAZIONI_RA.ESTRAI_ORDINI_NOW_RI_REG(ID_FILE);
    INFO('** STARTED PROCEDURE ESTRAI_ORDINI_NOW_RI_REG **');

    APPUSER.PKG_ESTRAZIONI_RA.ESTRAI_ORDINI_NOW_RI_REG(ID_FILE);


    /*
    AMBITO := tAMBITO(FAMIGLIA_REGOLATORIO);

    ESTRAI_GENERIC_ORDINI(ID_FILE,
                          AMBITO,
                          ORDINI_NOW_RI_REG,
                          FILE_NAME_RI_REG || '_' || TODAY || FILE_EXT,
                          gRUNQUERY);
    INFO('** FINISHED PROCEDURE ESTRAI_ORDINI_NOW_RI_REG **');
  */

  END ESTRAI_ORDINI_NOW_RI_REG;

  PROCEDURE ESTRAI_ORDINI_NOW_RI_XDSL(ID_FILE      IN NUMBER)
  IS
    AMBITO tAMBITO;
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_ORDINI_NOW_RI_XDSL **');

    APPUSER.PKG_ESTRAZIONI_RA.ESTRAI_ORDINI_NOW_RI_XDSL(ID_FILE);

    /*
    AMBITO := tAMBITO(FAMIGLIA_BITSTREAM, FAMIGLIA_EASYIP);

    ESTRAI_GENERIC_ORDINI(ID_FILE,
                          AMBITO,
                          ORDINI_NOW_RI_XDSL,
                          FILE_NAME_RI_XDSL || '_' || TODAY || FILE_EXT,
                          gRUNQUERY);
    INFO('** FINISHED PROCEDURE ESTRAI_ORDINI_NOW_RI_XDSL **');
  */
  END ESTRAI_ORDINI_NOW_RI_XDSL;

  PROCEDURE ESTRAI_ORDINI_NOW_RI_NGAVULA(ID_FILE      IN NUMBER)
  IS
    AMBITO tAMBITO;
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_ORDINI_NOW_RI_NGAVULA **');

    APPUSER.PKG_ESTRAZIONI_RA.ESTRAI_ORDINI_NOW_RI_NGAVULA(ID_FILE);

    /*
    AMBITO := tAMBITO(FAMIGLIA_NGA, FAMIGLIA_VULA);

    ESTRAI_GENERIC_ORDINI(ID_FILE,
                          AMBITO,
                          ORDINI_NOW_RI_NGAVULA,
                          FILE_NAME_RI_NGAVULA || '_' || TODAY || FILE_EXT,
                          gRUNQUERY);
    INFO('** FINISHED PROCEDURE ESTRAI_ORDINI_NOW_RI_NGAVULA **');
  */
  END ESTRAI_ORDINI_NOW_RI_NGAVULA;

  PROCEDURE ESTRAI_BSGBE_ATTIVI(ID_FILE       IN NUMBER,
                                DATA_INIZIO   IN VARCHAR2,
                                DATA_FINE     IN VARCHAR2,
                                CODICE_OLO    IN VARCHAR2)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_BSGBE_ATTIVI **');

      APPUSER.PKG_ESTRAZIONI_RA.ESTRAI_BSGBE_ATTIVI(ID_FILE,
                                                    DATA_INIZIO,
                                                    DATA_FINE,
                                                    CODICE_OLO);
      /*
      ESTRAI_GENERIC_ASSET (ID_FILE,
                            gRUNQUERY,
                            ESTRAI_ATTIVI,
                            FILE_NAME_BSGBE_ATT || '_' || TODAY || FILE_EXT,
                            SERVICE_BSGBE,
                            DATA_INIZIO,
                            DATA_FINE,
                            CODICE_OLO,
                            SKIP_CRMESTRATTORE => TRUE);
    */
    INFO('** FINISHED PROCEDURE ESTRAI_BSGBE_ATTIVI **');
  END ESTRAI_BSGBE_ATTIVI;

  PROCEDURE ESTRAI_BSGBE_CESSATI(ID_FILE            IN NUMBER,
                                 DATA_ESPLETAMENTO  IN VARCHAR2)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_BSGBE_CESSATI **');


      APPUSER.PKG_ESTRAZIONI_RA.ESTRAI_BSGBE_CESSATI(ID_FILE,
                                                     DATA_ESPLETAMENTO);
      /*
      ESTRAI_GENERIC_ASSET (ID_FILE,
                            gRUNQUERY,
                            ESTRAI_CESSATI,
                            FILE_NAME_BSGBE_CESS || '_' || TODAY || FILE_EXT,
                            SERVICE_BSGBE,
                            NULL,
                            DATA_ESPLETAMENTO,
                            NULL,
                            SKIP_CRMESTRATTORE => TRUE);
    */
    INFO('** FINISHED PROCEDURE ESTRAI_BSGBE_CESSATI **');
  END ESTRAI_BSGBE_CESSATI;

  PROCEDURE ESTRAI_BSATM_ATTIVI(ID_FILE       IN NUMBER,
                                DATA_INIZIO   IN VARCHAR2,
                                DATA_FINE     IN VARCHAR2,
                                CODICE_OLO    IN VARCHAR2)
  IS
  BEGIN
    PKG_ESTRAZIONI_RA.ESTRAI_BSATM_ATTIVI(ID_FILE,
                                          DATA_INIZIO,
                                          DATA_FINE,
                                          CODICE_OLO);
  END ESTRAI_BSATM_ATTIVI;

  PROCEDURE ESTRAI_BSATM_CESSATI(ID_FILE            IN NUMBER,
                                 DATA_ESPLETAMENTO  IN VARCHAR2)
  IS
  BEGIN
    PKG_ESTRAZIONI_RA.ESTRAI_BSATM_CESSATI(ID_FILE,
                                           DATA_ESPLETAMENTO);
  END ESTRAI_BSATM_CESSATI;

  PROCEDURE ESTRAI_EASYIP_ATTIVI(ID_FILE        IN NUMBER,
                                 DATA_INIZIO    IN VARCHAR2,
                                 DATA_FINE      IN VARCHAR2,
                                 CODICE_OLO     IN VARCHAR2)
  IS
  BEGIN
    PKG_ESTRAZIONI_RA.ESTRAI_EASYIP_ATTIVI(ID_FILE,
                                           DATA_INIZIO,
                                           DATA_FINE,
                                           CODICE_OLO);
  END ESTRAI_EASYIP_ATTIVI;

  PROCEDURE ESTRAI_EASYIP_CESSATI(ID_FILE           IN NUMBER,
                                  DATA_ESPLETAMENTO IN VARCHAR2)
  IS
  BEGIN
    PKG_ESTRAZIONI_RA.ESTRAI_EASYIP_CESSATI(ID_FILE,
                                            DATA_ESPLETAMENTO);
  END ESTRAI_EASYIP_CESSATI;

  PROCEDURE ESTRAI_VC_ATM_ATTIVI(ID_FILE      IN NUMBER,
                                 DATA_INIZIO  IN VARCHAR2,
                                 DATA_FINE    IN VARCHAR2,
                                 CODICE_OLO   IN VARCHAR2)
  IS
  BEGIN
    PKG_ESTRAZIONI_RA.ESTRAI_VC_ATM_ATTIVI(ID_FILE,
                                           DATA_INIZIO,
                                           DATA_FINE,
                                           CODICE_OLO);
  END ESTRAI_VC_ATM_ATTIVI;

  PROCEDURE ESTRAI_VC_ATM_CESSATI(ID_FILE           IN NUMBER,
                                  DATA_ESPLETAMENTO IN VARCHAR2)
  IS
  BEGIN
    PKG_ESTRAZIONI_RA.ESTRAI_VC_ATM_CESSATI(ID_FILE,
                                            DATA_ESPLETAMENTO);
  END ESTRAI_VC_ATM_CESSATI;

PROCEDURE ESTRAI_VC_VLAN_ATTIVI(ID_FILE       IN NUMBER,
                                DATA_INIZIO   IN VARCHAR2,
                                DATA_FINE     IN VARCHAR2,
                                CODICE_OLO    IN VARCHAR2)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_VC_VLAN_ATTIVI **');


      APPUSER.PKG_ESTRAZIONI_RA.ESTRAI_VC_VLAN_ATTIVI(ID_FILE,
                                                      DATA_INIZIO,
                                                      DATA_FINE,
                                                      CODICE_OLO);
      /*
      ESTRAI_GENERIC_ASSET (ID_FILE,
                            gRUNQUERY,
                            ESTRAI_ATTIVI,
                            FILE_NAME_VC_VLAN_ATT || '_' || TODAY || FILE_EXT,
                            VC_VLAN,
                            DATA_INIZIO,
                            DATA_FINE,
                            CODICE_OLO,
                            SKIP_CRMESTRATTORE => TRUE);
    */
    INFO('** FINISHED PROCEDURE ESTRAI_VC_VLAN_ATTIVI **');
  END ESTRAI_VC_VLAN_ATTIVI;

  PROCEDURE ESTRAI_VC_VLAN_CESSATI(ID_FILE            IN NUMBER,
                                   DATA_ESPLETAMENTO  IN VARCHAR2)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_VC_VLAN_CESSATI **');


      APPUSER.PKG_ESTRAZIONI_RA.ESTRAI_VC_VLAN_CESSATI(ID_FILE,
                                                       DATA_ESPLETAMENTO);
      /*
      ESTRAI_GENERIC_ASSET (ID_FILE,
                            gRUNQUERY,
                            ESTRAI_CESSATI,
                            FILE_NAME_VC_VLAN_CESS || '_' || TODAY || FILE_EXT,
                            VC_VLAN,
                            NULL,
                            DATA_ESPLETAMENTO,
                            NULL,
                            SKIP_CRMESTRATTORE => TRUE);
    */
    INFO('** FINISHED PROCEDURE ESTRAI_VC_VLAN_CESSATI **');
  END ESTRAI_VC_VLAN_CESSATI;

  PROCEDURE ESTRAI_F1_TD_INNOVATIVA(ID_FILE      IN NUMBER)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_F1_TD_INNOVATIVA **');


    APPUSER.PKG_ESTRAZIONI_RA.ESTRAI_F1_TD_INNOVATIVA(ID_FILE);

    /*
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_F1_TD,
                          FILE_NAME_F1_TD_INNOV || '_' || TODAY('DD_MM_YY') || FILE_EXT_TD,
                          F1_TD_INNOV,
                          NULL,
                          NULL,
                          NULL,
                          SKIP_CRMESTRATTORE => TRUE);
    $*/
    INFO('** FINISHED PROCEDURE ESTRAI_F1_TD_INNOVATIVA **');
  END ESTRAI_F1_TD_INNOVATIVA;

  PROCEDURE ESTRAI_F2_TD_INNOVATIVA(ID_FILE      IN NUMBER)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_F2_TD_INNOVATIVA **');
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_F2_TD,
                          FILE_NAME_F2_TD_INNOV || '_' || TODAY('DD_MM_YY') || FILE_EXT_TD,
                          F2_TD_INNOV,
                          NULL,
                          NULL,
                          NULL,
                          SKIP_CRMESTRATTORE => TRUE);
    INFO('** FINISHED PROCEDURE ESTRAI_F2_TD_INNOVATIVA **');
  END ESTRAI_F2_TD_INNOVATIVA;


  PROCEDURE ESTRAI_F1_TD_INNOVATIVA_NISIDA(ID_FILE      IN NUMBER)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_F1_TD_INNOVATIVA NISIDA**');
    APPUSER.PKG_ESTRAZIONI_NISIDA.ESTRAI_F1_TD_INNOVATIVA(ID_FILE);

    /*
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_F1_TD_NISIDA,
                          FILE_NAME_F1_TD_INNOV_NISIDA || '_' || TODAY('DD_MM_YY') || FILE_EXT_TD,
                          F1_TD_INNOV_NISIDA,
                          NULL,
                          NULL,
                          NULL);
    */
    INFO('** FINISHED PROCEDURE ESTRAI_F1_TD_INNOVATIVA NISIDA **');
  END ESTRAI_F1_TD_INNOVATIVA_NISIDA;

  PROCEDURE ESTRAI_F2_TD_INNOVATIVA_NISIDA(ID_FILE      IN NUMBER)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_F2_TD_INNOVATIVA NISIDA **');
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_F2_TD_NISIDA,
                          FILE_NAME_F2_TD_INNOV_NISIDA || '_' || TODAY('DD_MM_YY') || FILE_EXT_TD,
                          F2_TD_INNOV_NISIDA,
                          NULL,
                          NULL,
                          NULL);
    INFO('** FINISHED PROCEDURE ESTRAI_F2_TD_INNOVATIVA NISIDA **');
  END ESTRAI_F2_TD_INNOVATIVA_NISIDA;
  PROCEDURE ESTRAI_NOW_RI_ULL (ID_FILE      IN NUMBER,
                               DATA_INIZIO  IN VARCHAR2,
                               DATA_FINE    IN VARCHAR2)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_NOW_RI_ULL **');
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_ATTIVI_RI,
                          FILE_NAME_NOWRI_ULL || '_' || FORMAT_DATE(DATA_INIZIO, 'YYYYMMDD') ||  '_' || FORMAT_DATE(DATA_FINE, 'YYYYMMDD') || FILE_EXT,
                          SERVICE_ULL_RI,
                          DATA_INIZIO,
                          DATA_FINE,
                          NULL);
    INFO('** FINISHED PROCEDURE ESTRAI_NOW_RI_ULL **');
  END ESTRAI_NOW_RI_ULL;

  PROCEDURE ESTRAI_NOW_RI_ULLD (ID_FILE      IN NUMBER,
                                DATA_INIZIO  IN VARCHAR2,
                                DATA_FINE    IN VARCHAR2)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_NOW_RI_ULLD **');
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_ATTIVI_RI,
                          FILE_NAME_NOWRI_ULLD || '_' || FORMAT_DATE(DATA_INIZIO, 'YYYYMMDD') ||  '_' || FORMAT_DATE(DATA_FINE, 'YYYYMMDD') || FILE_EXT,
                          SERVICE_ULLD_RI,
                          DATA_INIZIO,
                          DATA_FINE,
                          NULL);
    INFO('** FINISHED PROCEDURE ESTRAI_NOW_RI_ULLD **');
  END ESTRAI_NOW_RI_ULLD;

  PROCEDURE ESTRAI_NOW_RI_SLU (ID_FILE      IN NUMBER,
                                DATA_INIZIO  IN VARCHAR2,
                                DATA_FINE    IN VARCHAR2)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_NOW_RI_SLU **');
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_ATTIVI_RI,
                          FILE_NAME_NOWRI_SLU || '_' || FORMAT_DATE(DATA_INIZIO, 'YYYYMMDD') ||  '_' || FORMAT_DATE(DATA_FINE, 'YYYYMMDD') || FILE_EXT,
                          SERVICE_SLU_RI,
                          DATA_INIZIO,
                          DATA_FINE,
                          NULL);
    INFO('** FINISHED PROCEDURE ESTRAI_NOW_RI_SLU **');
  END ESTRAI_NOW_RI_SLU;

  PROCEDURE ESTRAI_NOW_RI_ATM (ID_FILE      IN NUMBER,
                                DATA_INIZIO  IN VARCHAR2,
                                DATA_FINE    IN VARCHAR2)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_NOW_RI_ATM **');
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_ATTIVI_RI,
                          FILE_NAME_NOWRI_ATM || '_' || FORMAT_DATE(DATA_INIZIO, 'YYYYMMDD') ||  '_' || FORMAT_DATE(DATA_FINE, 'YYYYMMDD') || FILE_EXT,
                          SERVICE_ATM_RI,
                          DATA_INIZIO,
                          DATA_FINE,
                          NULL);
    INFO('** FINISHED PROCEDURE ESTRAI_NOW_RI_SLU **');
  END ESTRAI_NOW_RI_ATM;

  PROCEDURE ESTRAI_NOW_RI_GBE (ID_FILE      IN NUMBER,
                                DATA_INIZIO  IN VARCHAR2,
                                DATA_FINE    IN VARCHAR2)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_NOW_RI_GBE **');
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_ATTIVI_RI,
                          FILE_NAME_NOWRI_GBE || '_' || FORMAT_DATE(DATA_INIZIO, 'YYYYMMDD') ||  '_' || FORMAT_DATE(DATA_FINE, 'YYYYMMDD') || FILE_EXT,
                          SERVICE_GBE_RI,
                          DATA_INIZIO,
                          DATA_FINE,
                          NULL);
    INFO('** FINISHED PROCEDURE ESTRAI_NOW_RI_GBE **');
  END ESTRAI_NOW_RI_GBE;

  PROCEDURE ESTRAI_NOW_RI_EASYIP (ID_FILE      IN NUMBER,
                                DATA_INIZIO  IN VARCHAR2,
                                DATA_FINE    IN VARCHAR2)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_NOW_RI_EASYIP **');
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_ATTIVI_RI,
                          FILE_NAME_NOWRI_EASYIP || '_' || FORMAT_DATE(DATA_INIZIO, 'YYYYMMDD') ||  '_' || FORMAT_DATE(DATA_FINE, 'YYYYMMDD') || FILE_EXT,
                          SERVICE_EASYIP_RI,
                          DATA_INIZIO,
                          DATA_FINE,
                          NULL);
    INFO('** FINISHED PROCEDURE ESTRAI_NOW_RI_EASYIP **');
  END ESTRAI_NOW_RI_EASYIP;

  PROCEDURE ESTRAI_NOW_RI_NGAVULA (ID_FILE      IN NUMBER,
                                DATA_INIZIO  IN VARCHAR2,
                                DATA_FINE    IN VARCHAR2)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_NOW_RI_NGAVULA **');
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_ATTIVI_RI,
                          FILE_NAME_NOWRI_VULA || '_' || FORMAT_DATE(DATA_INIZIO, 'YYYYMMDD') ||  '_' || FORMAT_DATE(DATA_FINE, 'YYYYMMDD') || FILE_EXT,
                          SERVICE_VULA_RI,
                          DATA_INIZIO,
                          DATA_FINE,
                          NULL);
    INFO('** FINISHED PROCEDURE ESTRAI_NOW_RI_NGAVULA **');
  END ESTRAI_NOW_RI_NGAVULA;

  PROCEDURE ESTRAI_NOW_RI_VC (ID_FILE      IN NUMBER,
                                DATA_INIZIO  IN VARCHAR2,
                                DATA_FINE    IN VARCHAR2)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_NOW_RI_VC **');
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_ATTIVI_RI,
                          FILE_NAME_NOWRI_VC || '_' || FORMAT_DATE(DATA_INIZIO, 'YYYYMMDD') ||  '_' || FORMAT_DATE(DATA_FINE, 'YYYYMMDD') || FILE_EXT,
                          NOWRI_VC_ATM,
                          DATA_INIZIO,
                          DATA_FINE,
                          NULL);
    INFO('** FINISHED PROCEDURE ESTRAI_NOW_RI_VC **');
  END ESTRAI_NOW_RI_VC;

  PROCEDURE ESTRAI_NOW_RI_UVLAN (ID_FILE      IN NUMBER,
                                DATA_INIZIO  IN VARCHAR2,
                                DATA_FINE    IN VARCHAR2)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_NOW_RI_UVLAN **');
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_ATTIVI_RI,
                          FILE_NAME_NOWRI_UVLAN || '_' || FORMAT_DATE(DATA_INIZIO, 'YYYYMMDD') ||  '_' || FORMAT_DATE(DATA_FINE, 'YYYYMMDD') || FILE_EXT,
                          NOWRI_UVLAN,
                          DATA_INIZIO,
                          DATA_FINE,
                          NULL);
    INFO('** FINISHED PROCEDURE ESTRAI_NOW_RI_UVLAN **');
  END ESTRAI_NOW_RI_UVLAN;

  PROCEDURE ESTRAI_NOW_RI_CVLAN (ID_FILE      IN NUMBER,
                                DATA_INIZIO  IN VARCHAR2,
                                DATA_FINE    IN VARCHAR2)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_NOW_RI_CVLAN **');
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_ATTIVI_RI,
                          FILE_NAME_NOWRI_CVLAN || '_' || FORMAT_DATE(DATA_INIZIO, 'YYYYMMDD') ||  '_' || FORMAT_DATE(DATA_FINE, 'YYYYMMDD') || FILE_EXT,
                          NOWRI_CVLAN,
                          DATA_INIZIO,
                          DATA_FINE,
                          NULL);
    INFO('** FINISHED PROCEDURE ESTRAI_NOW_RI_CVLAN **');
  END ESTRAI_NOW_RI_CVLAN;

  PROCEDURE FILL_SCARTI_ATM_SISTINA_OLD(inIDFILE     IN NUMBER,
                                    ESTRAI       IN VARCHAR2,
                                    DATA_DA      IN VARCHAR2,
                                    DATA_A       IN VARCHAR2)
  IS
    TYPE tSCARTI IS TABLE OF SCARTI_ATM_SISTINA%ROWTYPE;

    SCARTI          tSCARTI;
    SQL_STATEMENT   VARCHAR2(5000);
    cRECORDS        SYS_REFCURSOR;
    CONSISTENZA_NOW PARAMETRI_CFGZ_NOW.VALORE_STRINGA%TYPE;
  BEGIN
    LOG ('*** STARTING PROCEDURE FILL_SCARTI_ATM_SISTINA');

    SELECT VALORE_STRINGA INTO CONSISTENZA_NOW FROM PARAMETRI_CFGZ_NOW WHERE CHIAVE = 'OWNER_CONSISTENZA';


    SQL_STATEMENT := q'x
    SELECT :IDFILE,
           SYSTIMESTAMP,
           DETT.BDS_ID DETT_BDS_ID,
           CASE PKG_ESTRAZIONI.GET_IDUTENTE_FINALE(ASSET.BDS_ID, 'SISTINA') WHEN 'POTS' THEN LPAD(ASSET.NUMEROTELEFONICO, 12, '0') WHEN 'LineaNonFonia' THEN LPAD(ASSET.NUMEROFITTIZIO, 12, '1') WHEN 'ISDN' THEN LPAD(ASSET.NUMEROFITTIZIO, 12, '1') WHEN 'LnF' THEN LPAD(ASSET.NUMEROFITTIZIO, 12, '1') ELSE ASSET.IDRISORSA END ID_UTENTE_FINALE,
           ASSET.CODIFICAOLOAGCOM CODICE_GESTORE,
           CASE WHEN ASSET.DESPRIMOORDINE IS NOT NULL THEN PKG_ESTRAZIONI.SET_DATE(ASSET.DESPRIMOORDINE) || ' ' || PKG_ESTRAZIONI.SET_DATE(ASSET.ORA_DES, 'hh24:mi:ss') ELSE NULL END DATA_PRIMO_NOLEGGIO,
           PKG_ESTRAZIONI.SET_DATE(ASSET.DES) || ' ' || PKG_ESTRAZIONI.SET_DATE(ASSET.ORA_DES, 'hh24:mi:ss') DATE_DES,
           ASSET.BDS_ID DESC_OCS,
           CASE OFF.ID_OFFERTA WHEN 8 THEN 'BTS_FLAS' WHEN 9 THEN 'BTS_HLAS' WHEN 10 THEN 'BTS_LITE' WHEN 39 THEN 'BTS_FLSI' WHEN 40 THEN 'BTS_HLSI' ELSE NULL END DESCRIZIONE_SERVIZIO,
           CASE OFF.IDTPLG_PAGAMENTO_ACCS WHEN 1 THEN 'F' ELSE 'C' END MODALITA_FATTURAZIONE,
           PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'TIPOPROFILOVC') CLASSE_SERVIZIO,
           (SELECT PCR_DOWN FROM PROFILO_VC WHERE ID_PRFL_VC = RTRIM(PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'IDPROFILOVC'), '.0')) VELOCITA_ACS_UTENTE_FINALE,
           NULL CAUSALE_SCARTO,
         --RU_1322
           CASE PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'TIPOPROTOCOLLO','PROTOCOLLO') WHEN 'FR' THEN 'FR' ELSE 'ATM' END PROTOCOLLO_UTENTE_FINALE,
           PKG_ESTRAZIONI.CODE_AREA_RACC(ASSET.BDS_ID, 'COD_AREA_RACCOLTA') AREA_DI_RACCOLTA,
           --SM_10778 PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'VPI','ATMVC') VPI_OLO,
           NULL VPI_OLO,
           PKG_ESTRAZIONI.BANDA_UTENTE_FINALE(DETT.BDS_ID, ORD.BDS_ID, ASSET.BDS_ID, OFF.ID_OFFERTA, 'BandaOLO') BANDA_OLO,
           ASSET.IDRISORSA DESC_ID_XDSL,
          PKG_ESTRAZIONI.CODE_AREA_RACC(ASSET.BDS_ID, 'COD_AREA_RACCOLTA') AREA_DI_RACCOLTA_KDC
    FROM BDS_1_CASEDATA_ASSET ASSET
 LEFT JOIN BDS_1_CASEDATA_ORDINE ORD ON ASSET.IDRICHIESTAOLO = ORD.IDRICHIESTAOLO
        LEFT JOIN BDS_1_CASEDATA_RICHIESTA RICH ON ASSET.IDRICHIESTAOLO = RICH.IDRICHIESTAOLO  --SM_2907 Inserite Outer join e modificato legame tra offerta e asset
        LEFT OUTER JOIN TRASCODFC_OFFERTA TSO ON NOME_OFFERTA_ESTERNA = ASSET.OFFERTA AND PROVENIENZA = 'BPM'
        JOIN OFFERTA OFF on TSO.ID_OFFERTA=off.id_offerta
        LEFT JOIN CONTRATTO AGREE ON AGREE.ID_CONTRATTO = ASSET.IDCONTRATTO
  JOIN BDS_1_CASEDATA_DETTAGLIOASSET DETT ON DETT.ASSET_DETTAGLIOASSET_BDSID = ASSET.BDS_ID AND DETT.NOMECOMPONENTE = 'ATMVC'
  JOIN BDS_1_CASEDATA_ATTRIBTDTTGLSST ATTR ON ATTR.DTTGLSST_TTRBTIDTTGLISST_BDSID = DETT.BDS_ID AND ATTR.NOMEATTRIBUTO = 'IDRISORSAVC'
 WHERE OFF.ID_OFFERTA = ANY (8, 9, 10, 39, 40)x' || CHR(10);

    IF CONSISTENZA_NOW = 'N' THEN
      SQL_STATEMENT := SQL_STATEMENT || q'x AND (ASSET.CRMESTRATTORE = 'NOW' OR ASSET.STATOASSET = 'INLAVORAZIONE')x' || CHR(10);
    END IF;

/* --RU_1322
    IF ESTRAI = ESTRAI_SISTINA_G THEN
      SQL_STATEMENT := SQL_STATEMENT || ' AND TRUNC(ASSET.LASTUPDATE) = ' || GET_DATE(DATA_A);
    ELSIF ESTRAI = ESTRAI_SISTINA_M THEN
      SQL_STATEMENT := SQL_STATEMENT || ' AND ASSET.LASTUPDATE BETWEEN ' || GET_DATE(DATA_DA) || ' AND ' || GET_DATE(DATA_A);
    END IF;
*/
    LOG ('*** SPOOLING QUERY: ' || CHR(10) || SQL_STATEMENT);

    OPEN cRECORDS FOR SQL_STATEMENT USING inIDFILE;

    <<MAIN_LOOP>>
    LOOP
      FETCH cRECORDS BULK COLLECT INTO SCARTI LIMIT 10000;
      EXIT WHEN SCARTI IS EMPTY;

      <<PROCESS_LOOP>>
      FOR K IN 1..SCARTI.LAST LOOP
        IF SCARTI(K).ID_UTENTE_FINALE IS NULL THEN
          SCARTI(K).CAUS_SCARTO := 'ID_UTENTE_FINALE NON VALORIZZATO';
          INSERT INTO SCARTI_ATM_SISTINA
          VALUES SCARTI(K);
        ELSIF SCARTI(K).CODICE_GESTORE IS NULL THEN
          SCARTI(K).CAUS_SCARTO := 'CODICE_GESTORE NON VALORIZZATO';
          INSERT INTO SCARTI_ATM_SISTINA
          VALUES SCARTI(K);
        ELSIF SCARTI(K).DATA_PRIMO_NOLEGGIO IS NULL THEN
          SCARTI(K).CAUS_SCARTO := 'DATA_PRIMO_NOLEGGIO NON VALORIZZATO';
          INSERT INTO SCARTI_ATM_SISTINA
          VALUES SCARTI(K);
        ELSIF SCARTI(K).DATE_DES IS NULL THEN
          SCARTI(K).CAUS_SCARTO := 'DATE_DES NON VALORIZZATO';
          INSERT INTO SCARTI_ATM_SISTINA
          VALUES SCARTI(K);
        ELSIF SCARTI(K).DESC_OCS IS NULL THEN
          SCARTI(K).CAUS_SCARTO := 'DESC_OCS NON VALORIZZATO';
          INSERT INTO SCARTI_ATM_SISTINA
          VALUES SCARTI(K);
        ELSIF SCARTI(K).DESCRIZIONE_SERVIZIO IS NULL THEN
          SCARTI(K).CAUS_SCARTO := 'DESCRIZIONE_SERVIZIO NON VALORIZZATO';
          INSERT INTO SCARTI_ATM_SISTINA
          VALUES SCARTI(K);
        ELSIF SCARTI(K).MODALITA_FATTURAZIONE IS NULL THEN
          SCARTI(K).CAUS_SCARTO := 'MODALITA_FATTURAZIONE NON VALORIZZATO';
          INSERT INTO SCARTI_ATM_SISTINA
          VALUES SCARTI(K);
        ELSIF SCARTI(K).CLASSE_SERVIZIO IS NULL THEN
          SCARTI(K).CAUS_SCARTO := 'CLASSE_SERVIZIO NON VALORIZZATO';
          INSERT INTO SCARTI_ATM_SISTINA
          VALUES SCARTI(K);
        ELSIF SCARTI(K).VELOCITA_ACS_UTENTE_FINALE IS NULL THEN
          SCARTI(K).CAUS_SCARTO := 'VELOCITA_ACS_UTENTE_FINALE NON VALORIZZATO';
          INSERT INTO SCARTI_ATM_SISTINA
          VALUES SCARTI(K);
      --RU_1322
         ELSIF SCARTI(K).PROTOCOLLO_UTENTE_FINALE  IS NULL THEN
           SCARTI(K).CAUS_SCARTO := 'PROTOCOLLO_UTENTE_FINALE NON VALORIZZATO';
           INSERT INTO SCARTI_ATM_SISTINA
           VALUES SCARTI(K);
         ELSIF SCARTI(K).AREA_DI_RACCOLTA  IS NULL THEN
           SCARTI(K).CAUS_SCARTO := 'AREA_DI_RACCOLTA NON VALORIZZATO';
           INSERT INTO SCARTI_ATM_SISTINA
           VALUES SCARTI(K);
        /* SM_10778
          ELSIF SCARTI(K).VPI_OLO  IS NULL THEN
           SCARTI(K).CAUS_SCARTO := 'VPI_OLO NON VALORIZZATO';
           INSERT INTO SCARTI_ATM_SISTINA
           VALUES SCARTI(K);*/
         ELSIF SCARTI(K).BANDA_OLO  IS NULL THEN
           SCARTI(K).CAUS_SCARTO := 'BANDA_OLO NON VALORIZZATO';
           INSERT INTO SCARTI_ATM_SISTINA
           VALUES SCARTI(K);
         ELSIF SCARTI(K).DESC_ID_XDSL  IS NULL THEN
           SCARTI(K).CAUS_SCARTO := 'DESC_ID_XDSL NON VALORIZZATO';
           INSERT INTO SCARTI_ATM_SISTINA
           VALUES SCARTI(K);
         ELSIF SCARTI(K).AREA_DI_RACCOLTA_KDC  IS NULL THEN
           SCARTI(K).CAUS_SCARTO := 'AREA_DI_RACCOLTA_KDC NON VALORIZZATO';
           INSERT INTO SCARTI_ATM_SISTINA
           VALUES SCARTI(K);

        END IF;
      END LOOP PROCESS_LOOP;
      COMMIT;

    END LOOP MAIN_LOOP;

    CLOSE cRECORDS;
  EXCEPTION
    WHEN OTHERS THEN
      IF cRECORDS%ISOPEN THEN
        CLOSE cRECORDS;
      END IF;
      RAISE_APPLICATION_ERROR(-20999, DBMS_UTILITY.FORMAT_ERROR_BACKTRACE);
  END FILL_SCARTI_ATM_SISTINA_OLD;

  -- CS_856
  PROCEDURE FILL_SCARTI_ATM_SISTINA(inIDFILE     IN NUMBER,
                  ESTRAI       IN VARCHAR2,
                  DATA_DA      IN VARCHAR2,
                  DATA_A       IN VARCHAR2)
  IS
    TYPE tSCARTI IS TABLE OF SCARTI_ATM_SISTINA%ROWTYPE;

    SCARTI          tSCARTI;
    -- SQL_STATEMENT   VARCHAR2(5000);
    -- cRECORDS        SYS_REFCURSOR;
    CONSISTENZA_NOW PARAMETRI_CFGZ_NOW.VALORE_STRINGA%TYPE;
    v_CAUS_SCARTO Varchar2(2000);
    v_count     Number:=0;
  BEGIN
    LOG ('*** STARTING PROCEDURE FILL_SCARTI_ATM_SISTINA');

    SELECT VALORE_STRINGA INTO CONSISTENZA_NOW FROM PARAMETRI_CFGZ_NOW WHERE CHIAVE = 'OWNER_CONSISTENZA';

	-- Task.44881

    /* For rec_main in (SELECT /*+ LEADING(OFF) */
    /*    ASSET.CRMESTRATTORE,
          ASSET.STATOASSET,
          inIDFILE IDFILE,
          SYSTIMESTAMP DATA_ELAB,
          DETT.BDS_ID DETT_BDS_ID,
          CASE PKG_ESTRAZIONI.GET_IDUTENTE_FINALE(ASSET.BDS_ID, 'SISTINA') WHEN 'POTS' THEN LPAD(ASSET.NUMEROTELEFONICO, 12, '0') WHEN 'LineaNonFonia' THEN LPAD(ASSET.NUMEROFITTIZIO, 12, '1') WHEN 'ISDN' THEN LPAD(ASSET.NUMEROFITTIZIO, 12, '1') WHEN 'LnF' THEN LPAD(ASSET.NUMEROFITTIZIO, 12, '1') ELSE ASSET.IDRISORSA END ID_UTENTE_FINALE,
          ASSET.CODIFICAOLOAGCOM CODICE_GESTORE,
          CASE WHEN ASSET.DESPRIMOORDINE IS NOT NULL THEN PKG_ESTRAZIONI.SET_DATE(ASSET.DESPRIMOORDINE) || ' ' || PKG_ESTRAZIONI.SET_DATE(ASSET.ORA_DES, 'hh24:mi:ss') ELSE NULL END DATA_PRIMO_NOLEGGIO,
          PKG_ESTRAZIONI.SET_DATE(ASSET.DES) || ' ' || PKG_ESTRAZIONI.SET_DATE(ASSET.ORA_DES, 'hh24:mi:ss') DATE_DES,
          ASSET.BDS_ID DESC_OCS,
          CASE OFF.ID_OFFERTA WHEN 8 THEN 'BTS_FLAS' WHEN 9 THEN 'BTS_HLAS' WHEN 10 THEN 'BTS_LITE' WHEN 39 THEN 'BTS_FLSI' WHEN 40 THEN 'BTS_HLSI' ELSE NULL END DESCRIZIONE_SERVIZIO,
          --SM_10806 CASE OFF.IDTPLG_PAGAMENTO_ACCS WHEN 1 THEN 'F' ELSE 'C' END MODALITA_FATTURAZIONE,
          CASE OFF.IDTPLG_PAGAMENTO_ACCS WHEN 1 THEN 'F' WHEN 2 THEN 'C'  WHEN 3 THEN 'C' ELSE NULL END MODALITA_FATTURAZIONE,
          PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'TIPOPROFILOVC') CLASSE_SERVIZIO,
          (SELECT PCR_DOWN FROM PROFILO_VC WHERE ID_PRFL_VC = RTRIM(PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'IDPROFILOVC'), '.0') AND ROWNUM < 2) VELOCITA_ACS_UTENTE_FINALE,
          NULL CAUSALE_SCARTO,
          CASE PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'TIPOPROTOCOLLO','PROTOCOLLO') WHEN 'FR' THEN 'FR' ELSE 'ATM' END PROTOCOLLO_UTENTE_FINALE,
          PKG_ESTRAZIONI.CODE_AREA_RACC(ASSET.BDS_ID, 'COD_AREA_RACCOLTA') AREA_DI_RACCOLTA,
          NULL VPI_OLO,
          PKG_ESTRAZIONI.BANDA_UTENTE_FINALE(DETT.BDS_ID, ORD.BDS_ID, ASSET.BDS_ID, OFF.ID_OFFERTA, 'BandaOLO') BANDA_OLO,
          ASSET.IDRISORSA DESC_ID_XDSL,
          PKG_ESTRAZIONI.CODE_AREA_RACC(ASSET.BDS_ID, 'COD_AREA_RACCOLTA') AREA_DI_RACCOLTA_KDC
        FROM BDS_1_CASEDATA_ASSET ASSET
          LEFT JOIN BDS_1_CASEDATA_ORDINE ORD ON ASSET.IDRICHIESTAOLO = ORD.IDRICHIESTAOLO
          LEFT JOIN BDS_1_CASEDATA_RICHIESTA RICH ON ASSET.IDRICHIESTAOLO = RICH.IDRICHIESTAOLO  --SM_2907 Inserite Outer join e modificato legame tra offerta e asset
          LEFT OUTER JOIN TRASCODFC_OFFERTA TSO ON NOME_OFFERTA_ESTERNA = ASSET.OFFERTA AND PROVENIENZA = 'BPM'
          JOIN OFFERTA OFF on TSO.ID_OFFERTA=off.id_offerta
          LEFT JOIN CONTRATTO AGREE ON AGREE.ID_CONTRATTO = ASSET.IDCONTRATTO
          JOIN BDS_1_CASEDATA_DETTAGLIOASSET DETT ON DETT.ASSET_DETTAGLIOASSET_BDSID = ASSET.BDS_ID AND DETT.NOMECOMPONENTE = 'ATMVC'
          JOIN BDS_1_CASEDATA_ATTRIBTDTTGLSST ATTR ON ATTR.DTTGLSST_TTRBTIDTTGLISST_BDSID = DETT.BDS_ID AND ATTR.NOMEATTRIBUTO = 'IDRISORSAVC'
        WHERE OFF.ID_OFFERTA = ANY (8, 9, 10, 39, 40)*/

   For rec_main in (SELECT /*+ LEADING(OFF) */
                    ASSET.CRMESTRATTORE,
                    ASSET.STATOASSET,
                    inIDFILE IDFILE,
                    SYSTIMESTAMP DATA_ELAB,
                    DETT.BDS_ID DETT_BDS_ID,
                    ASSET.CODIFICAOLOAGCOM CODICE_GESTORE,
                    ASSET.BDS_ID DESC_OCS,
                    NULL CAUSALE_SCARTO,
                    NULL VPI_OLO,
                    ASSET.IDRISORSA DESC_ID_XDSL,
                    CASE OFF.ID_OFFERTA WHEN 8 THEN 'BTS_FLAS' WHEN 9 THEN 'BTS_HLAS' WHEN 10 THEN 'BTS_LITE' WHEN 39 THEN 'BTS_FLSI' WHEN 40 THEN 'BTS_HLSI' ELSE NULL END DESCRIZIONE_SERVIZIO,
                    CASE OFF.IDTPLG_PAGAMENTO_ACCS WHEN 1 THEN 'F' WHEN 2 THEN 'C'  WHEN 3 THEN 'C' ELSE NULL END MODALITA_FATTURAZIONE,
                    PKG_ESTRAZIONI.SET_DATE(ASSET.DES) || ' ' || PKG_ESTRAZIONI.SET_DATE(ASSET.ORA_DES, 'hh24:mi:ss') DATE_DES,   --> OK
                    CASE PKG_ESTRAZIONI.GET_IDUTENTE_FINALE(ASSET.BDS_ID, 'SISTINA') WHEN 'POTS' THEN LPAD(ASSET.NUMEROTELEFONICO, 12, '0') WHEN 'LineaNonFonia' THEN LPAD(ASSET.NUMEROFITTIZIO, 12, '1') WHEN 'ISDN' THEN LPAD(ASSET.NUMEROFITTIZIO, 12, '1') WHEN 'LnF' THEN LPAD(ASSET.NUMEROFITTIZIO, 12, '1') ELSE ASSET.IDRISORSA END ID_UTENTE_FINALE,     --> OK
                    CASE WHEN ASSET.DESPRIMOORDINE IS NOT NULL THEN PKG_ESTRAZIONI.SET_DATE(ASSET.DESPRIMOORDINE) || ' ' || PKG_ESTRAZIONI.SET_DATE(ASSET.ORA_DES, 'hh24:mi:ss') ELSE NULL END DATA_PRIMO_NOLEGGIO,  --> OK
                    CASE PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'TIPOPROTOCOLLO','PROTOCOLLO') WHEN 'FR' THEN 'FR' ELSE 'ATM' END PROTOCOLLO_UTENTE_FINALE,  --> OK
                    PKG_ESTRAZIONI.CODE_AREA_RACC(ASSET.BDS_ID, 'COD_AREA_RACCOLTA') AREA_DI_RACCOLTA,      --> OK
                    PKG_ESTRAZIONI.CODE_AREA_RACC(ASSET.BDS_ID, 'COD_AREA_RACCOLTA') AREA_DI_RACCOLTA_KDC,  --> OK
                    ATTRCL.VALOREATTRIBUTO CLASSE_SERVIZIO,                     --> OK RISOLTO    ???
                  --(SELECT PCR_DOWN FROM PROFILO_VC WHERE ID_PRFL_VC = RTRIM(PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'IDPROFILOVC'), '.0')) VELOCITA_ACS_UTENTE_FINALE,
                   (SELECT prfvc.PCR_DOWN FROM PROFILO_VC  prfvc, BDS_1_CASEDATA_ATTRIBTDTTGLSST ATT
                WHERE prfvc.ID_PRFL_VC = rtrim(ATT.VALOREATTRIBUTO,'.0')
                 AND ATT.DTTGLSST_TTRBTIDTTGLISST_BDSID=DETT.BDS_ID
                 AND ATT.NOMEATTRIBUTO = 'IDPROFILOVC' and rownum < 2)  VELOCITA_ACS_UTENTE_FINALE, --Prestazionale
                 --PKG_ESTRAZIONI.BANDA_UTENTE_FINALE(DETT.BDS_ID, ORD.BDS_ID, ASSET.BDS_ID, OFF.ID_OFFERTA, 'BandaOLO') BANDA_OLO
                  PKG_ESTRAZIONI.BANDA_UTENTE_FINALE_SC(DETT.BDS_ID, ORD.BDS_ID, ASSET.BDS_ID, OFF.ID_OFFERTA, 'BandaOLO') BANDA_OLO --Prestazionale
                  FROM BDS_1_CASEDATA_ASSET ASSET
                    LEFT JOIN BDS_1_CASEDATA_ORDINE ORD ON ASSET.IDRICHIESTAOLO = ORD.IDRICHIESTAOLO
                    LEFT JOIN BDS_1_CASEDATA_RICHIESTA RICH ON ASSET.IDRICHIESTAOLO = RICH.IDRICHIESTAOLO  --SM_2907 Inserite Outer join e modificato legame tra offerta e asset
                    LEFT OUTER JOIN TRASCODFC_OFFERTA TSO ON NOME_OFFERTA_ESTERNA = ASSET.OFFERTA AND PROVENIENZA = 'BPM'
                    JOIN OFFERTA OFF on TSO.ID_OFFERTA=off.id_offerta
                    LEFT JOIN CONTRATTO AGREE ON AGREE.ID_CONTRATTO = ASSET.IDCONTRATTO
                    JOIN BDS_1_CASEDATA_DETTAGLIOASSET DETT ON DETT.ASSET_DETTAGLIOASSET_BDSID = ASSET.BDS_ID AND DETT.NOMECOMPONENTE = 'ATMVC'
                    JOIN BDS_1_CASEDATA_ATTRIBTDTTGLSST ATTR ON ATTR.DTTGLSST_TTRBTIDTTGLISST_BDSID = DETT.BDS_ID AND ATTR.NOMEATTRIBUTO = 'IDRISORSAVC'
                  -- aggiunta 1
                   LEFT JOIN BDS_1_CASEDATA_ATTRIBTDTTGLSST ATTRCL ON DETT.BDS_ID=ATTRCL.DTTGLSST_TTRBTIDTTGLISST_BDSID  AND ATTRCL.NOMEATTRIBUTO = 'TIPOPROFILOVC'
                  WHERE OFF.ID_OFFERTA = ANY (8, 9, 10, 39, 40)
                 )  -- chiusura query
    Loop
      v_CAUS_SCARTO:=null;
      IF Not (NVL(CONSISTENZA_NOW,'Y') <> 'N' or
          (CONSISTENZA_NOW = 'N' AND (rec_main.CRMESTRATTORE = 'NOW' OR rec_main.STATOASSET = 'INLAVORAZIONE'))
          )
      THEN
        CONTINUE;
      END IF;

      IF rec_main.ID_UTENTE_FINALE IS NULL THEN
        v_CAUS_SCARTO := 'ID_UTENTE_FINALE NON VALORIZZATO';
      ELSIF rec_main.CODICE_GESTORE IS NULL THEN
        v_CAUS_SCARTO := 'CODICE_GESTORE NON VALORIZZATO';
      ELSIF rec_main.DATA_PRIMO_NOLEGGIO IS NULL THEN
        v_CAUS_SCARTO := 'DATA_PRIMO_NOLEGGIO NON VALORIZZATO';
      ELSIF rec_main.DATE_DES IS NULL THEN
        v_CAUS_SCARTO := 'DATE_DES NON VALORIZZATO';
      ELSIF rec_main.DESC_OCS IS NULL THEN
        v_CAUS_SCARTO := 'DESC_OCS NON VALORIZZATO';
      ELSIF rec_main.DESCRIZIONE_SERVIZIO IS NULL THEN
        v_CAUS_SCARTO := 'DESCRIZIONE_SERVIZIO NON VALORIZZATO';
      ELSIF rec_main.MODALITA_FATTURAZIONE IS NULL THEN
        v_CAUS_SCARTO := 'MODALITA_FATTURAZIONE NON VALORIZZATO';
      ELSIF rec_main.CLASSE_SERVIZIO IS NULL THEN
        v_CAUS_SCARTO := 'CLASSE_SERVIZIO NON VALORIZZATO';
      ELSIF rec_main.VELOCITA_ACS_UTENTE_FINALE IS NULL THEN
        v_CAUS_SCARTO := 'VELOCITA_ACS_UTENTE_FINALE NON VALORIZZATO';
      ELSIF rec_main.PROTOCOLLO_UTENTE_FINALE  IS NULL THEN
        v_CAUS_SCARTO := 'PROTOCOLLO_UTENTE_FINALE NON VALORIZZATO';
      ELSIF rec_main.AREA_DI_RACCOLTA  IS NULL THEN
        v_CAUS_SCARTO := 'AREA_DI_RACCOLTA NON VALORIZZATO';
      ELSIF rec_main.BANDA_OLO  IS NULL THEN
        v_CAUS_SCARTO := 'BANDA_OLO NON VALORIZZATO';
      ELSIF rec_main.DESC_ID_XDSL  IS NULL THEN
        v_CAUS_SCARTO := 'DESC_ID_XDSL NON VALORIZZATO';
      ELSIF rec_main.AREA_DI_RACCOLTA_KDC  IS NULL THEN
        V_CAUS_SCARTO := 'AREA_DI_RACCOLTA_KDC NON VALORIZZATO';
      END IF;

      If V_CAUS_SCARTO is not null Then
        Insert into APPUSER.SCARTI_ATM_SISTINA (
          IDFILE,DATA_ELAB ,DETT_BDSID,ID_UTENTE_FINALE,CODICE_GESTORE
          ,DATA_PRIMO_NOLEGGIO,DATE_DES,DESC_OCS,DESCRIZIONE_SERVIZIO,MODALITA_FATTURAZIONE
          ,CLASSE_SERVIZIO,VELOCITA_ACS_UTENTE_FINALE,CAUS_SCARTO)
        Values  (
            rec_main.IDFILE, rec_main.DATA_ELAB, rec_main.DETT_BDS_ID, rec_main.ID_UTENTE_FINALE, rec_main.CODICE_GESTORE
            ,rec_main.DATA_PRIMO_NOLEGGIO,rec_main.DATE_DES,rec_main.DESC_OCS,rec_main.DESCRIZIONE_SERVIZIO,rec_main.MODALITA_FATTURAZIONE
            ,rec_main.CLASSE_SERVIZIO,rec_main.VELOCITA_ACS_UTENTE_FINALE,v_CAUS_SCARTO
          );

          v_count:=v_count+1;
        -- if mod(v_count,10000)=0 Then -- Task.44881
		if mod(v_count,500)=0 Then -- Task.44881
          COMMIT;
                LOG ('commit');
        End If;
      End If;
    End Loop;

    COMMIT;
    LOG ('*** END PROCEDURE FILL_SCARTI_ATM_SISTINA('||to_char(v_count)||')');
  EXCEPTION
    WHEN OTHERS THEN
      LOG ('FILL_SCARTI_ATM_SISTINA::'||sqlerrm);
      RAISE_APPLICATION_ERROR(-20999, DBMS_UTILITY.FORMAT_ERROR_BACKTRACE);
  END FILL_SCARTI_ATM_SISTINA;


  PROCEDURE ESTRAI_SISTINA_GIORNALIERO (ID_FILE          IN NUMBER,
                                        DATA_ESTRAZIONE  IN VARCHAR2)
  IS
    DATA_INPUT VARCHAR2(50);
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_SISTINA_GIORNALIERO **');

    PKG_ESTRAZIONI_SISTINA.ESTRAI_GIORNALIERO(ID_FILE, DATA_ESTRAZIONE);
    /*
    IF DATA_ESTRAZIONE IS NULL THEN
      DATA_INPUT := TO_CHAR(SYSDATE - INTERVAL '1' DAY, kDATEFORMAT);
    ELSE
      DATA_INPUT := DATA_ESTRAZIONE;
    END IF;

    FILL_SCARTI_ATM_SISTINA(ID_FILE,
                            ESTRAI_SISTINA_G,
                            NULL,
                            DATA_INPUT);

    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_SISTINA_G,
                          FILE_NAME_SISTINA_G || '_' || TODAY('YYYYMMDD') || FILE_EXT,
                          SERVICE_SISTINA,
                          NULL,
                          DATA_INPUT,
                          NULL);
    */
    INFO('** FINISHED PROCEDURE ESTRAI_SISTINA_GIORNALIERO **');
  END ESTRAI_SISTINA_GIORNALIERO;

  PROCEDURE ESTRAI_SISTINA_MENSILE (ID_FILE      IN NUMBER,
                                    DATA_INIZIO  IN VARCHAR2,
                                    DATA_FINE    IN VARCHAR2)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_SISTINA_MENSILE **');
    FILL_SCARTI_ATM_SISTINA(ID_FILE,
                            ESTRAI_SISTINA_M,
                            DATA_INIZIO,
                            DATA_FINE);

    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_SISTINA_M,
                          FILE_NAME_SISTINA_M || '_' || TODAY('YYYYMMDD') || FILE_EXT,
                          SERVICE_SISTINA,
                          DATA_INIZIO,
                          DATA_FINE,
                          NULL);
    INFO('** FINISHED PROCEDURE ESTRAI_SISTINA_MENSILE **');
  END ESTRAI_SISTINA_MENSILE;

  PROCEDURE ESTRAI_ULISSE_F1(ID_FILE      IN NUMBER)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_ULISSE_F1 **');
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_F1_TD,
                          FILE_NAME_F1_TD_INNOV || '_' || TODAY('DD_MM_YY') || FILE_EXT_TD,
                          ULISSE_TD_F1,
                          NULL,
                          NULL,
                          NULL);
    INFO('** FINISHED PROCEDURE ESTRAI_ULISSE_F1 **');
  END ESTRAI_ULISSE_F1;

  PROCEDURE ESTRAI_REGIA0_GIACENZE(ID_FILE      IN NUMBER)
  IS
    AMBITO tAMBITO;
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_REGIA0_GIACENZE **');

    AMBITO := tAMBITO(FAMIGLIA_REGOLATORIO);

    ESTRAI_GENERIC_ORDINI(ID_FILE,
                          AMBITO,
                          REGIA0_GIACENZE,
                          FILE_NAME_REGIA0_GIAC || '_' || TODAY('YYYYMMDD') || FILE_EXT,
                          gRUNQUERY);
    INFO('** FINISHED PROCEDURE ESTRAI_REGIA0_GIACENZE **');
  END ESTRAI_REGIA0_GIACENZE;

  PROCEDURE ESTRAI_REGIA0_KO_GIORNALIERO(ID_FILE      IN NUMBER)
  IS
    AMBITO tAMBITO;
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_REGIA0_GIORNALIERO **');

    AMBITO := tAMBITO(FAMIGLIA_REGOLATORIO, FAMIGLIA_NGA, FAMIGLIA_VULA, FAMIGLIA_BITSTREAM);

    ESTRAI_GENERIC_ORDINI(ID_FILE,
                          AMBITO,
                          REGIA0_KO,
                          FILE_NAME_REGIA0_KO_G || '_' || TODAY('YYYYMMDD') || FILE_EXT,
                          gRUNQUERY,
                          SEPARATOR => CSV_SEPARATOR);
    INFO('** FINISHED PROCEDURE ESTRAI_REGIA0_GIORNALIERO **');
  END ESTRAI_REGIA0_KO_GIORNALIERO;

  PROCEDURE ESTRAI_REGIA0_KO_FULL(ID_FILE      IN NUMBER,
                                  DATA_INIZIO  IN VARCHAR2,
                                  DATA_FINE    IN VARCHAR2)
  IS
    AMBITO tAMBITO;
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_REGIA0_KO_FULL **');

    AMBITO := tAMBITO(FAMIGLIA_REGOLATORIO, FAMIGLIA_NGA, FAMIGLIA_VULA, FAMIGLIA_BITSTREAM);

    ESTRAI_GENERIC_ORDINI(ID_FILE,
                          AMBITO,
                          REGIA0_KO,
                          FILE_NAME_REGIA0_KO_F || '_' || FORMAT_DATE(DATA_INIZIO,'YYYYMMDD') || '_' || FORMAT_DATE(DATA_FINE,'YYYYMMDD') || FILE_EXT,
                          gRUNQUERY,
                          DATA_INIZIO,
                          DATA_FINE,
                          SEPARATOR => CSV_SEPARATOR);
    INFO('** FINISHED PROCEDURE ESTRAI_REGIA0_KO_FULL **');
  END ESTRAI_REGIA0_KO_FULL;

-- SM_6019 (E) -- Unificati i quattro flussi di estrazione consistenze nel nuovo ID 258
  PROCEDURE ESTRAI_OPERA_CONSISTENZE (ID_FILE          IN NUMBER,
                                      ID_AGGIUNTIVO    IN NUMBER)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_OPERA_CONSISTENZE **');
    ESTRAI_GENERIC_OPERA(ID_FILE,
                         ID_AGGIUNTIVO,
                         --AMBITO,
                         OPERA_CONSISTENZE,
                         gRUNQUERY,
                         'OPERA_CONSISTENZE (NO FILE)');
    INFO('** FINISHED PROCEDURE ESTRAI_OPERA_CONSISTENZE **');
  END ESTRAI_OPERA_CONSISTENZE;



-- ANDREA GARAVINI
 -- 18/08/2016
 -- LOTTO4

  PROCEDURE ESTRAI_UTENTI_INATTIVI (ID_FILE         IN NUMBER,
                                   GIORNI_INATT_IT IN VARCHAR2)
  IS

   FROM_CLAUSE     VARCHAR2(5000);
    WHERE_CLAUSE    VARCHAR2(2000);
    SQL_STATEMENT   VARCHAR2(10000);
    FILE_NAME_UT_INATT VARCHAR2(100); --RU_1037
  BEGIN

    FILE_NAME_UT_INATT:=FILE_NAME_UT_INATT_TMP || '_' || TODAY('YYYYMMDDHH24MISS') || FILE_EXT; --RU_1037


    LOG('   SPOOL UTENTI_INATTIVI FOR FILE ' || FILE_NAME_UT_INATT);

    IF NOT CAN_START(ID_FILE, FILE_NAME_UT_INATT) THEN
      LOG ('   EXITING BECAUSE OF CAN_START RETURNING FALSE: CHECK TABLE STATO_ESTRAZIONI.');
      RETURN;
    END IF;


    /*commentato per CS_576
     FROM_CLAUSE := CHR(10) || ' FROM UTENTE JOIN PORTAFOGLIO_CLIENTE ON UTENTE.USERID = PORTAFOGLIO_CLIENTE.USERID' || CHR(10);
    */

    --CS_576
    --RU_1037 add AND TU.IDTPLG_UTENTE = 2
    --Eliminata union con TU.IDTPLG_UTENTE = 2
    FROM_CLAUSE := CHR(10) || q'x FROM ( SELECT  UTENTE.USER_ALIAS
               , UTENTE.NOME
               , UTENTE.COGNOME
               , utente.cod_profilo
               , MAX ( UTENTE.TIMSTP_ULTIMO_ACCS ) AS MAX_ACCESSO
            FROM UTENTE
                 INNER JOIN TIPOLG_UTENTE TU            ON TU.IDTPLG_UTENTE = UTENTE.IDTPLG_UTENTE
                 LEFT OUTER JOIN PORTAFOGLIO_CLIENTE PO ON UTENTE.USERID    = PO.USERID
           WHERE NVL ( PO.CODFC_OLO_AGCOM, '$????#' ) NOT IN ( 'OLO','OLS','TLC' )
             AND TU.IDTPLG_UTENTE <> 2
             AND TU.FLAG_TRACC_152                      = 'Y'
             AND UTENTE.FLAG_DISABL                    <> '1'
             and UTENTE.DATAFI_VALID                    > sysdate
        GROUP BY UTENTE.USER_ALIAS
               , UTENTE.NOME
               , UTENTE.COGNOME
               , utente.cod_profilo)x' || CHR(10);
    /*commentato per CS_576
    WHERE_CLAUSE := ' WHERE TRUNC(UTENTE.TIMSTP_ULTIMO_ACCS) < TRUNC(SYSDATE-' || GIORNI_INATT ||')';
    */
    --CS_576
    WHERE_CLAUSE := ' WHERE MAX_ACCESSO <= TRUNC ( TRUNC ( SYSDATE ) - ' || GIORNI_INATT_IT ||')';


    SQL_STATEMENT := BUILD_SQL_STATEMENT(FILE_COLUMNS(UTENTI_INATTIVI), FROM_CLAUSE, WHERE_CLAUSE, FILE_NAME_UT_INATT, CSV_SEPARATOR); --RU_1087

    LOG('   BUILT STATEMENT: ' || CHR(10) || SQL_STATEMENT);

    IF WRITE_ON_TABLE THEN
            FETCH_AND_COMMIT(SQL_STATEMENT, ID_FILE, FILE_NAME_UT_INATT, UTENTI_INATTIVI, CSV_SEPARATOR);--RU_1087
    ELSE
        FETCH_AND_WRITE(SQL_STATEMENT, FILE_NAME_UT_INATT);
    END IF;

      UPDATE_STATUS(ID_FILE, FLAG_OK);

    LOG ('   FINISHED UTENTI_INATTIVI DATA SPOOL');
  EXCEPTION
    WHEN OTHERS THEN
    INFO('** FATAL ERROR: ' || SQLCODE || ' - ' || SQLERRM || ' **');
    UPDATE_STATUS(ID_FILE, FLAG_KO, SUBSTR(SQLCODE || SQLERRM, 1, 2000));

  END ESTRAI_UTENTI_INATTIVI;

  PROCEDURE ESTRAI_ORDINI_ECCESSIVI (ID_FILE       IN NUMBER,
                                   DATA_ORD        IN VARCHAR2,
                                   SOGLIA          IN VARCHAR2)
  IS
    --FROM_CLAUSE     VARCHAR2(5000);
    --WHERE_CLAUSE    VARCHAR2(2000);
    SQL_STATEMENT   VARCHAR2(10000);
  BEGIN

--    FILE_NAME_ORD_ECC := FILE_NAME_ORD_ECC || '_' || TODAY || FILE_EXT;

    LOG('   SPOOL ORDINI_ECCESSIVI FOR FILE ' || FILE_NAME_ORD_ECC);

    IF NOT CAN_START(ID_FILE, FILE_NAME_ORD_ECC) THEN
      LOG ('   EXITING BECAUSE FROM  OF CAN_START RETURNING FALSE: CHECK TABLE STATO_ESTRAZIONI.');
      RETURN;
    END IF;

    SQL_STATEMENT := 'SELECT ORD.CODIFICAOLOAGCOM ||' || '''|''' || '|| ORD.OPERATORE ||' || '''|''' || '|| COUNT(BDS_ID) N_ORD FROM BDS_1_CASEDATA_ORDINE ORD WHERE TRUNC(ORD.CREATED) = ' || GET_DATE(DATA_ORD) || ' AND ORD.OPERATORE <> ''' || UT_AUTOM || ''' GROUP BY ORD.CODIFICAOLOAGCOM, ORD.OPERATORE HAVING COUNT(BDS_ID) > ' || SOGLIA;

    LOG('   BUILT STATEMENT: ' || CHR(10) || SQL_STATEMENT);

    IF WRITE_ON_TABLE THEN
      FETCH_AND_COMMIT(SQL_STATEMENT, ID_FILE, FILE_NAME_ORD_ECC, ORDINI_ECCESSIVI, PIPE_SEPARATOR);
    ELSE
      FETCH_AND_WRITE(SQL_STATEMENT, FILE_NAME_ORD_ECC);
    END IF;

      UPDATE_STATUS(ID_FILE, FLAG_OK);

    LOG ('   FINISHED ORDINI_ECCESSIVI DATA SPOOL');
  EXCEPTION
    WHEN OTHERS THEN
    INFO('** FATAL ERROR: ' || SQLCODE || ' - ' || SQLERRM || ' **');
    UPDATE_STATUS(ID_FILE, FLAG_KO, SUBSTR(SQLCODE || SQLERRM, 1, 2000));


  END ESTRAI_ORDINI_ECCESSIVI;

  PROCEDURE ESTRAI_ACCESSI_GUI (ID_FILE         IN NUMBER,
                                PROFONDITA      IN VARCHAR2,
                                NOME_SIS        IN VARCHAR2)
  IS
    -- FROM_CLAUSE     VARCHAR2(5000);
    -- WHERE_CLAUSE    VARCHAR2(2000);
    TESTATA          VARCHAR2(10000);
    SQL_STATEMENT    VARCHAR2(10000);

    CAMPO1               VARCHAR2(100) DEFAULT 'User ID / Matricola';
    CAMPO2               VARCHAR2(100) DEFAULT 'Nome Utente';
    CAMPO3               VARCHAR2(100) DEFAULT 'Cognome Utente';
    CAMPO4               VARCHAR2(100) DEFAULT 'Funzione di appartenenza/Azienda di Appartenenza (utente esterno) e Funzione TI di riferimento';
    CAMPO5               VARCHAR2(100) DEFAULT 'Profilo di Abilitazione';
    CAMPO6               VARCHAR2(100) DEFAULT 'Data e Ora Inizio Accesso (GG/MM/AAAA HH24:MM:SS)';
    CAMPO7               VARCHAR2(100) DEFAULT 'Data e Ora Fine Accesso (GG/MM/AAAA HH24:MM:SS)';

    FORMATO_TIME_OUT     VARCHAR2(100) DEFAULT 'DD/MM/YYYY HH24:MI:SS';
    FORMATO_TIME_TST     VARCHAR2(100) DEFAULT 'DD/MM/YYYY';

  BEGIN

--     FILE_NAME_ACCESSI_GUI := FILE_NAME_ACCESSI_GUI || '_' || TODAY || FILE_EXT;

     LOG('   SPOOL ACCESSI_GUI FOR FILE ' || FILE_NAME_ACCESSI_GUI);

    IF NOT CAN_START(ID_FILE, FILE_NAME_ACCESSI_GUI) THEN
      LOG ('   EXITING BECAUSE OF CAN_START RETURNING FALSE: CHECK TABLE STATO_ESTRAZIONI.');
      RETURN;
    END IF;

    TESTATA := 'SELECT CAMPO FROM ' || CHR(10);

    TESTATA := TESTATA || '(SELECT 1 NCOL, ' || '''SISTEMA:' || NOME_SIS || ''' CAMPO FROM DUAL ' || CHR(10);
      TESTATA := TESTATA || 'UNION SELECT 2, ' || '''Data generazione:' || ''' || TO_CHAR(SYSDATE,''' || FORMATO_TIME_TST || ''') FROM DUAL ' || CHR(10);
    TESTATA := TESTATA || 'UNION SELECT 3, ' || ''' ''' || ' FROM DUAL' || CHR(10);
    TESTATA := TESTATA || 'UNION SELECT 4, ''' || CAMPO1 || ',' || CAMPO2 || ',' || CAMPO3 || ',' || CAMPO4 || ',' || CAMPO5 || ',' || CAMPO6 || ',' || CAMPO7 || ''' FROM DUAL ' || CHR(10);

    SQL_STATEMENT := 'SELECT 5, ALIAS_USR ||' || ''',''' || '||NOME ||' || ''',''' || '|| COGNOME ||' || ''',''' || '|| FUNZIONE ||' || ''',''' || '|| PROFILO ||' || ''',''' || '|| LOGIN ||' || ''',''' || '|| LOGOUT' || CHR(10);
  --SQL_STATEMENT := SQL_STATEMENT || 'FROM (SELECT TRACC.FUNZIONE_AZIENDALE, TRACC.USERID AS UT_IN, TRACC.SESSION_ID AS SS_IN, TRACC.TIMSTP_INSMTO AS TIME_IN, TRACC.DESCR_PROFILO FROM TRACC_ATTIVITA_UTENTE TRACC WHERE TRACC.TIPO_OPERAZIONE =''' || OP_LOGIN || ''' AND TRUNC(TRACC.TIMSTP_INSMTO) >= TRUNC(SYSDATE-'|| PROFONDITA ||') AND TRACC.USERID NOT LIKE ''' || PRFX_M2M || ''' ORDER BY TRACC.TIMSTP_INSMTO) TRACC_IN' || CHR(10);
    SQL_STATEMENT := SQL_STATEMENT || 'FROM (SELECT DISTINCT
                             UTENTE.USER_ALIAS ALIAS_USR
                           , UTENTE.NOME NOME
                           , UTENTE.COGNOME COGNOME
                           , NVL(LOGIN.FUNZIONE_AZIENDALE, UTENTE.FUNZIONE_AZIENDALE) FUNZIONE
                           , LOGIN.DESCR_PROFILO PROFILO
                           , TO_CHAR(LOGIN.TIMSTP_INSMTO,'''|| FORMATO_TIME_OUT ||''') LOGIN'||'
                           , TO_CHAR(LOGOUT.TIMSTP_INSMTO,'''|| FORMATO_TIME_OUT ||''') LOGOUT'||'
                           FROM UTENTE
            INNER JOIN TIPOLG_UTENTE tu
                   ON tu.IDTPLG_UTENTE     = UTENTE.IDTPLG_UTENTE
                 INNER JOIN TRACC_ATTIVITA_UTENTE LOGIN
                   ON LOGIN.USERID         = UTENTE.USERID
                 LEFT OUTER JOIN PORTAFOGLIO_CLIENTE po
                   ON UTENTE.USERID        = po.USERID
                 LEFT OUTER JOIN TRACC_ATTIVITA_UTENTE LOGOUT
                   ON LOGOUT.USERID        = UTENTE.USERID
                  AND LOGOUT.USERID        = LOGIN.USERID
                  and LOGIN.SESSION_ID     = LOGOUT.SESSION_ID
                  and logout.TIPO_OPERAZIONE='||'''LOGOUT''' ||'
                   WHERE LOGIN.TIPO_OPERAZIONE ='||'''LOGIN'''||'
                    AND TRUNC(LOGIN.TIMSTP_INSMTO) >= TRUNC(SYSDATE-'|| PROFONDITA ||')'||'
                   AND NVL ( po.CODFC_OLO_AGCOM,'||'''$????#'''||')'||'
                     not in('||'''OLO'''||','||'''OLS'''||','||'''TLC'''||' )'||'
                    AND ( ( tu.FLAG_TRACC_152 ='||'''Y'''||') OR (UTENTE.COD_PROFILO LIKE '||'''%OLO%'''||'
                                                                     AND UTENTE.MATRICOLA IS NOT NULL))'||'
                     AND LOGIN.APPLICAZIONE_CLIENT NOT IN ('||'''WORKSPACE'''||','||'''OPENSPACE'''||')'||'
          ORDER BY 3, 2, 1, 6)'|| CHR(10);

    SQL_STATEMENT := TESTATA || CHR(10) || 'UNION' || CHR(10) || SQL_STATEMENT || ')';

    LOG('   BUILT STATEMENT: ' || CHR(10) || SQL_STATEMENT);

    IF WRITE_ON_TABLE THEN
      FETCH_AND_COMMIT(SQL_STATEMENT, ID_FILE, FILE_NAME_ACCESSI_GUI, 'ACCESSI_GUI', PIPE_SEPARATOR);
    ELSE
      FETCH_AND_WRITE(SQL_STATEMENT, FILE_NAME_ACCESSI_GUI);
    END IF;

      UPDATE_STATUS(ID_FILE, FLAG_OK);

    LOG ('   FINISHED ACCESSI_GUI DATA SPOOL');
  EXCEPTION
    WHEN OTHERS THEN
    INFO('** FATAL ERROR: ' || SQLCODE || ' - ' || SQLERRM || ' **');
    UPDATE_STATUS(ID_FILE, FLAG_KO, SUBSTR(SQLCODE || SQLERRM, 1, 2000));
  END ESTRAI_ACCESSI_GUI;

--/ ANDREA GARAVINI

-- ANDREA GARAVINI
 -- 30/08/2016
 -- LOTTO4

  PROCEDURE ESTRAI_ORDINI_ESPLETATI (DATA_INPUT IN VARCHAR2)
  IS

    TYPE T_SPOOL_ROWS IS TABLE OF tROW;
    ELENCO_OLO T_SPOOL_ROWS;
    ELENCO_ORD T_SPOOL_ROWS;

    RESULTSETOLO SYS_REFCURSOR;
    RESULTSETORD SYS_REFCURSOR;

    SELEZ_OLO          VARCHAR2(10000);
    SELEZ_ORD_X_ESTR   VARCHAR2(10000);
    SELEZ_ORD_X_DIFF   VARCHAR2(10000);
    SELEZ_ORD          VARCHAR2(10000);
    SELEZ_ORD_X_ESTR_I VARCHAR2(10000);
    SELEZ_ORD_X_DIFF_I VARCHAR2(10000);

    ID_FILE_NAME_ORD_ESPL           NUMBER;
    FULL_FILE_NAME_ORD_ESPL         VARCHAR2(1000);
    ID_ESEC_PROCSO_FILE_ORD_ESPL    NUMBER;

    DATA_ESTRAZIONE                 TIMESTAMP DEFAULT SYSTIMESTAMP;
  BEGIN

    IF DATA_INPUT IS NOT NULL THEN
      DATA_ESTRAZIONE :=  TO_TIMESTAMP(DATA_INPUT, kDATEFORMAT);
    END IF;


-- Si definiscono le query di estrazione per gli OLO e per gli ORDINI.

-- Gli OLO vengono selezionati sulla base delle condizioni:
-- 1 --> Ordini espletati il giorno prima
-- 2 --> OLO registrati per il monitoraggio

LOG('1 START: SELEZ_OLO');  -- ru 245 cristiano conte

    SELEZ_OLO := 'select diff_agcom.CODFC_OLO_AGCOM' || CHR(10);
    SELEZ_OLO := SELEZ_OLO || 'from DIFFIDA_AGCOM_CFGZ_OLO diff_agcom' || CHR(10);
    SELEZ_OLO := SELEZ_OLO || 'where' || CHR(10);
    SELEZ_OLO := SELEZ_OLO || 'diff_agcom.FLAG_MONITORAGGIO = ' || '''Y''' || 'and (diff_agcom.DATAFI_ABLTZ is null OR trunc(diff_agcom.DATAFI_ABLTZ) > trunc(SYSDATE))';

-- Gli ORDINI vengono selezionati sulla base delle condizioni:
--:1 --> Per ogni OLO vengono ricercati gli ORDINI aggiornati il giorno precedente
-- 2 --> Che si trovino in uno degli stati definiti

LOG('2 START: SELEZ_ORD_X_ESTR');

    -- Select di estrazione dei campi necessari per l inserimento degli ordini nella tabella ESTRAZIONI
    SELEZ_ORD_X_ESTR := 'select rich.CODICEORDINEOLO ||' || '''|''' || '|| rich.CODIFICAOLOAGCOM ||' || '''|''' || '|| rich.CODICEORDINETI ||' || '''|''' || '|| notif.COD_TIPOLG_NOTF ||' || '''|''' || '|| PKG_ESTRAZIONI.MAPP_STATO_RICH(rich.STRUTTURARICHIESTA, rich.STATORICHIESTANOW, notif.COD_TIPOLG_NOTF) ||' || '''|''' || '|| PKG_ESTRAZIONI.MAPP_NOME_FILE(fileproc.NOME_FILE, notif.IDTPLG_STNTF_FILE_ORARIO) ||' || '''|''' || CHR(10);

LOG('3 START: SELEZ_ORD_X_DIFF');

    -- Select di estrazione del campo necessario per il successivo recupero delle informazioni da inserire nella tabella DIFD_AGC_NTFORD_ESPL
    SELEZ_ORD_X_DIFF := 'SELECT rich.IDRICHIESTAOLO' || CHR(10);

    -- Stringa di selezione degli ordini (comune per  entrambe le estrazioni  -- RU 245 Cristiano Conte
    SELEZ_ORD := 'from BDS_1_CASEDATA_RICHIESTA rich' || CHR(10);
    SELEZ_ORD := SELEZ_ORD || 'LEFT OUTER join BDS_1_CASEDATA_ORDINE ord_now on ORD_NOW.IDRICHIESTAOLO = rich.IDRICHIESTAOLO' || CHR(10);
    SELEZ_ORD := SELEZ_ORD || 'join RICH_ORDN_COMUNIC_NOTF notif on rich.IDRICHIESTAOLO = notif.ID_RICH_OLO' || CHR(10);
    SELEZ_ORD := SELEZ_ORD || 'join FILE_NOTF_STANDARD notfst on notif.ID_NOTF = notfst.ID_NOTF' || CHR(10);
    SELEZ_ORD := SELEZ_ORD || 'join FILE_PROCSTO fileproc on notfst.ID_FILE_PROCSTO_OUTPUT = fileproc.ID_FILE' || CHR(10);
    SELEZ_ORD := SELEZ_ORD || 'where PKG_ESTRAZIONI.MAPP_STATO_RICH(rich.STRUTTURARICHIESTA, rich.STATORICHIESTANOW, notif.COD_TIPOLG_NOTF) is not NULL' || CHR(10);
    SELEZ_ORD := SELEZ_ORD || 'and notif.ORIGINE_NOTF <> ''' || OR_NOTIF_NOGUI || '''' || CHR(10);
    SELEZ_ORD := SELEZ_ORD || 'and fileproc.ID_INTRFC in (61, 64, 69, 177)' || CHR(10);  -- AGGIUNTA INTRFC PER SERVIZIO NP - CRISTIANO
    SELEZ_ORD := SELEZ_ORD || q'xand TRUNC(rich.LASTUPDATE) = TO_DATE('$DATA_ESTRAZIONE', 'YYYY-MM-DD') - INTERVAL '1' DAYx' || CHR(10);


    SELEZ_ORD := REPLACE (SELEZ_ORD, '$DATA_ESTRAZIONE', TO_CHAR(DATA_ESTRAZIONE, kDATEFORMAT));

-- Nota: lo stesso elenco di ID_INTRFC ? riportato nella INSERT successiva
--    SELEZ_ORD := SELEZ_ORD || 'and fileproc.NOME_FILE like ''' || '%' || INFX_RG || '%''' || CHR(10);

LOG('4 START: SELEZ_ORD');

    -- Costruzione della query completa di estrazione dei campi necessari per l inserimento degli ordini nella tabella ESTRAZIONI
    SELEZ_ORD_X_ESTR := SELEZ_ORD_X_ESTR || SELEZ_ORD;

    -- Costruzione della query completa di estrazione del campo necessario per il successivo recupero delle informazioni da inserire nella tabella DIFD_AGC_NTFORD_ESPL
    SELEZ_ORD_X_DIFF := SELEZ_ORD_X_DIFF || SELEZ_ORD;

LOG('SELEZ_ORD_X_ESTR: ' || CHR(10) || SELEZ_ORD_X_ESTR);

-- Il risultato della prima selezione viene inserito in un array contenente i codici degli OLO per cui generare i file di output

    OPEN RESULTSETOLO FOR SELEZ_OLO;

    LOOP

        FETCH RESULTSETOLO BULK COLLECT INTO ELENCO_OLO LIMIT LINES_BLOCK;

        IF ELENCO_OLO.COUNT = 0
        THEN
            LOG('NON SONO PRESENTI OLO RISPONDENTI AI CRITERI DI ESTRAZIONE');
        ELSE
            FOR I IN 1..ELENCO_OLO.COUNT LOOP

                BEGIN

            -- Per ogni OLO individuato

                    LOG('ELENCO_OLO(I): ' || ELENCO_OLO(I));

            -- Calcolo un ID_FILE univoco
                    ID_FILE_NAME_ORD_ESPL := S_FILE_PROCSTO.NEXTVAL;

            -- Costruisco dinamicamente il nome del file con la data ed il codice OLO
                    FULL_FILE_NAME_ORD_ESPL := FILE_NAME_ORD_ESPL || TO_CHAR(DATA_ESTRAZIONE,'DDMMYYYY') || '_' || ELENCO_OLO(I) || '_NOW' || FILE_EXT;

            -- Completo la query di estrazione degli ordini per ESTRAZIONI con la condizione di appartenenza all OLO in elaborazione
                    SELEZ_ORD_X_ESTR_I := SELEZ_ORD_X_ESTR || 'and rich.CODIFICAOLOAGCOM = ''' || ELENCO_OLO(I) || '''';

                    LOG('   SELEZ_ORD_X_ESTR_I: ' || CHR(10) || SELEZ_ORD_X_ESTR_I);

                    IF NOT CAN_START(ID_FILE_NAME_ORD_ESPL, FULL_FILE_NAME_ORD_ESPL) THEN
                      LOG ('   EXITING BECAUSE OF CAN_START RETURNING FALSE: CHECK TABLE STATO_ESTRAZIONI.');
                      RETURN;
                    END IF;

                    IF WRITE_ON_TABLE THEN
                      FETCH_AND_COMMIT(SELEZ_ORD_X_ESTR_I, ID_FILE_NAME_ORD_ESPL, FULL_FILE_NAME_ORD_ESPL, ORD_ESPL, PIPE_SEPARATOR);
                    ELSE
                      FETCH_AND_WRITE(SELEZ_ORD_X_ESTR_I, FULL_FILE_NAME_ORD_ESPL);
                    END IF;

                    UPDATE_STATUS(ID_FILE_NAME_ORD_ESPL, FLAG_OK);

                    UPDATE STATO_ESTRAZIONI
                    SET COD_OLO =  ELENCO_OLO(I)
                    WHERE ID_FILE = ID_FILE_NAME_ORD_ESPL;

            -- Per ogni file creato si inseriscono le relative righe sulle tabelle ESEC_PROCSTO_FILE eFILE_PROCSTO

                    -- Calcolo un ID_FILE univoco
                    ID_ESEC_PROCSO_FILE_ORD_ESPL := S_ESEC_PROCSO_FILE.NEXTVAL;

                    INSERT INTO ESEC_PROCSO_FILE (COD_PROCSO_FILE,
                                                  ID_ESEC_PROCSO_FILE,
                                                  ID_PROCSO_FILE,
                                                  STATO_ESEC,
                                                  TMSP_FINE_ELAB,
                                                  TMSP_INIZIO_ELAB)
                                           SELECT
                                                  PROCF.COD_PROCSO_FILE,
                                                  ID_ESEC_PROCSO_FILE_ORD_ESPL,
                                                  INTRFC.ID_PROCSO_FILE,
                                                  'IN ELABORAZIONE',
                                                  NULL,
                                                  SYSTIMESTAMP
                                           FROM INTRFC
                                           JOIN PROCSO_FILE procf on INTRFC.ID_PROCSO_FILE = PROCF.ID_PROCSO_FILE
                                       WHERE INTRFC.ID_INTRFC = 142;

                      COMMIT;

                    INSERT INTO FILE_PROCSTO (COD_OLO,
                                              CODFC_OLO_AGCOM,
                                              DATA_FILE,
                                              DESCR_STATO_FILE,
                                              ESITO,
                                              ID_ESEC_PROCSO_FILE,
                                              ID_FILE,
                                              ID_INTRFC,
                                              IDTPLG_FILE,
                                              NOME_FILE,
                                              TIMSTP_APERTURA_FILE,
                                              TIMSTP_CHIUSURA_FILE,
                                              VERSO_DEL_FILE)
                                       SELECT
                                              OLO.COD_OLO,
                                              OLO.CODFC_OLO_AGCOM,
                                              to_date(SYSDATE),
                                              'IN ELABORAZIONE',
                                              NULL,
                                              ID_ESEC_PROCSO_FILE_ORD_ESPL,
                                              ID_FILE_NAME_ORD_ESPL,
                                              '142',
                                              '2',
                                              FULL_FILE_NAME_ORD_ESPL,
                                              SYSTIMESTAMP,
                                              NULL,
                                              'OUTPUT'
                                       FROM OLO
                                       WHERE CODFC_OLO_AGCOM = ELENCO_OLO(I);

                      COMMIT;

                  EXCEPTION
                    WHEN OTHERS THEN
                    INFO('** FATAL ERROR: ' || SQLCODE || ' - ' || SQLERRM || ' **');
                    UPDATE_STATUS(ID_FILE_NAME_ORD_ESPL, FLAG_KO, SUBSTR(SQLCODE || SQLERRM, 1, 2000));

                  END;

                  -- Completo la query di estrazione degli ordini per DIFD_AGC_NTFORD_ESPL con la condizione di appartenenza all OLO in elaborazione
                  SELEZ_ORD_X_DIFF_I := SELEZ_ORD_X_DIFF || 'and rich.CODIFICAOLOAGCOM = ''' || ELENCO_OLO(I) || '''';

LOG('SELEZ_ORD_X_DIFF_I: ' || SELEZ_ORD_X_DIFF_I);

                  OPEN RESULTSETORD FOR SELEZ_ORD_X_DIFF_I;

                  LOOP

                      FETCH RESULTSETORD BULK COLLECT INTO ELENCO_ORD LIMIT LINES_BLOCK;

                      FORALL K IN ELENCO_ORD.FIRST..ELENCO_ORD.LAST

                            INSERT INTO DIFD_AGC_NTFORD_ESPL (COD_OLO_NUMERICO,
                                                                COD_ORDN_OLO,
                                                                COD_ORDN_TI,
                                                                COD_TIPOLG_NOTF,
                                                                CODFC_OLO_AGCOM,
                                                                DATA_ESTRAZIONE,
                                                                DATA_INVIO_FILE_NOTF,
                                                                ESITO_ESPLETAMENTO,
                                                                ID_FILE_PROCSTO_OUTPUT,
                                                                ID_NOTF,
                                                                NOME_FILE_NOTF,
                                                                STRUTTURA_RICH,
                                                                TIMSTP_INSMTO_RECD,
                                                                CODFC_OLO_AGCOM_DESTNRIO
                                                                )
                            SELECT                              OLO.COD_OLO,    --  -- RU 245 Cristiano Conte
                                                                RICH.CODICEORDINEOLO,
                                                                RICH.CODICEORDINETI,
                                                                notif.COD_TIPOLG_NOTF,
                                                                RICH.CODIFICAOLOAGCOM,
                                                                SYSDATE-1,
                                                                filepout.TIMSTP_INVIO,
                                                                PKG_ESTRAZIONI.MAPP_STATO_RICH(rich.STRUTTURARICHIESTA, rich.STATORICHIESTANOW, notif.COD_TIPOLG_NOTF),
                                                                filepout.ID_FILE_PROCSTO_OUTPUT,
                                                                notif.ID_NOTF,
                                                                PKG_ESTRAZIONI.MAPP_NOME_FILE(fileproc.NOME_FILE, notif.IDTPLG_STNTF_FILE_ORARIO),
                                                                rich.STRUTTURARICHIESTA,
                                                                SYSTIMESTAMP,
                                                                RICH.CODIFICAOLOAGCOM
                                                           FROM BDS_1_CASEDATA_RICHIESTA rich
                                                           left OUTER JOIN BDS_1_CASEDATA_ORDINE ord_now on ORD_NOW.IDRICHIESTAOLO = rich.IDRICHIESTAOLO
                                                           JOIN OLO on rich.CODIFICAOLOAGCOM = OLO.CODFC_OLO_AGCOM
                                                           JOIN RICH_ORDN_COMUNIC_NOTF notif on rich.IDRICHIESTAOLO = notif.ID_RICH_OLO
                                                           JOIN FILE_NOTF_STANDARD notfst on notif.ID_NOTF = notfst.ID_NOTF
                                                           JOIN FILE_PROCSTO_OUTPUT filepout on notfst.ID_FILE_PROCSTO_OUTPUT = filepout.ID_FILE_PROCSTO_OUTPUT
                                                           JOIN FILE_PROCSTO fileproc on filepout.ID_FILE_PROCSTO_OUTPUT = fileproc.ID_FILE
                                                           WHERE PKG_ESTRAZIONI.MAPP_STATO_RICH(rich.STRUTTURARICHIESTA, rich.STATORICHIESTANOW, notif.COD_TIPOLG_NOTF) is not NULL
                                                           AND   fileproc.ID_INTRFC in (61, 64, 69)
                                                           AND notif.ORIGINE_NOTF <> ' || OR_NOTIF_NOGUI || '
                                                           AND RICH.IDRICHIESTAOLO = ELENCO_ORD(K);
                      COMMIT;

                      EXIT WHEN RESULTSETORD%NOTFOUND;
                  END LOOP;

            END LOOP;

        END IF;

        EXIT WHEN RESULTSETOLO%NOTFOUND;
    END LOOP;

    UPDATE CFG_START_ESTRAZIONI
    SET DATA_ESPLETAMENTO = NULL
    WHERE COD_INTRFC = 'ID173';

    COMMIT;

  END ESTRAI_ORDINI_ESPLETATI;

--/ANDREA GARAVINI

-- Luca Abbate, Lotto 5
  PROCEDURE ESTRAI_NP_ATTIVI(ID_FILE       IN NUMBER,
                              DATA_INIZIO   IN VARCHAR2,
                              DATA_FINE     IN VARCHAR2,
                              CODICE_OLO    IN VARCHAR2)
  IS
BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_NP_ATTIVI **');
    PKG_ESTRAZIONI_RA.ESTRAI_NP_ATTIVI(ID_FILE, DATA_INIZIO, DATA_FINE, CODICE_OLO);

    /* ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_ATTIVI,
                          FILE_NAME_NP_ATT || '_' || TODAY || FILE_EXT,
                          SERVICE_NP,
                          DATA_INIZIO,
                          DATA_FINE,
                          CODICE_OLO,
                          SKIP_CRMESTRATTORE => TRUE);
    */
    INFO('** FINISHED PROCEDURE ESTRAI_NP_ATTIVI **');
  END ESTRAI_NP_ATTIVI;

  PROCEDURE ESTRAI_NP_CESSATI(ID_FILE           IN NUMBER,
                               DATA_ESPLETAMENTO IN VARCHAR2)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_NP_CESSATI **');
    PKG_ESTRAZIONI_RA.ESTRAI_NP_CESSATI(ID_FILE, DATA_ESPLETAMENTO);
    /*
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_CESSATI,
                          FILE_NAME_NP_CESS || '_' || TODAY || FILE_EXT,
                          SERVICE_NP,
                          NULL,
                          DATA_ESPLETAMENTO,
                          NULL,
                          SKIP_CRMESTRATTORE => TRUE);
    */
    INFO('** FINISHED PROCEDURE ESTRAI_NP_CESSATI **');
  END ESTRAI_NP_CESSATI;
--/ Luca Abbate, Lotto5

--INIZIO RU_975 CPS VC RAES
  PROCEDURE ESTRAI_CPS_ATTIVI(ID_FILE       IN NUMBER,
                              DATA_INIZIO   IN VARCHAR2,
                              DATA_FINE     IN VARCHAR2,
                              CODICE_OLO    IN VARCHAR2)
  IS
BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_NP_ATTIVI **');
    PKG_ESTRAZIONI_RA.ESTRAI_CPS_ATTIVI(ID_FILE, DATA_INIZIO, DATA_FINE, CODICE_OLO);

    INFO('** FINISHED PROCEDURE ESTRAI_CPS_ATTIVI **');
  END ESTRAI_CPS_ATTIVI;


  PROCEDURE ESTRAI_CPS_CESSATI(ID_FILE           IN NUMBER,
                               DATA_ESPLETAMENTO IN VARCHAR2)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_CPS_CESSATI **');
    PKG_ESTRAZIONI_RA.ESTRAI_CPS_CESSATI(ID_FILE, DATA_ESPLETAMENTO);

    INFO('** FINISHED PROCEDURE ESTRAI_CPS_CESSATI **');
  END ESTRAI_CPS_CESSATI;


  PROCEDURE ESTRAI_CPS_INCONTRA (ID_FILE       IN NUMBER,
                             CODICE_OLO    IN VARCHAR2)
  IS
BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_CPS_INCONTRA **');
    ESTRAI_GENERIC_ASSET_CPS (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_X_INCONTRA,
                          FILE_NAME_CPS_INCONTRA || '_' || TODAY || FILE_EXT,
                          SERVICE_CPS_INCONTRA,
                          NULL,
                          NULL,
                          NULL);
    INFO('** FINISHED PROCEDURE ESTRAI_CPS_INCONTRA **');
  END ESTRAI_CPS_INCONTRA;

  PROCEDURE ESTRAI_CPS_FRMSFRAUD (ID_FILE       IN NUMBER,
                             CODICE_OLO    IN VARCHAR2)
  IS
BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_CPS_FRMSFRAUD **');
    ESTRAI_GENERIC_ASSET_CPS (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_X_INCONTRA,
                          FILE_NAME_CPS_FRMSFRAUD || '_' || TODAY || FILE_EXT,
                          SERVICE_CPS_FRMSFRAUD,
                          NULL,
                          NULL,
                          NULL);
    INFO('** FINISHED PROCEDURE ESTRAI_CPS_FRMSFRAUD **');
  END ESTRAI_CPS_FRMSFRAUD;
--FINE_RU_975 CPS VS RAES


-- Luca Abbate, Lotto6
-- INCONTRA - Lotto6
  PROCEDURE ESTRAI_INCONTRA (ID_FILE       IN NUMBER,
                             DATA_INIZIO   IN VARCHAR2,
                             DATA_FINE     IN VARCHAR2,
                             CODICE_OLO    IN VARCHAR2)
  IS
  COUNT_ROW NUMBER; --RU_1100
  CHEK NUMBER; --RU_1100
  vx_ID_FILE  NUMBER; --RU_1100

BEGIN

COUNT_ROW :=0; --RU_1100
CHEK :=0; --RU_1100
vx_ID_FILE:= ID_FILE;--RU_1100



    INFO('** STARTED PROCEDURE ESTRAI_INCONTRA **');
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_X_INCONTRA,
                          FILE_NAME_INCONTRA || TO_CHAR(SYSDATE, '"P"YYMMDD".001"') || UPPER(FILE_EXT),
                          SERVICE_INCONTRA,
                          DATA_INIZIO,
                          DATA_FINE,
                          NULL);


-- INIZIO RU_1100
select count(*)  Into CHEK
 from APPUSER.CFG_START_ESTRAZIONI a
 where sistema ='INCONTRA' and COD_INTRFC='ID195' AND GENERIC_PARAM='Y';


IF CHEK > 0 THEN

     CHEK:=0;
     select count(*) Into CHEK
        from stato_estrazioni where id_file=vx_ID_FILE and STATUS='OK';

     IF CHEK > 0 THEN
      INFO('** STARTED LOAD TAB STAG_INCONTRA_OUTPUT_FILE **');

      DELETE FROM APPUSER.STAG_INCONTRA_OUTPUT_FILE  WHERE ID_FILE_PROCSTO_OUT=vx_ID_FILE;

       BEGIN
              INSERT INTO APPUSER.STAG_INCONTRA_OUTPUT_FILE
                (ID_SO,
                 STATO_SO,
                 PREFISSO,
                 NUMERO,
                 DATA_EMISSIONE,
                 DATA_ESPLETAMENTO,
                 CODE_DR,
                 TIPO_RICHIESTA,
                 FAMIGLIA_SERVIZIO,
                 ORIGINE_SO,
                 SERVIZIO,
                 COD_OLO,
                 CODFC_OLO_AGCOM,
                 NOME_FILE,
                 DATA_INSERIMENTO,
                 ID_FILE_PROCSTO_OUT,
                 ID_STATO_ELAB_STAG,
                 NUM_RECORD)
          select           TO_CHAR(REGEXP_SUBSTR(RIGA,'([^|]*)(\||$)', 1,2,NULL,1)) ID_SO,
                           TO_CHAR(REGEXP_SUBSTR(RIGA,'([^|]*)(\||$)', 1,3,NULL,1)) STATO_SO,
                           TO_CHAR(REGEXP_SUBSTR(RIGA,'([^|]*)(\||$)', 1,4,NULL,1)) PREFISSO,
                           TO_CHAR(REGEXP_SUBSTR(RIGA,'([^|]*)(\||$)', 1,5,NULL,1)) NUMERO,
                           TO_DATE( TO_CHAR(REGEXP_SUBSTR(RIGA,'([^|]*)(\||$)', 1,6,NULL,1)),'YYYYMMDD') DATA_EMISSIONE,
                           TO_DATE( TO_CHAR(REGEXP_SUBSTR(RIGA,'([^|]*)(\||$)', 1,7,NULL,1)),'YYYYMMDD') DATA_ESPLETAMENTO,
                           TO_CHAR(REGEXP_SUBSTR(RIGA,'([^|]*)(\||$)', 1,8,NULL,1)) CODE_DR,
                           TO_CHAR(REGEXP_SUBSTR(RIGA,'([^|]*)(\||$)', 1,9,NULL,1)) TIPO_RICHIESTA,
                           TO_CHAR(REGEXP_SUBSTR(RIGA,'([^|]*)(\||$)', 1,10,NULL,1)) FAMIGLIA_SERVIZIO,
                           TO_CHAR(REGEXP_SUBSTR(RIGA,'([^|]*)(\||$)', 1,11,NULL,1)) ORIGINE_SO,
                           TO_CHAR(REGEXP_SUBSTR(RIGA,'([^|]*)(\||$)', 1,12,NULL,1)) SERVIZIO,
                           TO_CHAR(REGEXP_SUBSTR(RIGA,'([^|]*)(\||$)', 1,13,NULL,1)) COD_OLO,
                           TO_CHAR(REGEXP_SUBSTR(RIGA,'([^|]*)(\||$)', 1,14,NULL,1)) CODFC_OLO_AGCOM,
                           nome_file,
                           SYSDATE,
                           TO_NUMBER(ID_FILE) ID_FILE,
                           2,
                           TO_NUMBER(ROWNUM) NUM
                            from APPUSER.ESTRAZIONI A
                      where REGEXP_SUBSTR(RIGA,'([^|]*)(\||$)', 1,1,NULL,1)='02'
                      AND A.ID_FILE=vx_ID_FILE
                      ORDER BY sequenza asc;

                     COUNT_ROW:= SQL%ROWCOUNT;
                     COMMIT;

         EXCEPTION
            WHEN NO_DATA_FOUND THEN
                COUNT_ROW:=0;
            WHEN OTHERS THEN
               COUNT_ROW:=NULL;
               INFO('** PROCEDURE ESTRAI_INCONTRA - FATAL ERROR: ' || SQLCODE || ' - ' || SQLERRM || ' **');
                UPDATE_STATUS(ID_FILE, FLAG_KO, 'STOR+'||SUBSTR(SQLCODE || SQLERRM, 1, 2000));
           END;

         INFO('** FINISHED LOAD STAG_INCONTRA_OUTPUT_FILE - COUNT: ' ||COUNT_ROW||'**');
     END IF;

 END IF;
 --FINE RU_1100

    INFO('** FINISHED PROCEDURE ESTRAI_INCONTRA **');


  END ESTRAI_INCONTRA;




-- VULL vs RA, RAES - Lotto6
  PROCEDURE ESTRAI_VULL_ATTIVI(ID_FILE       IN NUMBER,
                              DATA_INIZIO   IN VARCHAR2,
                              DATA_FINE     IN VARCHAR2,
                              CODICE_OLO    IN VARCHAR2)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_VULL_ATTIVI **');
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_ATTIVI,
                          FILE_NAME_VULL_ATT || '_' || TODAY || FILE_EXT,
                          SERVICE_VULL,
                          DATA_INIZIO,
                          DATA_FINE,
                          CODICE_OLO,
                          SKIP_CRMESTRATTORE => TRUE);
    INFO('** FINISHED PROCEDURE ESTRAI_VULL_ATTIVI **');
  END ESTRAI_VULL_ATTIVI;

  PROCEDURE ESTRAI_VULL_CESSATI(ID_FILE           IN NUMBER,
                               DATA_ESPLETAMENTO IN VARCHAR2)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_VULL_CESSATI **');
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_CESSATI,
                          FILE_NAME_VULL_CESS || '_' || TODAY || FILE_EXT,
                          SERVICE_VULL,
                          NULL,
                          DATA_ESPLETAMENTO,
                          NULL,
                          SKIP_CRMESTRATTORE => TRUE);
    INFO('** FINISHED PROCEDURE ESTRAI_VULL_CESSATI **');
  END ESTRAI_VULL_CESSATI;

-- WLR vs RA, RAES - Lotto6
  PROCEDURE ESTRAI_WLR_STS_ATTIVI(ID_FILE       IN NUMBER,
                                  DATA_INIZIO   IN VARCHAR2,
                                  DATA_FINE     IN VARCHAR2,
                                  CODICE_OLO    IN VARCHAR2)
  IS
  BEGIN
    ESTRAI_WLR_ATTIVI (ID_FILE, DATA_INIZIO, DATA_FINE, CODICE_OLO);
    ESTRAI_STS_ATTIVI (ID_FILE, DATA_INIZIO, DATA_FINE, CODICE_OLO);
  END ESTRAI_WLR_STS_ATTIVI;

  PROCEDURE ESTRAI_WLR_STS_CESSATI(ID_FILE           IN NUMBER,
                                   DATA_ESPLETAMENTO IN VARCHAR2)
   IS
  BEGIN
    ESTRAI_WLR_CESSATI (ID_FILE, DATA_ESPLETAMENTO);
    ESTRAI_STS_CESSATI (ID_FILE, DATA_ESPLETAMENTO);
  END ESTRAI_WLR_STS_CESSATI;

  PROCEDURE ESTRAI_WLR_ATTIVI(ID_FILE       IN NUMBER,
                              DATA_INIZIO   IN VARCHAR2,
                              DATA_FINE     IN VARCHAR2,
                              CODICE_OLO    IN VARCHAR2)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_WLR_ATTIVI **');
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_ATTIVI,
                          FILE_NAME_WLR_ATT || '_' || TODAY || FILE_EXT,
                          SERVICE_WLR,
                          DATA_INIZIO,
                          DATA_FINE,
                          CODICE_OLO,
                          SKIP_CRMESTRATTORE => TRUE);
    INFO('** FINISHED PROCEDURE ESTRAI_WLR_ATTIVI **');
  END ESTRAI_WLR_ATTIVI;

  PROCEDURE ESTRAI_WLR_CESSATI(ID_FILE           IN NUMBER,
                               DATA_ESPLETAMENTO IN VARCHAR2)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_WLR_CESSATI **');
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_CESSATI,
                          FILE_NAME_WLR_CESS || '_' || TODAY || FILE_EXT,
                          SERVICE_WLR,
                          NULL,
                          DATA_ESPLETAMENTO,
                          NULL,
                          SKIP_CRMESTRATTORE => TRUE);
    INFO('** FINISHED PROCEDURE ESTRAI_WLR_CESSATI **');
  END ESTRAI_WLR_CESSATI;

-- STS WLR vs RA, RAES - Lotto6
  PROCEDURE ESTRAI_STS_ATTIVI(ID_FILE       IN NUMBER,
                              DATA_INIZIO   IN VARCHAR2,
                              DATA_FINE     IN VARCHAR2,
                              CODICE_OLO    IN VARCHAR2)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_STS_ATTIVI **');
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_ATTIVI,
                          FILE_NAME_WLR_ATT || '_' || TODAY || FILE_EXT,
                          SERVICE_STS_WLR,
                          DATA_INIZIO,
                          DATA_FINE,
                          CODICE_OLO,
                          SKIP_CRMESTRATTORE => TRUE);
    INFO('** FINISHED PROCEDURE ESTRAI_STS_ATTIVI **');
  END ESTRAI_STS_ATTIVI;

  PROCEDURE ESTRAI_STS_CESSATI(ID_FILE           IN NUMBER,
                               DATA_ESPLETAMENTO IN VARCHAR2)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_STS_CESSATI **');
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_CESSATI,
                          FILE_NAME_WLR_CESS || '_' || TODAY || FILE_EXT,
                          SERVICE_STS_WLR,
                          NULL,
                          DATA_ESPLETAMENTO,
                          NULL,
                          SKIP_CRMESTRATTORE => TRUE);
    INFO('** FINISHED PROCEDURE ESTRAI_STS_CESSATI **');
  END ESTRAI_STS_CESSATI;

-------------- RU_371 INIZIO
-- VULL vs SISTINA
  PROCEDURE ESTRAI_VULL_SISTINA_NOT_NULL (ID_FILE       IN NUMBER,
                                          DATA_INIZIO   IN VARCHAR2,
                                          DATA_FINE     IN VARCHAR2
                                          )
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_VULL_SISTINA_NOT_NULL **');
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_SISTINA_NOT_NULL,
                          FILE_NAME_SISTINA_VULL || TODAY('YYMMDD') || FILE_EXT,
                          SERVICE_SISTINA_VULL_NOT_NULL,
                          DATA_INIZIO,
                          DATA_FINE,
                          NULL,
                          EMPTY_STRING);
    INFO('** FINISHED PROCEDURE ESTRAI_VULL_SISTINA_NOT_NULL **');
  END ESTRAI_VULL_SISTINA_NOT_NULL;

  PROCEDURE ESTRAI_VULL_SISTINA_NULL (ID_FILE         IN NUMBER,
                                  RUN_QUERY       IN BOOLEAN,
                                  SERVICE         IN VARCHAR2,
                                  DATA_DA         IN VARCHAR2,
                                  DATA_A          IN VARCHAR2)

  IS
    TYPE TSISTINA_RECORD IS RECORD(DATA_ELAB SCARTI_VULL_SISTINA.DATA_ELAB%TYPE,
                                   NUMRZNE SCARTI_VULL_SISTINA.NUMRZNE%TYPE,
                                   CONTENUTO_RECD SCARTI_VULL_SISTINA.CONTENUTO_RECD%TYPE,
                                   CAUS_SCARTO SCARTI_VULL_SISTINA.CAUS_SCARTO%TYPE
                                 );

    TYPE tSISTINA_RECORDS IS TABLE OF TSISTINA_RECORD;
    TYPE tSISTINA_CURSOR IS REF CURSOR;

    SISTINA_RECORDS   tSISTINA_RECORDS;
    cSISTINA          tSISTINA_CURSOR;

    FROM_CLAUSE     VARCHAR2(5000);
    WHERE_CLAUSE    VARCHAR2(2000);
    SQL_STATEMENT   VARCHAR2(10000);
    DATE_ATTIVI     VARCHAR2(500);
    DATE_CESSATI    VARCHAR2(500);
    CONSISTENZA_NOW PARAMETRI_CFGZ_NOW.VALORE_STRINGA%TYPE;
  BEGIN
    LOG('   SPOOL GENERIC VULL_SISTINA_NULL');

    IF SERVICE IS NULL THEN
      RAISE_APPLICATION_ERROR(-20994, 'SERVICE_NAME CANNOT BE NULL');
    END IF;

    IF DATA_DA IS NOT NULL AND DATA_A IS NOT NULL THEN
      DATE_ATTIVI := 'ASSET.LASTUPDATE BETWEEN ' || GET_DATE(DATA_DA) || ' AND ' || GET_DATE(DATA_A);
      DATE_CESSATI := q'xASSET.LASTUPDATE BETWEEN TRUNC(ADD_MONTHS(x' || GET_DATE(DATA_DA) || q'x, -6)) + INTERVAL '1' DAY AND x' || GET_DATE(DATA_A);
    ELSE
      DATE_ATTIVI := q'xTRUNC(ASSET.LASTUPDATE) = TRUNC(SYSDATE) - INTERVAL '1' DAYx';
      DATE_CESSATI := q'xASSET.LASTUPDATE BETWEEN TRUNC(ADD_MONTHS(SYSDATE, -6)) AND TRUNC(SYSDATE) - INTERVAL '1' DAYx';
    END IF;

    SELECT VALORE_STRINGA INTO CONSISTENZA_NOW FROM PARAMETRI_CFGZ_NOW WHERE CHIAVE = 'OWNER_CONSISTENZA';

    FROM_CLAUSE := CHR(10) || ' FROM BDS_1_CASEDATA_ASSET ASSET' || CHR(10) || JOIN_TABLES(SERVICE);
    WHERE_CLAUSE :=  'WHERE OFF.ID_OFFERTA = ANY ' || IDS_OFFERTA(SERVICE) || CHR(10);
    WHERE_CLAUSE := WHERE_CLAUSE || ' AND (';
    WHERE_CLAUSE := WHERE_CLAUSE || '(ASSET.STATOASSET = ANY (''' || STATUS_INLAVORAZIONE || ''', ''' || STATUS_ATTIVO || ''')';
    WHERE_CLAUSE := WHERE_CLAUSE || ' AND '|| DATE_ATTIVI || ')';
    WHERE_CLAUSE := WHERE_CLAUSE || '   OR (ASSET.STATOASSET = ''' || STATUS_CESSATO || '''';
    WHERE_CLAUSE := WHERE_CLAUSE || ' AND '|| DATE_CESSATI || ')';
    WHERE_CLAUSE := WHERE_CLAUSE || ')' || CHR(10);
    WHERE_CLAUSE := WHERE_CLAUSE || ' AND (';
    WHERE_CLAUSE := WHERE_CLAUSE || ' ASSET.IDRISORSA is null';
    WHERE_CLAUSE := WHERE_CLAUSE || ' OR ASSET.DESPRIMOORDINE is null';
    WHERE_CLAUSE := WHERE_CLAUSE || ' OR ASSET.DES is null';
    WHERE_CLAUSE := WHERE_CLAUSE || ' OR ASSET.CODIFICAOLOAGCOM is null';
    WHERE_CLAUSE := WHERE_CLAUSE || ' OR CLIENTE.COGNOMERAGIONESOCIALE is null';
    WHERE_CLAUSE := WHERE_CLAUSE || ')' || CHR(10);
    IF CONSISTENZA_NOW = 'N' THEN
      WHERE_CLAUSE := WHERE_CLAUSE || q'x AND ASSET.CRMESTRATTORE = 'NOW'x' || CHR(10);
    END IF;
    SQL_STATEMENT := BUILD_SQL_STATEMENT(FILE_COLUMNS(SERVICE), FROM_CLAUSE, WHERE_CLAUSE);

   LOG('   BUILT STATEMENT: ' || CHR(10) || SQL_STATEMENT);

    IF NOT RUN_QUERY THEN
      INFO('   BUILT STATEMENT: ' || CHR(10) || SQL_STATEMENT);
   ELSE

    OPEN cSISTINA FOR SQL_STATEMENT;

    LOOP
      FETCH cSISTINA BULK COLLECT INTO SISTINA_RECORDS LIMIT 1000;
      EXIT WHEN SISTINA_RECORDS.COUNT = 0;

      FORALL I IN 1..SISTINA_RECORDS.COUNT
        INSERT INTO SCARTI_VULL_SISTINA
          (
            DATA_ELAB,
            NUMRZNE,
            CONTENUTO_RECD,
            CAUS_SCARTO
          )
        VALUES
         (
           SISTINA_RECORDS(I).DATA_ELAB,
           SISTINA_RECORDS(I).NUMRZNE,
           SISTINA_RECORDS(I).CONTENUTO_RECD,
           SISTINA_RECORDS(I).CAUS_SCARTO
          );
      COMMIT;
    END LOOP;

      CLOSE cSISTINA;

    END IF;

   /* IF RUN_QUERY THEN
      UPDATE_STATUS(inID_FILE, FLAG_OK);
    END IF;*/

    LOG ('   FINISHED SISTINA DATA SPOOL');
  EXCEPTION
    WHEN OTHERS THEN
    INFO('** FATAL ERROR: ' || SQLCODE || ' - ' || SQLERRM || ' **');
     UPDATE_STATUS(ID_FILE, FLAG_KO, SUBSTR(SQLCODE || SQLERRM, 1, 2000));
  END ESTRAI_VULL_SISTINA_NULL;

  PROCEDURE ESTRAI_VULL_SISTINA(ID_FILE       IN NUMBER,
                                DATA_INIZIO   IN VARCHAR2,
                                DATA_FINE     IN VARCHAR2)
  IS
  BEGIN
    ESTRAI_VULL_SISTINA_NOT_NULL(ID_FILE, DATA_INIZIO, DATA_FINE);
    ESTRAI_VULL_SISTINA_NULL (ID_FILE,
                        gRUNQUERY,
                        SERVICE_SISTINA_VULL_NULL,
                        DATA_INIZIO,
                        DATA_FINE);
  END ESTRAI_VULL_SISTINA;

-------------- RU_371 FINE

-- SHA vs RA, RAES - Lotto6
  PROCEDURE ESTRAI_SHA_ATTIVI(ID_FILE       IN NUMBER,
                              DATA_INIZIO   IN VARCHAR2,
                              DATA_FINE     IN VARCHAR2,
                              CODICE_OLO    IN VARCHAR2)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_SHA_ATTIVI **');
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_ATTIVI,
                          FILE_NAME_SHA_ATT || '_' || TODAY || FILE_EXT,
                          SERVICE_SHA,
                          DATA_INIZIO,
                          DATA_FINE,
                          CODICE_OLO,
                          SKIP_CRMESTRATTORE => TRUE);
    INFO('** FINISHED PROCEDURE ESTRAI_SHA_ATTIVI **');
  END ESTRAI_SHA_ATTIVI;

  PROCEDURE ESTRAI_SHA_CESSATI(ID_FILE           IN NUMBER,
                               DATA_ESPLETAMENTO IN VARCHAR2)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_SHA_CESSATI **');
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_CESSATI,
                          FILE_NAME_SHA_CESS || '_' || TODAY || FILE_EXT,
                          SERVICE_SHA,
                          NULL,
                          DATA_ESPLETAMENTO,
                          NULL,
                          SKIP_CRMESTRATTORE => TRUE);
    INFO('** FINISHED PROCEDURE ESTRAI_SHA_CESSATI **');
  END ESTRAI_SHA_CESSATI;


  -- VULL vs RI - Lotto6
  PROCEDURE ESTRAI_NOW_RI_VULL (ID_FILE      IN NUMBER,
                               DATA_INIZIO  IN VARCHAR2,
                               DATA_FINE    IN VARCHAR2)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_NOW_RI_VULL **');
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_ATTIVI_RI,
                          FILE_NAME_NOWRI_VULL || '_' || FORMAT_DATE(DATA_INIZIO, 'YYYYMMDD') ||  '_' || FORMAT_DATE(DATA_FINE, 'YYYYMMDD') || FILE_EXT,
                          SERVICE_VULL_RI,
                          DATA_INIZIO,
                          DATA_FINE,
                          NULL);
    INFO('** FINISHED PROCEDURE ESTRAI_NOW_RI_VULL **');
  END ESTRAI_NOW_RI_VULL;

  -- WLR vs RI - Lotto6
  PROCEDURE ESTRAI_NOW_RI_WLR (ID_FILE      IN NUMBER,
                               DATA_INIZIO  IN VARCHAR2,
                               DATA_FINE    IN VARCHAR2)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_NOW_RI_WLR **');
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_ATTIVI_RI,
                          FILE_NAME_NOWRI_WLR || '_' || FORMAT_DATE(DATA_INIZIO, 'YYYYMMDD') ||  '_' || FORMAT_DATE(DATA_FINE, 'YYYYMMDD') || FILE_EXT,
                          SERVICE_WLR_RI,
                          DATA_INIZIO,
                          DATA_FINE,
                          NULL);
    INFO('** FINISHED PROCEDURE ESTRAI_NOW_RI_WLR **');
  END ESTRAI_NOW_RI_WLR;

  -- SHA vs RI - Lotto6
  PROCEDURE ESTRAI_NOW_RI_SHA (ID_FILE      IN NUMBER,
                               DATA_INIZIO  IN VARCHAR2,
                               DATA_FINE    IN VARCHAR2)
  IS
  BEGIN
    INFO('** STARTED PROCEDURE ESTRAI_NOW_RI_SHA **');
    ESTRAI_GENERIC_ASSET (ID_FILE,
                          gRUNQUERY,
                          ESTRAI_ATTIVI_RI,
                          FILE_NAME_NOWRI_SHA || '_' || FORMAT_DATE(DATA_INIZIO, 'YYYYMMDD') ||  '_' || FORMAT_DATE(DATA_FINE, 'YYYYMMDD') || FILE_EXT,
                          SERVICE_SHA_RI,
                          DATA_INIZIO,
                          DATA_FINE,
                          NULL);
    INFO('** FINISHED PROCEDURE ESTRAI_NOW_RI_SHA **');
  END ESTRAI_NOW_RI_SHA;

  -- NOW vs RAC -- lOTTO 6
  PROCEDURE ESTRAI_NOW_VS_RAC (ID_FILE      IN NUMBER,
                               DATA_INIZIO  IN VARCHAR2,
                               DATA_FINE    IN VARCHAR2)
  IS
  BEGIN -- DA IMPLEMENTARE LA QUERY --
    INFO('** STARTED PROCEDURE ESTRAI_NOW_VS_RAC **');
    ESTRAI_GENERIC_ORDINI (ID_FILE,
                          NULL,
                          SERVICE_RAC,
                          FILE_NAME_RAC || '_' || FORMAT_DATE(TO_CHAR(SYSDATE, 'YYYY-MM-DD'), 'YYYYMMDD') || FILE_EXT,
                          gRUNQUERY,
                          DATA_INIZIO,
                          DATA_FINE);
    INFO('** FINISHED PROCEDURE ESTRAI_NOW_VS_RAC **');
  END ESTRAI_NOW_VS_RAC;

--/ Luca Abbate, Lotto6

  PROCEDURE TRUNCATE_OPERA
  IS
    kNOMEFILE CONSTANT STATO_ESTRAZIONI.NOME_FILE%TYPE DEFAULT 'TRUNCATE_OPERA';
    STATO_ID  ROWID;
  BEGIN
    <<CHECK_OPERA>>
    DECLARE
      CHECK_RECORD PLS_INTEGER;
    BEGIN
      SELECT 1
      INTO CHECK_RECORD
      FROM STATO_ESTRAZIONI SE
      WHERE SE.NOME_FILE = kNOMEFILE
        AND TRUNC(CREATED) = TRUNC(SYSDATE);
    EXCEPTION
      WHEN NO_DATA_FOUND THEN
        INSERT INTO STATO_ESTRAZIONI
          (CREATED,
          LAST_UPD,
          NOME_FILE,
          ID_FILE,
          STATUS)
        VALUES
          (SYSTIMESTAMP,
           SYSTIMESTAMP,
           kNOMEFILE,
           S_FILE_PROCSTO.NEXTVAL,
           FLAG_LOADING)
        RETURNING ROWID INTO STATO_ID;

        COMMIT;

        EXECUTE IMMEDIATE 'TRUNCATE TABLE OGG_NOW_TO_OPERA_MENSILE_ASSET';

        UPDATE STATO_ESTRAZIONI
        SET STATUS = FLAG_OK
        WHERE ROWID = STATO_ID;

        COMMIT;
    END CHECK_OPERA;
  EXCEPTION
    WHEN OTHERS THEN
      <<OTHERS_BLOCK>>
      DECLARE
        ERROR_MESSAGE VARCHAR(2000):= SUBSTR(SQLERRM, 1, 2000);
      BEGIN
        IF STATO_ID IS NOT NULL THEN
          UPDATE STATO_ESTRAZIONI
          SET STATUS = FLAG_KO,
              DESCR_ERRORE = ERROR_MESSAGE
          WHERE ROWID = STATO_ID;
          COMMIT;
        ELSE
          RAISE;
        END IF;
      END OTHERS_BLOCK;
  END TRUNCATE_OPERA;

BEGIN

  DECLARE
    TMP_SELECT_COLS T_SELECT_COLUMNS;
    BASE_SELECT_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS ('ASSET.CODICEORDINETI', -- ID_ORD_CRMWS (1) -- OK
                                        q'xCASE ASSET.STATOASSET WHEN TO_NCHAR('x' || STATUS_INLAVORAZIONE || q'x') THEN 'S' ELSE 'N' ENDx', -- LOCK (2) -- OK
                                        q'xPKG_ESTRAZIONI.GET_CAUSALE(ORD.TIPOLOGIASOTTOLAV, ORD.TIPOLOGIASCENARIO, ASSET.IDOFFERTA)x', -- CAUSALE (3)  Lotto6 -- OK
                                        'PKG_ESTRAZIONI.CODIFICA_TIPO_ORDINE(ORD.TIPOLOGIALAVORAZIONE)', -- TIPO_ORDINE (4) -- OK
                                        'OFF.COD_OFFERTA_JPUB', -- TIPO_CONTR (5) -- OK
                                        'PKG_ESTRAZIONI.SET_DATE(ASSET.DES)', -- DATA_DES (6) -- OK
                                        'ASSET.IDRISORSA', -- ID_RIS (7) -- OK
                                        'ASSET.CODIFICAOLOAGCOM', -- CODE_GEST_REC (8) -- OK
                                        q'yCASE UPPER(PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'STRUTTURALINEA')) WHEN 'SIMPLEX' THEN 56  WHEN 'GNR' THEN 50 WHEN 'PBX' THEN 55 ELSE Null  ENDy', -- TIPO_FAMIGLIA
                                        q'xCASE WHEN OFF.OFFERTA in ('ULL LINEA ATTIVA NP','ULL DATI LINEA ATTIVA NP') THEN 50 WHEN OFF.OFFERTA='SLU LINEA ATTIVA NP' THEN DECODE(UPPER(PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET (ASSET.BDS_ID, 'FLAGDNDONOROLO')), 'Y', 52, 50) ELSE 51 ENDx', --  OPZ COMMERCIALE Lotto 6
                                        q'xPKG_ESTRAZIONI.TIPOLINEA(ORD.BDS_ID, OFF.COD_OFFERTA_JPUB, OFF.ID_FAMIG_OFFERTA)x', -- TIPO_LINEA (11)
                                        'PKG_ESTRAZIONI.SET_DATE(ASSET.DESPRIMOORDINE)', -- DATA_INIZIO_NOL (12)
                                        q'xCASE WHEN TO_CHAR(ASSET.STATOASSET) = x' || DBMS_ASSERT.ENQUOTE_LITERAL(STATUS_CESSATO) || ' THEN PKG_ESTRAZIONI.SET_DATE(ASSET.DES) ELSE NULL END', -- DATA_CESSAZIONE (13)
                                        q'xCASE PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'PERMUTAARMADIO') WHEN 'N' THEN '0' WHEN 'S' THEN '1' ELSE '0' ENDx', -- FLAG_PERMUTA (14)
                                        q'xPKG_ESTRAZIONI.FLAG_QUALIFICA(PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'BITRATE'))x', -- FLAG_QUALIFICA (15)
                                        'PKG_ESTRAZIONI.SET_DATE(RICH.DRO)', -- DATA_DRO (16)
                                        'numtelefonico.NUMEROPRINCIPALE', -- NUMERO_AGGIUNTIVO per ULL,ULLD,SLU(17)
                                        q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'IDULLCO')x', -- CODE_IDULLCO (18)
                                        'PKG_ESTRAZIONI.SET_DATE(ORD.DAC)', -- DATA_PREVISTA_CHIUSURA (19)
                                        'ASSET.CODICEORDINEOLO', -- CODICE_ORDINE_OLO (20)
                                        'ORD.CODICEPROGETTO', -- CODICE_PROGETTO (21)
                                        'ASSET.CLLI', -- CODICE_CLLI(22)
                                        q'xCASE WHEN OFF.OFFERTA in ('ULL LINEA ATTIVA NP','ULL DATI LINEA ATTIVA NP','SLU LINEA ATTIVA NP') THEN 1 ELSE 0 ENDx', --  FLAG NP (23) Lotto 6
                                        q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'IDSLUCO')x', -- CODICE_ID_SLOOP(24)
                                        'PKG_ESTRAZIONI.DISTRETTO(ASSET.DISTRETTO)', -- CODE_DISTR (25)
                                        'TIP_RICH.STATO_RICH_NOW_GUI', -- STATO_ORDINE (26) --> SM_4022 STATO RICHIESTA NOW
                                        'PKG_ESTRAZIONI.CODIFICA_STATO_RICHIESTA(RICH.STATORICHIESTANOW)', -- ESITO_ACQUISIZIONE_BILLING (27)
                                        'AGREE.COD_CONTRATTO', -- CODE_CONTR (28)
                                        q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'ROUTINGNUMBER')x', -- ROUTING_NUMBER (29) Lotto6
                                        q'xCASE WHEN OFF.OFFERTA in ('ULL LINEA ATTIVA NP','ULL LINEA ATTIVA','ULL DATI LINEA ATTIVA NP','ULL DATI LINEA ATTIVA','SLU LINEA ATTIVA NP') THEN 1 ELSE 0 ENDx' --  FLAG LA (30) Lotto 6
                                        );


  AGGIUNTIVI_SELECT_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS ('ASSET.CODICEORDINETI', -- ID_ORD_CRMWS (1) -- OK
                                        q'xCASE ASSET.STATOASSET WHEN TO_NCHAR('x' || STATUS_INLAVORAZIONE || q'x') THEN 'S' ELSE 'N' ENDx', -- LOCK (2) -- OK
                                        q'xPKG_ESTRAZIONI.GET_CAUSALE(ORD.TIPOLOGIASOTTOLAV, ORD.TIPOLOGIASCENARIO, ASSET.IDOFFERTA)x', -- CAUSALE (3)  Lotto6 -- OK
                                        'PKG_ESTRAZIONI.CODIFICA_TIPO_ORDINE(ORD.TIPOLOGIALAVORAZIONE)', -- TIPO_ORDINE (4) -- OK
                                        'OFF.COD_OFFERTA_JPUB', -- TIPO_CONTR (5) -- OK
                                        'PKG_ESTRAZIONI.SET_DATE(ASSET.DES)', -- DATA_DES (6) -- OK
                                        'ASSET.IDRISORSA', -- ID_RIS (7) -- OK
                                        'ASSET.CODIFICAOLOAGCOM', -- CODE_GEST_REC (8) -- OK
                                        q'yCASE UPPER(PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'STRUTTURALINEA')) WHEN 'SIMPLEX' THEN 56  WHEN 'GNR' THEN 50 WHEN 'PBX' THEN 55 ELSE Null  ENDy', -- TIPO_FAMIGLIA
                                        q'xCASE WHEN OFF.OFFERTA in ('ULL LINEA ATTIVA NP','ULL DATI LINEA ATTIVA NP') THEN 50 WHEN OFF.OFFERTA='SLU LINEA ATTIVA NP' THEN DECODE(UPPER(PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET (ASSET.BDS_ID, 'FLAGDNDONOROLO')), 'Y', 52, 50) ELSE 51 ENDx', --  OPZ COMMERCIALE Lotto 6
                                        q'xPKG_ESTRAZIONI.TIPOLINEA(ORD.BDS_ID, OFF.COD_OFFERTA_JPUB, OFF.ID_FAMIG_OFFERTA)x', -- TIPO_LINEA (11)
                                        'PKG_ESTRAZIONI.SET_DATE(ASSET.DESPRIMOORDINE)', -- DATA_INIZIO_NOL (12)
                                        q'xCASE WHEN TO_CHAR(ASSET.STATOASSET) = x' || DBMS_ASSERT.ENQUOTE_LITERAL(STATUS_CESSATO) || ' THEN PKG_ESTRAZIONI.SET_DATE(ASSET.DES) ELSE NULL END', -- DATA_CESSAZIONE (13)
                                        q'xCASE PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'PERMUTAARMADIO') WHEN 'N' THEN '0' WHEN 'S' THEN '1' ELSE '0' ENDx', -- FLAG_PERMUTA (14)
                                        q'xPKG_ESTRAZIONI.FLAG_QUALIFICA(PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'BITRATE'))x', -- FLAG_QUALIFICA (15)
                                        'PKG_ESTRAZIONI.SET_DATE(RICH.DRO)', -- DATA_DRO (16)
                                        'AGGIUNTIVO.NUMEROTELEFONICO', -- NUMERO_AGGIUNTIVO per ULL,ULLD,SLU(17)   SM_5077
                                        q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'IDULLCO')x', -- CODE_IDULLCO (18)
                                        'PKG_ESTRAZIONI.SET_DATE(ORD.DAC)', -- DATA_PREVISTA_CHIUSURA (19)
                                        'ASSET.CODICEORDINEOLO', -- CODICE_ORDINE_OLO (20)
                                        'ORD.CODICEPROGETTO', -- CODICE_PROGETTO (21)
                                        'ASSET.CLLI', -- CODICE_CLLI(22)
                                        q'xCASE WHEN OFF.OFFERTA in ('ULL LINEA ATTIVA NP','ULL DATI LINEA ATTIVA NP','SLU LINEA ATTIVA NP') THEN 1 ELSE 0 ENDx', --  FLAG NP (23) Lotto 6
                                        q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'IDSLUCO')x', -- CODICE_ID_SLOOP(24)
                                        'PKG_ESTRAZIONI.DISTRETTO(ASSET.DISTRETTO)', -- CODE_DISTR (25)
                                        'TIP_RICH.STATO_RICH_NOW_GUI', -- STATO_ORDINE (26) --> SM_4022 STATO RICHIESTA NOW
                                        'PKG_ESTRAZIONI.CODIFICA_STATO_RICHIESTA(RICH.STATORICHIESTANOW)', -- ESITO_ACQUISIZIONE_BILLING (27)
                                        'AGREE.COD_CONTRATTO', -- CODE_CONTR (28)
                                        q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'ROUTINGNUMBER')x', -- ROUTING_NUMBER (29) Lotto6
                                        q'xCASE WHEN OFF.OFFERTA in ('ULL LINEA ATTIVA NP','ULL LINEA ATTIVA','ULL DATI LINEA ATTIVA NP','ULL DATI LINEA ATTIVA','SLU LINEA ATTIVA NP') THEN 1 ELSE 0 ENDx' --  FLAG LA (30) Lotto 6
                                        );

    -- Luca Abbate, Lotto5
    --  (RA, RAES)
    NP_SELECT_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS ('ASSET.CODICEORDINETI',
                                                          q'xCASE ASSET.STATOASSET WHEN TO_NCHAR('x' || STATUS_INLAVORAZIONE || q'x') THEN 'S' ELSE 'N' ENDx',
                                                          q'xPKG_ESTRAZIONI.GET_CAUSALE(ORD.TIPOLOGIASOTTOLAV, ORD.TIPOLOGIASCENARIO, ASSET.IDOFFERTA)x', -- CAUSALE (3) Lotto6,
                                                          'PKG_ESTRAZIONI.CODIFICA_TIPO_ORDINE(ORD.TIPOLOGIALAVORAZIONE)',
                                                          'OFF.COD_OFFERTA_JPUB', -- TIPO_CONTR (5) -- OK
                                                          'PKG_ESTRAZIONI.SET_DATE(ASSET.DES)',
                                                          -- 'numtelefonico.NUMEROPRINCIPALE',
                                                          'ASSET.IDRISORSA', -- SM_3949: al posto del valore di sopra (numtelefonico.NUMEROPRINCIPALE)
                                                          'ASSET.CODIFICAOLOAGCOM',
                                                          q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'OLORETAILER', 'NUMBERPORTABILITY')x', -- da S6
                                                          'Null',-- TIPO_FAMIGLIA Lotto 6
                                                          'ASSET.CODIFICAOLOAGCOMDONATING',
                                                          'ASSET.CODIFICAOLOAGCOMDONOR',
                                                          'PKG_ESTRAZIONI.SET_DATE(ASSET.DESPRIMOORDINE)',
                                                          q'xCASE WHEN TO_CHAR(ASSET.STATOASSET) = x' || DBMS_ASSERT.ENQUOTE_LITERAL(STATUS_CESSATO) || ' THEN PKG_ESTRAZIONI.SET_DATE(ASSET.DES) ELSE NULL END',
                                                          q'xCASE PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'PERMUTAARMADIO') WHEN 'N' THEN '0' WHEN 'S' THEN '1' ELSE '0' ENDx', -- FLAG_PERMUTA  Lotto 6
                                                          q'xNULLx',
                                                          'PKG_ESTRAZIONI.SET_DATE(RICH.DRO)',
                                                          -- 'CASE ASSETS.NUMEROTELEFONICO WHEN ASSET.NUMTELPRINCIPALE THEN NULL ELSE ASSETS.NUMEROTELEFONICO END', -- NUMERO_AGGIUNTIVO Lotto6
                                                          'CASE ASSETS.NUMTELPRINCIPALE WHEN NULL THEN ASSET.NUMEROTELEFONICO ELSE ASSETS.NUMEROTELEFONICO END',
                                                          q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'IDULLCO')x',
                                                          'PKG_ESTRAZIONI.SET_DATE(ORD.DAC)',
                                                          'ASSET.CODICEORDINEOLO',
                                                          'ORD.CODICEPROGETTO',
                                                          'ASSET.CLLI',
                                                          '1',-- Lotto 6
                                                          q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'IDSLUCO')x',
                                                          'PKG_ESTRAZIONI.DISTRETTO(ASSET.DISTRETTO)',
                                                          'TIP_RICH.STATO_RICH_NOW_GUI',-- SM_4022 STATO RICHIESTA NOW
                                                          'PKG_ESTRAZIONI.CODIFICA_STATO_RICHIESTA(RICH.STATORICHIESTANOW)',
                                                          'AGREE.COD_CONTRATTO',
                                                          q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'ROUTINGNUMBER')x' -- ROUTING_NUMBER  --Lotto 6
                                                          );
    --/ Luca Abbate, Lotto5

   --SM_9629
    --  (INCONTRA)
    INCONTRA_SELECT_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS (q'x'02'x', -- TIPO_RECORD
                                                              'T.RICHIESTA', -- ID_SO
                                                              'T.STATOASSET', -- STATO_SO
                                                              'PKG_ESTRAZIONI.DISTRETTO_INCONTRA(T.IDRISORSA)', -- PREFISSO
                                                              --'ASSET.NUMEROTELEFONICO', -- NUMERO
                                                              'PKG_UTILITY.TOGLI_PREFISSO(T.IDRISORSA, PKG_ESTRAZIONI.DISTRETTO_INCONTRA(T.IDRISORSA))' , -- NUMERO
                                                              q'xTO_CHAR(T.DRO, 'YYYYMMDD')x', -- DATA_EMISSIONE
                                                              q'xTO_CHAR(T.DES, 'YYYYMMDD')x', -- DATA_ESPLETAMENTO
                                                              q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(T.ASSET_BDS_ID, 'CODEDR')x', -- CODE_DR
                                                              q'xT.TIPOLOGIALAVORAZIONE||'-'||T.TIPOLG_SOTTO_LAVRZ_GUIx', -- TIPO_RICHIESTA sm_5000 MNP
                                                              q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(T.ASSET_BDS_ID, 'TIPOSERVIZIO')x', -- FAMIGLIA_SERVIZIO
                                                              q'xCASE T.NOME_OFFERTA_CATLG WHEN 'WLR' THEN CASE PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(T.ORD_BDS_ID, 'CODICEPIATTAFORMA') WHEN 'RES' THEN 'SBR' WHEN 'SBR' THEN 'SBR' WHEN 'BUS' THEN 'SBL' WHEN 'SBL' THEN 'SBL' ELSE NULL END ELSE 'NOW' ENDx', -- ORIGINE_SO
                                                            --RU_1469 (SERVIZIO; COD_OLO; CODFC_OLO_AGCOM)
                                                              --q'xDECODE(T.NOME_OFFERTA_CATLG, 'NP', 'NPG', T.NOME_OFFERTA_CATLG)x', -- SERVIZIO
                                                              --'T.COD_OLO', --'ASSET.CODICEORDINEOLO', -- COD_OLO --SM_4034
                                                              --'T.CODIFICAOLOAGCOM', -- CODFC_OLO_AGCOM
                                                            --RU_1469 (SERVIZIO; COD_OLO; CODFC_OLO_AGCOM)
                                                                q'xDECODE(T.NOME_OFFERTA_CATLG, 'NP', 'OTH', 'WLR','OTH','VULL','SIS')x', -- SERVIZIO
                                                                q'x'XXX'x', -- COD_OLO
                                                                q'x'XXX'x', -- CODFC_OLO_AGCOM
                                                              'NULL');

--INIZIO RU_975
CPS_INCONTRA_SELECT_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS (q'x'02'x', -- TIPO_RECORD
                                                           'PKG_ESTRAZIONI.DISTRETTO_INCONTRA(ASSET.IDRISORSA)', -- PREFISSO
                                                           'PKG_UTILITY.TOGLI_PREFISSO(ASSET.IDRISORSA, PKG_ESTRAZIONI.DISTRETTO_INCONTRA(ASSET.IDRISORSA))' , -- NUMERO
                                                        --RU_1469 (SERVIZIO)
                                                           -- q'xDECODE(OFF.NOME_OFFERTA_CATLG, 'NP', 'NPG', OFF.NOME_OFFERTA_CATLG)x', -- SERVIZIO
                                                           q'xDECODE(OFF.NOME_OFFERTA_CATLG, 'CPS', 'BRT')x', -- SERVIZIO
                                                            --q'xORD.TIPOLOGIALAVORAZIONE||'-'||TIP_S_LAV.TIPOLG_SOTTO_LAVRZ_GUIx', -- LAVORAZIONE
                                                            q'xDECODE(ORD.TIPOLOGIALAVORAZIONE,'MIGRAZIONE','CESSAZIONE',ORD.TIPOLOGIALAVORAZIONE)x', -- LAVORAZIONE
                                                            q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'OPZIONETRAFFICO')x', -- OPZIONE_TRAFFICO
                                                            'ORD.CODICEORDINEOLO', --CODICE ORDINE OLO
                                                             q'xTO_CHAR(ASSET.DES, 'YYYYMMDD')x', -- DATA_ESPLETAMENTO
                                                             'NULL');

FRMSFRAUD_INCONTRA_SELECT_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS (q'x'02'x', -- TIPO_RECORD
                                                           'PKG_ESTRAZIONI.DISTRETTO_INCONTRA(ASSET.IDRISORSA)', -- PREFISSO
                                                            'PKG_UTILITY.TOGLI_PREFISSO(ASSET.IDRISORSA, PKG_ESTRAZIONI.DISTRETTO_INCONTRA(ASSET.IDRISORSA))' , -- NUMERO
                                                            q'xDECODE(OFF.NOME_OFFERTA_CATLG, 'NP', 'NPG', OFF.NOME_OFFERTA_CATLG)x', -- OFFERTA
                                                           --q'xORD.TIPOLOGIALAVORAZIONE||'-'||TIP_S_LAV.TIPOLG_SOTTO_LAVRZ_GUIx', -- LAVORAZIONE
                                                            q'xDECODE(ORD.TIPOLOGIALAVORAZIONE,'MIGRAZIONE','CESSAZIONE',ORD.TIPOLOGIALAVORAZIONE)x', -- LAVORAZIONE
                                                            q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'OPZIONETRAFFICO')x', -- OPZIONE_TRAFFICO
                                                            'ORD.CODICEORDINEOLO', --CODICE ORDINE OLO
                                                             q'xTO_CHAR(ASSET.DES, 'YYYYMMDD')x', -- DATA_ESPLETAMENTO
                                                             'NULL');
--FINE RU_975



    -- Valido per WLR e STS_WLR (vs RA, RAES) -- valorizzato per WLR (eccetto per il campo PROD_NAME)
    WLR_SELECT_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS ('ASSET.CODICEORDINETI', -- ID_ORD_CRMWS (1) (OK)
                                            q'xCASE ASSET.STATOASSET WHEN TO_NCHAR('x' || STATUS_INLAVORAZIONE || q'x') THEN 'S' ELSE 'N' ENDx', -- LOCK (2) (OK)
                                            q'xPKG_ESTRAZIONI.GET_CAUSALE(ORD.TIPOLOGIASOTTOLAV, ORD.TIPOLOGIASCENARIO, ASSET.IDOFFERTA)x', -- CAUSALE (3) Lotto6
                                            'PKG_ESTRAZIONI.CODIFICA_TIPO_ORDINE(ORD.TIPOLOGIALAVORAZIONE)', -- TIPO_ORDINE (4) (OK)
                                            'OFF.COD_OFFERTA_JPUB', -- TIPO_CONTR (5) (41 per WLR E STS_WLR) (OK)
                                            'PKG_ESTRAZIONI.SET_DATE(ASSET.DES)', -- DATA_DES (6) (OK)
                                            q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD.BDS_ID, 'CODEPRESTAGG')x', -- CODE_PREST_AGG (7) Lotto 6 RP
                                            'ASSET.IDRISORSA', -- ID_RIS (8) (OK)
                                            'ASSET.CODIFICAOLOAGCOM', -- CODE_GEST_REC (9) (OK)
                                            q'xCASE WHEN PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'ACCESSONUMERICO') in ('0', Null) THEN CASE PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'STRUTTURALINEA') WHEN 'GNR' THEN CASE WHEN PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'SELEZIONEPASSANTE') in ('0', Null) THEN '50' WHEN PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'SELEZIONEPASSANTE') = '1' THEN '51' END ELSE Null END WHEN PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'ACCESSONUMERICO')='1' THEN CASE PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'STRUTTURALINEA') WHEN 'GNR' THEN CASE WHEN PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'SELEZIONEPASSANTE') in ('0', Null) THEN '52' WHEN PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'SELEZIONEPASSANTE') = '1' THEN '53' END ELSE Null END ENDx',
                                          --  q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD.BDS_ID, 'TIPOLINEA')x', -- TIPO_FAMIGLIA (10)
                                       --INIZIO Task_XXX: Commento Tipo Linea per Nuova Logica
                                           -- q'xCASE WHEN PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'TIPOLINEA','ACCESSOWLR')='POTS' THEN 55 WHEN PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'TIPOLINEA','ACCESSOWLR')='ISDN' THEN CASE WHEN PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'STRUTTURALINEA','ACCESSOWLR')in('BRA Mono','BRA Multi') THEN 53 ELSE Null END ENDx', -- TIPO_LINEA (11) Lotto 6 RP (NULL per STS_WLR)
                                           --Commentata con SM_9817 q'xCASE WHEN PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'BANDASERVIZIO','ACCESSOWLR')='ISDN PRA'  THEN  CASE WHEN PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'TIPOLINEA','ACCESSOWLR')='ISDN' AND  PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'STRUTTURALINEA','ACCESSOWLR')='PBX' THEN 54  WHEN  PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'TIPOLINEA','ACCESSOWLR')='POTS' AND PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'STRUTTURALINEA','ACCESSOWLR')='SIMPLEX' THEN 54 ELSE NULL END WHEN PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'TIPOLINEA','ACCESSOWLR')='POTS' THEN 55 WHEN PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'TIPOLINEA','ACCESSOWLR')='ISDN' AND PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'STRUTTURALINEA','ACCESSOWLR') in ('BRA Mono','BRA Multi') THEN 53 ELSE NULL ENDx',  --TIPO_LINEA
                                            q'xCASE WHEN PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'TIPOLINEA','ACCESSOWLR')='POTS' THEN  CASE WHEN PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'STRUTTURALINEA','ACCESSOWLR')='SIMPLEX' AND PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'BANDASERVIZIO','ACCESSOWLR')='ISDN PRA'  THEN 54 ELSE 55 END WHEN  PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'TIPOLINEA','ACCESSOWLR')='ISDN' THEN CASE WHEN  PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'STRUTTURALINEA','ACCESSOWLR')in('BRA Mono','BRA Multi') THEN 53 WHEN  PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'STRUTTURALINEA','ACCESSOWLR')='PBX' AND PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'BANDASERVIZIO','ACCESSOWLR')='ISDN PRA' THEN 54 WHEN  PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'STRUTTURALINEA','ACCESSOWLR')='GNR'  AND PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'QUANTITACANALI','ACCESSOWLR') >=15  THEN 54 ELSE NULL END  ELSE NULL ENDx',--TIPO_LINEA --SM_9817
                                       --FINE Task_XXX: Commento Tipo Linea per Nuova Logica
                                            q'xCASE nvl(PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'CODICEFATTURAZIONE'),'-') WHEN '-' THEN NULL WHEN 'A' THEN 50 WHEN 'B' THEN 50 WHEN 'C' THEN 50 WHEN 'U' THEN 50  ELSE 51 ENDx',--  SUB_TIPO_LINEA_RESIDENZIALE SM_5675
                                            q'xCASE nvl(PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'CODICEFATTURAZIONE'),'-') WHEN '-' THEN NULL WHEN 'F' THEN 53 WHEN 'C' THEN 51 WHEN 'E' THEN 51 WHEN 'H' THEN 51 WHEN 'M' THEN 51 ELSE 52 ENDx',--  SUB_TIPO_LINEA_DIREZIONE SM_5675
                                            --q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'CODICEPIATTAFORMA', 'ACCESSOWLR')x', --SUB_TIPO_LINEA_RESIDENZIALE (12) (NULL per STS_WLR) Lotto 6 RP
                                           -- q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'DIREZIONALITA', 'ACCESSOWLR')x', --SUB_TIPO_LINEA_DIREZIONE (13)  (NULL per STS_WLR) Lotto 6 RP
                                            'PKG_ESTRAZIONI.SET_DATE(ASSET.DESPRIMOORDINE)', -- DATA_INIZIO_NOL (14)
                                            q'xCASE WHEN TO_CHAR(ASSET.STATOASSET) = x' || DBMS_ASSERT.ENQUOTE_LITERAL(STATUS_CESSATO) || ' THEN PKG_ESTRAZIONI.SET_DATE(ASSET.DES) ELSE NULL END', -- DATA_CESSAZIONE (15)
                                            q'xCASE PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'PERMUTAARMADIO') WHEN 'N' THEN '0' WHEN 'S' THEN '1' ELSE '0' ENDx', --  FLAG_PERMUTA (16) (NULL per STS_WLR)
                                            q'xNULLx', -- FLAG_QUALIFICA (17) (NULL per STS_WLR)
                                            'PKG_ESTRAZIONI.SET_DATE(RICH.DRO)', -- DATA_DRO (18)
                                            'ASSET_NUMAGG.NUMEROAGGIUNTIVO', -- NUMERO_AGGIUNTIVO (NULL per STS_WLR)
                                            q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'IDULLCO')x', -- CODE_IDULLCO (20)  (NULL per STS_WLR)
                                            'PKG_ESTRAZIONI.SET_DATE(ORD.DAC)', -- DATA_PREVISTA_CHIUSURA (21) (NULL per STS_WLR)
                                            'ASSET.CODICEORDINEOLO', -- CODICE_ORDINE_OLO (22)
                                            'ORD.CODICEPROGETTO', -- CODICE_PROGETTO (23)
                                            'ASSET.CLLI', -- CODICE_CLLI (24) (NULL per STS_WLR)
                                            '0', -- FLAG_NP (25) (NULL per STS_WLR)
                                            q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'IDSLUCO')x', -- CODICE_ID_SLOOP (26) (NULL per STS_WLR)
                                            'PKG_ESTRAZIONI.DISTRETTO(ASSET.DISTRETTO)', -- CODE_DISTR (27) (NULL per STS_WLR)
                                            'TIP_RICH.STATO_RICH_NOW_GUI', -- STATO_ORDINE (26) --> SM_4022 STATO RICHIESTA NOW
                                            'PKG_ESTRAZIONI.CODIFICA_STATO_RICHIESTA(RICH.STATORICHIESTANOW)', -- ESITO_ACQUISIZIONE_BILLING (29)
                                            'AGREE.COD_CONTRATTO', -- CODE_CONTR (30)
                                            'NULL', -- ROUTING_NUMBER, (31) (NULL per STS_WLR)
                                            'STS_WLR.PROD_NAME', -- default per STS_WLR -- IF WLR THEN NULL; IF STS THEN NOT NULL -- PROD_NAME (32)
                                            'ASSET.OFFERTA', --RU_1143    (33)
                                            'ASSET.IDRISORSACORRELATO', --RU_1143 --ID_RISORSA_CORRELATO (34)
                                            q'x'FONIA'x', --RU_1143 --TIPOLOGIA_ACCESSO   (35)
                                            'ASSET.NUMEROTELEFONICO',--RU_1143 --NUMERO_TELEFONICO (36)
                                            'ASSET.OPERATORERETE' --RU_1143 --OPERATORE_RETE (37)

                                            );

    RAC_SELECT_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS (q'x'2'x', -- TIPO_RECORD
                                                          'ORD.IDRISORSA', -- NUMERO_LINEA
                                                          q'xCASE WHEN id_offerta IN (20, 27, 28, 29) THEN 'NP' WHEN id_offerta=26 THEN 'VULL' WHEN id_offerta=25 THEN 'WLR' ELSE null endx', -- TIPO_SERVIZIO
                                                          'ORD.CODIFICAOLONOW',-- CODICE_OLO SM_3696
                                                          'ORD.CODIFICAOLOAGCOM', --SIGLA_OLO
                                                          'OLO.RAGIONE_SOCIALE', -- DESCRIZIONE_OLO
                                                          'PKG_ESTRAZIONI.SET_DATE(ORD.DES,''YYYY-MM-DD'')' -- DATA_ESPLETAMENTO
                                            );

    --/ Luca Abbate, Lotto6


    BSGBE_SELECT_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS ('ASSET.IDRISORSA',
                                                            'ASSET.CODIFICAOLOAGCOM',
                                                            q'xPKG_ESTRAZIONI.GET_PROF_COMM_BS(ASSET.IDOFFERTA, ASSET.BDS_ID, 'UP')x',
                                                            q'xPKG_ESTRAZIONI.GET_PROF_COMM_BS(ASSET.IDOFFERTA, ASSET.BDS_ID, 'DOWN')x',
                                                            q'xPKG_ESTRAZIONI.TIPOLINEA(ORD.BDS_ID, OFF.COD_OFFERTA_JPUB, OFF.ID_FAMIG_OFFERTA)x',
                                                            'OFF.IDTPLG_PAGAMENTO_ACCS', --OK MOD_FAT
                                                            'OFF.COD_OFFERTA_JPUB', -- SM_392 'TPL_CON.COD_CONTRATTO_JPUB',
                                                            'AGREE.COD_CONTRATTO',
                                                             q'xCASE OFF.MODO_TRASFERIMENTO WHEN 'ASIMMETRICO' THEN CASE OFF.COD_OFFERTA_JPUB WHEN '44' THEN 10 WHEN '50' THEN 15 WHEN '51' THEN 16 ELSE Null END WHEN 'SIMMETRICO' THEN CASE OFF.COD_OFFERTA_JPUB WHEN '44' THEN 14 ELSE Null END ELSE Null ENDx', -- TIPO FAMIGLIA S7 BTS GBE SIMMETRICI
                                                           -- q'xPKG_ESTRAZIONI.TIPO_FAMIGLIA(OFF.ID_OFFERTA)x',
                                                            'PKG_ESTRAZIONI.SET_DATE(RICH.DRO)',
                                                            'PKG_ESTRAZIONI.SET_DATE(ASSET.DES)',
                                                            'PKG_ESTRAZIONI.SET_DATE(ASSET.DESPRIMOORDINE)',
                                                            q'xCASE WHEN TO_CHAR(ASSET.STATOASSET) = x' || DBMS_ASSERT.ENQUOTE_LITERAL(STATUS_CESSATO) || ' THEN PKG_ESTRAZIONI.SET_DATE(ASSET.DES) ELSE NULL END',
                                                            'PKG_ESTRAZIONI.CODIFICA_TIPO_ORDINE(ORD.TIPOLOGIALAVORAZIONE,ORD.TIPOLOGIASOTTOLAV)',--  TIPO_ORDINE SM_2746
                                                            q'xCASE PKG_ESTRAZIONI.VLAN_VALUE(ASSET.BDS_ID, 'FLAG_ENCAPSULATION') WHEN 'Y' THEN 1 WHEN 'N' THEN 0 ELSE Null ENDx', -- TIPO_VLAN SM_2746
                                                            q'xCASE PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'USERVLAN1TAGGING') WHEN 'Untagged' THEN 1 WHEN 'Tagged' THEN 0 ELSE Null ENDx', --SM_4017
                                                            q'xPKG_ESTRAZIONI.VLAN_VALUE(ASSET.BDS_ID, 'COD_KIT')x', -- KIT_CONS SM_2746
                                                             q'xCASE WHEN PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'CODICE', 'MODEM') IS NOT NULL THEN 1 ELSE 0 ENDx',  -- FLAG MODEM SM_2746
                                                            q'xPKG_ESTRAZIONI.VLAN_VALUE(ASSET.BDS_ID, 'COD_AREA_RACCOLTA')x',
                                                            q'xPKG_ESTRAZIONI.VLAN_VALUE(ASSET.BDS_ID, 'COD_MACRO_AREA')x',
                                                            'ASSET.CODICEORDINETI',
                                                            q'xCASE ASSET.STATOASSET WHEN TO_NCHAR('x' || STATUS_INLAVORAZIONE || q'x') THEN 'S' ELSE 'N' ENDx',
                                                            q'xCASE OFF.MODO_TRASFERIMENTO WHEN 'SIMMETRICO' THEN PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'TECNOLOGIADELIVERY') ELSE 'A' ENDx', --  TECNOLOGIA S7
                                                            'ASSET.CLLI',
                                                            'ORD.TIPOLOGIASOTTOLAV',
                                                             q'xNVL(PKG_ESTRAZIONI.SET_DATE(ORD.DACRIMODULATA), PKG_ESTRAZIONI.SET_DATE(ORD.DAC))x', -- DATA PREVISTA CHIUSURA SM_2746
                                                            'ASSET.CODICEORDINEOLO',
                                                            q'xCASE PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'MODULAZIONE') WHEN '0' THEN '1' WHEN '1' THEN '2' ELSE Null ENDx', -- (25) TIPO_MODULAZIONE SM_2746
                                                            q'xCASE WHEN PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'CODICEPRODOTTOSPLITTER','SPLITTER')  IS NOT NULL THEN 1 ELSE 0 ENDx', --FLAG SPLITTER SM_2746
                                                            q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'TIPOTRASPORTO')x', -- SM_642 q'xPKG_ESTRAZIONI.VLAN_VALUE(ASSET.BDS_ID, 'TIPO_TRASPORTO')x',
                                                            'ASSET.NUMEROTELEFONICO',
                                                            q'xCASE PKG_ESTRAZIONI.VLAN_VALUE(ASSET.BDS_ID, 'TIPO_TRASPORTO') WHEN 'L1' THEN 1 WHEN 'L2' THEN 1 WHEN 'LD' THEN 1 WHEN 'Long Distance' THEN 1 ELSE Null ENDx', -- MOD_FATT_TRASP SM_2746
                                                             q'xCASE PKG_ESTRAZIONI.GET_PROF_COMM_BS(ASSET.IDOFFERTA, ASSET.BDS_ID, 'ACCESSO') WHEN 'Fixed' THEN 1 WHEN 'Adaptive' THEN 2 ELSE Null ENDx', -- MOD_ACCESSO SM_2746
                                                            q'xPKG_ESTRAZIONI.GET_PROF_COMM_BS(ASSET.IDOFFERTA, ASSET.BDS_ID, 'DOWN')x',
                                                            q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'PROFILOTECNICOLINEA')x',
                                                              'TIP_RICH.STATO_RICH_NOW_GUI', -- STATO_ORDINE (26) --> SM_4022 STATO RICHIESTA NOW
                                                            'PKG_ESTRAZIONI.CODIFICA_STATO_RICHIESTA(RICH.STATORICHIESTANOW)',
                                                            'ASSET.IDRISORSA');

  BSATM_SELECT_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS ('ASSET.IDRISORSA',
                                                            'ASSET.CODIFICAOLOAGCOM',
                                                            q'xPKG_ESTRAZIONI.GET_PROF_COMM_BS(ASSET.IDOFFERTA, ASSET.BDS_ID, 'UP')x',
                                                            q'xPKG_ESTRAZIONI.GET_PROF_COMM_BS(ASSET.IDOFFERTA, ASSET.BDS_ID, 'DOWN')x',
                                                            q'xPKG_ESTRAZIONI.TIPOLINEA(ORD.BDS_ID, OFF.COD_OFFERTA_JPUB, OFF.ID_FAMIG_OFFERTA)x',
                                                            'OFF.IDTPLG_PAGAMENTO_ACCS', -- OK MOD_FAT (1, 2, 3)
                                                            'OFF.COD_OFFERTA_JPUB', -- SM_392 'TPL_CON.COD_CONTRATTO_JPUB',
                                                            'AGREE.COD_CONTRATTO',
                                                            q'xPKG_ESTRAZIONI.TIPO_FAMIGLIA(OFF.ID_OFFERTA)x', -- TIPO_FAMIGLIA S7 SIMMETRICI
                                                            'PKG_ESTRAZIONI.SET_DATE(RICH.DRO)',
                                                            'PKG_ESTRAZIONI.SET_DATE(ASSET.DES)',
                                                            'PKG_ESTRAZIONI.SET_DATE(ASSET.DESPRIMOORDINE)',
                                                            q'xCASE WHEN TO_CHAR(ASSET.STATOASSET) = x' || DBMS_ASSERT.ENQUOTE_LITERAL(STATUS_CESSATO) || ' THEN PKG_ESTRAZIONI.SET_DATE(ASSET.DES) ELSE NULL END', -- DATA_CESSAZIONE
                                                            'PKG_ESTRAZIONI.CODIFICA_TIPO_ORDINE(ORD.TIPOLOGIALAVORAZIONE,ORD.TIPOLOGIASOTTOLAV)',-- TIPO_ORDINE SM_2746
                                                            q'xCASE WHEN PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'CODICE', 'SPLITTER') IS NOT NULL THEN 1 ELSE 0 ENDx', --FLAG SPLITTER SM_2746
                                                            q'xCASE WHEN PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'CODICE', 'MODEM') IS NOT NULL THEN 1 ELSE 0 ENDx',  -- FLAG MODEM SM_2746
                                                            q'xPKG_ESTRAZIONI.CODE_AREA_RACC(ASSET.BDS_ID, 'COD_AREA_RACCOLTA')x', -- CODE_AREA SM_2746
                                                            'ASSET.CODICEORDINETI',
                                                            q'xCASE ASSET.STATOASSET WHEN TO_NCHAR('x' || STATUS_INLAVORAZIONE || q'x') THEN 'S' ELSE 'N' ENDx',
                                                            q'xCASE OFF.MODO_TRASFERIMENTO WHEN 'SIMMETRICO' THEN PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'TECNOLOGIADELIVERY') ELSE 'A' ENDx', --  TECNOLOGIA S7
                                                            'ASSET.CLLI',
                                                            'TIP_S_LAV.TIPOLG_SOTTO_LAVRZ_GUI', -- CAUSALE DI LAVORAZIONE SM_2746
                                                            q'xNVL(PKG_ESTRAZIONI.SET_DATE(ORD.DACRIMODULATA), PKG_ESTRAZIONI.SET_DATE(ORD.DAC))x', -- DATA PREVISTA CHIUSURA SM_2746
                                                            'ASSET.CODICEORDINEOLO',
                                                              'TIP_RICH.STATO_RICH_NOW_GUI', -- STATO_ORDINE (26) --> SM_4022 STATO RICHIESTA NOW
                                                            'PKG_ESTRAZIONI.CODIFICA_STATO_RICHIESTA(RICH.STATORICHIESTANOW)');

  BSEASYIP_SELECT_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS ('ASSET.IDRISORSA', -- (1)ID_RISORSA
                                                            'ASSET.CODIFICAOLOAGCOM', -- (2) OLO
                                                            'OFF.COD_OFFERTA_JPUB', -- (3) TIPO_CONTR   SM_392 'TPL_CON.COD_CONTRATTO_JPUB',
                                                            'AGREE.COD_CONTRATTO',-- (4) CODE_CONTR
                                                            q'xPKG_ESTRAZIONI.TIPOLINEA(ORD.BDS_ID, OFF.COD_OFFERTA_JPUB, OFF.ID_FAMIG_OFFERTA)x',-- (5) TIPO_LINEA
                                                            '2', --(6) TIPO FAMIGLIA Lotto 6
                                                            --q'xPKG_ESTRAZIONI.TIPO_FAMIGLIA(OFF.ID_OFFERTA)x',
                                                            'OFF.IDTPLG_PAGAMENTO_ACCS', -- (7) MOD_FAT
                                                            q'xCASE WHEN OFF.IDTPLG_PAGAMENTO_ACCS = 2 THEN '1' ELSE NULL ENDx', -- (8) TIPO_MOD_FAT
                                                            -- q'xCASE PKG_ESTRAZIONI.VP_VALUE(ASSET.BDS_ID, 'TIPO_TRASPORTO') WHEN 'Presente' THEN 1  ELSE 0 ENDx', -- (9) TIPO_TRASP SM_2746 --SM_4066
                                                            q'xCASE NVL(PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'TRASPORTO'),'ASSETNTE') WHEN 'PRESENTE' THEN 1  ELSE 0 ENDx', --TIPO_TRASP
                                                            --q'xCASE PKG_ESTRAZIONI.VP_VALUE(ASSET.BDS_ID, 'MODALITA_FATTURAZIONE') WHEN 'Flat' THEN 1 WHEN 'Hight' THEN 2 WHEN 'Light' THEN 2  ELSE Null ENDx', -- (10)MOD_FAT_TRASP SM_2746
                                                            q'xCASE PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'TRASPORTO') WHEN 'PRESENTE' THEN 3  ELSE NULL ENDx',-- (10)MOD_FAT_TRASP
                                                            'PKG_ESTRAZIONI.SET_DATE(RICH.DRO)',-- (11) DATA_DRO
                                                            'PKG_ESTRAZIONI.SET_DATE(ASSET.DES)',--(12) DATA_DES
                                                            'PKG_ESTRAZIONI.SET_DATE(ASSET.DESPRIMOORDINE)',-- (13) DATA_DEC
                                                            --'PKG_ESTRAZIONI.SET_DATE(ASSET.DES)',
                                                            q'xCASE WHEN TO_CHAR(ASSET.STATOASSET) = x' || DBMS_ASSERT.ENQUOTE_LITERAL(STATUS_CESSATO) || ' THEN PKG_ESTRAZIONI.SET_DATE(ASSET.DES) ELSE NULL END', -- (14) DATA_CESSAZIONE
                                                            'PKG_ESTRAZIONI.CODIFICA_TIPO_ORDINE(ORD.TIPOLOGIALAVORAZIONE,ORD.TIPOLOGIASOTTOLAV)',-- (15) TIPO_ORDINE SM_2746
                                                            --q'xPKG_ESTRAZIONI.CODE_AREA_RACC(ASSET.BDS_ID, 'COD_AREA_RACCOLTA')x', --(16) CODE_AREA SM_2746
                                                            'PKG_ESTRAZIONI.GET_CODE_AREA(ASSET.DISTRETTO)', --CODE_AREA
                                                            q'yCASE PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'MODALITACONSEGNA') WHEN '0' THEN '8'  WHEN '1' THEN '10' WHEN '2' THEN '5' WHEN '3' THEN '6' WHEN '4' THEN '7' WHEN '5' THEN '2' WHEN '6' THEN '1' WHEN '7' THEN '3' WHEN '8' THEN '4' ELSE Null  ENDy', -- (17) SUBNET_EASYIP  SM_2746
                                                             q'xCASE WHEN PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'CODICE', 'SPLITTER') IS NOT NULL THEN 1 ELSE 0 ENDx', --(18) FLAG SPLITTER SM_2746
                                                            'ASSET.CODICEORDINETI',-- (19) CODICE ORDINE TI
                                                            q'xCASE ASSET.STATOASSET WHEN TO_NCHAR('x' || STATUS_INLAVORAZIONE || q'x') THEN 'S' ELSE 'N' ENDx',--(20) LOCK
                                                            --'CAUS.DESCR_CAUS_NOW_DG',--(21)CAUSALE DI LAVORAZIONE
                                                            'ULTIMA_LAV.tipologialavorazione',
                                                             q'xNVL(PKG_ESTRAZIONI.SET_DATE(ORD.DACRIMODULATA), PKG_ESTRAZIONI.SET_DATE(ORD.DAC))x', -- (22) DATA PREVISTA CHIUSURA SM_2746
                                                            'ASSET.CODICEORDINEOLO',--(23)CODICE_ORDINE_OLO
                                                            --q'xPKG_ESTRAZIONI.OPZIONE_COMMERCIALE(ASSET.BDS_ID, OFF.COD_OFFERTA_JPUB)x',--(24) OPZ_COMM  -- SM_392 'TPL_CON.COD_CONTRATTO_JPUB',
                                                            q'xCASE OFF.COD_OFFERTA_JPUB WHEN '48' THEN '5' ELSE CASE NVL(PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'TRASPORTO'),'ASSENTE') WHEN 'PRESENTE' THEN DECODE(OFF.COD_OFFERTA_JPUB,'47','4') WHEN 'ASSENTE' THEN DECODE(OFF.COD_OFFERTA_JPUB,'47','3') END ENDx', --SM_5328
                                                            q'xCASE PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'MODULAZIONE') WHEN '0' THEN '1' WHEN '1' THEN '2' ELSE Null ENDx', -- (25) TIPO_MODULAZIONE SM_2746
                                                            q'xCASE PKG_ESTRAZIONI.GET_PROF_COMM_BS(ASSET.IDOFFERTA, ASSET.BDS_ID, 'ACCESSO') WHEN 'Fixed' THEN 1  ELSE Null ENDx', -- (25) MOD_ACCESSO SM_2746 -- SM_3936
                                                            q'xPKG_ESTRAZIONI.DENORMALIZZA_RISORSA(ASSET.NUMEROFITTIZIO)x',-- (27) UTENZA DI RIFERIMENTO
                                                            'ASSET.CLLI',-- (28)CODE_CLLI
                                                            q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'PROFILOTECNICOLINEA')x',-- (29)PROFILO ACCESSO
                                                            q'xPKG_ESTRAZIONI.GET_PROF_COMM_BS(ASSET.IDOFFERTA, ASSET.BDS_ID, 'UP')x',--(30) PCR_UP
                                                            q'xPKG_ESTRAZIONI.GET_PROF_COMM_BS(ASSET.IDOFFERTA, ASSET.BDS_ID, 'DOWN')x',--- (31) PCR_DOWN
                                                             'TIP_RICH.STATO_RICH_NOW_GUI', -- STATO_ORDINE (32) --> SM_4022 STATO RICHIESTA NOW
                                                            'PKG_ESTRAZIONI.CODIFICA_STATO_RICHIESTA(RICH.STATORICHIESTANOW)');---(33) ESITO_ACQUISIZIONE_BILLING

    ORDINI_NOW_RI_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS ('ORD.IDRISORSA',
                                                             'RICH.LAVORAZIONE',
                                                             'ORD.TIPOLOGIASOTTOLAV',
                                                             'PKG_ESTRAZIONI.SET_DATE(ORD.DATAINVIOORDINEADELIVERY)',
                                                             'TIP_RICH.STATO_RICH_NOW_GUI', -- STATO_ORDINE (26) --> SM_4022 STATO RICHIESTA NOW
                                                             'ORD.CODIFICAOLOAGCOM',
                                                             'ORD.CODICEORDINEOLO',
                                                             'ORD.IDRICHIESTAOLO',
                                                             'OFF.OFFERTA',
                                                             'TIP_RICH.STATO_RICH_NOW_GUI', -- STATO_SOI Lotto 6 -- 10
                                                             'TIP_RICH_OLO.STATO_RICH_OLO_GUI', -- X_OLO_STATUS Lotto 6
                                                             'NP_NUMAGG.NUMEROAGGIUNTIVO',
                                                             'ORD.CODICEPROGETTO',
                                                             'PKG_ESTRAZIONI.SET_DATE(ORD.CREATED)',
                                                             'PKG_ESTRAZIONI.SET_DATE(ORD.CREATED)',
                                                             'CASE TO_CHAR(ORD.TIPOLOGIALAVORAZIONE) WHEN '|| ORDINE_CESSAZIONE || ' THEN PKG_ESTRAZIONI.SET_DATE(RICH.DRO) ELSE NULL END',
                                                             'PKG_ESTRAZIONI.SET_DATE(ORD.CREATED)',
                                                             'CAUS.DESCR_CAUS_NOW_DG',
                                                             'ORD.CODICEDELIVERY',
                                                             'AGREE.FLAG_NPD', -- 20
                                                             'PKG_ESTRAZIONI.PROCESSED_FLAG(RICH.STATORICHIESTANOW)',
                                                             q'xCASE WHEN NVL(ORD.IDRISORSANOW,'-') <> NVL(ORD.IDRISORSA,'-') THEN ORD.IDRISORSANOW ENDx',
                                                             'ORD.IDRICHIESTAOLO',
                                                             q'xPKG_ESTRAZIONI.TIPOLINEA(ORD.BDS_ID, OFF.COD_OFFERTA_JPUB, OFF.ID_FAMIG_OFFERTA)x', -- TIPO_LINEA
                                                             q'yPKG_ESTRAZIONI.GET_TIPO_FAMIGLIA(ORD.BDS_ID, OFF.ID_OFFERTA)y', -- TIPO_FAMIGLIA
                                                             'OFF.COD_OFFERTA_JPUB',
                                                             'AGREE.COD_CONTRATTO',
                                                             q'xPKG_ESTRAZIONI.OPZ_COMM_ORD(ORD.BDS_ID, OFF.COD_OFFERTA_JPUB, OFF.ID_FAMIG_OFFERTA,OFF.OFFERTA)x', -- OPZ_COMM
                                                             q'xDECODE(PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD.BDS_ID, 'PERMUTAARMADIO'), 'S', '1', 'N', '0', '0')x', -- FLAG_PERMUTA -- S7
                                                             q'xPKG_ESTRAZIONI.CODIFICA_CODICE_FATT(ORD.BDS_ID,'DIR')x', -- SUB_TIPO_LINEA_DIREZIONE  Lotto S6 -- 30
                                                             q'xPKG_ESTRAZIONI.GET_TIP_PAG_ACCS(OFF.IDTPLG_PAGAMENTO_ACCS,'MOD_FAT')x', -- MOD_FAT Lotto S6
                                                             q'xPKG_ESTRAZIONI.GET_TIP_PAG_ACCS(OFF.IDTPLG_PAGAMENTO_ACCS,'TIPO_MOD_FAT')x', -- TIPO_MOD_FAT Lotto S6
                                                             q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD.BDS_ID, 'PCRUP')x', -- VALO_PCR_UP_ACC
                                                             q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD.BDS_ID, 'PCRDOWN')x', -- VALO_PCR_DOWN_ACC
                                                             q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD.BDS_ID, 'PCRUP')x', -- VALO_PCR_UP_VC
                                                             q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD.BDS_ID, 'PCRDOWN')x', -- VALO_PCR_DOWN_VC
                                                             q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD.BDS_ID, 'MCRUP')x', -- VALO_MCR_UP_VC
                                                             q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD.BDS_ID, 'MCRDOWN')x', -- VALO_MCR_DOWN_VC
                                                             q'xPKG_ESTRAZIONI.TECNOLOGIA_TIPO_PROT(ORD.BDS_ID, OFF.MODO_TRASFERIMENTO, OFF.ID_OFFERTA)x', --  TECNOLOGIA_TIPO_PROT
                                                             --q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD.BDS_ID, 'COS')x', -- TIPO_COS_CLASSE_SERV -- 40
                                                             q'xPKG_ESTRAZIONI.VLAN_VALUE_ORD(ORD.BDS_ID, 'TIPO_COS_NO_GBE')x', -- TIPO_COS_CLASSE_SERV -- 40
                                                             q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD.BDS_ID, 'TIPOBANDACONSEGNA')x', -- TIPO_BANDA
                                                             q'xCASE OFF.ID_FAMIG_OFFERTA WHEN 4 THEN 1 ELSE CASE PKG_ESTRAZIONI.VLAN_VALUE_ORD(ORD.BDS_ID, 'TIPO_BANDA') WHEN 'MONOCOS' THEN 0 WHEN 'MULTICOS' THEN 1 ELSE 0 END ENDx', -- VLAN_QUALITA  --S7
                                                             'OFF.COD_OFFERTA_JPUB', -- TIPO_CONTR
                                                             q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD.BDS_ID, 'IDRISORSA', 'CONSISTENZADATI')x', -- ID_RIS_OLD Lotto S6
                                                             q'xPKG_ESTRAZIONI.CLASSE_SERV(ORD.BDS_ID, OFF.COD_OFFERTA_JPUB)x', -- TIPO_VC_CLASSE_SERV Lotto S6
                                                             q'xCASE OFF.COD_OFFERTA_JPUB WHEN '44' THEN PKG_ESTRAZIONI.VLAN_VALUE_ORD(ORD.BDS_ID, 'TIPO_COS') ELSE NULL ENDx', -- TIPO_VC_GBE_CLASSE_SERV Lotto S6 --S7
                                                             q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD.BDS_ID, 'TIPOBANDACONSEGNA')x', -- MOD_VENDITA_VC Lotto S6
                                                             'DECODE(UPPER(PROF.MODELLO_ACCS),''FIXED'',''1'',''RATE ADAPTIVE'',''2'',NULL)',--SM_3209
                                                             q'xCASE WHEN PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD.BDS_ID, 'TRASPORTO') IS NOT NULL THEN 1 ELSE 0 ENDx', -- TIPO_TRASP --S7
                                                             'PKG_ESTRAZIONI.SET_DATE(ORD.DES)', --50
                                                             q'xPKG_ESTRAZIONI.CODIFICA_CODICE_FATT(ORD.BDS_ID,'RES')x', -- SUB_TIPO_LINEA_RESIDENZIALE Lotto S6
                                                             'CASE TO_CHAR(ORD.TIPOLOGIALAVORAZIONE) WHEN '|| ORDINE_CESSAZIONE || q'x THEN 'Delete' WHEN x' || ORDINE_ATTIVAZIONE || q'x THEN 'Add' ELSE NULL ENDx',
                                                             q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD.BDS_ID, 'PROFILOTECNICOLINEA')x');

    ORDINI_GIAC_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS (
                                                          'ORD.IDRISORSA',
                                                          'TIP_LAV.TIPOLG_LAVRZ_GUI', -- Lotto 6
                                                          'TIP_S_LAV.TIPOLG_SOTTO_LAVRZ_GUI', -- Lotto 6
                                                          'PKG_ESTRAZIONI.SET_DATE(ORD.DATAINVIOORDINEADELIVERY)',
                                                          'TIP_RICH.STATO_RICH_NOW_GUI', -- Lotto 6
                                                          'CAUS.DESCR_CAUS_INTERNO', -- Lotto 6 -- S7
                                                          'PKG_ESTRAZIONI.SET_DATE(ORD.DATAINVIOORDINEADELIVERY)',
                                                          'OFF.TIPO_SRVZ', -- TIPO SERVIZIO
                                                          'ORD.CODIFICAOLOAGCOM',
                                                          'ORD.CODICEORDINEOLO', -- (10)
                                                          'RICH.IDRICHIESTAOLO',
                                                          'T_OFF.NOME_OFFERTA_ESTERNA', -- Lotto 6
                                                          'TIP_RICH.STATO_RICH_NOW_GUI', -- STATO_SOI Lotto 6
                                                          'TIP_RICH_OLO.STATO_RICH_OLO_GUI', -- X_OLO_STATUS Lotto 6
                                                          'NP_NUMAGG.NUMEROAGGIUNTIVO',
                                                          'ORD.CODICEPROGETTO',
                                                          'PKG_ESTRAZIONI.SET_DATE(ORD.CREATED)',
                                                          'PKG_ESTRAZIONI.SET_DATE(ORD.CREATED)',
                                                          'PKG_ESTRAZIONI.SET_DATE(ORD.DATACHIUSURAORDINE)', -- (19)
                                                          'CASE TO_CHAR(ORD.TIPOLOGIALAVORAZIONE) WHEN '|| ORDINE_CESSAZIONE || ' THEN PKG_ESTRAZIONI.SET_DATE(RICH.DRO) ELSE NULL END',
                                                          'NULL', -- DATA CONSEGNA GARANTITA (21)
                                                          'PKG_ESTRAZIONI.SET_DATE(ORD.DAC)',
                                                          'NULL', -- DATA ULTIMA CONSEGNA ACCETTABILE, DOPO LA QUALE L'OLO RICHIEDE L'APPLICAZIONE DELLA PENALE
                                                          'PKG_ESTRAZIONI.SET_DATE(RICH.DRO)',
                                                          'CAUS.COD_CAUS_NOW_DG', -- (25)
                                                          'ORD.CODICEDELIVERY',
                                                          'AGREE.FLAG_NPD',
                                                          'PKG_ESTRAZIONI.PROCESSED_FLAG(RICH.STATORICHIESTANOW)',
                                                          q'xCASE WHEN NVL(ORD.IDRISORSANOW,'-') <> NVL(ORD.IDRISORSA,'-') THEN ORD.IDRISORSANOW ENDx',
                                                          'RICH.IDRICHIESTAOLO', -- ROW_ID_OLI (30)
                                                          'ORD.CODICEORDINETI', -- X_TWS_TI_ORDER_CODE
                                                          'ORD.CODICEORDINETI'
                                                          , 'NULL' -- INVARIANTE (33) -- aggiunto per RU_543 fino al campo 41
                                                          , q'xto_char(ORD.DACRIMODULATA, 'DD/MM/YYYY')x' -- X_TWS_DACRIM
                                                          , 'CAUS.DESCR_CAUS_INTERNO' -- X_INT_DESC
                                                          , 'CAUS.COD_CAUS_INTERNO' -- X_INT_CODE
                                                          , 'CAUS.DESCR_CAUS_NOW_DG' -- X_DG_DESC
                                                          , 'CAUS.COD_CAUS_NOW_DG' -- X_DG_CODE
                                                          , 'CAUS.COD_CAUS_OLO' -- X_OLO_CODE
                                                          , 'CAUS.DESCR_CAUS_OLO' -- X_OLO_DESC
                                                          , 'SISTEMA.DESCR_SISTEMA_NOME_SISTEMA' -- X_ORIG_SYSTEM (41)
                                                          ); -- EVENT_ID

 VCATM_SELECT_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS ('ATTR.VALOREATTRIBUTO',
                                                          'ASSET.CODIFICAOLOAGCOM',
                                                          'OFF.COD_OFFERTA_JPUB', --SM_2746
                                                          'AGREE.COD_CONTRATTO',
                                                          'PKG_ESTRAZIONI.SET_DATE(RICH.DRO)',
                                                          'PKG_ESTRAZIONI.SET_DATE(ASSET.DES)',
                                                          'PKG_ESTRAZIONI.SET_DATE(ASSET.DESPRIMOORDINE)',
                                                          'CASE WHEN ASSET.STATOASSET = ''' || STATUS_CESSATO || ''' THEN PKG_ESTRAZIONI.SET_DATE(ASSET.DES) ELSE NULL END', -- CRISTIANO SM_1935
                                                          --'PKG_ESTRAZIONI.SET_DATE(ASSET.DES)',
                                                          'PKG_ESTRAZIONI.CODIFICA_TIPO_ORDINE(ORD.TIPOLOGIALAVORAZIONE,ORD.TIPOLOGIASOTTOLAV)', --TIPO ORDINE SM_2746
                                                         q'xCASE WHEN PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'TIPOPROFILOVC') = 'ABR' THEN 1 WHEN PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'TIPOPROFILOVC') = 'VBR' THEN 2 WHEN PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'TIPOPROFILOVC') = 'CBR' THEN 6 ENDx', -- CRISTIANO SM_1935
                                                          --q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'TIPOPROFILOVC')x',
                                                          'PROF_VC.PCR_UP',
                                                          'PROF_VC.PCR_DOWN',
                                                          'PROF_VC.MCR_UP',
                                                          'PROF_VC.MCR_DOWN',
                                                          'PROF_VC.SCR_UP',
                                                          'PROF_VC.SCR_DOWN',
                                                          q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'CODICEVP')x',
                                                         q'xPKG_ESTRAZIONI.TIPO_FAMIGLIA(OFF.ID_OFFERTA)x', -- TIPO_FAMIGLIA S7 SIMMETRICI
                                                          'OFF.IDTPLG_PAGAMENTO_ACCS', -- OK MOD_FATT
                                                          q'xCASE PKG_ESTRAZIONI.VP_VALUE(ASSET.BDS_ID, 'TIPO_TRASPORTO') WHEN 'Presente' THEN 1  ELSE 0 ENDx', -- (9) TIPO_TRASP SM_2746 --SM_4066
                                                          q'xCASE PKG_ESTRAZIONI.VP_VALUE(ASSET.BDS_ID, 'TIPO_TRASPORTO') WHEN 'Presente' THEN CASE OFF.IDTPLG_PAGAMENTO_ACCS WHEN 1 THEN 1  WHEN 2 THEN 2 WHEN 3 THEN 2  ELSE 3 END  ELSE Null ENDx',--  SM_5684 MOD FATT TRASP
                                                          --q'xCASE PKG_ESTRAZIONI.VP_VALUE(ASSET.BDS_ID, 'MODALITA_FATTURAZIONE') WHEN 'Flat' then 1 WHEN 'Hight' THEN 2 WHEN 'Light' THEN 2  ELSE Null ENDx', -- (10)MOD_FAT_TRASP SM_2746
                                                          q'xPKG_ESTRAZIONI.CODE_AREA_RACC_DETT(DETT.BDS_ID, 'COD_AREA_RACCOLTA')x', -- CODE_AREA SM_2746
                                                          q'xPKG_ESTRAZIONI.CODE_AREA_RACC_DETT(DETT.BDS_ID, 'COD_KIT')x', -- CODE_AREA SM_2746
                                                          'ASSET.CODICEORDINETI',
                                                          q'xCASE ASSET.STATOASSET WHEN TO_NCHAR('x' || STATUS_INLAVORAZIONE || q'x') THEN 'S' ELSE 'N' ENDx',
                                                          q'xPKG_ESTRAZIONI.MODALITA_VENDITA(DETT.BDS_ID, OFF.ID_OFFERTA)x',
                                                          --'CAUS.DESCR_CAUS_NOW_DG',
                                                          'ULT_LAV.TIPOLG_SOTTO_LAVRZ_GUI',
                                                          q'xNVL(PKG_ESTRAZIONI.SET_DATE(ORD.DACRIMODULATA), PKG_ESTRAZIONI.SET_DATE(ORD.DAC))x', -- DATA PREVISTA CHIUSURA SM_2746
                                                          'ASSET.CODICEORDINEOLO',
                q'xCASE WHEN PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'TIPOPROFILOVC') = 'ABR' THEN 1 WHEN PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'TIPOPROFILOVC') = 'VBR' THEN 2 WHEN PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'TIPOPROFILOVC') = 'CBR' THEN 6 ENDx', -- CRISTIANO SM_1935
                                                          --q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'TIPOPROFILOVC')x',
                                                            'TIP_RICH.STATO_RICH_NOW_GUI', -- STATO_ORDINE (26) --> SM_4022 STATO RICHIESTA NOW
                                                          'PKG_ESTRAZIONI.CODIFICA_STATO_RICHIESTA(RICH.STATORICHIESTANOW)');

  VC_VLAN_SELECT_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS ('ATTR.VALOREATTRIBUTO',
                                                          'ASSET.CODIFICAOLOAGCOM',
                                                          'OFF.COD_OFFERTA_JPUB', --SM_2746
                                                          'AGREE.COD_CONTRATTO',
                                                          'PKG_ESTRAZIONI.SET_DATE(RICH.DRO)',
                                                          'PKG_ESTRAZIONI.SET_DATE(ASSET.DES)',
                                                          'PKG_ESTRAZIONI.SET_DATE(ASSET.DESPRIMOORDINE)',
                                                          'CASE WHEN ASSET.STATOASSET = ''' || STATUS_CESSATO || ''' THEN PKG_ESTRAZIONI.SET_DATE(ASSET.DES) ELSE NULL END', -- DATA_CESSAZIONE
                                                          'PKG_ESTRAZIONI.CODIFICA_TIPO_ORDINE(ORD.TIPOLOGIALAVORAZIONE,ORD.TIPOLOGIASOTTOLAV)', --TIPO ORDINE SM_2746
                                                          'ORD.TIPOLOGIASOTTOLAV',
                                                          q'xCASE OFF.MODO_TRASFERIMENTO WHEN 'ASIMMETRICO' THEN CASE OFF.COD_OFFERTA_JPUB WHEN '44' THEN 10 WHEN '50' THEN 15 WHEN '51' THEN 16 ELSE Null END WHEN 'SIMMETRICO' THEN CASE OFF.COD_OFFERTA_JPUB WHEN '44' THEN 14 ELSE Null END ELSE Null ENDx', -- TIPO FAMIGLIA S7 BTS GBE SIMMETRICI
                                                          --q'xPKG_ESTRAZIONI.TIPO_FAMIGLIA(OFF.ID_OFFERTA)x',
                                                          q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'BANDAPICCOUP')x',
                                                          q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'BANDAPICCODOWN')x',
                                                          q'xPROF_BMD.BP2_MAXx',
                                                          q'xPROF_BMD.BP2x',
                                                          q'xPROF_BMD.BP3_MAXx',
                                                          q'xPROF_BMD.BP3x',
                                                          q'xPROF_BMD.BP5_MAXx',
                                                          q'xPROF_BMD.BP5x',
                                                          q'xPROF_BMD.BP6_MAXx',
                                                          q'xPROF_BMD.BP6x',
                                                          q'xPKG_ESTRAZIONI.VLAN_VALUE(ASSET.BDS_ID, 'COD_AREA_RACCOLTA')x', --SM_3936
                                                          q'xPKG_ESTRAZIONI.VLAN_VALUE(ASSET.BDS_ID, 'COD_MACRO_AREA')x', --SM_3936
                                                          'ASSET.CODICEORDINETI',
                                                          q'xCASE ASSET.STATOASSET WHEN TO_NCHAR('x' || STATUS_INLAVORAZIONE || q'x') THEN 'S' ELSE 'N' ENDx',
                                                          'CAUS.DESCR_CAUS_NOW_DG',
                                                          q'xNVL(PKG_ESTRAZIONI.SET_DATE(ORD.DACRIMODULATA), PKG_ESTRAZIONI.SET_DATE(ORD.DAC))x', -- DATA PREVISTA CHIUSURA SM_2746
                                                          'ASSET.CODICEORDINEOLO',
                                                          'TIP_RICH.STATO_RICH_NOW_GUI', -- STATO_ORDINE (26) --> SM_4022 STATO RICHIESTA NOW
                                                          'PKG_ESTRAZIONI.CODIFICA_STATO_RICHIESTA(RICH.STATORICHIESTANOW)');

  NOWRI_VC_SELECT_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS ('ATTR.VALOREATTRIBUTO',
                                                            'ASSET.CODIFICAOLOAGCOM',
                                                            '42',
                                                            'AGREE.COD_CONTRATTO',
                                                            'PKG_ESTRAZIONI.SET_DATE(RICH.DRO)',
                                                            'PKG_ESTRAZIONI.SET_DATE(ASSET.DES)',
                                                            'PKG_ESTRAZIONI.SET_DATE(ASSET.DESPRIMOORDINE)',
                                                            'PKG_ESTRAZIONI.SET_DATE(ASSET.LASTUPDATE)',
                                                            'PKG_ESTRAZIONI.SET_DATE(ASSET.DES)',
                                                            'PKG_ESTRAZIONI.CODIFICA_TIPO_ORDINE(ORD.TIPOLOGIALAVORAZIONE)',
                                                            'ORD.TIPOLOGIASOTTOLAV',
                                                            'ASSET.IDRISORSA',
                                                            q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'TIPOPROFILOVC')x',
                                                            'PROF_VC.PCR_UP',
                                                            'PROF_VC.PCR_DOWN',
                                                            'PROF_VC.MCR_UP',
                                                            'PROF_VC.MCR_DOWN',
                                                            'PROF_VC.SCR_UP',
                                                            'PROF_VC.SCR_DOWN',
                                                            q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'CODICEVP')x',
                                                            q'xPKG_ESTRAZIONI.TIPO_FAMIGLIA(OFF.ID_OFFERTA)x',
                                                            'OFF.IDTPLG_PAGAMENTO_ACCS', -- OK MOD_FATT
                                                            q'xCASE WHEN PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'TRASPORTO') IS NOT NULL THEN 1 ELSE 0 ENDx', -- SM_642 'AN_VP.TIPO_TRASPORTO',
                                                            q'xPKG_ESTRAZIONI.MOD_FAT_TRASP(ASSET.BDS_ID, OFF.IDTPLG_PAGAMENTO_ACCS)x', -- OK MOD_FATT_TRASP
                                                            'AN_VP.COD_AREA_RACCOLTA',
                                                            'AN_VP.COD_KIT',
                                                            'ASSET.CODICEORDINETI');

  NOWRI_CVLAN_SELECT_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS ('ATTR.VALOREATTRIBUTO',
                                                            'ASSET.CODIFICAOLOAGCOM',
                                                            '44',
                                                            'AGREE.COD_CONTRATTO',
                                                            'PKG_ESTRAZIONI.SET_DATE(RICH.DRO)',
                                                            'PKG_ESTRAZIONI.SET_DATE(ASSET.DES)',
                                                            'ASSET.IDRISORSA',
                                                            q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'IDVLAN')x',
                                                            'PKG_ESTRAZIONI.SET_DATE(ASSET.DESPRIMOORDINE)',
                                                            'PKG_ESTRAZIONI.SET_DATE(ASSET.LASTUPDATE)',
                                                            'PKG_ESTRAZIONI.SET_DATE(ASSET.DES)',
                                                            'PKG_ESTRAZIONI.CODIFICA_TIPO_ORDINE(ORD.TIPOLOGIALAVORAZIONE)',
                                                            'ORD.TIPOLOGIASOTTOLAV',
                                                            q'xPKG_ESTRAZIONI.TIPO_FAMIGLIA(OFF.ID_OFFERTA)x',
                                                            q'xPKG_ESTRAZIONI.VLAN_VALUE(ASSET.BDS_ID, 'COD_AREA_RACCOLTA')x',
                                                            q'xPKG_ESTRAZIONI.VLAN_VALUE(ASSET.BDS_ID, 'COD_MACRO_AREA')x',
                                                            'ASSET.CODICEORDINETI');

  NOWRI_UVLAN_SELECT_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS (q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'IDRISORSAUSERVLAN')x',
                                                                q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'CVLANID')x',
                                                                'ASSET.CODIFICAOLOAGCOM',
                                                                'OFF.COD_OFFERTA_JPUB', -- TIPO_CONTR
                                                                'AGREE.COD_CONTRATTO',
                                                                q'xPKG_ESTRAZIONI.TIPO_FAMIGLIA(OFF.ID_OFFERTA)x',
                                                                'ASSET.IDRISORSA',
                                                                q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'BANDAPICCOUP')x',
                                                                q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'BANDAPICCODOWN')x',
                                                                q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'IDVLAN')x',
                                                                q'xPROF_BMD.BP2_MAXx',
                                                                q'xPROF_BMD.BP2x',
                                                                q'xPROF_BMD.BP3_MAXx',
                                                                q'xPROF_BMD.BP3x',
                                                                q'xPROF_BMD.BP5_MAXx',
                                                                q'xPROF_BMD.BP5x',
                                                                q'xPROF_BMD.BP6_MAXx',
                                                                q'xPROF_BMD.BP6x',
                                                                'ASSET.IDRICHIESTAOLO',
                                                                'ASSET.CODICEORDINETI',
                                                                'PKG_ESTRAZIONI.SET_DATE(RICH.DRO)',
                                                                'PKG_ESTRAZIONI.SET_DATE(ASSET.DES)',
                                                                'PKG_ESTRAZIONI.SET_DATE(ASSET.DESPRIMOORDINE)',
                                                                'PKG_ESTRAZIONI.SET_DATE(ASSET.DES)',
                                                                'RICH.CREATED',
                                                                'PKG_ESTRAZIONI.CODIFICA_TIPO_ORDINE(ORD.TIPOLOGIALAVORAZIONE)',
                                                                'ORD.TIPOLOGIASOTTOLAV',
                                                                'RICH.STATORICHIESTANOW',
                                                                'ASSET.IDRISORSANOW');

  F1_TD_INNOV_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS ('ASSET.CODIFICAOLOAGCOM',
                                                          'OLO.COD_OLO',
                                                          'OLO.NOME',
                                                          q'xCASE OFF.MODO_TRASFERIMENTO WHEN 'ASIMMETRICO' THEN 39 ELSE 40 ENDx',
                                                          q'xCASE PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'TIPOBANDACONSEGNA') WHEN 'CONDIVISA' THEN CASE PKG_ESTRAZIONI.VP_VALUE(ASSET.BDS_ID, 'TIPO') WHEN 'Standard' THEN 25 WHEN 'Special' THEN 26 WHEN 'Lite' THEN 27 Else Null END WHEN 'DEDICATA' THEN Null ENDx', -- CODE_TIPO_OFFERTA SM_4022
                                                          --q'xPKG_ESTRAZIONI.TIPO_OFFERTA(ASSET.BDS_ID)x', -- CODICE TIPO OFFERTA SM_2746
                                                          --q'xCASE UPPER(TO_CHAR(ORD.MODALITAFATTURAZIONE)) WHEN 'FLAT' THEN 0 WHEN 'CONSUM' THEN 1 ELSE NULL ENDx',
                                                            q'xCASE ASSET.IDOFFERTA WHEN 8 THEN '0' WHEN 9 THEN '1' WHEN 10 THEN '1' WHEN 39 THEN '0' WHEN 40 THEN '1' ELSE NULL ENDx', -- (6) FLAG BILLING S7  -- SM_4066
                                                         -- q'xCASE OFF.ID_OFFERTA WHEN 8 THEN 'BITSTREAM ATM Asimmetrico Flat' WHEN 9 THEN 'BITSTREAM ATM Asimmetrico High Level Consumo' WHEN 10 THEN 'BITSTREAM ATM Asimmetrico Lite Consumo' ELSE NULL ENDx',
                                                         'T_OFF.NOME_OFFERTA_ESTERNA', -- (7) Tipo Offerta Commerciale S7
                                                          q'x(SELECT DTU.DESCR FROM TIPOLG_OFFERTA_DTU DTU WHERE DTU.ID_NOME_OFFERTA_DTU = OFF.ID_NOME_OFFERTA_DTU)x',
                                                          q'x'ATM'x', -- sm 2220
                                                          'NULL',
                                                          q'x PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'CODICEVP','ATMVC') x', -- cristiano COD_VP --SM_4022
                                                          q'x PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'VPI','ATMVC') x', -- Cristiano VPI --SM_4022
                                                          q'xPKG_ESTRAZIONI.CODE_AREA_RACC(ASSET.BDS_ID, 'COD_AREA_RACCOLTA')x', -- CODE_AREA SM_2746
                                                          q'xPKG_ESTRAZIONI.CODE_AREA_RACC(ASSET.BDS_ID, 'DESC_AREA_RACCOLTA')x', -- DESC_AREA SM_2746
                                                          'PKG_ESTRAZIONI.GET_FLAG_TRASPORTO(ASSET.OFFERTA, ASSET.BDS_ID)', -- FLAG_TRASPORTO
                                                          q'xCASE PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'TIPOLINEA', decode(off.id_offerta, 7, 'ACCESSOGBEASIMFLAT', 8, 'ACCESSOATMASIMFLAT', 9, 'ACCESSOATMASIMHL', 10, 'ACCESSOATMASIMLITE')) WHEN 'POTS' THEN substr(ASSET.IDRISORSA, 1, instr(ASSET.IDRISORSA, ' ')-1) ELSE ASSET.NUMEROFITTIZIO ENDx', -- TGU UF
                                                          q'xCASE OFF.MODO_TRASFERIMENTO WHEN 'SIMMETRICO' THEN CASE PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'TIPOLINEA') WHEN 'LineaNonFonia' THEN ASSET.IDRISORSA ELSE NULL END ELSE NULL ENDx', -- TD UF ESTENSIONE SIMMETRICI S7
                                                          q'xCASE PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'TIPOBANDACONSEGNA') WHEN 'DEDICATA' THEN PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'CODICETD','ATMVC') WHEN 'CONDIVISA' THEN Null ENDx', -- TD_OLO SM_2746
                                                          'ASSET.IDASSET', -- CODICE XDSL
                                                          'CASE WHEN ULT_ORD.TIPOLOGIALAVORAZIONE = ''CESSAZIONE'' THEN 6 WHEN ULT_ORD.TIPOLOGIALAVORAZIONE = ''VARIAZIONE'' THEN 9 ELSE 1 END', --TBD STATO UTENZA
                                                          'CASE WHEN ASSET.CODICETOPONOMASTICA IS NULL AND ASSET.COMUNE IS NULL THEN ASSET.LOCALITA WHEN ASSET.CODICETOPONOMASTICA IS NULL THEN ASSET.COMUNE ELSE TO_NCHAR(PKG_ESTRAZIONI.GET_COMUNE (ASSET.CODICETOPONOMASTICA)) END', -- CODICE COMUNE (21)
                                                          q'xPKG_ESTRAZIONI.SET_DATE(ASSET.DES)x', --DES
                                                          q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'TIPOPROFILOVC')x', --CLASSE DI SERVIZIO
                                                          q'xCASE WHEN PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'TIPOPROFILOVC')='VBR' THEN DECODE(PROF_VC.SCR_DOWN,150,'A',300,'B',600,'C',1200,'D',37.5,'E',200,'F',400,'G',1600,'H',3200,'I') ELSE NULL ENDx',-- Profilo VBR ESTENSIONE SIMMETRICI S7
                                                          --'NULL',
                                                          q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'DLCI')x', --DLCI ESTENSIONE SIMMETRICI S7
                                                          q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'VCI')x',
                                                          q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'VPI')x',
                                                          q'xPROF_VC.MCR_DOWNx',
                                                          q'xPROF_VC.MCR_UPx',
                                                          q'xPROF_VC.PCR_DOWNx',
                                                          q'xPROF_VC.PCR_UPx',
                                                          q'xPROF_VC.SCR_DOWNx',
                                                          q'xPROF_VC.SCR_UPx',
                                                          q'xCASE WHEN ASSET.STATOASSET='ATTIVO' THEN 1 ELSE CASE WHEN ULT_ORD.tipologialavorazione='CESSAZIONE' THEN 6 ELSE 9 END ENDx', -- CODE_STATO_PS_ULL_OFFERTA (34)
                                                          q'xCASE TO_CHAR(DETT.NOMECOMPONENTE) WHEN 'ATMVC' THEN CASE WHEN DETT.STATODETTAGLIOASSET='ATTIVO' THEN 1 ELSE CASE WHEN ULT_ORD.tipologialavorazione='CESSAZIONE' THEN 6 ELSE 9 END END ENDx', -- CODE_STATO_PS_ULL_LINEA (35)
                                                          q'xCASE PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'TIPOBANDACONSEGNA') WHEN 'CONDIVISA' THEN CASE PKG_ESTRAZIONI.VP_VALUE(ASSET.BDS_ID, 'STATO') WHEN 'Active' THEN 1 WHEN 'Inactive' THEN 6 Else Null END WHEN 'DEDICATA' THEN Null ENDx', -- CODE_STATO_PS_ULL_LOTTO SM_2746
                                                          'ASSET.IDRISORSA',
                                                          'ASSET.CLLI',
                                                          'ORD.CODICEPROGETTO',
                                                          q'x'ND'x', -- CODE_VPI_VCI
                                                          q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'VPI')x', -- SM_4435  'AN_VP.VPI',-- VALO_VPI_OLO
                                                          q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'VCI')x',--VALO_VCI_OLO
                                                          q'x'ND'x',--CODE_DLCI
                                                         -- 'NULL',
                                                          q'xCASE (PROF_VC.PCR_DOWN / 1024) WHEN 0 THEN '1' ELSE TO_CHAR(ROUND (PROF_VC.PCR_DOWN / 1024)) ENDx',--VALO_CAPAC_TRASM_MBITS
                                                          q'xCASE OFF.ID_OFFERTA WHEN 8 THEN 'BTS_FLAS' WHEN 10 THEN 'BTS_LITE' WHEN 9 THEN 'BTS_HLAS' ELSE NULL ENDx', --TIPO_SERVIZIO
                                                          q'xCASE PKG_ESTRAZIONI.GET_FLAG_TRASPORTO(ASSET.OFFERTA, ASSET.BDS_ID) WHEN 0 THEN 0 WHEN 1 THEN CASE WHEN UPPER(ASSET.OFFERTA) IN ('BITSTREAMATMASIMMETRICOHL', 'BITSTREAMATMASIMMETRICOLITE','BITSTREAMATMSIMMETRICOHL') THEN 1 WHEN UPPER(ASSET.OFFERTA) IN ('BITSTREAMATMASIMMETRICOFLAT', 'BITSTREAMGBEASIMMETRICOFLAT','BITSTREAMATMSIMMETRICOFLAT','BITSTREAMGBESIMMETRICOFLAT') THEN 2 ELSE NULL END ENDx', -- FLAG_TRAFFICO ESTENSIONE SIMMETRICI S7
                                                          q'xCASE WHEN PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'TIPOPROFILOVC')='VBR' THEN DECODE(PROF_VC.SCR_DOWN,150,'A',300,'B',600,'C',1200,'D',37.5,'E',200,'F',400,'G',1600,'H',3200,'I') ELSE NULL ENDx', --UF_PREFISSO ESTENSIONE SIMMETRICI S7
                                                          'NULL'); -- per separatore anche in ultima posizione

  F2_TD_INNOV_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS ('ASSET.IDASSET',
                                                         'ASSET.IDRISORSA',
                                                         'ASSET.TIPO',
                                                         q'x1x',
                                                         'NULL');
--
  F1_TD_INNOV_COLS_NISIDA T_SELECT_COLUMNS := T_SELECT_COLUMNS ('ASSET.CODIFICAOLOAGCOM',
                                                          'OLO.COD_OLO',
                                                          'OLO.NOME',
                                                          q'xCASE OFF.MODO_TRASFERIMENTO WHEN 'ASIMMETRICO' THEN 39 ELSE 40 ENDx',
                                                          q'xCASE PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'TIPOBANDACONSEGNA') WHEN 'CONDIVISA' THEN CASE PKG_ESTRAZIONI.VP_VALUE(ASSET.BDS_ID, 'TIPO') WHEN 'Standard' THEN 25 WHEN 'Special' THEN 26 WHEN 'Lite' THEN 27 Else Null END WHEN 'DEDICATA' THEN Null ENDx', -- CODE_TIPO_OFFERTA SM_4022
                                                          q'xCASE ASSET.IDOFFERTA WHEN 8 THEN '0' WHEN 9 THEN '1' WHEN 10 THEN '1' WHEN 39 THEN '0' WHEN 40 THEN '1' ELSE NULL ENDx', -- (6) FLAG BILLING S7  -- SM_4066
                                                          'T_OFF.NOME_OFFERTA_ESTERNA', -- (7) Tipo Offerta Commerciale S7
                                                          q'x(SELECT DTU.DESCR FROM TIPOLG_OFFERTA_DTU DTU WHERE DTU.ID_NOME_OFFERTA_DTU = OFF.ID_NOME_OFFERTA_DTU)x',
                                                          --q'x'ATM'x', -- sm 2220
                                                          q'xCASE PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'PROFILOTECNICOLINEA','ProtocolloUF') WHEN 'FR' THEN 'FR' ELSE 'ATM' ENDx', --SM_5646
                                                         -- q'xDECODE(UPPER(OFF.MODO_TRASFERIMENTO),'ASIMMETRICO','ATM','FR')x', --Protocollo UF
                                                          'NULL',
                                                          q'x PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'CODICEVP','ATMVC') x', -- cristiano COD_VP --SM_4022
                                                          q'x PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'VPI','ATMVC') x', -- Cristiano VPI --SM_4022
                                                          q'xPKG_ESTRAZIONI.CODE_AREA_RACC(ASSET.BDS_ID, 'COD_AREA_RACCOLTA')x', -- CODE_AREA SM_2746
                                                          q'xPKG_ESTRAZIONI.CODE_AREA_RACC(ASSET.BDS_ID, 'DESC_AREA_RACCOLTA')x', -- DESC_AREA SM_2746
                                                          'PKG_ESTRAZIONI.GET_FLAG_TRASPORTO(ASSET.OFFERTA, ASSET.BDS_ID)', -- FLAG_TRASPORTO
                                                          q'xCASE WHEN OFF.ID_OFFERTA IN (8, 9, 10) THEN decode(instr(ASSET.IDRISORSA,'W'),0, ASSET.IDRISORSA, trim(substr(ASSET.IDRISORSA,1,instr(ASSET.IDRISORSA,'W')-1))) ELSE NULL ENDx', --TGU UF (SM_5197)
                                                          q'xCASE WHEN OFF.ID_OFFERTA IN (39, 40) THEN ASSET.IDRISORSA ELSE NULL ENDx', --TD UF (SM_5197)
                                                          q'xCASE PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'TIPOBANDACONSEGNA') WHEN 'DEDICATA' THEN PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'CODICETD','ATMVC') WHEN 'CONDIVISA' THEN Null ENDx', -- TD_OLO SM_2746
                                                          'ASSET.BDS_ID', -- CODICE XDSL
                                                          q'xPKG_ESTRAZIONI.GET_STATI_F1_TD (RICH.IDRISORSA, 'STATO_UTENZA')x', --TBD STATO UTENZA -- SM_6018
                                                          'CASE WHEN ASSET.CODICETOPONOMASTICA IS NULL AND ASSET.COMUNE IS NULL THEN ASSET.LOCALITA WHEN ASSET.CODICETOPONOMASTICA IS NULL THEN ASSET.COMUNE ELSE TO_NCHAR(PKG_ESTRAZIONI.GET_COMUNE (ASSET.CODICETOPONOMASTICA)) END', -- CODICE COMUNE (21)
                                                          q'xPKG_ESTRAZIONI.SET_DATE(ASSET.DES)x', --DES
                                                          q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'TIPOPROFILOVC')x', --CLASSE DI SERVIZIO
                                                          q'xCASE WHEN PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'TIPOPROFILOVC')='VBR' THEN DECODE(PROF_VC.SCR_DOWN,150,'A',300,'B',600,'C',1200,'D',37.5,'E',200,'F',400,'G',1600,'H',3200,'I') ELSE NULL ENDx',-- Profilo VBR ESTENSIONE SIMMETRICI S7
                                                          q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'DLCI')x', --DLCI ESTENSIONE SIMMETRICI S7
                                                          q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'VCI')x',
                                                          q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'VPI')x',
                                                          q'xPROF_VC.MCR_DOWNx',
                                                          q'xPROF_VC.MCR_UPx',
                                                          q'xPROF_VC.PCR_DOWNx',
                                                          q'xPROF_VC.PCR_UPx',
                                                          q'xPROF_VC.SCR_DOWNx',
                                                          q'xPROF_VC.SCR_UPx',
                                                          q'xPKG_ESTRAZIONI.GET_STATI_F1_TD (RICH.IDRISORSA, 'CODE_STATO_PS_ULL_OFFERTA')x', -- CODE_STATO_PS_ULL_OFFERTA (34)  -- SM_6018
                                                          q'xPKG_ESTRAZIONI.GET_STATI_F1_TD (RICH.IDRISORSA, 'CODE_STATO_PS_ULL_LINEA')x', -- CODE_STATO_PS_ULL_LINEA (35) -- SM_6018
                                                          q'x'1'x', -- CODE_STATO_PS_ULL_LOTTO -- SM_6018
                                                          'ASSET.IDRISORSA',
                                                          'ASSET.CLLI',
                                                          'ORD.CODICEPROGETTO',
                                                          q'x'ND'x', -- CODE_VPI_VCI
                                                          q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'VPI')x', -- SM_4435   'AN_VP.VPI',-- VALO_VPI_OLO
                                                          q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'VCI')x',--VALO_VCI_OLO
                                                          q'x'ND'x',--CODE_DLCI
                                                          q'xCASE (PROF_VC.PCR_DOWN / 1024) WHEN 0 THEN '1' ELSE TO_CHAR(ROUND (PROF_VC.PCR_DOWN / 1024)) ENDx',--VALO_CAPAC_TRASM_MBITS
                                                          q'xCASE OFF.ID_OFFERTA WHEN 8 THEN 'BTS_FLAS' WHEN 10 THEN 'BTS_LITE' WHEN 9 THEN 'BTS_HLAS' WHEN 39 THEN 'BTS_FLSI' WHEN 40 THEN 'BTS_HLSI' ELSE NULL ENDx', --TIPO_SERVIZIO
                                                          q'xCASE PKG_ESTRAZIONI.GET_FLAG_TRASPORTO(ASSET.OFFERTA, ASSET.BDS_ID) WHEN 0 THEN 0 WHEN 1 THEN CASE WHEN UPPER(ASSET.OFFERTA) IN ('BITSTREAMATMASIMMETRICOHL', 'BITSTREAMATMASIMMETRICOLITE','BITSTREAMATMSIMMETRICOHL') THEN 1 WHEN UPPER(ASSET.OFFERTA) IN ('BITSTREAMATMASIMMETRICOFLAT', 'BITSTREAMGBEASIMMETRICOFLAT','BITSTREAMATMSIMMETRICOFLAT','BITSTREAMGBESIMMETRICOFLAT') THEN 2 ELSE NULL END ENDx', -- FLAG_TRAFFICO ESTENSIONE SIMMETRICI S7
                                                          q'xCASE WHEN PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'TIPOPROFILOVC')='VBR' THEN DECODE(PROF_VC.SCR_DOWN,150,'A',300,'B',600,'C',1200,'D',37.5,'E',200,'F',400,'G',1600,'H',3200,'I') ELSE NULL ENDx', --UF_PREFISSO ESTENSIONE SIMMETRICI S7
                                                          'NULL'); -- per separatore anche in ultima posizione

  F2_TD_INNOV_COLS_NISIDA T_SELECT_COLUMNS := T_SELECT_COLUMNS ('ASSET.IDASSET',
                                                         'ASSET.IDRISORSA',
                                                         'ASSET.TIPO',
                                                         q'x1x',
                                                         'NULL');


  ULL_RI_SELECT_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS ('ASSET.CODICEORDINETI', --(1)
                                                           'PKG_ESTRAZIONI.SET_DATE(RICH.DRO)', -- (2)
                                                           'PKG_ESTRAZIONI.SET_DATE(ASSET.DES)', -- (3)
                                                           'ORD.CODICEPROGETTO', -- (4)
                                                           'OFF.COD_OFFERTA_JPUB', -- SM_392 'TPL_CON.COD_CONTRATTO_JPUB', -- TIPO_CONTR -- (5)
                                                           'ASSET.CLLI', -- (6)
                                                           'CODE_PREST_AGG', -- CODE_PREST_AGG -- valore cablato in ridefinizione array -- (7)
                                                           'ASSET.IDRISORSA', -- (8)
                                                           'ID_RIS_PRINC', -- ID_RIS_PRINC  -- valore cablato in ridefinizione array -- (9)
                                                           'ASSET.CODIFICAOLOAGCOM', -- CODE_GEST_REC -- (10)
                                                           'CODE_GEST_RET', -- CODE_GEST_RET  -- valore cablato in ridefinizione array --(11)
                                                           q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD.BDS_ID, 'TIPO_LINEA')x', -- TIPO_FAMIGLIA -- (12)
                                                           'OPZ_COMM', -- valore cablato in ridefinizione array -- (13)
                                                           q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'DESTINAZIONEUSO')x', -- TIPO_LINEA -- (14)
                                                           'FLAG_NP', -- FLAG_NP -- valore cablato in ridefinizione array -- (15)
                                                           'CASE OFF.ID_OFFERTA WHEN 1 THEN 52 ELSE NULL END', -- SUB_TIPO_LINEA -- (16)
                                                           q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD.BDS_ID, 'CODICEPIATTAFORMA')x', -- SUB_TIPO_LINEA_RESIDENZIALE -- (17)
                                                           'SUB_TIPO_LINEA_DIREZIONE', -- SUB_TIPO_LINEA_DIREZIONE  -- valore cablato in ridefinizione array -- (18)
                                                           q'xORD.LNA_LAx', -- MOD_VENDITA_ACCESSO -- (19)
                                                           'PKG_ESTRAZIONI.SET_DATE(ASSET.DESPRIMOORDINE)', -- DATA_INIZIO_NOL --(20)
                                                           q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'IDULLCO')x', -- CODE_ID_ULLCO -- (21)
                                                            'PKG_ESTRAZIONI.DISTRETTO(ASSET.DISTRETTO)', -- (22)
                                                           q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'PERMUTAARMADIO')x', -- FLAG_PERMUTA -- (23)
                                                           'FLAG_MIGRAZIONE', -- FLAG_MIGRAZIONE   -- valore cablato in ridefinizione array -- (24)
                                                           'FLAG_QUALIFICAZIONE', -- FLAG_QUALIFICAZIONE  -- valore cablato in ridefinizione array -- (25)
                                                           'ID_RIS_OLD', -- ID_RIS_OLD  -- valore cablato in ridefinizione array -- (26)
                                                           'PKG_ESTRAZIONI.SET_DATE(ASSET.DESPRIMOORDINE)', -- DATA_DEC -- (27)
                                                           'PKG_ESTRAZIONI.SET_DATE(RICH.DRO)', -- DATA_RICHIESTA_CESSAZIONE -- (28)
                                                           'PKG_ESTRAZIONI.SET_DATE(ASSET.DES)', -- DATA_CESSAZIONE -- (29)
                                                           'PKG_ESTRAZIONI.SET_DATE(ORD.DATAINVIOORDINEADELIVERY)', -- DATA_INVIO_DELIVERY -- (30)
                                                           q'x'N'x', -- CODE_TIPO_INVIO -- (31)
                                                           'ORD.TIPOLOGIALAVORAZIONE', -- TIPO_ORDINE --(32)
                                                           'ORD.TIPOLOGIASOTTOLAV', -- CAUSALE_TIPO_ORDINE -- (33)
                                                           'RICH.STATORICHIESTANOW', -- STATO_ORDINE -- (34)
                                                           'PKG_ESTRAZIONI.SET_DATE((SELECT TIMSTP_INSMTO_EVENTO  FROM EVENTO_ORDN_NOW_WHLS EVENT WHERE EVENT.ID_EVENTO_ORDN_NOW_WHLS = PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO)))', -- DATA_INVIO_BILLING -- (35)
                                                           'PKG_ESTRAZIONI.CODIFICA_STATO_RICHIESTA(RICH.STATORICHIESTANOW)'); -- ESITO_ACQUISIZONE_BILLING -- (36)

  ULL_SLU_SELECT_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS ('ASSET.CODICEORDINETI',
                                                           'PKG_ESTRAZIONI.SET_DATE(RICH.DRO)',
                                                           'PKG_ESTRAZIONI.SET_DATE(ASSET.DES)',
                                                           'ORD.CODICEPROGETTO',
                                                           'OFF.COD_OFFERTA_JPUB', -- SM_392 'TPL_CON.COD_CONTRATTO_JPUB',
                                                           'ASSET.CLLI',
                                                           'NULL',
                                                           'ASSET.IDRISORSA',
                                                           'NULL',
                                                           'ASSET.CODIFICAOLOAGCOM',
                                                           'NULL',
                                                           '51',
                                                           q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD.BDS_ID, 'DESTINAZIONEUSO')x',
                                                           '0',--'NULL',
                                                           '52',
                                                           'NULL',
                                                           'NULL',
                                                           q'xORD.LNA_LAx',
                                                           'PKG_ESTRAZIONI.SET_DATE(ASSET.DESPRIMOORDINE)',
                                                           'ORD.IDULLCO',
                                                           q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD.BDS_ID, 'DISTRETTO')x',
                                                           q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ORD.BDS_ID, 'PERMUTAARMADIO')x',
                                                           'NULL',
                                                           'NULL',
                                                           'NULL',
                                                           'PKG_ESTRAZIONI.SET_DATE(ASSET.DESPRIMOORDINE)',
                                                           'PKG_ESTRAZIONI.SET_DATE(RICH.DRO)',
                                                           'PKG_ESTRAZIONI.SET_DATE(ASSET.DES)',
                                                           'PKG_ESTRAZIONI.SET_DATE(ORD.DATAINVIOORDINEADELIVERY)',
                                                           'PKG_ESTRAZIONI.DATA_INVIO_BILLING(ASSET.IDRISORSA)',
                                                           'PKG_ESTRAZIONI.CODIFICA_STATO_RICHIESTA(RICH.STATORICHIESTANOW)',
                                                           'ORD.TIPOLOGIALAVORAZIONE',
                                                           'ORD.TIPOLOGIASOTTOLAV',
                                                           'PKG_ESTRAZIONI.SET_DATE((SELECT TIMSTP_INSMTO_EVENTO  FROM EVENTO_ORDN_NOW_WHLS EVENT WHERE EVENT.ID_EVENTO_ORDN_NOW_WHLS = PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO)))',
                                                           'RICH.STATORICHIESTANOW');

  ATM_RI_SELECT_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS ('ASSET.IDRISORSA',
                                                           'ASSET.CODIFICAOLOAGCOM',
                                                           'NULL',
                                                            q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ORD.BDS_ID, 'TIPO_LINEA')x',
                                                            'OFF.IDTPLG_PAGAMENTO_ACCS', --q'xCASE UPPER(TO_CHAR(ORD.MODALITAFATTURAZIONE)) WHEN 'FLAT' THEN 1 WHEN 'LITE' THEN 2 WHEN 'HIGH LEVEL' THEN 3 ELSE NULL ENDx',
                                                            '42',
                                                            'AGREE.COD_CONTRATTO',
                                                            'CASE OFF.MODO_TRASFERIMENTO WHEN ' || kASIMMETRICO || ' THEN 7 WHEN ' || kSIMMETRICO || ' THEN 8 ELSE NULL END',
                                                            'PKG_ESTRAZIONI.SET_DATE(RICH.DRO)',
                                                            'PKG_ESTRAZIONI.SET_DATE(ASSET.DES)',
                                                            'PKG_ESTRAZIONI.SET_DATE(ASSET.DESPRIMOORDINE)',
                                                            'PKG_ESTRAZIONI.SET_DATE(ASSET.LASTUPDATE)',
                                                            'PKG_ESTRAZIONI.SET_DATE(ASSET.DES)',
                                                            'ORD.TIPOLOGIALAVORAZIONE',
                                                            'ORD.TIPOLOGIASOTTOLAV',
                                                            q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'CODICE', 'SPLITTER')x',
                                                            q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD.BDS_ID, 'CODICE', 'MODEM')x',
                                                            'ASSET.CODICEORDINETI',
                                                            'NULL',
                                                            'ASSET.IDRICHIESTAOLO',
                                                            'PKG_ESTRAZIONI.SET_DATE(RICH.DRO)',
                                                            'PKG_ESTRAZIONI.SET_DATE(ORD.DATAINVIOORDINEADELIVERY)',
                                                            'PKG_ESTRAZIONI.CODIFICA_STATO_RICHIESTA(RICH.STATORICHIESTANOW)',
                                                            'RICH.STATORICHIESTANOW',
                                                            'PKG_ESTRAZIONI.DATA_INVIO_BILLING(ASSET.IDRISORSA)'); --TBD

  GBE_RI_SELECT_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS ('ASSET.IDRISORSA',
                                                           'ASSET.CODIFICAOLOAGCOM',
                                                           'NULL',
                                                            q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ORD.BDS_ID, 'TIPO_LINEA')x',
                                                            'OFF.IDTPLG_PAGAMENTO_ACCS', --q'xCASE UPPER(TO_CHAR(ORD.MODALITAFATTURAZIONE)) WHEN 'FLAT' THEN 1 WHEN 'LITE' THEN 2 WHEN 'HIGH LEVEL' THEN 3 ELSE NULL ENDx',
                                                            '44',
                                                            'AGREE.COD_CONTRATTO',
                                                            'CASE OFF.MODO_TRASFERIMENTO WHEN ' || kASIMMETRICO || ' THEN 7 WHEN ' || kSIMMETRICO || ' THEN 8 ELSE NULL END',
                                                            'PKG_ESTRAZIONI.SET_DATE(RICH.DRO)',
                                                            'PKG_ESTRAZIONI.SET_DATE(ASSET.DES)',
                                                            'PKG_ESTRAZIONI.SET_DATE(ASSET.DESPRIMOORDINE)',
                                                            'PKG_ESTRAZIONI.SET_DATE(ASSET.LASTUPDATE)',
                                                            'PKG_ESTRAZIONI.SET_DATE(ASSET.DES)',
                                                            'ORD.TIPOLOGIALAVORAZIONE',
                                                            'ORD.TIPOLOGIASOTTOLAV',
                                                            q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'CODICE', 'SPLITTER')x',
                                                            q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD.BDS_ID, 'CODICE', 'MODEM')x',
                                                            'ASSET.CODICEORDINETI',
                                                            q'xPKG_ESTRAZIONI.VLAN_VALUE(ASSET.BDS_ID, 'COD_AREA_RACCOLTA')x',
                                                            q'xPKG_ESTRAZIONI.VLAN_VALUE(ASSET.BDS_ID, 'COD_MACRO_AREA')x',
                                                            'NULL',
                                                            'ASSET.IDRICHIESTAOLO',
                                                            'PKG_ESTRAZIONI.SET_DATE(RICH.DRO)',
                                                            'PKG_ESTRAZIONI.SET_DATE(ORD.DATAINVIOORDINEADELIVERY)',
                                                            'PKG_ESTRAZIONI.CODIFICA_STATO_RICHIESTA(RICH.STATORICHIESTANOW)',
                                                            'RICH.STATORICHIESTANOW',
                                                            'PKG_ESTRAZIONI.DATA_INVIO_BILLING(ASSET.IDRISORSA)'); --TBD

  EASYIP_RI_SELECT_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS ('ASSET.IDRISORSA',
                                                            'ASSET.CODIFICAOLOAGCOM',
                                                            'NULL',
                                                            'OFF.COD_OFFERTA_JPUB', -- SM_392 'TPL_CON.COD_CONTRATTO_JPUB',
                                                            'AGREE.COD_CONTRATTO',
                                                            q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ORD.BDS_ID, 'TIPO_LINEA')x',
                                                            q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ORD.BDS_ID, 'PROFILOTECNICOLINEA')x',
                                                            '2',
                                                            'OFF.IDTPLG_PAGAMENTO_ACCS', --q'xCASE UPPER(TO_CHAR(ORD.MODALITAFATTURAZIONE)) WHEN 'FLAT' THEN 1 WHEN 'LITE' THEN 2 WHEN 'HIGH LEVEL' THEN 3 ELSE NULL ENDx',
                                                            q'xCASE WHEN PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'TRASPORTO') IS NOT NULL THEN 1 ELSE 0 ENDx', -- SM_642
                                                            q'xPKG_ESTRAZIONI.MOD_FAT_TRASP(ASSET.BDS_ID, OFF.IDTPLG_PAGAMENTO_ACCS)x', -- OK MOD_FATT_TRASP
                                                            'PKG_ESTRAZIONI.SET_DATE(RICH.DRO)',
                                                            'PKG_ESTRAZIONI.SET_DATE(ASSET.DES)',
                                                            'PKG_ESTRAZIONI.SET_DATE(ASSET.DESPRIMOORDINE)',
                                                            'PKG_ESTRAZIONI.SET_DATE(ASSET.LASTUPDATE)',
                                                            'PKG_ESTRAZIONI.SET_DATE(ASSET.DES)',
                                                            'ORD.TIPOLOGIALAVORAZIONE',
                                                            'ORD.TIPOLOGIASOTTOLAV',
                                                            q'xPKG_ESTRAZIONI.VLAN_VALUE(ASSET.BDS_ID, 'COD_AREA_RACCOLTA')x',
                                                            q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ORD.BDS_ID, 'MODALITACONSEGNA')x',
                                                            q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD.BDS_ID, 'CODICE', 'SPLITTER')x',
                                                            'ASSET.CODICEORDINETI',
                                                            'NULL',
                                                            'ASSET.IDRICHIESTAOLO',
                                                            'PKG_ESTRAZIONI.SET_DATE(RICH.DRO)',
                                                            'PKG_ESTRAZIONI.SET_DATE(ORD.DATAINVIOORDINEADELIVERY)',
                                                            q'x'5'x', --OPZIONE_COMMERCIALE
                                                            'PKG_ESTRAZIONI.CODIFICA_STATO_RICHIESTA(RICH.STATORICHIESTANOW)',
                                                            'RICH.STATORICHIESTANOW',
                                                            'PKG_ESTRAZIONI.DATA_INVIO_BILLING(ASSET.IDRISORSA)');

  VULA_RI_SELECT_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS ('ASSET.IDRISORSA',
                                                            'ASSET.CODIFICAOLOAGCOM',
                                                            q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ORD.BDS_ID, 'TIPO_LINEA')x',
                                                            'OFF.IDTPLG_PAGAMENTO_ACCS', --q'xCASE UPPER(TO_CHAR(ORD.MODALITAFATTURAZIONE)) WHEN 'FLAT' THEN 1 WHEN 'LITE' THEN 2 WHEN 'HIGH LEVEL' THEN 3 ELSE NULL ENDx',
                                                            'OFF.COD_OFFERTA_JPUB', -- SM_392 'TPL_CON.COD_CONTRATTO_JPUB'
                                                            'AGREE.COD_CONTRATTO',
                                                            'CASE OFF.MODO_TRASFERIMENTO WHEN ' || kASIMMETRICO || ' THEN 15 WHEN ' || kSIMMETRICO || ' THEN 16 ELSE NULL END',
                                                            q'xCASE UPPER(PROF.MODELLO_ACCS) WHEN 'RATE ADAPTIVE' THEN 2 ELSE NULL ENDx',
                                                            q'xCASE PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD.BDS_ID, 'TECNOLOGIA') WHEN 'VSDL' THEN 'V' WHEN 'FTTH' THEN 'Z' ELSE NULL ENDx',
                                                            'ORD.CLLI',
                                                            q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'PROFILOTECNICOLINEA')x',
                                                            'PROF.PROFILO_COMMERCIALE_UP', --q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD.BDS_ID, 'PCRUP')x',
                                                            'PROF.PROFILO_COMMERCIALE_DOWN', --q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD.BDS_ID, 'PCRDOWN')x',
                                                            q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'ENCAPSULATION')x',
                                                            q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD.BDS_ID, 'USERVLAN1TAGGING')x',
                                                            'ASSET.NUMEROFITTIZIO',
                                                            q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'MODULAZIONE')x',
                                                            '1',
                                                            q'xPKG_ESTRAZIONI.VLAN_VALUE(ASSET.BDS_ID, 'COD_AREA_RACCOLTA')x',
                                                            q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ORD.BDS_ID, 'MODALITACONSEGNA')x',
                                                            '1',
                                                            'NULL',
                                                            'ASSET.IDRICHIESTAOLO',
                                                            'ASSET.CODICEORDINETI',
                                                            'PKG_ESTRAZIONI.SET_DATE(RICH.DRO)',
                                                            'PKG_ESTRAZIONI.SET_DATE(ASSET.DES)',
                                                            'PKG_ESTRAZIONI.SET_DATE(ASSET.DESPRIMOORDINE)',
                                                            'PKG_ESTRAZIONI.SET_DATE(ASSET.DES)',
                                                            'PKG_ESTRAZIONI.SET_DATE(RICH.DRO)',
                                                            'PKG_ESTRAZIONI.SET_DATE(ORD.DATAINVIOORDINEADELIVERY)',
                                                            'PKG_ESTRAZIONI.CODIFICA_STATO_RICHIESTA(RICH.STATORICHIESTANOW)',
                                                            'ORD.TIPOLOGIALAVORAZIONE',
                                                            'ORD.TIPOLOGIASOTTOLAV',
                                                            'RICH.STATORICHIESTANOW',
                                                            'ASSET.IDRISORSANOW',
                                                            q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ORD.BDS_ID, 'IDVLAN')x',
                                                            'PKG_ESTRAZIONI.DATA_INVIO_BILLING(ASSET.IDRISORSA)'); --TBD

  SISTINA_SELECT_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS ( q'x CASE PKG_ESTRAZIONI.GET_IDUTENTE_FINALE(ASSET.BDS_ID, 'SISTINA') WHEN 'POTS' THEN LPAD(ASSET.NUMEROTELEFONICO, 12, '0') WHEN 'LineaNonFonia' THEN LPAD(ASSET.NUMEROFITTIZIO, 12, '1') WHEN 'ISDN' THEN LPAD(ASSET.NUMEROFITTIZIO, 12, '1') WHEN 'LnF' THEN LPAD(ASSET.NUMEROFITTIZIO, 12, '1') ELSE ASSET.IDRISORSA ENDx', -- Utente Finale --SM_4572
                                             --PREDTAZIONALE      q'xPKG_ESTRAZIONI.CODE_AREA_RACC_DETT(DETT.BDS_ID, 'COD_KIT')x', -- Identificativo TD OLO
                                                             q'xPKG_ESTRAZIONI.CODE_AREA_RACC_DETT_SC(DETT.BDS_ID, 'COD_KIT')x', -- Identificativo TD OLO
                                                            'ASSET.CODIFICAOLOAGCOM', -- Codice gestore
                                                            q'xCASE WHEN ASSET.DESPRIMOORDINE IS NOT NULL THEN PKG_ESTRAZIONI.SET_DATE(ASSET.DESPRIMOORDINE,'YYYYMMDD') || '' || PKG_ESTRAZIONI.SET_DATE(ASSET.ORA_DES, 'HH24:MI:SS') ELSE NULL ENDx', -- Data Primo Noleggio --SM_5084
                                                            q'xPKG_ESTRAZIONI.SET_DATE(ASSET.DES,'YYYYMMDD') || '' || PKG_ESTRAZIONI.SET_DATE(ASSET.ORA_DES, 'HH24:MI:SS')x', -- Date Des --SM_5084
                                                            -- q'xPKG_ESTRAZIONI.SET_DATE(ASSET.DES) || ' ' || PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'ORADES')x', -- Date Des
                                                            q'xCASE WHEN TO_CHAR(ASSET.STATOASSET) = x' || DBMS_ASSERT.ENQUOTE_LITERAL(STATUS_CESSATO) || q'x THEN PKG_ESTRAZIONI.SET_DATE(ASSET.DES,'YYYYMMDD') || '' || PKG_ESTRAZIONI.SET_DATE(ASSET.ORA_DES, 'HH24:MI:SS') ELSE NULL ENDx', -- Date Cessazione --SM_5084
                                                            'ASSET.BDS_ID',
                                                            q'xCASE OFF.ID_OFFERTA WHEN 8 THEN 'BTS_FLAS' WHEN 9 THEN 'BTS_HLAS' WHEN 10 THEN 'BTS_LITE' WHEN 39 THEN 'BTS_FLSI' WHEN 40 THEN 'BTS_HLSI' ELSE NULL ENDx', -- Descrizione Servizio
                                                            q'xCASE OFF.IDTPLG_PAGAMENTO_ACCS WHEN 1 THEN 'F' WHEN 2 THEN 'C' WHEN 3 THEN 'C' ELSE NULL ENDx',--SM_10806  --q'xCASE UPPER(TO_CHAR(ORD.MODALITAFATTURAZIONE)) WHEN 'FLAT' THEN 'F' WHEN 'CONSUMO' THEN 'C' ELSE NULL ENDx',
                                                         -----SM_10906 q'xPKG_ESTRAZIONI.FLAG_TRASPORTO_INT(ASSET.BDS_ID, OFF.IDTPLG_PAGAMENTO_ACCS)x', --SM_642, -- Flag Trasporto Urbano
                                                            q'x(select case when ATTR.VALOREATTRIBUTO='PRESENTE' THEN case when OFF.IDTPLG_PAGAMENTO_ACCS='1' THEN 'F' when OFF.IDTPLG_PAGAMENTO_ACCS IN ('2', '3') THEN 'C' END END FROM APPUSER.BDS_1_CASEDATA_ATTRIBTDTTGLSST ATTR where ATTR.NOMEATTRIBUTO = 'TRASPORTO' AND ATTR.DTTGLSST_TTRBTIDTTGLISST_BDSID = DETT.BDS_ID  and rownum<2)x', --SM_10906, -- Flag Trasporto Urbano --CS_871
                                         --Pretazionale                   q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'TIPOPROFILOVC')x', -- Classe Servizio
                                                             q'x(SELECT VALOREATTRIBUTO FROM BDS_1_CASEDATA_ATTRIBTDTTGLSST ATTPV
                                                                JOIN BDS_1_CASEDATA_DETTAGLIOASSET DETTPV ON ATTPV.DTTGLSST_TTRBTIDTTGLISST_BDSID = DETTPV.BDS_ID
                                                                  WHERE DETTPV.BDS_ID = DETT.BDS_ID
                                                                  AND ATTPV.NOMEATTRIBUTO = 'TIPOPROFILOVC' and rownum <2)x', -- Classe Servizio
                                                            --PRESTAZIONALE q'x(SELECT PCR_DOWN FROM PROFILO_VC WHERE ID_PRFL_VC = RTRIM(PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'IDPROFILOVC'), '.0')  and rownum<2)x', -- Velocita accesso utente finale CS_871
                                                            q'x (SELECT prfvc.PCR_DOWN FROM PROFILO_VC  prfvc, BDS_1_CASEDATA_ATTRIBTDTTGLSST ATT
                                                                        WHERE prfvc.ID_PRFL_VC = rtrim(ATT.VALOREATTRIBUTO,'.0')
                                                                        AND ATT.DTTGLSST_TTRBTIDTTGLISST_BDSID=DETT.BDS_ID AND ATT.NOMEATTRIBUTO = 'IDPROFILOVC' and rownum < 2)x',-- Velocita accesso utente finale
                                                            q'xCASE PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'TIPOPROTOCOLLO','PROTOCOLLO') WHEN 'FR' THEN 'FR' ELSE 'ATM' ENDx', --SM_5646
                                                            --q'x'ATM'x', -- Protocollo ?utente finale --SM_5646
                                                            q'xCASE OFF.MODO_TRASFERIMENTO WHEN 'SIMMETRICO' THEN PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'DLCI') ELSE NULL ENDx', -- DLCI utente finale
                                                             -- q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'VPI')x', -- VPI SM_5171
                                                          ---- SM_10778 q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'VPI','ATMVC')x', -- VPI SM_5171
                                                            q'x(select ATTR.VALOREATTRIBUTO FROM APPUSER.BDS_1_CASEDATA_ATTRIBTDTTGLSST ATTR where ATTR.NOMEATTRIBUTO = 'VPI' AND ATTR.DTTGLSST_TTRBTIDTTGLISST_BDSID = DETT.BDS_ID and rownum<2)x',
                                                               -- q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'VCI')x', -- VCI SM_5171
                                                          ---- SM_10778 q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'VCI','ATMVC')x', -- VCI SM_5171
                                                            q'x(select ATTR.VALOREATTRIBUTO FROM APPUSER.BDS_1_CASEDATA_ATTRIBTDTTGLSST ATTR where ATTR.NOMEATTRIBUTO = 'VCI' AND ATTR.DTTGLSST_TTRBTIDTTGLISST_BDSID = DETT.BDS_ID and rownum<2)x',
                                         --PREDTAZIONALE              q'xPKG_ESTRAZIONI.BANDA_UTENTE_FINALE(DETT.BDS_ID, ORD.BDS_ID, ASSET.BDS_ID, OFF.ID_OFFERTA, 'BandaUtenteFinale')x', -- Banda Utente Finale
                                                            q'xPKG_ESTRAZIONI.BANDA_UTENTE_FINALE_SC(DETT.BDS_ID, ORD.BDS_ID, ASSET.BDS_ID, OFF.ID_OFFERTA, 'BandaUtenteFinale')x', -- Banda Utente Finale
                                         --PREDTAZIONALE               q'xPKG_ESTRAZIONI.BANDA_UTENTE_FINALE(DETT.BDS_ID, ORD.BDS_ID, ASSET.BDS_ID, OFF.ID_OFFERTA, 'VelocitaAccessoOLO')x', -- Velocita Accesso OLO
                                                            q'xPKG_ESTRAZIONI.BANDA_UTENTE_FINALE_SC(DETT.BDS_ID, ORD.BDS_ID, ASSET.BDS_ID, OFF.ID_OFFERTA, 'VelocitaAccessoOLO')x', -- Velocita Accesso OLO
                                                            q'xPKG_ESTRAZIONI.CODE_AREA_RACC(ASSET.BDS_ID, 'COD_AREA_RACCOLTA')x', -- Area di Raccolta
                                                              --q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'VPI')x', -- VPI OLO  SM_5171
                                                          ----- SM_10778 q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'VPISP','ATMVC')x', -- VPI OLO SM_5171
                                                            q'x(select ATTR.VALOREATTRIBUTO FROM APPUSER.BDS_1_CASEDATA_ATTRIBTDTTGLSST ATTR where ATTR.NOMEATTRIBUTO = 'VPISP' AND ATTR.DTTGLSST_TTRBTIDTTGLISST_BDSID = DETT.BDS_ID  and rownum<2)x',
                                                            --q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'VCIRETE')x',   -- VCI OLO SM_5171
                                                          ---- SM_10778 q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'VCISP','ATMVC')x', -- VCI OLO SM_5171
                                                            q'x(select ATTR.VALOREATTRIBUTO FROM APPUSER.BDS_1_CASEDATA_ATTRIBTDTTGLSST ATTR where ATTR.NOMEATTRIBUTO = 'VCISP' AND ATTR.DTTGLSST_TTRBTIDTTGLISST_BDSID = DETT.BDS_ID and rownum<2)x',
                                           --PREDTAZIONALE                 --q'xPKG_ESTRAZIONI.BANDA_UTENTE_FINALE(DETT.BDS_ID, ORD.BDS_ID, ASSET.BDS_ID, OFF.ID_OFFERTA, 'BandaOLO')x', -- Banda OLO
                                                            q'xPKG_ESTRAZIONI.BANDA_UTENTE_FINALE_SC(DETT.BDS_ID, ORD.BDS_ID, ASSET.BDS_ID, OFF.ID_OFFERTA, 'BandaOLO')x', -- Banda OLO
                                                            'ORD.CODICEPROGETTO', -- Codice Progetto
                                                            'ASSET.CLLI', -- Codice CLLI
                                                            'ASSET.IDRISORSA', -- Desc_id_XDSL
                                                            q'xPKG_ESTRAZIONI.CODE_AREA_RACC(ASSET.BDS_ID, 'COD_AREA_RACCOLTA')x', -- Area di Raccolta KdC
                                                            'NULL');

  REGIA0_GIACENZE_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS ('DETT.IDDETTAGLIOORDINE',
                                                             'ASSET.CODIFICAOLOAGCOMDONOR',
                                                             'ASSET.CODIFICAOLOAGCOMDONATING',
                                                             'ASSET.CODIFICAOLOAGCOMDONATING',
                                                             'ORD.BDS_ID',
                                                             'ORD.IDRISORSA',
                                                             'ORD.IDRICHIESTAOLO',
                                                             'ORD.NUMTELPRINCIPALE', -- Cristiano x S6
                                                             'NULL',
                                                             'ORD.CODICEORDINETI',
                                                             'ORD.CODICEORDINEOLO',
                                                             'ORD.CODICEPROGETTO',
                                                             q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD.BDS_ID, 'CODICEPIATTAFORMA')x',
                                                             'ORD.OFFERTA',
                                                             'NULL', -- fuori ambito (TIPO_DN)
                                                             q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD.BDS_ID, 'TIPOLINEANP','NUMBERPORTABILITY')x', -- TIPO LINEA
                                                             q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD.BDS_ID, 'FLAGNUMERAZIONIAGGIUNTIVE','NUMBERPORTABILITY')x', -- FLAG_AGGIUNTIVI_NP
                                                             'NULL', -- QUANTITA_LINEE
                                                             'CAUS.ID_ANAG_CAUS', -- CODE_CAUSALE_TI
                                                             'CAUS.DESCR_CAUS_INTERNO', -- DESCRIZIONE_CAUSALE_TI
                                                             'CAUS.ID_ANAG_CAUS', -- CODE_CAUSALE_OLO
                                                             'CAUS.DESCR_CAUS_OLO', -- DESCRIZIONE_CAUSALE_OLO
                                                             'CAUS.ID_ANAG_CAUS', -- CAUSALE_ORDINE
                                                             '(SELECT IDTPLG_EVENTO FROM EVENTO_ORDN_NOW_WHLS EVENT WHERE EVENT.ID_EVENTO_ORDN_NOW_WHLS = PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO))', -- TIPO_CAUSALE_ORDINE
                                                             'NULL', -- RIENTRO_IN_TI
                                                             'NULL', -- GIORNI_DAL_ARRIVO
                                                             'NULL', -- GIORNI_DAL_CAMBIO_STATO
                                                             'PKG_ESTRAZIONI.SET_DATE((SELECT TIMSTP_INSMTO_EVENTO FROM EVENTO_ORDN_NOW_WHLS EVENT WHERE EVENT.ID_EVENTO_ORDN_NOW_WHLS = PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO)))', -- DATA_ACQUISIZIONE_ORDINE
                                                             'PKG_ESTRAZIONI.SET_DATE(RICH.DRO)',
                                                             'PKG_ESTRAZIONI.SET_DATE(ORD.DAC)',
                                                             'PKG_ESTRAZIONI.SET_DATE(ORD.DACRIMODULATA)',
                                                             'NULL', -- NUMERO_DI_RIMODULAZIONI
                                                             'PKG_ESTRAZIONI.SET_DATE((SELECT TIMSTP_INSMTO_EVENTO FROM EVENTO_ORDN_NOW_WHLS EVENT WHERE EVENT.ID_EVENTO_ORDN_NOW_WHLS = PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO)))', -- DATA_ACCETTAZIONE_ORDINE
                                                             'NULL', -- PRESENZA_DI_NP
                                                             'NULL', -- CODICE_OL_RETAIL
                                                             'ORD.NOME',
                                                             'ORD.COGNOMERAGIONESOCIALE', -- COGNOME_RAG_SOC
                                                             'ORD.CF', -- CF_PIVA
                                                             'NULL', -- fuori ambito (NUMERAZIONE_VOIP)
                                                             q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ORDINE(ORD.BDS_ID, 'ROUTINGNUMBER', 'NUMBERPORTABILITY')x', -- ROUTING_NUMBER
                                                             '(SELECT COD_GAT FROM CLC_IDULLCO CLC WHERE CLC.IDULLCO = ORD.IDULLCO FETCH FIRST ROW ONLY)', -- CODICE_SEDE_GAT il fetch first row only ? messo per bypassare il problema in System Test dei record doppi
                                                             'NULL', -- SCENARIO_LAVORAZIONE
                                                             'CL_CURRENT_FILE_NAME',
                                                             'AGREE.FLAG_NPD', -- NPD_FLAG
                                                             'ORD.IDRICHIESTAOLO', -- ID_OL
                                                             'RICH.IDPACCHETTONOW', -- ID_PACCHETTO
                                                             '(SELECT LAV.IDTPLG_RICH_COMSTOLO FROM LAVRZ_APPLBLE_ORDN LAV WHERE LAV.ID_LAVRZ_APPLBLE_ORDN = (SELECT ID_LAVRZ_APPLBLE_ORDN FROM EVENTO_ORDN_NOW_WHLS EVENT WHERE EVENT.ID_EVENTO_ORDN_NOW_WHLS = PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO)))', -- STATO_OLO
                                                             '(SELECT IDTPLG_EVENTO FROM EVENTO_ORDN_NOW_WHLS EVENT WHERE EVENT.ID_EVENTO_ORDN_NOW_WHLS = PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO))', -- STATO_TECNICO
                                                             'NULL', -- fuori ambito (ID_CRM)
                                                              q'xPKG_ESTRAZIONI.DATA_INVIO_RICHIESTA(ORD.IDRICHIESTAOLO, PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO), 'EMISSIONE')x', -- DATA_INVIO_SCF_001
                                                              q'xPKG_ESTRAZIONI.DATA_INVIO_RICHIESTA(ORD.IDRICHIESTAOLO, PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO), 'NI_VERIFICA_TECNICA_E_TOPONOMASTICA')x', -- DATA_RITORNO_SCF_001
                                                              q'xPKG_ESTRAZIONI.DATA_INVIO_RICHIESTA(ORD.IDRICHIESTAOLO, PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO), 'EMISSIONE')x', -- DATA_INVIO_SCF_003
                                                              q'xPKG_ESTRAZIONI.DATA_INVIO_RICHIESTA(ORD.IDRICHIESTAOLO, PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO), 'NF_ESPLETAMENTO_TECNICO')x', -- DATA_RITORNO_SCF_003
                                                              q'xPKG_ESTRAZIONI.DATA_INVIO_RICHIESTA(ORD.IDRICHIESTAOLO, PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO), 'EMISSIONE')x', -- DATA_INVIO_SCF_002
                                                              q'xPKG_ESTRAZIONI.DATA_INVIO_RICHIESTA(ORD.IDRICHIESTAOLO, PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO), 'NI_VERIFICATECNICA_E_TOPONOMASTICA')x', -- DATA_RITORNO_SCF_002
                                                              q'xPKG_ESTRAZIONI.DATA_INVIO_RICHIESTA(ORD.IDRICHIESTAOLO, PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO), 'EMISSIONE')x', -- DATA_INVIO_SCF_007
                                                              q'xPKG_ESTRAZIONI.DATA_INVIO_RICHIESTA(ORD.IDRICHIESTAOLO, PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO), 'NF_ESPLETAMENT_TECNICO')x', -- DATA_RITORNO_SCF_007
                                                              'NULL', -- fuori ambito (DATA_INVIO_SCF_O_013)
                                                              'NULL', -- fuori ambito (DATA_INVIO_SCF_O_008)
                                                              q'xPKG_ESTRAZIONI.DATA_INVIO_RICHIESTA(ORD.IDRICHIESTAOLO, PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO), 'RIMODULAZIONE')x', -- DATA_INVIO_SCF_010
                                                              q'xPKG_ESTRAZIONI.DATA_INVIO_RICHIESTA(ORD.IDRICHIESTAOLO, PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO), 'NI_RIMODULAZIONE_DAC')x', -- DATA_RITORNO_SCF_010
                                                              'NULL', -- N.A. (DATA_INVIO_SCF_011)
                                                              'NULL', -- N.A. (DATA_RITORNO_SCF_011)
                                                              q'xPKG_ESTRAZIONI.DATA_INVIO_RICHIESTA(ORD.IDRICHIESTAOLO, PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO), 'NI_MODULAZIONE')x', -- DATA_INVIO_SCF_009
                                                              q'xPKG_ESTRAZIONI.DATA_INVIO_RICHIESTA(ORD.IDRICHIESTAOLO, PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO), 'NI_RIMODULAZIONE_DAC')x', -- DATA_RITORNO_SCF_009
                                                              q'xPKG_ESTRAZIONI.DATA_INVIO_RICHIESTA(ORD.IDRICHIESTAOLO, PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO), 'NI_DISPACCIATO_MOI/MOS')x', -- DATA_R_DISP_MOI
                                                              q'xPKG_ESTRAZIONI.DATA_INVIO_RICHIESTA(ORD.IDRICHIESTAOLO, PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO), 'NI_PRESA_APPUNTAMENTO')x', -- DATA_R_PRESA_APP
                                                              'NULL', -- N.A. (HUB_Data Inizio SOSPENSIONE)
                                                              q'xPKG_ESTRAZIONI.DATA_INVIO_RICHIESTA(ORD.IDRICHIESTAOLO, PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO), 'NI_SOSPENSIONE')x', -- DATA_R__SOSP
                                                              q'xPKG_ESTRAZIONI.DATA_INVIO_RICHIESTA(ORD.IDRICHIESTAOLO, PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO), 'NI_FINE_TENTATIVO_CONTATTO')x', -- DATA_R_TENT_DI_CHM
                                                              q'xPKG_ESTRAZIONI.DATA_INVIO_RICHIESTA(ORD.IDRICHIESTAOLO, PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO), 'NI_ACCODAMENTO/NI_RIMODULAZIONE_DPR')x', -- DATA_R_ACCODAMENTO
                                                              q'xPKG_ESTRAZIONI.DATA_INVIO_RICHIESTA(ORD.IDRICHIESTAOLO, PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO), 'NF_CONFERMA_ANNULLAMENTO')x', -- DATA_R_ANN_RETE
                                                              q'xPKG_ESTRAZIONI.DATA_INVIO_RICHIESTA(ORD.IDRICHIESTAOLO, PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO), 'NI_ACCODAMENTO/NI_RIMODULAZIONE_DPR')x', -- DATA_R_RIMODULAZIONE_DPNR
                                                              q'xPKG_ESTRAZIONI.DATA_INVIO_RICHIESTA(ORD.IDRICHIESTAOLO, PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO), 'NI_DISPACCIATO_MOI/MOS')x', -- DATA_R_OP_SPE_EPA
                                                              q'xPKG_ESTRAZIONI.DATA_INVIO_RICHIESTA(ORD.IDRICHIESTAOLO, PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO), 'NI_DISPACCIATO_MOI/MOS')x', -- DATA_R_OP_SPE_OPA
                                                              q'xPKG_ESTRAZIONI.DATA_INVIO_RICHIESTA(ORD.IDRICHIESTAOLO, PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO), 'NF_ESPLETAMENTO_TECNICO')x', -- DATA_RITORNO_EMISSIONE
                                                              q'xPKG_ESTRAZIONI.DATA_INVIO_RICHIESTA(ORD.IDRICHIESTAOLO, PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO), 'NI_VERIFICA_TECNICA_E_TOPONOMASTICA')x', -- DATA_R_IN_CARICO_DELIVERY
                                                              q'xPKG_ESTRAZIONI.DATA_INVIO_RICHIESTA(ORD.IDRICHIESTAOLO, PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO), 'NI_DISPACCIATO_MOI/MOS')x', -- DATA_R_DISP_A_MOS
                                                              q'xPKG_ESTRAZIONI.DATA_INVIO_RICHIESTA(ORD.IDRICHIESTAOLO, PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO), 'NF_ESPLETAMENTO_TECNICO')x', -- DATA_INVIO_EFD
                                                              q'xPKG_ESTRAZIONI.DATA_INVIO_RICHIESTA(ORD.IDRICHIESTAOLO, PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO), 'NI_VERIFICA_TECNICA_E_TOPONOMASTICA')x', -- DATA_RITORNO_EFD
                                                              'NULL', -- fuori ambito (DATA_ELAB_LAV_MAN)
                                                              'NULL');


    REGIA0_KO_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS ('ORD.CODICEORDINEOLO',
                                                        'OLO.COD_OLO',
                                                        'ORD.TIPOLOGIALAVORAZIONE',
                                                        'RICH.IDANAGRAFICACAUSALE',
                                                        'TRO.NOME_OFFERTA_ESTERNA', --SM 2129
                                                        --'CASE OFF.ID_FAMIG_OFFERTA WHEN ' || FAMIGLIA_REGOLATORIO || q'x THEN PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ORD.BDS_ID, 'DESTINAZIONEUSO') ELSE PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ORD.BDS_ID, 'TIPOLINEA') ENDx',  --SM 2129
                                                        'NULL',
                                                        'ORD.IDRISORSA',
                                                        'ORD.NUMTELPRINCIPALE',
                                                        'ORD.NUMEROTELEFONICO',
                                                        'RICH.IDANAGRAFICACAUSALE', --stato rich now
                                                        'CAUS.DESCR_CAUS_INTERNO',  -- cod causale
                                                        'RICH.IDANAGRAFICACAUSALE', --
                                                        'CAUS.DESCR_CAUS_OLO',
                                                        'PKG_ESTRAZIONI.SET_DATE(RICH.DRO)',
                                                        'PKG_ESTRAZIONI.SET_DATE(ORD.DAC)',
                                                        'PKG_ESTRAZIONI.SET_DATE(ORD.LASTUPDATE)',
                                                        q'xPKG_ESTRAZIONI.DATA_INVIO_RICHIESTA(ORD.IDRICHIESTAOLO, PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO), 'NI_VERIFICA_TECNICA_E_TOPONOMASTICA')x',   --SM 2129
                                                        q'xPKG_ESTRAZIONI.DATA_INVIO_RICHIESTA(ORD.IDRICHIESTAOLO, PKG_ESTRAZIONI.ID_EVENTO_NOW(RICH.IDRICHIESTAOLO), 'NI_VERIFICA_TECNICA_E_TOPONOMASTICA')x',   --SM 2129
                                                        'RICH.TIPOLOGIASCENARIO',
                                                        'RICH.AMBITO');


     ULISSE_F1_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS ('ASSET.CODIFICAOLOAGCOM',
                                                          'OLO.COD_OLO',
                                                          'OLO.NOME',
                                                          q'xCASE OFF.MODO_TRASFERIMENTO WHEN 'ASIMMETRICO' THEN 39 ELSE 40 ENDx',
                                                          q'xCASE PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'TIPOBANDACONSEGNA') WHEN 'CONDIVISA' THEN CASE PKG_ESTRAZIONI.VP_VALUE(ASSET.BDS_ID, 'TIPO') WHEN 'Standard' THEN 25 WHEN 'Special' THEN 26 WHEN 'Lite' THEN 27 Else Null END WHEN 'DEDICATA' THEN Null ENDx', -- CODE_TIPO_OFFERTA SM_4022
                                                          q'xCASE ASSET.IDOFFERTA WHEN 8 THEN '0' WHEN 9 THEN '1' WHEN 10 THEN '1' WHEN 39 THEN '0' WHEN 40 THEN '1' ELSE NULL ENDx', -- (6) FLAG BILLING S7  -- SM_4066
                                                          'TSO_OUT.NOME_OFFERTA_ESTERNA', -- (7) Tipo Offerta Commerciale S7
                                                          q'x(SELECT DTU.DESCR FROM TIPOLG_OFFERTA_DTU DTU WHERE DTU.ID_NOME_OFFERTA_DTU = OFF.ID_NOME_OFFERTA_DTU)x',
                                                          --q'x'ATM'x', -- sm 2220
                                                          q'xCASE PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'PROFILOTECNICOLINEA','ProtocolloUF') WHEN 'FR' THEN 'FR' ELSE 'ATM' ENDx', --SM_5646
                                                         -- q'xDECODE(UPPER(OFF.MODO_TRASFERIMENTO),'ASIMMETRICO','ATM','FR')x', --Protocollo UF
                                                          'NULL',
                                                          q'x PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'CODICEVP','ATMVC') x', -- cristiano COD_VP --SM_4022
                                                          q'x PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'VPI','ATMVC') x', -- Cristiano VPI --SM_4022
                                                          q'xPKG_ESTRAZIONI.CODE_AREA_RACC(ASSET.BDS_ID, 'COD_AREA_RACCOLTA')x', -- CODE_AREA SM_2746
                                                          q'xPKG_ESTRAZIONI.CODE_AREA_RACC(ASSET.BDS_ID, 'DESC_AREA_RACCOLTA')x', -- DESC_AREA SM_2746
                                                          'PKG_ESTRAZIONI.GET_FLAG_TRASPORTO(ASSET.OFFERTA, ASSET.BDS_ID)', -- FLAG_TRASPORTO
                                                          q'xCASE WHEN OFF.ID_OFFERTA IN (8, 9, 10) THEN decode(instr(ASSET.IDRISORSA,'W'),0, ASSET.IDRISORSA, trim(substr(ASSET.IDRISORSA,1,instr(ASSET.IDRISORSA,'W')-1))) ELSE NULL ENDx', --TGU UF (SM_5197)
                                                          q'xCASE WHEN OFF.ID_OFFERTA IN (39, 40) THEN ASSET.IDRISORSA ELSE NULL ENDx', --TD UF (SM_5197)
                                                          q'xCASE PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'TIPOBANDACONSEGNA') WHEN 'DEDICATA' THEN PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'CODICETD','ATMVC') WHEN 'CONDIVISA' THEN Null ENDx', -- TD_OLO SM_2746
                                                          'ASSET.IDASSET', -- CODICE XDSL
                                                          q'xPKG_ESTRAZIONI.GET_STATI_F1_TD (RICH.IDRISORSA, 'STATO_UTENZA')x', --TBD STATO UTENZA -- SM_6018
                                                          'CASE WHEN ASSET.CODICETOPONOMASTICA IS NULL AND ASSET.COMUNE IS NULL THEN ASSET.LOCALITA WHEN ASSET.CODICETOPONOMASTICA IS NULL THEN ASSET.COMUNE ELSE TO_NCHAR(PKG_ESTRAZIONI.GET_COMUNE (ASSET.CODICETOPONOMASTICA)) END', -- CODICE COMUNE (21)
                                                          q'xPKG_ESTRAZIONI.SET_DATE(ASSET.DES)x', --DES
                                                          q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'TIPOPROFILOVC')x', --CLASSE DI SERVIZIO
                                                          q'xCASE WHEN PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'TIPOPROFILOVC')='VBR' THEN DECODE(PROF_VC.SCR_DOWN,150,'A',300,'B',600,'C',1200,'D',37.5,'E',200,'F',400,'G',1600,'H',3200,'I') ELSE NULL ENDx',-- Profilo VBR ESTENSIONE SIMMETRICI S7
                                                          q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'DLCI')x', --DLCI ESTENSIONE SIMMETRICI S7
                                                          q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'VCI')x',
                                                          q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'VPI')x',
                                                          q'xPROF_VC.MCR_DOWNx',
                                                          q'xPROF_VC.MCR_UPx',
                                                          q'xPROF_VC.PCR_DOWNx',
                                                          q'xPROF_VC.PCR_UPx',
                                                          q'xPROF_VC.SCR_DOWNx',
                                                          q'xPROF_VC.SCR_UPx',
                                                          q'xPKG_ESTRAZIONI.GET_STATI_F1_TD (RICH.IDRISORSA, 'CODE_STATO_PS_ULL_OFFERTA')x', -- CODE_STATO_PS_ULL_OFFERTA (34)  -- SM_6018
                                                           q'xPKG_ESTRAZIONI.GET_STATI_F1_TD (RICH.IDRISORSA, 'CODE_STATO_PS_ULL_LINEA')x', -- CODE_STATO_PS_ULL_LINEA (35) -- SM_6018
                                                          q'x'1'x', -- CODE_STATO_PS_ULL_LOTTO -- SM_6018
                                                          'ASSET.IDRISORSA',
                                                          'ASSET.CLLI',
                                                          'ORD.CODICEPROGETTO',
                                                          q'x'ND'x', -- CODE_VPI_VCI
                                                          q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'VPI')x', -- SM_4435   'AN_VP.VPI',-- VALO_VPI_OLO
                                                          q'xPKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'VCI')x',--VALO_VCI_OLO
                                                          q'x'ND'x',--CODE_DLCI
                                                          q'xCASE (PROF_VC.PCR_DOWN / 1024) WHEN 0 THEN '1' ELSE TO_CHAR(ROUND (PROF_VC.PCR_DOWN / 1024)) ENDx',--VALO_CAPAC_TRASM_MBITS
                                                          q'xCASE OFF.ID_OFFERTA WHEN 8 THEN 'BTS_FLAS' WHEN 10 THEN 'BTS_LITE' WHEN 9 THEN 'BTS_HLAS' WHEN 39 THEN 'BTS_FLSI' WHEN 40 THEN 'BTS_HLSI' ELSE NULL ENDx', --TIPO_SERVIZIO
                                                          q'xCASE PKG_ESTRAZIONI.GET_FLAG_TRASPORTO(ASSET.OFFERTA, ASSET.BDS_ID) WHEN 0 THEN 0 WHEN 1 THEN CASE WHEN UPPER(ASSET.OFFERTA) IN ('BITSTREAMATMASIMMETRICOHL', 'BITSTREAMATMASIMMETRICOLITE','BITSTREAMATMSIMMETRICOHL') THEN 1 WHEN UPPER(ASSET.OFFERTA) IN ('BITSTREAMATMASIMMETRICOFLAT', 'BITSTREAMGBEASIMMETRICOFLAT','BITSTREAMATMSIMMETRICOFLAT','BITSTREAMGBESIMMETRICOFLAT') THEN 2 ELSE NULL END ENDx', -- FLAG_TRAFFICO ESTENSIONE SIMMETRICI S7
                                                          q'xCASE WHEN PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(DETT.BDS_ID, 'TIPOPROFILOVC')='VBR' THEN DECODE(PROF_VC.SCR_DOWN,150,'A',300,'B',600,'C',1200,'D',37.5,'E',200,'F',400,'G',1600,'H',3200,'I') ELSE NULL ENDx', --UF_PREFISSO ESTENSIONE SIMMETRICI S7
                                                          'NULL'); -- per separatore anche in ultima posizione


    OPERA_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS(q'xTO_DATE(TO_CHAR(SYSDATE, 'YYYYMM') || '01', 'YYYYMMDD')x', -- DATA FOTO
                                                    'NVL(ASSET.CODICEORDINETI, ASSET.CODICEORDINEOLO)', -- CODICE ORDINE TI
                                                    'ASSET.CODIFICAOLOAGCOM', -- CODIFICA OLO AGCOM
                                                    q'xCASE WHEN ASSET.DISTRETTO IS NOT NULL AND LENGTH(TRIM(TRANSLATE(ASSET.DISTRETTO,'0123456789', ' '))) IS NULL THEN '0' || TO_NUMBER (ASSET.DISTRETTO) ELSE NULL ENDx', -- DISTRETTO
                                                    'ATTR1.VALOREATTRIBUTO', -- TIPO LINEA
                                                    'ASSET.IDRISORSANOW', -- ID RISORSA NOW
                                                    'ASSET.IDRISORSA', -- ID RISORSA
                                                    'ASSET.STATOASSET', -- DESCRIZIONE STATO ASSET
                                                    'ASSET.LASTUPDATE', -- TIMESTAMP AGGIORNAMENTO ASSET
                                                    'ASSET.DESPRIMOORDINE', -- DES PRIMO ORDINE
                                                    q'xCASE WHEN ASSET.STATOASSET = 'CESSATO' THEN ASSET.DES ELSE NULL ENDx', -- DES CESSAZIONE
                                                    'OFF.OFFERTA', -- OFFERTA
                                                    'OFF.ID_OFFERTA', -- IDENTIFICATIVO OFFERTA
                                                    'ASSET.CLLI', -- CLLI
                                                    'ASSET.NUMEROFITTIZIO', -- NUMERO FITTIZIO
                                                    'CENTR.ADC', -- ADC
                                                    'OLO.COD_OLO', -- CODICE OLO NUMERICO
                                                    'ASSET.DES', -- DES
                                                    'ASSET.NUMEROTELEFONICO', -- NUMERO TELEFONICO
                                                    q'xCASE WHEN OFF.STRUTTURA_RICH = 'NPG' THEN 'NPG' WHEN OFF.STRUTTURA_RICH = 'NGA' OR OFF.STRUTTURA_RICH = 'XDSL' THEN 'DATI' WHEN OFF.STRUTTURA_RICH = 'REGOLATORIO' AND OFF.OFFERTA LIKE 'WLR%' THEN 'WLR' ELSE 'RAME' ENDx', -- TIPOLOGIA FLUSSO
                                                    'ATTR2.VALOREATTRIBUTO', -- CODE_CENTRALE_ACLRR
                                                    'CENTR.GAT', -- CODICE GAT
                                                    q'xCASE WHEN ASSET.OPZIONEDINAMICA IS NOT NULL THEN 'Y' ENDx');

--------- RU_371 INIZIO
      SISTINA_VULL_NOT_NULL_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS (q'xRPAD(ASSET.IDRISORSA, 12, ' ')x',                        -- NUMERAZIONE
                                                                       q'xTO_CHAR(ASSET.DESPRIMOORDINE, 'dd/mm/yyyy')x',           -- DATA ATTIVAZIONE SERVIZIO
                                                                       'CASE WHEN ASSET.STATOASSET  = '''||STATUS_CESSATO||''' THEN TO_CHAR(ASSET.DES, ''dd/mm/yyyy'') ELSE ''31/12/2999'' END',  -- SM_4365   -- DATA CHIUSURA SERVIZIO
                                                                       q'xRPAD(ASSET.CODIFICAOLOAGCOM, 3, ' ')x',                  -- OPERATORE
                                                                       q'xRPAD(NVL(CLIENTE.CODICEFISCALE, ' '), 16, ' ')x',        -- CODICE FISCALE
                                                                       q'xRPAD(NVL(CLIENTE.PARTITAIVA, ' '), 11, ' ')x',           -- PARTITA IVA
                                                                       q'xRPAD(NVL(CLIENTE.COGNOMERAGIONESOCIALE, ' '), 60, ' ')x' -- RAGIONE SOCIALE - COGNOME
                                                                       );
      SISTINA_VULL_NULL_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS     ( 'SYSTIMESTAMP',
                                                                       'ASSET.IDRISORSA',
                                                                       'ASSET.IDRISORSA||ASSET.DESPRIMOORDINE||ASSET.DES||ASSET.CODIFICAOLOAGCOM||CLIENTE.CODICEFISCALE||CLIENTE.PARTITAIVA||CLIENTE.COGNOMERAGIONESOCIALE',
                                                                        q'xDECODE(ASSET.IDRISORSA,Null,'MISSING MANDATORY FIELD:NUMERAZIONE ',Null)||DECODE(ASSET.DESPRIMOORDINE,Null,'MISSING MANDATORY FIELD:DATA ATTIVAZIONE SERVIZIO ',Null)||DECODE(ASSET.DES,Null,'MISSING MANDATORY FIELD:DATA CHIUSURA SERVIZIO ',Null)||DECODE(ASSET.CODIFICAOLOAGCOM,Null,'MISSING MANDATORY FIELD:OPERATORE ',Null)||DECODE(CLIENTE.CODICEFISCALE,Null,'MISSING MANDATORY FIELD:CODICE FISCALE ',Null)||DECODE(CLIENTE.PARTITAIVA,Null,'MISSING MANDATORY FIELD:PARTITA IVA ',Null)||DECODE(CLIENTE.COGNOMERAGIONESOCIALE,Null,'MISSING MANDATORY FIELD:RAGIONE SOCIALE ',Null)x'
                                                                       );
--------- RU_371 FINE
-- ANDREA GARAVINI
 -- 18/08/2016
 -- LOTTO4

    /* Sostituito per CS_576
    UTENTI_INATT_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS ('PORTAFOGLIO_CLIENTE.CODFC_OLO_AGCOM','UTENTE.USERID');
    */
    --CS_576
    UTENTI_INATT_COLS T_SELECT_COLUMNS := T_SELECT_COLUMNS ('USER_ALIAS','COGNOME','NOME','COD_PROFILO',q'xTO_CHAR( MAX_ACCESSO, 'DD/MM/YYYY')x');


--/ ANDREA GARAVINI

  BEGIN

    BEGIN
      SELECT DIRECTORY_PATH || '/'
        INTO DEFAULT_DIR
      FROM ALL_DIRECTORIES
      WHERE DIRECTORY_NAME = DEFAULT_DIR_OBJECT;
    EXCEPTION
      WHEN NO_DATA_FOUND THEN
        DEFAULT_DIR := NULL;
    END;

    -- BUILD SERVICE MAP FOR ASSET SPOOL
    SERVICE_MAP(SERVICE_ULL)        := T_IDS_OFFERTA(1, 2, 27, 30);
    SERVICE_MAP(SERVICE_ULLD)       := T_IDS_OFFERTA(3, 4, 28, 31);
    SERVICE_MAP(SERVICE_SLU)        := T_IDS_OFFERTA(5, 6, 29, 34);
    SERVICE_MAP(SERVICE_BSATM)      := T_IDS_OFFERTA(8, 9, 10,39,40); -- AGGIUNTO 39 e 40 S7 BTS ATM SIMMETRICI
    SERVICE_MAP(SERVICE_BSGBE)      := T_IDS_OFFERTA(7, 15, 16, 17, 18, 41); -- AGGIUNTO 41 S7 BTS GBE SIMMETRICI
    SERVICE_MAP(SERVICE_BTS)        := T_IDS_OFFERTA(7, 8, 9, 10);
    SERVICE_MAP(SERVICE_EASYIP)     := T_IDS_OFFERTA(11, 12, 13, 14);
    SERVICE_MAP(VC_ATM)             := T_IDS_OFFERTA(8, 9, 10,39,40);  -- AGGIUNTO 39 e 40 S7 BTS ATM SIMMETRICI
    SERVICE_MAP(VC_VLAN)            := T_IDS_OFFERTA(7, 15, 16, 17, 18, 41); -- AGGIUNTO 41 S7 BTS GBE SIMMETRICI
    SERVICE_MAP(F1_TD_INNOV)        := T_IDS_OFFERTA(8, 9, 10, 39, 40);  --SM_4561 AGGIUNTO 39 e 40 S7 BTS ATM SIMMETRICI
    SERVICE_MAP(F2_TD_INNOV)        := T_IDS_OFFERTA(7, 8, 9, 10, 11, 12, 13, 14);
    --SERVICE_MAP(F1_TD_INNOV_NISIDA) := T_IDS_OFFERTA(8, 9, 10,39,40);  --SM_4561 AGGIUNTO 39 e 40 S7 BTS ATM SIMMETRICI
    SERVICE_MAP(F1_TD_INNOV_NISIDA) := T_IDS_OFFERTA(8, 9, 10, 39, 40);
    SERVICE_MAP(F2_TD_INNOV_NISIDA) := T_IDS_OFFERTA(7, 8, 9, 10, 11, 12, 13, 14);
    SERVICE_MAP(SERVICE_ULL_RI)     := T_IDS_OFFERTA(1, 2);
    SERVICE_MAP(SERVICE_ULLD_RI)    := T_IDS_OFFERTA(3, 4);
    SERVICE_MAP(SERVICE_SLU_RI)     := T_IDS_OFFERTA(5, 6);
    SERVICE_MAP(SERVICE_ATM_RI)     := T_IDS_OFFERTA(8, 9, 10);
    SERVICE_MAP(SERVICE_GBE_RI)     := T_IDS_OFFERTA(7);
    SERVICE_MAP(SERVICE_EASYIP_RI)  := T_IDS_OFFERTA(11, 12, 13, 14);
    SERVICE_MAP(SERVICE_VULA_RI)    := T_IDS_OFFERTA(15, 16, 17, 18);
    SERVICE_MAP(SERVICE_SISTINA)    := T_IDS_OFFERTA(8, 9, 10, 39, 40); --S7 Aggiunti servizi SIMMETRICI ATM
    SERVICE_MAP(ULISSE_TD_F1)       := T_IDS_OFFERTA(8, 9, 10, 39, 40);
   -- SERVICE_MAP(ULISSE_TD_F1)       := T_IDS_OFFERTA(8, 9, 10,39,40);  --SM_4561 AGGIUNTO 39 e 40 S7 BTS ATM SIMMETRICI
    SERVICE_MAP(NOWRI_VC_ATM)       := T_IDS_OFFERTA(8, 9, 10);
    SERVICE_MAP(NOWRI_CVLAN)        := T_IDS_OFFERTA(7);
    SERVICE_MAP(NOWRI_UVLAN)        := T_IDS_OFFERTA(15, 16, 17, 18);
    SERVICE_MAP(SERVICE_NP)         := T_IDS_OFFERTA(20);                     -- Luca Abbate, Lotto5 (RA, RAES, OPERA)
    SERVICE_MAP(SERVICE_INCONTRA)   := T_IDS_OFFERTA(20, 22, 25, 33, 21, 26); -- RU_412 --20,27,28,29 --NP / 22,25,33 --WLR / 21,26 --VULL
    SERVICE_MAP(SERVICE_WLR)        := T_IDS_OFFERTA(22, 25);                 -- Luca Abbate, Lotto6 (WLR)
    SERVICE_MAP(SERVICE_STS_WLR)    := T_IDS_OFFERTA(22, 25);                 -- Luca Abbate, Lotto6 (STS WLR)
    SERVICE_MAP(SERVICE_SHA)        := T_IDS_OFFERTA(23, 24);                 -- Luca Abbate, Lotto6 (SHA)
    SERVICE_MAP(SERVICE_VULL)       := T_IDS_OFFERTA(21, 26);                 -- Luca Abbate, Lotto6 (VULL)
    SERVICE_MAP(SERVICE_SHA_RI)     := T_IDS_OFFERTA(23, 24);                 -- Luca Abbate, Lotto6 (SHA vs RI)
    SERVICE_MAP(SERVICE_VULL_RI)    := T_IDS_OFFERTA(21, 26);                 -- Luca Abbate, Lotto6 (VULL vs RI)
    SERVICE_MAP(SERVICE_WLR_RI)     := T_IDS_OFFERTA(22, 25);                 -- Luca Abbate, Lotto6 (WLR vs RI)
    SERVICE_MAP(SERVICE_RAC)        := T_IDS_OFFERTA(20, 25, 26, 27, 28, 29); -- Luca Abbate, Lotto6 (RAC)
    SERVICE_MAP(SERVICE_SISTINA_VULL_NOT_NULL)       := T_IDS_OFFERTA(21, 26);                 -- RU_371 (SISTINA VULL)
    SERVICE_MAP(SERVICE_SISTINA_VULL_NULL):= T_IDS_OFFERTA(21, 26);                        -- RU_371 (SISTINA VULL)

    -- TRACE FORMAT vs INCONTRA (NP, VULL, WLR) -- LA Lotto6
    FILE_COLUMNS(SERVICE_INCONTRA) := INCONTRA_SELECT_COLS;

--RU_975
  FILE_COLUMNS(SERVICE_CPS_INCONTRA) := CPS_INCONTRA_SELECT_COLS;
  FILE_COLUMNS(SERVICE_CPS_FRMSFRAUD) := FRMSFRAUD_INCONTRA_SELECT_COLS;

    --################# NOW vs RA/RAES #################--
    --SETTING UP BITSTREAM GBE FORMAT vs RA -- Lotti precedenti
    FILE_COLUMNS(SERVICE_BSGBE) := BSGBE_SELECT_COLS;

    --SETTING UP BITSTREAM ATM FORMAT vs RA -- Lotti precedenti
    FILE_COLUMNS(SERVICE_BSATM) := BSATM_SELECT_COLS;

    -- SETTING UP BITSTREAM EASY IP FORMAT vs RA -- Lotti precedenti
    FILE_COLUMNS(SERVICE_EASYIP) := BSEASYIP_SELECT_COLS;

    --SETTING UP VC ATM FORMAT vs RA -- Lotti precedenti
    FILE_COLUMNS(VC_ATM) := VCATM_SELECT_COLS;

    --SETTING UP VCUSER/VLAN FORMAT vs RA -- Lotti precedenti
    FILE_COLUMNS(VC_VLAN) := VC_VLAN_SELECT_COLS;

    -- NP TRACE FORMAT -- LA Lotto5
    FILE_COLUMNS(SERVICE_NP) := NP_SELECT_COLS; -- (RA, RAES)

    --SETTING UP ULL TRACE FORMAT vs RA, RAES -- LA Lotti precedenti + Lotto6
    TMP_SELECT_COLS := AGGIUNTIVI_SELECT_COLS;
  --  TMP_SELECT_COLS(5) := '(select COD_OFFERTA_JPUB FROM OFFERTA OFF WHERE OFF.ID_OFFERTA = ANY'||IDS_OFFERTA(SERVICE_ULL)||' FETCH FIRST 1 ROW ONLY)'; --'5' TIPO_CONTR
   -- TMP_SELECT_COLS(10) := '51'; -- OPZ_COMM
    FILE_COLUMNS(SERVICE_ULL) := TMP_SELECT_COLS;

    -- ULLD TRACE FORMAT vs RA, RAES -- LA Lotti precedenti + Lotto6
    TMP_SELECT_COLS := AGGIUNTIVI_SELECT_COLS;
    TMP_SELECT_COLS.EXTEND(6); --RU_1143 --RU_1153
    TMP_SELECT_COLS(31) := 'ASSET.OFFERTA'; --RU_1143
    TMP_SELECT_COLS(32) := 'ASSET.IDRISORSACORRELATO'; --RU_1143
    TMP_SELECT_COLS(33) := q'x'FONIA'x' ; --RU_1143
    TMP_SELECT_COLS(34) := 'ASSET.NUMEROTELEFONICO'; --RU_1143
    TMP_SELECT_COLS(35) := 'ASSET.OPERATORERETE'; --RU_1143
    TMP_SELECT_COLS(36) := q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'TIPOLINEA')x' ; --RU_1153
 --   TMP_SELECT_COLS(5) := '(select COD_OFFERTA_JPUB FROM OFFERTA OFF WHERE OFF.ID_OFFERTA = ANY'||IDS_OFFERTA(SERVICE_ULLD)||' FETCH FIRST 1 ROW ONLY)'; --'37'; --TIPO_CONTR
    TMP_SELECT_COLS.DELETE(9); --TIPO_FAMIGLIA
    TMP_SELECT_COLS.DELETE(11); --TIPO_LINEA
    TMP_SELECT_COLS.DELETE(29); --ROUTING_NUMBER
    FILE_COLUMNS(SERVICE_ULLD) := TMP_SELECT_COLS;



    -- SLU TRACE FORMAT vs RA, RAES -- LA Lotti precedenti + Lotto6
    TMP_SELECT_COLS := AGGIUNTIVI_SELECT_COLS;
  --  TMP_SELECT_COLS(5) := '(select COD_OFFERTA_JPUB FROM OFFERTA OFF WHERE OFF.ID_OFFERTA = ANY'||IDS_OFFERTA(SERVICE_SLU)||' FETCH FIRST 1 ROW ONLY)'; --'52'; --TIPO_CONTR
    FILE_COLUMNS(SERVICE_SLU) := TMP_SELECT_COLS;


       -- VULL TRACE FORMAT vs RA, RAES -- LA Lotto6
  TMP_SELECT_COLS := BASE_SELECT_COLS;
   TMP_SELECT_COLS.EXTEND(5); --RU_1143
   TMP_SELECT_COLS(31) := 'ASSET.OFFERTA'; --RU_1143
   TMP_SELECT_COLS(32) := 'ASSET.IDRISORSACORRELATO'; --RU_1143
   TMP_SELECT_COLS(33) := q'x'FONIA'x' ; --RU_1143
   TMP_SELECT_COLS(34) := 'ASSET.NUMEROTELEFONICO'; --RU_1143
   TMP_SELECT_COLS(35) := 'ASSET.OPERATORERETE'; --RU_1143
-- TMP_SELECT_COLS(5) := '(select COD_OFFERTA_JPUB FROM OFFERTA OFF WHERE OFF.ID_OFFERTA = ANY'||IDS_OFFERTA(SERVICE_VULL)||' FETCH FIRST 1 ROW ONLY)'; --'23'; -- TIPO_CONTR
    TMP_SELECT_COLS(15) := 'NULL';
    TMP_SELECT_COLS(10) := '50'; -- OPZ_COMM
    TMP_SELECT_COLS(17) := 'ASSET_NUMAGG.NUMEROAGGIUNTIVO'; -- NUMERO AGGIUNTIVO
    TMP_SELECT_COLS.DELETE(30); -- FLAG_LA
    TMP_SELECT_COLS(11) := q'xCASE WHEN PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'TIPOLINEA','ACCESSOVULL')='POTS' THEN 55 WHEN PKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'TIPOLINEA','ACCESSOVULL')='ISDN' THEN 53 ELSE NULL ENDx';
    TMP_SELECT_COLS(29) := 'NULL'; -- ROUTING NUMBER
    FILE_COLUMNS(SERVICE_VULL) := TMP_SELECT_COLS;




    -- WLR TRACE FORMAT vs RA,  -- LA Lotto6
    TMP_SELECT_COLS := WLR_SELECT_COLS;
    TMP_SELECT_COLS(32) := NULL;
    FILE_COLUMNS(SERVICE_WLR) := TMP_SELECT_COLS;

    -- STS_WLR TRACE FORMAT vs RA, RAES -- LA Lotto6
    TMP_SELECT_COLS := WLR_SELECT_COLS;
    TMP_SELECT_COLS(10) := q'x(select TIPO_FAMIG_RA FROM TIPOLG_STS TIP WHERE TIP.COD_STS_NOW=PKG_ESTRAZIONI.ASSET_ATTR_BY_COMPONENT_ID(STS_WLR.DETT_BDS_ID, 'CODICE'))x'; -- TIPO FAMIGLIA Lotto 6
    TMP_SELECT_COLS(11) := 'NULL';
    TMP_SELECT_COLS(12) := 'NULL';
    TMP_SELECT_COLS(13) := 'NULL';
    --TMP_SELECT_COLS(16) := 'NULL';
    TMP_SELECT_COLS(17) := 'NULL';
    TMP_SELECT_COLS(19) := 'NULL';
    TMP_SELECT_COLS(20) := 'NULL';
    TMP_SELECT_COLS(21) := 'NULL';
    TMP_SELECT_COLS(24) := 'NULL';
    TMP_SELECT_COLS(25) := 'NULL';
    TMP_SELECT_COLS(26) := 'NULL';
    TMP_SELECT_COLS(27) := 'NULL';
    TMP_SELECT_COLS(31) := 'NULL';

    TMP_SELECT_COLS(33) := 'NULL'; --RU_1143
    TMP_SELECT_COLS(34) := 'NULL'; --RU_1143
    TMP_SELECT_COLS(35) := 'NULL'; --RU_1143
    TMP_SELECT_COLS(36) := 'NULL'; --RU_1143
    TMP_SELECT_COLS(37) := 'NULL'; --RU_1143
    FILE_COLUMNS(SERVICE_STS_WLR) := TMP_SELECT_COLS;

    -- SHA TRACE FORMAT vs RA, RAES -- LA Lotto6
 TMP_SELECT_COLS := BASE_SELECT_COLS;
    TMP_SELECT_COLS.EXTEND(6); --RU_1143 --RU_1153
    TMP_SELECT_COLS(31) := 'ASSET.OFFERTA'; --RU_1143
    TMP_SELECT_COLS(32) := 'ASSET.IDRISORSACORRELATO'; --RU_1143
    TMP_SELECT_COLS(33) := q'x'DATI'x' ; --RU_1143
    TMP_SELECT_COLS(34) := 'ASSET.NUMEROTELEFONICO'; --RU_1143
    TMP_SELECT_COLS(35) := 'ASSET.OPERATORERETE'; --RU_1143
    TMP_SELECT_COLS(36) := q'xPKG_ESTRAZIONI.CODIFICA_ATTRIBUTO_ASSET(ASSET.BDS_ID, 'TIPOLINEA')x' ; --RU_1153
 --   TMP_SELECT_COLS(5) := '(select COD_OFFERTA_JPUB FROM OFFERTA OFF WHERE OFF.ID_OFFERTA = ANY'||IDS_OFFERTA(SERVICE_SHA)||' FETCH FIRST 1 ROW ONLY)'; --'17'; -- TIPO_CONTR
    TMP_SELECT_COLS.DELETE(9); -- TIPO_FAMIGLIA
    TMP_SELECT_COLS.DELETE(10); -- OPZ_COMM
    TMP_SELECT_COLS.DELETE(11); -- TIPO_LINEA
    TMP_SELECT_COLS(17) := 'NULL'; -- NUMERO AGGIUNTIVO --SM_3742
    TMP_SELECT_COLS(29) := 'NULL'; -- ROUTING NUMBER
    TMP_SELECT_COLS.DELETE(30); -- FLAG_LA
    FILE_COLUMNS(SERVICE_SHA) := TMP_SELECT_COLS;

    --SETTING UP GIACENZA ORDINI FORMAT - REGOLATORIO vs RA, RAES -- LA Lotto6
    TMP_SELECT_COLS                       := ORDINI_GIAC_COLS;
    --TMP_SELECT_COLS(22)                   := 'NULL'; SM_5730
    TMP_SELECT_COLS(29)                   := 'NULL';
    FILE_COLUMNS(ORDINI_GIACENTI_REG)     := TMP_SELECT_COLS;

    --SETTING UP GIACENZA ORDINI FORMAT - NGAVULA vs RA, RAES -- LA Lotto6
    TMP_SELECT_COLS                       := ORDINI_GIAC_COLS;
    --TMP_SELECT_COLS(4)                    := 'NULL'; SM_5795
    TMP_SELECT_COLS(15)                   := 'NULL';
    TMP_SELECT_COLS(25)                   := 'NULL';
    FILE_COLUMNS(ORDINI_GIACENTI_NGAVULA) := TMP_SELECT_COLS;

    --SETTING UP GIACENZA ORDINI FORMAT - XDSL vs RA, RAES -- LA Lotto6
    TMP_SELECT_COLS                       := ORDINI_GIAC_COLS;
    --TMP_SELECT_COLS(4)                    := 'NULL'; SM_5795
    TMP_SELECT_COLS(15)                   := 'NULL';
    TMP_SELECT_COLS(25)                   := 'NULL';
    FILE_COLUMNS(ORDINI_GIACENTI_XDSL)    := TMP_SELECT_COLS;

     --SETTING UP ORDINI NOW RI FORMAT - REGOLATORIO vs RA, RAES -- LA Lotto6
    TMP_SELECT_COLS                       := ORDINI_NOW_RI_COLS;
    TMP_SELECT_COLS(22)                   := 'NULL';
    TMP_SELECT_COLS(31)                   := 'NULL';
    TMP_SELECT_COLS(32)                   := 'NULL';
    TMP_SELECT_COLS(33)                   := 'NULL';
    TMP_SELECT_COLS(34)                   := 'NULL';
    TMP_SELECT_COLS(35)                   := 'NULL';
    TMP_SELECT_COLS(36)                   := 'NULL';
    TMP_SELECT_COLS(37)                   := 'NULL';
    TMP_SELECT_COLS(38)                   := 'NULL';
    TMP_SELECT_COLS(39)                   := 'NULL';
    TMP_SELECT_COLS(40)                   := 'NULL';
    TMP_SELECT_COLS(41)                   := 'NULL';
    TMP_SELECT_COLS(42)                   := 'NULL';
    TMP_SELECT_COLS(43)                   := 'NULL';
    TMP_SELECT_COLS(44)                   := 'NULL';
    TMP_SELECT_COLS(45)                   := 'NULL';
    TMP_SELECT_COLS(46)                   := 'NULL';
    TMP_SELECT_COLS(47)                   := 'NULL';
    TMP_SELECT_COLS(48)                   := 'NULL';
    TMP_SELECT_COLS(49)                   := 'NULL';
    TMP_SELECT_COLS(53)                   := 'NULL';
    FILE_COLUMNS(ORDINI_NOW_RI_REG)       := TMP_SELECT_COLS;

    --SETTING UP ORDINI NOW RI FORMAT - NGAVULA vs RA, RAES -- LA Lotto6
    TMP_SELECT_COLS                       := ORDINI_NOW_RI_COLS;
    TMP_SELECT_COLS(12)                   := 'NULL';
    TMP_SELECT_COLS(18)                   := 'NULL';
    TMP_SELECT_COLS(29)                   := 'NULL';
    TMP_SELECT_COLS(30)                   := 'NULL';
    TMP_SELECT_COLS(51)                   := 'NULL';
    FILE_COLUMNS(ORDINI_NOW_RI_NGAVULA) := TMP_SELECT_COLS;

    --SETTING UP ORDINI NOW RI FORMAT - XDSL vs RA, RAES -- LA Lotto6
    TMP_SELECT_COLS                       := ORDINI_NOW_RI_COLS;
    TMP_SELECT_COLS(12)                   := 'NULL';
    TMP_SELECT_COLS(18)                   := 'NULL';
    TMP_SELECT_COLS(29)                   := 'NULL';
    TMP_SELECT_COLS(30)                   := 'NULL';
    TMP_SELECT_COLS(51)                   := 'NULL';
    FILE_COLUMNS(ORDINI_NOW_RI_XDSL)    := TMP_SELECT_COLS;

    --SETTING F1 TD INNOVATIVA vs RA
    FILE_COLUMNS(F1_TD_INNOV) := F1_TD_INNOV_COLS;

    --SETTING F2 TD INNOVATIVA vs RA
    FILE_COLUMNS(F2_TD_INNOV) := F2_TD_INNOV_COLS;

    --SETTING F1 TD INNOVATIVA _NISIDA
    FILE_COLUMNS(F1_TD_INNOV_NISIDA) := F1_TD_INNOV_COLS_NISIDA;

    --SETTING F2 TD INNOVATIVA _NISIDA
    FILE_COLUMNS(F2_TD_INNOV_NISIDA) := F2_TD_INNOV_COLS_NISIDA;


    --/################# NOW vs RA/RAES #################--

    --################# NOW vs RI #################--
    -- SETTING UP SLU NOW-RI -- Lotti precedenti
    FILE_COLUMNS(SERVICE_SLU_RI) := ULL_SLU_SELECT_COLS;

    -- SETTING UP ATM NOW-RI -- Lotti precedenti
    FILE_COLUMNS(SERVICE_ATM_RI) := ATM_RI_SELECT_COLS;

    --SETTING UP GBE NOW-RI -- Lotti precedenti
    FILE_COLUMNS(SERVICE_GBE_RI) := GBE_RI_SELECT_COLS;

    --SETTING UP EASYIP NOW-RI -- Lotti precedenti
    FILE_COLUMNS(SERVICE_EASYIP_RI) := EASYIP_RI_SELECT_COLS;

    --SETTING UP NGAVULA NOW-RI -- Lotti precedenti
    FILE_COLUMNS(SERVICE_VULA_RI) := VULA_RI_SELECT_COLS;

    --SETTING RI VC -- Lotti precedenti
    FILE_COLUMNS(NOWRI_VC_ATM) := NOWRI_VC_SELECT_COLS;

    --SETTING RI CVLAN -- Lotti precedenti
    FILE_COLUMNS(NOWRI_CVLAN) := NOWRI_CVLAN_SELECT_COLS;

    --SETTING RI UVLAN -- Lotti precedenti
    FILE_COLUMNS(NOWRI_UVLAN) := NOWRI_UVLAN_SELECT_COLS;

    -- ULL TRACE FORMAT vs RI -- LA Lotti precedenti/Lotto6
    TMP_SELECT_COLS := ULL_RI_SELECT_COLS;
    TMP_SELECT_COLS(5) := '9'; -- TIPO_CONTR
    TMP_SELECT_COLS(7) := 'NULL'; -- CODE_PREST_AGG (non in ambito S6)
    TMP_SELECT_COLS(9) := 'NULL'; -- ID_RIS_PRINC (non in ambito S6)
    TMP_SELECT_COLS(11) := 'NULL'; -- CODE_GEST_RET (non in ambito S6)
    TMP_SELECT_COLS.DELETE(12); -- TIPO_FAMIGLIA
    TMP_SELECT_COLS(13) := '51'; -- OPZ_COMM
    TMP_SELECT_COLS(15) := '0'; -- OPZ_COMM
    TMP_SELECT_COLS(17) := 'NULL'; -- SUB_TIPO_LINEA_RESIDENZIALE (non in ambito S6)
    TMP_SELECT_COLS.DELETE(18); -- SUB_TIPO_LINEA_DIREZIONE
    TMP_SELECT_COLS(24) := 'NULL'; -- FLAG_MIGRAZIONE (non in ambito S6)
    TMP_SELECT_COLS(25) := 'NULL'; -- FLAG_QUALIFICAZIONE (non in ambito S6)
    TMP_SELECT_COLS(26) := 'NULL'; -- ID_RIS_OLD (non in ambito S6)
    FILE_COLUMNS(SERVICE_ULL_RI) := TMP_SELECT_COLS;

    -- ULL DATI TRACE FORMAT vs RI -- LA Lotti precedenti/Lotto6
    TMP_SELECT_COLS := ULL_RI_SELECT_COLS;
    TMP_SELECT_COLS(5) := '37'; -- TIPO_CONTR
    TMP_SELECT_COLS(7) := 'NULL'; -- CODE_PREST_AGG (non in ambito S6)
    TMP_SELECT_COLS(9) := 'NULL'; -- ID_RIS_PRINC (non in ambito S6)
    TMP_SELECT_COLS(11) := 'NULL'; -- CODE_GEST_RET (non in ambito S6)
    TMP_SELECT_COLS.DELETE(12); -- TIPO_FAMIGLIA
    TMP_SELECT_COLS(13) := '51'; -- OPZ_COMM
    TMP_SELECT_COLS(15) := '0'; -- OPZ_COMM
    TMP_SELECT_COLS(17) := 'NULL'; -- SUB_TIPO_LINEA_RESIDENZIALE (non in ambito S6)
    TMP_SELECT_COLS.DELETE(18); -- SUB_TIPO_LINEA_DIREZIONE
    TMP_SELECT_COLS(24) := 'NULL'; -- FLAG_MIGRAZIONE (non in ambito S6)
    TMP_SELECT_COLS(25) := 'NULL'; -- FLAG_QUALIFICAZIONE (non in ambito S6)
    TMP_SELECT_COLS(26) := 'NULL'; -- ID_RIS_OLD (non in ambito S6)
    FILE_COLUMNS(SERVICE_ULLD_RI) := TMP_SELECT_COLS;

    -- VULL TRACE FORMAT vs RI -- LA Lotto6
    TMP_SELECT_COLS := ULL_RI_SELECT_COLS;
    TMP_SELECT_COLS.DELETE(11); -- CODE_GEST_RET
    TMP_SELECT_COLS(5) := '23'; -- TIPO_CONTR
    TMP_SELECT_COLS(13) := '50'; -- OPZ_COMM
    TMP_SELECT_COLS(7) := 'NULL'; -- CODE_PREST_AGG
    TMP_SELECT_COLS(9) := 'NULL'; -- ID_RIS_PRINC
    TMP_SELECT_COLS(15) := 'NULL'; -- FLAG_NP
    TMP_SELECT_COLS(16) := 'NULL'; -- SUB_TIPO_LINEA
    TMP_SELECT_COLS(18) := 'NULL'; -- SUB_TIPO_LINEA_DIREZIONE
    TMP_SELECT_COLS(21) := 'NULL'; -- CODE_ID_ULLCO
    TMP_SELECT_COLS(23) := 'NULL'; -- FLAG_PERMUTA
    TMP_SELECT_COLS(24) := 'NULL'; -- FLAG_MIGRAZIONE
    TMP_SELECT_COLS(25) := 'NULL'; -- FLAG_QUALIFICAZIONE
    TMP_SELECT_COLS(26) := 'NULL'; -- ID_RIS_OLD
    FILE_COLUMNS(SERVICE_VULL_RI) := TMP_SELECT_COLS;

    -- WLR TRACE FORMAT vs RI -- LA Lotto6
    TMP_SELECT_COLS := ULL_RI_SELECT_COLS;
    TMP_SELECT_COLS.DELETE(11); -- CODE_GEST_RET
    TMP_SELECT_COLS(5) := '41'; -- TIPO_CONTR
    TMP_SELECT_COLS(7) := 'ORD.'; -- -- CODE_PREST_AGG
    TMP_SELECT_COLS(9) := 'NULL'; -- ID_RIS_PRINC
    TMP_SELECT_COLS(13) := 'NULL'; -- OPZ_COMM
    TMP_SELECT_COLS(15) := 'NULL'; -- FLAG_NP
    TMP_SELECT_COLS(16) := 'NULL'; -- SUB_TIPO_LINEA
    TMP_SELECT_COLS(21) := 'NULL'; -- CODE_ID_ULLCO
    TMP_SELECT_COLS(23) := 'NULL'; -- FLAG_PERMUTA
    TMP_SELECT_COLS(24) := 'NULL'; -- FLAG_MIGRAZIONE
    TMP_SELECT_COLS(25) := 'NULL'; -- FLAG_QUALIFICAZIONE
    FILE_COLUMNS(SERVICE_WLR_RI) := TMP_SELECT_COLS;

    -- SHA TRACE FORMAT vs RI -- LA Lotto6
    TMP_SELECT_COLS := ULL_RI_SELECT_COLS;
    TMP_SELECT_COLS.DELETE(11); -- CODE_GEST_RET
    TMP_SELECT_COLS(5) := '17'; -- TIPO_CONTR
    TMP_SELECT_COLS(7) := 'NULL'; -- CODE_PREST_AGG
    TMP_SELECT_COLS(9) := 'NULL'; -- ID_RIS_PRINC
    TMP_SELECT_COLS(12) := 'NULL'; -- TIPO_FAMIGLIA
    TMP_SELECT_COLS(13) := 'NULL'; -- OPZ_COMM
    TMP_SELECT_COLS(14) := 'NULL'; -- TIPO_LINEA
    TMP_SELECT_COLS(15) := 'NULL'; -- FLAG_NP
    TMP_SELECT_COLS(16) := 'NULL'; -- SUB_TIPO_LINEA
    TMP_SELECT_COLS(18) := 'NULL'; -- SUB_TIPO_LINEA_DIREZIONE
    TMP_SELECT_COLS(19) := 'NULL'; -- MOD_VENDITA_ACCESSO
    TMP_SELECT_COLS(23) := 'NULL'; -- FLAG_PERMUTA
    TMP_SELECT_COLS(36) := 'N'; -- FLAG_SPLITTER (solo per SHA)
    FILE_COLUMNS(SERVICE_SHA_RI) := TMP_SELECT_COLS;
    --/################# NOW vs RI #################--

    --SETTING SERVICE_RAC
    FILE_COLUMNS(SERVICE_RAC) := RAC_SELECT_COLS;

    --SETTING UP SISTINA
    FILE_COLUMNS(SERVICE_SISTINA) := SISTINA_SELECT_COLS;

    --SETTING ULISSE F1 TD
    FILE_COLUMNS(ULISSE_TD_F1) := ULISSE_F1_COLS;

    -- SETTING UP REGIA0 GIACENZE
    FILE_COLUMNS(REGIA0_GIACENZE) := REGIA0_GIACENZE_COLS;

    --SETTING UP REGIA0 KO
    FILE_COLUMNS(REGIA0_KO) := REGIA0_KO_COLS;

    --SETTING UP OPERA
    FILE_COLUMNS(OPERA_CONSISTENZE) := OPERA_COLS;

    -- SETTING UP SISTINA VULL  -- RU_371
    FILE_COLUMNS(SERVICE_SISTINA_VULL_NOT_NULL):= SISTINA_VULL_NOT_NULL_COLS;
    FILE_COLUMNS(SERVICE_SISTINA_VULL_NULL):= SISTINA_VULL_NULL_COLS;

-- ANDREA GARAVINI
 -- 18/08/2016
 -- LOTTO4

    --SETTING UP UTENTI INATTIVI FORMAT
    FILE_COLUMNS(UTENTI_INATTIVI) := UTENTI_INATT_COLS;

--/ ANDREA GARAVINI

  END;

END PKG_ESTRAZIONI;
/
