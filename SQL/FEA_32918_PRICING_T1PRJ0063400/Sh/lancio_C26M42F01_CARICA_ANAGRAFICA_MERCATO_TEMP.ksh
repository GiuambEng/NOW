#!/bin/ksh

##############################################################################
# CARICAMENTO ANAGRAFICA_MERCATO_TEMP
##############################################################################

. ./cfg_C26M42F01.env

LOG_FILE=lancio_C26M42F01_CARICAMENTO_ANAGRAFICA_MERCATO_TEMP_${data_corrente}.log

exec 1>$path_log/$LOG_FILE
exec 2>&1

echo "INIZIO lancio_C26M42F01_CARICAMENTO_ANAGRAFICA_MERCATO_TEMP - $(date '+%Y%m%d%H%M%S')"
echo ""

##############################################################################
# Verifica parametro input
##############################################################################

if [ -z "$1" ]
then
   echo "ERRORE: nome file non specificato"
   echo "Utilizzo: $0 <nome_file>"
   echo ""
   echo "FINE lancio_C26M42F01_CARICAMENTO_ANAGRAFICA_MERCATO_TEMP - $(date '+%Y%m%d%H%M%S')"
   exit 1
fi

INPUT_FILE_NAME=$1

INPUT_FILES=$path_root/Files
INPUT_FILE_PATH=$INPUT_FILES/$INPUT_FILE_NAME

echo "INPUT_FILES=[$INPUT_FILES]"
echo "INPUT_FILE_PATH=[$INPUT_FILE_PATH]"

##############################################################################
# Verifica file CSV
##############################################################################

if [ ! -f "$INPUT_FILE_PATH" ]
then
   echo "ERRORE: file non trovato [$INPUT_FILE_PATH]"
   echo ""
   echo "FINE lancio_C26M42F01_CARICAMENTO_ANAGRAFICA_MERCATO_TEMP - $(date '+%Y%m%d%H%M%S')"
   exit 1
fi

##############################################################################
# CTL TEMPLATE
##############################################################################

CTL_TEMPLATE=$INPUT_FILES/C26M42F01_CARICA_ANAGRAFICA_MERCATO_TEMP.ctl

echo "CTL_TEMPLATE=[$CTL_TEMPLATE]"

if [ ! -f "$CTL_TEMPLATE" ]
then
   echo "ERRORE: CTL template non trovato [$CTL_TEMPLATE]"
   echo ""
   echo "FINE lancio_C26M42F01_CARICAMENTO_ANAGRAFICA_MERCATO_TEMP - $(date '+%Y%m%d%H%M%S')"
   exit 1
fi

##############################################################################
# CTL RUNTIME
##############################################################################

CTL_RUNTIME=$INPUT_FILES/C26M42F01_CARICA_ANAGRAFICA_MERCATO_TEMP_runtime.ctl

sed \
  -e "s|&&INPUT_FILE_PATH&&|$INPUT_FILE_PATH|g" \
  -e "s|&&INPUT_FILE_NAME&&|$INPUT_FILE_NAME|g" \
  "$CTL_TEMPLATE" > "$CTL_RUNTIME"

RC=$?

if [ $RC -ne 0 ]
then
   echo "ERRORE nella generazione del CTL runtime"
   echo ""
   echo "FINE lancio_C26M42F01_CARICAMENTO_ANAGRAFICA_MERCATO_TEMP - $(date '+%Y%m%d%H%M%S')"
   exit 1
fi

echo "CTL_RUNTIME=[$CTL_RUNTIME]"

##############################################################################
# Wrapper SQLLoader
##############################################################################

call_sqlldr()
{
   if [ "$CRMSINTERFACE" = "N" ]
   then
      sqlldr "$@"
   else
      CrmSInterface 811 sqlldr "$@" 2>&1
   fi
}

##############################################################################
# SQLLoader
##############################################################################

SQLLDR_LOG=$path_log/sqlldr_C26M42F01_${data_corrente}.log
SQLLDR_BAD=$path_log/sqlldr_C26M42F01_${data_corrente}.bad
SQLLDR_DSC=$path_log/sqlldr_C26M42F01_${data_corrente}.dsc

echo "Lancio CARICAMENTO ANAGRAFICA_MERCATO_TEMP ..."

call_sqlldr \
userid=$username/$sys_code@$dbname \
control=$CTL_RUNTIME \
log=$SQLLDR_LOG \
bad=$SQLLDR_BAD \
discard=$SQLLDR_DSC \
direct=true

RC=$?

##############################################################################
# Pulizia CTL runtime
##############################################################################

rm -f "$CTL_RUNTIME"

##############################################################################
# Esito finale
##############################################################################

if [ $RC -ne 0 ]
then
   echo "ERRORE: SQL*Loader terminato con return code $RC"
   echo ""
   echo "FINE lancio_C26M42F01_CARICAMENTO_ANAGRAFICA_MERCATO_TEMP - $(date '+%Y%m%d%H%M%S')"
   exit $RC
fi

if grep -qE "ORA-|SQL\*Loader-" "$SQLLDR_LOG" 2>/dev/null
then
   echo "ERRORE rilevato nel log SQL*Loader"
   grep -E "ORA-|SQL\*Loader-" "$SQLLDR_LOG"
   exit 1
fi

echo ""
echo "FINE lancio_C26M42F01_CARICAMENTO_ANAGRAFICA_MERCATO_TEMP - $(date '+%Y%m%d%H%M%S')"

exit 0
