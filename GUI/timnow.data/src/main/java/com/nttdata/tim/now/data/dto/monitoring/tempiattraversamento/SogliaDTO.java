package com.nttdata.tim.now.data.dto.monitoring.tempiattraversamento;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class SogliaDTO implements Serializable {

	private static final long serialVersionUID = -8457889203516494599L;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("valore")
	private String valore;

	@JsonProperty("contatore")
	private String contatore;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValore() {
		return valore;
	}

	public void setValore(String valore) {
		this.valore = valore;
	}

	public String getContatore() {
		return contatore;
	}

	public void setContatore(String contatore) {
		this.contatore = contatore;
	}

	@Override
	public String toString() {
		return "SogliaDTO [nome=" + nome + ", valore=" + valore + ", contatore=" + contatore + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contatore == null) ? 0 : contatore.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((valore == null) ? 0 : valore.hashCode());
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
		SogliaDTO other = (SogliaDTO) obj;
		if (contatore == null) {
			if (other.contatore != null)
				return false;
		} else if (!contatore.equals(other.contatore))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (valore == null) {
			if (other.valore != null)
				return false;
		} else if (!valore.equals(other.valore))
			return false;
		return true;
	}

}
