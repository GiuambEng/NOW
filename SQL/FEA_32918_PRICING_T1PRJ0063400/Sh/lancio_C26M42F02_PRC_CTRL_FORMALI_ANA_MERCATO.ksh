#!/bin/ksh
## ESECUZIONE PROCEDURA PRC_CTRL_FORMALI_ANA_MERCATO

. ./cfg_C26M42F01.env

LOG_FILE=/lancio_C26M42F02_PRC_CTRL_FORMALI_ANA_MERCATO_${data_corrente}.log
exec 1> $path_log/$LOG_FILE
exec 2>&1

echo "START lancio_C26M42F02_PRC_CTRL_FORMALI_ANA_MERCATO - "`date '+%Y%m%d%H%M%S'`
echo""


call_sqlplus() 
{
 if test $CRMSINTERFACE = N; then
    sqlplus -s ${username}/${sys_code}@${dbname} "$@" 2>&1
 else
    CrmSInterface 810 sqlplus -s ${username}@${dbname} "$@" 2>&1
 fi
}

## CHIAMATA PRC_CTRL_FORMALI_ANA_MERCATO
echo "Lancio PRC_CTRL_FORMALI_ANA_MERCATO..."
call_sqlplus <<EOF
SET SERVEROUTPUT ON;
SET LINESIZE 1000
BEGIN
   PKG_ANAGRAFICA_MERCATO.PRC_CTRL_FORMALI_ANA_MERCATO;
END;
/
EXIT;
EOF

echo ""
echo "FINE lancio_C26M42F02_PRC_CTRL_FORMALI_ANA_MERCATO - "`date '+%Y%m%d%H%M%S'`
