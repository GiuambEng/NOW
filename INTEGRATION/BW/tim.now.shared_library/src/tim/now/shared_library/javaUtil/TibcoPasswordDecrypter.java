package tim.now.shared_library.javaUtil;

import com.tibco.security.ObfuscationEngine;

public class TibcoPasswordDecrypter {

	protected String Encrypted = "";
	protected String Decrypted = "";
	public TibcoPasswordDecrypter() {
	}
	public void invoke() throws Exception {
		
		System.setProperty("TIBCO_SECURITY_VENDOR", "j2se"); 
		
		Decrypted = new String(ObfuscationEngine.decrypt(Encrypted));
	}
	public String getEncrypted() {
			return Encrypted;
		}
	public void setEncrypted(String val) {
			Encrypted = val;
		}
	public String getDecrypted() {
			return Decrypted;
		}
	public void setDecrypted(String val) {
			Decrypted = val;
		}

}
