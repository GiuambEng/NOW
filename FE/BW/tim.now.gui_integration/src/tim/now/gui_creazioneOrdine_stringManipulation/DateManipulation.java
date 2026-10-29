package tim.now.gui_creazioneOrdine_stringManipulation;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateManipulation {
	
	
	
	public static String dateForResearch (String date, String operazione){
		
		try{
			Date d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			Calendar c1 = Calendar.getInstance();
			c1.setTime(d);
			String s;
			switch (operazione) {
			case "=":
				s = new SimpleDateFormat("yyyy-MM-dd").format(c1.getTime());
				return " BETWEEN TO_DATE('" + s 
						+ " 00:00:00','yyyy-MM-dd HH24:MI:SS') AND TO_DATE('" 
						+ s + " 23:59:59','yyyy-MM-dd HH24:MI:SS')) AND "; 
			case ">":
				c1.add(Calendar.DAY_OF_MONTH,1);
				s = new SimpleDateFormat("yyyy-MM-dd").format(c1.getTime());
				return " BETWEEN TO_DATE('" + s 
						+ "','yyyy-MM-dd HH24:MI:SS') AND TO_DATE('9999-12-31','yyyy-MM-dd HH24:MI:SS')) AND ";
			case "<":
				c1.add(Calendar.DAY_OF_MONTH,-1);
				s = new SimpleDateFormat("yyyy-MM-dd").format(c1.getTime());
				return " BETWEEN TO_DATE('1099-01-01','yyyy-MM-dd HH24:MI:SS') AND TO_DATE('" 
						+ s + " 23:59:59','yyyy-MM-dd HH24:MI:SS')) AND "; 
			case ">=":
				s = new SimpleDateFormat("yyyy-MM-dd").format(c1.getTime());
				return " BETWEEN TO_DATE('" + s
						+ " 00:00:00','yyyy-MM-dd HH24:MI:SS') AND TO_DATE('9999-12-31','yyyy-MM-dd HH24:MI:SS')) AND ";
			case "<=":
				s = new SimpleDateFormat("yyyy-MM-dd").format(c1.getTime());
				return " BETWEEN TO_DATE('1099-01-01','yyyy-MM-dd HH24:MI:SS') AND TO_DATE('" 
				+ s + " 23:59:59','yyyy-MM-dd HH24:MI:SS')) AND "; 
			default: //<>
				s = new SimpleDateFormat("yyyy-MM-dd").format(c1.getTime());
				return " NOT BETWEEN TO_DATE('" + s 
						+ " 00:00:00','yyyy-MM-dd HH24:MI:SS') AND TO_DATE('" 
						+ s + " 23:59:59','yyyy-MM-dd HH24:MI:SS')) AND ";
			}
		}catch (Exception e){
			e.printStackTrace();
			return ""; 
		}
		
	}
	
}


