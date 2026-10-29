#!/bin/ksh
## ESECUZIONE PROCEDURA lancio_C26M42F03_PRC_ELAB_ANA_MERCATO

. ./cfg_C26M42F01.env

LOG_FILE=/lancio_C26M42F03_PRC_ELAB_ANA_MERCATO_${data_corrente}.log
exec 1> $path_log/$LOG_FILE
exec 2>&1

echo "START lancio_C26M42F03_PRC_ELAB_ANA_MERCATO - "`date '+%Y%m%d%H%M%S'`
echo""


call_sqlplus() 
{
 if test $CRMSINTERFACE = N; then
    sqlplus -s ${username}/${sys_code}@${dbname} "$@" 2>&1
 else
    CrmSInterface 810 sqlplus -s ${username}@${dbname} "$@" 2>&1
 fi
}

## CHIAMATA PRC_ELAB_ANA_MERCATO
echo "Lancio PRC_ELAB_ANA_MERCATO..."
call_sqlplus <<EOF
SET SERVEROUTPUT ON;
SET LINESIZE 1000
BEGIN
   PKG_ANAGRAFICA_MERCATO.PRC_ELAB_ANA_MERCATO;
END;
/
EXIT;
EOF

echo ""
echo "START lancio_C26M42F03_PRC_ELAB_ANA_MERCATO - "`date '+%Y%m%d%H%M%S'`
