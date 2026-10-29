package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1058
@JsonInclude(Include.NON_NULL)
public class RecuperaSubContractorOutputBean implements Serializable {

	private static final long serialVersionUID = 3666153095031958809L;

	@JsonProperty("codOloAgcom")
    private String codOloAgcom;

    @JsonProperty("codiceOloNumerico")
    private String codiceOloNumerico;

    @JsonProperty("codOloAgcomTitolare")
    private String codOloAgcomTitolare;

	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}

	public String getCodiceOloNumerico() {
		return codiceOloNumerico;
	}

	public void setCodiceOloNumerico(String codiceOloNumerico) {
		this.codiceOloNumerico = codiceOloNumerico;
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
		result = prime * result + ((codiceOloNumerico == null) ? 0 : codiceOloNumerico.hashCode());
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
		RecuperaSubContractorOutputBean other = (RecuperaSubContractorOutputBean) obj;
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
		if (codiceOloNumerico == null) {
			if (other.codiceOloNumerico != null)
				return false;
		} else if (!codiceOloNumerico.equals(other.codiceOloNumerico))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperaSubContractorOutputBean [codOloAgcom=" + codOloAgcom + ", codiceOloNumerico=" + codiceOloNumerico
				+ ", codOloAgcomTitolare=" + codOloAgcomTitolare + "]";
	}
	


}