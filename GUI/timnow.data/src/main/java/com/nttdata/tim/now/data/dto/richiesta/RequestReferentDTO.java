package com.nttdata.tim.now.data.dto.richiesta;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class RequestReferentDTO implements Serializable {

	private static final long serialVersionUID = -1309746486352846439L;

	@JsonProperty("Nome")
	private String nome;

	@JsonProperty("Cognome")
	private String cognome;

	@JsonProperty("TelefonoFissoReferente")
	private String telefonoFisso;

	@JsonProperty("CellulareReferente")
	private String cellulare;

	@JsonProperty("Qualifica")
	private String qualifica;
	
	//SM_10519
	@JsonProperty("Email")
	private String email;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTelefonoFisso() {
		return telefonoFisso;
	}

	public void setTelefonoFisso(String telefonoFisso) {
		this.telefonoFisso = telefonoFisso;
	}

	public String getCellulare() {
		return cellulare;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}

	public String getQualifica() {
		return qualifica;
	}

	public void setQualifica(String qualifica) {
		this.qualifica = qualifica;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
