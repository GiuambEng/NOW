package com.nttdata.tim.now.data.dto.anagraficaolo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class AnagraficaOloOutputDTO implements Serializable {

	private static final long serialVersionUID = 8866639902048262419L;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("operatore")
	private String operatore;

	@JsonProperty("codiceAgcom")
	private String codiceAgcom;

	@JsonProperty("flagAccorpante")
	private String flagAccorpante;
	
	//RU_1180
	@JsonProperty("codiceAgcomNumerico")
	private String codiceAgcomNumerico;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getOperatore() {
		return operatore;
	}

	public void setOperatore(String operatore) {
		this.operatore = operatore;
	}

	public String getCodiceAgcom() {
		return codiceAgcom;
	}

	public void setCodiceAgcom(String codiceAgcom) {
		this.codiceAgcom = codiceAgcom;
	}

	public String getFlagAccorpante() {
		return flagAccorpante;
	}

	public void setFlagAccorpante(String flagAccorpante) {
		this.flagAccorpante = flagAccorpante;
	}

	public String getCodiceAgcomNumerico() {
		return codiceAgcomNumerico;
	}

	public void setCodiceAgcomNumerico(String codiceAgcomNumerico) {
		this.codiceAgcomNumerico = codiceAgcomNumerico;
	}

}
