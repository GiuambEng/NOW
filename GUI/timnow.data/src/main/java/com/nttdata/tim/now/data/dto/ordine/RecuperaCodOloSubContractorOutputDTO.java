package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecuperaCodOloSubContractorOutputDTO implements Serializable {

	private static final long serialVersionUID = -3570740353551655596L;

	@JsonProperty("codOloAgcom")
    private String codOloAgcom;

    @JsonProperty("codOloNumerico")
    private String codOloNumerico;
    
    //SM_9791
    @JsonProperty("codOloAgcomTitolare")
    private String codOloAgcomTitolare;

	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}

	public String getCodOloNumerico() {
		return codOloNumerico;
	}

	public void setCodOloNumerico(String codOloNumerico) {
		this.codOloNumerico = codOloNumerico;
	}

	public String getCodOloAgcomTitolare() {
		return codOloAgcomTitolare;
	}

	public void setCodOloAgcomTitolare(String codOloAgcomTitolare) {
		this.codOloAgcomTitolare = codOloAgcomTitolare;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codOloAgcom == null) ? 0 : codOloAgcom.hashCode());
		result = prime * result + ((codOloAgcomTitolare == null) ? 0 : codOloAgcomTitolare.hashCode());
		result = prime * result + ((codOloNumerico == null) ? 0 : codOloNumerico.hashCode());
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
		RecuperaCodOloSubContractorOutputDTO other = (RecuperaCodOloSubContractorOutputDTO) obj;
		if (codOloAgcom == null) {
			if (other.codOloAgcom != null)
				return false;
		} else if (!codOloAgcom.equals(other.codOloAgcom))
			return false;
		if (codOloAgcomTitolare == null) {
			if (other.codOloAgcomTitolare != null)
				return false;
		} else if (!codOloAgcomTitolare.equals(other.codOloAgcomTitolare))
			return false;
		if (codOloNumerico == null) {
			if (other.codOloNumerico != null)
				return false;
		} else if (!codOloNumerico.equals(other.codOloNumerico))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperaCodOloSubContractorOutputDTO [codOloAgcom=" + codOloAgcom + ", codOloNumerico=" + codOloNumerico
				+ ", codOloAgcomTitolare=" + codOloAgcomTitolare + "]";
	}

}
