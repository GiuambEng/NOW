-- =============================================================================
-- C26M42F01_CARICA_ANAGRAFICA_MERCATO_TEMP.ctl
-- SQL*Loader control file per il caricamento di ANAGRAFICA_MERCATO_TEMP
-- Separatore: ;  |  Header: 1 riga (SKIP 1)
-- &&INPUT_FILE_PATH&& = path completo del file
-- &&INPUT_FILE_NAME&& = solo nome del file
-- =============================================================================
OPTIONS (SKIP=1)
LOAD DATA
INFILE '&&INPUT_FILE_PATH&&'
TRUNCATE
INTO TABLE ANAGRAFICA_MERCATO_TEMP
FIELDS TERMINATED BY ';' OPTIONALLY ENCLOSED BY '"'
TRAILING NULLCOLS
(
  COMUNE_ORIGINARIO,
  PROVINCIA,
  REGIONE,
  CODICE_ISTAT_COMUNE,
  CODICE_ISTAT_REGIONE,
  MERCATO,
  DATA_INIZIO_VALIDITA,
  NOME_FILE            CONSTANT "&&INPUT_FILE_NAME&&",
  DATA_CARICAMENTO     EXPRESSION "SYSTIMESTAMP"
)


