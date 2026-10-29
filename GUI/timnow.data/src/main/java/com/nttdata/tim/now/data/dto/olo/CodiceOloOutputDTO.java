package com.nttdata.tim.now.data.dto.olo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class CodiceOloOutputDTO implements Serializable {

	private static final long serialVersionUID = -4808790844275040773L;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("operatore")
	private String operatore;

	@JsonProperty("codOloAgcom")
	private String codOloAgcom;

	@JsonProperty("flagAccorpante")
	private boolean flagAccorpante;

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

	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}

	public boolean isFlagAccorpante() {
		return flagAccorpante;
	}

	public void setFlagAccorpante(boolean flagAccorpante) {
		this.flagAccorpante = flagAccorpante;
	}

	@Override
	public String toString() {
		return "ProfiloOloDTO [nome=" + nome + ", operatore=" + operatore + ", codOloAgcom=" + codOloAgcom
				+ ", flagAccorpante=" + flagAccorpante + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codOloAgcom == null) ? 0 : codOloAgcom.hashCode());
		result = prime * result + (flagAccorpante ? 1231 : 1237);
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((operatore == null) ? 0 : operatore.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CodiceOloOutputDTO other = (CodiceOloOutputDTO) obj;
		if (codOloAgcom == null) {
			if (other.codOloAgcom != null)
				return false;
		} else if (!codOloAgcom.equals(other.codOloAgcom))
			return false;
		if (flagAccorpante != other.flagAccorpante)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (operatore == null) {
			if (other.operatore != null)
				return false;
		} else if (!operatore.equals(other.operatore))
			return false;
		return true;
	}

}
