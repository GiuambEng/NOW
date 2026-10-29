package tim.now.gui_pps_export;

import com.nttdata.crypt.timnow.CryptoParamsUtils;

public class CryptoParams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static String encrypt(String idFile){
		 // Stringa da modificare
		CryptoParamsUtils crypt = new CryptoParamsUtils();
		try {
			return crypt.encrypt(idFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
	
	public static String decryptCheck(String idFile){
		 // Stringa da modificare
		CryptoParamsUtils crypt = new CryptoParamsUtils();
		try {
			return crypt.decryptCheck(idFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
	
	public static String decryptDownload(String idFile){
		 // Stringa da modificare
		CryptoParamsUtils crypt = new CryptoParamsUtils();
		try {
			return crypt.decryptDownload(idFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
}
