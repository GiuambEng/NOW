package com.nttdata.tim.now.data.bean.ricerca;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class RicercaCampiOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = 1142319389795164858L;

    @JsonProperty("nomeDB")
	private String nomeDB;

	@JsonProperty("tipoDato")
	private String tipoDato;

	@JsonProperty("label")
	private String label;

	@JsonProperty("defaultValue")
	private ArrayList<String> defaultValue;

	public String getNomeDB() {
		return nomeDB;
	}

	public void setNomeDB(String nomeDB) {
		this.nomeDB = nomeDB;
	}

	public String getTipoDato() {
		return tipoDato;
	}

	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public ArrayList<String> getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(ArrayList<String> defaultValue) {
		this.defaultValue = defaultValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((defaultValue == null) ? 0 : defaultValue.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((nomeDB == null) ? 0 : nomeDB.hashCode());
		result = prime * result + ((tipoDato == null) ? 0 : tipoDato.hashCode());
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
		RicercaCampiOutputBean other = (RicercaCampiOutputBean) obj;
		if (defaultValue == null) {
			if (other.defaultValue != null)
				return false;
		} else if (!defaultValue.equals(other.defaultValue))
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (nomeDB == null) {
			if (other.nomeDB != null)
				return false;
		} else if (!nomeDB.equals(other.nomeDB))
			return false;
		if (tipoDato == null) {
			if (other.tipoDato != null)
				return false;
		} else if (!tipoDato.equals(other.tipoDato))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RicercaCampiOutputBean [nomeDB=" + nomeDB + ", tipoDato=" + tipoDato + ", label=" + label
				+ ", defaultValue=" + defaultValue + "]";
	}
	
}