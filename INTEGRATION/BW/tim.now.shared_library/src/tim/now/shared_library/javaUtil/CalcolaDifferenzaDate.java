package tim.now.shared_library.javaUtil;


import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
 

public class CalcolaDifferenzaDate {
 
	public static void main(String[] args) {
	}
	
	 public static String getDiff(String data1, String data2) throws UnknownHostException, ParseException {

		String result = "";
		String dateFormat = "yyyy-MM-dd'T'HH:mm:ss";
		SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);
		
		Date date1 = dateFormatter.parse(data1);
		Date date2 = dateFormatter.parse(data2); 
		
		long diffsec = (date1.getTime() - date2.getTime())/1000;
		
		result = String.valueOf(diffsec);
	
		return result;	
	}
}
