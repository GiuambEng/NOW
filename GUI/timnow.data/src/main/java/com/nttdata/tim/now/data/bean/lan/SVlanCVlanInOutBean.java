package com.nttdata.tim.now.data.bean.lan;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class SVlanCVlanInOutBean implements Serializable {

    private static final long serialVersionUID = -2231225518998528298L;

    @JsonProperty("SVLanCode")
	private String SVLanCode;

    @JsonProperty("CVLanId")
    private String CVLanId;

    @JsonProperty("azione")
    private String azione;
    
    @JsonProperty("esito")
    private String esito;

    @JsonProperty("message")
    private String message;

	public String getSVLanCode() {
		return SVLanCode;
	}

	public void setSVLanCode(String sVLanCode) {
		SVLanCode = sVLanCode;
	}

	public String getCVLanId() {
		return CVLanId;
	}

	public void setCVLanId(String cVLanId) {
		CVLanId = cVLanId;
	}

	public String getAzione() {
		return azione;
	}

	public void setAzione(String azione) {
		this.azione = azione;
	}

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CVLanId == null) ? 0 : CVLanId.hashCode());
		result = prime * result + ((SVLanCode == null) ? 0 : SVLanCode.hashCode());
		result = prime * result + ((azione == null) ? 0 : azione.hashCode());
		result = prime * result + ((esito == null) ? 0 : esito.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
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
		SVlanCVlanInOutBean other = (SVlanCVlanInOutBean) obj;
		if (CVLanId == null) {
			if (other.CVLanId != null)
				return false;
		} else if (!CVLanId.equals(other.CVLanId))
			return false;
		if (SVLanCode == null) {
			if (other.SVLanCode != null)
				return false;
		} else if (!SVLanCode.equals(other.SVLanCode))
			return false;
		if (azione == null) {
			if (other.azione != null)
				return false;
		} else if (!azione.equals(other.azione))
			return false;
		if (esito == null) {
			if (other.esito != null)
				return false;
		} else if (!esito.equals(other.esito))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SVlanCVlanInOutBean [SVLanCode=" + SVLanCode + ", CVLanId=" + CVLanId + ", azione=" + azione
				+ ", esito=" + esito + ", message=" + message + "]";
	}



}