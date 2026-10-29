package tim.now.gui_creazioneOrdine_stringManipulation;

public class QueryClauseStatoElaborazione {
	public static String GetQueryClause(String operatore, String valore){
		
		switch (valore){
		case "DA ELABORARE":
			if (operatore.equals("=")) return "AFC.IDFILE IS NULL";
			else return "NOT AFC.IDFILE IS NULL";
		case "ELABORAZIONE SCARTATA":
			if (operatore.equals("=")) return "(FP.ESITO='KO' OR (SELECT COUNT(*) FROM STAG_CATAL_OFF_COM_COINV_FILE CCF WHERE CCF.ID_FILE_PROCSTO_INPUT = FP.ID_FILE AND CCF.ID_STATO_ELAB_STAG = 3)>0) AND I.COD_INTRFC = 'ID372'";
			else return "NOT((FP.ESITO='KO' OR (SELECT COUNT(*) FROM STAG_CATAL_OFF_COM_COINV_FILE CCF WHERE CCF.ID_FILE_PROCSTO_INPUT = FP.ID_FILE AND CCF.ID_STATO_ELAB_STAG = 3)>0)) AND I.COD_INTRFC = 'ID372'";
		case "IN CORSO DI ELABORAZIONE":
			if (operatore.equals("=")) return "FP.DESCR_STATO_FILE IN ('APERTO','IN ELABORAZIONE') AND I.COD_INTRFC = 'ID372'";
			else return "NOT(FP.DESCR_STATO_FILE IN ('APERTO','IN ELABORAZIONE')) AND I.COD_INTRFC = 'ID372'";
		case "FILE NON LEGGIBILE":
			if (operatore.equals("=")) return "FP.DESCR_STATO_FILE IN ('ERRORE','SCARTATO','ERRORE APERTURA FILE') AND I.COD_INTRFC = 'ID372'";
			else return "NOT(FP.DESCR_STATO_FILE IN ('ERRORE','SCARTATO','ERRORE APERTURA FILE')) AND I.COD_INTRFC = 'ID372'";
		default:
			if (operatore.equals("=")) return "FP.ESITO='OK' AND I.COD_INTRFC = 'ID372'";
			else return "NOT(FP.ESITO='OK') AND I.COD_INTRFC = 'ID372'";
		}
		
	}
}
