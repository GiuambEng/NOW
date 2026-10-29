package tib.psg.utility.ldap;

import java.io.Serializable;

public class Result implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9102531205111828686L;
	private String resultCode;
	private String resultMessage;
	private User user;
	
	public Result() {}
	
	public Result(String resultCode, String resultMessage, User user) {
		this.resultCode = resultCode;
		this.resultMessage = resultMessage;
		this.user = user;
	}
	public Result(String resultCode,String resultMessage){
		this(resultCode,resultMessage,null);
	}
	
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String toString(){
		String s= "RC:"+resultCode+"-Result Message:"+resultMessage;
		if (user!=null) s.concat("-utente:"+user);
		return s;
	}
}
