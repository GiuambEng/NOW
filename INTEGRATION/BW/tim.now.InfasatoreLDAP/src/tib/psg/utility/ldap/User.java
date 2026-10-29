package tib.psg.utility.ldap;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1222031493865067802L;
	private String Uid,Nome,FunzioneAziendale,Mail,Matricola,UserAlias,CodOloAgcom;

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		this.Nome = nome;
	}

	public String getFunzioneAziendale() {
		return FunzioneAziendale;
	}

	public void setFunzioneAziendale(String funzioneAziendale) {
		FunzioneAziendale = funzioneAziendale;
	}

	public String getMail() {
		return Mail;
	}

	public void setMail(String mail) {
		Mail = mail;
	}

	public String getMatricola() {
		return Matricola;
	}

	public void setMatricola(String matricola) {
		Matricola = matricola;
	}

	public String getUid() {
		return Uid;
	}

	public void setUid(String uid) {
		Uid = uid;
	}

	public String getUSerAlias() {
		return UserAlias;
	}

	public void setUSerAlias(String uSerAlias) {
		UserAlias = uSerAlias;
	}

	public String getCodOloAgcom() {
		return CodOloAgcom;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		CodOloAgcom = codOloAgcom;
	}

	public String toString(){
		return Uid;
		
	}
	
}
