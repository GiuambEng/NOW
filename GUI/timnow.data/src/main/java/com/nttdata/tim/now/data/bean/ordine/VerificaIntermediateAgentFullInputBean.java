package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.lan.SVlanCVlanInputBean;

@JsonInclude(Include.NON_NULL)
public class VerificaIntermediateAgentFullInputBean implements Serializable {

	private static final long serialVersionUID = -4396701849011102372L;

	@JsonProperty("idOfferta")
	private String idOfferta;
	
	@JsonProperty("lavorazione")
    private String lavorazione;
	
	@JsonProperty("idAsset")
    private String idAsset;
	
	@JsonProperty("intermediateAgentFull")
	private String intermediateAgentFull;
	
	@JsonProperty("encapsulation")
	private String encapsulation;
	
	@JsonProperty("svlanCodes")
	private List<SVlanCVlanInputBean> svlanCodes;
	
	@JsonProperty("cvlanCodes")
	private List<SVlanCVlanInputBean> cvlanCodes;

	public String getIdOfferta() {
		return idOfferta;
	}

	public void setIdOfferta(String idOfferta) {
		this.idOfferta = idOfferta;
	}

	public String getLavorazione() {
		return lavorazione;
	}

	public void setLavorazione(String lavorazione) {
		this.lavorazione = lavorazione;
	}

	public String getIdAsset() {
		return idAsset;
	}

	public void setIdAsset(String idAsset) {
		this.idAsset = idAsset;
	}

	public String getIntermediateAgentFull() {
		return intermediateAgentFull;
	}

	public void setIntermediateAgentFull(String intermediateAgentFull) {
		this.intermediateAgentFull = intermediateAgentFull;
	}

	public String getEncapsulation() {
		return encapsulation;
	}

	public void setEncapsulation(String encapsulation) {
		this.encapsulation = encapsulation;
	}

	public List<SVlanCVlanInputBean> getSvlanCodes() {
		return svlanCodes;
	}

	public void setSvlanCodes(List<SVlanCVlanInputBean> svlanCodes) {
		this.svlanCodes = svlanCodes;
	}

	public List<SVlanCVlanInputBean> getCvlanCodes() {
		return cvlanCodes;
	}

	public void setCvlanCodes(List<SVlanCVlanInputBean> cvlanCodes) {
		this.cvlanCodes = cvlanCodes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cvlanCodes == null) ? 0 : cvlanCodes.hashCode());
		result = prime * result + ((encapsulation == null) ? 0 : encapsulation.hashCode());
		result = prime * result + ((idAsset == null) ? 0 : idAsset.hashCode());
		result = prime * result + ((idOfferta == null) ? 0 : idOfferta.hashCode());
		result = prime * result + ((intermediateAgentFull == null) ? 0 : intermediateAgentFull.hashCode());
		result = prime * result + ((lavorazione == null) ? 0 : lavorazione.hashCode());
		result = prime * result + ((svlanCodes == null) ? 0 : svlanCodes.hashCode());
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
		VerificaIntermediateAgentFullInputBean other = (VerificaIntermediateAgentFullInputBean) obj;
		if (cvlanCodes == null) {
			if (other.cvlanCodes != null)
				return false;
		} else if (!cvlanCodes.equals(other.cvlanCodes))
			return false;
		if (encapsulation == null) {
			if (other.encapsulation != null)
				return false;
		} else if (!encapsulation.equals(other.encapsulation))
			return false;
		if (idAsset == null) {
			if (other.idAsset != null)
				return false;
		} else if (!idAsset.equals(other.idAsset))
			return false;
		if (idOfferta == null) {
			if (other.idOfferta != null)
				return false;
		} else if (!idOfferta.equals(other.idOfferta))
			return false;
		if (intermediateAgentFull == null) {
			if (other.intermediateAgentFull != null)
				return false;
		} else if (!intermediateAgentFull.equals(other.intermediateAgentFull))
			return false;
		if (lavorazione == null) {
			if (other.lavorazione != null)
				return false;
		} else if (!lavorazione.equals(other.lavorazione))
			return false;
		if (svlanCodes == null) {
			if (other.svlanCodes != null)
				return false;
		} else if (!svlanCodes.equals(other.svlanCodes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaIntermediateAgentFullInputBean [idOfferta=" + idOfferta + ", lavorazione=" + lavorazione
				+ ", idAsset=" + idAsset + ", intermediateAgentFull=" + intermediateAgentFull + ", encapsulation="
				+ encapsulation + ", svlancodes=" + svlanCodes + ", cvlancodes=" + cvlanCodes + "]";
	}

	

}
